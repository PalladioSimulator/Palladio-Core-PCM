package de.uka.ipd.sdq.edp2.internal;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.impl.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.IdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;

public class EmfmodelDataSeriesFromReferenceSwitch extends ExperimentDataSwitch<DataSeries> {
	/** Factory for Emfmodel. */
	private static final ExperimentDataFactory factory = ExperimentDataFactory.eINSTANCE;
	/** Factory which is used to create the DAOs to access data of the DataSeries. */
	private MeasurementsDaoFactory daoFactory;
	/** String which contains the values uuid for the data series. */
	private String valuesId;
	
	public EmfmodelDataSeriesFromReferenceSwitch(MeasurementsDaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public DataSeries caseIdentifierBasedMeasurements(
			IdentifierBasedMeasurements object) {
		valuesId = EcoreUtil.generateUUID();
		IdentifierBasedMeasurements ibm = factory.createIdentifierBasedMeasurements();
		daoFactory.createNominalMeasurementsDao(valuesId);
		ibm.setValuesUuid(valuesId);
		return ibm;
	}
	
	@Override
	public DataSeries caseJSXmlMeasurements(
			JSXmlMeasurements object) {
		valuesId = EcoreUtil.generateUUID();
		JSXmlMeasurements jsxml = factory.createJSXmlMeasurements();
		daoFactory.createJScienceXmlMeasurementsDao(valuesId);
		jsxml.setValuesUuid(valuesId);
		return jsxml;
	}
	@SuppressWarnings("unchecked")
	@Override
	public DataSeries caseDoubleBinaryMeasurements(
			DoubleBinaryMeasurements object) {
		valuesId = EcoreUtil.generateUUID();
		DoubleBinaryMeasurements dbm = factory.createDoubleBinaryMeasurements();
		dbm.setValuesUuid(valuesId);
		dbm.setStorageUnit(object.getStorageUnit());
		BinaryMeasurementsDao bmdao = daoFactory.createDoubleMeasurementsDao(valuesId);
		bmdao.setUnit(dbm.getStorageUnit());
		return dbm;
	}
	@SuppressWarnings("unchecked")
	@Override
	public DataSeries caseLongBinaryMeasurements(
			LongBinaryMeasurements object) {
		valuesId = EcoreUtil.generateUUID();
		LongBinaryMeasurements lbm = factory.createLongBinaryMeasurements();
		lbm.setValuesUuid(valuesId);
		lbm.setStorageUnit(object.getStorageUnit());
		BinaryMeasurementsDao bmdao = daoFactory.createLongMeasurementsDao(valuesId);
		bmdao.setUnit(lbm.getStorageUnit());
		return lbm;
	}

}
