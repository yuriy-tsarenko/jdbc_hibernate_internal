package com.jdbc_hibernate_internal.lesson1.demo_insert;


import com.jdbc_hibernate_internal.lesson1.ex003_result_set.Customer;
import com.jdbc_hibernate_internal.lesson1.ex003_result_set.DataBaseConnector;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        DataBaseConnector dataBaseConnector = new DataBaseConnector();
        dataBaseConnector.createClient(12, "JOHN", "TEST", "Carine",
                "40.32.2555", "54, rue Royale", "NULL", "Nantes", "NULL",
                "44000", "France", 1370, new BigDecimal("21000.00"));
        Customer found = dataBaseConnector.getAllClients().parallelStream()
                .filter(client -> client.getCustomerNumber() == 12)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("customer not found"));
        System.out.println(found);

    }
}
