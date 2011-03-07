package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author groenda, Michael Kuperberg
 *
 */
public class Pie implements /*Comparable<Pie>, */Serializable {
	/**
	 * for serialization
	 */
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<PieEntity> entities = new ArrayList<PieEntity>();
	
	private String label;
	
	public Pie(String string){
		this.label = string;
	}
	
	public void addEntity(PieEntity e){
		entities.add(e);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO we ignore labels
		// TODO we ignore the sorting of entities
		if(obj instanceof Pie){
			Pie other = (Pie) obj;
			if(this.getEntities().size()!=other.getEntities().size()){
				return false;
			}else{
				List<PieEntity> thisClone = new ArrayList<PieEntity>();
				Collections.copy(thisClone, this.getEntities());
				List<PieEntity> otherClone = new ArrayList<PieEntity>();
				Collections.copy(otherClone, other.getEntities());
				Collections.sort(thisClone);
				Collections.sort(otherClone);
				for(int i=0; i<thisClone.size(); i++){
					if(thisClone.get(i).equals(otherClone.get(i))){
						//continue
					}else{
						return false;
					}
				}
				return true;
			}
		}else{
			return false;
		}
	}
	
	private Collection<PieEntity> getAggregatedPie(int maxCount) {
		ArrayList<PieEntity> newEntities = new ArrayList<PieEntity>();
		int i; double sum = 0;
		for (i=entities.size()-1; i >= entities.size() - maxCount; i--) {
			newEntities.add(entities.get(i));
			sum += entities.get(i).getValue();
		}
		double remaining = 0;
		for (; i >= 0; i--)
			remaining += entities.get(i).getValue();
		sum += remaining;
		DecimalFormat df = new DecimalFormat("#0.0", new DecimalFormatSymbols(Locale.US));
		newEntities.add(new PieEntity(remaining, "Other ("+df.format(remaining * 100.0 / sum)+"%)"));
		Collections.sort(newEntities);
		return newEntities;
	}

	public ArrayList<PieEntity> getEntities() {
		return entities;
	}

	public Collection<PieEntity> getEntities(int maxCount){
		Collections.sort(entities);
		if (entities.size() > maxCount && maxCount > 0) {
			return getAggregatedPie(maxCount);
		}
		return entities;
	}

	public String getLabel() {
		return label;
	}
}
