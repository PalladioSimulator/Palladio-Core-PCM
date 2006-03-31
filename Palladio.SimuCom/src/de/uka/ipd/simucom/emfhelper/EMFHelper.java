package de.uka.ipd.simucom.emfhelper;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

public class EMFHelper {
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
