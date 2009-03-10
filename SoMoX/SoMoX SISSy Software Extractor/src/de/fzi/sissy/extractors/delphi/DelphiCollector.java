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
package de.fzi.sissy.extractors.delphi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


import de.fzi.delphi.symbols.CompilationUnit;
import de.fzi.delphi.symbols.Method;
import de.fzi.delphi.symbols.Scope;
import de.fzi.delphi.symbols.*;
import de.fzi.delphi.symbols.types.*;
import de.fzi.delphi.types.Type;
import de.fzi.sissy.extractors.meta.GeneralCollector;
import de.fzi.sissy.extractors.meta.GeneralMapper;
import de.fzi.sissy.metamod.File;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.Statement;
import de.fzi.sissy.util.Debug;
import de.fzi.delphi.OPProjectManager;
import de.fzi.delphi.PositionElement;
import de.fzi.delphi.ProjectListEntry;
import de.fzi.delphi.CodeblockInfo;

/**
 * @author stammel
 *
 */
public class DelphiCollector extends GeneralCollector {

    private GeneralMapper mapper;
    
    public DelphiCollector(SissyOutput sissyOutput, GeneralMapper mapper) {
        super();
        this.sissyOutput = sissyOutput;
        this.mapper = mapper;
        
        
        extractScopesAndSymbols();
        extractMethodReferences(sissyOutput);
        extractAttributeReferences(sissyOutput);
        // several other accesses:
        extractAccesses(sissyOutput);
        extractTypeCasts(sissyOutput);
    }
    
    
    private SissyOutput sissyOutput;
    
    private void extractMethodReferences(SissyOutput sissyOutput) {
        
        Iterator method_ref_itr = sissyOutput.getOpMethodReferences().iterator();
        
        while (method_ref_itr.hasNext()) {
            OutputPair method_ref = (OutputPair)method_ref_itr.next();
            
            Method method = (Method) method_ref.getSymbol();
            
            if (method != null)
                this.collectSymbol(method);

            Scope scope = method_ref.getScope();
            
            Symbol corresponding_symbol = scope.getCorrespondingSymbol();
           
            Statement container_stm = method_ref.getCurrentStatement();
            
            /*
            Debug.verbose("COLLECTED MethodReference: ");
            Debug.verbose("Method:       "+method.getFullName());
            Debug.verbose("Corresponding-Symbol:");
            if (corresponding_symbol != null)
            showSymbol(corresponding_symbol);
            else
                Debug.warning("Corresponding Symbol was null!");
            if (container_stm != null)
                Debug.verbose("Container-Statement:"+ container_stm.getClass().getName());
                else
                    Debug.warning("Container-Statement was null!");
            
            Debug.verbose("---------------------------------------------");
            */

            this.addFunctionAccessElement(method_ref);
            
        }
        
    }
    
    private void extractTypeCasts(SissyOutput sissyOutput) {
        
        Iterator type_cast_itr = sissyOutput.getOpTypeCasts().iterator();
        
        while (type_cast_itr.hasNext()) {
            OutputPair type_cast = (OutputPair)type_cast_itr.next();
            
            Type type = (Type) type_cast.getSymbol();
            
            if (type != null)
                this.collectSymbol(type);
            
            Scope scope = type_cast.getScope();
            
            Symbol corresponding_symbol = scope.getCorrespondingSymbol();
           
            Statement container_stm = type_cast.getCurrentStatement();
            
            /*
            Debug.verbose("COLLECTED TypeCast: ");
            Debug.verbose("Type:       "+type.getFullName());
            Debug.verbose("Corresponding-Symbol:");
            if (corresponding_symbol != null)
            showSymbol(corresponding_symbol);
            else
                Debug.verbose("Corresponding Symbol was null!");
            if (container_stm != null)
                Debug.verbose("Container-Statement:"+ container_stm.getClass().getName());
                else
                    Debug.verbose("Container-Statement was null!");
            
            Debug.verbose("---------------------------------------------");
            */
            
            this.addTypeCastAccessElement(type_cast);
            
        }
        
    }
   
    private void extractAttributeReferences(SissyOutput sissyOutput) {
        
        Iterator attrb_ref_itr = sissyOutput.getOpAttributReferences().iterator();
        
        while (attrb_ref_itr.hasNext()) {
            OutputPair attrb_ref = (OutputPair)attrb_ref_itr.next();
            
            Attribute attrb = (Attribute) attrb_ref.getSymbol();
            
            if (attrb != null)
                this.collectSymbol(attrb);
            
            Scope scope = attrb_ref.getScope();
            
            Symbol corresponding_symbol = scope.getCorrespondingSymbol();

            Statement container_stm = attrb_ref.getCurrentStatement();

            /*
            Debug.verbose("COLLECTED AttributeReference: ");
            Debug.verbose("Attribute:     "+attrb.getFullName());
            Debug.verbose("Corresponding-Symbol:");
            if (corresponding_symbol != null)
            showSymbol(corresponding_symbol);
            else
                Debug.verbose("Corresponding Symbol was null!");
            if (container_stm != null)
                Debug.verbose("Container-Statement:"+ container_stm.getClass().getName());
                else
                    Debug.verbose("Container-Statement was null!");
            Debug.verbose("---------------------------------------------");
            */
            
            this.addVariableAccessElement(attrb_ref);
            
        }
        
    }
    
    private void extractAccesses(SissyOutput sissyOutput) {
        // selfAccesses
        this.setSelfAccessElements(sissyOutput.getOpSelfAccesses());
        // staticTypeAccesses
        this.setStaticTypeAccessElements(sissyOutput.getOpStaticTypeAccesses());
        // runtimeTypeAccesses
        this.setRunTimeTypeAccessElements(sissyOutput.getOpRuntimeTypeAccesses());
        // compositeAccesses
        this.setCompositeAccessElements(sissyOutput.getOpCompositeAccesses());
    }

