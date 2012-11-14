package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.util.HashMap;
import java.util.List;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFQueryHelper;

public class Pcm2LqnHelper {

	static HashMap<String, Integer> guidMap = new HashMap<String, Integer>();
	static int guidCounter = 0;
	
	static boolean shortenIds = false;
	
	public static String fixGUID(String id) {
		return id.replaceAll("-", "x"); // to make XML valid
	}

	/**
	 * Generates an unique ID for the given Identifier.
	 * PCM2LQN cannot use the identifier's guid directly, because
	 * sometimes for actions inside RDSEFF's also the assembly
	 * context id and the usage context id must be added to make
	 * the LQN entities unique. 
	 * 
	 * The following code tries to generate 'pretty' ids that
	 * shall ease reading the LQN solvers' output.
	 * 
	 * Takes into account the {@link AssemblyContext} hierarchy of 
	 * model elements and the {@link AllocationContext}, so that 
	 * different component instances will get different ids. 
	 * 
	 * If changing this method, take care to change other methods of this
	 * class accordingly, e.g. {@link #getIdForEntryLevelSystemCall(EntryLevelSystemCall)}.
	 * 
	 * @param object
	 * @param cw
	 * @return
	 */
	public static String getId(Identifier object, ContextWrapper cw) {
		String className = getClassName(object);
		String id = "";
		if (object instanceof ResourceDemandingSEFF){
			ResourceDemandingSEFF rdseff = (ResourceDemandingSEFF)object;
			ImplementationComponentType ict = (ImplementationComponentType)rdseff.eContainer();
			String compName = ict.getEntityName();
			
			// TODO: I had to cast Signature to OperationSignature to navigate to the interface.
			// Check if this still works! FB, 13-06-2010 
			String ifName = ((OperationSignature)rdseff.getDescribedService__SEFF()).getInterface__OperationSignature().getEntityName();
			String serviceName = rdseff.getDescribedService__SEFF().getEntityName();
			
			id = compName+"_"
				+ifName+"_"
				+serviceName+"_"
				+getAssCtxtAllocCtxtIdString(cw)+
				+getNumberForId(cw.getCompUsgCtx());
		} else if (object instanceof AbstractAction){
			AbstractAction aa = (AbstractAction)object;
			String actionName = aa.getEntityName();
			id = className+"_"
				+ actionName+"_"
				+ aa.getId()+ "_"
				+getAssCtxtAllocCtxtIdString(cw)+"_"
				+getNumberForId(cw.getCompUsgCtx());//+"_"
				//+getNumberForId(object);
		} else if (object instanceof Loop){
			id = "UsageScenario_"+className+"_"+ getNumberForId(object);
		} else if (object instanceof PassiveResource){
			// create id that is unique for the pair (PassiveResource,AssemblyContext)
			id = "PassiveResource_"+((PassiveResource)object).getEntityName()+"_"
			+getAssCtxtAllocCtxtIdString(cw)+"_"+getNumberForId(object);
		} else if (object instanceof AcquireAction){
			// create id that is unique for the pair (PassiveResource,AssemblyContext)
			id = "AcquireAction_"+((AcquireAction)object).getEntityName()+"_"
			+getAssCtxtAllocCtxtIdString(cw)+"_"+getNumberForId(object);
		} else if (object instanceof ReleaseAction){
				// create id that is unique for the pair (PassiveResource,AssemblyContext)
				id = "ReleaseAction_"+((ReleaseAction)object).getEntityName()+"_"
				+getAssCtxtAllocCtxtIdString(cw)+"_"+getNumberForId(object);
		} else {	
			//id = className + fixGUID(object.getId());
			id = className + getNumberForId(object);
		}
		
		return shortenID(id);
	}
	


	private static String shortenID(String id) {
		if (shortenIds && id.length() > 50){
			return id.substring(id.length()-50, id.length());
		} else {
			return id;
		}
	}

