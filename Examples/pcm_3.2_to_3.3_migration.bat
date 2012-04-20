rem the replacement commands are executed for all PCM files in the current folder. #
rem Possibly not all metamodel changes have been accounted for, so some may have to be done manually. 

for /f %%a IN ('dir /b *.repository') do (

  sed -i "s/assemblyContexts_ComposedStructure/assemblyContexts__ComposedStructure/g" %%a

  sed -i "s/encapsulatedComponent_AssemblyContext/encapsulatedComponent__AssemblyContext/g" %%a
  sed -i "s/datatypes_Repository/dataTypes__Repository/g" %%a

  sed -i "s/datatype__Parameter/dataType__Parameter/g" %%a

)

for /f %%a IN ('dir /b *.usagemodel') do (
 sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/UsageModel\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/UsageModel\/5.0/g" %%a
)

for /f %%a IN ('dir /b *.allocation') do (
 sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/Allocation\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/Allocation\/5.0/g" %%a
)

for /f %%a IN ('dir /b *.repository') do (

  sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/Core\/Composition\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/Core\/Composition\/5.0/g" %%a
  sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/Repository\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/Repository\/5.0/g" %%a
  sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/SEFF\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/SEFF\/5.0/g" %%a
  sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/System\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/System\/5.0/g" %%a
  sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/Reliability\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/Reliability\/5.0/g" %%a

)

for /f %%a IN ('dir /b *.system') do (

  sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/Core\/Composition\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/Core\/Composition\/5.0/g" %%a
  sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/System\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/System\/5.0/g" %%a
  sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/Repository\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/Repository\/5.0/g" %%a
  
  sed -i "s/assemblyContexts_ComposedStructure/assemblyContexts__ComposedStructure/g" %%a

  sed -i "s/encapsulatedComponent_AssemblyContext/encapsulatedComponent__AssemblyContext/g" %%a

  sed -i "s/configParameterUsages_AssemblyContext/configParameterUsages__AssemblyContext/g" %%a

  sed -i "s/XMLSchema-instance\"/XMLSchema-instance\" xmlns:composition=\"http://sdq.ipd.uka.de/PalladioComponentModel/Core/Composition/4.0\"/g" %%a

  sed -i "s/assemblyConnectors_ComposedStructure id/connectors__ComposedStructure xsi:type=\"composition:AssemblyConnector\" id/g" %%a

  sed -i "s/providedDelegationConnectors_ComposedStructure id/connectors__ComposedStructure xsi:type=\"composition:ProvidedDelegationConnector\" id/g" %%a

  sed -i "s/providedDelegationConnectors_ComposedStructure/connectors__ComposedStructure/g" %%a
 
  sed -i "s/requiredDelegationConnectors_ComposedStructure id/connectors__ComposedStructure xsi:type=\"composition:RequiredDelegationConnector\" id/g" %%a

  sed -i "s/requiredDelegationConnectors_ComposedStructure/connectors__ComposedStructure/g" %%a

  sed -i "s/assemblyConnectors_ComposedStructure/connectors__ComposedStructure/g" %%a

  sed -i "s/QoSAnnotations\/Performance/QoSAnnotations\/QoS_Performance/g" %%a
  sed -i "s/QoSAnnotations\/Reliability/QoSAnnotations\/QoS_Reliability/g" %%a
  sed -i "s/SEFF\/Performance/SEFF\/SEFF_Performance/g" %%a
  sed -i "s/SEFF\/Reliability/SEFF\/SEFF_Reliability/g" %%a

)

for /f %%a IN ('dir /b *.resourceenvironment') do (
 
sed -i "s/name=\"[a-zA-Z_]*\">/><!-- deleted name -->/g" %%a
rem \">/><!-- deleted name \1 -->

sed -i "s/sdq.ipd.uka.de\/PalladioComponentModel\/ResourceEnvironment\/4.0/sdq.ipd.uka.de\/PalladioComponentModel\/ResourceEnvironment\/5.0/g" %%a
sed -i "s/schedulingPolicy=\"PROCESSOR_SHARING\">/> <schedulingPolicy href=\"pathmap:\/\/PCM_MODELS\/Palladio.resourcetype#ProcessorSharing\"\/>/g" %%a
sed -i "s/schedulingPolicy=\"DELAY\">/> <schedulingPolicy href=\"pathmap:\/\/PCM_MODELS\/Palladio.resourcetype#Delay\"\/>/g" %%a 
sed -i "s/schedulingPolicy=\"FCFS\">/> <schedulingPolicy href=\"pathmap:\/\/PCM_MODELS\/Palladio.resourcetype#FCFS\"\/>/g" %%a
sed -i "s/schedulingPolicy=\"EXACT\">/> <schedulingPolicy href=\"pathmap:\/\/PCM_MODELS\/Palladio.resourcetype#EXACT\"\/>/g" %%a
sed -i "s/<activeResourceSpecifications_ResourceContainer>/<activeResourceSpecifications_ResourceContainer> <schedulingPolicy href=\"pathmap:\/\/PCM_MODELS\/Palladio.resourcetype#ProcessorSharing\"\/>/g" %%a
 
)

@echo ********
@echo Try whether your models are valid now. If not, you may have to change more things manually. Check out https://sdqweb.ipd.kit.edu/wiki/PCM_Model_Migration and https://sdqweb.ipd.kit.edu/wiki/PCM_Changelog
