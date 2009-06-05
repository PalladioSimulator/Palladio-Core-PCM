package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

import java.util.Collection;
import java.util.Iterator;

import com.db4o.ObjectContainer;
import com.db4o.config.ObjectTranslator;

public class PersistedLinkedListTranslator implements ObjectTranslator {
	
	public Object onStore(ObjectContainer con, Object object){
		MyList col = (MyList)object;
		Object[] elements = new Object[2];
		elements[0] = col.getHeadID();
		elements[1] = col.getLast();
		return elements;
	}

	public void onActivate(ObjectContainer con, Object object, Object members){
		MyList col = (MyList)object;
		Object[] elements = (Object[]) members;
		col.setHeadID((Long)elements[0]);
		col.setLast((ListElement)elements[1]);
		col.objectOnActivate(con);
	}

	public Class storedClass(){
		return Object[].class;
	}
}