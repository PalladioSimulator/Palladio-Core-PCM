/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.debug;

import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand;
import de.uka.ipd.sdq.simucomframework.simucomstatus.util.SimucomstatusSwitch;

/**
 * @author Snowball
 *
 */
public class ProcessActionPrintVisitor extends SimucomstatusSwitch<String> {

    /**
	 * 
	 */
    public ProcessActionPrintVisitor() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.simucomframework.simucomstatus.util.SimucomstatusSwitch#caseWaitForAcquire
     * (de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire)
     */
    @Override
    public String caseWaitForAcquire(WaitForAcquire object) {
        // object.getResource() == null can happen during simulation startup
        return "Waiting to Acquire Resource " + (object.getResource() == null ? "N/A" : object.getResource().getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.simucomframework.simucomstatus.util.SimucomstatusSwitch#caseWaitForDelay(de
     * .uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay)
     */
    @Override
    public String caseWaitForDelay(WaitForDelay object) {
        return "Holding execution for " + object.getDelay();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.simucomframework.simucomstatus.util.SimucomstatusSwitch#caseWaitForDemand(
     * de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand)
     */
    @Override
    public String caseWaitForDemand(WaitForDemand object) {
        return "Waiting for ActiveResource " + object.getResource().getId() + " to process " + object.getDemand();
    }

}
