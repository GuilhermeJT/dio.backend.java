package org.example;

import org.example.persistence.ConnectionUtil;
import org.example.persistence.EmployeeDAO;
import org.flywaydb.core.Flyway;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private final static EmployeeDAO dao = new EmployeeDAO();
    public static void main(String[] args) {

            var flyway = Flyway.configure()
                    .dataSource("jdbc:mysql://localhost/dio", "root", "1234")
                    .locations("classpath:db.migration")
                    .load();
            flyway.migrate();


    }
}