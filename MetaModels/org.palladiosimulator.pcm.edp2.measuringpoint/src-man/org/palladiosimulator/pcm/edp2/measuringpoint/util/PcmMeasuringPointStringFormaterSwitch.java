package org.palladiosimulator.pcm.edp2.measuringpoint.util;

import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

public class PcmMeasuringPointStringFormaterSwitch extends PcmmeasuringpointSwitch<String> {

    private final StringBuilder result = new StringBuilder();

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch#caseAssemblyOperationMeasuringPoint(org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint)
     */
    @Override
    public String caseAssemblyOperationMeasuringPoint(final AssemblyOperationMeasuringPoint object) {
        result.append("Operation: ");
        result.append(object.getAssembly().getEntityName());
        result.append(".");
        result.append(object.getRole().getEntityName());
        result.append(".");
        result.append(object.getOperationSignature().getEntityName());

        return result.toString();
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch#caseAssemblyPassiveResourceMeasuringPoint(org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint)
     */
    @Override
    public String caseAssemblyPassiveResourceMeasuringPoint(final AssemblyPassiveResourceMeasuringPoint object) {
        result.append("Passive Resource: ");
        result.append(object.getAssembly().getEntityName());
        result.append(".");
        result.append(object.getPassiveResource().getEntityName());

        return result.toString();
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch#caseActiveResourceMeasuringPoint(org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint)
     */
    @Override
    public String caseActiveResourceMeasuringPoint(final ActiveResourceMeasuringPoint object) {
        final ProcessingResourceSpecification activeResource = object
                .getActiveResource();
        result.append(activeResource.getActiveResourceType_ActiveResourceSpecification().getEntityName());
        result.append(" [");
        result.append(String.valueOf(object.getReplicaID()));
        result.append("] in ");
        result.append(object.getActiveResource()
                .getResourceContainer_ProcessingResourceSpecification().getEntityName());
        return result.toString();
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch#caseSystemOperationMeasuringPoint(org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint)
     */
    @Override
    public String caseSystemOperationMeasuringPoint(final SystemOperationMeasuringPoint object) {
        result.append(object.getSystem().getEntityName());
        result.append(".");
        result.append(object.getRole().getEntityName());
        result.append(".");
        result.append(object.getOperationSignature().getEntityName());

        return result.toString();
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch#caseLinkingResourceMeasuringPoint(org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint)
     */
    @Override
    public String caseLinkingResourceMeasuringPoint(final LinkingResourceMeasuringPoint object) {
        // TODO Auto-generated method stub
        return super.caseLinkingResourceMeasuringPoint(object);
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch#caseSubSystemOperationMeasuringPoint(org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint)
     */
    @Override
    public String caseSubSystemOperationMeasuringPoint(final SubSystemOperationMeasuringPoint object) {
        result.append("Sub System Operation: ");
        result.append(object.getSubsystem().getEntityName());
        result.append(".");
        result.append(object.getRole().getEntityName());
        result.append(".");
        result.append(object.getOperationSignature().getEntityName());

        return result.toString();
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch#caseUsageScenarioMeasuringPoint(org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint)
     */
    @Override
    public String caseUsageScenarioMeasuringPoint(final UsageScenarioMeasuringPoint object) {
        result.append("Usage Scenario: ");
        result.append(object.getUsageScenario().getEntityName());

        return result.toString();
    }
}
