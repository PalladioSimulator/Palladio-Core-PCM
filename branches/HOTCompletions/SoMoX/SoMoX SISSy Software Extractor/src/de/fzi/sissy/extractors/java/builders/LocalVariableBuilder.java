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
import recoder.abstraction.Method;
import recoder.abstraction.ParameterizedType;
import recoder.abstraction.Type;
import recoder.abstraction.Variable;
import recoder.convenience.TreeWalker;
import recoder.java.Expression;
import recoder.java.ProgramElement;
import recoder.java.declaration.LocalVariableDeclaration;
import recoder.java.declaration.MethodDeclaration;
import recoder.java.declaration.VariableSpecification;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.LocalVariable;
import de.fzi.sissy.util.Debug;

/**
 * It extracts all local variables in a method and adds the appropriate localvariable 
 * elements to the model.
 * @author szuli
 *
 */
public class LocalVariableBuilder extends Builder {

	private static LocalVariableBuilder singleton = null;

	/**
	 * 
	 */
	private LocalVariableBuilder() {
		super();
	}

	public static LocalVariableBuilder getSingleton() {
		if (singleton == null) {
			singleton = new LocalVariableBuilder();
		} //if
		return singleton;
	} //getSingleton

	public void extractFromRecoder(Method method_recoder) {
		if (method_recoder instanceof MethodDeclaration) {
			MethodDeclaration methodDeclaration_metamod = (MethodDeclaration) method_recoder;
			TreeWalker treeWalker = new TreeWalker(methodDeclaration_metamod);
			while (treeWalker.next()) {
				ProgramElement ASTElement_recoder =	treeWalker.getProgramElement();
				// here we only create DeclarationTypeAccesses for VariableSpecifications contained in LocalVariableDeclarations
				// see AccessBuilder for DeclarationTypeAccesses in other places.
				if (ASTElement_recoder instanceof LocalVariableDeclaration) {
					LocalVariableDeclaration localVariableDeclaration_recoder =	(LocalVariableDeclaration) ASTElement_recoder;
					
					VariableSpecification[] variableSpecificationArray_recoder = 
					    							localVariableDeclaration_recoder.getVariables().toArray(new VariableSpecification[0]);
					
					for (int i = 0;	i < variableSpecificationArray_recoder.length; i++) {
					    VariableSpecification variableSpecification_recoder = variableSpecificationArray_recoder[i];
					    
						if (RecoderToOMMapper.getSingleton().getInstanceFromMapper(variableSpecification_recoder) != null)
						    return;
					    
						String simpleName =	variableSpecification_recoder.getName();

						//we resolve the type of the variable
						Type variableType_recoder =	variableSpecification_recoder.getType();
                        if (variableType_recoder instanceof ParameterizedType) {
                            variableType_recoder = ((ParameterizedType) variableType_recoder).getGenericType();
                            
                        }
						
						de.fzi.sissy.metamod.Type type_metamod = (de.fzi.sissy.metamod.Type)
						ClassTypeBuilder.getSingleton().getInstanceFromMapper(variableType_recoder);

						// create DeclarationTypeAccess for Local Variable !!
						de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);
                        Common.extractTypeArguments(dta, variableSpecification_recoder.getType());
						// Position for dta
						dta.setPosition(FileBuilder.getSingleton().getSourcePosition(variableSpecification_recoder));

						LocalVariable localVariable_metamod = new LocalVariable(simpleName);
						
						// get according metamod-statement of the localVariableDeclaration
						de.fzi.sissy.metamod.Statement metamod_statement = (de.fzi.sissy.metamod.Statement) RecoderToOMMapper.getSingleton().getInstanceFromMapper(localVariableDeclaration_recoder);
						
						
						
						// here we create and add a VariableAccess if there is an initializer 
						// for this VariableSpecification !
						Expression initializer = variableSpecification_recoder.getInitializer();
						//Debug.info("VariableSpecification "+variableSpecification_recoder.getName()+" gefunden.");

						Variable variable_recoder =	ExtractorFassade.getSourceInfo().getVariable(variableSpecification_recoder);
					
						if (initializer != null) {
							AccessBuilder.getSingleton().addVariableAccess(metamod_statement, localVariable_metamod, variableSpecification_recoder, true);
						} else {
							//Debug.warning("VariableSpecification "+variableSpecification_recoder.getName()+" has no Initializer, so no Access created.");
						}

						//we also add the hasVariables link to function --> variable
						Function method_metamod = (Function) RecoderToOMMapper.getSingleton().getInstanceFromMapper(method_recoder);
						if (method_metamod == null)
							Debug.error("LocalVariableBuilder::extractFromRecoder - method_metamod is null");

						localVariable_metamod.setPosition(FileBuilder.getSingleton().getSourcePosition(variableSpecification_recoder));

						if (method_metamod != null)
							method_metamod.addLocalVariable(localVariable_metamod);

						localVariable_metamod.setTypeDeclaration(dta);
						
						//we also add it to the recoder to mdr mapper
						RecoderToOMMapper.getSingleton().addInstanceToMapper(variableSpecification_recoder, localVariable_metamod);
					} //for
				}//if
			} //while
		} //if
	}

}
