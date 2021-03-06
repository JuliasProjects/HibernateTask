package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД

    private static Connection connection;
    private static Util instance;

    public static Connection getConnection() {
        return connection;
    }

    public Util() {
        try {
            if (null == connection || connection.isClosed()) {
                Properties props = getProps();
                connection = DriverManager
                        .getConnection(props.getProperty("db.url"), props.getProperty("db.username"),
                                props.getProperty("db.password"));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;

    }

    private static Properties getProps() throws IOException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(Util.class.getResource("/database.properties").toURI()))) {
            props.load(in);
            return props;
        } catch (IOException | URISyntaxException e) {
            throw new IOException("Database config file not found", e);
        }
    }
}

