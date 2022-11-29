package az.et.web.db.lesson08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcExampleApp {
    public static void main(String[] args) {

        // 1. add driver to project (pom.xml)
        // 2. create connection
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "postgres"
            );
            String insertCountry = "INSERT INTO countries(name) values('PLN');";
            PreparedStatement insertStmnt = connection.prepareStatement(insertCountry);
            int i = insertStmnt.executeUpdate();
            System.out.println("Rows added:" + i);

            String getAllCountriesSql = "SELECT * FROM countries;";
            PreparedStatement ps = connection.prepareStatement(getAllCountriesSql);
            ResultSet rs1 = ps.executeQuery();

            while (rs1.next()) {
                int countryId = rs1.getInt("id");
                String countryName = rs1.getString("name");
                System.out.println("countryId:" + countryId + ", countryName:" + countryName);
            }
            System.out.println("=============");

            String deleteCountryById = "DELETE from countries where id = 1 and name = ?;";
            PreparedStatement del = connection.prepareStatement(deleteCountryById);
            del.setInt(1, 2);
            int delCount = del.executeUpdate();
            System.out.println("Rows added:" + delCount);


            String getAllCountriesSql2 = "SELECT * FROM countries;";
            PreparedStatement ps2 = connection.prepareStatement(getAllCountriesSql2);
            ResultSet rs = ps2.executeQuery();

            while (rs.next()) {
                int countryId = rs.getInt("id");
                String countryName = rs.getString("name");
                System.out.println("countryId:" + countryId + ", countryName:" + countryName);
            }

            ps.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
