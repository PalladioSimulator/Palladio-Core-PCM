/**
 * 
 */
package de.uka.ipd.sdq.edp2.internal;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.IdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;

/**EMF switch to create DAOs based on a raw measurement or a lower element (e.g. data series).
 * @author groenda
 */
public class DAOFromBelowRawMeasurementSwitch extends ExperimentDataSwitch<Boolean> {
	/** DAO factory which is used to create measurements. */
	private MeasurementsDaoFactory daoFactory;
	
	@Override
	public Boolean caseRawMeasurements(RawMeasurements object) {
		boolean success = true;
		for(DataSeries dataSeries : object.getDataSeries()) {
			success &= doSwitch(dataSeries);
		}
		return success;
	}

	@Override
	public Boolean caseIdentifierBasedMeasurements(
			IdentifierBasedMeasurements object) {
		daoFactory = object.getRawMeasurements().getMeasurementsRange()
				.getMeasurements().getMeasure().getExperimentGroup()
				.getRepository().getMeasurementsDaoFactory();
		return null != daoFactory.createNominalMeasurementsDao(object.getValuesUuid());
	}
	
	@Override
	public Boolean caseLongBinaryMeasurements(LongBinaryMeasurements object) {
		daoFactory = object.getRawMeasurements().getMeasurementsRange()
				.getMeasurements().getMeasure().getExperimentGroup()
				.getRepository().getMeasurementsDaoFactory();
		return null != daoFactory.createLongMeasurementsDao(object
				.getValuesUuid(), object.getStorageUnit());
	}
	
	@Override
	public Boolean caseDoubleBinaryMeasurements(DoubleBinaryMeasurements object) {
		daoFactory = object.getRawMeasurements().getMeasurementsRange()
				.getMeasurements().getMeasure().getExperimentGroup()
				.getRepository().getMeasurementsDaoFactory();
		return null != daoFactory.createDoubleMeasurementsDao(object
				.getValuesUuid(), object.getStorageUnit());
	}
	
	@Override
	public Boolean caseJSXmlMeasurements(JSXmlMeasurements object) {
		daoFactory = object.getRawMeasurements().getMeasurementsRange()
				.getMeasurements().getMeasure().getExperimentGroup()
				.getRepository().getMeasurementsDaoFactory();
		return null != daoFactory.createJScienceXmlMeasurementsDao(object
				.getValuesUuid());
	}
}
