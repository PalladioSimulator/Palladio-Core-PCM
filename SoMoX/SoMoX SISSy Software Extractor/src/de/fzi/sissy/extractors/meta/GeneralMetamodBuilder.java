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
import java.util.Iterator;
import java.util.Vector;

import de.fzi.delphi.symbols.Symbol;
import de.fzi.delphi.symbols.types.ClassType;
import de.fzi.sissy.extractors.delphi.OutputPair;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.extractors.java.builders.ClassTypeBuilder;
import de.fzi.sissy.extractors.java.builders.RecoderToOMMapper;
import de.fzi.sissy.extractors.java.builders.StatementViewer;
import de.fzi.sissy.metamod.Package;
import de.fzi.sissy.metamod.Array;
import de.fzi.sissy.metamod.BlockStatement;
import de.fzi.sissy.metamod.CastTypeAccess;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Constructor;
import de.fzi.sissy.metamod.DeclarationTypeAccess;
import de.fzi.sissy.metamod.Delegate;
import de.fzi.sissy.metamod.Destructor;
import de.fzi.sissy.metamod.Field;
import de.fzi.sissy.metamod.File;
import de.fzi.sissy.metamod.FormalParameter;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.FunctionAccess;
import de.fzi.sissy.metamod.GlobalFunction;
import de.fzi.sissy.metamod.GlobalVariable;
import de.fzi.sissy.metamod.InheritanceTypeAccess;
import de.fzi.sissy.metamod.LocalVariable;
import de.fzi.sissy.metamod.Member;
import de.fzi.sissy.metamod.Method;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.NamedModelElement;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.Property;
import de.fzi.sissy.metamod.PropertyAccess;
import de.fzi.sissy.metamod.Reference;
import de.fzi.sissy.metamod.RunTimeTypeAccess;
import de.fzi.sissy.metamod.SelfAccess;
import de.fzi.sissy.metamod.SimpleStatement;
import de.fzi.sissy.metamod.SourceEntity;
import de.fzi.sissy.metamod.Statement;
import de.fzi.sissy.metamod.StaticTypeAccess;
import de.fzi.sissy.metamod.Type;
import de.fzi.sissy.metamod.TypeAlias;
import de.fzi.sissy.metamod.Variable;
import de.fzi.sissy.metamod.VariableAccess;
import de.fzi.sissy.util.Debug;

/**
 * @author stammel
 *
 */
public abstract class GeneralMetamodBuilder {
    
    protected GeneralCollector collector;
    protected GeneralMapper mapper;
 	protected ModelElementRepository modelElementRepository;

 	protected StatementViewer sv;
    
    public GeneralMetamodBuilder(GeneralCollector collector, GeneralMapper mapper, ModelElementRepository modelElementRepository) {
        this.collector = collector;
        this.mapper = mapper;
        this.modelElementRepository = modelElementRepository;
    }

    public void setup() {
    }
    
    
    public void buildAll() {
        Debug.info("building files...");
        buildFiles();
        
        Debug.info("building packages...");
        buildPackages();
        
        
        Debug.info("building primitive types...");
        buildPrimitiveTypes();
        Debug.info("building classes...");
        buildClasses();
        Debug.info("building arrays...");
        buildArrays();
        
        Debug.info("building functions...");
        buildFunctions();
        
        buildDelegates();
        Debug.info("building references...");
        buildReferences();
        Debug.info("building type aliases...");
        buildTypeAliases();
        
        Debug.info("building variables...");
        buildVariables();

        Debug.info("building imports...");
        buildImports();
        
        Debug.info("building accesses...");
        buildAccesses();
        
        establishContainmentRelations();
        
        Debug.info("adding projects as structural abstractions");
        buildDefaultAbstractions();
        
        //createStatementViewer();
    }

    protected void buildFiles() {
        
	    Iterator fe_itr = this.collector.getFileElements().iterator();
	    
	    building:
	    while (fe_itr.hasNext()) {
	        Object file_element = fe_itr.next(); 
	
            buildFile(file_element);
	    }
        
    }
    
    protected void buildFile(Object file_element) {
        
        if (alreadyMapped(file_element)) {
            Debug.warning("tried to build duplicate fileobject, prevented");
            return;
        }

        // get filename
        String filename = this.collector.getFilenameOfFileElement(file_element);
        
        if (filename==null) {
            Debug.warning("buildFiles(): returned filename was null!");
            return;
        }
        
        // creation
        File file_metamod = new File(filename);
        
        // mapping
        this.mapper.addInstance(file_element, file_metamod);
        
        // root-connection
        modelElementRepository.getRoot().addFile(file_metamod);
        
    }

    public abstract void buildImportedPackages(Object file_element, File file_metamod);

    
    protected void buildPackages() {
        
	    Iterator itr = this.collector.getPackageElements().iterator();
	    
	    building:
	    while (itr.hasNext()) {
	        Object package_element = itr.next();
            
            buildPackage(package_element);
	    }
    }
    
    protected void buildPackage(Object package_element) {
        if (alreadyMapped(package_element)) {
            Debug.warning("buildPackage(): tried to build duplicate packageobject, prevented");
            return;
        }
        
        // get packagename
        String packagename = this.collector.getPackagenameOfPackageElement(package_element);
        
        if (packagename==null) {
            Debug.warning("buildPackage(): returned packagename was null!");
            return;
        }
        
        // creation
        de.fzi.sissy.metamod.Package package_metamod =
            new de.fzi.sissy.metamod.Package(packagename, modelElementRepository.getRoot());
        
        // TODO package setup 
        
        // mapping
        this.mapper.addInstance(package_element, package_metamod);
        
        // root
        modelElementRepository.getRoot().addPackage(package_metamod);
        
    }
    
    protected void buildPrimitiveTypes() {
        
	    Iterator itr = this.collector.getPrimitiveTypeElements().iterator();
	    
	    building:
	    while (itr.hasNext()) {
	        Object ptype_element = itr.next(); 

	        buildPrimitiveType(ptype_element);
	    }
        
    }
    
    protected void buildPrimitiveType(Object ptype_element) {
        
        if (alreadyMapped(ptype_element)) {
            Debug.warning("tried to build duplicate primitivetype-object, prevented");
            return;
        }

        // get typename
        String name = this.collector.getTypenameOfPrimitiveTypeElement(ptype_element);
        
        if (name==null) {
            Debug.warning("buildPrimitiveTypes(): returned typename was null!");
            return;
        }
        
        // creation
		Class pt_class_metamod = new Class(name);
		
		// set primitive class
		pt_class_metamod.setPrimitive();
        
        // mapping
        this.mapper.addInstance(ptype_element, pt_class_metamod);
        
        // root-connection
        modelElementRepository.getRoot().addType(pt_class_metamod);
        
    }
    
    protected void buildClasses() {
        
	    Iterator itr = this.collector.getClassElements().iterator();
	    
	    building:
	    while (itr.hasNext()) {
	        Object class_element = itr.next(); 
	        
            buildClass(class_element);
	    }
        
    }
 
    protected void buildClass(Object class_element) {

        if (alreadyMapped(class_element)) {
            Debug.warning("tried to build duplicate class object, prevented");
            return;
        }
        
        // get class-name
        String name = this.collector.getNameOfClassElement(class_element);


        if (name==null) {
            Debug.warning("buildClasses(): returned classname was null!");
            return;
        }
        
        // creation
        Class class_metamod = new Class(name);

        // TODO class setup
        
        // interface
        setupClassInterface(class_element, class_metamod);

        // referencetype
        setupClassReferencetype(class_element, class_metamod);

        // position
        setupPosition(class_element, class_metamod);
        
        // modifiers
        setupClassModifiers(class_element, class_metamod);
        
        // mapping
        this.mapper.addInstance(class_element, class_metamod);
        
        // TODO connect with package/file
        establishClassPackageContainmentRelation(class_element, class_metamod);
        
    }

