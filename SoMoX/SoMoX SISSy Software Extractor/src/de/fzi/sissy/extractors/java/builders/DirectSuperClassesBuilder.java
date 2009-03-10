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

import java.util.ArrayList;
import java.util.List;

import recoder.abstraction.ClassType;
import recoder.abstraction.Method;
import recoder.convenience.TreeWalker;
import recoder.java.ProgramElement;
import recoder.java.declaration.ClassDeclaration;
import recoder.java.declaration.InheritanceSpecification;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.InheritanceTypeAccess;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.util.Debug;

/**
 *
 * @author szulman
 *
 */
public class DirectSuperClassesBuilder extends Builder {

	private static DirectSuperClassesBuilder singleton;

	/**
	 * 
	 */
	private DirectSuperClassesBuilder() {
		super();
	}

	public static DirectSuperClassesBuilder getSingleton() {
		if (singleton == null) {
			singleton = new DirectSuperClassesBuilder();
		}
		return singleton;
	} //getSingleton

	/**
	 * This method can be called, if all of the classtypes contained in the project are already extracted. 
	 * It simply iterates through all classes contained in the model so far and figures out the supertype relationship among them.
	 */
	public void extractFromRecoder() {
		// (07c) Direct-Superclass - Relation

		ClassTypeBuilder classTypeClass = ClassTypeBuilder.getSingleton();

		List<ClassType> cls_types = new ArrayList<ClassType>();
		cls_types.addAll(ExtractorFassade.getNameInfo().getClassTypes());
		int c1 = 0;
		while (c1 < cls_types.size()) {
			if (RecoderToOMMapper.getSingleton().getInstanceFromMapper(cls_types.get(c1)) == null)
				cls_types.remove(c1);
			else
				c1++;
		}
		
		//First we iterate through all classes in the project.
		for (int i = 0; i < cls_types.size(); i++) {
			ClassType childType = cls_types.get(i);
			
			// if the class is unresolved, skip it
			if (childType.getName().equals("<unknownClassType>"))
			    continue;

			//Then we figure out all supertype relations among them. Have a look, how we do it. First we 
			//gets all superTypes of classType, second we look up the appropriate supertype in our model and connect
			//them using DirectSuperClasses.add() method.
			ClassType[] superTypes = childType.getSupertypes().toArray(new ClassType[0]);
			for (int j = 0; superTypes.length > j; j++) {
				ClassType superType = superTypes[j];

				//we look up the supertype class in the model
				de.fzi.sissy.metamod.Class superType_metamod = (de.fzi.sissy.metamod.Class) classTypeClass.getInstanceFromMapper(superType);
				de.fzi.sissy.metamod.Class childType_metamod = (de.fzi.sissy.metamod.Class) classTypeClass.getInstanceFromMapper(childType);
				
				//Now we connect the child and the super classes by a directSuperClass relation.
				if (superType_metamod != childType_metamod) {
					if (cls_types.indexOf(superType) == -1)
						cls_types.add(superType);
				    // (07d) InheritanceTypeAccess created.
				    InheritanceTypeAccess access = new InheritanceTypeAccess(superType_metamod);
				    boolean positionSetted = false;
				    if (childType instanceof ClassDeclaration) {
					    TreeWalker treeWalker = new TreeWalker((ClassDeclaration)childType);
					    while (treeWalker.next()) {
					        ProgramElement p = treeWalker.getProgramElement();
					        if (p instanceof InheritanceSpecification) {
					            access.setPosition(FileBuilder.getSingleton().getSourcePosition(p));
					            positionSetted = true;
					        }
					    }
				    }

					if (!positionSetted) {
						// TODO missing Position ???
						// get position of childType_metamod
						Position position = childType_metamod.getPosition();
						if (position != null) {
							access.setPosition(position);
						} else {
							Debug.warning("Null-Position for InteritanceTypeAccess setted!");
						}
					}

					childType_metamod.addInheritanceTypeAccess(access);
				}//if
				
				//// Added by Mircea Trifu
				// Add overriden methods to superclass
				Method[] child_methods = childType.getMethods().toArray(new Method[0]);
				Method[] super_methods = superType.getMethods().toArray(new Method[0]);
				for (int k = 0; k < child_methods.length; k++) {
					Method child_met = child_methods[k];
					if (RecoderToOMMapper.getSingleton().getInstanceFromMapper(child_met) != null) {
						for (int l=0; l<super_methods.length; l++) {
							Method super_met = super_methods[l];
							if (child_met.getName().equals(super_met.getName()))
								if (child_met.getSignature().equals(super_met.getSignature()))
									if (RecoderToOMMapper.getSingleton().getInstanceFromMapper(super_met) == null)
										MethodBuilder.getSingleton().extractFromRecoder(super_met);
						}
					}
				}
				////				
			}
		}
	} //extractFromRecoder
}
