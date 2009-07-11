package org.somox.metrics.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.somox.metrics.Abstractness;
import org.somox.metrics.Coupling;
import org.somox.metrics.DMS;
import org.somox.metrics.Instability;
import org.somox.metrics.InterfaceViolation;
import org.somox.metrics.NameResemblance;
import org.somox.metrics.PackageMapping;
import org.somox.metrics.SliceLayerArchitectureQuality;
import org.somox.metrics.SubsystemComponent;
import org.somox.metrics.init.Initialization;

import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

/**
 * @author Grischa Liebel
 * 
 * Tests all 9 Metrics from the org.somox.metrics package
 * 
 * Currently there are no assertions made in the Tests,
 * because it is not yet possible to determine which results would be correct
 * There are only some prints on the console screen which help to identify the results and possible errors
 *
 */
public class CoCoMeTests {
	
	private Abstractness abs;
	private Coupling cou;
	private DMS dms;
	private Instability ins;
	private InterfaceViolation iViol;
	private NameResemblance nameRes;
	private PackageMapping pMap;
	private SliceLayerArchitectureQuality slaq;
	private SubsystemComponent sC;
	
	private static Root root = null;
	private static List<List<GASTClass>> elements;
	private static List<GASTClass> elements1;
	private static List<GASTClass> elements2;
	
	/**
	 * The absolute or relative path to the GAST model
	 */
	private static final String modelName = "cocome.gast";
	

	/**
	 * Basic initialization of the model, resource and editingDomain
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Initialization init = new Initialization();
		URI fileURI = URI.createFileURI(new File(modelName).getAbsolutePath());
		elements = init.extractLists(fileURI);
		extractClassLists();
		root = init.getRoot();
	}
	
	@Before
	public void checkInitialization () {
		assertTrue("Root was initialized", root!=null);
		assertTrue("List1 was initialized", elements1!=null);
		assertTrue("List1 contains elements", elements1.size()>0);
		assertTrue("List2 was initialized", elements2!=null);
		assertTrue("List2 contains elements", elements2.size()>0);
	}
	
	/**
	 * Test of the abstractness metric
	 * 
	 * Computes the abstractness metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * 
	 * @throws Exception
	 */
	@Test
	public void abstractnessTest () throws Exception {
		abs = new Abstractness();

		long time1First = System.nanoTime();
		double abstractnessWithoutEMF = abs.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;

		System.out.println("Abstractness");
		System.out.println("Calculated without EMF-Query: " + abstractnessWithoutEMF + " (took: " + time1total + " ns)");
		
		//needs to be changed for different models / different lists
		//assertTrue("Abstractness result correct", abstractnessWithEMF == 0.5);
		
		System.out.println("");
	}
	
	/**
	 * Test of the coupling metric
	 * 
	 * Computes the coupling metric without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Please be aware that a blacklist needs to be set for this metric to work correct
	 * (currently the java.* Package is blacklisted)
	 * 
	 * @throws Exception
	 */
	@Test
	public void couplingTest () throws Exception {
		cou = new Coupling();
		
		HashSet<String> whitelist = new HashSet<String>();
		whitelist.add("cocome.org.*");
		cou.setWhitelist(whitelist);
		/*HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("org.junit.*");
		blacklist.add("org.apache.*");
		blacklist.add("org.netlib.*");
		blacklist.add("sun.*");
		blacklist.add("info.*");
		blacklist.add("de.*");
		blacklist.add("java.*");
		blacklist.add("javax.*");
		cou.setBlacklist(blacklist);*/

		long time1First = System.nanoTime();
		double coupling = cou.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Coupling");
		System.out.println("Calculated without EMF-Query: " + coupling + " (took: " + time1total + " ns)");
		
		//needs to be changed for different models / different lists
		//assertTrue("Coupling result correct", coupling == 0.5);
		System.out.println("");
	}
	
	/**
	 * Test of the instability metric
	 * 
	 * Computes the instability metric without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Please be aware that a blacklist needs to be set for this metric to work correct
	 * (currently the java.* Package is blacklisted)
	 * 
	 * @throws Exception
	 */
	@Test
	public void instabilityTest () throws Exception {
		ins = new Instability();
		
		HashSet<String> whitelist = new HashSet<String>();
		whitelist.add("org.cocome.*");
		ins.setBlacklist(whitelist);
		/*HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("org.junit.*");
		blacklist.add("org.apache.*");
		blacklist.add("org.netlib.*");
		blacklist.add("sun.*");
		blacklist.add("info.*");
		blacklist.add("de.*");
		blacklist.add("java.*");
		blacklist.add("javax.*");
		ins.setBlacklist(blacklist);*/

		long time1First = System.nanoTime();
		double instability = ins.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Instability");
		System.out.println("Calculated without EMF-Query: " + instability + " (took: " + time1total + " ns)");
		
		//needs to be changed for different models / different lists
		//assertTrue("Instability result correct", distanceFMS == 0.5);
		System.out.println("");
	}
	
