/**
 *
 */
package de.fzi.se.quality.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**Class with helper function for EMF processing.
 *
 * @author groenda
 */
public class EMFHelper {

	/**Gets the first object of a given type from a list.
	 * @param <T> Type of the Object.
	 * @param collection List of objects.
	 * @param c Class of the requested object.
	 * @return The first object in the list of the given type.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getFirstObjectByType(List<?> collection, Class<T> c) {
		Iterator<?> i = collection.iterator();
		Object o = null;
		while ((o = i.next()) != null) {
			if (c.isAssignableFrom(o.getClass()))
				break;
		}
		return (T) o;
	}

	/**Gets all objects of a given type from a list.
	 * @param <T> Type of the Object.
	 * @param collection List of objects.
	 * @param c Class of the requested object.
	 * @return The first object in the list of the given type.
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getObjectsByType(List<?> collection, Class<T> c) {
		List<T> list = new ArrayList<T>();
		Iterator<?> i = collection.iterator();
		Object o = null;
		while (i.hasNext()) {
			o = i.next();
			if (c.isAssignableFrom(o.getClass())) {
				list.add((T) o);
			}
		}
		return Collections.unmodifiableList(list);
	}

}
