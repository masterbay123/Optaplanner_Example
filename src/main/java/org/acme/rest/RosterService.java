package org.acme.rest;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
//import java.util.ArrayList;
//import java.time.Month;
//import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;


//import org.acme.domain.Timeslot;
//import org.acme.domain.Location;
//import org.acme.domain.Shift;
import org.acme.domain.Roster;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
//import org.optaplanner.core.api.solver.SolverStatus;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
//import org.acme.rest.RosterStorage;



@Path("roster")
public class RosterService {
    //public static final Long SINGLETON_TIME_TABLE_ID;
    @Inject
    SolverManager<Roster,UUID> solverManager;
    @Inject
    ScoreManager<Roster,HardSoftScore> scoreManager;

    UUID problemid;

    @GET
    @Path("/getRoster")
    public Roster getRoster() {
        RosterStorage get1 = new RosterStorage();
        return get1.getRoster();
    }

    @POST
    @Path("/solve")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Roster solve() {
        UUID problemId = UUID.randomUUID();
        problemid = problemId;
        Roster Rosterproblem = getRoster();
        //Consumer<Roster> solution;
        SolverJob<Roster,UUID>  solverJob = solverManager.solve(problemId, Rosterproblem);
        Roster solution;
        try {
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed",e);
        }
        return solution;
    }
    @POST
    @Path("/stopsolve")
    public void stopsolve() {
        solverManager.terminateEarly(problemid);
    }

}

