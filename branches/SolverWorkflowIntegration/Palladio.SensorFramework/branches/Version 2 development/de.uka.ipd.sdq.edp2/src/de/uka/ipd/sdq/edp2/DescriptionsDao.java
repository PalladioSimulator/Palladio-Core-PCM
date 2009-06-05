/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import de.uka.ipd.sdq.edp2.models.emfmodel.Descriptions;

/**
 * @author groenda
 */
public interface DescriptionsDao extends Dao, EmfResourceDao {

	public Descriptions getDescriptions();
}
