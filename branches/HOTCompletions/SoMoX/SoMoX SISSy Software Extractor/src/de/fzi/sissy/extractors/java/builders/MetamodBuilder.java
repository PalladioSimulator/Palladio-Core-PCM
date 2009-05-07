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
package de.fzi.sissy.extractors.java.builders;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import recoder.abstraction.ArrayType;
import recoder.abstraction.ClassType;
import recoder.abstraction.Constructor;
import recoder.abstraction.Field;
import recoder.abstraction.Method;
import recoder.abstraction.Type;
import recoder.convenience.TreeWalker;
import recoder.io.ClassFileRepository;
import recoder.io.DataLocation;
import recoder.io.SourceFileRepository;
import recoder.java.declaration.ClassInitializer;
import recoder.java.declaration.FieldDeclaration;
import recoder.java.declaration.FieldSpecification;
import recoder.java.declaration.TypeDeclaration;
import recoder.service.NameInfo;
import recoder.service.SourceInfo;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.BlockStatement;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.InheritanceTypeAccess;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.util.Debug;

/**
 * @author stammel
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class MetamodBuilder extends Builder {

	protected ModelElementRepository modelElementRepository = null;
	protected SourceInfo sourceInfo = null;
	protected SourceFileRepository sourceFileRepository = null;
	protected NameInfo nameInfo = null;
	protected ClassFileRepository classFileRepository = null;

	private Vector classes = null;
	private Vector innerClasses = null;
	private Vector localClasses = null;
	private Vector allMethods = null;
	private Vector allFields = null;
	private Vector allConstructors = null;
	private StatementViewer sv = null;
	 
	private static MetamodBuilder singleton = null;

	private MetamodBuilder() {
		super();
	}

	public static MetamodBuilder getSingleton() {
		if (singleton == null) {
			singleton = new MetamodBuilder();
		} //if
		return singleton;
	} //getSingleton

	public void setup(ModelElementRepository modelElementRepository, ClassFileRepository classFileRepository, SourceInfo sourceInfo, SourceFileRepository sourceFileRepository, NameInfo nameInfo){
		getSingleton().modelElementRepository = modelElementRepository; 
		getSingleton().sourceInfo = sourceInfo;
		getSingleton().nameInfo = nameInfo;
		getSingleton().sourceFileRepository = sourceFileRepository;
		getSingleton().classFileRepository = classFileRepository;
		
		
/*
		CompilationUnitList cf = sourceFileRepository.getKnownCompilationUnits();
		
		for (int i=0; i<cf.size(); i++) {
			System.out.println("CompUnit: "+cf.getCompilationUnit(i).getName());
		}
*/

