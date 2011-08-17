/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.qml.reader;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage;

/**
 * Reads the Dimension defined in the file. Be sure the definition 
 * does not contain multiple dimension definitions.  
 * 
 * @author noorshams
 *
 */
public class QMLDimensionReader {
	
	public List<Dimension> getDimensions(String[] dimensionPaths) {
		List<Dimension> dimensions = new ArrayList<Dimension>();
		for (String dimensionPath : dimensionPaths) {
			dimensions.add(this.getDimension(dimensionPath));
		}
		return dimensions;
	}
	
	public Dimension getDimension(String dimensionPath) {
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle all file
		// extensions.
		//
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put(QMLDeclarationsPackage.eNS_URI,
				QMLDeclarationsPackage.eINSTANCE);

		// Construct the URI for the instance file.
		// The argument is treated as a file path only if it denotes an existing
		// file.
		// Otherwise, it's directly treated as a URL.
		//
		File file = new File(dimensionPath);
		URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(dimensionPath);

		// Demand load resource for this file.
		//
		Resource resource = resourceSet.getResource(uri, true);

		// Validate the contents of the loaded resource.
		//
		
		Dimension dimension = null;
		
		for (EObject eObject : resource.getContents()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				new QMLDeclarationsReader().printDiagnostic(diagnostic, "");
				throw new RuntimeException("QML validation failed!");
			}
			if(!(eObject instanceof Dimension)) {
				throw new RuntimeException("Check QML definition! Dimension expected!");
			}
			dimension = ((Dimension)eObject);
			//XXX: first dimension found will be returned
			break;
		}
		return dimension;
	}
	
}
