//package de.uka.ipd.sdq.experimentautomation.application.variation;
//
//import de.uka.ipd.sdq.pcm.core.CoreFactory;
//import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
//import de.uka.ipd.sdq.pcm.usagemodel.Delay;
//import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelFactory;
//
//public class DelayReplicationVariation extends AbstractUserActionReplicationVariation<Delay> {
//
//    @Override
//    public Delay replicate(Delay action) {
//        Delay replica = UsagemodelFactory.eINSTANCE.createDelay();
//        replica.setEntityName(action.getEntityName());
//        replica.setScenarioBehaviour_AbstractUserAction(action.getScenarioBehaviour_AbstractUserAction());
//        replica.setTimeSpecification_Delay(replicate(action.getTimeSpecification_Delay()));
//        return replica;
//    }
//    
//    public PCMRandomVariable replicate(PCMRandomVariable variable) {
//        PCMRandomVariable replica = CoreFactory.eINSTANCE.createPCMRandomVariable();
//        replica.setSpecification(variable.getSpecification());
//        return replica;
//    }
//
//}
