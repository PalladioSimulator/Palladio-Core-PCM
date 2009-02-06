/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.impl;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.uka.ipd.sdq.sensorframework.DataNotAccessibleException;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.sensorframework.ExperimentGroupDao;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelFactory;
import de.uka.ipd.sdq.sensorframework.file.impl.EmfModelXMIResourceFactoryImpl;

/**DAO for accessing emf models stored in files on backgrounds storage.
 * @author groenda
 */
public class FileExperimentGroupDao implements ExperimentGroupDao {
	protected final static emfmodelFactory ModelFactory = emfmodelFactory.eINSTANCE;
	protected static ResourceSet resourceSet = new ResourceSetImpl();
	private ExperimentGroup experimentGroup = null;
	private boolean accessible = false;

	@Override
	public void closeStorage() throws DataNotAccessibleException {
		//TODO Save
		experimentGroup = null;
		accessible=false;
	}

	@Override
	public ExperimentGroup getExperimentGroup() {
		return experimentGroup;
	}

	@Override
	public boolean isStorageClosed() {
		return !accessible;
	}

	@Override
	public void openStorage() throws DataNotAccessibleException {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put(EmfModelXMIResourceFactoryImpl.EXTENSION_SENSORFRAMEWORK,
				new EmfModelXMIResourceFactoryImpl());
		// TODO Auto-generated method stub
		accessible = true;
	}
}
