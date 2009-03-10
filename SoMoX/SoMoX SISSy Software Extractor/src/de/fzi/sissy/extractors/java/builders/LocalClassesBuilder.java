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
import recoder.abstraction.Field;
import recoder.abstraction.Method;
import recoder.convenience.TreeWalker;
import recoder.java.Expression;
import recoder.java.ProgramElement;
import recoder.java.declaration.FieldSpecification;
import recoder.java.declaration.MethodDeclaration;
import recoder.java.declaration.TypeDeclarationContainer;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.TypeParameterClass;

/**
 * @author haller
 */
public class LocalClassesBuilder extends Builder {

	private static LocalClassesBuilder singleton = null;
	
	/**
	 * 
	 */
    private LocalClassesBuilder() {
		super();
	}

	public static LocalClassesBuilder getSingleton() {
		if (singleton == null) {
			singleton = new LocalClassesBuilder();
		}//if
		return singleton;
	}//getSingleton
	
	public void extractFromRecoder(Method method_recoder) {
		if (method_recoder instanceof MethodDeclaration) {
			TreeWalker tw = new TreeWalker((MethodDeclaration)method_recoder);
			while (tw.next()) {
				ProgramElement pe = tw.getProgramElement();
				if (pe instanceof TypeDeclarationContainer) {
					TypeDeclarationContainer  tdc = (TypeDeclarationContainer)pe;
	
					for (int i = 0; i < tdc.getTypeDeclarationCount() ; i++) {
						ClassTypeBuilder classTypeBuilder = ClassTypeBuilder.getSingleton();
					
						//we look up the class in the model
						de.fzi.sissy.metamod.Class classType_metamod = (de.fzi.sissy.metamod.Class)
							classTypeBuilder.getInstanceFromMapper(tdc.getTypeDeclarationAt(i));
				
						if (classType_metamod instanceof TypeParameterClass)
							continue;
						
						//now we connect the method and the classes by a localClasses relation
						Function method_metamod = (Function) RecoderToOMMapper.getSingleton().getInstanceFromMapper(method_recoder);
						
						method_metamod.addLocalClass(classType_metamod);
					}
				}
			}
		}
	}

	public void extractFromRecoder(Field field_recoder) {
		if (field_recoder instanceof FieldSpecification) {
			Expression init = ((FieldSpecification)field_recoder).getInitializer();
			TreeWalker tw = new TreeWalker(init);
			while (tw.next()) {
				ProgramElement pe = tw.getProgramElement();
				if (pe instanceof TypeDeclarationContainer) {
					TypeDeclarationContainer  tdc = (TypeDeclarationContainer)pe;
	
					for (int i = 0; i < tdc.getTypeDeclarationCount() ; i++) {
						ClassTypeBuilder classTypeBuilder = ClassTypeBuilder.getSingleton();
					
						//we look up the class in the model
						de.fzi.sissy.metamod.Class classType_metamod = (de.fzi.sissy.metamod.Class)
							classTypeBuilder.getInstanceFromMapper(tdc.getTypeDeclarationAt(i));

						if (classType_metamod instanceof TypeParameterClass)
							continue;
						
						//now we connect the method and the classes by a localClasses relation
						de.fzi.sissy.metamod.Statement initializer = (de.fzi.sissy.metamod.Statement) RecoderToOMMapper.getSingleton().getInstanceFromMapper(init);
						Function method_metamod = initializer.getSurroundingFunction();						
						method_metamod.addLocalClass(classType_metamod);
					}					
				}
			}
		}
		
	}
}
