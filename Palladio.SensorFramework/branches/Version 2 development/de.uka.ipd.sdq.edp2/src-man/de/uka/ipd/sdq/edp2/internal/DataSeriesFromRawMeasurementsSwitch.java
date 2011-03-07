 /**
 * 
 */
package de.uka.ipd.sdq.edp2.internal;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;

/**EMF switch to create data series based on RawMeasurements.
 * @author groenda
 */
public class DataSeriesFromRawMeasurementsSwitch extends ExperimentDataSwitch<Boolean> {
	/** Logger for this class. */
	private static final Logger logger = Logger
			.getLogger(DataSeriesFromRawMeasurementsSwitch.class.getCanonicalName());
	/** Factory for EMF model. */
	private static final ExperimentDataFactory factory = ExperimentDataFactory.eINSTANCE;

	/** RawMeasurement on which the DataSeries should be added. */
	private RawMeasurements rm;
	
	@Override
	public Boolean caseRawMeasurements(RawMeasurements object) {
		rm = object;
		return doSwitch(object.getMeasurementsRange().getMeasurements().getMeasure());
	}
	
	@Override
	public Boolean caseEdp2Measure(Edp2Measure object) {
		return doSwitch(object.getMetric());
	}
	
	@Override
	public Boolean caseMetricSetDescription(MetricSetDescription object) {
		Iterator<MetricDescription> iter = object.getSubsumedMetrics().iterator();
		boolean success = true;
		while (iter.hasNext()) {
			success &= doSwitch(iter.next());
		}
		return success;
	}
	
	@Override
	public Boolean caseBaseMetricDescription(BaseMetricDescription bmd) {
		String valuesUuid = EcoreUtil.generateUUID();
		if (bmd.getCaptureType() == CaptureType.IDENTIFIER) {
			factory.createIdentifierBasedMeasurements(rm, valuesUuid);
		} else if (bmd.getCaptureType() == CaptureType.INTEGER_NUMBER) {
			NumericalBaseMetricDescription nmbd = (NumericalBaseMetricDescription) bmd;
			if (nmbd.getPersistenceKind() == PersistenceKindOptions.BINARY_PREFERRED) {
				factory.createLongBinaryMeasurements(rm, valuesUuid, nmbd.getDefaultUnit());
			} else if (nmbd.getPersistenceKind() == PersistenceKindOptions.JS_XML_PREFERRED) {
				factory.createJSXmlMeasurements(rm, valuesUuid);
			} else {
				String msg = "PersistenceKindOption of measure not known.";
				logger.log(Level.SEVERE, msg);
				throw new IllegalArgumentException(msg);
			}
		} else if (bmd.getCaptureType() == CaptureType.REAL_NUMBER) {
			NumericalBaseMetricDescription nmbd = (NumericalBaseMetricDescription) bmd;
			if (nmbd.getPersistenceKind() == PersistenceKindOptions.BINARY_PREFERRED) {
				factory.createDoubleBinaryMeasurements(rm, valuesUuid, nmbd.getDefaultUnit());
			} else if (nmbd.getPersistenceKind() == PersistenceKindOptions.JS_XML_PREFERRED) {
				factory.createJSXmlMeasurements(rm, valuesUuid);
			} else {
				String msg = "PersistenceKindOption of measure not known.";
				logger.log(Level.SEVERE, msg);
				throw new IllegalArgumentException(msg);
			}
		} else {
			String msg = "CaptureType of measure not known.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalArgumentException(msg);
		}
		return true;
	}
}
