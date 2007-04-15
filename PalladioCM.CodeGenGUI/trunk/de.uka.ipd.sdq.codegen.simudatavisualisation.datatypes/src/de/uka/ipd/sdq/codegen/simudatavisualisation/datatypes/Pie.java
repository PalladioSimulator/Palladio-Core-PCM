package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.util.ArrayList;
import java.util.Collection;

public class Pie {
	protected Collection<PieEntity> entities = new ArrayList<PieEntity>();
	public Pie(){
		
	}
	
	public void addEntity(PieEntity e){
		entities.add(e);
	}
	
	public Collection<PieEntity> getEntities(){
		return entities;
	}
}
