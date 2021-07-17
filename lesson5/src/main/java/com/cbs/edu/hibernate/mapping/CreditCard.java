package com.cbs.edu.hibernate.mapping;

import javax.persistence.Embeddable;

@Embeddable
public class CreditCard {
    private String number;
    private String year;
    private String cvv;
}
