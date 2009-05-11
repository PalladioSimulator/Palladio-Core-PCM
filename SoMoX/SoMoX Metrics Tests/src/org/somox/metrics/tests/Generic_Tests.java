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

import de.fzi.gast.core.ModelElement;
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
public class Generic_Tests {
	
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
	private static List<ModelElement> elements1;
	private static List<ModelElement> elements2;
	
	private static final String modelPath = "grischatest.gast";
	

	/**
	 * Basic initialization of the model, resource and editingDomain
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Initialization init = new Initialization();
		URI fileURI = URI.createFileURI(new File(modelPath).getAbsolutePath());
		elements = init.extractLists(fileURI);
		root = init.getRoot();
	}
	
	@Before
	public void checkInitialization () {
		assertTrue("Root was initialized", root!=null);
		assertTrue("Elements is not null", elements!=null);
		
		//reset element lists
		elements1 = new LinkedList<ModelElement>();
		elements2 = new LinkedList<ModelElement>();
	}
	
	
	/**
	 * "Standart" test scheme:
	 * - The two lists "elements1" and "elements2" are configured, 
	 *   i.e. the wanted classes are added to the lists
	 * - The relevant metric calculations for this list configuration are called
	 * - The results returned by the metric-calculations are tested for correctness with assertTrue()-statements
	 * 
	 * @throws Exception
	 */
	@Test
	public void someTest () throws Exception {		
		if (elements != null) {
			
			//elements are extracted based on the test case
			//   in this example case i only want to have the Classes "MyLayer1Interface"
			//   and "MyLayer1Class2" and their inner classes in the class list "elements1"
			//The second class list, "elements2", is left empty in this case
			//(Be aware that the class lists are newly initialized before every test case
			//with the "@Before"-notated method, so they're empty)
			for (List<GASTClass> currentClassList : elements) {
				for (GASTClass currentClassInClassList : currentClassList) {
					if (currentClassInClassList.getSimpleName().equals("MyLayer1Interface") || currentClassInClassList.getSimpleName().equals("MyLayer1Class2")){
						elements1.addAll(currentClassList);
						break;
					}
				}
			}
			
			//relevant metrics for the current testcase are calculated
			double abstractness = abstractnessTest();
			
			//results are tested
			assertTrue("Abstractness result correct", 0.5 - abstractness < 0.000000001);
			
		}
	}
	
	/**
	 * Computes the abstractness metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 */
	public double abstractnessTest () {
		abs = new Abstractness();

		long time1First = System.nanoTime();
		double abstractnessWithEMF = abs.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		
		long time2First = System.nanoTime();
		double abstractnessWithoutEMF = abs.computeWithOutEMF(root, elements1, elements2);
		long time2total = System.nanoTime()-time2First;
		
		System.out.println("Abstractness");
		System.out.println("Calculated with EMF-Query: " + abstractnessWithEMF + " (took: " + time1total + " ns)");
		System.out.println("Calculated without EMF-Query: " + abstractnessWithoutEMF + " (took: " + time2total + " ns)");
		
		System.out.println("");
		
		return abstractnessWithoutEMF;
	}
	
	/**
	 * Computes the coupling metric without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Please be aware that a blacklist needs to be set for this metric to work correct
	 * (currently the java.* Package is blacklisted)
	 */
	public double couplingTest () {
		cou = new Coupling();
		
		HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("java.*");
		cou.setBlacklist(blacklist);

		long time1First = System.nanoTime();
		double coupling = cou.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Coupling");
		System.out.println("Calculated without EMF-Query: " + coupling + " (took: " + time1total + " ns)");
		
		System.out.println("");
		
		return coupling;
	}
	
	/**
	 * Computes the instability metric without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Please be aware that a blacklist needs to be set for this metric to work correct
	 * (currently the java.* Package is blacklisted)
	 */
	public double instabilityTest () {
		ins = new Instability();
		
		HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("java.*");
		ins.setBlacklist(blacklist);

		long time1First = System.nanoTime();
		double instability = ins.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Instability");
		System.out.println("Calculated without EMF-Query: " + instability + " (took: " + time1total + " ns)");
		
		System.out.println("");
		
		return instability;
	}
	
	/**
	 * Computes the interface violation metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 */
	public double ifaceViolationTest () {
		iViol = new InterfaceViolation();

		long time1First = System.nanoTime();		
		double interfaceViolation = iViol.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Interface Violation");
		System.out.println("Calculated without EMF-Query: " + interfaceViolation + " (took: " + time1total + " ns)");
		System.out.println("");
		
		return interfaceViolation;
	}
	
	/**
	 * Computes the slaq metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 */
	public double SLAQTest () {
		slaq = new SliceLayerArchitectureQuality();

		long time1First = System.nanoTime();		
		double sliceLayerArchitectureQuality = slaq.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Slice Layer Architecture Quality");
		System.out.println("Calculated without EMF-Query: " + sliceLayerArchitectureQuality + " (took: " + time1total + " ns)");
		System.out.println("");
		
		return sliceLayerArchitectureQuality;
	}
	
	/**
	 * Computes the subsystemComponent metric without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Please be aware that a blacklist needs to be set for this metric to work correct
	 * (currently the java.* Package is blacklisted)
	 */
	public double SubsystemComponentTest () {
		sC = new SubsystemComponent();
		
		HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("java.*");
		sC.setBlacklist(blacklist);

		long time1First = System.nanoTime();		
		double subsystemComponent = sC.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Subsystem Component");
		System.out.println("Calculated without EMF-Query: " + subsystemComponent + " (took: " + time1total + " ns)");
		System.out.println("");
		
		return subsystemComponent;
	}
	
	/**
	 * Computes the DMS metric without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Please be aware that a blacklist needs to be set for the Instability-metric used in the DMS
	 * (currently the java.* Package is blacklisted)
	 * Also, the DMS metric has a setter for the Instability and Abstractness, so that the blacklist
	 * in "Instability" can be used. Without using the Setter, an empty blacklist will be used in the DMS
	 */
	public double dmsTest () {
		ins = new Instability();
		dms = new DMS();
		
		HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("java.*");
		ins.setBlacklist(blacklist);
		
		dms.setInstability(ins);

		long time1First = System.nanoTime();
		double distanceFMS = dms.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Distance from Main Sequence");
		System.out.println("Calculated without EMF-Query: " + distanceFMS + " (took: " + time1total + " ns)");
		System.out.println("");
		
		return distanceFMS;
	}
	
	/**
	 * Computes the NameResemblance metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 * Be aware that the metric has a setter for the percentage. The percentage is used to determine
	 * how much percent of 2 Strings need to be equal so that these Strings are treated to have a name resemblance 
	 */
	public double nameResemblanceTest () {
		nameRes = new NameResemblance();

		long time1First = System.nanoTime();
		
		//last parameter = percentage needs to be changed manually
		nameRes.setPercentage(50);
		double nameResemblance = nameRes.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Name Resemblance");
		System.out.println("Calculated without EMF-Query: " + nameResemblance + " (took: " + time1total + " ns)");
		System.out.println("");
		
		return nameResemblance;
	}
	
	/**
	 * Computes the packageMapping metric with and without EMF-Query and prints the results to the Screen,
	 * including the accurate time of the calculations
	 */
	public double packageMappingTest () {
		pMap = new PackageMapping();

		long time1First = System.nanoTime();
		double packageMapping = pMap.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Package Mapping");
		System.out.println("Calculated without EMF-Query: " + packageMapping + " (took: " + time1total + " ns)");
		System.out.println("");
		
		return packageMapping;
	}
}
