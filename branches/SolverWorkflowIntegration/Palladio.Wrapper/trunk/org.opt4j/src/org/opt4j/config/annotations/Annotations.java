/** Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */
package org.opt4j.config.annotations;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Annotations} delivers some basic methods for working with
 * annotations.
 * 
 * @author lukasiewycz
 * 
 */
public class Annotations {

	/**
	 * The {@code Info} contains information of one annotation
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public static class Info {
		private final Annotation annotation;
		private final int depth;
		private final Class<?> clazz;

		public Info(Annotation annotation, int depth, Class<?> clazz) {
			super();
			this.annotation = annotation;
			this.depth = depth;
			this.clazz = clazz;
		}

		/**
		 * Returns the depth.
		 * 
		 * @return the depth
		 */
		public int getDepth() {
			return depth;
		}

		/**
		 * Returns the class.
		 * 
		 * @return the class
		 */
		public Class<?> getClazz() {
			return clazz;
		}

		/**
		 * Returns the annotation.
		 * 
		 * @return the annotation
		 */
		public Annotation getAnnotation() {
			return annotation;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return annotation.annotationType() + " " + annotation + " "
					+ clazz.getName() + " " + depth;
		}

	}

	/**
	 * Returns all Annotation classes.
	 * 
	 * @param clazz
	 *            the class to search
	 * @return all Annotation classes
	 */
	public static Collection<Class<? extends Annotation>> getAnnotationClasses(
			Class<?> clazz) {
		Collection<Info> collection = getInfo(clazz);
		Collection<Class<? extends Annotation>> annotations = new ArrayList<Class<? extends Annotation>>();
		for (Info info : collection) {
			annotations.add(info.getAnnotation().annotationType());
		}
		return annotations;
	}

	/**
	 * Returns all Annotations.
	 * 
	 * @param clazz
	 *            the class to search
	 * @return all Annotations
	 */
	public static Collection<Annotation> getAnnotations(Class<?> clazz) {
		Collection<Info> collection = getInfo(clazz);
		Collection<Annotation> annotations = new ArrayList<Annotation>();
		for (Info info : collection) {
			annotations.add(info.getAnnotation());
		}
		return annotations;
	}

	/**
	 * Returns all annotation informations.
	 * 
	 * @param clazz
	 *            the class
	 * @return the annotation informations
	 */
	public static Collection<Info> getInfo(Class<?> clazz) {
		return getInfo(clazz, 0);
	}

	/**
	 * Returns a map of annotations to annotation information. Removes multiple
	 * occurrences of annotation classes based on the depth value.
	 * 
	 * @param clazz
	 *            the class
	 * @return the unique map
	 */
	public static Map<Class<? extends Annotation>, Info> getUniques(
			Class<?> clazz) {
		Map<Class<? extends Annotation>, Info> map = getUniques(clazz, true);
		return map;
	}

	/**
	 * Returns a map of annotations to annotation information. Removes multiple
	 * occurrences of annotation classes based on the depth value.
	 * 
	 * @param clazz
	 *            the class
	 * @param includeCurrent
	 *            include the current class to the search
	 * @return the map of the annotation classes to their info
	 */
	public static Map<Class<? extends Annotation>, Info> getUniques(
			Class<?> clazz, boolean includeCurrent) {
		Collection<Info> collection = getInfo(clazz);
		if (!includeCurrent) {
			Collection<Info> removes = new ArrayList<Info>();
			for (Info info : collection) {
				if (info.getClazz().equals(clazz)) {
					removes.add(info);
				}
			}
			collection.removeAll(removes);
		}
		Map<Class<? extends Annotation>, Info> map = new HashMap<Class<? extends Annotation>, Info>();

		for (Info info : collection) {
			Class<? extends Annotation> c = info.getAnnotation()
					.annotationType();

			if (map.containsKey(c)) {
				Info i = map.get(c);
				if (i.getDepth() > info.getDepth()) {
					map.put(c, info);
				}
			} else {
				map.put(c, info);
			}
		}
		return map;
	}

	protected static Collection<Info> getInfo(Class<?> clazz, int depth) {
		Collection<Info> collection = new ArrayList<Info>();
		if (depth == 10) {
			return collection;
		}

		if (clazz != null && !clazz.equals(Object.class)) {
			for (Annotation annotation : clazz.getAnnotations()) {
				Info info = new Info(annotation, depth, clazz);
				collection.add(info);
			}
			collection.addAll(getInfo(clazz.getSuperclass(), depth + 1));

			for (Class<?> inf : clazz.getInterfaces()) {
				collection.addAll(getInfo(inf, depth + 1));
			}
		}

		return collection;
	}
}
