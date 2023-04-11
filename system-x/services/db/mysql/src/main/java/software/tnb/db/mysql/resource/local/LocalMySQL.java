package software.tnb.db.mysql.resource.local;

import software.tnb.common.deployment.Deployable;
import software.tnb.db.common.local.LocalDB;
import software.tnb.db.mysql.service.MySQL;

import org.testcontainers.containers.wait.strategy.Wait;

import com.google.auto.service.AutoService;

@AutoService(MySQL.class)
public class LocalMySQL extends MySQL implements Deployable {
    private final LocalDB localDb = new LocalDB(this, PORT, Wait.forLogMessage(".*ready for connections.* port: " + PORT + ".*", 1));

    @Override
    public String jdbcConnectionUrl() {
        return String.format("jdbc:mysql://localhost:%d/%s", localDb.getPort(), account().database());
    }

    @Override
    public String hostname() {
        return "localhost";
    }

    @Override
    public int port() {
        return localDb.getPort();
    }

    @Override
    public void deploy() {
        localDb.deploy();
    }

    @Override
    public void undeploy() {
        localDb.undeploy();
    }

    @Override
    public void openResources() {
        localDb.openResources();
    }

    @Override
    public void closeResources() {
        localDb.closeResources();
        validation = null;
    }

    @Override
    public String name() {
        return "MySQL";
    }
}
