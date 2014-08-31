package org.palladiosimulator.protocom.framework.java.ee.prototype;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Christian Klaussner
 */
public class ClassHelper {

	/**
	 *
	 * @param classFile
	 * @param packageName
	 * @return
	 */
	private static Class<?> classForFile(String classFile, String packageName) {
		String className = classFile.substring(0, classFile.lastIndexOf('.'));

		try {
			return Class.forName(packageName + "." + className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * @param packageName
	 * @return
	 */
	public static Class<?>[] getClassesInPackage(String packageName) {
		List<Class<?>> result = new LinkedList<Class<?>>();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		try {
			Enumeration<URL> resources = classLoader.getResources("/" + packageName);

			if (resources.hasMoreElements()) {
				File folder = new File(resources.nextElement().getFile());

				for (File file : folder.listFiles()) {
					if (file.isFile()) {
						result.add(classForFile(file.getName(), packageName));
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return result.toArray(new Class<?>[0]);
	}
}
