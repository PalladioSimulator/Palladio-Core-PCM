/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.impl.BinaryMeasurementsDaoImpl;
import de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType;
import de.uka.ipd.sdq.edp2.models.emfmodel.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.JSXmlMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.LongBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.MetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.Scale;
import de.uka.ipd.sdq.edp2.models.emfmodel.util.EmfmodelSwitch;

/**EMF switch to create data series based on metric for RawMeasurements.
 * @author groenda
 */
public class EmfmodelDataSeriesFromMetricSwitch extends EmfmodelSwitch<Boolean> {
	/** Factory for Emfmodel. */
	private static final EmfmodelFactory factory = EmfmodelFactory.eINSTANCE;
	/** RawMeasurements on which the DataSeries should be added. */
	private RawMeasurements rm;
	/** The definition of the overall measure. */
	private Edp2Measure measure;
	/** Factory which is used to create the DAOs to access data of the DataSeries. */
	private MeasurementsDaoFactory daoFactory;
	
	public EmfmodelDataSeriesFromMetricSwitch(RawMeasurements rm, Edp2Measure measure, MeasurementsDaoFactory daoFactory) {
		this.rm = rm;
		this.measure = measure;
		this.daoFactory = daoFactory;
	}
	
	@Override
	public Boolean caseMetricSetDescription(MetricSetDescription object) {
		Iterator<MetricDescription> iter = object.getSubsumedMetrics().iterator();
		boolean success = true;
		while (iter.hasNext()) {
			success &= new EmfmodelDataSeriesFromMetricSwitch(rm, measure, daoFactory).doSwitch(iter.next());
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
					BinaryMeasurementsDaoImpl bmdao = daoFactory.createLongMeasurementsDao(valuesId);
					bmdao.setUnit(lbm.getStorageUnit());
					rm.getDataSeries().add(lbm);
				} else { // CaptureType.REAL_NUMBER
					DoubleBinaryMeasurements dbm = factory.createDoubleBinaryMeasurements();
					dbm.setValuesUuid(valuesId);
					dbm.setStorageUnit(bmd.getDefaultUnit());
					BinaryMeasurementsDaoImpl bmdao = daoFactory.createDoubleMeasurementsDao(valuesId);
					bmdao.setUnit(dbm.getStorageUnit());
					rm.getDataSeries().add(dbm);
				}
			}
		}
		return true;
	}

}
