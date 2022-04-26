package spaceexplorers.strategies;

import spaceexplorers.publicapi.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class StudentStrategy implements IStrategy {

    /**
     * Method where students can observe the state of the system and schedule events to be executed.
     *
     * @param planets          The current state of the system.
     * @param planetOperations Helper methods students can use to interact with the system.
     * @param eventsToExecute  Queue students will add to in order to schedule events.
     */
    @Override
    public void takeTurn(List<IPlanet> planets, IPlanetOperations planetOperations, Queue<IEvent> eventsToExecute) {
        List<IVisiblePlanet> occupiedVisiblePlanets = new ArrayList<>();
        List<IVisiblePlanet> unOccupiedVisiblePlanets = new ArrayList<>();
        for (IPlanet planet : planets) {
            if (planet instanceof IVisiblePlanet && ((IVisiblePlanet) planet).getOwner() == Owner.SELF) {
                occupiedVisiblePlanets.add((IVisiblePlanet) planet);
            } else if (planet instanceof IVisiblePlanet)
                unOccupiedVisiblePlanets.add((IVisiblePlanet) planet);
        }
    }

    @Override
    public String getName() {
        return "Student";
    }

    @Override
    public boolean compete() {
        return false;
    }
}