    private void extractScopesAndSymbols() {
        
        // get root-scope from OPParser-ProjectManager directly !!!
        Scope root_scope = OPProjectManager.getProjectScope();

        if (root_scope == null) {
            Debug.warning("root_scope was null!!");
            return;
        }
        
        /*
        if (root_scope.getCorrespondingSymbol()==null) {
            Debug.warning("Corresponding Symbol for Root-Scope was null!");
        } else {
            Debug.verbose("Corresponding Symbol for Root-Scope was "+ root_scope.getCorrespondingSymbol().getClass().getName());
        }
        */
        
        ScopeWalker walker = new ScopeWalker(root_scope);
        
        do {
            
            Scope current_scope = walker.getCurrentScope();
            
            if (current_scope != null) {
	            Debug.verbose("Scope-Name: "+ current_scope.getFullName());
                
	            Symbol corresponding_symbol = current_scope.getCorrespondingSymbol();

                // TODO Do we have to collect any scope-symbols separatly ??
                /*
	            if (corresponding_symbol!=null) {
	                Debug.verbose("Corresponding-Symbol:"+ corresponding_symbol.getFullName() + " is "+corresponding_symbol.getClass().getName());
                
                    // TODO try to collect corresponding symbol
                    collectSymbol(corresponding_symbol);
                }
                */
                
	            Iterator itr = current_scope.getSymbols().iterator();
	            
	            while(itr.hasNext()) {
	                Symbol symbol = (Symbol)itr.next();
                    
                    if (symbol.getScope()!=current_scope) {
                        Debug.warning("extractScopesAndSymbols(): Container-Scope was not correct ?? Symbol: "+symbol.getFullName());
                        //symbol.setScope(current_scope);
                    }
	                
	                collectSymbol(symbol);
	            }
            } else {
                Debug.warning("Current Scope was null!");
            }
            
        } while (walker.next());
        
    }
    
