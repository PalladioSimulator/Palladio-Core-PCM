package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.internal.ReopenEditorMenu;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;

public class Pcm2LqnHelper {

	static HashMap<String, Integer> guidMap = new HashMap<String, Integer>();
	static int guidCounter = 0;
	
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
	 * @param object
	 * @param cw
	 * @return
	 */
	public static String getId(Identifier object, ContextWrapper cw) {
		String className = object.getClass().getSimpleName().replaceAll("Impl","");
		String id = "";
		if (object instanceof ResourceDemandingSEFF){
			ResourceDemandingSEFF rdseff = (ResourceDemandingSEFF)object;
			ImplementationComponentType ict = (ImplementationComponentType)rdseff.eContainer();
			String compName = ict.getEntityName();
			String ifName = rdseff.getDescribedService__SEFF().getInterface_Signature().getEntityName();
			String serviceName = rdseff.getDescribedService__SEFF().getServiceName();
			
			id = compName+"_"
				+ifName+"_"
				+serviceName+"_"
				+getAssCtxIdString(cw)+
				+getNumberForId(cw.getCompUsgCtx());
		} else if (object instanceof AbstractAction){
			AbstractAction aa = (AbstractAction)object;
			String actionName = aa.getEntityName();
			id = className+"_"
				+ actionName+"_"
				+getAssCtxIdString(cw)
				+getNumberForId(cw.getCompUsgCtx())
				+getNumberForId(object);
		} else if (object instanceof Loop){
			id = "UsageScenario_"+className+"_"+ getNumberForId(object);
		} else {
			//id = className + fixGUID(object.getId());
			id = className + getNumberForId(object);
		}
		
		return id;
	}

	private static String getAssCtxIdString(ContextWrapper cw) {
		String assCtxName = "";
		EList<AssemblyContext> assCtxList = cw.getAssCtxList();
		for (AssemblyContext ac : assCtxList){
			assCtxName+=getNumberForId(ac);
		}
		return assCtxName;
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
		return "UsageScenario_"
			+us.getEntityName()+"_"
			+getNumberForId(us);
	}

	public static String getIdForCommResource(LinkingResource lr,
			CommunicationLinkResourceType clrt) {
		return lr.getEntityName() + "_" + clrt.getEntityName();
				//+ fixGUID(clrt.getId());
			//+ getNumberForId(clrt);
	}

	public static String getIdForProcResource(ResourceContainer rc,
			ProcessingResourceType prt) {
		return rc.getEntityName() + "_" + prt.getEntityName();
			//	+ Pcm2LqnHelper.fixGUID(prt.getId());
			//+ getNumberForId(prt);
	}
	
}
