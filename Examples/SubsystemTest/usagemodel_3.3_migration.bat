rem oldmodel = %1 
rem pass the old repository model as a parameter
rem it will be updated by this script. 

sed -i "s/signature_EntryLevelSystemCall/operationSignature__EntryLevelSystemCall/g" %1

sed -i "s/namedReference_VariableUsage/namedReference__VariableUsage/g" %1

sed -i "s/signatures__Interface/signatures__OperationInterface/g" %1
