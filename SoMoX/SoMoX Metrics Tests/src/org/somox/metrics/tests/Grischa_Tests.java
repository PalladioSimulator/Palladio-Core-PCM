package org.somox.metrics.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
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

import de.fzi.gast.accesses.provider.accessesItemProviderAdapterFactory;
import de.fzi.gast.annotations.provider.annotationsItemProviderAdapterFactory;
import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Package;
import de.fzi.gast.core.Root;
import de.fzi.gast.core.provider.coreItemProviderAdapterFactory;
import de.fzi.gast.functions.provider.functionsItemProviderAdapterFactory;
import de.fzi.gast.statements.provider.statementsItemProviderAdapterFactory;
import de.fzi.gast.types.GASTClass;
import de.fzi.gast.types.provider.typesItemProviderAdapterFactory;
import de.fzi.gast.variables.provider.variablesItemProviderAdapterFactory;

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
public class Grischa_Tests {
	
	private Abstractness abs;
	private Coupling cou;
	private DMS dms;
	private Instability ins;
	private InterfaceViolation iViol;
	private NameResemblance nameRes;
	private PackageMapping pMap;
	private SliceLayerArchitectureQuality slaq;
	private SubsystemComponent sC;

	private static AdapterFactoryEditingDomain editingDomain;

	private static ComposedAdapterFactory adapterFactory;
	
	private static Resource resource;
	
	private static Root root = null;
	private static List<ModelElement> elements;
	private static List<ModelElement> elements1;
	private static List<ModelElement> elements2;
	

	/**
	 * Basic initialization of the model, resource and editingDomain
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initializeEditingDomain();
		createResource(null);
		extractClassLists();
	}
	
	@Before
	public void checkInitialization () {
		assertTrue("Root was initialized", root!=null);
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
		double abstractnessWithEMF = abs.computeWithEMF(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		
		long time2First = System.nanoTime();
		double abstractnessWithoutEMF = abs.computeWithOutEMF(root, elements1, elements2);
		long time2total = System.nanoTime()-time2First;
		
		System.out.println("Abstractness");
		System.out.println("Calculated with EMF-Query: " + abstractnessWithEMF + " (took: " + time1total + " ns)");
		System.out.println("Calculated without EMF-Query: " + abstractnessWithoutEMF + " (took: " + time2total + " ns)");
		
		assertTrue("Abstractness results are equal", abstractnessWithEMF == abstractnessWithoutEMF);
		
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
		
		HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("java.*");
		cou.setBlacklist(blacklist);

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
		
		HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("java.*");
		ins.setBlacklist(blacklist);

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
		
		HashSet<String> blacklist = new HashSet<String>();
		blacklist.add("java.*");
		sC.setBlacklist(blacklist);

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

		long time1First = System.nanoTime();
		
		//last parameter = percentage needs to be changed manually
		nameRes.setPercentage(50);
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
		EList<EObject> contents =resource.getContents();
		
		elements = new LinkedList<ModelElement>();
		elements1 = new LinkedList<ModelElement>();
		elements2 = new LinkedList<ModelElement>();
		
		for (EObject current : contents) {
			if (current instanceof Root) {
				root = (Root)current;
			}
		}
		if (root != null) {
			EList<de.fzi.gast.core.Package> packages = root.getPackages();
			iteratePackages(packages);
		}
		
		if (elements.size() > 0) {
			for (ModelElement element : elements) {
				
				//TEST for PackageMapping and SubsystemComponent
				if (element instanceof GASTClass) {
					if (((GASTClass) element).getSimpleName().equals("MyLayer1Interface") || ((GASTClass) element).getSimpleName().equals("MyLayer1Class2")){
						elements1.add(element);
					}
				}
				
				//TEST for InterfaceViolation and Coupling
				/*if (element instanceof GASTClass) {
					if (((GASTClass) element).getSimpleName().equals("MyOtherClass")) {
						elements2.add(element);
					} else if (((GASTClass) element).getSimpleName().equals("MyLayer1Interface") || ((GASTClass) element).getSimpleName().equals("MyLayer1Class2")){
						elements1.add(element);
					}
				}*/
				
				//TEST FOR INSTABILITY: MyLayer1Class1 excluded
				/*if (element instanceof GASTClass) {
					if (((GASTClass) element).getSimpleName().equals("MyOtherClass")) {
						
					} else {
						elements1.add(element);
					}
				}*/
				
				
				//TEST FOR ABSTRACTNESS: ONLY INTERFACE
				/*if (element instanceof GASTClass) {
					if (((GASTClass) element).getSimpleName().equals("MyLayer1Interface")) {
						elements1.add(element);
					}
				}*/
				
				//ALL ELEMENTS DIVIDED: Used for SLAQ, Abstractness
				/*int i=0;
				if (i<=elements.size()/2) {
					elements1.add(element);
				} else {
					elements2.add(element);
				}
				i++;*/
			}
		}
	}
	
	private static void iteratePackages (EList<Package> packages) {
		for (de.fzi.gast.core.Package current : packages) {
			if (!current.getSimpleName().equals("java")) {
				EList<GASTClass> classes = current.getClasses();
				for (GASTClass currentClass : classes) {
					elements.add(currentClass);
				}
				EList<de.fzi.gast.core.Package> subPackages = current.getSubPackages();
				if (subPackages.size() > 0) {
					iteratePackages(subPackages);
				}
			}
		}
	}
	
	private static void createResource(URI uri) {
		// Register the default resource factory -- only needed for stand-alone!
		editingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File("grischatest.gast").getAbsolutePath());

		//Try to load the resource through the editingDomain.
		resource = null;
		try {
			resource = editingDomain.getResourceSet().getResource(fileURI, true);
		}
		catch (Exception e) {
			resource = editingDomain.getResourceSet().getResource(fileURI, false);
		}

		System.out.println("Resource \"" + fileURI.lastSegment() + "\" loaded: " + resource.isLoaded() + "\n");
	}
	
	
	private static void initializeEditingDomain () {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new statementsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new coreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new annotationsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new typesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new functionsItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new accessesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new variablesItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		BasicCommandStack commandStack = new BasicCommandStack();

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

}
