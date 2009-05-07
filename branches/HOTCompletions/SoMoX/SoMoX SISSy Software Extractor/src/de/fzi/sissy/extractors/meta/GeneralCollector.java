/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.extractors.meta;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import de.fzi.sissy.extractors.delphi.OutputPair;
import de.fzi.sissy.metamod.*;
import de.fzi.sissy.util.Debug;

/**
 * @author stammel
 *
 * Collects Model-Elements of the source-system
 * and gives a general interface to provide information
 * for the MetamodBuilder
 * 
 */
public abstract class GeneralCollector {

    private Vector fileElements;
    private Vector packageElements;
    private Vector primitiveTypeElements;
    private Vector classElements;
    private Vector arrayElements;

    private Vector globalFunctionElements;
    private Vector methodElements;
    private Vector constructorElements;
    private Vector destructorElements;
    private Vector delegateElements;
    private Vector referenceElements;
    private Vector typeAliasElements;

    private Vector globalVariableElements;
    private Vector fieldElements;
    private Vector localVariablesElements;
    private Vector propertyElements;
    
    private Vector functionAccessElements;
    private Vector variableAccessElements;
    private Vector typeAccessElements;
    private Vector typeCastAccessElements;
    private Vector selfAccessElements;
    private Vector runtimeTypeAccessElements;
    private Vector compositeAccessElements;
    private Vector staticTypeAccessElements;

    public GeneralCollector() {
        fileElements = new Vector();
        packageElements = new Vector();
        primitiveTypeElements = new Vector();
        classElements = new Vector();
        arrayElements = new Vector();

        globalFunctionElements = new Vector();
        methodElements = new Vector();
        constructorElements = new Vector();
        destructorElements = new Vector();
        delegateElements = new Vector();
        referenceElements = new Vector();
        typeAliasElements = new Vector();
        
        globalVariableElements = new Vector();
        fieldElements = new Vector();
        localVariablesElements = new Vector();
        propertyElements = new Vector();

        functionAccessElements = new Vector();
        variableAccessElements = new Vector();
        typeAccessElements = new Vector();
        typeCastAccessElements = new Vector();
        selfAccessElements = new Vector();
        runtimeTypeAccessElements = new Vector();
        compositeAccessElements = new Vector();
        staticTypeAccessElements = new Vector();
}
    
    
    // Package-File-Containment
    protected abstract Object getFileContainerElementOfPackageElement(Object package_element);
    // Package-Package-Containment
    protected abstract Object getPackageContainerElementOfPackageElement(Object package_element);
    // Class-Class-Containment
    protected abstract Object getClassContainerElementOfClassElement(Object class_element);
    // Method-Class-Containment 
    protected abstract Object getClassContainerElementOfMethodElement(Object method_element);
    // Constructor-Class-Containment 
    protected abstract Object getClassContainerElementOfConstructorElement(Object constructor_element);
    // Destructor-Class-Containment 
    protected abstract Object getClassContainerElementOfDestructorElement(Object destructor_element);
    // Field-Class-Containment
    protected abstract Object getClassContainerElementOfFieldElement(Object field_element);
    
    // LocalVariable-Function-Containment 
    protected abstract Object getFunctionContainerElementOfLocalVariableElement(Object lv_element);
    // FormalParameter-Function-Containment 
    protected abstract Object getFunctionContainerElementOfFormalParameterElement(Object fp_element);
    // CatchParameter-Function-Containment 
    protected abstract Object getFunctionContainerElementOfCatchParameterElement(Object cp_element);

    // Filename
    protected abstract String getFilenameOfFileElement(Object file_element);
    // Packagename
    protected abstract String getPackagenameOfPackageElement(Object package_element);
    // Name of primitive type
    protected abstract String getTypenameOfPrimitiveTypeElement(Object primitive_type_element);
    // Name of class element
    protected abstract String getNameOfClassElement(Object class_element);
    // Interface setup
    protected abstract boolean classElementIsInterface(Object class_element);
    // Referencetype setup
    protected abstract boolean classElementIsReferenceType(Object class_element);
    // membersetup of classes:
    protected abstract boolean classElementIsExternal(Object class_element);
    protected abstract boolean classElementIsInternal(Object class_element);
    protected abstract boolean classElementIsNew(Object class_element);
    protected abstract boolean classElementIsPrivate(Object class_element);
    protected abstract boolean classElementIsProtected(Object class_element);
    protected abstract boolean classElementIsPublic(Object class_element);
    protected abstract boolean classElementIsPackage(Object class_element);
    protected abstract boolean classElementIsStatic(Object class_element);
    protected abstract boolean classElementIsFinal(Object class_element);
    
