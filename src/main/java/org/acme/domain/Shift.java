package org.acme.domain;

//import java.sql.Time;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import javax.persistence.ManyToOne;

//import io.quarkus.hibernate.orm.panache.PanacheEntity;
//import javax.persistence.Entity;
//import java.time.Month;


@PlanningEntity
public class Shift {

    
    @PlanningId
    private Long id;
    @PlanningVariable(valueRangeProviderRefs = "TimeslotRange")
    @ManyToOne
    private Timeslot timeslot;

    private int total_flights;

    @PlanningVariable(valueRangeProviderRefs = "LocationRange")
    @ManyToOne
    private Location location;

    public Shift() {

    }
    public Shift(Long id,int total_flights) {
        this.id = id;
        this.total_flights = total_flights;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }
    public Location getLocation() {
        return location;
    }
    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public int gettotal_flights() {
        return total_flights;
    }
    @Override
    public String toString() {
        return id + ": " + timeslot + " " + location; 
    }

}