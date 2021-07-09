package com.jdbc_hibernate_internal.lesson2.simple_dao;

import com.jdbc_hibernate_internal.lesson2.simple_dao.dao.CarDao;
import com.jdbc_hibernate_internal.lesson2.simple_dao.dao.DaoFactory;
import com.jdbc_hibernate_internal.lesson2.simple_dao.dao.IdaoFactory;

public class Main {

    public static void main(String[] args) {
        IdaoFactory factory = DaoFactory.getInstance();
        CarDao carDao = factory.getCarDao();

        carDao.remove("Chevrolet");

//        System.out.println(car.getId() + " " + car.getMark()
//                    + " " + car.getModel() + " " + car.getPrice());


    }

}
