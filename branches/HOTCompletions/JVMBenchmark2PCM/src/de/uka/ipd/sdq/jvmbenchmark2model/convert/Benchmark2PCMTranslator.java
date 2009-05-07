package de.uka.ipd.sdq.jvmbenchmark2model.convert;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;

import de.uka.ipd.sdq.jvmbenchmark2model.Activator;
import de.uka.ipd.sdq.jvmbenchmark2model.pcm.JvmBenchmark2ModelRepository;
import de.uka.ipd.sdq.jvmbenchmark2model.preferences.JvmBenchmark2ModelPreferences;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

public class Benchmark2PCMTranslator {
	
	private static Logger logger = Logger.getLogger(Benchmark2PCMTranslator.class);
	
	public static void main(String[] args) {
		logger.info("Creating repository...");
		JvmBenchmark2ModelRepository jvmBenchmark2ModelRepository = new JvmBenchmark2ModelRepository();
		jvmBenchmark2ModelRepository.createJvmComponent("TestJvmComponent");
		URI fullPath = getSerializationPath();
		try {
			jvmBenchmark2ModelRepository.save(fullPath, "JVM");
		} catch (IOException e) {
			logger.error("Failed to save repository.");
			e.printStackTrace();
			return;
		}
		logger.info("Repository saved successfully.");
		
	}
		
	/**
	 * Helper method to find the output location where the repository should be
	 * written.
	 * <p>
	 * The user set preferences are consulted first. If they are not set, the
	 * file is written to the project's root in the workspace directory.
	 * </p>
	 * 
	 * @return the path, including the file name, where to save the repository
	 */
	private static URI getSerializationPath() {
		String baseDir = null;
		boolean pathNotSet = true;
		//IPreferenceStore prefs = Activator.getDefault().getPreferenceStore();
		//IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		//String workspacePath = root.getLocationURI().getPath();
		//baseDir = prefs.getString(JvmBenchmark2ModelPreferences.repositoryOutputDir);
		//pathNotSet = baseDir.equals("");
		String workspacePath = "C:/pcm_dev_workspace/jvmbenchmark2model";
		if (pathNotSet) {
			baseDir = workspacePath;
		}
		System.err.println(baseDir);
		URI uri = URI.createFileURI(baseDir);
		
		uri = uri.appendSegment("default");
		return uri;
	}

}
