package de.uka.ipd.sdq.qnm.simulator;

import java.io.File;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.qnm.QNModel;
import de.uka.ipd.sdq.qnm.QnmPackage;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;

public class QNModelInstance {
	
	private QNModel qnModel;
	
	private static Logger logger = 	Logger.getLogger(QNModelInstance.class.getName());
	
	public QNModelInstance(){
		qnModel = (QNModel) loadFromXMIFile("D:\\Diss\\svn\\code\\"
				+ "Palladio.EMFAnalyticalModel\\trunk\\de.uka"
				+ ".ipd.sdq.qnm.simulator\\Example\\Test1-Sequence_CPU_HD.qnm");

//		qnModel = (QNModel) loadFromXMIFile("D:\\Diss\\svn\\code\\"
//				+ "Palladio.EMFAnalyticalModel\\trunk\\de.uka"
//				+ ".ipd.sdq.qnm.simulator\\Example\\Test3-Sequence_CPU_Delay.qnm");

//		qnModel = (QNModel) loadFromXMIFile("D:\\Diss\\svn\\code\\"
//				+ "Palladio.EMFAnalyticalModel\\trunk\\de.uka"
//				+ ".ipd.sdq.qnm.simulator\\Example\\Test4-Sequence_CPU_HD_Delay.qnm");

//		qnModel = (QNModel) loadFromXMIFile("D:\\Diss\\svn\\code\\"
//				+ "Palladio.EMFAnalyticalModel\\trunk\\de.uka"
//				+ ".ipd.sdq.qnm.simulator\\Example\\Test5-Sequence(System)_Sequence(Thread)_CPU_HD_Delay.qnm");

		
	}
		
	private EObject loadFromXMIFile(String fileName) {
		// Create a resource set to hold the resources.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extentions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put(ResourceModelPackage.eNS_URI,
				ResourceModelPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(QnmPackage.eNS_URI,
				QnmPackage.eINSTANCE);

		// Construct the URI for the instance file.
		// The argument is treated as a file path only if it denotes an existing
		// file. Otherwise, it's directly treated as a URL.
		File file = new File(fileName);
		URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(fileName);

		Resource resource = null;
		// Demand load resource for this file.
		try {
			resource = resourceSet.getResource(uri, true);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		EObject eObject = (EObject) resource.getContents().iterator().next();
		return EcoreUtil.getRootContainer(eObject);
	}

	public QNModel getQnModel() {
		return qnModel;
	}

	public void setQnModel(QNModel qnModel) {
		this.qnModel = qnModel;
	}
}
