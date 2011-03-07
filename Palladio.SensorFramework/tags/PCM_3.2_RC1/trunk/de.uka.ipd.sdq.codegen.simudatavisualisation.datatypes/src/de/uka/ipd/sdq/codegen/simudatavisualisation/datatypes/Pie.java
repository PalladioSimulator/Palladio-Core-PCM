package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

public class Pie {
	protected ArrayList<PieEntity> entities = new ArrayList<PieEntity>();
	private String label;
	public Pie(String string){
		this.label = string;
	}
	
	public void addEntity(PieEntity e){
		entities.add(e);
	}
	
	public Collection<PieEntity> getEntities(int maxCount){
		Collections.sort(entities);
		if (entities.size() > maxCount && maxCount > 0) {
			return getAggregatedPie(maxCount);
		}
		return entities;
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

	public String getLabel() {
		return label;
	}
}
