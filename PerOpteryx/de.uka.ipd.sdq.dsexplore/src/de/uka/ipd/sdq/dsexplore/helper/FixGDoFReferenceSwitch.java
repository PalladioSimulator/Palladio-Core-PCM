package de.uka.ipd.sdq.dsexplore.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.PcmFactory;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFFactory;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFRepository;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.util.GDoFSwitch;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

public class FixGDoFReferenceSwitch {

	
	private PCMInstance initialInstance;

	public FixGDoFReferenceSwitch(PCMInstance initialInstance2) {
		this.initialInstance = initialInstance2;
	}
	
	public void fix(GDoFRepository r){
		
		PcmFactory pcmFactory = PcmFactory.eINSTANCE;
		
		// collect all pcm operations, structural features and classes
		Map<String, ENamedElement> pcmTypedElements = new HashMap<String,ENamedElement>();
		
		for (Iterator<EObject> iterator = pcmFactory.getPcmPackage().eAllContents(); 
		     iterator.hasNext();) {
			EObject eNamedElement = (EObject) iterator.next();
			if (eNamedElement instanceof EClass 
					|| eNamedElement instanceof EOperation
					|| eNamedElement instanceof EStructuralFeature){
				pcmTypedElements.put(((ENamedElement)eNamedElement).getName(), (ENamedElement)eNamedElement);
			}
		}
		
		for (Iterator<EObject> iterator = EcoreUtil.getAllContents(r, true);
		iterator.hasNext();) {
			EObject gdofObject = (EObject) iterator.next();
			List<EStructuralFeature> features = gdofObject.eClass().getEAllStructuralFeatures();
			
			for (EStructuralFeature eStructuralFeature : features) {
				
				// test if value of the feature is from the PCM package, i.e. its metaclass from the ecore package.
				if (eStructuralFeature instanceof EReference){
					EReference eref = (EReference)eStructuralFeature;
					EClass refType = eref.getEReferenceType();
					EPackage topmostPackage = getTopMostPackage(refType.getEPackage());
					if (topmostPackage.getName().contains("ecore")){
						
						if (eref.isMany()){
							
							//TODO
							
						} else {
						
							// if yes, replace by the same feature of the PCM java classes.
							Object currentValue = gdofObject.eGet(eref);
							if (currentValue instanceof ENamedElement){
								ENamedElement pcmNamedElement = pcmTypedElements.get(((ENamedElement) currentValue).getName());
								gdofObject.eSet(eref, pcmNamedElement);
							}
						}
					}
						
					}
				}
				
			}
			

		}
		

	private EPackage getTopMostPackage(EPackage ePackage) {
		EPackage superpackage = ePackage.getESuperPackage();
		if (superpackage == null || superpackage == ePackage)
			return ePackage;
		return getTopMostPackage(superpackage);
	}

	public void fixGDoFReferences(Problem problem) {
		List<DegreeOfFreedom> dofs = problem.getDesigndecision();
		
		Set<GDoFRepository> gdofRepos = new HashSet<GDoFRepository>();
		for (DegreeOfFreedom degreeOfFreedom : dofs) {
			GDoFRepository repo = (GDoFRepository)degreeOfFreedom.getGdof().eContainer();
			if (gdofRepos.add(repo)){
				fix(repo);
			}
		}
		
	}
}
