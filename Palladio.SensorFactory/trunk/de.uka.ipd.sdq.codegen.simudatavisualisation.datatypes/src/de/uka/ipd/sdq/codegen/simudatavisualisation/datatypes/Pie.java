package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.util.ArrayList;
import java.util.Collection;

public class Pie {
	protected Collection<PieEntity> entities = new ArrayList<PieEntity>();
	private String label;
	public Pie(String string){
		this.label = string;
	}
	
	public void addEntity(PieEntity e){
		entities.add(e);
	}
	
	public Collection<PieEntity> getEntities(){
		return entities;
	}
	
	public String getLabel() {
		return label;
	}
}