    protected void establishClassPackageContainmentRelation(Object class_element, Class class_metamod) {
        
        Object package_container_element = collector.getPackageContainerElementOfClassElement(class_element);
        
        if (package_container_element==null) {
            Debug.warning("establishClassPackageContainmentRelation(): package container element for " 
            		+ class_element.toString() + " was null!");
            return;
        }
        
        de.fzi.sissy.metamod.Package container_package = (de.fzi.sissy.metamod.Package)mapper.getInstance(package_container_element);

        if (container_package==null) {
            Debug.warning("establishClassPackageContainmentRelation(): mapped container metamod package for "
            		+ package_container_element.toString() + " was null!");
            return;
        }

        container_package.addClass(class_metamod);
        
    }
    
    // MB: Type aliases are defined in packages...
    protected void establishTypeAliasPackageContainmentRelation(Object typealias_element, TypeAlias class_metamod) {
    	
    	Object package_container_element = collector.getPackageContainerElementOfClassElement(typealias_element);
        
        if (package_container_element==null) {
            Debug.warning("establishTypeAliasPackageContainmentRelation(): package container element for " 
            		+ typealias_element.toString() + " was null!");
            return;
        }
        
        de.fzi.sissy.metamod.Package container_package = (de.fzi.sissy.metamod.Package)mapper.getInstance(package_container_element);

        if (container_package==null) {
            Debug.warning("establishTypeAliasPackageContainmentRelation(): mapped container metamod package for "
            		+ package_container_element.toString() + " was null!");
            return;
        }

        container_package.addTypeAlias(class_metamod);

    }
    
    
    protected boolean alreadyMapped(Object key) {
        return (this.mapper.getInstance(key)!=null);
    }
    
    protected void setupPosition(Object src_element, SourceEntity metamod_element ) {

        Position position_metamod = collector.getPositionOfElement(src_element);
        
		if (position_metamod == null) {
			Debug.warning("Null-Position setted for " + metamod_element.getClass().getName());
            return;
        }
     
        metamod_element.setPosition(position_metamod);
    }
    
    protected void setupClassInterface(Object class_element, Class class_metamod) {
        if (this.collector.classElementIsInterface(class_element)) {
            class_metamod.setInterface();
        }
    }
    
    protected void setupClassReferencetype(Object class_element, Class class_metamod) {
        if (this.collector.classElementIsReferenceType(class_element)) {
            class_metamod.setReferenceType();
        } else {
            class_metamod.setValueType();
        }
        
    }
    
    protected void setupClassModifiers(Object class_element, Class class_metamod) {
        
        if (this.collector.classElementIsExternal(class_element)) {
            class_metamod.setExtern(true);
        } else {
            class_metamod.setExtern(false);
        }
        
        if (this.collector.classElementIsInternal(class_element)) {
            class_metamod.setInternal(true);
        } else {
            class_metamod.setInternal(false);
        }

        if (this.collector.classElementIsNew(class_element)) {
            class_metamod.setNew();
        } else {
            class_metamod.setOverride();
        }

        if (this.collector.classElementIsPrivate(class_element)) {
            class_metamod.setPrivate();
        } else
        if (this.collector.classElementIsProtected(class_element)) {
            class_metamod.setProtected();
        } else
        if (this.collector.classElementIsPublic(class_element)) {
            class_metamod.setPublic();
        } else
        if (this.collector.classElementIsPackage(class_element)) {
            class_metamod.setPackage();
        } else {
            // default public
            class_metamod.setPublic();
        }
        
        if (this.collector.classElementIsStatic(class_element)) {
            class_metamod.setStatic(true);
        } else {
            class_metamod.setStatic(false);
        }
        
        if (this.collector.classElementIsFinal(class_element)) {
            class_metamod.setFinal(true);
        } else {
            class_metamod.setFinal(false);
        }
                
    }
    
    protected void buildArrays() {
        
	    Iterator itr = this.collector.getArrayElements().iterator();
	    
	    building:
	    while (itr.hasNext()) {
	        Object array_element = itr.next(); 
	        
	        if (alreadyMapped(array_element)) {
	            Debug.warning("tried to build duplicate array object, prevented");
	            continue building;
	        }
	        
	        // get base-type
			Object base_type_element = collector.getBaseTypeOfArrayElement(array_element);
			de.fzi.sissy.metamod.Type base_type_metamod = (de.fzi.sissy.metamod.Type)mapper.getInstance(base_type_element);
						
			if (base_type_metamod == null) {
	            Debug.warning("buildArrays(): base type for "
	            		+ array_element.toString() + " was null!");
				
			} else {

				// TODO array setup
				de.fzi.sissy.metamod.Array array_metamod = new de.fzi.sissy.metamod.Array(base_type_metamod);
					
				// referencetype
				setupArrayReferencetype(array_element, array_metamod);
	
		        // mapping
		        this.mapper.addInstance(array_element, array_metamod);
		        
		        // root-connection
		        modelElementRepository.getRoot().addType(array_metamod);

			}
	    }
        
    }

    protected void setupArrayReferencetype(Object array_element, Array array_metamod) {
        if (this.collector.arrayElementIsReferenceType(array_element)) {
            array_metamod.setReferenceType();
        } else {
            array_metamod.setValueType();
        }
    }
    
    protected final void buildFunctions() {
        Debug.info("\tbuilding global functions...");
        buildGlobalFunctions();
        Debug.info("\tbuilding methods...");
        buildMethods();
        Debug.info("\tbuilding constructors...");
        buildConstructors();
        Debug.info("\tbuilding destructors...");
        buildDestructors();
    }
    
    protected void buildGlobalFunctions() {
        
        Iterator itr = this.collector.getGlobalFunctionElements().iterator();
        Debug.info("building global functions: "+this.collector.getGlobalFunctionElements().size());
	    
	    building:
 	    while (itr.hasNext()) {
 	        Object global_function_element = itr.next(); 
	    
            buildGlobalFunction(global_function_element);
	    }
        
    }
    
    protected void buildGlobalFunction(Object global_function_element) {
        
        if (alreadyMapped(global_function_element)) {
            Debug.warning("tried to build duplicate glob. function object "
            		+ global_function_element.toString() + ", prevented");
            return;
        }
        
        // get method-name
        String name = this.collector.getNameOfFunctionElement(global_function_element);
        
        if (name==null) {
            Debug.warning("buildGlobalFunctions(): " + global_function_element.toString() 
            		+ ": returned methodname was null!");
            return;
        }
        
        // creation
        GlobalFunction global_function_metamod = new GlobalFunction(name);

        // mapping
        // TODO Mapping for GlobalFunctions with scope NOT symbol ==> to fix error in function resolution (e. g. local variable)!
        // MB 21.9.2005: This does not work! Therefore I switched back to the old solution!
        // Symptom: Calls to global functions are not added to the meta model at all!
        // this.mapper.addInstance(((de.fzi.delphi.symbols.Method)global_function_element).getCorrespondingScope(), global_function_metamod);
        this.mapper.addInstance(global_function_element, global_function_metamod);
        Debug.info("buildGlobalFunction(): " + global_function_element.toString() +" was mapped!");

        // TODO method setup
        setupFunction(global_function_element, global_function_metamod);
        
        // establish package-containment-relation
        Object package_container_element = collector.getPackageContainerElementOfGlobalFunctionElement(global_function_element);
        
        if (package_container_element==null) {
            Debug.warning("buildGlobalFunction(): " + global_function_element.toString() 
            		+ ": package container element was null!");
            return;
        }

        de.fzi.sissy.metamod.Package container_package = (de.fzi.sissy.metamod.Package)mapper.getInstance(package_container_element);
        
        if (container_package==null) {
            Debug.warning("buildGlobalFunction(): mapped container metamod package was null! for gf: "+ global_function_element.toString());
            return;
        }

        container_package.addGlobalFunction(global_function_metamod);
    }
    
    protected void buildMethods() {
	   
        Iterator itr = this.collector.getMethodElements().iterator();
	    
	    building:
 	    while (itr.hasNext()) {
 	        Object method_element = itr.next(); 
	        
            buildMethod(method_element);

	    }
	    
	}

