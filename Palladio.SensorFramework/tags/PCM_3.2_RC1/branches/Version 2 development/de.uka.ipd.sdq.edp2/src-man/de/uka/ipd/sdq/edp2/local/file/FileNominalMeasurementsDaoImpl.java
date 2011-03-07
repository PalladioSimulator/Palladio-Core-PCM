/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentDataFactoryImpl;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements;

/**File-backed implementation of {@link NominalMeasurementsDao}.
 * @author groenda
 */
public class FileNominalMeasurementsDaoImpl extends EmfFileAccessDao implements NominalMeasurementsDao {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(FileNominalMeasurementsDaoImpl.class.getCanonicalName());
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.NominalMeasurementsDao#getNominalMeasurements()
	 */
	@Override
	public ObservedIdentifierBasedMeasurements getObservedIdentifierBasedMeasurements() {
		if (!isOpen()) {
			String msg = "getIdentifierBasedMeasurements() only allowed on open data.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		return (ObservedIdentifierBasedMeasurements) getEmfRootElement();
	}

	@Override
	protected EObject createEmfRootElement() {
		return ExperimentDataFactoryImpl.eINSTANCE.createObservedIdentifierBasedMeasurements();
	}
}