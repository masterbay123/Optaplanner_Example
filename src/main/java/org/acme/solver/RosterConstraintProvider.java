package org.acme.solver;


//import org.joda.time.Months;
import org.acme.domain.Shift;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.Joiners;
//import org.optaplanner.core.api.score.stream.uni;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

public class RosterConstraintProvider implements ConstraintProvider{
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintfactory) {
        return new Constraint[] {
            ShiftConflict(constraintfactory),
            IntervalFollow(constraintfactory),
            LocationExceptions(constraintfactory)
        };
    }
    public Constraint ShiftConflict(ConstraintFactory constraintfactory) {
        return constraintfactory
        .fromUniquePair(Shift.class,
        Joiners.equal(Shift::getTimeslot),
        Joiners.equal(Shift::getLocation),
        Joiners.lessThan(Shift::getId)).penalize("Shift conflict",HardSoftScore.ONE_HARD);
    }
    public Constraint IntervalFollow(ConstraintFactory constraintfactory) {
        return constraintfactory
        .fromUniquePair(Shift.class,
        Joiners.equal(Shift::getLocation),
        Joiners.filtering((shift1,shift2) -> (shift2.getTimeslot().getMonth() - shift1.getTimeslot().getMonth() < 2)  || // this filtering means that whenever the 
        (shift2.getTimeslot().getMonth() - shift2.getTimeslot().getMonth() > 2) 
        )).penalize("Violate_Interval_Following",HardSoftScore.ONE_HARD);       // this rule is configured to use hard because this rule should explicitly not be violated 
    }
    
    public Constraint LocationExceptions(ConstraintFactory constraintFactory) {
        return constraintFactory
        .fromUniquePair(Shift.class, // firstly not equal locations is allowed in this constraint
        Joiners.filtering((shift1,shift2) -> (shift1.getLocation().location == "Kwu Tung North" && shift2.getLocation().location == "Kwu Tung North") //the solver will filter out these locations which it has same locations on the same row 
        || (shift1.getLocation().location == "Mai Po & Fairview Park" && shift2.getLocation().location == "Mai Po & Fairview Park")                    // and because it still follows the rule above, it would be handled exceptionally
        )
        ).penalize("Violate_Location_Exceptions",HardSoftScore.ONE_SOFT);   // but still the soft score is unchanged at last which means it remains unsolved.
    }
    
    
}