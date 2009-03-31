/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;

/**DAO to access experiment groups.
 * @author groenda
 */
public interface ExperimentGroupDao extends Edp2Dao, EmfResourceDao {
	/**Returns the EMF representation of the experiment group.
	 * @return EMF model of the experiment group.
	 */
	public ExperimentGroup getExperimentGroup();
	
}
