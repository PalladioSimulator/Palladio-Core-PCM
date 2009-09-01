package de.fzi.stanja.sissyconnector.sissyaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;

import de.fzi.stanja.core.access.JdtHelper;
import de.fzi.stanja.core.access.StanjaConstants;
import de.fzi.stanja.sissyconnector.SissyconnectorConstants;
import de.fzi.stanja.sissyconnector.dbaccess.PostGreSqlInteractor;
import de.fzi.stanja.sissyconnector.exceptions.ExportFailedException;
import de.fzi.stanja.sissyconnector.exceptions.JDBCException;
import de.fzi.stanja.sissyconnector.preferences.PreferenceConstants;

/**
 * @author Pildner
 *
 */
/**
 * @author Pildner
 *
 */
public class SissyInteractor {
	
	
	private static final String PLUGINID_SISSY4ELIPSE_RUNNERJAR = "de.sissy4eclipse.service.sissyrun";
	private static final String PLUGINID_JDBC_POSTGRESQL = "org.postgresql.jdbc.jdbc3";
	private static final String PLUGINID_RECODER_JAR = "net.sourceforge.recoder";
	private static final String PLUGINID_SISSY_RESOURCES = "de.fzi.SISSy.jars.resources";
	private static final String PLUGINID_SISSY_JAR = "de.fzi.SISSy.jars.sissy";
	private static final String SISSY_RUN_CLASS = "de.fzi.sissy.SissyRun";
	
	private File loggingDirectory;
	
	private static final Logger logger=Logger.getLogger("SissyInteractor.class");
	private static final String PLUGIN_ID = null;
	

	/**
	 * the export command.
	 */
	private List<String> command;
	private final IPreferenceStore store = StanjaConstants.STANJA_PREFERENCE_STORE;
	
	private Process exportProcess = null;
	private Status status;
	
	
	public List<String> getCommand(){
		return this.command;
	}
	
	/**
	 * get the command as string
	 * @return
	 */
	public String getCommandString(){
		String commandString = new String();
		for (String string : this.command){
			commandString += (string+" "); 
		}
		return commandString;
	}
	
	public void testExport() throws ExportFailedException, JDBCException, IOException{
		this.prepareExport();
		this.runExport();
	}
	
	

	private void afterExport() {
		
	}

	private void runExport() throws IOException {
		System.out.println("Run Export");
		this.exportProcess = this.startExportProcess(this.command);
		this.exportProcess = null;
		System.out.println("Run Export");
	}

	private Process startExportProcess(List<String> command) throws IOException {
		ProcessBuilder builder = new ProcessBuilder(command);
		builder.redirectErrorStream(true);
		//builder.directory(this.getWorkspacePathAsFile());
		System.out.println(command.toString());
		return builder.start();
	}

	private File getWorkspacePathAsFile() {
		return new File(JdtHelper.getWorkspaceRoot().getLocation().toOSString());
	}

	
	/**
	 * this function take care that the command parameters are ok
	 * @throws ExportFailedException 
	 * @throws JDBCException 
	 */
	protected void prepareExport() throws ExportFailedException, JDBCException{
		/*create the command*/
		List<String> command = new ArrayList<String>();
		boolean serverJVMAvailable = this.isServerJVMAvailable();
		this.appendStartArguments(command, serverJVMAvailable);
		this.appendSissyArguments(command);
		this.command = command;
		String output = new String();
		for (String string : command){
			output += string+" "; 
		}
		System.out.println(output);
		
		/*get the PostGreSQLInteractor singleton*/
		PostGreSqlInteractor dbInteractor = PostGreSqlInteractor.getInstance();
		/*open the connection to the database */
		dbInteractor.openConnection();
		dbInteractor.flushDatabase();
		
	}
	
	private void appendSissyArguments(List<String> command) {
		this.appendJavaProgrammingLanguageArguments(command);
		/*append runner class*/
		command.add("-runnerclass");
		command.add(SISSY_RUN_CLASS);
		this.appendExportArguments(command);
	}