    protected void buildMethod(Object method_element) {
        if (alreadyMapped(method_element)) {
            Debug.warning("tried to build duplicate method object, prevented");
            return;
        }
        
        // get method-name
        String name = this.collector.getNameOfFunctionElement(method_element);
        
        if (name==null) {
            Debug.warning("buildMethods(): returned methodname was null!");
            return;
        }
        
        // creation
        Method method_metamod = new Method(name);

        // mapping
        this.mapper.addInstance(method_element, method_metamod);
        Debug.verbose("buildMethod()" + method_element.toString() +" was mapped!");
        
        // TODO method setup
        setupFunction(method_element, method_metamod);
        
        establishMethodClassContainmentRelation(method_element, method_metamod);
        
    }

    protected void buildConstructors() {
 	   
        Iterator itr = this.collector.getConstructorElements().iterator();
 	    
 	    building:
 	    while (itr.hasNext()) {
 	        Object constructor_element = itr.next(); 
 	        
            buildConstructor(constructor_element);

 	    }
 	    
 	}

    protected void buildConstructor(Object constructor_element) {

        if (alreadyMapped(constructor_element)) {
                Debug.warning("tried to build duplicate constructor object, prevented");
                return;
            }
            
            // get method-name
            String name = this.collector.getNameOfFunctionElement(constructor_element);
            
            if (name==null) {
                Debug.warning("buildConstructors(): returned name was null!");
                return;
            }
            
            // creation
            Constructor constructor_metamod = new Constructor(name);
    
            // mapping
            this.mapper.addInstance(constructor_element, constructor_metamod);
            Debug.verbose("buildConstructor(): " + constructor_element.toString() +" was mapped!");

            // TODO method setup
            setupFunction(constructor_element, constructor_metamod);

            establishConstructorClassContainmentRelation(constructor_element, constructor_metamod);

    }

    protected void buildDestructors() {
  	   
        Iterator itr = this.collector.getDestructorElements().iterator();
  	    
  	    building:
  	    while (itr.hasNext()) {
  	        Object destructor_element = itr.next(); 
  	        
            buildDestructor(destructor_element);
  	    }
  	    
  	}

    protected void buildDestructor(Object destructor_element) {

            if (alreadyMapped(destructor_element)) {
                Debug.warning("tried to build duplicate destructor object, prevented");
                return;
            }
            
            // get method-name
            String name = this.collector.getNameOfFunctionElement(destructor_element);
            
            if (name==null) {
                Debug.warning("buildDestructors(): returned name was null!");
                return;
            }
            
            // creation
            Destructor destructor_metamod = new Destructor(name);
    
            // mapping
            this.mapper.addInstance(destructor_element, destructor_metamod);
            Debug.verbose("buildDestructor(): " + destructor_element.toString() +" was mapped!");

            // TODO method setup
            setupFunction(destructor_element, destructor_metamod);
            
            establishDestructorClassContainmentRelation(destructor_element, destructor_metamod);
        
    }

    protected void setupFunction(Object function_element, Function function_metamod) {
		// position
        setupFunctionPosition(function_element, function_metamod);
		
		// modifiers -- member-setup and so on 
        setupFunctionModifiers(function_element, function_metamod);

		// returntype
		setupReturntype(function_element, function_metamod);
		
		// formal parameters
		buildFormalParameters(function_element, function_metamod);

		// local variables
		//buildLocalVariables(function_element, function_metamod);
		
		// statement-hierarchie
	    buildStatements(function_element, function_metamod);
    }
    
    protected void establishMethodClassContainmentRelation(Object method_element, Method method_metamod) {
        Object class_container_element = this.collector.getClassContainerElementOfMethodElement(method_element);
        
        if (class_container_element == null) {
            Debug.warning("establishMethodClassContainmentRelation(): class-container-element was null!");
            return;
        }

        Class class_container_metamod = (Class)mapper.getInstance(class_container_element);
        
        if (class_container_metamod == null) {
            Debug.warning("establishMethodClassContainmentRelation(): class-container-metamod was null!");
            return;
        }
        
		// containment
        class_container_metamod.addMethod(method_metamod);
        
        // MB: If the added method is abstract the class *has* to be abstract
        if (method_metamod.isAbstract()) {
        	class_container_metamod.setAbstract(true);
        }
    }
    
    protected void establishConstructorClassContainmentRelation(Object constructor_element, Constructor constructor_metamod) {
        Object class_container_element = this.collector.getClassContainerElementOfConstructorElement(constructor_element);
        
        if (class_container_element == null) {
            Debug.warning("establishConstructorClassContainmentRelation(): class-container-element was null!");
            return;
        }

        Class class_container_metamod = (Class)mapper.getInstance(class_container_element);
        
        if (class_container_metamod == null) {
            Debug.warning("establishConstructorClassContainmentRelation(): class-container-metamod was null!");
            return;
        }
        
		// containment
        class_container_metamod.addConstructor(constructor_metamod);
        
        // MB: If the added method is abstract the class *has* to be abstract
        if (constructor_metamod.isAbstract()) {
        	class_container_metamod.setAbstract(true);
        }

    }
    
    protected void establishDestructorClassContainmentRelation(Object destructor_element, Destructor destructor_metamod) {
        Object class_container_element = this.collector.getClassContainerElementOfDestructorElement(destructor_element);
        
        if (class_container_element == null) {
            Debug.warning("establishDestructorClassContainmentRelation(): class-container-element was null!");
            return;
        }

        Class class_container_metamod = (Class)mapper.getInstance(class_container_element);
        
        if (class_container_metamod == null) {
            Debug.warning("establishDestructorClassContainmentRelation(): class-container-metamod was null!");
            return;
        }
        
		// containment
        class_container_metamod.addDestructor(destructor_metamod);
        
        // MB: If the added method is abstract the class *has* to be abstract
        if (destructor_metamod.isAbstract()) {
        	class_container_metamod.setAbstract(true);
        }
    }
    

    
    protected void setupFunctionPosition(Object function_element, Function function_metamod) {
        setupPosition(function_element, function_metamod);    
    }
    
    protected void setupFunctionModifiers(Object function_element, Function function_metamod) {
        if (function_metamod == null)
            return;
        
        if (function_metamod instanceof GlobalFunction) {
        	
        	GlobalFunction global_function_metamod = (GlobalFunction) function_metamod;
        	
        	if (this.collector.functionElementIsUnitInitializer(function_element)) {
        		global_function_metamod.setKind(GlobalFunction.UNIT_INITIALIZER);
        	} else if (this.collector.functionElementIsUnitFinalizer(function_element)) {
        		global_function_metamod.setKind(GlobalFunction.UNIT_FINALIZER);
        	} else
        		global_function_metamod.setKind(GlobalFunction.NORMAL);
        }
        	
        // Member specific setup...
        if (function_metamod instanceof Member) {
            
            Member member_function_metamod = (Member)function_metamod;
            
            if (this.collector.functionElementIsExternal(function_element)) {
                member_function_metamod.setExtern(true);
            } else {
                member_function_metamod.setExtern(false);
            }
            
            if (this.collector.functionElementIsInternal(function_element)) {
                member_function_metamod.setInternal(true);
            } else {
                member_function_metamod.setInternal(false);
            }

            if (this.collector.functionElementIsNew(function_element)) {
                member_function_metamod.setNew();
            } else {
                member_function_metamod.setOverride();
            }

            if (this.collector.functionElementIsPrivate(function_element)) {
                member_function_metamod.setPrivate();
            } else
            if (this.collector.functionElementIsProtected(function_element)) {
                member_function_metamod.setProtected();
            } else
            if (this.collector.functionElementIsPublic(function_element)) {
                member_function_metamod.setPublic();
            } else
            if (this.collector.functionElementIsPackage(function_element)) {
                member_function_metamod.setPackage();
            } else {
                // default public
                member_function_metamod.setPublic();
            }
            
            if (this.collector.functionElementIsStatic(function_element)) {
                member_function_metamod.setStatic(true);
            } else {
                member_function_metamod.setStatic(false);
            }
            
            if (this.collector.functionElementIsFinal(function_element)) {
                member_function_metamod.setFinal(true);
            } else {
                member_function_metamod.setFinal(false);
            }

            if (this.collector.functionElementIsAbstract(function_element)) {
                member_function_metamod.setAbstract(true);
            } else {
                member_function_metamod.setAbstract(false);
            }
            
            if (this.collector.functionElementIsVirtual(function_element)) {
                member_function_metamod.setVirtual(true);
            } else {
                member_function_metamod.setVirtual(false);
            }
            
            if (this.collector.functionElementIsIntrospectable(function_element)) {
                member_function_metamod.setIntrospectable(true);
            } else {
                member_function_metamod.setIntrospectable(false);
            }
            
        } 
      
    }
    