	private static String getClassName(Identifier object) {
		return object.getClass().getSimpleName().replaceAll("Impl","");
	}

	/**
	 * Create an id string based on the ids of all {@link AssemblyContext}s of the current components 
	 * (taking into account the hierarchy of {@link AssemblyContext}s of nested {@link CompositeComponent}s)
	 * and based on the id of the allocation context.
	 * 
	 * @param cw The current {@link ContextWrapper}.
	 * @return a unique id string
	 */
	private static String getAssCtxtAllocCtxtIdString(ContextWrapper cw) {
		String assCtxtAllocCtxtName = "";
		List<AssemblyContext> assCtxList = cw.getAssCtxList();
		for (AssemblyContext ac : assCtxList){
			assCtxtAllocCtxtName+=getNumberForId(ac);
		}
		assCtxtAllocCtxtName += getNumberForId(cw.getAllCtx());
		return shortenID(assCtxtAllocCtxtName);
	}
	
	private static int getNumberForId(Identifier object) {
		Integer value = guidMap.get(object.getId());
		if (value==null){
			guidMap.put(object.getId(), ++guidCounter);
			return guidCounter;
		} else {
			return value;
		}

	}

	public static void clearGuidMap(){
		guidMap = new HashMap<String, Integer>();
		guidCounter = 0;
	}
	
	public static String getIdForUsageScenario(UsageScenario us){
		//return us.getEntityName()+ fixGUID(us.getId());
		return shortenID("UsageScenario_"
			+us.getEntityName()+"_"
			+getNumberForId(us));
	}

	public static String getIdForCommResource(LinkingResource lr,
			CommunicationLinkResourceType clrt) {
		//Empty type (i.e. clrt == null) is ok for validation, so do not fail here because of it. 
		String clrtString = clrt == null ? "none" : clrt.getEntityName(); 
		return shortenID("LinkingResource_"+lr.getEntityName() + "_" + clrtString);
				//+ fixGUID(clrt.getId());
			//+ getNumberForId(clrt);
	}
	
	public static String getIdForThroughput(String commResourceID){
		return shortenID("throughput_"+commResourceID);
	}
	
	public static String getIdForLatency(String commResourceID, CallType callType){
		return shortenID("latency_"+commResourceID+"_"+callType);
	}

	public static String getIdForProcResource(Entity rc,
			ProcessingResourceType prt) {
		return shortenID(rc.getEntityName() + "_" + prt.getEntityName());
			//	+ Pcm2LqnHelper.fixGUID(prt.getId());
			//+ getNumberForId(prt);
	}

	public static String getIdForPassiveResource(
			PassiveResource passiveResource, AllocationContext assCtx) {
		return shortenID(getClassName(passiveResource) 
		+ "_" + passiveResource.getEntityName() 
		//+ "_" + getNumberForId(passiveResource)
		+ "_" + assCtx.getId());
	}
	
	public static String getIdForEntryLevelSystemCall(EntryLevelSystemCall call){
		String className = getClassName(call);
		String id = className  + call.getId();
		return shortenID(id);
	}

	/**
	 * Get wait entry id based on passed id (appends a String)
	 * @param id
	 * @return
	 */
	public static String getSignalEntryId(String id) {
		return shortenID(id + "Signal_Entry");
	}

	/**
	 * Get signal entry id based on passed id (appends a String)
	 * @param id
	 * @return
	 */
	public static String getWaitEntryId(String id) {
		return shortenID(id + "Wait_Entry");
	}

	public static String getIdForForkedBehaviour(ForkedBehaviour asyncBeh,
			ContextWrapper myContextWrapper) {
		StartAction startAction = (StartAction) EMFQueryHelper.getObjectByType(
				asyncBeh.getSteps_Behaviour(), StartAction.class);
		return shortenID("ForkedBehaviour_"+ getNumberForId(startAction));
	}
	
}
