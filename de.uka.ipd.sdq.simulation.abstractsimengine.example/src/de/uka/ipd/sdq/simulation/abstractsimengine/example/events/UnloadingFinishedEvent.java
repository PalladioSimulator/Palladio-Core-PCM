package de.uka.ipd.sdq.simulation.abstractsimengine.example.events;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.Bus;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.util.Utils;

public class UnloadingFinishedEvent extends AbstractSimEventDelegator<Bus> {

    private double unloadingTime;

    public UnloadingFinishedEvent(double unloadingTime, ISimulationModel model, String name) {
        super(model, name);
        this.unloadingTime = unloadingTime;
    }

    @Override
    public void eventRoutine(Bus bus) {
        Utils.log(bus, "Unloading finished. Took " + this.unloadingTime + " seconds.");

        // schedule load passengers event
        LoadPassengersEvent e = new LoadPassengersEvent(this.getModel(), "Load Passengers");
        e.schedule(bus, 0);
    }

}
