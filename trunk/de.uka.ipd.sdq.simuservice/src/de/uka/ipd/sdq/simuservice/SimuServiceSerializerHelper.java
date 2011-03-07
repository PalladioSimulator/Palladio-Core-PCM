package de.uka.ipd.sdq.simuservice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IProject;

import de.uka.ipd.sdq.simuservice.types.SimuServiceParams;

/**
 * Helper for SimuService. Eases access to the models.
 * 
 * @author kuester, brosch, daniel.patejdl
 * 
 */
public class SimuServiceSerializerHelper {

	private IProject project;
	private SimuServiceParams params;

	private File allocationFile;
	private File usageFile;

	/**
	 * Retrieves the target allocation file.
	 * 
	 * @return the target allocation file
	 */
	public File getAllocationFile() {
		return allocationFile;
	}

	/**
	 * Retrieves the target usage file.
	 * 
	 * @return the target usage file
	 */
	public File getUsageFile() {
		return usageFile;
	}

	/**
	 * Initializes the helper class.
	 * 
	 * @param project
	 *            The Eclipse runtime project where the deserialized models will
	 *            be stored.
	 * @param params
	 *            The {@link SimuServiceParams} reference describing what is
	 *            passed to the simu server.
	 */
	public SimuServiceSerializerHelper(IProject project,
			SimuServiceParams params) {
		this.project = project;
		this.params = params;
		this.allocationFile = null;
		this.usageFile = null;
	}

	/**
	 * Writes all model files into the Eclipse runtime project.
	 * 
	 * @throws IOException
	 *             indicates a file write error
	 */
	public void deserializeModelFiles() throws IOException {
		String projectLocation = project.getLocation().toOSString()
			+ System.getProperty("file.separator");

		String[] repositoryModelFileNames = params.getRepositoryModelFileNames();
		String[] repositoryModelXMIs = params.getRepositoryModelXMIs();

		assert(repositoryModelFileNames.length == repositoryModelXMIs.length);	// we require for each file
																				// some content to be written
		for (int i = 0; i < repositoryModelFileNames.length; i++) {
			writeToFile(projectLocation + repositoryModelFileNames[i], repositoryModelXMIs[i]);
		}

		writeToFile(project.getLocation().toOSString() + System.getProperty("file.separator")
				+ params.getSystemModelFileName(), params.getSystemModelXMI());

		writeToFile(project.getLocation().toOSString() + System.getProperty("file.separator")
				+ params.getResourceEnvironmentFileName(), params.getResourceEnvironmentModelXMI());

		allocationFile = writeToFile(project.getLocation().toOSString() + System.getProperty("file.separator")
				+ params.getAllocationModelFileName(), params.getAllocationModelXMI());

		usageFile = writeToFile(project.getLocation().toOSString() + System.getProperty("file.separator")
				+ params.getUsageModelFileName(), params.getUsageModelXMI());
	}

	/**
	 * Writes a string into a file.
	 * 
	 * @param path
	 *            the path of the file to create
	 * @param contents
	 *            the contents to write
	 * @return a File object that points to the created file
	 * @throws IOException
	 *             indicates a file write error
	 */
	private File writeToFile(String path, String contents) throws IOException {
		File file = new File(path);
		assert (!file.exists());
		FileWriter writer = new FileWriter(file);
		writer.write(contents);
		writer.close();
		return file;
	}
}
