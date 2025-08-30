package org.example;

import org.example.persistence.ConnectionUtil;
import org.example.persistence.EmployeeDAO;
import org.example.persistence.entity.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.OffsetDateTime;

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


//
//
//            EmployeeEntity entity = new EmployeeEntity();
//
//
//            entity.setName("Joao");
//            entity.setSalary(new BigDecimal("2500"));
//            entity.setBirthday(OffsetDateTime.now().minusYears(20));
//
//
//
//            dao.insert(entity);
//
//            dao.findAll().forEach(System.out::println);
//
//            System.out.println(dao.findById(1));
//
//
//            var entity= new EmployeeEntity();
//            entity.setId(1);
//            entity.setName("Guilherme José");
//            entity.setSalary(new BigDecimal(2000));
//            entity.setBirthday(OffsetDateTime.now().minusYears(23));
//
//            dao.update(entity);

            dao.delete(2);

    }
}