package com.jdbc_hibernate_internal.lesson1.lesson1.ex003_result_set;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataBaseConnector worker = new DataBaseConnector();
        List<Customer> clients = worker.getAllClients();
        System.out.printf("db has customers: %d", clients.size());
        clients.forEach(System.out::println);
    }

}