	/**
	 * Test of the interface violation metric
	 * 
	 * Computes the interface violation metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * 
	 * @throws Exception
	 */
	@Test
	public void ifaceViolationTest () throws Exception {
		iViol = new InterfaceViolation();

		long time1First = System.nanoTime();		
		double interfaceViolation = iViol.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Interface Violation");
		System.out.println("Calculated without EMF-Query: " + interfaceViolation + " (took: " + time1total + " ns)");
		
		//needs to be changed for different models / different lists
		//assertTrue("Instability result correct", distanceFMS == 0.5);
		System.out.println("");
	}
	
	/**
	 * Test of the slaq metric
	 * 
	 * Computes the slaq metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * 
	 * @throws Exception
	 */
	@Test
	public void SLAQTest () throws Exception {
		slaq = new SliceLayerArchitectureQuality();

		long time1First = System.nanoTime();		
		double sliceLayerArchitectureQuality = slaq.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Slice Layer Architecture Quality");
		System.out.println("Calculated without EMF-Query: " + sliceLayerArchitectureQuality + " (took: " + time1total + " ns)");
		
		//needs to be changed for different models / different lists
		//assertTrue("Slice Layer Architecture Quality result correct", sliceLayerArchitectureQuality == 0.5);
		System.out.println("");
	}
	
	/**
	 * Test of the subsystemComponent metric
	 * 
	 * Computes the subsystemComponent metric without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Please be aware that a blacklist needs to be set for this metric to work correct
	 * (currently the java.* Package is blacklisted)
	 * 
	 * @throws Exception
	 */
	@Test
	public void SubsystemComponentTest () throws Exception {
		sC = new SubsystemComponent();
		
		HashSet<String> whitelist = new HashSet<String>();
		whitelist.add("cocome.org.*");
		sC.setWhitelist(whitelist);
		/*HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("org.junit.*");
		blacklist.add("org.apache.*");
		blacklist.add("org.netlib.*");
		blacklist.add("sun.*");
		blacklist.add("info.*");
		blacklist.add("de.*");
		blacklist.add("java.*");
		blacklist.add("javax.*");
		sC.setBlacklist(blacklist);*/

		long time1First = System.nanoTime();		
		double subsystemComponent = sC.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Subsystem Component");
		System.out.println("Calculated without EMF-Query: " + subsystemComponent + " (took: " + time1total + " ns)");
		
		//needs to be changed for different models / different lists
		//assertTrue("Subsystem Component result correct", subsystemComponent == 0.5);
		System.out.println("");
	}
	
	/**
	 * Test of the DMS metric
	 * 
	 * Computes the DMS metric without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Please be aware that a blacklist needs to be set for the Instability-metric used in the DMS
	 * (currently the java.* Package is blacklisted)
	 * Also, the DMS metric has a setter for the Instability and Abstractness, so that the blacklist
	 * in "Instability" can be used. Without using the Setter, an empty blacklist will be used in the DMS
	 * 
	 * @throws Exception
	 */
	@Test
	public void dmsTest () throws Exception {
		dms = new DMS();
		
		HashSet<String> whitelist = new HashSet<String>();
		whitelist.add("org.cocome.*");	
		dms.setWhitelist(whitelist);

		long time1First = System.nanoTime();
		double distanceFMS = dms.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Distance from Main Sequence");
		System.out.println("Calculated without EMF-Query: " + distanceFMS + " (took: " + time1total + " ns)");

		//needs to be changed for different models / different lists
		//assertTrue("DMS result correct", distanceFMS == 0.5);
		System.out.println("");
	}
	
	/**
	 * Test of the NameResemblance metric
	 * 
	 * Computes the NameResemblance metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Be aware that the metric has a setter for the percentage. The percentage is used to determine
	 * how much percent of 2 Strings need to be equal so that these Strings are treated to have a name resemblance 
	 * 
	 * @throws Exception
	 */
	@Test
	public void nameResemblanceTest () throws Exception {
		nameRes = new NameResemblance();
		nameRes.initialize(root);

		long time1First = System.nanoTime();
		double nameResemblance = nameRes.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Name Resemblance");
		System.out.println("Calculated without EMF-Query: " + nameResemblance + " (took: " + time1total + " ns)");

		System.out.println("");
	}
	
	/**
	 * Test of the packageMapping metric
	 * 
	 * Computes the packageMapping metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * 
	 * @throws Exception
	 */
	@Test
	public void packageMappingTest () throws Exception {
		pMap = new PackageMapping();

		long time1First = System.nanoTime();
		double packageMapping = pMap.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Package Mapping");
		System.out.println("Calculated without EMF-Query: " + packageMapping + " (took: " + time1total + " ns)");

		System.out.println("");
	}
	
	private static void extractClassLists () {
		elements1 = new LinkedList<GASTClass>();
		elements2 = new LinkedList<GASTClass>();
		
		if (elements.size() > 0) {
			int i=0;
			for (List<GASTClass> classTupel : elements) {
				for (GASTClass current : classTupel) {
					if (i<elements.size()/2) {
						elements1.add(current);
					} else {
						elements2.add(current);
					}
				}				
				i++;
			}
		}
	}
}
