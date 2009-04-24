package org.somox.softwareextractor.sissy;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Preferences;
import org.somox.common.SoMoXProjectPreferences;
import org.somox.configuration.ConfigurationDefinition;
import org.somox.core.SoMoXCoreLogger;
import org.somox.extractor.ArtifactWrapper;
import org.somox.extractor.ExtractionResult;

import de.fzi.sissy.Main;
import de.fzi.sissy.metamod.ModelElementRepository;

/**
 * Software Extractor taking use of the SISSy framework
 *
 * @author Benjamin Klatt
 *
 */
public class SISSySoftwareExtractor implements
		org.somox.extractor.SoftwareExtractor {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	/** Identifier for the sissy argument string */
	private static String CONFIGURATION_ID_SISSYARGUMENTS = "org.somox.softwareextractor.sissy.arguments";

	/** The base directory to run sissy from */
	//private static String CONFIGURATION_ID_DIRECTORY = "org.somox.softwareextractor.sissy.directory";
	
	/** The name of the sissy output file */
	private static String CONFIGURATION_ID_OUTPUTFILE = "org.somox.softwareextractor.sissy.outputfile";

	/** The type of source code sissy should analyze */
	private static String CONFIGURATION_ID_SOURCETYPE = "org.somox.softwareextractor.sissy.sourcetype";

	/** The java version of the software to analyze */
	private static String CONFIGURATION_ID_SOURCEVERSION = "org.somox.softwareextractor.sissy.sourceversion";
	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The list of artifact wrappers resulting from the extraction process */
	private List<ArtifactWrapper> artifactWrapper = new LinkedList<ArtifactWrapper>();

	// ---------------------------------
	// Constructor
	// ---------------------------------

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	@Override
	public ExtractionResult runExtraction(String extractorId, Preferences preferences) {
		SoMoXCoreLogger.logInfo("SISSy Software Extractor Started");


		// build the configuration String
		LinkedList<String> paramList = new LinkedList<String>();
		paramList.add("-"+preferences.getString(CONFIGURATION_ID_SOURCETYPE));
		paramList.add(preferences.getString(SoMoXProjectPreferences.PREFERENCES_SOURCE_DIRECTORY));
		paramList.add("-source");
		paramList.add(preferences.getString(CONFIGURATION_ID_SOURCEVERSION));
		//TODO add and test additional arguments
//		String sissyArguments = preferences.getString(CONFIGURATION_ID_SISSYARGUMENTS);
//		String[] additionalArguments = sissyArguments.split(" ");
//		paramList.addAll(Arrays.asList(additionalArguments));

		String[] parameters = (String[]) paramList.toArray(new String[paramList.size()]);
		SoMoXCoreLogger.logInfo("SISSy Software Extractor configured with parameters: "+parameters);

		// run SISSy
		SoMoXCoreLogger.logInfo("SISSy Software Extractor starting");

		ModelElementRepository modelRepository = Main.runSISSy(parameters);
		
		modelRepository.serializeToFile(new File(Platform.getInstanceLocation().getURL().getFile()+preferences.getString(SoMoXProjectPreferences.SOMOX_PROJECT_NAME)+"/"+preferences.getString(CONFIGURATION_ID_OUTPUTFILE)));

		// wrap the result
		ArtifactWrapper wrapper = new SISSyModelElementRepositoryWrapper(extractorId,modelRepository);
		this.artifactWrapper.add(wrapper);

		SISSyExtractionResult result = new SISSyExtractionResult(this);
		result.setResultStatus(ExtractionResult.ResultStatus.SUCCESS);
		SoMoXCoreLogger.logInfo("SISSy Software Extractor finished");
		return result;
	}

	@Override
	public LinkedList<ConfigurationDefinition> getConfigurationDefinitions() {
		LinkedList<ConfigurationDefinition> configs = new LinkedList<ConfigurationDefinition>();

		ConfigurationDefinition outputFile = new ConfigurationDefinition(	CONFIGURATION_ID_OUTPUTFILE,
																			"The name of the output file",
																			ConfigurationDefinition.Type.STRING,
																			"");

		ConfigurationDefinition sourceType = new ConfigurationDefinition(	CONFIGURATION_ID_SOURCETYPE,
																			"The software type (java,cpp)",
																			ConfigurationDefinition.Type.STRING,
																			"java");

		ConfigurationDefinition sourceVersion = new ConfigurationDefinition(	CONFIGURATION_ID_SOURCEVERSION,
																			"The version number of the source (i.e. 1.4 or 5.0 for java)",
																			ConfigurationDefinition.Type.STRING,
																			"5.0");

		ConfigurationDefinition arguments = new ConfigurationDefinition(	CONFIGURATION_ID_SISSYARGUMENTS,
																			"Argument string for additional settings",
																			ConfigurationDefinition.Type.STRING,
																			"-java <directory> -source 5.0",
																			new LinkedList<String>(),
																			1, false);
		configs.add(outputFile);
		configs.add(sourceType);
		configs.add(sourceVersion);
		configs.add(arguments);
		return configs;
	}

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	@Override
	public List<ArtifactWrapper> getSoftwareArtefacts() {
		return this.artifactWrapper;
	}

}
