package de.uka.ipd.sdq.simulation.abstractsimengine;

/**
 * An entity represents an object of the real-world system under simulation. However, not all
 * objects which are present in the real system need to be modelled by an entity. Instead, is is
 * usual to restrict the modelling to those objects, which are actually of interest for the given
 * simulation.
 * <p>
 * Entities have attributes, which are modified by events.
 * <p>
 * For a motivation of the methods <code>isScheduled</code> and <code>reschedule</code>, please
 * refer to the Desmo-J documentation [1].
 * <p>
 * [1] http://desmoj.sourceforge.net/doc/desmoj/core/simulator/Entity.html
 * 
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 */
public interface IEntity {

    public static final NullEntity NULL = new NullEntity();

    public boolean isScheduled();

    public void reschedule(double delay);

}