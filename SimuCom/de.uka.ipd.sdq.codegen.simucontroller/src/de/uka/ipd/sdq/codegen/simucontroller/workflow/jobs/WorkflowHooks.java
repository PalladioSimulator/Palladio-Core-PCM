package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.LinkedList;
import java.util.List;

public class WorkflowHooks {
    
    /** The id of the workflow extending configuration tabs have to register for. */
    public static String WORKFLOW_ID_AFTER_LOAD_VALIDATE = "workflow.extension.simucom.after.load.validate";
    
    /** The id of the workflow extending configuration tabs have to register for. */
    public static String WORKFLOW_ID_BEFORE_CODEGENERATION= "workflow.extension.simucom.before.codegeneration";
	
    /** The id of the workflow extending configuration tabs have to register for. */
    public static String WORKFLOW_ID_BEFORE_DOCK = "workflow.extension.simucom.before.dock";
    
    /** The id of the workflow extending configuration tabs have to register for. */
    public static String WORKFLOW_ID_AFTER_DOCK = "workflow.extension.simucom.after.dock";
  
    
    /** The id of the workflow extending configuration tabs have to register for. */
    public static String WORKFLOW_ID_AFTER_SIMULATION = "workflow.extension.simucom.after.simulation";
    
    /**
     * Get a list of ids of all extendible workflow extension points.
     * 
     * @return The list of ids.
     */
    public static List<String> getAllWorkflowHookIDs(){
        
        List<String> idList = new LinkedList<String>();
        idList.add(WORKFLOW_ID_AFTER_LOAD_VALIDATE);
        idList.add(WORKFLOW_ID_BEFORE_CODEGENERATION);
        idList.add(WORKFLOW_ID_BEFORE_DOCK);
        idList.add(WORKFLOW_ID_AFTER_DOCK);
        idList.add(WORKFLOW_ID_AFTER_SIMULATION);
        return idList;
    }

}
