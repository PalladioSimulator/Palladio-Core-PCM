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
import java.util.List;

import recoder.abstraction.ArrayType;
import recoder.abstraction.ClassType;
import recoder.abstraction.ParameterizedType;
import recoder.abstraction.Type;
import recoder.abstraction.TypeParameter;
import recoder.java.declaration.TypeDeclaration;
import recoder.java.declaration.TypeParameterDeclaration;
import recoder.java.reference.TypeReference;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.File;
import de.fzi.sissy.metamod.GenericClass;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.Package;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.TypeParameterClass;
import de.fzi.sissy.util.Debug;

/**
 * @author szulman
 */
public class ClassTypeBuilder extends Builder {

	private static ClassTypeBuilder singleton;

	/**
	 * 
	 */
	private ClassTypeBuilder() {
		super();
	}

	public static ClassTypeBuilder getSingleton() {
		if (singleton == null) {
			singleton = new ClassTypeBuilder();
		} //
		return singleton;
	} //getSingleton
	
	public Class extractMembers(ClassType classType_recoder) {
		
        while (classType_recoder instanceof ParameterizedType) {
            classType_recoder = ((ParameterizedType)classType_recoder).getGenericType();
        }    
        // check if we already have this class
        Class classType_metamod = (Class)RecoderToOMMapper.getSingleton().getInstanceFromMapper(classType_recoder); 
        if (classType_metamod!=null)
            return classType_metamod;
	    
        // folgende abbildung: (recoder -> metamod)
        // ParameterizedType -> GenericClass
        // ClassType mit TypeParameters -> GenericClass
        // ClassType ohne TypeParameters -> Class
        
        boolean generic = false;
        if ((classType_recoder.getTypeParameters() != null) && (!classType_recoder.getTypeParameters().isEmpty())) {
            generic = true;
        }
            
        String simpleName = classType_recoder.getName();

        if (generic) {
            classType_metamod = new GenericClass(simpleName);
        }
        else if (classType_recoder instanceof TypeParameter)
            classType_metamod = new TypeParameterClass(simpleName);
        else
            classType_metamod = new Class(simpleName);
        	
		// mapping
		RecoderToOMMapper.getSingleton().addInstanceToMapper(classType_recoder, classType_metamod);

		if (generic)
            extractTypeParameters((GenericClass)classType_metamod, classType_recoder);
		
		if (classType_recoder.isInterface()) {
			classType_metamod.setInterface();
		} 
        
		if (classType_recoder instanceof TypeDeclaration) {
			/* if it is a typedeclaration it means,
			 * we have a file, where it was declared
			 * so we can set a Position: 
			 */ 
			Position position = FileBuilder.getSingleton().getSourcePosition((TypeDeclaration)classType_recoder);
			if (position == null)
				Debug.warning("Null-Position setted for Class!");
				
			classType_metamod.setPosition(position);
            
            //((TypeDeclaration)classType_recoder).getComments()
		} else {
			// TODO missing Position
			/* in the other case there is no TypeDeclaration available,
			 * but since the classType of Recoder isn't null we
			 * create a Position object and set the assembly field of this Position object.
			 */ 
			//Debug.warning("Assembly-File-Object created!");
			String filename = MetamodBuilder.getSingleton().findFileName(classType_recoder.getFullName());
			
			Position assembly_position = new Position(null, 0, 0, 0, 0);
			File assembly_file = new File(filename);
			assembly_file.setAssembly();
			ExtractorFassade.getModelElementRepository().getRoot().addFile(assembly_file);
			assembly_position.setAssembly(assembly_file);
			classType_metamod.setPosition(assembly_position);
		}
		
		classType_metamod.setReferenceType();
        		
		if (classType_recoder.getName() != null)
		    if (classType_recoder.getName().equals("<unknownClassType>"))
		        return classType_metamod;
		
		extractModifiers(classType_recoder);
		establishContainmentRelationWithPackage(classType_recoder);
		
		/*
		// (07b) Inner Class - Relation
		Class classType_surrounding = (Class) this.getInstanceFromMapper(classType_recoder.getContainingClassType());
		if (classType_surrounding != null)
		    classType_surrounding.addInnerClass(classType_metamod);
		*/
		
		return classType_metamod;
	} //extractMembers

	/*
	 * This method sets the "classes" association between packages and contained classes.
	 */	
	public void establishContainmentRelationWithPackage(ClassType classType_recoder) {
		recoder.abstraction.Package containingPackage_recoder = classType_recoder.getPackage();
		//we look up the appropriate package in the METAMOD instance
		Package containingPackage_metamod = (Package) RecoderToOMMapper.getSingleton().getInstanceFromMapper(containingPackage_recoder);
		if (containingPackage_metamod == null)
			containingPackage_metamod = PackageTypeBuilder.getSingleton().extractFromRecoder(containingPackage_recoder);
		//we look up the appropriate class in the METAMOD instance
		Class classType_metamod = (Class) this.getInstanceFromMapper(classType_recoder);
		if (containingPackage_metamod!=null && classType_metamod != null) {
			containingPackage_metamod.addClass(classType_metamod);
		}//if
		//root package?
	}//extractContainingPackage
	
	
	public void extractModifiers(ClassType classType_recoder) {
		
		//we look up the appropriate member
		Class classType_metamod = (Class) this.getInstanceFromMapper(classType_recoder);
		
		if (classType_recoder.isAbstract()) {
			classType_metamod.setAbstract(true);
		}
		
		if (classType_recoder.isFinal()) {
			classType_metamod.setFinal(true);
		}
		
		if (classType_recoder.isPrivate()) {
			classType_metamod.setPrivate();
		}
		
		if (classType_recoder.isProtected()) {
			classType_metamod.setProtected();
		}

		if (classType_recoder.isPublic()) {
			classType_metamod.setPublic();
		}

		if (classType_recoder.isAbstract()) {
			classType_metamod.setAbstract(true);
		}
		
		if (classType_recoder.isStatic()) {
			classType_metamod.setStatic(true);
		}

	}//extractModifiers

	
	/* (non-Javadoc)
	 * We override the getInstanceFromMapper method in order to implement the "lazy" property of the source code analysing.
	 * The terminology "lazy" means in our case, that our default strategy is not to analyze compiled classes in order to avoid the extraction of libraries.
	 * However if we need some types later (for example, because a local variable in the analyzed source has a type of a class found in the library)
	 * we add them. 
	 * @see de.fzi.extractor.builders.Builder#getInstanceFromMapper(java.lang.Object)
	 */
	public ModelElement getInstanceFromMapper(Type recoderObject) {
		ModelElement modelElement_metamod = RecoderToOMMapper.getSingleton().getInstanceFromMapper(recoderObject);
		if (modelElement_metamod == null) {
			//if we have not analyzed this recoder object, but we need it, we analyze it now
			if (recoderObject instanceof ClassType)
			    modelElement_metamod = extractMembers((ClassType)recoderObject);
			else if (recoderObject instanceof ArrayType)
				modelElement_metamod = MetamodBuilder.getSingleton().createArrayType((ArrayType)recoderObject);
			else return null;
		}//if
		return modelElement_metamod;
	}
    
    private void extractTypeParameters(GenericClass mmClass, ClassType rClass) {
        List<? extends TypeParameter> rTpList = rClass.getTypeParameters();
        for (TypeParameter tp : rTpList) {
        	TypeParameterClass tpc = (TypeParameterClass)extractMembers(tp);
        	if (tp instanceof TypeParameterDeclaration)
        		tpc.setNormal();
            mmClass.addTypeParameter(tpc);
        }
    }    
}
