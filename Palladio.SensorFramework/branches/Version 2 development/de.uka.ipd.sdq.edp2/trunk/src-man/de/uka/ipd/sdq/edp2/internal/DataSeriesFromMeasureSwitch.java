/**
 * 
 */
package de.uka.ipd.sdq.edp2.internal;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.impl.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Scale;

/**EMF switch to create data series based on metric for RawMeasurements.
 * @author groenda
 */
public class DataSeriesFromMeasureSwitch extends ExperimentDataSwitch<Boolean> {
	/** Factory for Emfmodel. */
	private static final ExperimentDataFactory factory = ExperimentDataFactory.eINSTANCE;
	/** RawMeasurements on which the DataSeries should be added. */
	private RawMeasurements rm;
	/** The definition of the overall measure. */
	private Edp2Measure measure;
	/** Factory which is used to create the DAOs to access data of the DataSeries. */
	private MeasurementsDaoFactory daoFactory;
	
	/**Creates a new instances.
	 * @param rm Where to add the data series.
	 * @param measure The definition of the measure which defines the data series.
	 * @param daoFactory The factory used to create the measurement DAOs.
	 */
	public DataSeriesFromMeasureSwitch(RawMeasurements rm, Edp2Measure measure, MeasurementsDaoFactory daoFactory) {
		this.rm = rm;
		this.measure = measure;
		this.daoFactory = daoFactory;
	}

	@Override
	public Boolean caseMetricSetDescription(MetricSetDescription object) {
		Iterator<MetricDescription> iter = object.getSubsumedMetrics().iterator();
		boolean success = true;
		while (iter.hasNext()) {
			success &= new DataSeriesFromMeasureSwitch(rm, measure, daoFactory).doSwitch(iter.next());
		}
		return success;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean caseBaseMetricDescription(BaseMetricDescription bmd) {
		String valuesId = EcoreUtil.generateUUID();
		if (bmd.getScale() == Scale.NOMINAL) {
			NominalMeasurements nm = factory.createNominalMeasurements();
			daoFactory.createNominalMeasurementsDao(valuesId);
			nm.setValuesUuid(valuesId);
			rm.getDataSeries().add(nm);
		} else { // Scale.{Ordinal|Interval|Ratio}
			if (measure.getPersistencyKind() == PersistenceKindOptions.JS_XML_PREFERRED) {
				JSXmlMeasurements jsxml = factory.createJSXmlMeasurements();
				daoFactory.createJScienceXmlMeasurementsDao(valuesId);
				jsxml.setValuesUuid(valuesId);
				rm.getDataSeries().add(jsxml);
			} else { // BINARY_PREFERRED
				if (bmd.getCaptureType() == CaptureType.NATURAL_NUMBER) {
					LongBinaryMeasurements lbm = factory.createLongBinaryMeasurements();
					lbm.setValuesUuid(valuesId);
					lbm.setStorageUnit(bmd.getDefaultUnit());
					BinaryMeasurementsDao bmdao = daoFactory.createLongMeasurementsDao(valuesId);
					bmdao.setUnit(lbm.getStorageUnit());
					rm.getDataSeries().add(lbm);
				} else { // CaptureType.REAL_NUMBER
					DoubleBinaryMeasurements dbm = factory.createDoubleBinaryMeasurements();
					dbm.setValuesUuid(valuesId);
					dbm.setStorageUnit(bmd.getDefaultUnit());
					BinaryMeasurementsDao bmdao = daoFactory.createDoubleMeasurementsDao(valuesId);
					bmdao.setUnit(dbm.getStorageUnit());
					rm.getDataSeries().add(dbm);
				}
			}
		}
		return true;
	}

}