    protected void setupReturntype(Object function_element, Function function_metamod) {
        
       if (function_metamod instanceof Constructor)
           return;
       if (function_metamod instanceof Destructor)
           return;
       
       Object return_type_element = this.collector.getReturnTypeElementOfFunctionElement(function_element);
       
       if (return_type_element==null && this.collector.functionElementIsFunction(function_element)) {
           Debug.warning("setupReturntype(): " + function_element.toString() 
        		   + ": return-type-element was null (but it's a true function element!)");
           return;
       } else if (!this.collector.functionElementIsFunction(function_element)) {
           return;
       }
       
       Type return_type_metamod = (Type)this.mapper.getInstance(return_type_element);
       
       if (return_type_metamod==null) {
           Debug.warning("setupReturntype(): " + function_element.toString() + "" +
           		": mapped return-type-metamod was null!");
           return;
       }
       
       // TODO dta for Returntype correct ????
       
       DeclarationTypeAccess dta = new DeclarationTypeAccess(return_type_metamod);
       
       // position setup of dta
       dta.setPosition(function_metamod.getPosition());
       
       function_metamod.setReturnTypeDeclaration(dta); 
    }

    
    
    protected void buildDelegates() {
        
        Iterator itr = this.collector.getDelegateElements().iterator();
        
        building:
        while (itr.hasNext()) {
            Object delegate_element = itr.next(); 
            
            buildDelegate(delegate_element);
        }
        
    }
    
    protected void buildDelegate(Object delegate_element) {
        
        // check mapping
        if (alreadyMapped(delegate_element)) {
            Object metamod_elem = mapper.getInstance(delegate_element);
            Debug.warning("tried to build duplicate delegate object "+ delegate_element.toString()+", prevented. Mapped metamod-element: "+metamod_elem.getClass().getName());
            return;
        }
        
        String name = this.collector.getNameOfDelegateElement(delegate_element);
        
        if (name==null) {
            Debug.warning("buildDelegate(): returned name was null!");
            return;
        }
        
        // creation
        Delegate delegate_metamod = new Delegate(name);

        // mapping
        this.mapper.addInstance(delegate_element, delegate_metamod);

        // TODO setup delegates !!!
        // TODO invocated functions ???
        
    }
    

    protected void buildReferences() {
        
        Iterator itr = this.collector.getReferenceElements().iterator();
        
        building:
        while (itr.hasNext()) {
            Object reference_element = itr.next(); 
            
            buildReference(reference_element);
        }
        
    }
    
    protected void buildReference(Object reference_element) {
        
        // check mapping
        if (alreadyMapped(reference_element)) {
            Object metamod_elem = mapper.getInstance(reference_element);
            Debug.warning("tried to build duplicate reference object "+ reference_element.toString()+", prevented. Mapped metamod-element: "+metamod_elem.getClass().getName());
            return;
        }
        
        String name = this.collector.getNameOfReferenceElement(reference_element);
        
        if (name==null) {
            Debug.warning("buildReference(): returned name was null!");
            return;
        }

        // get referenced type element
        Object referenced_type_element = this.collector.getReferencedTypeElementOfReferenceElement(reference_element);
        
        if (referenced_type_element==null) {
            Debug.warning("buildReference(): returned referenced type element was null!");
            return;
        }

        // get mapped metamod type 
        Type referenced_type = (Type)mapper.getInstance(referenced_type_element);

        if (referenced_type==null) {
            Debug.warning("buildReference(): mapped referenced type was null!");
            return;
        }

        // creation
        Reference reference_metamod = new Reference(referenced_type, name);

        // mapping
        this.mapper.addInstance(reference_element, reference_metamod);

        // TODO setup delegates !!!
        // TODO invocated functions ???
        
    }

    protected void buildTypeAliases() {
        
        Iterator itr = this.collector.getTypeAliasElements().iterator();
        
        building:
        while (itr.hasNext()) {
            Object typealias_element = itr.next(); 
            
            buildTypeAlias(typealias_element);
        }
        
    }
    
    protected void buildTypeAlias(Object typealias_element) {
        
        // check mapping
        if (alreadyMapped(typealias_element)) {
            Object metamod_elem = mapper.getInstance(typealias_element);
            Debug.warning("tried to build duplicate typealias object "+ typealias_element.toString()+", prevented. Mapped metamod-element: "+metamod_elem.getClass().getName());
            return;
        }
        
        String name = this.collector.getNameOfTypeAliasElement(typealias_element);
        
        if (name==null) {
            Debug.warning("buildTypeAlias(): returned name was null! "+ typealias_element.toString());
            return;
        }

        // get aliased type element
        Object aliased_type_element = this.collector.getAliasedTypeElementOfTypeAliasElement(typealias_element);
        
        if (aliased_type_element==null) {
            Debug.warning("buildTypeAlias(): returned aliased type element was null!");
            return;
        }

        // get mapped metamod type 
        Type aliased_type = (Type)mapper.getInstance(aliased_type_element);

        if (aliased_type==null) {
            Debug.warning("buildTypeAlias(): mapped aliased type was null! aliased_type_element: "+aliased_type_element.toString() + " for type_alias_element: "+ typealias_element.toString());
            return;
        }

        // creation
        TypeAlias typealias_metamod = new TypeAlias(aliased_type, name);

        // mapping
        this.mapper.addInstance(typealias_element, typealias_metamod);
        
        // MB : Add type alias to a package
        establishTypeAliasPackageContainmentRelation(typealias_element, typealias_metamod);

        // TODO setup delegates !!!
        // TODO invocated functions ???
    }

    
    protected void buildFormalParameters(Object function_element, Function function_metamod) {
        
        Iterator itr = this.collector.getFormalParameterElements(function_element).iterator();
	    
	    building:
 	    while (itr.hasNext()) {
 	        Object fp_element = itr.next(); 
	        
            buildFormalParameter(function_metamod, fp_element);
 	    }
        
    }

    protected void buildFormalParameter(Function function_metamod, Object fp_element) {
        if (alreadyMapped(fp_element)) {
            Object metamod_elem = mapper.getInstance(fp_element);
            Debug.warning("tried to build duplicate formal parameter object "+ fp_element.toString()+", prevented. Mapped metamod-element: "+metamod_elem.getClass().getName()+" function-metamod: "+function_metamod.getSimpleName());
            return;
        }
        
        String name = this.collector.getNameOfFormalParameterElement(fp_element);
        
        if (name==null) {
            Debug.warning("buildFormalParameters(): returned name was null!");
            return;
        }
        
        // creation
        FormalParameter fp_metamod = new FormalParameter(name);

        // mapping
        this.mapper.addInstance(fp_element, fp_metamod);

        // TODO fp setup
        
        // formalparameter-function-containment
        function_metamod.addFormalParameter(fp_metamod);
        
        // position
        setupFormalParameterPosition(fp_element, fp_metamod);
        
        // declaration type access
        setupFormalParameterTypeDeclaration(fp_element, fp_metamod);
        
    }

    protected void setupFormalParameterPosition(Object fp_element, FormalParameter fp_metamod) {
        setupPosition(fp_element, fp_metamod);    
    }
    