    private void collectSymbol(Symbol symbol) {
        
        if (symbol==null) {
            Debug.warning("Attempt to collect null-symbol prevented!");
            return;
        }
        
        if (symbol.isInstanceOf("CompilationUnit")) {
            // TODO Assumption: CompilationUnits can contain only one Unit so we
            // can first create a File for this symbol, and moreover we
            // can create a Package Object for the contained Unit 
            // (which is not modelled by itself in OPParser)  
            
            // FileElement / PackageElement
            CompilationUnit compilationUnit = (CompilationUnit)symbol;
 
            Scope scope = compilationUnit.getCorrespondingScope(); 
            // MB: ProjectListEntry contains a compilation unit, not the scope!
            ProjectListEntry ple = OPProjectManager.getProjectListEntry(compilationUnit.getName()); 
            
            if (ple == null) {
                Debug.warning("ProjectListEntry for CompilationUnit-Symbol was null!");
                return;
            } 
            
            /*
            Debug.verbose("Collected CompilationUnit: ");
            showSymbol(compilationUnit);
            Debug.verbose("Filename: "+ple.getFilename());
            Debug.verbose("TotalLines: "+ple.getTotalLines());
            Debug.verbose("---------------------------------------------");
            */
            
            // we take compilationUnit-symbol as file-element and ...
            this.addFileElement(symbol);
            // ... due to mapping-reasons we take scope of compilationUnit as package-element!
            this.addPackageElement(scope); 
            
        } else if (symbol.isInstanceOf("Property")) {
            // FieldElement

            Property property = (Property)symbol;
            
            /*
            Debug.verbose("COLLECTED PROPERTY: ");
            showSymbol(property);
            Debug.verbose("Visibility:       "+property.getVisibility());
            Debug.verbose("VisibilityString: "+property.getVisibilityString());
            if (property.getType()!=null)
            Debug.verbose("Type:             "+property.getType().getName());
            if (property.getGetter()!=null)
            Debug.verbose("Getter:           "+property.getGetter().getName());
            if (property.getSetter()!=null)
            Debug.verbose("Setter:           "+property.getSetter().getName());
            Debug.verbose("---------------------------------------------");
            */
            
            this.addPropertyElement(symbol);
            
        } else if (symbol.isInstanceOf("Attribute")) {
            
            // FieldElement
            Attribute attrb = (Attribute)symbol;
          
            /*
            Debug.verbose("COLLECTED ATTRIBUTE: ");
            showSymbol(attrb);
            Debug.verbose("Visibility:       "+attrb.getVisibility());
            Debug.verbose("VisibilityString: "+attrb.getVisibilityString());
            if (attrb.getType()!=null)
            Debug.verbose("Type:             "+attrb.getType().getName());
            Debug.verbose("---------------------------------------------");
            */
            
            // test if it is a local variable (of a method)
            Scope scope = attrb.getScope();
            Symbol container_symbol = scope.getCorrespondingSymbol();
            // is parent-scope-symbol a Method-Object?
            if (container_symbol!=null && container_symbol.isInstanceOf("Method")) {
                // check if it is a Formal Parameter:
                Method method = (Method)container_symbol;
                if (method.getParameters().contains(attrb)) {
                    Debug.verbose("Attribute as FormalParameter identified ==> not collected! "+symbol.toString());
                    return;
                } else {
                // ==> assume it is a local variable
                    Debug.verbose("Attribute as LocalVariable identified! "+symbol.toString());
                    this.addLocalVariablesElement(attrb);
                }
            } else if (container_symbol!=null && container_symbol.isInstanceOf("ClassType")) {
                Debug.verbose("Field: "+symbol.toString());
                this.addFieldElement(symbol);
            } else {
                Debug.verbose("Global Variable: "+symbol.toString());
                this.addGlobalVariableElement(symbol);
            } 
            
        } else if (symbol.isInstanceOf("Method")) {
            // MethodElement
            
            // Lookup Category of Method: 
            // 1 Procedure, 2 Function, 3 Constructor, 4 Destructor
            
            
            Method method = (Method)symbol;
            
            /*
            Debug.verbose("COLLECTED METHOD: ");
            showSymbol(method);
            Debug.verbose("Category:         "+method.getCategory());
            Debug.verbose("Visibility:       "+method.getVisibility());
            Debug.verbose("VisibilityString: "+method.getVisibilityString());
            Debug.verbose("NumberParam:      "+method.getParameters().size());
            Debug.verbose("isClassMethod:    "+method.isClassMethod());
            Debug.verbose("isInnerMethod:    "+method.isInnerMethod());
            Debug.verbose("isOverloaded:     "+method.isOverloaded());
            Debug.verbose("isAbstract:       "+method.isAbstract());
            Debug.verbose("isVirtual:        "+method.isVirtual());
            Debug.verbose("isOverride:       "+method.isOverride());
            if (method.getType()!=null)
            Debug.verbose("Type:             "+method.getType().getName());
            if (method.getType()!=null)
            Debug.verbose("ReturnType:       "+method.getType().getName());
            Debug.verbose("codeblockinfo:");
            if (method.getCodeblockInfo()!=null)
                showCodeblockInfo(method.getCodeblockInfo());
            Debug.verbose("---------------------------------------------");
            */
            
            // is member-method ?
            Object container_class_element = getContainerClassElementOfSymbol(method);

            if (container_class_element==null) {
                // Debug.warning("Method not class-associated: "+method.getFullName());
                if (method.getCategory()==0)
                    method.setCategory(Method.PROCEDURE);
                this.addGlobalFunctionElement(method);
                return;
            }
            
            switch (method.getCategory()) {
	            case Method.PROCEDURE: // procedure
	                this.addMethodElement(method);
	                break;
	            case Method.FUNCTION: // function
	                this.addMethodElement(method);
	                break;
	            case Method.CONSTRUCTOR:  // constructor
	                this.addConstructorElement(method);
	                break;
	            case Method.DESTRUCTOR: // destructor
	                this.addDestructorElement(method);
	                break;
	            case Method.UNIT_INITIALIZER: 
	            	this.addMethodElement(method);
	            	break;
	            case Method.UNIT_FINALIZER:
	            	this.addMethodElement(method);
                default:
                    Debug.warning("Method without category found! ==> set to function and added to method-elements");
                    method.setCategory(Method.FUNCTION);
                    this.addMethodElement(method);
            }
            
        } else if (symbol.isInstanceOf("MethodComposite")) {
            MethodComposite comp = (MethodComposite)symbol;
            
            Iterator myIt = comp.getOverloadedMethods().iterator();
            while (myIt.hasNext()) {
            	collectSymbol((Method)myIt.next());
            }
            
        } else if (symbol.isInstanceOf("ArrayType")) {
            // ArrayElement
            ArrayType array = (ArrayType)symbol;
           
            /*
            Debug.verbose("COLLECTED ArrayType: ");
            showSymbol(array);
            Debug.verbose("isPacked:  "+array.isPacked());
            if (array.getType()!=null)
            Debug.verbose("Type:      "+array.getType().getName());
            if (array.getArrayType()!=null)
            Debug.verbose("ArrayType: "+array.getArrayType().getName());
            Debug.verbose("---------------------------------------------");
            */
            
            this.addArrayElement(symbol);
            
        } else if (symbol.isInstanceOf("NilType")) {
            // PrimitiveTypeElement
            
            NilType type = (NilType)symbol;

            /*
            Debug.verbose("COLLECTED NilType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addPrimitiveTypeElement(symbol);
            
            //primitiveTypeNameMap.put(symbol, "nil");
            
        } else if (symbol.isInstanceOf("PointerType")) {
            // handled as ReferenceElement
            PointerType type = (PointerType)symbol;

            /* 
            Debug.verbose("COLLECTED PointerType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addReferenceElement(symbol);

        } else if (symbol.isInstanceOf("ProceduralType")) {
            // DelegateElement
            ProceduralType type = (ProceduralType)symbol;

            /*
            Debug.verbose("COLLECTED ProceduralType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addDelegateElement(symbol);

        } else if (symbol.isInstanceOf("CharacterType")) {
            // PrimitiveTypeElement
            CharacterType type = (CharacterType)symbol;

            /*
            Debug.verbose("COLLECTED CharacterType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addPrimitiveTypeElement(symbol);
            //primitiveTypeNameMap.put(symbol, "character");
            
        } else if (symbol.isInstanceOf("EnumeratedType")) {
            // PrimitiveTypeElement
            EnumeratedType type = (EnumeratedType)symbol;

            /*
            Debug.verbose("COLLECTED EnumeratedType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */

            this.addPrimitiveTypeElement(symbol);
            //primitiveTypeNameMap.put(symbol, "enumeration");
            
        } else if (symbol.isInstanceOf("IntegerType")) {
            // PrimitiveTypeElement
            IntegerType type = (IntegerType)symbol;

            /*
            Debug.verbose("COLLECTED IntegerType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */

            this.addPrimitiveTypeElement(symbol);
            //primitiveTypeNameMap.put(symbol, "integer");
            
        } else if (symbol.isInstanceOf("SubrangeType")) {
            // not handled yet
            SubrangeType type = (SubrangeType)symbol;

            /*
            Debug.verbose("COLLECTED SubrangeType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addPrimitiveTypeElement(symbol);
       
        } else if (symbol.isInstanceOf("RealType")) {
            // PrimitiveTypeElement
           RealType type = (RealType)symbol;

           /*
           Debug.verbose("COLLECTED RealType: ");
           showSymbol(type);
           showType(type);
           Debug.verbose("---------------------------------------------");
           */
           
           this.addPrimitiveTypeElement(symbol);
           //primitiveTypeNameMap.put(symbol, "integer");
            
        } else if (symbol.isInstanceOf("StringType")) {
            // PrimitiveTypeElement
            StringType type = (StringType)symbol;
            
            /*
            Debug.verbose("COLLECTED StringType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addPrimitiveTypeElement(symbol);
            //primitiveTypeNameMap.put(symbol, "string");
            
        } else if (symbol.isInstanceOf("UnknownClassType")) {
            // ClassElement
            UnknownClassType type = (UnknownClassType)symbol;

            /*
            Debug.verbose("COLLECTED UnknownClassType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addClassElement(symbol);
            //primitiveTypeNameMap.put(symbol, "unknown class");
            
        } else if (symbol.isInstanceOf("ClassType")) {
            // ClassElement
            ClassType type = (ClassType)symbol;
            
            /*
            Debug.verbose("COLLECTED ClassType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("isDispInterface:  "+type.isDispinterface());
            Debug.verbose("isInterface::     "+type.isInterface());
            Debug.verbose("Number Methods:   "+type.getMethods().size());
            Debug.verbose("Number Fields:    "+type.getFields().size());
            Debug.verbose("Number SuperClass:"+type.getSuperClasses().size());
            Debug.verbose("---------------------------------------------");
            */
            
            this.addClassElement(symbol);
            
        } else if (symbol.isInstanceOf("FileType")) {
            // not handled yet
            FileType type = (FileType)symbol;

            /*
            Debug.verbose("COLLECTED FileType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */

            // FIXME FileType is not handled yet !!!
            //this.addPrimitiveTypeElement(symbol);

        } else if (symbol.isInstanceOf("RecordType")) {
            // handled as ClassElement
            RecordType type = (RecordType)symbol;

            /*
            Debug.verbose("COLLECTED RecordType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addClassElement(symbol);
            
        } else if (symbol.isInstanceOf("SetType")) {
            // handled as ClassElement
            SetType type = (SetType)symbol;

            /*
            Debug.verbose("COLLECTED SetType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addClassElement(symbol);

        } else if (symbol.isInstanceOf("UserDefinedType")) {
            // not handled yet
            UserDefinedType type = (UserDefinedType)symbol;

            /*
            Debug.verbose("COLLECTED UserDefinedType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("RealBaseType: " + type.getRealBaseType().getClass().getName());
            Debug.verbose("BaseType: " + type.getBaseType().getClass().getName());
            Debug.verbose("---------------------------------------------");
            */
            
            //this.addClassElement(symbol);
            // MB : Special treatment for type aliases, this will lose some types!
            // See Bug #252, #251
            this.addTypeAliasElement(symbol);
            
            // Possible allback, since Haiko does not properly resolve the base types
            // this.addPrimitiveTypeElement(symbol);
        
        } else if (symbol.isInstanceOf("VariantType")) {
            // not handled yet
            VariantType type = (VariantType)symbol;

            /*
            Debug.verbose("COLLECTED IntegerType: ");
            showSymbol(type);
            showType(type);
            Debug.verbose("---------------------------------------------");
            */
            
            this.addPrimitiveTypeElement(symbol);

        }
        
        
    }
    
