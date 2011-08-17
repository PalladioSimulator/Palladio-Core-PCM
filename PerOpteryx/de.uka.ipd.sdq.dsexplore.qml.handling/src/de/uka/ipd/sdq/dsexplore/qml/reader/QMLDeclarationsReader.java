/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclaration;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarations;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.RefinedQMLProfile;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.SimpleQMLProfile;

/**
 * Basic class for reading qml definitions.
 * 
 * @author noorshams
 */
public class QMLDeclarationsReader {
	/**
	 * Assumes 1 QML declaration in the file
	 * @param path
	 *            the file path or URI.
	 */
	public QMLDeclarations getQMLDeclarations(String QMLDeclarationsPath) {
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
		File file = new File(QMLDeclarationsPath);
		URI uri = file.isFile() ? URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(QMLDeclarationsPath);

		// Demand load resource for this file.
		//
		Resource resource = resourceSet.getResource(uri, true);

		// Validate the contents of the loaded resource.
		//
		
		//List<QMLDeclarations> declarationsList = new ArrayList<QMLDeclarations>();
		QMLDeclarations returnDeclaration = null;
		
		for (EObject eObject : resource.getContents()) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
			if (diagnostic.getSeverity() != Diagnostic.OK) {
				printDiagnostic(diagnostic, "");
				throw new RuntimeException("QML validation failed: "+diagnostic.getMessage()+". See console output for details.");
			}
			if(!(eObject instanceof QMLDeclarations)) {
				throw new RuntimeException("Check QML definition: The root element of the file must be a QMLDeclarations element.");
			}
			
			returnDeclaration = ((QMLDeclarations)eObject);
			break;
		}
		return returnDeclaration;

	}

	/**
	 * <!-- begin-user-doc --> Prints diagnostics with indentation. <!--
	 * end-user-doc -->
	 * 
	 * @param diagnostic
	 *            the diagnostic to print.
	 * @param indent
	 *            the indentation for printing.
	 */
	protected void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}
	
	public List<QMLContractType> getQMLContractTypes(QMLDeclarations declarations) {
		if (declarations == null) {
			return null;
		}
		List<QMLContractType> contractTypes = new ArrayList<QMLContractType>();
		for (QMLDeclaration declaration : declarations.getQmlDeclarations()) {
			if(declaration instanceof QMLContractType) {
				contractTypes.add((QMLContractType)declaration);
			}
		}
		return contractTypes;
	}
	
	public List<SimpleQMLContract> getSimpleQMLContracts(QMLDeclarations declarations) {
		if (declarations == null) {
			return null;
		}
		List<SimpleQMLContract> simpleContracts = new ArrayList<SimpleQMLContract>();
		for (QMLDeclaration declaration : declarations.getQmlDeclarations()) {
			if(declaration instanceof SimpleQMLContract) {
				simpleContracts.add((SimpleQMLContract)declaration);
			}
		}
		return simpleContracts;
	}
	
	public List<SimpleQMLProfile> getSimpleQMLProfiles(QMLDeclarations declarations) {
		if (declarations == null) {
			return null;
		}
		List<SimpleQMLProfile> simpleProfiles = new ArrayList<SimpleQMLProfile>();
		for (QMLDeclaration declaration : declarations.getQmlDeclarations()) {
			if(declaration instanceof SimpleQMLProfile) {
				simpleProfiles.add((SimpleQMLProfile)declaration);
			}
		}
		return simpleProfiles;
	}
	
	public List<RefinedQMLContract> getRefinedQMLContracts(QMLDeclarations declarations) {
		if (declarations == null) {
			return null;
		}
		List<RefinedQMLContract> refinedContracts = new ArrayList<RefinedQMLContract>();
		for (QMLDeclaration declaration : declarations.getQmlDeclarations()) {
			if(declaration instanceof RefinedQMLContract) {
				refinedContracts.add((RefinedQMLContract)declaration);
			}
		}
		return refinedContracts;
	}
	
	public List<RefinedQMLProfile> getRefinedQMLProfiles(QMLDeclarations declarations) {
		if (declarations == null) {
			return null;
		}
		List<RefinedQMLProfile> simpleProfiles = new ArrayList<RefinedQMLProfile>();
		for (QMLDeclaration declaration : declarations.getQmlDeclarations()) {
			if(declaration instanceof RefinedQMLProfile) {
				simpleProfiles.add((RefinedQMLProfile)declaration);
			}
		}
		return simpleProfiles;
	}

}
