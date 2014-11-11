package de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim

import com.google.inject.Inject
import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference
import de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference
import de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange
import de.fzi.se.quality.qualityannotation.PCMParameterPartition
import de.uka.ipd.sdq.pcm.seff.AbstractAction
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF

class SimAccuracyXpt {
	@Inject extension SimAccuracyInfluenceExt	
	
	def dispatch checkAccuracy(CharacterisedPCMParameterPartitionInterval ival, ResourceDemandingSEFF rdseff, AbstractAction action) '''
		de.uka.ipd.sdq.simucomframework.accuracy.AccuracyAnalysisHelper.checkBoundsInterval(
			"«ival.id»",
			"«ival.getResourceName()»",
			ctx.getModel(),
			«IF ival.pcmParameterPartition.parameterReference instanceof PCMOperationParameterReference»
				methodBodyStackFrame
			«ELSEIF ival.pcmParameterPartition.parameterReference instanceof PCMRequiredBusinessOperationReturnParameterReference»
				callResult
			«ELSEIF ival.pcmParameterPartition.parameterReference instanceof PCMComponentParameterReference»
				methodBodyStackFrame
			«ELSE»
				«/* ERROR "This type of parameter reference is not supported by this implementation."*/»
			«ENDIF»,
			«IF ival.pcmParameterPartition.parameterReference instanceof PCMOperationParameterReference»
				"«ival.pcmParameterPartition.parameterReference.getSimuComId()».«ival.forCharacterisation»"
			«ELSEIF ival.pcmParameterPartition.parameterReference instanceof PCMRequiredBusinessOperationReturnParameterReference»
				"RETURN.«ival.forCharacterisation»"
			«ELSEIF ival.pcmParameterPartition.parameterReference instanceof PCMComponentParameterReference»
				"«ival.pcmParameterPartition.parameterReference.getSimuComId()».«ival.forCharacterisation»"
			«ELSE»
				«/* ERROR "This type of parameter reference is not supported by this implementation." */»
			«ENDIF»,
			"«rdseff.id»",
			"«action.id»",
			"«rdseff.getResourceName()»",
			"«ival.from.specification»",
			"«ival.to.specification»");
	'''

	def dispatch checkAccuracy(CharacterisedPCMParameterPartitionRange range, ResourceDemandingSEFF rdseff, AbstractAction action) '''
		de.uka.ipd.sdq.simucomframework.accuracy.AccuracyAnalysisHelper.checkBoundsRange(
			"«range.id»",
			"«range.getResourceName()»",
			ctx.getModel(),
			«IF range.pcmParameterPartition.parameterReference instanceof PCMOperationParameterReference»
				ctx.getStack().currentStackFrame()
			«ELSEIF range.pcmParameterPartition.parameterReference instanceof PCMRequiredBusinessOperationReturnParameterReference»
				callResult
			«ELSEIF range.pcmParameterPartition.parameterReference instanceof PCMComponentParameterReference»
				ctx.getStack().currentStackFrame()
			«ELSE»
				«/* ERROR "This type of parameter reference is not supported by this implementation." */»
			«ENDIF»,
			«IF range.pcmParameterPartition.parameterReference instanceof PCMOperationParameterReference»
				"«range.pcmParameterPartition.parameterReference.getSimuComId()».«range.forCharacterisation»"
			«ELSEIF range.pcmParameterPartition.parameterReference instanceof PCMRequiredBusinessOperationReturnParameterReference»
				"RETURN.«range.forCharacterisation»"
			«ELSEIF range.pcmParameterPartition.parameterReference instanceof PCMComponentParameterReference»
				"«range.pcmParameterPartition.parameterReference.getSimuComId()».«range.forCharacterisation»"
			«ELSE»
				«/* ERROR "This type of parameter reference is not supported by this implementation." */»
			«ENDIF»,
			"«rdseff.id»",
			"«action.id»",
			"«rdseff.getResourceName()»",
			«FOR value : range.values SEPARATOR ', '»"«value.specification»"«ENDFOR»
			);
	'''

def dispatch String checkAccuracy(CharacterisedPCMParameterPartition partition, ResourceDemandingSEFF rdseff, AbstractAction action) '''
	«/* ERROR "Implementation of transformation for accuracy influence analysis does not support this partition type." */»
'''

def dispatch String checkAccuracy(PCMParameterPartition partition, ResourceDemandingSEFF rdseff, AbstractAction action) '''
	«FOR part : partition.characerisedParameterPartitions»
		«part.checkAccuracy(rdseff, action)»
	«ENDFOR»
'''
}