/**
 * 
 */
package de.uka.ipd.sdq.edp2.file.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.edp2.ExperimentGroupDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelFactoryImpl;

/**File-backed implementation of {@link ExperimentGroupDao}.
 * @author groenda
 */
public class FileExperimentGroupDaoImpl extends EmfFileAccessDao implements ExperimentGroupDao {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(FileExperimentGroupDaoImpl.class.getCanonicalName());

	@Override
	public ExperimentGroup getExperimentGroup() {
		if (!isOpen()) {
			String msg = "getExperimentGroup() only allowed on open data.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		return (ExperimentGroup) getEmfRootElement();
	}

	@Override
	protected EObject createEmfRootElement() {
		return EmfmodelFactoryImpl.eINSTANCE.createExperimentGroup();
	}

}
