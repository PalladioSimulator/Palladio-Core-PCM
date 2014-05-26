package org.palladiosimulator.pcm.edp2.measuringpoint.util;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.StringMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * Utility methods for Measuring Points.
 * 
 * @author Sebastian Lehrig
 */
public class MeasuringPointUtility {

    /**
     * TODO Should be refactored into measuring point objects' toString() method. [Lehrig]
     */
    public static String measuringPointToString(final MeasuringPoint measuringPoint) {
        final StringBuilder result = new StringBuilder();
        if(measuringPoint == null) {
            result.append("Measure");
        }
        else if(measuringPoint instanceof StringMeasuringPoint) {
            result.append(((StringMeasuringPoint) measuringPoint).getMeasuringPoint());
        }
        else if(measuringPoint instanceof ActiveResourceMeasuringPoint) {
            final ProcessingResourceSpecification activeResource = ((ActiveResourceMeasuringPoint) measuringPoint).getActiveResource();
            result.append(activeResource.getActiveResourceType_ActiveResourceSpecification().getEntityName());
            result.append(" [");
            result.append(String.valueOf(((ActiveResourceMeasuringPoint) measuringPoint).getReplicaID()));
            result.append("] in ");
            result.append(((ActiveResourceMeasuringPoint) measuringPoint).getActiveResource().getResourceContainer_ProcessingResourceSpecification().getEntityName());
        }
        else if(measuringPoint instanceof AssemblyOperationMeasuringPoint) {
            final AssemblyOperationMeasuringPoint mP = (AssemblyOperationMeasuringPoint) measuringPoint;
            result.append("Operation: ");
            result.append(mP.getAssembly().getEntityName());
            result.append(".");
            result.append(mP.getRole().getEntityName());
            result.append(".");
            result.append(mP.getOperationSignature().getEntityName());
        }
        else if(measuringPoint instanceof AssemblyPassiveResourceMeasuringPoint) {
            final AssemblyPassiveResourceMeasuringPoint mP = (AssemblyPassiveResourceMeasuringPoint) measuringPoint;
            result.append("Passive Resource: ");
            result.append(mP.getAssembly().getEntityName());
            result.append(".");
            result.append(mP.getPassiveResource().getEntityName());
        }
        else if(measuringPoint instanceof SubSystemOperationMeasuringPoint) {
            final SubSystemOperationMeasuringPoint mP = (SubSystemOperationMeasuringPoint) measuringPoint;
            result.append("Sub System Operation: ");
            result.append(mP.getSubsystem().getEntityName());
            result.append(".");
            result.append(mP.getRole().getEntityName());
            result.append(".");
            result.append(mP.getOperationSignature().getEntityName());
        }
        else if(measuringPoint instanceof SystemOperationMeasuringPoint) {
            final SystemOperationMeasuringPoint mP = (SystemOperationMeasuringPoint) measuringPoint;
            result.append(mP.getSystem().getEntityName());
            result.append(".");
            result.append(mP.getRole().getEntityName());
            result.append(".");
            result.append(mP.getOperationSignature().getEntityName());
        } else if(measuringPoint instanceof UsageScenarioMeasuringPoint) {
            final UsageScenarioMeasuringPoint mP = (UsageScenarioMeasuringPoint) measuringPoint;
            result.append("Usage Scenario: ");
            result.append(mP.getUsageScenario().getEntityName());
        }
        else {
            throw new IllegalArgumentException("Unknown measuring point type");
        }
        return result.toString();
    }
}
