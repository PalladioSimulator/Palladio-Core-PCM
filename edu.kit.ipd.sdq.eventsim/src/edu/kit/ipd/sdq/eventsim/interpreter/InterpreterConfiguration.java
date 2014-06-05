package edu.kit.ipd.sdq.eventsim.interpreter;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import edu.kit.ipd.sdq.eventsim.entities.EventSimEntity;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ITraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.state.AbstractInterpreterState;

public interface InterpreterConfiguration<A extends Entity, E extends EventSimEntity, S extends AbstractInterpreterState<A>> {

    public Map<EClass, ? extends ITraversalStrategy<A, ? extends A, E, S>> getHandlerMap();

    public List<? extends ITraversalListener<A, E, S>> getTraversalListenerList();
    
    public Map<A, ? extends List<? extends ITraversalListener<A, E, S>>> getTraversalListenerMap();

}