/*
		CompilationUnitList cf = sourceFileRepository.getKnownCompilationUnits();
		
		for (int i=0; i<cf.size(); i++) {
			ClassTypeList cl = cf.getCompilationUnit(i).getTypesInScope();
			System.out.println(cf.getCompilationUnit(i).getName());
			for (int j=0; j<cl.size(); j++) {
				System.out.println(cl.getClassType(j).getFullName());
			}
		}
*/		
		
	} //setup

	public void createPrimitiveTypeClasses() {
		//add ClassTypes for primitive types (int, boolean, ...)
		Debug.info("create Primitive Type Classes");

		createPrimitiveTypeClass("char",    nameInfo.getCharType());
		createPrimitiveTypeClass("short",   nameInfo.getShortType());
		createPrimitiveTypeClass("byte",    nameInfo.getByteType());
		createPrimitiveTypeClass("int",     nameInfo.getIntType());
		createPrimitiveTypeClass("long",    nameInfo.getLongType());
		createPrimitiveTypeClass("float",   nameInfo.getFloatType());
		createPrimitiveTypeClass("void",    nameInfo.getNullType());
		createPrimitiveTypeClass("double",  nameInfo.getDoubleType());
		createPrimitiveTypeClass("boolean", nameInfo.getBooleanType());		
	}

	// helper-method for creation of primitiveTypeClasses !!
	private void createPrimitiveTypeClass(String name, Type recoder_type) {
		
		// create class
		Class primitiveTypeClass = new Class(name);
		// set primitive class
		primitiveTypeClass.setPrimitive();
        // setting of model element-statute
        primitiveTypeClass.setImplicit();
		// connection to root
		modelElementRepository.getRoot().addType(primitiveTypeClass);
		// mapping recoder-type to metamod-class-type
		RecoderToOMMapper.getSingleton().addInstanceToMapper(recoder_type, primitiveTypeClass);
	}

	public void createFiles() {
		Debug.info("Extracting file names");
		int totalLOC = FileBuilder.getSingleton().extractFromRecoder(sourceFileRepository);
		Debug.info("Total LOC: " + totalLOC);
	}

	public void establishInnerPackageRelation() {
		Debug.info("Establishing Inner-Package-Relation");
		// calculate the hasPackage relation under packages 
		// (gets metamod-package-objects from repository)
		HasPackagesBuilder.getSingleton().extractFromRecoder();
	}

	public void findDirectClasses() {
		Debug.info("Find Direct Classes");
		// (03c) Liste von Klassen (ClassTypes) erzeugen.
		// add all classes to the list
		classes = new Vector();
		List<ClassType> classTypes_recoder = ExtractorFassade.getNameInfo().getClassTypes();
		for (int l = 0; l<classTypes_recoder.size(); l++) {
			ClassType classType_recoder = classTypes_recoder.get(l);
			if (classType_recoder instanceof TypeDeclaration) {
				classes.add(classType_recoder);
			}
		}
		
		
	}

	public void findInnerClasses() {
		Debug.info("Find Inner Classes");
		//find all inner classes
//		Debug.info("Extracting inner classes");

		Iterator iter = classes.iterator();
		boolean finished = false;

		Vector innerClasses = new Vector();
		Vector newInnerClasses = new Vector();
		Vector copyNewInner;
		ClassType[] inner;
		while (!finished) {
			while (iter.hasNext()) {
				ClassType c = (ClassType) iter.next();

				//this has been the important change:
				//c.getTypes() instead of c.getAllTypes().
				//c.getAllTypes() would also extract inherited types...
				
                //System.err.println(c.getFullName() + " has " + ctl.size() +
				// " inner classes");

                inner = c.getTypes().toArray(new ClassType[0]);

				for (int i = 0; i < inner.length; i++) {
					newInnerClasses.add(inner[i]);
				}
			}
			innerClasses.addAll(newInnerClasses);

			copyNewInner = (Vector) newInnerClasses.clone();
			newInnerClasses.clear();
			iter = copyNewInner.iterator();
			if (!iter.hasNext())
				finished = true;
		}
		
		this.innerClasses = innerClasses;
	}

	public void unionClasses() {
		Debug.info("Union Inner Classes With Classes");
		//add inner classes to Vector of all classes.
		classes.addAll(innerClasses);
		classes.addAll(localClasses);
	}

	public void findLocalClasses() {
		//find all local classes
		Debug.info("Find local classes");

		//this way we also find all methods

		localClasses = new Vector();
		Vector newLocalClasses = new Vector();
		Vector copyNewLocal;
		Iterator iter = classes.iterator();
		boolean finished = false;
		while (!finished) {
			while (iter.hasNext()) {
				ClassType c = (ClassType) iter.next();
				
				// if this ClassType is a ClassDeclaration, extract anonymous classes
				if (!(c instanceof TypeDeclaration)) // we have no source for that class. 
					continue;
				
				// extract anonymous classes
				TreeWalker t = new TreeWalker((TypeDeclaration)c);
				while (t.next()) {
					if ((t.getProgramElement() instanceof TypeDeclaration) && (t.getProgramElement() != c)) {
						TypeDeclaration dec = (TypeDeclaration)t.getProgramElement();
						if ( !newLocalClasses.contains(dec) && !localClasses.contains(dec)) 
							newLocalClasses.add(dec);
					}
			
				}
				// extracting anonymous classes ends here
				
			}
			localClasses.addAll(newLocalClasses);
			copyNewLocal = (Vector) newLocalClasses.clone();
			newLocalClasses.clear();
			iter = copyNewLocal.iterator();
			if (!iter.hasNext())
				finished = true;
		}
		
		// local classes are not added to classes-Vector
		// because they created by LocalClassesBuilder (Lazy-Method)
		// see also ClassTypeBuilder.getInstanceFromMapper()
	}




	public void eliminateDuplicateClasses() {
		Debug.info("Eliminating Duplicate Classes");
		//make sure there aren't any duplicates in collection of classes
		HashSet hset = new HashSet(classes);
		classes = new Vector();
		classes.addAll(hset);
	}

	public String findFileName(String classname) {

		// first we look directly for the location of the class
		DataLocation loc = classFileRepository.findClassFile(classname);

		// second we test to find location in case of a local class
		location_find_test:
		if (loc == null) {
			String innername = classname;
			int ldp = innername.length() - 1;
			StringBuffer sb = new StringBuffer(innername);
			inner_class_test:
			while (true) {
			ldp = innername.lastIndexOf('.', ldp);

			if (ldp == -1) {
				break location_find_test;
			}

			sb.setCharAt(ldp, '$');
			innername = sb.toString();

			loc = classFileRepository.findClassFile(innername);
			if (loc != null) {
				classname = innername;
				break inner_class_test;
			}
			}
		}
			
		if (loc != null)
			return loc.toString();
		else 
			return null;
	}

	public void findMethodsConstructorsAndFields() {
		Debug.info("Find Methods And Constructors");

		allMethods = new Vector();
		allConstructors = new Vector();
		allFields = new Vector();
				
		Iterator iter = classes.iterator();
		while (iter.hasNext()) {
			ClassType c = (ClassType) iter.next();
				    
			Method[] methods = c.getMethods().toArray(new Method[0]);
			Constructor[] constrs =	c.getConstructors().toArray(new Constructor[0]);
			Field[] flds = c.getFields().toArray(new Field[0]);
		
			for (int i = 0; i < methods.length; i++) {
				allMethods.add(methods[i]);
			}
		
			//only add them (because constructors are also methods)
			//so we won't have duplicate local classes.
			for (int i = 0; i < constrs.length; i++) {
				allConstructors.add(constrs[i]);
			}
			
			for (int i = 0; i < flds.length; i++) {
				allFields.add(flds[i]);
			}

		}
	}

	public void createClasses() {
		Debug.info("Create Classes");
		//create Metamod instances of all ClassTypes in classes.
		Iterator iter = classes.iterator();
		while (iter.hasNext()) {
			ClassType c = (ClassType) iter.next();
			ClassTypeBuilder.getSingleton().extractMembers(c);
		}
	}

	/**
	 * 
	 */
	public void findAndCreateInitializers() {
		// TODO here we are looking for FieldSpecifications to create FieldInitializers
		Debug.info("Find And Create Initializers");
		
		// examine all classes
		Iterator iter = classes.iterator();
		while (iter.hasNext()) {
			ClassType currentClassType = (ClassType) iter.next();

			TreeWalker t = new TreeWalker((TypeDeclaration)currentClassType);
			while (t.next()) {
				// look for field-specifications
				if (t.getProgramElement() instanceof FieldSpecification) {
					FieldSpecification fieldSpecification = (FieldSpecification)t.getProgramElement();
					if (fieldSpecification.getInitializer() != null) {
						// get parent-FieldDeclaration:
						if (fieldSpecification.getParent() instanceof FieldDeclaration) {
							FieldDeclaration parentFieldDeclaration = (FieldDeclaration)fieldSpecification.getParent();
							
							// check if we have a FieldDeclaration for current Class
							// (in case of inner/local classes)
							if (parentFieldDeclaration.getMemberParent()==currentClassType) {
								// Field Initializer gets name of Field 
								String fieldName = fieldSpecification.getName();
	
								//Debug.info("Field Initializer found: " + fieldSpecification.getFullName());
								
								// get metamod-Class-Object
								Class currentClassMetamod = (Class) RecoderToOMMapper.getSingleton().getInstanceFromMapper(currentClassType);
	
								// create Field Initializer ==> Metamod-Constructor-Object
								de.fzi.sissy.metamod.Constructor fieldInitializer = new de.fzi.sissy.metamod.Constructor(fieldName);
							
								// setup to initializer
								fieldInitializer.setInitializer();
								
								// setup Position
								fieldInitializer.setPosition(FileBuilder.getSingleton().getSourcePosition(fieldSpecification.getInitializer()));
									
								// put SimpleStatement for Initialization in it
								BlockStatement blk = new BlockStatement();				
								blk.setPosition(FileBuilder.getSingleton().getSourcePosition(fieldSpecification.getInitializer()));
								//FilenameToStatementMapper.getSingleton().addStatement(blk.getPosition().getSourceFile().getPathName().substring(5), blk);
								de.fzi.sissy.metamod.SimpleStatement initializationStatement = new de.fzi.sissy.metamod.SimpleStatement(); 
								StatementBuilder.getSingleton().setupStatement(initializationStatement, fieldSpecification.getInitializer());
								blk.addStatement(initializationStatement);
								fieldInitializer.setBody(blk);
	
								// TODO Mapping??
								
								// TODO setup Accesses
								de.fzi.sissy.metamod.Field field_metamod = (de.fzi.sissy.metamod.Field) RecoderToOMMapper.getSingleton().getInstanceFromMapper(fieldSpecification);
								AccessBuilder.getSingleton().addVariableAccess(initializationStatement, field_metamod, fieldSpecification, true);
								
								// TODO further setup of SimpleStatement
															
								// add Field Initializer to class
								currentClassMetamod.addConstructor(fieldInitializer);
							}
						}
					}
				} else 	if (t.getProgramElement() instanceof ClassInitializer) {
					ClassInitializer classInitializerRecoder = (ClassInitializer)t.getProgramElement();
					// only examine static initialization blocks
					if (classInitializerRecoder.isStatic()) {
						// we create a Metamod-Constructor-Object as Initializer!


						// check if we have a ClassInitializer for current Class
						// (in case of inner/local classes)
						if (classInitializerRecoder.getMemberParent()==currentClassType) {
						
						
							// Field Initializer gets name of Field 
							String className = currentClassType.getName();
	
							//Debug.info("Static Initialization Block found: " + currentClassType.getFullName());
								
							// create Field Initializer ==> Metamod-Constructor-Object
							de.fzi.sissy.metamod.Constructor classInitializerMetamod = new de.fzi.sissy.metamod.Constructor(className);
							
							// setup to initializer
							classInitializerMetamod.setInitializer();
								
							// setup Position
							classInitializerMetamod.setPosition(FileBuilder.getSingleton().getSourcePosition(classInitializerRecoder));
							
							// setup Static
							classInitializerMetamod.setStatic(true);
							
							// generate Statement-Hierarchie for Class Initializer
							StatementBuilder.getSingleton().generateStatementHierarchie(classInitializerMetamod, classInitializerRecoder.getBody());
	
							// TODO setup Accesses
							//AccessBuilder.getSingleton().walkToFindAndCreateAccesses(classInitializerRecoder.getBody());
	
							// TODO setup other stuff
						
							// get metamod-Class-Object
							Class currentClassMetamod = (Class) RecoderToOMMapper.getSingleton().getInstanceFromMapper(currentClassType);
							currentClassMetamod.addConstructor(classInitializerMetamod);
							
						}
						
						
						
					}
				}

			}
		}
		
	}

	public void establishDirectSuperclassRelation() {
		Debug.info("Establish Direct Superclass - Relation");
		//calculate the directSuperClasses relations among classes
		DirectSuperClassesBuilder.getSingleton().extractFromRecoder();
	}

	public void establishInnerClassRelation() {
		Debug.info("Establish Inner Class - Relation");
		//extract inner classes relations
		Iterator iter = classes.iterator();
		while (iter.hasNext()) {
			ClassType c = (ClassType) iter.next();
			InnerClassesBuilder.getSingleton().extractFromRecoder(c);
		}
	}

	public ModelElement createArrayType(ArrayType arrayType_recoder) {
		if (arrayType_recoder != null) {
			int dim_count = 0;
			
			Type baseType = arrayType_recoder.getBaseType();	
			de.fzi.sissy.metamod.Type baseType_metamod = (de.fzi.sissy.metamod.Type) ClassTypeBuilder.getSingleton().getInstanceFromMapper(baseType);
			
			// (08a) Array-Object created.
			
			de.fzi.sissy.metamod.Array array = new de.fzi.sissy.metamod.Array(baseType_metamod);
			modelElementRepository.getRoot().addType(array);
			array.setReferenceType();
			RecoderToOMMapper.getSingleton().addInstanceToMapper(arrayType_recoder, array);
			return array;
		}
		return null;
	}

	public void createFields() {
		//extract all attributes of classes
		Debug.info("Create Fields");
		Iterator iter = classes.iterator();
		while (iter.hasNext()) {
			ClassType c = (ClassType) iter.next();
			FieldBuilder.getSingleton().extractFromRecoder(c);
		}
	}

	public void separateConstructorsAndMethods() {
		Debug.info("Separate Constructors And Methods");
		//extract all methods and constructors
		//first remove all constructors from allMethods
		for (int i = 0; i < allMethods.size(); i++) {
			Method m = (Method) allMethods.elementAt(i);
			if (m instanceof Constructor) {
				allMethods.remove(i);
				i--;
			}
		}
	}

	public void createMethods() {
		//now we can extract only methods
		Debug.info("Create Methods");
		Iterator iter = allMethods.iterator();
		while (iter.hasNext()) {
			Method m = (Method) iter.next();
			MethodBuilder.getSingleton().extractFromRecoder(m);
		}
		
	}

	public void createConstructors() {
		//and only constructors
		Debug.info("Create Constructors");
		Iterator iter = allConstructors.iterator();
		while (iter.hasNext()) {
			Constructor constr = (Constructor) iter.next();
			ConstructorBuilder.getSingleton().extractFromRecoder(constr);
		}
	}

	public void reuniteConstructorsAndMethods() {
		//first we unite methods and constructors again
		Debug.info("Reunite Constructors And Methods");
		allMethods.addAll(allConstructors);
	}
	
	public void createStatementViewer() {
		// get all metamod-Methods:
		Vector metamod_functions = new Vector();
		Iterator itr = allMethods.iterator();
		while(itr.hasNext()) {
			de.fzi.sissy.metamod.Function metamod_function = 
			   (de.fzi.sissy.metamod.Function) RecoderToOMMapper.getSingleton().getInstanceFromMapper(itr.next());
			   
			metamod_functions.add(metamod_function);
		}
		
		if (!metamod_functions.isEmpty()) {
			sv = new StatementViewer();
			sv.showMethodSelection(metamod_functions);
		}
	}
	
	public StatementViewer getStatementViewer() {
		return sv;
	}

	public void establishLocalClassRelation() {
		Debug.info("Establish Local Class - Relation");
		//calculate localClasses relation between methods and classes
		Iterator iter = allMethods.iterator();
		while (iter.hasNext()) {
			Method m = (Method) iter.next();
			LocalClassesBuilder.getSingleton().extractFromRecoder(m);
		}
		
		iter = allFields.iterator();
		while (iter.hasNext()) {
			Field f = (Field)iter.next();
			LocalClassesBuilder.getSingleton().extractFromRecoder(f);			
		}
	}

	public void findAndCreateAccesses() {
		//now we can extract all accesses
		Debug.info("Find And Create Accesses");

		Iterator iter = allMethods.iterator();
		while (iter.hasNext()) {
			Method m = (Method) iter.next();
			// In AccessBuilder we start an overall extraction process
			// for all Variable, Function and Type Accesses
			// (except InheritanceTypeAccess, ...)
			AccessBuilder.getSingleton().extractFromRecoder(m);

			//ClassAccessBuilder.getSingleton().extractFromRecoder(m);
		}
		
		iter = allFields.iterator();
		while (iter.hasNext()) {
			Field f = (Field)iter.next();
			AccessBuilder.getSingleton().extractFromRecoder(f);
		}
		
		//showClasses();
	}
	
	public void setupOverrideStatusOfMethods() {
		// we have to separate once more:
		this.separateConstructorsAndMethods();
		
		// we calculate override status within the metamod-structure:
		Debug.info("Setup Override ResultStatus for Methods");

		double counter = 0;
		Iterator method_itr = allMethods.iterator();
		while (method_itr.hasNext()) {
			recoder.abstraction.Method recoder_method = (recoder.abstraction.Method) method_itr.next();
	
			//// TODO: Added by Mircea Trifu
			/*
			if (recoder_method instanceof Constructor) {
				Debug.info("A Constructor in Override-Setup, tststs !");
				continue;
			}
			*/
			////
			
			// get metamod-method:
			de.fzi.sissy.metamod.Method currentMethod = (de.fzi.sissy.metamod.Method)RecoderToOMMapper.getSingleton().getInstanceFromMapper(recoder_method);

			//counter++;
			//if (counter % 100 == 0) 			
			//Debug.info((counter/(double)allMethods.size()) + " % done.");
//			Debug.info("Method: " + currentMethod.getSimpleName());
		
			// get surrounding class
			Class surroundingClass = currentMethod.getSurroundingClass();

			//Debug.info("Surrounding-Class: " + surroundingClass.getSimpleName());

			// get all super classes
			ModelElementList superClasses = surroundingClass.getAllSuperTypes();
			
			// get all methods of these superclasses
			ModelElementList allSuperclassMethods = new ModelElementList();
			
			
			Iterator class_itr = superClasses.iterator();
			override_test:
			while (class_itr.hasNext()) {
				Class sclass = (Class)class_itr.next();
			
				// check for overriden methods
				
				Iterator supermethod_itr = sclass.getMethods().iterator();
				while (supermethod_itr.hasNext()) {
					de.fzi.sissy.metamod.Method amethod = (de.fzi.sissy.metamod.Method) supermethod_itr.next();
					// An overriden method has identical signature			
					if (amethod.getSimpleName().equals(currentMethod.getSimpleName()))
					if (amethod.hasIdenticalSignature(currentMethod)) {
						//Debug.info("Override found: "+amethod.getSimpleName());
						currentMethod.setOverridenMember(amethod);
						currentMethod.setOverride();
						break override_test;
					}
				}
				
			}
			
		}		
		
	}


	
	public void showClasses() {
		ModelElementList mel = modelElementRepository.getRoot().getClasses();
		
		Iterator itr = mel.iterator();
		
		while(itr.hasNext()) {
			Class cl = (Class) itr.next();
			
			System.out.println(cl.getSimpleName());
			
			Iterator ita_itr = cl.getInheritanceTypeAccesses().iterator();
			while(ita_itr.hasNext()) {
				InheritanceTypeAccess ita = (InheritanceTypeAccess) ita_itr.next();
				
				System.out.println(ita.getAccessedTarget().getSimpleName());
			}
			
		}
	}


}
