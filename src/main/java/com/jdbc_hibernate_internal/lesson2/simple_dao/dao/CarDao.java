package com.jdbc_hibernate_internal.lesson2.simple_dao.dao;

import com.jdbc_hibernate_internal.lesson2.simple_dao.entity.Car;

import java.util.List;

public interface CarDao {

    void add(Car car);

    List<Car> getAll();

    Car getById(int id);

    void updatePrice(int price, int carId);

    void remove(String mark);

}
