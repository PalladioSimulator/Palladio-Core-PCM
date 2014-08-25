package org.palladiosimulator.protocom.framework.java.ee.storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author Christian Klaussner
 */
public interface IStorage {

	/**
	 *
	 * @param path
	 * @throws IOException
	 */
	void createFolder(String path) throws IOException;

	/**
	 *
	 * @param path
	 * @param data
	 */
	void writeFile(String path, byte[] data) throws IOException;

	/**
	 *
	 * @param path
	 * @param data
	 */
	void writeFile(String path, String data) throws IOException;

	/**
	 *
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	byte[] readFile(String path) throws FileNotFoundException;

	/**
	 *
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	String readFileAsString(String path) throws FileNotFoundException;

	/**
	 *
	 * @param path
	 * @throws IOException
	 */
	Set<String> getFiles(String path) throws IOException;

	/**
	 *
	 * @param path
	 * @throws IOException
	 */
	void deleteFile(String path);
}
