/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.storage.impl;

import java.io.File;

import de.uka.ipd.sdq.sensorframework.ExperimentGroup;
import de.uka.ipd.sdq.sensorframework.storage.DataNotAccessibleException;
import de.uka.ipd.sdq.sensorframework.storage.DaoFactory;
import de.uka.ipd.sdq.sensorframework.storage.MeasurementDataDao;
import de.uka.ipd.sdq.sensorframework.storage.file.impl.DoubleSerialiser;

/**Responsible for creating DAOs accessing files on background storage.
 * @author groenda
 */
public class FileDaoFactory<T> implements DaoFactory {
	private File storageDirectory = null;
	private boolean accessible = false;

	@Override
	public ExperimentGroup createExperimentGroupDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MeasurementDataDao<Double> createDoubleMeasurementDataDao(String uuid) {
		FileMeasurementDataDao<Double> fmd = new FileMeasurementDataDao<Double>();
		fmd.setSerializer(new DoubleSerialiser());
		fmd.setStorageDirectory(storageDirectory);
		fmd.setUuid(uuid);
		return fmd;
	}

	@Override
	public void closeStorage() throws DataNotAccessibleException {
		// TODO Auto-generated method stub
		accessible = false; 
	}

	@Override
	public boolean isStorageClosed() {
		return !accessible;
	}

	@Override
	public void openStorage() throws DataNotAccessibleException {
		// TODO Auto-generated method stub
		accessible = true;
	}

}
