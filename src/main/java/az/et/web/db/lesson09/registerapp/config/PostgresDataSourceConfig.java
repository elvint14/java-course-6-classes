package az.et.web.db.lesson09.registerapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDataSourceConfig implements DataSourceConfig {

    @Override
    public Connection getConnection() {
        final String dbUrl = System.getenv("db_url");
        final String dbUser = System.getenv("db_user");
        final String dbPassword = System.getenv("db_password");
        System.out.println("url: " + dbUrl + "\npassword: " + dbPassword + "\nuser: " + dbUser);
        try {
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
