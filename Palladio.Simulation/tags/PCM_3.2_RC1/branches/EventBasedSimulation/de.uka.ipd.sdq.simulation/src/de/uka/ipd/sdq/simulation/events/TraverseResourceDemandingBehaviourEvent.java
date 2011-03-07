package de.uka.ipd.sdq.simulation.events;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.SimulatedComponentInstance;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.rdseff.SeffTraversal;
import de.uka.ipd.sdq.simulation.traversal.state.TraversalState;

public class TraverseResourceDemandingBehaviourEvent extends AbstractSimEvent<EventSimModel, Request> {

    private TraversalState<AbstractAction> context;
//    private AbstractAction position;
    private SimulatedComponentInstance component;
//    private ResourceDemandingBehaviour behaviour;
    private OperationSignature signature;

    public TraverseResourceDemandingBehaviourEvent(EventSimModel owner, SimulatedComponentInstance component, OperationSignature signature) {
        super(owner, "Span request event");
//        this.position = position;
        this.component = component;
//        this.behaviour = behaviour;
        this.signature = signature;
    }

    public TraverseResourceDemandingBehaviourEvent(EventSimModel owner, TraversalState<AbstractAction> context) {
        super(owner, "Span request event");
        this.context = context;
    }

    @Override
    public void eventRoutine(Request who) {
//        if (context == null) {
//            context = new TraversalContext<AbstractAction>();
//            context.getStack().enterScope(new TraversalStackFrame<AbstractAction>());
//            context.getStack().currentScope().setComponent(component);
//            context.getStack().currentScope().setCurrentPosition(position);
            
            
            // TODO do we really need this here!?
//            context = who.getTraversalContext();
//            context.getStack().currentScope().setComponent(this.context.getStack().currentScope().getComponent());
//        }
//        if (position == null) {
//            position = context.getStack().currentScope().getCurrentPosition();
//        }

        if(component != null && signature != null) {
            new SeffTraversal(who, who.getTraversalState(), component, signature).beginTraversal();    
        } else {
            new SeffTraversal(who, context).resumeTraversal();
        }        
    }

}
