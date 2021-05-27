package org.jboss.fuse.tnb.common.utils;

import org.jboss.fuse.tnb.common.config.TestConfiguration;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;

public final class IOUtils {
    private static final Logger LOG = LoggerFactory.getLogger(IOUtils.class);

    private IOUtils() {
    }

    public static void writeFile(Path file, String content) {
        try {
            Files.write(file, content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to " + file, e);
        }
    }

    public static String readFile(Path file) {
        try {
            return Files.readString(file);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file " + file, e);
        }
    }

    /**
     * Creates a new tar file from given directory.
     *
     * @param f path to the directory or file
     * @return path to the tar file
     */
    public static Path createTar(Path f) {
        Path output;
        try {
            output = Files.createTempFile(TestConfiguration.appLocation(), "tar", ".tar");
        } catch (IOException e) {
            throw new RuntimeException("Unable to create temp file: ", e);
        }
        try (TarArchiveOutputStream archive = new TarArchiveOutputStream(Files.newOutputStream(output))) {
            archive.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
            if (!f.toFile().isDirectory()) {
                addTarEntry(archive, f, f.getFileName().toString());
            } else {
                Files.walkFileTree(f, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
                        if (attributes.isSymbolicLink()) {
                            return FileVisitResult.CONTINUE;
                        }
                        Path targetFile = f.relativize(file);
                        addTarEntry(archive, f, targetFile.toString());

                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        return FileVisitResult.CONTINUE;
                    }
                });
            }

            archive.finish();
        } catch (IOException e) {
            throw new RuntimeException("Unable to create tar file: ", e);
        }
        return output;
    }

    private static void addTarEntry(TarArchiveOutputStream taos, Path file, String fileName) {
        try {
            TarArchiveEntry tarEntry = new TarArchiveEntry(file.toFile(), fileName);
            taos.putArchiveEntry(tarEntry);
            Files.copy(file, taos);
            taos.closeArchiveEntry();
        } catch (IOException e) {
            throw new RuntimeException("Unable to create tar entry: ", e);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        org.apache.commons.io.IOUtils.closeQuietly(closeable, e -> LOG.warn("Could not close resource", e));
    }

    public static void createDirectory(File f) {
        if (!f.exists()) {
            if (!f.mkdirs()) {
                LOG.debug("Creating new directory {}", f.getAbsolutePath());
                throw new RuntimeException("Unable to create directory " + f.getAbsolutePath());
            }
        }
    }

    public static void createDirectory(Path p) {
        createDirectory(p.toFile());
    }

    public static void copyDirectory(Path from, Path to) {
        try {
            LOG.debug("Copying directory {} to {}", from.toAbsolutePath(), to.toAbsolutePath());
            FileUtils.copyDirectory(from.toFile(), to.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Unable to copy directories: ", e);
        }
    }

    public static void replaceVariables(Path input, Properties keysValues, Path output) {
        String withVars = readFile(input);
        //can't use lambda because withVars would have to be effectively final
        for (Object key : keysValues.keySet()) {
            withVars = withVars.replaceAll(TestConfiguration.VARIABLE_PLACEHOLDER_START + key + TestConfiguration.VARIABLE_PLACEHOLDER_END,
                keysValues.getProperty(key.toString()));
        }
        writeFile(output, withVars);
    }
}