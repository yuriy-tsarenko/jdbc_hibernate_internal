package com.jdbc_hibernate_internal.homework.lesson2.repository;

import com.jdbc_hibernate_internal.homework.lesson2.db_connector.DataBaseConnector;
import com.jdbc_hibernate_internal.homework.lesson2.entity.EmployeeEntity;
import com.jdbc_hibernate_internal.homework.lesson2.util.PrimaryKey;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import static com.jdbc_hibernate_internal.homework.lesson2.util.Constants.CHAR;


public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final Logger log = Logger.getLogger(EmployeeRepositoryImpl.class);

    @Override
    public void createClient(EmployeeEntity employeeEntity) {
        try {
            DataBaseConnector.createConnection()
                    .execute("insert into"
                            + " employee_db.employees(employeeNumber, lastName, firstName, extension, email," +
                            " officeCode, reportsTo, jobTitle)"
                            + " values ("
                            + CHAR + employeeEntity.getEmployeeNumber() + CHAR + ","
                            + CHAR + employeeEntity.getLastName() + CHAR + ","
                            + CHAR + employeeEntity.getFirstName() + CHAR + ","
                            + CHAR + employeeEntity.getExtension() + CHAR + ","
                            + CHAR + employeeEntity.getEmail() + CHAR + ","
                            + CHAR + employeeEntity.getOfficeCode() + CHAR + ","
                            + CHAR + employeeEntity.getReportsTo() + CHAR + ","
                            + CHAR + employeeEntity.getJobTitle() + CHAR
                            + ");");
            DataBaseConnector.closeConnection();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public int updateClient(Map<String, Object> args, Integer employeeEntity) {
        PrimaryKey<Integer> primaryKey = new PrimaryKey<>();
        primaryKey.setKey("employeeNumber");
        primaryKey.setValue(employeeEntity);
        Statement connection;
        int update = 0;
        try {
            connection = DataBaseConnector.createConnection();
            update = connection.executeUpdate(queryBuilderUpdate(args, primaryKey, "employees"));
            DataBaseConnector.closeConnection();
        } catch (Exception e) {
            log.error(e);
        }
        return update;
    }

    @Override
    public List<EmployeeEntity> getAllClients() {
        return getAllEntities("SELECT * FROM employees", EmployeeEntity.class);
    }

    @Override
    public EmployeeEntity getClient(Integer employeeNumber) {
        return getAllEntities("SELECT * FROM employees WHERE employeeNumber="
                        + CHAR + employeeNumber + CHAR + ";",
                EmployeeEntity.class).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("client not found"));
    }
}
