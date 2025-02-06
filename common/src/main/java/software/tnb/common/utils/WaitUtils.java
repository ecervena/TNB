package software.tnb.common.utils;

import software.tnb.common.config.TestConfiguration;
import software.tnb.common.exception.FailureCauseException;
import software.tnb.common.exception.FailureConditionMetException;
import software.tnb.common.exception.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public final class WaitUtils {
    private static final Logger LOG = LoggerFactory.getLogger(WaitUtils.class);
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(1);

    private WaitUtils() {
    }

    /**
     * Sleeps for a given time.
     *
     * @param timeout timeout
     */
    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * Waits until the check return true.
     *
     * @param check booleansupplier instance
     * @param logMessage log message that will be printed out before waiting
     * @throws TimeoutException when the check isn't true after the time expires
     */
    public static void waitFor(BooleanSupplier check, String logMessage) throws TimeoutException {
        waitFor(check, 24, 5000L, logMessage);
    }

    /**
     * Waits until the check return true.
     *
     * @param resourceCheck success condition
     * @param retries number of retries
     * @param waitTime wait time between the retries
     * @param logMessage log message that will be printed out before waiting
     * @throws TimeoutException when the check isn't true after the time expires
     */
    public static void waitFor(BooleanSupplier resourceCheck, int retries, long waitTime, String logMessage) throws TimeoutException {
        LOG.info(logMessage);
        boolean state;
        do {
            state = resourceCheck.getAsBoolean();

            if (!state) {
                LOG.debug("Condition not met yet, sleeping for {}", waitTime);
                retries--;
                sleep(waitTime);
            }
        } while (!state && retries > 0);

        if (!state) {
            throw new TimeoutException("Timeout exceeded");
        }
        LOG.debug("Done waiting");
    }

    public static void waitFor(BooleanSupplier check, BooleanSupplier fail, long timeout, String logMessage) throws FailureConditionMetException {
        waitFor(check, fail, timeout, logMessage, null);
    }

    /**
     * Waits until the check or fail condition return true.
     * <p>
     * If a wait duration specified by {@link TestConfiguration#testWaitKillTimeout()} is reached, the wait is killed to prevent infinite waiting
     *
     * @param check booleansupplier instance
     * @param fail booleansupplier instance
     * @param timeout wait time between the retries
     * @param logMessage log message that will be printed out before waiting
     * @throws FailureConditionMetException when the fail condition is true
     */
    public static void waitFor(BooleanSupplier check, BooleanSupplier fail, long timeout, String logMessage,
        Supplier<FailureCauseException> failureCause) throws FailureConditionMetException {
        LOG.info(logMessage);
        Instant start = Instant.now();
        while (true) {
            if (check.getAsBoolean()) {
                break;
            } else if (fail.getAsBoolean()) {
                String exceptionMessage = "Specified fail condition met";
                if (failureCause != null) {
                    FailureCauseException e = failureCause.get();
                    throw new FailureConditionMetException(e.getDescription() != null ? e.getDescription() : exceptionMessage, e);
                } else {
                    throw new FailureConditionMetException(exceptionMessage);
                }
            } else if (Duration.between(start, Instant.now()).compareTo(TestConfiguration.testWaitKillTimeout()) > 0) {
                LOG.error("Wait killed after {} minutes", TestConfiguration.testWaitKillTimeout().toMinutes());
                break;
            } else {
                LOG.debug("Condition not met yet, sleeping for {}", timeout);
                sleep(timeout);
            }
        }
        LOG.debug("Done waiting");
    }

    /**
     * Runs the given callable and aborts its execution if it takes too long.
     *
     * @param callable callable to run
     * @param <T> return type
     * @return callable result or TimeoutException
     */
    public static <T> T withTimeout(Callable<T> callable) {
        return withTimeout(callable, TestConfiguration.testWaitTime());
    }

    /**
     * Runs the given callable and aborts its execution if it takes too long.
     *
     * @param callable callable to run
     * @param waitTime wait time
     * @param <T> return type
     * @return callable result or TimeoutException
     */
    public static <T> T withTimeout(Callable<T> callable, Duration waitTime) {
        Instant end = Instant.now().plus(waitTime);
        final Future<T> future = EXECUTOR_SERVICE.submit(callable);
        while (Instant.now().isBefore(end) && !future.isDone()) {
            sleep(100L);
        }
        if (!future.isDone()) {
            future.cancel(true);
            throw new TimeoutException("Timeout exceeded");
        } else {
            try {
                return future.get();
            } catch (Exception e) {
                throw new RuntimeException("Unable to get callable result: ", e);
            }
        }
    }
}
