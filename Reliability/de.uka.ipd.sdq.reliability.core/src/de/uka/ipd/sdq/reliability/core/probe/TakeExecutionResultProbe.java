package de.uka.ipd.sdq.reliability.core.probe;

import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.edp2.impl.IdentifierMeasure;
import org.palladiosimulator.edp2.models.ExperimentData.BaseMetricDescription;
import org.palladiosimulator.edp2.models.ExperimentData.DataType;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataFactory;
import org.palladiosimulator.edp2.models.ExperimentData.Identifier;
import org.palladiosimulator.edp2.models.ExperimentData.Monotonic;
import org.palladiosimulator.edp2.models.ExperimentData.Scale;
import org.palladiosimulator.edp2.models.ExperimentData.TextualBaseMetricDescription;

import de.uka.ipd.sdq.probespec.framework.probes.BasicEventProbe;
import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.reliability.core.IFailureStatisticsListener;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;

/**
 * ProbeStrategy which is able to measure the type of an execution result.
 *
 * The execution result type is identified through its numeric ID.
 *
 * @author brosch
 *
 */
public class TakeExecutionResultProbe extends BasicEventProbe<FailureStatistics, Identifier, Dimensionless> implements IFailureStatisticsListener {

    private final static ExperimentDataFactory experimentDataFactory = ExperimentDataFactory.eINSTANCE;

    public TakeExecutionResultProbe(final FailureStatistics failureStatistics, final Map<MarkovFailureType, Identifier> simFailureTypes, final Identifier successIdentifier) {
        super(failureStatistics,createMetricDescription(simFailureTypes,successIdentifier));
    }

    private static BaseMetricDescription createMetricDescription(final Map<MarkovFailureType, Identifier> simFailureTypes, final Identifier successIdentifier) {
        final TextualBaseMetricDescription description = experimentDataFactory.createTextualBaseMetricDescription(
                "Execution Result",
                "Enumeration of all failure types which might happen in a reliability simulation",
                Scale.NOMINAL, DataType.QUALITATIVE, Monotonic.NO);
        description.setUuid(EcoreUtil.generateUUID());
        description.getIdentifiers().addAll(simFailureTypes.values());
        description.getIdentifiers().add(successIdentifier);
        return description;
    }

    @Override
    protected void registerListener() {
        this.eventSource.addObserver(this);
    }

    @Override
    public void executionResultRecorder(final MarkovFailureType failureType) {
        final Identifier resultFailureIdentifier = this.eventSource.getExecutionResultId(failureType);
        final Measure<Identifier, Dimensionless> result = IdentifierMeasure.valueOf(resultFailureIdentifier, Unit.ONE);
        this.notify(result);
    }

}
