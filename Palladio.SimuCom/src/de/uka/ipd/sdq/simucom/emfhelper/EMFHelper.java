package de.uka.ipd.sdq.simucom.emfhelper;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

public class EMFHelper {
	
	@SuppressWarnings("unchecked")
	public static Object getObjectByType(EList collection, Class c) {
		Iterator i = collection.iterator();
		Object o = null;
		while ((o = i.next()) != null) {
			if (c.isAssignableFrom(o.getClass()))
				break;
		}
		return o;
	}
}