    protected void setupFormalParameterTypeDeclaration(Object fp_element, FormalParameter fp_metamod) {
        
        Object type_element = this.collector.getTypeElementOfFormalParameterElement(fp_element);

        if (type_element == null) {
            Debug.warning("setupFormalParameterTypeDeclaration(): Type-Element of FormalParameter "+fp_metamod.getSimpleName()+" was null!");
            return;
        }

        Type type_metamod = (Type)mapper.getInstance(type_element);
        
        if (type_metamod == null) {
            Debug.warning("setupFormalParameterTypeDeclaration(): Type of metamod-type-object "+fp_metamod.getSimpleName()+" was null!");
            if (type_element instanceof ClassType) {
                buildClass(type_element);
            } else {
                buildPrimitiveType(type_element);
            }
            
            type_metamod = (Type)mapper.getInstance(type_element);
            
        }
        
		de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);
        
        dta.setPosition(fp_metamod.getPosition());

		// containment
		fp_metamod.setTypeDeclaration(dta);
		
    }
    
    
//    protected void buildLocalVariables(Object function_element, Function function_metamod) {
    protected void buildLocalVariables() {
    
        Iterator itr = this.collector.getLocalVariablesElements().iterator();
        Debug.info("building local variables: "+this.collector.getLocalVariablesElements().size());
    
        building:
	    while (itr.hasNext()) {
	        Object lv_element = itr.next(); 
	        
            Object function_element = collector.getFunctionContainerElementOfLocalVariableElement(lv_element);
			
			// TODO function_container of local variable was null ???
			if (function_element == null) {
                Debug.info("buildLocalVariables(): function_element was null!");
				continue building;
            }
            
            Function function_metamod = (Function)mapper.getInstance(function_element);


			if (function_metamod == null) {
                // try again with scope instead of symbol (mapping in global functions with scope (bugfixing))
                function_metamod = (Function)mapper.getInstance(((de.fzi.delphi.symbols.Method)function_element).getCorrespondingScope());
                if (function_metamod == null) {
                    Debug.info("buildLocalVariables(): function_metamod was null! "+function_element.toString());
				continue building;
                } else {
                    Debug.info("buildLocalVariables(): function_metamod_resolution with scope worked!!!");
                }
            }

            buildLocalVariable(function_metamod, lv_element);
	    }
 
    }
    
    protected void buildLocalVariable(Function function_metamod, Object lv_element) {

        if (alreadyMapped(lv_element)) {
            Debug.warning("tried to build duplicate local variable object, prevented");
            return;
        }
        
        String name = this.collector.getNameOfLocalVariableElement(lv_element);
        
        if (name==null) {
            Debug.warning("buildLocalVariables(): returned name was null!");
            return;
        }
        
        // creation
        LocalVariable lv_metamod = new LocalVariable(name);

        // mapping
        this.mapper.addInstance(lv_element, lv_metamod);


        // TODO lv setup
        
        // local variable-function-containment
        function_metamod.addLocalVariable(lv_metamod);

        // TODO initializer-access ??

        // position
        setupLocalVariablePosition(lv_element, lv_metamod);
        
        // declaration type access
        setupLocalVariableTypeDeclaration(lv_element, lv_metamod);
        
    }

    protected void setupLocalVariablePosition(Object lv_element, LocalVariable lv_metamod) {
        setupPosition(lv_element, lv_metamod); 
    }
    protected void setupLocalVariableTypeDeclaration(Object lv_element, LocalVariable lv_metamod) {
        
        Object type_element = this.collector.getTypeElementOfLocalVariableElement(lv_element);

        if (type_element == null) {
            Debug.warning("setupLocalVariableTypeDeclaration(): Type-Element of LocalVariable was null!");
            return;
        }

        Type type_metamod = (Type)mapper.getInstance(type_element);
        
        if (type_metamod == null) {
            Debug.warning("setupLocalVariableTypeDeclaration(): Type of metamod-type-object was null!");
            return;
        }
        
		de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);

        dta.setPosition(lv_metamod.getPosition());
        
		// containment
		lv_metamod.setTypeDeclaration(dta);
		
    }
    
    protected abstract void buildStatements(Object function_element, Function function_metamod);
    protected abstract void buildCatchParameters();
    
    
    public final void buildVariables() {
        Debug.info("\tbuilding global variables...");
        buildGlobalVariables();
        Debug.info("\tbuilding fields...");
        buildFields();
        // local variables and formal parameters are created at function-building
        buildLocalVariables();
        buildProperties();
    }

    protected void buildGlobalVariables() {
    
    	Iterator itr = this.collector.getGlobalVariableElements().iterator();
    
    	building:
	    while (itr.hasNext()) {
	        Object global_variable_element = itr.next(); 
        
            buildGlobalVariable(global_variable_element);
	    }
    }
 
    private void buildGlobalVariable(Object global_variable_element) {
        if (alreadyMapped(global_variable_element)) {
            Debug.warning("tried to build duplicate glob. variable object, prevented");
            return;
        }
        
        // get method-name
        String name = this.collector.getNameOfGlobalVariableElement(global_variable_element);
        
        if (name==null) {
            Debug.warning("buildGlobalVariables(): returned name was null!");
            return;
        }
        
        // creation
        GlobalVariable global_variable_metamod = new GlobalVariable(name);
      
        // mapping
        this.mapper.addInstance(global_variable_element, global_variable_metamod);

        // TODO gv setup

        // const-setup
        if (this.collector.globalVariableElementIsConst(global_variable_element)) {
            global_variable_metamod.setConst(true);
        } else {
            global_variable_metamod.setConst(false);
        }
        
        // TODO field setup
        // position
        setupGlobalVariablePosition(global_variable_element, global_variable_metamod);
        
        // declaration type access
        setupGlobalVariableTypeDeclaration(global_variable_element, global_variable_metamod);
        
        // establish package-containment-relation
        Object package_container_element = collector.getPackageContainerElementOfGlobalVariableElement(global_variable_element);
        
        if (package_container_element==null) {
            Debug.warning("buildGlobalVariable(): package container element was null! for gv: "+global_variable_metamod.getSimpleName());
            return;
        }

        de.fzi.sissy.metamod.Package container_package = (de.fzi.sissy.metamod.Package)mapper.getInstance(package_container_element);
        
        if (container_package==null) {
            Debug.warning("buildGlobalVariable(): mapped container metamod package was null! for gv: "+global_variable_metamod.getSimpleName());
            return;
        }
        
        container_package.addGlobalVariable(global_variable_metamod);
        
    }

    protected void setupGlobalVariablePosition(Object global_variable_element, GlobalVariable global_variable_metamod) {
    	setupPosition(global_variable_element, global_variable_metamod);    
	}
    
    protected void setupGlobalVariableTypeDeclaration(Object global_variable_element, GlobalVariable global_variable_metamod) {
	    
	    Object type_element = this.collector.getTypeElementOfGlobalVariableElement(global_variable_element);
	
	    if (type_element == null) {
	        Debug.warning("setupGlobalVariableTypeDeclaration(): Type-Element of gv_element "+global_variable_metamod.getSimpleName()+" was null!");
            return;
        }
	
	    Type type_metamod = (Type)mapper.getInstance(type_element);
	    
	    if (type_metamod == null) {
	        Debug.warning("setupGlobalVariableTypeDeclaration(): Type of metamod-type-object "+global_variable_metamod.getSimpleName()+" was null!");
            return;
	    }
	    
		de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);
	
        dta.setPosition(global_variable_metamod.getPosition());
        
		// containment
		global_variable_metamod.setTypeDeclaration(dta);
	
    }
    
    
    public void buildFields() {
 	   
        Iterator itr = this.collector.getFieldElements().iterator();
	    
	    building:
 	    while (itr.hasNext()) {
 	        Object field_element = itr.next(); 
	        
            Debug.info("buildFields(): build field for symbol: "+field_element.toString());
            
            buildField(field_element);
            
	    }
        
    }
    
    protected void buildField(Object field_element) {

        if (alreadyMapped(field_element)) {
            Debug.warning("tried to build duplicate field object, prevented");
            return;
        }
        
        // get method-name
        String name = this.collector.getNameOfFieldElement(field_element);
        
        if (name==null) {
            Debug.warning("buildFields(): returned fieldname was null!");
            return;
        }
        
        // creation
        de.fzi.sissy.metamod.Field field_metamod = new de.fzi.sissy.metamod.Field(name);

        // mapping
        Debug.verbose("buildField(): mapped field_element: " + field_element.toString() + " to metamod_field: "+field_metamod.getSimpleName());
        
        this.mapper.addInstance(field_element, field_metamod);

        establishFieldClassContainmentRelation(field_element, field_metamod);

        // TODO field setup
        // position
        setupFieldPosition(field_element, field_metamod);
        
        // modifiers
        setupVariableModifiers(field_element, field_metamod);
        
        // declaration type access
        setupFieldTypeDeclaration(field_element, field_metamod);
        
    }

    protected void establishFieldClassContainmentRelation(Object field_element, Field field_metamod) {
        Object class_container_element = this.collector.getClassContainerElementOfFieldElement(field_element);
        
        if (class_container_element == null) {
            Debug.warning("establishFieldClassContainmentRelation(): class-container-element was null!");
            return;
        }
    
        Class class_container_metamod = (Class)mapper.getInstance(class_container_element);
        
        if (class_container_metamod == null) {
            Debug.warning("establishFieldClassContainmentRelation(): class-container-metamod was null!");
            return;
        }
        
        // containment
        class_container_metamod.addField(field_metamod);
    }
    protected void setupFieldPosition(Object field_element, Field field_metamod) {
        setupPosition(field_element, field_metamod);    
    }
    protected void setupVariableModifiers(Object field_element, Field field_metamod) {
        
        if (this.collector.fieldElementIsExternal(field_element)) {
            field_metamod.setExtern(true);
        } else {
            field_metamod.setExtern(false);
        }
        
        if (this.collector.fieldElementIsInternal(field_element)) {
            field_metamod.setInternal(true);
        } else {
            field_metamod.setInternal(false);
        }

        if (this.collector.fieldElementIsNew(field_element)) {
            field_metamod.setNew();
        } else {
            field_metamod.setOverride();
        }

        if (this.collector.fieldElementIsPrivate(field_element)) {
            field_metamod.setPrivate();
        } else
        if (this.collector.fieldElementIsProtected(field_element)) {
            field_metamod.setProtected();
        } else
        if (this.collector.fieldElementIsPublic(field_element)) {
            field_metamod.setPublic();
        } else
        if (this.collector.fieldElementIsPackage(field_element)) {
            field_metamod.setPackage();
        } else {
            // default public
            field_metamod.setPublic();
        }
        
        if (this.collector.fieldElementIsStatic(field_element)) {
            field_metamod.setStatic(true);
        } else {
            field_metamod.setStatic(false);
        }
        
        if (this.collector.fieldElementIsFinal(field_element)) {
            field_metamod.setFinal(true);
        } else {
            field_metamod.setFinal(false);
        }
        
        // MB: Correctly identify published fields
        if (this.collector.fieldElementIsIntrospectable(field_element)) {
            field_metamod.setIntrospectable(true);
        } else {
            field_metamod.setIntrospectable(false);
        }
        
    }
    protected void setupFieldTypeDeclaration(Object field_element, Field field_metamod) {
        
        Object type_element = this.collector.getTypeElementOfFieldElement(field_element);
    
        if (type_element == null) {
            Debug.warning("setupFieldTypeDeclaration(): Type-Element of Field was null!");
            return;
        }
    
        Type type_metamod = (Type)mapper.getInstance(type_element);
        
        if (type_metamod == null) {
            Debug.warning("setupFieldTypeDeclaration(): Type of metamod-type-object to Field "+field_metamod.getSimpleName()+" was null!");
            return;
        }
        
        de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);
    
        dta.setPosition(field_metamod.getPosition());
        // containment
        field_metamod.setTypeDeclaration(dta);
    
    }
    
    protected void buildProperties() {

        Iterator itr = this.collector.getPropertyElements().iterator();
        
        building:
        while (itr.hasNext()) {
            Object property_element = itr.next(); 
            
            buildProperty(property_element);
            
        }
        
    }
    
    protected void buildProperty(Object property_element) {

        if (alreadyMapped(property_element)) {
            Debug.warning("tried to build duplicate property object, prevented");
            return;
        }
        
        // get method-name
        String name = this.collector.getNameOfPropertyElement(property_element);
        
        if (name==null) {
            Debug.warning("buildProperty(): returned propertyname was null!");
            return;
        }
        
        // creation
        de.fzi.sissy.metamod.Property property_metamod = new de.fzi.sissy.metamod.Property(name);

        Debug.info("Property "+property_metamod.getSimpleName()+" was created!");
        
        // mapping
        this.mapper.addInstance(property_element, property_metamod);

        establishPropertyClassContainmentRelation(property_element, property_metamod);

        // TODO field setup
        // position
        setupPosition(property_element, property_metamod);
        
        // modifiers
        setupPropertyModifiers(property_element, property_metamod);
        
        // declaration type access
        setupPropertyTypeDeclaration(property_element, property_metamod);
        
        // setter/getter-setup:
        Object setter_element = collector.getSetterElementOfPropertyElement(property_element);
        if (setter_element != null) {
        	Method setter_metamod = new Method(property_metamod.getSimpleName() + ".set");
            setupPropertyModifiers(property_element, setter_metamod);
            BlockStatement body = new BlockStatement();          
            setter_metamod.setBody(body);
            SimpleStatement accStatement = new SimpleStatement();
            body.addStatement(accStatement);
        	ModelElement target = (ModelElement)mapper.getInstance(setter_element);
        	if (target != null) {
                if (target instanceof Method)
                	accStatement.addAccess(new FunctionAccess((Function)target));
                else if (target instanceof Field)
                	accStatement.addAccess(new VariableAccess((Variable)target, true));
                else
                	Debug.warning("GeneralMetamodBuilder: Target for setter method of property " + property_metamod.getSimpleName() + " was not a Method or a Field.");
            }
            property_metamod.setSetter(setter_metamod);                            
        }

        Object getter_element = collector.getGetterElementOfPropertyElement(property_element);
        if (getter_element != null) {
        	Method getter_metamod = new Method(property_metamod.getSimpleName() + ".get");
            setupPropertyModifiers(property_element, getter_metamod);
            BlockStatement body = new BlockStatement();          
            getter_metamod.setBody(body);
            SimpleStatement accStatement = new SimpleStatement();
            body.addStatement(accStatement);
        	ModelElement target = (ModelElement)mapper.getInstance(getter_element);
        	if (target != null) {
                if (target instanceof Method)
                	accStatement.addAccess(new FunctionAccess((Function)target));
                else if (target instanceof Field)
                	accStatement.addAccess(new VariableAccess((Variable)target, true));
                else
                	Debug.warning("GeneralMetamodBuilder: Target for getter method of property " + property_metamod.getSimpleName() + " was not a Method or a Field.");
            }
            property_metamod.setGetter(getter_metamod);                            
        }

    }

    private void establishPropertyClassContainmentRelation(Object property_element, Property property_metamod) {

        Object class_container_element = this.collector.getClassContainerElementOfPropertyElement(property_element);
        
        if (class_container_element == null) {
            Debug.warning("establishPropertyClassContainmentRelation(): class-container-element was null!");
            return;
        }
    
        Class class_container_metamod = (Class)mapper.getInstance(class_container_element);
        
        if (class_container_metamod == null) {
            Debug.warning("establishPropertyClassContainmentRelation(): class-container-metamod was null!");
            return;
        }
        
        // containment
        class_container_metamod.addField(property_metamod);
        
    }
    protected void setupPropertyModifiers(Object property_element, Member member_metamod) {
        
        if (this.collector.propertyElementIsExternal(property_element)) {
            member_metamod.setExtern(true);
        } else {
            member_metamod.setExtern(false);
        }
        
        if (this.collector.propertyElementIsInternal(property_element)) {
            member_metamod.setInternal(true);
        } else {
            member_metamod.setInternal(false);
        }

        if (this.collector.propertyElementIsNew(property_element)) {
            member_metamod.setNew();
        } else {
            member_metamod.setOverride();
        }

        if (this.collector.propertyElementIsPrivate(property_element)) {
            member_metamod.setPrivate();
        } else
        if (this.collector.propertyElementIsProtected(property_element)) {
            member_metamod.setProtected();
        } else
        if (this.collector.propertyElementIsPublic(property_element)) {
            member_metamod.setPublic();
        } else
        if (this.collector.propertyElementIsPackage(property_element)) {
            member_metamod.setPackage();
        } else {
            // default public
            member_metamod.setPublic();
        }
        
        if (this.collector.propertyElementIsStatic(property_element)) {
            member_metamod.setStatic(true);
        } else {
            member_metamod.setStatic(false);
        }
        
        if (this.collector.propertyElementIsFinal(property_element)) {
            member_metamod.setFinal(true);
        } else {
            member_metamod.setFinal(false);
        }
        
        if (this.collector.propertyElementIsIntrospectable(property_element)) {
            member_metamod.setIntrospectable(true);
        } else {
            member_metamod.setIntrospectable(false);
        }
      
    }
    protected void setupPropertyTypeDeclaration(Object property_element, Field property_metamod) {
        
        Object type_element = this.collector.getTypeElementOfPropertyElement(property_element);
    
        if (type_element == null) {
            Debug.warning("setupPropertyTypeDeclaration(): Type-Element of Property was null!");
            return;
        }
    
        Type type_metamod = (Type)mapper.getInstance(type_element);
        
        if (type_metamod == null) {
            Debug.warning("setupPropertyTypeDeclaration(): Type of metamod-type-object to Property "+property_metamod.getSimpleName()+" was null!");
            return;
        }
        
        de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);
    
        dta.setPosition(property_metamod.getPosition());
        // containment
        property_metamod.setTypeDeclaration(dta);
    
    }

    public final void buildImports() {
    	Iterator file_it = this.collector.getFileElements().iterator();
    	
    	while (file_it.hasNext()) {
    		
    		Object file_element = file_it.next();
    		
    		File file_metamod = (File) this.mapper.getInstance(file_element);
    		
    		if (file_metamod == null) 
    			continue;
    		
    		buildImportedPackages(file_element, file_metamod);
    		
    	}
    }

    public final void buildAccesses() {
        buildInheritanceTypeAccesses();
        
        buildOverriddenMembers();
        
        buildCastTypeAccesses();
        /*
        buildThrowTypeAccesses();
        buildDeclarationTypeAccesses();
        */
        buildStaticTypeAccesses();
        buildRunTimeTypeAccesses();
        buildSelfAccesses();
        buildCompositeAccesses();
        
        // buildFunctionAccesses();
        //buildDelegateAccesses();
        buildVariableAccesses();
        buildFunctionAccesses();
        //buildPropertyAccesses();
    }

    public void buildInheritanceTypeAccesses() {
        Debug.info("  building inheritance-type-accesses...");
        

        Iterator itr = this.collector.getClassElements().iterator();
        
        building:
        while (itr.hasNext()) {
            Object class_element = itr.next(); 
            
            // get metamod-object of super-class
            Class class_metamod = (Class)mapper.getInstance(class_element);
            
            if (class_metamod==null) {
                Debug.warning("InheritanceTypeAccesses(): mapped metamod-class-element was null!");
                continue building;
            }

            // return collection with sub-class-elements
            Collection coll_super = this.collector.getSuperClassElementsOfClassElement(class_element);
            
            if (coll_super != null && !coll_super.isEmpty()) {
                
                Iterator itr_super = coll_super.iterator();

                superbuilding:
                while (itr_super.hasNext()) {
                    
                    Object super_class_element = itr_super.next();
                    
                    // get metamod-sub-class-object
                    Class super_class_metamod = (Class)mapper.getInstance(super_class_element);
                    
                    if (super_class_metamod==null) {
                        Debug.warning("InheritanceTypeAccesses(): mapped metamod-sub-class-element was null!");
                        continue superbuilding;
                    }
                    
                    // create access
                    InheritanceTypeAccess ita = new InheritanceTypeAccess(super_class_metamod);
                    
                    // add access to subclass
                    class_metamod.addInheritanceTypeAccess(ita);
                    
                }
                
            }
           
        }
        
    }
    
    abstract protected void buildOverriddenMembers();
    
    public void buildCastTypeAccesses() {
        Debug.info("  building cast-type-accesses...");

        Iterator itr = collector.getTypeCastAccessElements().iterator();
        
        while(itr.hasNext()) {
            Object typecast_access_element = (Object) itr.next();
            
            // get function
            
            Object type = collector.getTypeElementToTypeCastAccessElement(typecast_access_element);
            
            Object metamod_object = mapper.getInstance(type);
            
            if (metamod_object==null){
                Debug.warning("buildCastTypeAccesses(): Metamod-Class-Object was null!");
                continue;
            }
            
            if (!(metamod_object instanceof Type)) {
            	Debug.warning("buildCastTypeAccesses(): Metamod-Class-Object was invalid for " + type.toString());
                continue;
            }
            
            Type type_metamod = (Type) metamod_object;
            
            // create new access-object
            
            CastTypeAccess cast_type_access = new CastTypeAccess(type_metamod);
            
            // get container-statement
            
            
            Statement container_stm = (Statement)collector.getContainerStatementOfTypeCastAccessElement(typecast_access_element);
            
            if (container_stm != null) {
                container_stm.addAccess(cast_type_access);
                Debug.info("Type Cast Access to "+type_metamod.getSimpleName()+" added to Statement !");
            } else {
                Debug.warning("buildCastTypeAccesses(): Container-Statement was null!");
            }
            
        }
    }
    
    public void buildThrowTypeAccesses(){}
    public void buildDeclarationTypeAccesses(){}
    
    
    public void buildStaticTypeAccesses() {
        Debug.info("  building static-type-accesses...");
        
        Iterator itr = collector.getStaticTypeAccessElements().iterator();
        
        while(itr.hasNext()) {
            Object static_type_access_element = (Object) itr.next();
            
            buildStaticTypeAccess(static_type_access_element);
            
        }
    }

    public void buildStaticTypeAccess(Object static_type_access_element) {
        
        Object target_class_element = collector.getTypeClassElementOfStaticTypeAccessElement(static_type_access_element);
        
        if (target_class_element==null) {
            Debug.warning("buildStaticTypeAccess(): target_class_element was null!");
            return;
        }
        
        Class target_class_metamod = (Class)mapper.getInstance(target_class_element);
        
        if (target_class_metamod==null) {
            Debug.warning("buildStaticTypeAccess(): target_class_metamod was null!");
            return;
        }
        
        StaticTypeAccess static_type_access_metamod = new StaticTypeAccess(target_class_metamod);

        // get container-statement
        Statement container_stm = (Statement)collector.getContainerStatementOfStaticTypeAccessElement(static_type_access_element);
        
        if (container_stm != null) {
            container_stm.addAccess(static_type_access_metamod);
            //Debug.info("Function Access to "+function_metamod.getSimpleName()+" added to Statement !");
        } else {
            Debug.warning("buildStaticTypeAccess(): Container-Statement was null!");
        }
        
    }

    
    public void buildRunTimeTypeAccesses() {
        Debug.info("  building runtime-type-accesses...");
        
        Iterator itr = collector.getRunTimeTypeAccessElements().iterator();
        
        while(itr.hasNext()) {
            Object runtime_type_access_element = (Object) itr.next();
            
            buildRunTimeTypeAccess(runtime_type_access_element);
            
        }
        
    }
    
    public void buildRunTimeTypeAccess(Object runtime_type_access_element) {
        
        Object target_class_element = collector.getTypeClassElementOfRunTimeTypeAccessElement(runtime_type_access_element);
        
        if (target_class_element==null) {
            Debug.warning("buildRunTimeTypeAccess(): target_class_element was null!");
            return;
        }
        
        Type target_class_metamod = (Type)mapper.getInstance(target_class_element);
        
        if (target_class_metamod==null) {
            Debug.warning("buildRunTimeTypeAccess(): target_class_metamod was null!");
            return;
        }
        
        RunTimeTypeAccess runtime_type_access_metamod = new RunTimeTypeAccess(target_class_metamod);

        // get container-statement
        Statement container_stm = (Statement)collector.getContainerStatementOfRunTimeTypeAccessElement(runtime_type_access_element);
        
        if (container_stm != null) {
            container_stm.addAccess(runtime_type_access_metamod);
            //Debug.info("Function Access to "+function_metamod.getSimpleName()+" added to Statement !");
        } else {
            Debug.warning("buildRunTimeTypeAccess(): Container-Statement was null!");
        }
        
    }

    
    
    public void buildSelfAccesses() {
        Debug.info("  building self-accesses...");
        
        Iterator itr = collector.getSelfAccessElements().iterator();
        Debug.info(" number: "+collector.getSelfAccessElements().size());
        
        while(itr.hasNext()) {
            Object self_access_element = (Object) itr.next();
            
            buildSelfAccess(self_access_element);
            
        }
        
    }
    
    public void buildSelfAccess(Object self_access_element) {
        
        Object target_class_element = collector.getTargetClassElementOfSelfAccessElement(self_access_element);
        
        if (target_class_element==null) {
            Debug.warning("buildSelfAccess(): target_class_element was null!");
            return;
        }
        
        Class target_class_metamod = (Class)mapper.getInstance(target_class_element);
        
        if (target_class_metamod==null) {
            Debug.warning("buildSelfAccess(): target_class_metamod was null!");
            return;
        }
        
        SelfAccess self_access_metamod = new SelfAccess(target_class_metamod);

        // get container-statement
        Statement container_stm = (Statement)collector.getContainerStatementOfSelfAccessElement(self_access_element);
        
        if (container_stm != null) {
            container_stm.addAccess(self_access_metamod);
            //Debug.info("Function Access to "+function_metamod.getSimpleName()+" added to Statement !");
        } else {
            Debug.warning("buildSelfAccess(): Container-Statement was null!");
        }
        
    }


    public void buildCompositeAccesses() {

        Iterator itr = collector.getCompositeAccessElements().iterator();
        
        while(itr.hasNext()) {
            Object composite_access_element = (Object) itr.next();
            
            buildCompositeAccess(composite_access_element);
            
        }

    }

    public void buildCompositeAccess(Object composite_access_element) {
        /*
        // TODO fill in building for composite access
        
        // get container-statement
        Statement container_stm = (Statement)collector.getContainerStatementOfSelfAccessElement(self_access_element);
        
        if (container_stm != null) {
            container_stm.addAccess(self_access_metamod);
            //Debug.info("Function Access to "+function_metamod.getSimpleName()+" added to Statement !");
        } else {
            Debug.warning("buildSelfAccess(): Container-Statement was null!");
        }
        */
        
    }


    public void buildFunctionAccesses(){
        
        Iterator itr = collector.getFunctionAccessElements().iterator();
        
        while(itr.hasNext()) {
            Object function_access_element = (Object) itr.next();
            
            buildFunctionAccess(function_access_element);
            
        }
        
    }
    
    public void buildFunctionAccess(Object function_access_element) {

    	// get function
        Object function_element = collector.getFunctionElementToFunctionAccessElement(function_access_element);
        
        Function function_metamod = (Function)mapper.getInstance(function_element);
        
        if (function_metamod==null){
        	
            Debug.warning("buildFunctionAcesses(): Metamod-Function-Object was null! Function-Element "+function_element.toString()+" was of Type "+function_element.getClass().getName());
            /* MB : Mmh. The following is not a good fallback strategy
             -- it creates ghost/duplicate functions, therefore we simply do
             not add function accesses/calls with unknown targets!
             */ 
            /* 
             buildMethod(function_element);
             function_metamod = (Function)mapper.getInstance(function_element); 
             */
            return;
        }
        
        // create new access-object
        
        FunctionAccess function_access = new FunctionAccess(function_metamod);
        
        // get container-statement
        
        
        Statement container_stm = (Statement)collector.getContainerStatementOfFunctionAccessElement(function_access_element);
        
        if (container_stm != null) {
            container_stm.addAccess(function_access);
            //Debug.info("Function Access to "+function_metamod.getSimpleName()+" added to Statement !");
        } else {
            Debug.warning("buildFunctionAccess(): Container-Statement was null!");
        }
    	
    }

    public void buildVariableAccesses(){
        
        Iterator itr = collector.getVariableAccessElements().iterator();
        
        while(itr.hasNext()) {
            Object variable_access_element = (Object) itr.next();
            
            // get variable
            
            Object variable_element = collector.getVariableElementToVariableAccessElement(variable_access_element);
            
            if (variable_element == null) {
                Debug.warning("buildVariableAcesses(): Variable-Element was null!");
                continue;
            }
            
            Variable variable_metamod = (Variable)mapper.getInstance(variable_element);
            
            if (variable_metamod==null){
                Debug.warning("buildVariableAcesses():  Metamod-Variable-Object for " + ((Symbol) variable_element).getScope() + " was null! Variable-Element was of Type "+variable_element.getClass().getName());
                continue;
            }
            
            // create new access-object
            
            boolean isWrite = false;
            isWrite = collector.isWritingVariableAccess(variable_access_element);
            
            // TODO read/write-Setup
            
            VariableAccess variable_access;
            if (variable_metamod instanceof Property)
                variable_access = new PropertyAccess((Property)variable_metamod, isWrite);
            else
            	variable_access = new VariableAccess(variable_metamod, isWrite);
            
            // get container-statement
            
            Statement container_stm = (Statement)collector.getContainerStatementOfVariableAccessElement(variable_access_element);
            
            
            if (container_stm != null) {
                container_stm.addAccess(variable_access);

                Debug.verbose("Variable Access to "+variable_metamod.getSimpleName()+" added to Statement ! ");
                
                ModelElement parent = container_stm.getParent();
                
                while (parent!=null && !(parent instanceof NamedModelElement)) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    Debug.verbose("Parent of Statement is "+ ((NamedModelElement)parent).getSimpleName());
                }
                
            } else {
                Debug.warning("buildVariableAcesses(): Container-Statement was null!");
            }
            
        }
        
    }

    
    public void buildDelegateAccesses(){}
    public void buildPropertyAccesses(){}

    public final void establishContainmentRelations() {
        establishPackagePackageContainmentRelation();
        establishClassClassContainmentRelation();
    }

	public abstract void establishPackagePackageContainmentRelation();
    public abstract void establishClassClassContainmentRelation();
    
    public abstract void buildDefaultAbstractions();
    
	public void createStatementViewer() {
		// get all metamod-Methods:
		Vector allMethods = new Vector();
		
		allMethods.addAll(collector.getMethodElements());
        allMethods.addAll(collector.getGlobalFunctionElements());
        allMethods.addAll(collector.getConstructorElements());
        allMethods.addAll(collector.getDestructorElements());
	    
	    Vector metamod_functions = new Vector();
		Iterator itr = allMethods.iterator();
		while(itr.hasNext()) {
            Object obj = itr.next();
			de.fzi.sissy.metamod.Function metamod_function = 
			   (de.fzi.sissy.metamod.Function) mapper.getInstance(obj);
//            de.fzi.sissy.metamod.Function metamod_function = 
  //             (de.fzi.sissy.metamod.Function) mapper.getInstance(((de.fzi.delphi.symbols.Method)obj).getCorrespondingScope());
			   
			metamod_functions.add(metamod_function);
		}
		
		if (!metamod_functions.isEmpty()) {
			sv = new StatementViewer();
			sv.showMethodSelection(metamod_functions);
		}
	}

    /**
     * @return Returns the modelElementRepository.
     */
    public ModelElementRepository getModelElementRepository() {
        return modelElementRepository;
    }
    /**
     * @param modelElementRepository The modelElementRepository to set.
     */
    public void setModelElementRepository(
            ModelElementRepository modelElementRepository) {
        this.modelElementRepository = modelElementRepository;
    }
}
