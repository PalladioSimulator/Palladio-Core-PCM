package de.fzi.stanja.sissyconnector.sissyaccess;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;

import de.fzi.stanja.core.access.JdtHelper;
import de.fzi.stanja.sissyconnector.exceptions.ExportFailedException;
import de.fzi.stanja.sissyconnector.exceptions.JDBCException;
import junit.framework.TestCase;

public class SissyAccessTest extends TestCase {
	List<String> command = new ArrayList<String>();
	SissyInteractor interactor = new SissyInteractor();
	
	
	public void testCommand() throws ExportFailedException, JDBCException{
		interactor.prepareExport();
		System.out.println("--- testCommmand ---");
		System.out.println(interactor.getCommandString());
	}

	/**
	 *  test the output of the function SissyInteractor.appendProjects();
	 */
	public void testHelperGetSourceFiles(){
		
		interactor.appendProjectsSourceFolders(command);
		String mystring = new String();
		for(String string : command){
			mystring += string;
		}
		System.out.println("--- testHelperGetSourceFiles ---");
		System.out.println(mystring);
	}
	
	public void testHelperGetAnalyzerObjectList(){
		List<String> analyzerList = JdtHelper.getAllAnalyzersNameListFromExtentions();
		System.out.println("--- testHelperGetAnalyzerObjectList ---");
		System.out.println(analyzerList.toString());
	}
	public void testHelperGetProjectNameArrayFromWorkspace(){
		List<String> projects = JdtHelper.getProjectNameListFromWorkspace();
		System.out.println("--- testHelperGetProjectNameArrayFromWorkspace ---");
		System.out.println(projects.toString());
	}
	
	public void testJavaProjects(){
		List<String> javaProjectsName = new ArrayList<String>();
		List<IProject> projects = JdtHelper.gettAllProjectsListFromWorkspace();
		List<IJavaProject> javaProjects =  JdtHelper.filterNonJavaProjects(projects);
		for (IJavaProject project : javaProjects){
			javaProjectsName.add(project.getElementName());
		}
		System.out.println("--- testJavaProjects ---");
		System.out.println(javaProjectsName.toString());
		 
	}
	
	public void testProjectPreferences(){
		IProject[] projectArray = JdtHelper.getProjectArrayFromWorkspace();
		String output = new String();
		for (int i = 0 ; i< projectArray.length;i++){
			output += projectArray[i].getName();
		}
		System.out.println("--- testProjectPreferences ---");
		System.out.println(output);
	}
	
 	
}
