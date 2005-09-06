@ECHO OFF
REM ********************************************************************************
REM
REM These are simple command line generation calls.  You can use the GUI client to
REM set the properties of a template and then right-click the property grid and
REM select "Save Property Set XML" to save your properties to a file. 
REM
REM ********************************************************************************

..\CodeSmithConsole /template:ArrayList.cst /properties:StringCollectionPropertySet.xml /out:StringCollection.cs
..\CodeSmithConsole /template:IList.cst /properties:IStringCollectionPropertySet.xml /out:IStringCollection.cs
..\CodeSmithConsole /template:PurchaseOrderXml.cst /properties:PurchaseOrderXmlPropertySet.xml /out:purchaseorder.txt

REM ********************************************************************************
REM
REM This is an example of using the merge features of the command line client.
REM
REM ********************************************************************************

..\CodeSmithConsole /template:MergeOutputSample.cst /properties:MergeOutputSamplePropertySet.xml /out:MergeOutputSample.vb /merge:"Sample Generated Region"

REM ********************************************************************************
REM
REM This is an example of using the console client to output multiple generations
REM to a single file in the same way that the VS.NET custom tool generates code.
REM
REM ********************************************************************************

..\CodeSmithConsole /properties:hashtable.xml /out:hashtable.cs

REM ********************************************************************************
REM
REM This is an example of using the console client to output multiple generations
REM to a single file in the same way that the VS.NET custom tool generates code.
REM
REM ********************************************************************************

..\CodeSmithConsole /properties:hashtable.xml /out:hashtable.cs

