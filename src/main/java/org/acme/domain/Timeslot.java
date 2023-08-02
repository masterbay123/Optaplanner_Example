package org.acme.domain;

import java.time.Month;

//import io.quarkus.hibernate.orm.panache.PanacheEntity;
//import javax.persistence.Entity;


public class Timeslot {

    public Month month;

    public Timeslot() {

    }

    public Timeslot(Month month) {
        this.month = month;        
    }

    public int getMonth() {
        return month.getValue();
    }
    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return month + " ";
    }
}