    // Position-Object 
    protected abstract Position getPositionOfElement(Object class_element);
    // Base type of array
    protected abstract Object getBaseTypeOfArrayElement(Object array_element);

    // Name of method element
    protected abstract String getNameOfFunctionElement(Object function_element);
    // membersetup of function elements
    protected abstract boolean functionElementIsExternal(Object function_element);
    protected abstract boolean functionElementIsInternal(Object function_element);
    protected abstract boolean functionElementIsNew(Object function_element);
    protected abstract boolean functionElementIsPrivate(Object function_element);
    protected abstract boolean functionElementIsProtected(Object function_element);
    protected abstract boolean functionElementIsPublic(Object function_element);
    protected abstract boolean functionElementIsPackage(Object function_element);
    protected abstract boolean functionElementIsStatic(Object function_element);
    protected abstract boolean functionElementIsFinal(Object function_element);
    protected abstract boolean functionElementIsVirtual(Object function_element);
    protected abstract boolean functionElementIsUnitInitializer(Object function_element);
    protected abstract boolean functionElementIsUnitFinalizer(Object function_element);

    // Name of field element
    protected abstract String getNameOfFieldElement(Object field_element);
    // membersetup of field elements
    protected abstract boolean fieldElementIsExternal(Object field_element);
    protected abstract boolean fieldElementIsInternal(Object field_element);
    protected abstract boolean fieldElementIsNew(Object field_element);
    protected abstract boolean fieldElementIsPrivate(Object field_element);
    protected abstract boolean fieldElementIsProtected(Object field_element);
    protected abstract boolean fieldElementIsPublic(Object field_element);
    protected abstract boolean fieldElementIsPackage(Object field_element);
    protected abstract boolean fieldElementIsStatic(Object field_element);
    protected abstract boolean fieldElementIsFinal(Object field_element);
    protected abstract boolean fieldElementIsIntrospectable(Object field_element);
    
    // Name of property element
    protected abstract String getNameOfPropertyElement(Object property_element);
    protected abstract Object getSetterElementOfpropertyElement(Object property_element);
    protected abstract Object getGetterElementOfpropertyElement(Object property_element);
    // membersetup of property elements
    public abstract boolean propertyElementIsExternal(Object property_element);
    public abstract boolean propertyElementIsInternal(Object property_element);
    public abstract boolean propertyElementIsNew(Object property_element);
    public abstract boolean propertyElementIsPrivate(Object property_element);
    public abstract boolean propertyElementIsProtected(Object property_element);
    public abstract boolean propertyElementIsPublic(Object property_element);
    public abstract boolean propertyElementIsPackage(Object property_element);
    public abstract boolean propertyElementIsStatic(Object property_element);
    public abstract boolean propertyElementIsFinal(Object property_element);
    public abstract boolean propertyElementIsIntrospectable(Object property_element);
    
    // Get formal parameter elements for function element
    protected abstract List getFormalParameterElements(Object function_element);
    protected abstract String getNameOfFormalParameterElement(Object fp_element);
    protected abstract Object getTypeElementOfFormalParameterElement(Object fp_element);

    // Get local variable elements for function element
    protected abstract List getLocalVariableElements(Object function_element);
    protected abstract String getNameOfLocalVariableElement(Object lv_element);

    protected abstract Object getTypeElementOfLocalVariableElement(Object lv_element);
    
    protected abstract String getNameOfGlobalVariableElement(Object gv_element);

    protected abstract Object getTypeElementOfGlobalVariableElement(Object gv_element);
    
    protected abstract Object getTypeElementOfPropertyElement(Object property_element);

    protected abstract Object getGetterElementOfPropertyElement(Object property_element);

    protected abstract Object getSetterElementOfPropertyElement(Object property_element);

    protected abstract Object getTypeElementOfFieldElement(Object property_element);

    private static File unknownFileObject;
    
    public static File getUnknownFileObject() {
        if (unknownFileObject==null)  {
            unknownFileObject = new File("<unknown>");
        }
        
        return unknownFileObject;
    }
    
    /**
     * 
     * @return Returns the fileElements.
     */
    public Vector getFileElements() {
        return fileElements;
    }
    public void addFileElement(Object element) {
        if (!fileElements.contains(element))
            fileElements.add(element);
    }

    /**
     * @return Returns the packageElements.
     */
    public Vector getPackageElements() {
        return packageElements;
    }
    public void addPackageElement(Object element) {
        if (!packageElements.contains(element))
            packageElements.add(element);
    }

