package az.et.web.db.lesson09.registerapp.config;

import java.sql.Connection;

public interface DataSourceConfig {

    Connection getConnection();

}
