/**
 * 
 */
package de.uka.ipd.sdq.edp.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.edp2.MeasurementsDaoRegistry;
import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CategoryIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedCategory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.EmfmodelSwitch;

/**Switch class to add a provided measurement to a data series.
 * @author groenda
 */
public class EmfmodelAddMeasurementToDataSeriesSwitch extends EmfmodelSwitch<Boolean> {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(EmfmodelAddMeasurementToDataSeriesSwitch.class.getCanonicalName());
	/** Factory of EDP2 EMF model. */
	private static final EmfmodelFactory factory = EmfmodelFactory.eINSTANCE;
	/** Registry for the DAOs. */
	private MeasurementsDaoRegistry daoRegistry;
	/** Measurement to add. */
	private Object measurementToAdd;

	public EmfmodelAddMeasurementToDataSeriesSwitch(MeasurementsDaoRegistry daoRegistry) {
		this.daoRegistry = daoRegistry;
	}
	
	@Override
	public Boolean caseNominalMeasurements(
			NominalMeasurements object) {
		ObservedCategory oc = factory.createObservedCategory();
		oc.setCategoryIdentifier((CategoryIdentifier) measurementToAdd);
		NominalMeasurementsDao dao = (NominalMeasurementsDao) daoRegistry.getMeasurementsDao(object.getValuesUuid());
		if (!dao.isOpen()) {
			try {
				dao.open();
			} catch (DataNotAccessibleException e) {
				logger.log(Level.SEVERE, "Could not access DAO with valuesUuid=" + object.getValuesUuid());
				return false;
			}
		}
		dao.getNominalMeasurements().getObservedCategories().add(oc);
		return true;
	}
	
	@Override
	public Boolean caseJSXmlMeasurements(
			JSXmlMeasurements object) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean caseDoubleBinaryMeasurements(
			DoubleBinaryMeasurements object) {
		BinaryMeasurementsDao<javax.measure.Measure<Double, Quantity>> bmd = 
			(BinaryMeasurementsDao<javax.measure.Measure<Double, Quantity>>) daoRegistry.getMeasurementsDao(object.getValuesUuid());
		if (!bmd.isOpen()) {
			try {
				bmd.open();
			} catch (DataNotAccessibleException e) {
				logger.log(Level.SEVERE, "Could not access DAO with valuesUuid=" + object.getValuesUuid());
				return false;
			}
		}
		bmd.getMeasurements().add((javax.measure.Measure<Double,Quantity>)measurementToAdd);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean caseLongBinaryMeasurements(
			LongBinaryMeasurements object) {
		BinaryMeasurementsDao<javax.measure.Measure<Long, Quantity>> bmd = 
			(BinaryMeasurementsDao<javax.measure.Measure<Long, Quantity>>) daoRegistry.getMeasurementsDao(object.getValuesUuid());
		if (!bmd.isOpen()) {
			try {
				bmd.open();
			} catch (DataNotAccessibleException e) {
				logger.log(Level.SEVERE, "Could not access DAO with valuesUuid=" + object.getValuesUuid());
				return false;
			}
		}
		bmd.getMeasurements().add((javax.measure.Measure<Long, Quantity>)measurementToAdd);
		return true;
	}

	/**
	 * @return the measurementToAdd
	 */
	public Object getMeasurementToAdd() {
		return measurementToAdd;
	}

	/**
	 * @param measurementToAdd the measurementToAdd to set
	 */
	public void setMeasurementToAdd(Object measurementToAdd) {
		this.measurementToAdd = measurementToAdd;
	}

}
