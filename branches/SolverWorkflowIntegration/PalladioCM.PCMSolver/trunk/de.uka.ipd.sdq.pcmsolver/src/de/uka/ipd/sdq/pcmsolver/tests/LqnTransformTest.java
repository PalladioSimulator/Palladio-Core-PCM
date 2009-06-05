package de.uka.ipd.sdq.pcmsolver.tests;

import java.util.Properties;

import junit.framework.JUnit4TestAdapter;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcmsolver.PCMSolver;

public class LqnTransformTest {

	private Properties props = new Properties();
	
//	private static final String PATH = "D:\\Diss\\svn\\code\\" +
//			"PalladioCM.PCMSolver\\trunk\\de.uka.ipd.sdq.pcmsolver\\" +
//			"src\\de\\uka\\ipd\\sdq\\pcmsolver\\tests\\MediaStore";
	private static final String PATH = "D:\\Diss\\svn\\code\\" +
	"PalladioCM.PCMSolver\\trunk\\de.uka.ipd.sdq.pcmsolver\\" +
	"src\\de\\uka\\ipd\\sdq\\pcmsolver\\tests\\MediaStore2";

	@Before
	public void setUp(){
		props.setProperty("Filename_Allocation", PATH+"\\MediaStore.allocation");
		props.setProperty("Filename_Repository", PATH+"\\MediaStore.repository");
		props.setProperty("Filename_ResourceEnvironment", PATH+"\\MediaStore.resourceenvironment");
		props.setProperty("Filename_ResourceType", PATH+"\\MediaStore.resourcetype");
		props.setProperty("Filename_System", PATH+"\\MediaStore.system");
		props.setProperty("Filename_UsageModel", PATH+"\\MediaStore.usagemodel");
		props.setProperty("Storage_Path", PATH);
	}
	
	@Test
	public void runLqnTransform(){
		// PCMSolver solver = new PCMSolver(props);
	}
	
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(LqnTransformTest.class);
	}
}
;