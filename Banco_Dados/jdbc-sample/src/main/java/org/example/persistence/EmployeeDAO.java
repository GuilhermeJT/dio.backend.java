package org.example.persistence;

import com.mysql.cj.jdbc.StatementImpl;
import org.example.persistence.entity.EmployeeEntity;

import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class EmployeeDAO {

    public void insert(final EmployeeEntity entity) {
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement();
        ){
            var sql = "INSERT INTO employees (name, salary, birthday) VALUES ( '"+entity.getName()+"', " +
                    "'"+entity.getSalary().toString()+"', " +
                    "'"+formaOffsetData(entity.getBirthday()) +"')";
            statement.executeUpdate(sql);

            statement.getUpdateCount();

            if(statement instanceof StatementImpl ipml)
                entity.setId(ipml.getLastInsertID());

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void update(final EmployeeEntity entity) {
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement();
        ){
            var sql = "UPDATE employees SET " +   // espaço depois de SET
                    "name = '" + entity.getName() + "', " +
                    "salary = " + entity.getSalary() + ", " +
                    "birthday = '" + formaOffsetData(entity.getBirthday()) + "' " +
                    "WHERE id = " + entity.getId();

            statement.executeUpdate(sql);


            statement.getUpdateCount();

            if(statement instanceof StatementImpl ipml)
                entity.setId(ipml.getLastInsertID());

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void delete(final long id) {
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement();
        ){
            var sql = "DELETE FROM employees WHERE id = " + id;
            statement.executeUpdate(sql);

            statement.getUpdateCount();


        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> entities = new ArrayList<>();
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement();
        ){

            statement.executeQuery("SELECT * FROM employees");
            var results = statement.getResultSet();
            while(results.next()){
                var entity = new  EmployeeEntity();

                entity.setId(results.getLong("id"));
                entity.setName(results.getString("name"));
                entity.setSalary(results.getBigDecimal("salary"));
                var birthdayInstant = results.getTimestamp("birthday").toInstant();
                var birthday = OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC);
                entity.setBirthday(birthday);
                entities.add(entity);

            }



        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return entities;
    }

    public EmployeeEntity findById(final Integer id) {
        var entity = new  EmployeeEntity();

        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement();
        ){

            statement.executeQuery("SELECT * FROM employees WHERE id = '"+id+"'");
            var results = statement.getResultSet();

            if(results.next()){
                entity.setId(results.getLong("id"));
                entity.setName(results.getString("name"));
                entity.setSalary(results.getBigDecimal("salary"));
                var birthdayInstant = results.getTimestamp("birthday").toInstant();
                var birthday = OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC);
                entity.setBirthday(birthday);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return entity;
    }

    private String formaOffsetData(final OffsetDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
