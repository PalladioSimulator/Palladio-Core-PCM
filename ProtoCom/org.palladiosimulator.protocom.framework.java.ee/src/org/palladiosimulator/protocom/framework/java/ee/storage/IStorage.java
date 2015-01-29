package org.palladiosimulator.protocom.framework.java.ee.storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

/**
 * Classes implementing the IStorage interface provide methods for file persistence.
 * @author Christian Klaussner
 */
public interface IStorage {
	/**
	 * Creates a folder.
	 * @param path the path of the new folder
	 * @throws IOException if an error occurred while accessing the storage
	 */
	void createFolder(String path) throws IOException;

	/**
	 * Writes data to the specified file. The file will be overwritten if it already exists.
	 * @param path the destination path
	 * @param data a byte array containing the data to write
	 * @throws IOException if an error occurred while accessing the storage
	 */
	void writeFile(String path, byte[] data) throws IOException;

	/**
	 * Writes data to the specified file. The file will be overwritten if it already exists.
	 * @param path the destination path
	 * @param data a string containing the data to write
	 * @throws IOException if an error occurred while accessing the storage
	 */
	void writeFile(String path, String data) throws IOException;

	/**
	 * Reads the content of the specified file.
	 * @param path the path to the file whose content will be read
	 * @return a byte array containing the file content
	 * @throws FileNotFoundException if the file could not be found
	 */
	byte[] readFile(String path) throws FileNotFoundException;

	/**
	 * Reads the content of the specified file.
	 * @param path the path to the file whose content will be read
	 * @return a string containing the file content
	 * @throws FileNotFoundException if the file could not be found
	 */
	String readFileAsString(String path) throws FileNotFoundException;

	/**
	 * Gets the files and folders contained in the specified folder.
	 * @param path the path whose files and folders will be returned
	 * @return a set of file and folder names
	 * @throws IOException if an error occurred while accessing the storage
	 */
	Set<String> getFiles(String path) throws IOException;

	/**
	 * Deletes the specified file or folder.
	 * @param path the file or folder to delete
	 * @throws IOException if an error occurred while accessing the storage
	 */
	void deleteFile(String path);
	// TODO: Add recursive deletion

	/**
	 * Checks whether the specified path points to a folder.
	 * @param path the path to check
	 * @return true if the path points to a folder, otherwise false
	 */
	boolean isFolder(String path);

	/**
	 * Checks whether the specified path points to an existing file or folder.
	 * @param path the path to check
	 * @return true if the file or folder exists, otherwise false
	 */
	boolean fileExists(String path);
}
