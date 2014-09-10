package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import de.fzi.se.quality.QualityRepository
import de.fzi.se.quality.parameters.ParameterReference
import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference
import de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference
import de.fzi.se.quality.parameters.pcm.PCMParameterReference
import de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition
import de.fzi.se.quality.qualityannotation.PCMServiceSpecification
import de.fzi.se.quality.qualityannotation.QualityAnnotation
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF
import de.uka.ipd.sdq.pcm.transformations.Helper
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn

@ModelIn(#[
	"quality.QualityRepository",
	"quality.parameters.ParameterReference",
	"quality.parameters.pcm.PCMComponentParameterReference",
	"quality.parameters.pcm.PCMOperationParameterReference",
	"quality.parameters.pcm.PCMParameterReference",
	"quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference",
	"quality.qualityannotation.CharacterisedPCMParameterPartition",
	"quality.qualityannotation.PCMServiceSpecification",
	"quality.qualityannotation.QualityAnnotation",
	"pcm.seff.ResourceDemandingSEFF"
])
class SimAccuracyInfluenceExt {
	QualityRepository qualityAnnotationRepository
	
	def String getResourceName(ResourceDemandingSEFF seff) {
		Helper::getResourceFileName(seff)
	}
	
	def String getResourceName(CharacterisedPCMParameterPartition partition) {
		Helper::getResourceFileName(partition)
	}

	// access to quality annotations
	def QualityRepository getQualityAnnotationRepository() {
		return this.qualityAnnotationRepository;
	}
	
	def QualityRepository setQualityAnnotationRepository(QualityRepository qualityAnnotationRepository) {
		this.qualityAnnotationRepository = qualityAnnotationRepository;
	}
	
	def QualityAnnotation getQualityAnnotation(ResourceDemandingSEFF rdseff) {
		if (qualityAnnotationRepository == null) 
			return null
		else
			qualityAnnotationRepository.qualityStatements.filter(typeof(QualityAnnotation)).findFirst [
				qa |
				(qa.forServiceSpecification instanceof PCMServiceSpecification) &&
					((qa.forServiceSpecification as PCMServiceSpecification).resourceDemandingSEFF == rdseff)
			]
	}
	
	// PCM parameter references to SimuCom String-based ids within RD-SEFFs
	def dispatch String getSimuComId(ParameterReference ref) '''
		ERROR: Unknown type of parameter reference.
	'''

	def dispatch String getSimuComId(PCMParameterReference ref) '''
		ERROR: Unknown type of PCM parameter reference.
	'''

	def dispatch String getSimuComId(PCMOperationParameterReference ref) {
		ref.parameter.parameterName
	}

	def dispatch String getSimuComId(PCMComponentParameterReference ref) '''
		ERROR: Unknown type of parameter reference.
	'''
	
	def dispatch String getSimuComId(PCMRequiredBusinessOperationReturnParameterReference ref) '''
		RETURN
	'''
}