package org.acme.rest;

import org.acme.domain.Location;
import org.acme.domain.Roster;
import org.acme.domain.Shift;
import org.acme.domain.Timeslot;
import java.time.Month;
import java.util.ArrayList;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
import java.util.List;

public class RosterStorage {
    public Roster getRoster() {
        List<Timeslot> timeslotList = new ArrayList<>();
            timeslotList.add(new Timeslot(Month.JANUARY));
            timeslotList.add(new Timeslot(Month.FEBRUARY));
            timeslotList.add(new Timeslot(Month.MARCH));
            timeslotList.add(new Timeslot(Month.APRIL));
            timeslotList.add(new Timeslot(Month.MAY));
            timeslotList.add(new Timeslot(Month.JUNE));
            timeslotList.add(new Timeslot(Month.JULY));
            timeslotList.add(new Timeslot(Month.AUGUST));
            timeslotList.add(new Timeslot(Month.SEPTEMBER));
            timeslotList.add(new Timeslot(Month.OCTOBER));
            timeslotList.add(new Timeslot(Month.NOVEMBER));
            timeslotList.add(new Timeslot(Month.DECEMBER));            
        List<Location> locationList = new ArrayList<>();
            locationList.add(new Location(1,"Tai Kwu Ling North"));
            locationList.add(new Location(2,"Wo Kong Shan"));
            locationList.add(new Location(3,"Luk Keng & Wo Hang(along Sha Tau Kok Road"));
            locationList.add(new Location(4,"Luk Keng & Wo Hang"));
            locationList.add(new Location(5,"Man Uk Pin"));
            locationList.add(new Location(6,"San Tin"));
            locationList.add(new Location(7,"Kwu Tung North"));
            locationList.add(new Location(8,"Lung Yeuk Tau"));
            locationList.add(new Location(9,"Lau Fau Shan & Tsim Bei Tsui"));
            locationList.add(new Location(10,"Mai Po & Fairview Park"));
            locationList.add(new Location(11,"Ting Kok"));
            locationList.add(new Location(12,"Nam Sang Wei"));
            locationList.add(new Location(13,"Ha Tsuen Fringe(North)"));
            locationList.add(new Location(14,"Ha Tsuen Fringe(South)"));
            locationList.add(new Location(15,"Sheung Pak Nai & Ha Pak Nai"));
            locationList.add(new Location(16,"Shek Kong"));
            locationList.add(new Location(17,"Ho Chung & Hebe Haven"));
            locationList.add(new Location(18,"Clear Water Bay Peninsula North"));
            locationList.add(new Location(19,"Tai O Fringe"));
        List<Shift> shiftList = new ArrayList<>();
            for (Long i=0L;i<=109L;i++) {
                shiftList.add(new Shift(i,4));
            }

        return new Roster(timeslotList,locationList,shiftList);

    }
}