    /**
     * @param packageElements The packageElements to set.
     */
    public void setPackageElements(Vector packageElements) {
        this.packageElements = packageElements;
    }
    /**
     * @return Returns the arrayElements.
     */
    public Vector getArrayElements() {
        return arrayElements;
    }
    public void addArrayElement(Object element) {
        if (!arrayElements.contains(element))
            arrayElements.add(element);
        else
            Debug.warning("addArrayElement: ArrayElement already inserted: "+element.toString());
    }
    /**
     * @return Returns the classElements.
     */
    public Vector getClassElements() {
        return classElements;
    }
    public void addClassElement(Object element) {
        if (!classElements.contains(element))
            classElements.add(element);
    }
    /**
     * @return Returns the globalVariablesElements.
     */
    public Vector getGlobalVariableElements() {
        return globalVariableElements;
    }
    public void addGlobalVariableElement(Object element) {
        if (!globalVariableElements.contains(element))
            globalVariableElements.add(element);
    }
    /**
     * @return Returns the primitiveTypeElements.
     */
    public Vector getPrimitiveTypeElements() {
        return primitiveTypeElements;
    }
    public void addPrimitiveTypeElement(Object element) {
        if (!primitiveTypeElements.contains(element))
            primitiveTypeElements.add(element);
    }
    /**
     * @return Returns the constructorElements.
     */
    public Vector getConstructorElements() {
        return constructorElements;
    }
    public void addConstructorElement(Object element) {
        if (!constructorElements.contains(element))
            constructorElements.add(element);
    }
    /**
     * @return Returns the destructorElements.
     */
    public Vector getDestructorElements() {
        return destructorElements;
    }
    public void addDestructorElement(Object element) {
        if (!destructorElements.contains(element))
            destructorElements.add(element);
    }
    /**
     * @return Returns the delegateElements.
     */
    public Vector getDelegateElements() {
        return delegateElements;
    }
    public void addDelegateElement(Object element) {
        if (!delegateElements.contains(element))
            delegateElements.add(element);
    }
    /**
     * @return Returns the referenceElements.
     */
    public Vector getReferenceElements() {
        return referenceElements;
    }
    public void addReferenceElement(Object element) {
        if (!referenceElements.contains(element))
            referenceElements.add(element);
    }

    /**
     * @return Returns the typeAliasElements.
     */
    public Vector getTypeAliasElements() {
        return typeAliasElements;
    }
    public void addTypeAliasElement(Object element) {
        if (!typeAliasElements.contains(element))
            typeAliasElements.add(element);
    }

    /**
     * @return Returns the fieldsElements.
     */
    public Vector getFieldElements() {
        return fieldElements;
    }
    public void addFieldElement(Object field_element) {
        if (!fieldElements.contains(field_element))
            fieldElements.add(field_element);
    }

    /**
     * @return Returns the globalFunctionElements.
     */
    public Vector getGlobalFunctionElements() {
        return globalFunctionElements;
    }
    public void addGlobalFunctionElement(Object element) {
        if (!globalFunctionElements.contains(element))
            globalFunctionElements.add(element);
    }

    /**
     * @return Returns the localVariablesElements.
     */
    public Vector getLocalVariablesElements() {
        return localVariablesElements;
    }
    public void addLocalVariablesElement(Object element) {
        if (!localVariablesElements.contains(element))
            localVariablesElements.add(element);
    }

    /**
     * @return Returns the methodElements.
     */
    public Vector getMethodElements() {
        return methodElements;
    }
    public void addMethodElement(Object element) {
        if (!methodElements.contains(element))
            methodElements.add(element);
    }


    public Vector getPropertyElements() {
        return propertyElements;
    }
    public void addPropertyElement(Object element) {
        if (!propertyElements.contains(element))
            propertyElements.add(element);
    }


    public void setPropertyElements(Vector propertyElements) {
        this.propertyElements = propertyElements;
    }

    public abstract boolean arrayElementIsReferenceType(Object array_element);

    public abstract Object getReturnTypeElementOfFunctionElement(Object function_element);


    public abstract boolean globalVariableElementIsConst(Object global_variable_element);


    public abstract Object getClassContainerElementOfPropertyElement(Object property_element);

    public abstract Collection getSuperClassElementsOfClassElement(Object class_element);


    public Vector getVariableAccessElements() {
        return variableAccessElements;
    }
    public void addVariableAccessElement(Object element) {
        if (!variableAccessElements.contains(element))
            variableAccessElements.add(element);
    }


    public void setVariableAccessElements(Vector variableAccessElements) {
        this.variableAccessElements = variableAccessElements;
    }


    public Vector getFunctionAccessElements() {
        return functionAccessElements;
    }
    public void addFunctionAccessElement(Object element) {
        if (!functionAccessElements.contains(element))
            functionAccessElements.add(element);
    }


