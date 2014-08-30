package de.uka.ipd.sdq.reliability.core.probe;

import java.util.Map;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.unit.Unit;

import org.palladiosimulator.measurementframework.measure.IdentifierMeasure;
import org.palladiosimulator.metricspec.BaseMetricDescription;
import org.palladiosimulator.metricspec.DataType;
import org.palladiosimulator.metricspec.Identifier;
import org.palladiosimulator.metricspec.Scale;
import org.palladiosimulator.metricspec.util.builder.TextualBaseMetricDescriptionBuilder;
import org.palladiosimulator.probeframework.probes.BasicEventProbe;

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
public class TakeExecutionResultProbe extends BasicEventProbe<FailureStatistics, Identifier, Dimensionless> implements
        IFailureStatisticsListener {

    public TakeExecutionResultProbe(final FailureStatistics failureStatistics,
            final Map<MarkovFailureType, Identifier> simFailureTypes, final Identifier successIdentifier) {
        super(failureStatistics, createMetricDescription(simFailureTypes, successIdentifier));
    }

    private static BaseMetricDescription createMetricDescription(
            final Map<MarkovFailureType, Identifier> simFailureTypes, final Identifier successIdentifier) {
        return TextualBaseMetricDescriptionBuilder.newTextualBaseMetricDescriptionBuilder().name("Execution Result")
                .textualDescription("Enumeration of all failure types which might happen in a reliability simulation")
                .scale(Scale.NOMINAL).dataType(DataType.QUANTITATIVE).identifiers(simFailureTypes.values())
                .identifiers(successIdentifier).build();
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
