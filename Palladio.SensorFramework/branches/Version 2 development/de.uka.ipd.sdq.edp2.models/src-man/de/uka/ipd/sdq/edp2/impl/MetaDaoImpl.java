/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;

/**
 * @author groenda
 *
 */
public abstract class MetaDaoImpl extends Edp2DaoImpl implements de.uka.ipd.sdq.edp2.MetaDao {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.IMetaDao#getMeasurementsDaoFactory()
	 */
	@Override
	public MeasurementsDaoFactory getMeasurementsDaoFactory() {
		if (!isOpen() || isDeleted()) {
			throw new IllegalStateException("Requesting the measurements factory only allowed on open and/or undeleted data.");
		}
		return null;
	}

}
