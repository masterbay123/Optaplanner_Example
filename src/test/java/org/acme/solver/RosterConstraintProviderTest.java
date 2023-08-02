package org.acme.solver;

import javax.inject.Inject;
import java.time.Month;
import io.quarkus.test.junit.QuarkusTest;
//import jdk.jfr.Timestamp;
import org.acme.domain.Location;
import org.acme.domain.Timeslot;
import org.acme.domain.Roster;
import org.acme.domain.Shift;

import org.junit.jupiter.api.Test;
import org.optaplanner.test.api.score.stream.ConstraintVerifier;

@QuarkusTest
class RosterConstraintProviderTest {
    private static final Location location = new Location(0,"Chai Wan");
    private static final Timeslot timeslot1 = new Timeslot(Month.MARCH);

    @Inject
    ConstraintVerifier<RosterConstraintProvider, Roster> constraintVerifer;

    @Test 
    void ShiftConflict() {
        Shift firstshift = new Shift(1L,6);
        Shift secondshift = new Shift(2L,4);

        firstshift.setLocation(location);
        firstshift.setTimeslot(timeslot1);
        secondshift.setLocation(location);
        secondshift.setTimeslot(timeslot1);

        constraintVerifer.verifyThat(RosterConstraintProvider::ShiftConflict).given(firstshift,secondshift).penalizesBy(1);
    }

}
