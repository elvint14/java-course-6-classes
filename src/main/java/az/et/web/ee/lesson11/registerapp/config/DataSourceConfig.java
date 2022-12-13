package az.et.web.ee.lesson11.registerapp.config;

import java.sql.Connection;

public interface DataSourceConfig {

    Connection getConnection();

}
