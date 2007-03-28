/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.birt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 *
 */
public class Histogram {
	
	List<Entity> entityList;
	
	/**
	 * @param entityList
	 */
	public Histogram() {
		this.entityList = new ArrayList<Entity>();
	}

	public void addEntity(Entity entity){
		entityList.add(entity);
	}
	
	public void removeEntity(Entity entity){
		entityList.remove(entity);
	}

	/**
	 * @return the entityList
	 */
	public List<Entity> getEntityList() {
		return entityList;
	}
}
