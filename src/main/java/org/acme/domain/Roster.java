package org.acme.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

@PlanningSolution
public class Roster {

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "TimeslotRange")
    private List<Timeslot> timeslotList;
    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "LocationRange")
    private List<Location> locationList;
    @PlanningEntityCollectionProperty
    private List<Shift> shiftList;

    @PlanningScore
    private HardSoftScore score;

    private SolverStatus solverStatus;

    public Roster() {

    }
    public Roster(List<Timeslot> timeslotList,List<Location> locationList,List<Shift> shiftList) {
        this.timeslotList = timeslotList;
        this.locationList = locationList;
        this.shiftList = shiftList;
        
    }
    public List<Timeslot> getTimeslotList() {
        return timeslotList;
    }
    public List<Location> getLocationList() {
        return locationList;
    }
    public List<Shift> getShiftList() {
        return shiftList;
    }
    public HardSoftScore getscore() {
        return score;
    }
    public void setTimeslotList(List<Timeslot> timeslotList) {
        this.timeslotList = timeslotList;
    }
    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }
    public void setShiftList(List<Shift> shiftList) {
        this.shiftList = shiftList;
    }
    public void setscore(HardSoftScore score) {
        this.score = score;
    }
    public SolverStatus getSolverStatus() {
        return solverStatus;
    }
    public void setSolverStatus(SolverStatus solverstatus) {
        this.solverStatus = solverstatus;
    }

}