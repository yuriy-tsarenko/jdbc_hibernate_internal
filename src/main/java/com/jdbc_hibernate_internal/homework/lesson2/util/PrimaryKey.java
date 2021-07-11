package com.jdbc_hibernate_internal.homework.lesson2.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimaryKey<T> {

    private String key;
    private T value;
}