    private static int max_recursion = 10;
    
    // is Method inside Class ? or global?
    private Object getContainerClassElementOfSymbol(Symbol symbol) {
        if (max_recursion < 0) {
            
//            max_recursion = 5;
            return null;
        }
        
        Scope container_scope = null;
        Symbol container_symbol = null;
        if (symbol.getScope()!=null) {
            container_scope= symbol.getScope();
            if (container_scope.getCorrespondingSymbol()!=null) {
                container_symbol = container_scope.getCorrespondingSymbol();
                if ((container_symbol != null) && container_symbol.isInstanceOf("Type")) {
                    return container_symbol;
                } else {
                    max_recursion--;
                    Object result = getContainerClassElementOfSymbol(container_symbol);
                    max_recursion++;
                    return result;
                }
            } else {
//                max_recursion = 5;
                return null;
            }
        } else {
//            max_recursion = 5;
            return null;
        }

    }
    
    private void showCodeblockInfo(CodeblockInfo cbi) {
        Debug.verbose("Branches:        "+cbi.getBranches());
        Debug.verbose("Statements:      "+cbi.getStatements());
        Debug.verbose("TotalLines:      "+cbi.getTotalLines());
        Debug.verbose("CommentLines:    "+cbi.getCommentLines());
        Debug.verbose("Type:            "+cbi.getType());
    }
    
    private void showSymbol(Symbol smb) {
        Debug.verbose("Name:            "+smb.getName());
        Debug.verbose("Lines:           "+smb.getLine());
        if (smb.getScope()!=null)
        Debug.verbose("Scope-Name:      "+smb.getScope().getName());
    }

