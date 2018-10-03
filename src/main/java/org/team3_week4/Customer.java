package org.team3_week4;

import lombok.Data;

@Data
public class Customer {

    private int money;
    private String id;
    private String password;
    private boolean accessNow;

    Customer(String id, String password) {
        this.id = id;
        this.password = password;
        accessNow = false;
    }

    Customer() {}

}
