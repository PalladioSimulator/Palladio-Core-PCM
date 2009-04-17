package org.somox.metrics.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;
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
import org.junit.Ignore;
import org.junit.Test;
import org.somox.metrics.Abstractness;
import org.somox.metrics.Coupling;
import org.somox.metrics.DMS;
import org.somox.metrics.Instability;
import org.somox.metrics.InterfaceViolation;
import org.somox.metrics.NameResemblance;
import org.somox.metrics.PackageMapping;

import de.fzi.gast.accesses.provider.accessesItemProviderAdapterFactory;
import de.fzi.gast.annotations.provider.annotationsItemProviderAdapterFactory;
import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.core.provider.coreItemProviderAdapterFactory;
import de.fzi.gast.functions.provider.functionsItemProviderAdapterFactory;
import de.fzi.gast.statements.provider.statementsItemProviderAdapterFactory;
import de.fzi.gast.types.GASTClass;
import de.fzi.gast.types.provider.typesItemProviderAdapterFactory;
import de.fzi.gast.variables.provider.variablesItemProviderAdapterFactory;

public class Tests {
	
	private Abstractness abs;
	private Coupling cou;
	private DMS dms;
	private Instability ins;
	private InterfaceViolation iViol;
	private NameResemblance nameRes;
	private PackageMapping pMap;

	private static AdapterFactoryEditingDomain editingDomain;

	private static ComposedAdapterFactory adapterFactory;
	
	private static Resource resource;
	
	private static Root root = null;
	private static List<ModelElement> elements1;
	private static List<ModelElement> elements2;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initializeEditingDomain();
		createResource(null);
		extractClassLists();
	}
	
	@Before
	public void checkInitialization () {
		assertTrue("Root was initialized", root!=null);
		assertTrue("List1 was initialized", elements1!=null);
		assertTrue("List1 contains elements", elements1.size()>0);
		assertTrue("List2 was initialized", elements2!=null);
		assertTrue("List2 contains elements", elements2.size()>0);
	}
	
	@Test
	public void abstractnessTest () throws Exception {
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
		
		assertTrue("Abstractness results are equal", abstractnessWithEMF == abstractnessWithoutEMF);
		
		//needs to be changed for different models / different lists
		assertTrue("Abstractness result correct", abstractnessWithEMF == 0.5);
		
		System.out.println("");
	}
	
	@Test
	public void couplingTest () throws Exception {
		cou = new Coupling();

		long time1First = System.nanoTime();
		double coupling = cou.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Coupling");
		System.out.println("Calculated without EMF-Query: " + coupling + " (took: " + time1total + " ns)");
		
		//needs to be changed for different models / different lists
		//assertTrue("Coupling result correct", coupling == 0.5);
		System.out.println("");
	}
	
	@Test
	public void instabilityTest () throws Exception {
		ins = new Instability();

		long time1First = System.nanoTime();
		double instability = ins.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Instability");
		System.out.println("Calculated without EMF-Query: " + instability + " (took: " + time1total + " ns)");
		
		//needs to be changed for different models / different lists
		//assertTrue("Instability result correct", distanceFMS == 0.5);
		System.out.println("");
	}
	
	@Test
	public void ifaceViolationTest () throws Exception {
		iViol = new InterfaceViolation();

		long time1First = System.nanoTime();
		double interfaceViolation = 0.0;
		
		//Not yet implemented
		//double interfaceViolation = iViol.compute(root, elements1, elements2);
		
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Interface Violation");
		System.out.println("Calculated without EMF-Query: " + interfaceViolation + " (took: " + time1total + " ns)");
		
		//needs to be changed for different models / different lists
		//assertTrue("Instability result correct", distanceFMS == 0.5);
		System.out.println("");
	}
	
	@Test
	public void dmsTest () throws Exception {
		abs = new Abstractness();
		ins = new Instability();
		dms = new DMS();

		long time1First = System.nanoTime();
		double distanceFMS = dms.compute(root, elements1, elements2);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Distance from Main Sequence");
		System.out.println("Calculated without EMF-Query: " + distanceFMS + " (took: " + time1total + " ns)");

		//needs to be changed for different models / different lists
		//assertTrue("DMS result correct", distanceFMS == 0.5);
		System.out.println("");
	}
	
	@Test
	public void nameResemblanceTest () throws Exception {
		nameRes = new NameResemblance();

		long time1First = System.nanoTime();
		
		//last parameter = percentage needs to be changed manually
		double nameResemblance = nameRes.compute(root, elements1, elements2, 50);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Name Resemblance");
		System.out.println("Calculated without EMF-Query: " + nameResemblance + " (took: " + time1total + " ns)");

		System.out.println("");
	}
	
	@Test
	public void packageMappingTest () throws Exception {
		pMap = new PackageMapping();

		long time1First = System.nanoTime();
		double packageMapping = pMap.compute(root, elements1, elements2, 50);
		long time1total = System.nanoTime()-time1First;
		
		System.out.println("Package Mapping");
		System.out.println("Calculated without EMF-Query: " + packageMapping + " (took: " + time1total + " ns)");

		System.out.println("");
	}
	
	private static void extractClassLists () {
		EList<EObject> contents =resource.getContents();
		
		elements1 = new LinkedList<ModelElement>();
		elements2 = new LinkedList<ModelElement>();
		
		for (EObject current : contents) {
			if (current instanceof Root) {
				root = (Root)current;
			}
		}
		if (root != null) {
			EList<de.fzi.gast.core.Package> packages = root.getPackages();
			for (de.fzi.gast.core.Package current : packages) {
				if (!current.getSimpleName().equals("java")) {
					EList<de.fzi.gast.core.Package> subPackages = current.getSubPackages();
					for (de.fzi.gast.core.Package currentSub : subPackages) {
						EList<GASTClass> classes = currentSub.getClasses();
						int sizeFirst = classes.size()/2;
						int i=0;
						for (GASTClass currentClass : classes) {
							if (i<sizeFirst) {
								elements1.add(currentClass);
							} else {
								elements2.add(currentClass);
							}
							i++;
						}
					}
				}
			}
		}
	}
	
	private static void createResource(URI uri) {
		// Register the default resource factory -- only needed for stand-alone!
		editingDomain.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File("output.gast").getAbsolutePath());

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
