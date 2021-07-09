package com.jdbc_hibernate_internal.lesson2.simple_dao.dao;

public interface IdaoFactory {

    CarDao getCarDao();

    ClientDAo getClientDao();


}