    private void showType(Type type) {
        Debug.verbose("TypeName:        "+type.getName());
        if (type.getCorrespondingScope()!=null)
        Debug.verbose("Corr-Scope-Name: "+type.getCorrespondingScope().getName());
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getFileContainerElementOfPackageElement(java.lang.Object)
     */
    protected Object getFileContainerElementOfPackageElement(
            Object package_element) {
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getPackageContainerElementOfPackageElement(java.lang.Object)
     */
    protected Object getPackageContainerElementOfPackageElement(
            Object package_element) {
        
        // we don't have packages in delphi
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getClassContainerElementOfClassElement(java.lang.Object)
     */
    protected Object getClassContainerElementOfClassElement(Object class_element) {
        // TODO member-classes in delphi ???
        Type class_op = (Type)class_element;
        
        // TODO implement class container retrieval 
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getSuperClassElementOfClassElement(java.lang.Object)
     */
    public Collection getSuperClassElementsOfClassElement(Object class_element) {
        if (!(class_element instanceof ClassType)) {
            return new Vector();
        }
        
        ClassType class_op = (ClassType)class_element;
        
        return class_op.getSuperClasses();
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getClassContainerElementOfMethodElement(java.lang.Object)
     */
    protected Object getClassContainerElementOfMethodElement(
            Object method_element) {
        
        Method method_op = (Method)method_element;
        
        // TODO class-method-eigenschaft of methods ???
        /*
        Scope scope = method_op.getScope();
        Symbol symbol = scope.getCorrespondingSymbol();

        if (symbol != null && symbol.isInstanceOf("ClassType")) {
            Debug.verbose("ClassContainer for method "+method_op.getName()+" is available!!");
            return symbol;
        } else if (symbol != null && symbol.isInstanceOf("Method")) {
            Debug.warning("ClassContainer for method "+method_op.getName()+" not available, since Scope corresponds to Method!!");
            return null;
        } else if (symbol!=null){
            Debug.warning("ClassContainer for method "+method_op.getName()+" not available (Scope not corresponding to ClassType or Method, but "+symbol.getName()+")");
            return null;
        } else {
            Debug.warning("ClassContainer for method "+method_op.getName()+" not available (symbol was null!)");
            return null;
        }
        */
        
        return getContainerClassElementOfSymbol(method_op);
        
        /*
        if (method_op.isClassMethod()) {
           
            Scope scope = method_op.getScope();
            Symbol symbol = scope.getCorrespondingSymbol();
            
            if (symbol.isInstanceOf("ClassType")) {
                return symbol;
            } else {
                Debug.warning("ClassType for class-method not found!!");
                return null;
            }
            
        }
        */
        
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getClassContainerElementOfConstructorElement(java.lang.Object)
     */
    protected Object getClassContainerElementOfConstructorElement(
            Object constructor_element) {

        Method method_op = (Method)constructor_element;
        

            Scope scope = method_op.getScope();
            Symbol symbol = scope.getCorrespondingSymbol();
            
            if ((symbol != null) && symbol.isInstanceOf("ClassType")) {
                return symbol;
            } else {
                Debug.warning("ClassType for constructor not found!!");
                return null;
            }
            
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getClassContainerElementOfDestructorElement(java.lang.Object)
     */
    protected Object getClassContainerElementOfDestructorElement(
            Object destructor_element) {

        Method method_op = (Method)destructor_element;
        
            Scope scope = method_op.getScope();
            Symbol symbol = scope.getCorrespondingSymbol();
            
            if ((symbol != null) && symbol.isInstanceOf("ClassType")) {
                return symbol;
            } else {
                Debug.warning("ClassType for destructor not found!!");
                return null;
            }
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getClassContainerElementOfFieldElement(java.lang.Object)
     */
    protected Object getClassContainerElementOfFieldElement(Object field_element) {

        Attribute attrib = (Attribute)field_element;
        
        Scope scope = attrib.getScope();
        Symbol symbol = scope.getCorrespondingSymbol();
        
        if ((symbol != null) && symbol.isInstanceOf("ClassType")) {
            return symbol;
        } else {
            Debug.verbose("getClassContainerForFieldElement(): ClassType for attribute "+ attrib.getName()+" not found!!");
            return null;
        }
 
   }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getFunctionContainerElementOfLocalVariableElement(java.lang.Object)
     */
    protected Object getFunctionContainerElementOfLocalVariableElement(
            Object lv_element) {
        // TODO are there local variables in Delphi ???
        
        if (lv_element instanceof Attribute) {
            Attribute attribute_element = (Attribute)lv_element;
            
            Scope scope = attribute_element.getScope();
            Symbol symbol = scope.getCorrespondingSymbol();
            
            if ((symbol != null) && symbol.isInstanceOf("Method")) {
                Debug.info(scope.toString());
                Debug.info(symbol.toString());
                return symbol;
            } else {
                Debug.warning("For LocalVariableElement "+attribute_element.getName()+" no MethodContainer found!");
            }
            
            // TODO implement retrieval 
            
            return null;
        }
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getFunctionContainerElementOfFormalParameterElement(java.lang.Object)
     */
    protected Object getFunctionContainerElementOfFormalParameterElement(
            Object fp_element) {
        
        if (fp_element instanceof Attribute) {
            Attribute attribute_element = (Attribute)fp_element;
            
            Scope parent_scope = attribute_element.getScope();
            Symbol corr_symbol = parent_scope.getCorrespondingSymbol();
            
            if ((corr_symbol != null) && corr_symbol.isInstanceOf("Method")) {
                return corr_symbol;
            } else {
                return null;
            }
        }
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getFunctionContainerElementOfCatchParameterElement(java.lang.Object)
     */
    protected Object getFunctionContainerElementOfCatchParameterElement(
            Object cp_element) {
        // TODO catch-parameters ???
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getFilenameOfFileElement(java.lang.Object)
     */
    protected String getFilenameOfFileElement(Object file_element) {
        
        CompilationUnit op_comp_unit = (CompilationUnit) file_element;
        
        ProjectListEntry pe = OPProjectManager.getProjectListEntry(op_comp_unit.getCorrespondingScope().getName());

        return pe.getFilename();
        
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getPackagenameOfPackageElement(java.lang.Object)
     */
    protected String getPackagenameOfPackageElement(Object package_element) {
        Scope compilation_unit_scope  = (Scope)package_element;
        return compilation_unit_scope.getName();
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getTypenameOfPrimitiveTypeElement(java.lang.Object)
     */
    protected String getTypenameOfPrimitiveTypeElement(
            Object primitive_type_element) {
        
        return ((Symbol)primitive_type_element).getName();

        /*
        if (primitiveTypeNameMap.containsKey(primitive_type_element)) { 
            return (String)primitiveTypeNameMap.get(primitive_type_element);
        } else {
            return null;
        }
        */
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getNameOfClassElement(java.lang.Object)
     */
    protected String getNameOfClassElement(Object class_element) {
        Type class_type_op = (Type)class_element;
        
        // MB : For debugging purposes return the fqn :
        // return class_type_op.getFullName();
        return class_type_op.getName();
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getPositionOfElement(java.lang.Object)
     */
    protected Position getPositionOfElement(Object element) {
        // TODO Position of Elements
        
        if (element instanceof Symbol) {
            Symbol symbol = (Symbol)element;
            
            Scope container_scope = symbol.getScope();
            
            // GET FILE-INFORMATION
            
            CompilationUnit compilation_unit = null; 
                
            if (container_scope==null) {
                Debug.warning("getPositionOfElement(): container_scope was null! for symbol "+symbol.toString());
            } else {
            
            // get corresponding scope
            //Scope corresponding_scope = container_scope.get
            
             compilation_unit = container_scope.getCompilationUnit();
            }

            if (compilation_unit==null){
                //Debug.warning("getPositionOfElement(): compilation_unit was null!! (for symbol: "+symbol.getFullName()+") ");
            
            } else {
            
            // get file for position
            
            File file_metamod = (File) mapper.getInstance(compilation_unit);

            if (file_metamod==null){
                //Debug.warning("getPositionOfElement(): file for compilation_unit was null!!  (for symbol: "+symbol.getFullName()+") ");
                // we take unknown file-object instead
                file_metamod = this.getUnknownFileObject();
            }

            // GET LINE/COLUMN-INFORMATION
            
            PositionElement posElement = symbol.getPositionElement();

            int start_line=-1;
            int start_column=-1;
            int end_line=-1;
            int end_column=-1;

            if (posElement != null) {
                start_line = posElement.getStartLine();
                start_column = posElement.getStartColumn();
                end_line = posElement.getEndLine();
                end_column = posElement.getEndColumn();
            } else {
                Debug.warning("PositionElement for Symbol was null: "+symbol.toString());
            }
            
            Position position = new Position(file_metamod, start_line, start_column, end_line, end_column);
            
            return position;

            }
            
        }
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getBaseTypeOfArrayElement(java.lang.Object)
     */
    protected Object getBaseTypeOfArrayElement(Object array_element) {
        // TODO BaseType of Array - dimensionen / verschachtelung ???
        
        ArrayType array_type = (ArrayType)array_element;
        
        return array_type.getArrayType();
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getNameOfFunctionElement(java.lang.Object)
     */
    protected String getNameOfFunctionElement(Object function_element) {
        Method method_element = (Method)function_element;
        
        return method_element.getName();
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getNameOfFieldElement(java.lang.Object)
     */
    protected String getNameOfFieldElement(Object field_element) {
        Attribute attribute_element = (Attribute)field_element;
        
        return attribute_element.getName();
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getFormalParameterElements(java.lang.Object)
     */
    protected List getFormalParameterElements(Object function_element) {
        Method method_element = (Method)function_element;
        
        return method_element.getParameters(); 
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getNameOfFormalParameterElement(java.lang.Object)
     */
    protected String getNameOfFormalParameterElement(Object fp_element) {
        
        if (fp_element instanceof Attribute) {
            Attribute attribute_element = (Attribute)fp_element;
            
            return attribute_element.getName();
        }
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getTypeElementOfFormalParameterElement(java.lang.Object)
     */
    protected Object getTypeElementOfFormalParameterElement(Object fp_element) {
        
        if (fp_element instanceof Attribute) {
            Attribute attribute_element = (Attribute)fp_element;
            
            return attribute_element.getType();
        }
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getLocalVariableElements(java.lang.Object)
     */
    protected List getLocalVariableElements(Object function_element) {
        // TODO Local Variable Elements - Implement Retrieval via Scopes !!!
        Vector lv_elements = new Vector();
        
        Method method_element = (Method)function_element;
        
        Scope corresponding_scope = method_element.getCorrespondingScope();
        /*
        Iterator symbol_itr = corresponding_scope.getSymbolTable().iterator();
        
        while(symbol_itr.hasNext()) {
            Symbol symbol = (Symbol)symbol_itr.next();
            
            if (symbol.isInstanceOf("Attribute")) {
                lv_elements.add(symbol);
            }
            
        }
        */
        return lv_elements;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getNameOfLocalVariableElement(java.lang.Object)
     */
    protected String getNameOfLocalVariableElement(Object lv_element) {
       
        if (lv_element instanceof Attribute) {
            Attribute attribute_element = (Attribute)lv_element;
            
            return attribute_element.getName();
        }
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getTypeElementOfLocalVariableElement(java.lang.Object)
     */
    protected Object getTypeElementOfLocalVariableElement(Object lv_element) {
        
        if (lv_element instanceof Attribute) {
            Attribute attribute_element = (Attribute)lv_element;
            
            return attribute_element.getType();
        }
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getTypeElementOfFieldElement(java.lang.Object)
     */
    protected Object getTypeElementOfFieldElement(Object field_element) {
        if (field_element instanceof Attribute) {
            Attribute attribute_element = (Attribute)field_element;
            
            return attribute_element.getType();
        }
        
        return null;
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getNameOfGlobalVariableElement(java.lang.Object)
     */
    protected String getNameOfGlobalVariableElement(Object gv_element) {
        Attribute  attrb = (Attribute)gv_element;
        
        return attrb.getName();
    }

    /* (non-Javadoc)
     * @see de.fzi.sissy.extractors.meta.GeneralCollector#getTypeElementOfGlobalVariableElement(java.lang.Object)
     */
    protected Object getTypeElementOfGlobalVariableElement(Object gv_element) {
        Attribute  attrb = (Attribute)gv_element;

        // FIXME exact type-resolution in ANTLR grammar necessary !!!
        if (attrb.getType()==null)
            return OPProjectManager.getConstantType();
        
        return attrb.getType();
    }

    protected String getNameOfPropertyElement(Object property_element) {
        Property property = (Property)property_element;
        return property.getName();
    }

    protected Object getTypeElementOfPropertyElement(Object property_element) {
        Property property = (Property)property_element;
        return property.getType();
    }

    protected Object getGetterElementOfPropertyElement(Object property_element) {
        Property property = (Property)property_element;
        return property.getGetter();
    }

    protected Object getSetterElementOfPropertyElement(Object property_element) {
        Property property = (Property)property_element;
        return property.getSetter();
    }

    
    protected boolean classElementIsInterface(Object class_element) {
        if (!(class_element instanceof ClassType))
            return false;
            
        ClassType class_type = (ClassType)class_element;
        return class_type.isInterface();
    }

    
    protected boolean classElementIsReferenceType(Object class_element) {
        // always true !
        //ClassType class_type = (ClassType)class_element;
        return true;
    }

    
    public boolean classElementIsExternal(Object class_element) {
        // always false
        return false;
    }

    
    public boolean classElementIsInternal(Object class_element) {
        // always false
        return false;
    }

    
    public boolean classElementIsNew(Object class_element) {
        // TODO new/override of classes
        //ClassType class_type = (ClassType)class_element;
        return true;
    }

    
    public boolean classElementIsPrivate(Object class_element) {
        // always false
        return false;
    }

    
    public boolean classElementIsProtected(Object class_element) {
        // always false
        return false;
    }

    // MB: types declared in the interface section of a unit are public
    public boolean classElementIsPublic(Object class_element) {
    	Type class_type = (Type) class_element; 
        return class_type.isInterfaceDeclaration();
    }

    
    // MB: Types declared in the implementation section of a unit have 'package' visibility
    public boolean classElementIsPackage(Object class_element) {
        Type class_type = (Type) class_element; 
        return !class_type.isInterfaceDeclaration();
    }

    
    public boolean classElementIsStatic(Object class_element) {
        // always false
        return false;
    }

    
    public boolean classElementIsFinal(Object class_element) {
        // always false
        return false;
    }

    
    public boolean functionElementIsExternal(Object function_element) {
        // always false
        return false;
    }

    
    public boolean functionElementIsInternal(Object function_element) {
        // always false
        return false;
    }

    
    public boolean functionElementIsNew(Object function_element) {
        Method method = (Method)function_element;
        return !method.isOverride();
    }

    
    public boolean functionElementIsPrivate(Object function_element) {
        Method method = (Method)function_element;
        // MB: In Delphi, private methods are declared as strictly private.
        return method.getVisibility()==Method.STRICTLYPRIVATE;
    }

    
    public boolean functionElementIsProtected(Object function_element) {
        Method method = (Method)function_element;
        return method.getVisibility()==Method.PROTECTED;
    }

    // MB : published and automated methods are considered as public!
    public boolean functionElementIsPublic(Object function_element) {
        Method method = (Method)function_element;
        return (method.getVisibility()==Method.PUBLIC) 
        	|| (method.getVisibility()==Method.PUBLISHED)
        	|| (method.getVisibility() == Method.AUTOMATED);
    }

    // MB : Delphi's private members are comparable to Java's package (default) visibility
    public boolean functionElementIsPackage(Object function_element) {
        Method method = (Method)function_element;
        return method.getVisibility()==Method.PRIVATE;
    }

    
    public boolean functionElementIsStatic(Object function_element) {
        Method method = (Method)function_element;
        return method.isClassMethod();
    }

    
    public boolean functionElementIsFinal(Object function_element) {
        // always false
        return false;
    }

    public boolean functionElementIsVirtual(Object function_element) {
    	Method method = (Method) function_element;
    	return (method.isVirtual() || method.isOverride());
    }
    
    public boolean functionElementIsIntrospectable(Object function_element) {
    	Method method = (Method) function_element;
    	return (method.isPublished());
    }
    
    public boolean functionElementIsUnitInitializer(Object function_element) {
    	Method method = (Method) function_element;
    	return (method.getCategory()==Method.UNIT_INITIALIZER);
    }
    
    public boolean functionElementIsUnitFinalizer(Object function_element) {
    	Method method = (Method) function_element;
    	return (method.getCategory()==Method.UNIT_FINALIZER);
    }
    
    public boolean fieldElementIsExternal(Object field_element) {
        // always false;
        return false;
    }

    
    public boolean fieldElementIsInternal(Object field_element) {
        // always false;
        return false;
    }

    
    public boolean fieldElementIsNew(Object field_element) {
        // TODO Properly check attribute hiding issues
        Attribute attrib = (Attribute)field_element;
        return true;
    }

    
    public boolean fieldElementIsPrivate(Object field_element) {
        Attribute attrib = (Attribute)field_element;
        return attrib.getVisibility() == Attribute.STRICTLYPRIVATE;
    }

    
    public boolean fieldElementIsProtected(Object field_element) {
        Attribute attrib = (Attribute)field_element;
        return attrib.getVisibility() == Attribute.PROTECTED;
    }

    // MB : Published and automated attributes are considered as public
    public boolean fieldElementIsPublic(Object field_element) {
        Attribute attrib = (Attribute)field_element;
        return (attrib.getVisibility()== Attribute.PUBLIC) 
    	|| (attrib.getVisibility()== Attribute.PUBLISHED)
    	|| (attrib.getVisibility() == Attribute.AUTOMATED);
    }

    
    // MB : Delphi's private is translated into package
    public boolean fieldElementIsPackage(Object field_element) {
        Attribute attrib = (Attribute)field_element;
        return attrib.getVisibility() == Attribute.PRIVATE;
    }

    
    public boolean fieldElementIsStatic(Object field_element) {
        // TODO static for fields ???
        return false;
    }

    
    public boolean fieldElementIsFinal(Object field_element) {
        // TODO final of fields ???
        return false;
    }

    public boolean fieldElementIsIntrospectable(Object field_element) {
    	Attribute attrib = (Attribute) field_element;
    	return (attrib.isPublished());
    }

    
    
    public boolean arrayElementIsReferenceType(Object array_element) {
        // TODO array-referencetype ???
        return true;
    }

    
    public Object getReturnTypeElementOfFunctionElement(Object function_element) {
        Method method = (Method)function_element;
        
        // TODO ReturnType abgleichen?
        
        switch (method.getCategory()) {
            case Method.FUNCTION:
                return method.getType();
    
            case Method.PROCEDURE:
            case Method.CONSTRUCTOR:
            case Method.DESTRUCTOR:
                
                //return method.getReturnType();
        }
        
        return null;
    }

    
    public boolean globalVariableElementIsConst(Object global_variable_element) {
        // TODO const-setup of attributes ???
        Attribute attrb = (Attribute)global_variable_element;
        return false;
    }

    
    protected Object getSetterElementOfpropertyElement(Object property_element) {
        Property property = (Property)property_element;
        return property.getSetter();
    }

    
    protected Object getGetterElementOfpropertyElement(Object property_element) {
        Property property = (Property)property_element;
        return property.getGetter();
    }

    
    public boolean propertyElementIsExternal(Object property_element) {
        // always false
        return false;
    }

    
    public boolean propertyElementIsInternal(Object property_element) {
        // always false
        return false;
    }

    
    public boolean propertyElementIsNew(Object property_element) {
        // TODO new/override of properties ???
        return true;
    }

    
    public boolean propertyElementIsPrivate(Object property_element) {
        Property property = (Property)property_element;
        return property.getVisibility() == Property.PRIVATE;
    }

    
    public boolean propertyElementIsProtected(Object property_element) {
        Property property = (Property)property_element;
        return property.getVisibility() == Property.PROTECTED;
    }

    
    public boolean propertyElementIsPublic(Object property_element) {
        Property property = (Property)property_element;
        return property.getVisibility() == Property.PUBLIC;
    }

    
    public boolean propertyElementIsPackage(Object property_element) {
        Property property = (Property)property_element;
        return false;
    }

    
    public boolean propertyElementIsStatic(Object property_element) {
        // TODO static-setup of property?
        return false;
    }

    
    public boolean propertyElementIsFinal(Object property_element) {
        // TODO final-setup of property?
        return false;
    }
    
    public boolean propertyElementIsIntrospectable(Object property_element) {
        Property property = (Property)property_element;
        return property.isPublished();
    }

    
    public Object getClassContainerElementOfPropertyElement(Object property_element) {
        Property property = (Property)property_element;

        Scope scope = property.getScope();
        Symbol corr_symbol = scope.getCorrespondingSymbol();
        
        if ((corr_symbol != null) && corr_symbol.isInstanceOf("ClassType")) {
            return corr_symbol;
        } else {
            Debug.warning("ClassContainer of PropertyElement not found!");
            return null;
        }
    }

    
/*
 * TODO: This does not work! Computing the subclasses is not so simple...
 */  
/*
 	public Collection getSubClassElementsOfClassElement(Object class_element) {
    	if (class_element instanceof ClassType) {
             ClassType class_type = (ClassType)class_element;
             return class_type.getSuperClasses();
        } else {
            Debug.warning("Check Type for Class-Element: "+ class_element.getClass().getName());
            return null;
        }
    }
*/
    
    public Object getFunctionElementToFunctionAccessElement(Object function_access_element) {
        OutputPair op = (OutputPair)function_access_element;
        return op.getSymbol();
    }

    
    public Object getContainerStatementOfFunctionAccessElement(Object function_access_element) {
        OutputPair op = (OutputPair)function_access_element;
        
       if (op.getCurrentStatement()!=null) {
           return op.getCurrentStatement();
       } else {
           return this.getContainerMethodBodyStatementOfAccessElement(op);
       }
    }

    
    public Object getVariableElementToVariableAccessElement(Object variable_access_element) {
        OutputPair op = (OutputPair)variable_access_element;
        return op.getSymbol();
    }

    
    public Object getContainerStatementOfVariableAccessElement(Object variable_access_element) {
        OutputPair op = (OutputPair)variable_access_element;
        if (op.getCurrentStatement()!=null) {
            return op.getCurrentStatement();
        } else {
            return this.getContainerMethodBodyStatementOfAccessElement(op);
        }
    }

    
    public boolean isWritingVariableAccess(Object variable_access_element) {
        return false;
    }
    
    private Object getContainerMethodBodyStatementOfAccessElement(Object access_element) {
        OutputPair op = (OutputPair)access_element;
        
        Scope container_scope = op.getScope();
        
        if (container_scope!=null) {
            Symbol corresponding_container_symbol = container_scope.getCorrespondingSymbol();
            if (corresponding_container_symbol!=null) {
                Object mapped_metamod_container = mapper.getInstance(corresponding_container_symbol);
                
                if (mapped_metamod_container!=null) {
                    if (mapped_metamod_container instanceof de.fzi.sissy.metamod.Function) {
                        de.fzi.sissy.metamod.Function function_metamod = (de.fzi.sissy.metamod.Function)mapped_metamod_container;
                        return function_metamod.getBody();
                    } else {
                        Debug.verbose("findbody: mapped container was not metamod-Function, but "+mapped_metamod_container.getClass().getName());
                        return null;
                    }
                } else {
                    Debug.verbose("findbody: mapped container was null!");
                    return null;
                }
            } else {
                Debug.verbose("findbody: Container-Symbol was null!");
                return null;
            }
        } else {
            Debug.verbose("findbody: Container-Scope was null!");
            return null;
        }
        
    }

    
    public Object getTypeElementToTypeCastAccessElement(Object typecast_access_element) {
        OutputPair op = (OutputPair)typecast_access_element;
        return op.getSymbol();
    }

    
    public Object getContainerStatementOfTypeCastAccessElement(Object typecast_access_element) {
        OutputPair op = (OutputPair)typecast_access_element;
        if (op.getCurrentStatement()!=null) {
            return op.getCurrentStatement();
        } else {
            return this.getContainerMethodBodyStatementOfAccessElement(op);
        }
    }

    public boolean functionElementIsProcedure(Object function_element) {
        Method method = (Method)function_element;
        return method.getCategory() == Method.PROCEDURE;
    }

    public boolean functionElementIsFunction(Object function_element) {
        Method method = (Method)function_element;
        return method.getCategory() == Method.FUNCTION;
    }

    public boolean functionElementIsAbstract(Object function_element) {
        Method method = (Method)function_element;
        return method.isAbstract();
    }

    public Object getPackageContainerElementOfGlobalFunctionElement(Object global_function_element) {
        Method method = (Method)global_function_element;
        
        // TODO package resolution ??
        
        if (method.getScope()!=null && method.getScope().getCompilationUnit()!=null) {
        	// MB : Use *corresponding* scope !
            Scope compilation_unit_scope = method.getScope().getCompilationUnit().getCorrespondingScope();

            if (compilation_unit_scope == null) {
                Debug.warning("getPackageContainerElementOfGlobalFunctionElement(): corresondingscope was null! for method: "+ method.getFullName());
            }
            
            return compilation_unit_scope;
        } else {
            if (method.getScope()==null) {
                Debug.warning("getPackageContainerElementOfGlobalFunctionElement(): scope was null! for method: "+ method.getFullName());
            } else if (method.getScope().getCompilationUnit()==null) {
                Debug.warning("getPackageContainerElementOfGlobalFunctionElement(): scope.compilationUnit was null! for method: "+ method.getFullName());
            }
            
            return null;
        }
    }

    public Object getPackageContainerElementOfGlobalVariableElement(Object global_variable_element) {
        Attribute attrb = (Attribute)global_variable_element;

        // TODO package resolution ??

        if (attrb.getScope()!=null && attrb.getScope().getCompilationUnit()!=null) {
        	// MB : Use *corresponding scope *
            Scope compilation_unit_scope = attrb.getScope().getCompilationUnit().getCorrespondingScope();

            return compilation_unit_scope;
        }  else {
            return null;
        }
        
    }

    public Object getPackageContainerElementOfClassElement(Object class_element) {
        Type type = (Type)class_element;

        // TODO package resolution ??

        if (type.getScope()!=null && type.getScope().getCompilationUnit()!=null) {
        
            Scope compilation_unit_scope = type.getScope().getCompilationUnit().getCorrespondingScope();
            
            if (compilation_unit_scope==null) {
                Debug.warning("getPackageContainerElementOfClassElement(): compilation_unit_scope was null!");
            }            
            
            return compilation_unit_scope;
        
        } else {
            if (type.getScope()==null) {
                Debug.warning("getPackageContainerElementOfClassElement(): type.getScope() was null! for type: "+ type.getFullName());
            } else if (type.getScope().getCompilationUnit()==null) {
                Debug.warning("getPackageContainerElementOfClassElement(): type.getScope().getCompilationUnit() was null! for type: "+ type.getFullName());
            }
            return null;
        }
    }

    public String getNameOfDelegateElement(Object delegate_element) {
        ProceduralType pt = (ProceduralType) delegate_element;
        
        return pt.getName();
    }

    public String getNameOfReferenceElement(Object reference_element) {
        PointerType pointer_type = (PointerType) reference_element;
        
        return pointer_type.getName();
    }

    public Object getReferencedTypeElementOfReferenceElement(Object reference_element) {
        PointerType pointer_type = (PointerType) reference_element;

        // TODO What exactly is the Referenced Type for PointerType ??
        
        return pointer_type.getBaseType();
    }

    public String getNameOfTypeAliasElement(Object typealias_element) {
        UserDefinedType ud_type = (UserDefinedType)typealias_element;
        
        return ud_type.getName();
    }

    public Object getAliasedTypeElementOfTypeAliasElement(Object typealias_element) {
        UserDefinedType ud_type = (UserDefinedType)typealias_element;

        // TODO What exactly is the aliased type in case of UserDefinedType ??
        
        return ud_type.getBaseType();
    }

    
    // MB: Type aliases belong to packages as well, at least for Delphi
    public Object getPackageContainerElementOfTypeAliasElement(Object typealias_element) {
        Type type = (Type)typealias_element;

        if (type.getScope()!=null && type.getScope().getCompilationUnit()!=null) {
        
        	// MB : Get the *corresponding* scope for the compilation unit
        	Scope compilation_unit_scope = type.getScope().getCompilationUnit().getCorrespondingScope();
            
            return compilation_unit_scope;
        
        } else {
            return null;
        }
    }

    public Object getTargetClassElementOfSelfAccessElement(Object self_access_element) {
        OutputPair output_pair = (OutputPair)self_access_element;
        
        Symbol accessed_symbol = (Symbol)output_pair.getSymbol();
        
        return getContainerClassElementOfSymbol(accessed_symbol);
    }

    public Object getContainerStatementOfSelfAccessElement(Object self_access_element) {
        OutputPair output_pair = (OutputPair)self_access_element;
       
        if (output_pair.getCurrentStatement()!=null) {
            return output_pair.getCurrentStatement();
        } else {
            return this.getContainerMethodBodyStatementOfAccessElement(output_pair);
        }
    }

    public Object getTypeClassElementOfRunTimeTypeAccessElement(Object runtime_type_access_element) {
        OutputPair output_pair = (OutputPair)runtime_type_access_element;
        
        Symbol accessed_symbol = (Symbol)output_pair.getSymbol();
        
        return accessed_symbol;
    }

    public Object getContainerStatementOfRunTimeTypeAccessElement(Object runtime_type_access_element) {
        OutputPair output_pair = (OutputPair)runtime_type_access_element;
        
        if (output_pair.getCurrentStatement()!=null) {
           return output_pair.getCurrentStatement();
        } else {
            return this.getContainerMethodBodyStatementOfAccessElement(output_pair);
        }
    }

    public Object getTypeClassElementOfStaticTypeAccessElement(Object static_type_access_element) {
        OutputPair output_pair = (OutputPair)static_type_access_element;
        
        Symbol accessed_symbol = (Symbol)output_pair.getSymbol();
        
        return accessed_symbol;
    }

    public Object getContainerStatementOfStaticTypeAccessElement(Object static_type_access_element) {
        OutputPair output_pair = (OutputPair)static_type_access_element;
        
        if (output_pair.getCurrentStatement()!=null) {
           return output_pair.getCurrentStatement();
        } else {
            return this.getContainerMethodBodyStatementOfAccessElement(output_pair);
        }
    }


}
