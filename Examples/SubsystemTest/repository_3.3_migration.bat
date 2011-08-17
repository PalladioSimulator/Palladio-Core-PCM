rem oldmodel = %1 
rem pass the old repository model as a parameter
rem it will be updated by this script. 

sed -i "s/providedRoles_InterfaceProvidingEntity id/providedRoles_InterfaceProvidingEntity xsi:type=\"OperationProvidedRole\" id/g" %1

sed -i "s/requiredRoles_InterfaceRequiringEntity id/requiredRoles_InterfaceRequiringEntity  xsi:type=\"OperationRequiredRole\" id/g" %1

sed -i "s/__ProvidedRole/__OperationProvidedRole/g" %1

sed -i "s/__RequiredRole/__OperationRequiredRole/g" %1

sed -i "s/inputParameterUsages_ExternalCallAction/inputVariableUsages__CallAction/g" %1

sed -i "s/outputVariableUsages_ExternalCallAction/returnVariableUsage__CallReturnAction/g" %1



sed -i "s/namedReference_VariableUsage/namedReference__VariableUsage/g" %1

sed -i "s/__Interface/__OperationInterface/g" %1

sed -i "s/serviceName/entityName/g" %1

sed -i "s/interfaces__Repository id/interfaces__Repository xsi:type=\"OperationInterface\" id/g" %1

sed -i "s/__Signature /__OperationSignature /g" %1
sed -i "s/__Signature>/__OperationSignature>/g" %1
sed -i "s/__Signature=/__OperationSignature=/g" %1

sed -i "s/returntype/returnType/g" %1

@echo Manually fix references
@echo Manually add ids for GuardedBranchTransitions. 
