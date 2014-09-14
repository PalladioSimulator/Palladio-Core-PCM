package org.palladiosimulator.protocom.framework.java.ee.prototype;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

import org.reflections.Reflections;

/**
 *
 * @author Christian Klaussner
 */
public class ClassHelper {

	/**
	 *
	 * @param packageName
	 * @param type
	 * @return
	 */
	public static <T> Class<?>[] getSubclasses(String packageName, Class<T> type) {
		Reflections reflections = new Reflections(packageName);
		Set<Class<? extends T>> classes = reflections.getSubTypesOf(type);

		Class<?>[] result = new Class<?>[classes.size()];
		int i = 0;

		for (Class<?> clazz : classes) {
			result[i++] = clazz;
		}

		Arrays.sort(result, new Comparator<Class<?>>() {
			@Override
			public int compare(Class<?> o1, Class<?> o2) {
				String n1 = o1.getSimpleName();
				String n2 = o2.getSimpleName();

				return n1.compareTo(n2);
			}
		});

		return result;
	}
}
