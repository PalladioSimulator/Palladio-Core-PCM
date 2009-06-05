/**
 * 
 */
package de.uka.ipd.sdq.edp2.file.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.edp2.DescriptionsDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.Descriptions;
import de.uka.ipd.sdq.edp2.models.emfmodel.impl.EmfmodelFactoryImpl;

/**File-backed implementation of {@link DescriptionsDao}.
 * @author groenda
 */
public class FileDescriptionsDaoImpl extends EmfFileAccessDao implements DescriptionsDao {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(FileDescriptionsDaoImpl.class.getCanonicalName());
	
	@Override
	protected EObject createEmfRootElement() {
		return EmfmodelFactoryImpl.eINSTANCE.createDescriptions();
	}

	@Override
	public Descriptions getDescriptions() {
		if (!isOpen()) {
			String msg = "getDescriptions() only allowed on open data.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		return (Descriptions) getEmfRootElement();
	}
}