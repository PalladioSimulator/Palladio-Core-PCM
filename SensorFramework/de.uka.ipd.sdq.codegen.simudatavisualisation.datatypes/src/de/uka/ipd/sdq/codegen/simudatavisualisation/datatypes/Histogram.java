/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 *
 */
public class Histogram {
	
	List<HistogramEntity> entityList;
	private String myLabel;
	
	/**
	 * @param string 
	 * @param entityList
	 */
	public Histogram(String label) {
		this.entityList = new ArrayList<HistogramEntity>();
		this.myLabel = label;
	}

	public void addEntity(HistogramEntity entity){
		entityList.add(entity);
	}
	
	public void removeEntity(HistogramEntity entity){
		entityList.remove(entity);
	}

	/**
	 * @return the entityList
	 */
	public List<HistogramEntity> getEntityList() {
		return entityList;
	}

	public String getLabel() {
		return myLabel;
	}

	public void setLabel(String newLabel) {
		myLabel=newLabel;
	}
	
}