    public void setFunctionAccessElements(Vector functionAccessElements) {
        this.functionAccessElements = functionAccessElements;
    }


    public Vector getTypeAccessElements() {
        return typeAccessElements;
    }
    public void addTypeAccessElement(Object element) {
        if (!typeAccessElements.contains(element))
            typeAccessElements.add(element);
    }


    public void setTypeAccessElements(Vector typeAccessElements) {
        this.typeAccessElements = typeAccessElements;
    }


    public abstract Object getFunctionElementToFunctionAccessElement(Object function_access_element);

    public abstract Object getContainerStatementOfFunctionAccessElement(Object function_access_element); 

    public abstract Object getVariableElementToVariableAccessElement(Object variable_access_element) ;

    public abstract Object getContainerStatementOfVariableAccessElement(Object variable_access_element) ;

    public abstract boolean isWritingVariableAccess(Object variable_access_element);


    public Vector getTypeCastAccessElements() {
        return typeCastAccessElements;
    }
    public void addTypeCastAccessElement(Object element) {
        if (!typeCastAccessElements.contains(element))
            typeCastAccessElements.add(element);
    }

    public void setTypeCastAccessElements(Vector typeCastAccessElements) {
        this.typeCastAccessElements = typeCastAccessElements;
    }

    public Vector getSelfAccessElements() {
        return selfAccessElements;
    }
    public void addSelfAccessElement(Object element) {
        if (!selfAccessElements.contains(element))
            selfAccessElements.add(element);
    }
    public void setSelfAccessElements(Vector selfAccessElements) {
        this.selfAccessElements = selfAccessElements;
    }

    public Vector getRunTimeTypeAccessElements() {
        return runtimeTypeAccessElements;
    }
    public void addRunTimeTypeAccessElement(Object element) {
        if (!runtimeTypeAccessElements.contains(element))
            runtimeTypeAccessElements.add(element);
    }
    public void setRunTimeTypeAccessElements(Vector runTimeTypeAccessElements) {
        this.runtimeTypeAccessElements = runTimeTypeAccessElements;
    }

    public Vector getCompositeAccessElements() {
        return compositeAccessElements;
    }
    public void addCompositeAccessElement(Object element) {
        if (!compositeAccessElements.contains(element))
            compositeAccessElements.add(element);
    }
    public void setCompositeAccessElements(Vector compositeAccessElements) {
        this.compositeAccessElements = compositeAccessElements;
    }

    public Vector getStaticTypeAccessElements() {
        return staticTypeAccessElements;
    }
    public void addStaticTypeAccessElement(Object element) {
        if (!staticTypeAccessElements.contains(element))
            staticTypeAccessElements.add(element);
    }
    public void setStaticTypeAccessElements(Vector staticTypeAccessElements) {
        this.staticTypeAccessElements = staticTypeAccessElements;
    }

    
    public abstract Object getTypeElementToTypeCastAccessElement(Object typecast_access_element);
    public abstract Object getContainerStatementOfTypeCastAccessElement(Object typecast_access_element);


    public abstract boolean functionElementIsProcedure(Object function_element);
    public abstract boolean functionElementIsFunction(Object function_element);
    public abstract boolean functionElementIsAbstract(Object function_element);
    public abstract boolean functionElementIsIntrospectable(Object function_element);

    public abstract Object getPackageContainerElementOfGlobalFunctionElement(Object global_function_element);
    public abstract Object getPackageContainerElementOfGlobalVariableElement(Object global_variable_element);
    public abstract Object getPackageContainerElementOfClassElement(Object class_element);
    public abstract Object getPackageContainerElementOfTypeAliasElement(Object typealias_element);
    
    public abstract String getNameOfDelegateElement(Object delegate_element);
    public abstract String getNameOfReferenceElement(Object reference_element);
    public abstract Object getReferencedTypeElementOfReferenceElement(Object reference_element);
    public abstract String getNameOfTypeAliasElement(Object typealias_element);
    public abstract Object getAliasedTypeElementOfTypeAliasElement(Object typealias_element);

    public abstract Object getTargetClassElementOfSelfAccessElement(Object self_access_element);
    public abstract Object getContainerStatementOfSelfAccessElement(Object self_access_element);

    public abstract Object getTypeClassElementOfRunTimeTypeAccessElement(Object runtime_type_access_element);
    public abstract Object getContainerStatementOfRunTimeTypeAccessElement(Object runtime_type_access_element);

    public abstract Object getTypeClassElementOfStaticTypeAccessElement(Object static_type_access_element);
    public abstract Object getContainerStatementOfStaticTypeAccessElement(Object static_type_access_element);

}    