	private void appendExportArguments(List<String> command) {
		command.add("-export");
		//TODO make connection to preferences
		command.add("-db");
		command.add(store.getString(PreferenceConstants.P_DB_NAME);
		command.add("-u");
		command.add(store.getString(PreferenceConstants.P_DB_LOGIN);
		command.add("-pw");
		command.add(SissyconnectorConstants.TEST_DB_PASSWORD);
		command.add("-drv");
		command.add(SissyconnectorConstants.PGSQL_DRIVER);
		command.add("-url");
		command.add(SissyconnectorConstants.TEST_DB_URL);
//		command.add("-iscr");
//		command.add(dbProvider.getPathToInitScript());
//		command.add("-escr");
//		command.add(dbProvider.getPathToEmptyScript());
	}
	
	
		

	private void appendJavaProgrammingLanguageArguments(List<String> command) {
		command.add("-java");
		this.appendProjectsSourceFolders(command);
		this.appendJavaLibraries(command);
		this.appentJavaArguments(command);
				
	}

	/**
	 * DONE get all the source folders from the given projects
	 * TODO get the folders only from the project selected in preferences
	 * @param command
	 */
	void appendProjectsSourceFolders(List<String> command) {
		List<String> sourceFolders = JdtHelper.extractSourceFoldersFromAllJavaProjects();
		command.add(this.composeToString(sourceFolders));
	}
	
	
	/**
	 * create a String out of the List
	 * @param strings
	 * @return
	 */
	private String composeToString(List<String> strings) {
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < strings.size(); ++index) {
			builder.append(strings.get(index));
			if (index != strings.size() - 1) {
				builder.append(java.io.File.pathSeparator);
			}
		}
		return builder.toString();
	}

	/**
	 * append all the library paths from the selected projects to the sissy command arguments
	 * TODO select the projects listed in the preferences
	 * @param command
	 */
	private void appendJavaLibraries(List<String> command) {
		List<String> projectsNameList = JdtHelper.getProjectNameListFromWorkspace();
		List<String> libraryPaths =  JdtHelper.extractRequiredJavaLibraries(projectsNameList);
		if (!libraryPaths.isEmpty()) {
			command.add("-libbin");
			command.add(this.composeToString(libraryPaths));
		}
	}
	
	/**
	 * read the java source level in eclipse workspace 
	 * TODO read value from workspace
	 * @param command
	 */
	private void appentJavaArguments(List<String> command) {
		String javaSourceLevel = JdtHelper.getCompilerJavaSourceLevel();
		command.add("-source");
		command.add(javaSourceLevel);
		
	}


	
	

	private void appendStartArguments(List<String> command,	boolean serverJVMAvailable) throws ExportFailedException {
		command.add("java");
		if (serverJVMAvailable) {
			//command.add("-server");
		}
		command.add("-Xmx800m");
		command.add("-Xms800m");
		this.appendClasspath(command);
		command.add("de.fzi.sissy.Main");		
	}

	private void appendClasspath(List<String> command) throws ExportFailedException {
		command.add("-classpath");
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getPathToJarInPlugin(PLUGINID_SISSY_JAR, "sissy.jar",	true));
		System.out.println(this.getPathToJarInPlugin(PLUGINID_SISSY_JAR,	"sissy.jar", true));
		buffer.append(this.getPathToJarInPlugin(PLUGINID_SISSY_RESOURCES,	"resources.jar", true));
		System.out.println(this.getPathToJarInPlugin(PLUGINID_SISSY_RESOURCES, "resources.jar", true));
		buffer.append(this.getPathToJarInPlugin(PLUGINID_RECODER_JAR,	"recoder.jar", true));
		System.out.println(this.getPathToJarInPlugin(PLUGINID_RECODER_JAR,	"recoder.jar", true));
		buffer.append(this.getPathToJarInPlugin(PLUGINID_SISSY4ELIPSE_RUNNERJAR, "SissyRun.jar", true));
		System.out.println(this.getPathToJarInPlugin(PLUGINID_SISSY4ELIPSE_RUNNERJAR, "SissyRun.jar", true));
		buffer.append(this.getPathTwhat,kind,bundleId,bundleVersion,description,time
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726757770
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758270
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758302
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758333
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758364
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758395
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758427
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758458
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758489
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758536
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758567
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758598
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758630
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758661
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758692
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758723
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726758989
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726759145
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726759286
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726759458
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726759708
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726759911
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726760645
executed,command,org.eclipse.ui,3.5.0.I20090604-2000,"org.eclipse.ui.edit.delete",1251726812366
executed,command,org.ecli