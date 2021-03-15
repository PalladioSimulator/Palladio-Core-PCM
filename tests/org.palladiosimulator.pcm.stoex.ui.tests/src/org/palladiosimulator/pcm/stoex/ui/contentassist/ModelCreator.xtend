package org.palladiosimulator.pcm.stoex.ui.contentassist

import org.palladiosimulator.pcm.core.CoreFactory
import org.palladiosimulator.pcm.parameter.ParameterFactory
import org.palladiosimulator.pcm.repository.RepositoryFactory
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF
import org.palladiosimulator.pcm.seff.SeffFactory
import org.palladiosimulator.pcm.seff.seff_performance.SeffPerformanceFactory
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory

class ModelCreator {
    
    static extension SeffFactory seffFactory = SeffFactory.eINSTANCE
    static extension RepositoryFactory repositoryFactory = RepositoryFactory.eINSTANCE
    static extension SeffPerformanceFactory seffPerformanceFactory = SeffPerformanceFactory.eINSTANCE
    static extension CoreFactory coreFactory = CoreFactory.eINSTANCE
    static extension ParameterFactory parameterFactory = ParameterFactory.eINSTANCE
    static extension UsagemodelFactory usageModelFactory = UsagemodelFactory.eINSTANCE
    
    static def createSeffWithOneInternalAction() {
        val dummyDataType = createCompositeDataType => [
            entityName = "dummyType"
        ]
        val collectionDataType = createCollectionDataType => [
             entityName = "collectionDataType"
             innerType_CollectionDataType = dummyDataType
        ]
        val deepNestedDataType = createCompositeDataType => [
            entityName = "nestedDataType"
            innerDeclaration_CompositeDataType += createInnerDeclaration => [
                entityName = "foo1"
                datatype_InnerDeclaration = createCompositeDataType => [
                    entityName = "foo1_1"
                    innerDeclaration_CompositeDataType += createInnerDeclaration => [
                        entityName = "foo1_1_1"
                        datatype_InnerDeclaration = dummyDataType
                    ]
                ]
            ]
            innerDeclaration_CompositeDataType += createInnerDeclaration => [
                entityName = "foo2"
                datatype_InnerDeclaration = createCompositeDataType => [
                    entityName = "foo2_1"
                    innerDeclaration_CompositeDataType += createInnerDeclaration => [
                        entityName = "foo2_1_1"
                        datatype_InnerDeclaration = dummyDataType
                    ]
                ]
            ]
            innerDeclaration_CompositeDataType += createInnerDeclaration => [
                entityName = "foo3"
                datatype_InnerDeclaration = collectionDataType
            ]
        ]
        val collectionForCompositeDataType = createCollectionDataType => [
            entityName = "CollectionOfComposite"
            innerType_CollectionDataType = createCompositeDataType => [
                entityName = "CollectedComposition"
                    innerDeclaration_CompositeDataType += createInnerDeclaration => [
                        entityName = "foo1"
                        datatype_InnerDeclaration = dummyDataType
                    ]
                    innerDeclaration_CompositeDataType += createInnerDeclaration => [
                        entityName = "foo2"
                        datatype_InnerDeclaration = dummyDataType
                    ]
            ]
        ]

        createResourceDemandingSEFF => [
            describedService__SEFF = createOperationSignature => [
                entityName = "service1"
                parameters__OperationSignature += createParameter => [
                    parameterName = "paramSimple"
                    dataType__Parameter = dummyDataType
                ]
                parameters__OperationSignature += createParameter => [
                    parameterName = "paramNested"
                    dataType__Parameter = deepNestedDataType
                ]
                parameters__OperationSignature += createParameter => [
                    parameterName = "paramCollection"
                    dataType__Parameter = collectionDataType
                ]
                parameters__OperationSignature += createParameter => [
                    parameterName = "paramCollectionOfComposite"
                    dataType__Parameter = collectionForCompositeDataType
                ]
                returnType__OperationSignature = dummyDataType
            ]
            steps_Behaviour += createStartAction
            steps_Behaviour += createInternalAction => [
                resourceDemand_Action += createParametricResourceDemand => [
                    specification_ParametericResourceDemand = createPCMRandomVariable
                ]
            ]
            steps_Behaviour += createStopAction
            linkSteps
        ]
        
    } 
    
    static def createSeffWithOneExternalCallAction() {
        val dummyDataType = createCompositeDataType => [
            entityName = "dummyType"
        ]
        
        createResourceDemandingSEFF => [
            describedService__SEFF = createOperationSignature => [
                entityName = "service1"
                parameters__OperationSignature += createParameter => [
                    parameterName = "paramFoo"
                    dataType__Parameter = dummyDataType
                ]
                parameters__OperationSignature += createParameter => [
                    parameterName = "paramBar"
                    dataType__Parameter = dummyDataType
                ]
            ]
            steps_Behaviour += createStartAction
            steps_Behaviour += createExternalCallAction => [
                calledService_ExternalService = createOperationSignature => [
                    entityName = "foo"
                    returnType__OperationSignature = dummyDataType
                ]
                returnVariableUsage__CallReturnAction += createVariableUsage => [
                    variableCharacterisation_VariableUsage += createVariableCharacterisation => [
                        specification_VariableCharacterisation = createPCMRandomVariable
                    ]
                ]
            ]
            steps_Behaviour += createStopAction
            linkSteps
        ]
    }
    
    static def createScenarioBehaviorWithOneEntryLevelSystemCall() {
        val dummyDataType = createCompositeDataType => [
            entityName = "dummyType"
        ]
        createScenarioBehaviour => [
            actions_ScenarioBehaviour += createStart
            actions_ScenarioBehaviour += createEntryLevelSystemCall => [
                operationSignature__EntryLevelSystemCall = createOperationSignature => [
                    returnType__OperationSignature = dummyDataType
                ]
                outputParameterUsages_EntryLevelSystemCall += createVariableUsage => [
                    variableCharacterisation_VariableUsage += createVariableCharacterisation => [
                        specification_VariableCharacterisation = createPCMRandomVariable
                    ]
                ]
            ]
            actions_ScenarioBehaviour += createStop
            linkSteps
        ]
    }
    
    protected static def linkSteps(ResourceDemandingSEFF seff) {
        for (var i = 1; i < seff.steps_Behaviour.size; i++) {
            seff.steps_Behaviour.get(i).predecessor_AbstractAction = seff.steps_Behaviour.get(i-1)
        }
    }
    
    protected static def linkSteps(ScenarioBehaviour behavior) {
        for (var i = 1; i < behavior.actions_ScenarioBehaviour.size; i++) {
            behavior.actions_ScenarioBehaviour.get(i).predecessor = behavior.actions_ScenarioBehaviour.get(i-1)
        }
    }

}