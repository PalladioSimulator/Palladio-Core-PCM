rem oldmodel = %%a 
rem pass the old repository model as a parameter
rem it will be updated by this script. 

for /f %%a IN ('dir /b *.repository') do (

sed -i "s/providedRoles_InterfaceProvidingEntity id/providedRoles_InterfaceProvidingEntity xsi:type=\"OperationProvidedRole\" id/g" %%a

sed -i "s/requiredRoles_InterfaceRequiringEntity id/requiredRoles_InterfaceRequiringEntity  xsi:type=\"OperationRequiredRole\" id/g" %%a

sed -i "s/__ProvidedRole/__OperationProvidedRole/g" %%a

sed -i "s/__RequiredRole/__OperationRequiredRole/g" %%a

sed -i "s/inputParameterUsages_ExternalCallAction/inputVariableUsages__CallAction/g" %%a

sed -i "s/outputVariableUsages_ExternalCallAction/returnVariableUsage__CallReturnAction/g" %%a



sed -i "s/namedReference_VariableUsage/namedReference__VariableUsage/g" %%a

sed -i "s/__Interface/__OperationInterface/g" %%a

sed -i "s/serviceName/entityName/g" %%a

sed -i "s/interfaces__Repository id/interfaces__Repository xsi:type=\"OperationInterface\" id/g" %%a

sed -i "s/__Signature /__OperationSignature /g" %%a
sed -i "s/__Signature>/__OperationSignature>/g" %%a
sed -i "s/__Signature=/__OperationSignature=/g" %%a

sed -i "s/returntype/returnType/g" %%a
)

for /f %%a IN ('dir /b *.system') do (

sed -i "s/providedRoles_InterfaceProvidingEntity id/providedRoles_InterfaceProvidingEntity xsi:type=\"_1:OperationProvidedRole\" id/g" %%a

sed -i "s/requiredRoles_InterfaceRequiringEntity id/requiredRoles_InterfaceRequiringEntity  xsi:type=\"_1:OperationRequiredRole\" id/g" %%a

sed -i "s/__ProvidedRole/__OperationProvidedRole/g" %%a

sed -i "s/__RequiredRole/__OperationRequiredRole/g" %%a


sed -i "s/namedReference_VariableUsage/namedReference__VariableUsage/g" %%a

sed -i "s/__Interface/__OperationInterface/g" %%a

sed -i "s/serviceName/entityName/g" %%a

sed -i "s/__Signature /__OperationSignature /g" %%a
sed -i "s/__Signature>/__OperationSignature>/g" %%a
sed -i "s/__Signature=/__OperationSignature=/g" %%a

)

for /f %%a IN ('dir /b *.usagemodel') do (

sed -i "s/signature_EntryLevelSystemCall/operationSignature__EntryLevelSystemCall/g" %%a

sed -i "s/namedReference_VariableUsage/namedReference__VariableUsage/g" %%a

sed -i "s/signatures__Interface/signatures__OperationInterface/g" %%a

)

@echo Manually fix references
@echo Manually add ids for GuardedBranchTransitions. 
