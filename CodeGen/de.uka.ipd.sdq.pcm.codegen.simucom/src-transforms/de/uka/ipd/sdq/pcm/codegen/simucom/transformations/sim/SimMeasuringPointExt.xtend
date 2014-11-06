package de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim

import de.uka.ipd.sdq.pcm.transformations.Helper
import org.eclipse.emf.ecore.EObject

class SimMeasuringPointExt {
	def getResourceURI(EObject eObject) {
		Helper::getResourceURI(eObject)
	}
	
	def getResourceDescription(EObject eObject) {
		Helper::getResourceDescription(eObject)
	}
}