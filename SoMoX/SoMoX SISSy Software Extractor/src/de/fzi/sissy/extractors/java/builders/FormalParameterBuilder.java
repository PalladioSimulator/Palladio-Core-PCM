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

import recoder.abstraction.Method;
import recoder.abstraction.ParameterizedType;
import recoder.abstraction.Type;
import recoder.abstraction.TypeParameter;
import recoder.bytecode.MethodInfo;
import recoder.java.declaration.MethodDeclaration;
import recoder.java.declaration.ParameterDeclaration;
import recoder.java.declaration.VariableSpecification;
import recoder.service.NameInfo;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.FormalParameter;
import de.fzi.sissy.metamod.Function;

/**
 * @author szuli
 *
 */
public class FormalParameterBuilder extends Builder {

	private static FormalParameterBuilder singleton = null;

	/**
	 * 
	 */
	private FormalParameterBuilder() {
		super();
	}

	public static FormalParameterBuilder getSingleton() {
		if (singleton == null) {
			singleton = new FormalParameterBuilder();
		}
		return singleton;
	} //getSingleton


	
	/* (non-Javadoc)
	 * @see de.fzi.goose.extractor.builders.VariableBuilder#getVariableList(recoder.abstraction.ClassType)
	 */
	public void extractFromRecoder(Method method_recoder) {
		if (method_recoder instanceof MethodDeclaration) {
			MethodDeclaration methodDeclaration_recoder = (MethodDeclaration) method_recoder;
			ParameterDeclaration[] parameters_recoder =	methodDeclaration_recoder.getParameters().toArray(new ParameterDeclaration[0]);
			for (int i = 0; parameters_recoder.length > i; i++) {
				ParameterDeclaration parameter_recoder = parameters_recoder[i];
				VariableSpecification variable_recoder = parameter_recoder.getVariableSpecification();
				String simpleName = variable_recoder.getName();
		
				Type type_recoder = variable_recoder.getType();
                if (type_recoder instanceof ParameterizedType) 
                    type_recoder = ((ParameterizedType) type_recoder).getGenericType();
                    
                

				de.fzi.sissy.metamod.Type type_metamod = (de.fzi.sissy.metamod.Type)ClassTypeBuilder.getSingleton().getInstanceFromMapper(type_recoder);;

				// create DeclarationTypeAccess for FormalParameter !!
				de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);
				Common.extractTypeArguments(dta, variable_recoder.getType());
                // Position for dta
				dta.setPosition(FileBuilder.getSingleton().getSourcePosition(parameter_recoder));
	
				FormalParameter parameter_metamod = new FormalParameter(simpleName);
				
				parameter_metamod.setPosition(FileBuilder.getSingleton().getSourcePosition(parameter_recoder));

				//we also add it to the recoder to mdr mapper
				RecoderToOMMapper.getSingleton().addInstanceToMapper(variable_recoder, parameter_metamod);
				
				//we also set the hasParameter link between the method and the parameter
				Function method_metamod = 
				    (Function)RecoderToOMMapper.getSingleton().getInstanceFromMapper(method_recoder);
				
				method_metamod.addFormalParameter(parameter_metamod);
				parameter_metamod.setTypeDeclaration(dta);				
			} //for
		} //if
		else if (method_recoder instanceof MethodInfo) {
			NameInfo ni = ExtractorFassade.getNameInfo();
			String[] paramTypes = ((MethodInfo)method_recoder).getParameterTypeNames();
			for (int i=0; i<paramTypes.length; i++) {
				Type type_recoder = ni.getType(paramTypes[i]);

				if (type_recoder == null) {
					List<? extends TypeParameter> typeParams = method_recoder.getTypeParameters();
					if (typeParams != null)
						for (int j=0; j<typeParams.size(); j++) {
							TypeParameter tp = typeParams.get(j);
							if (tp.getName().equals(paramTypes[i])) {
								type_recoder = tp;
								break;
							}
						}					
					continue;
				}
				if (type_recoder instanceof ParameterizedType) 
                    type_recoder = ((ParameterizedType) type_recoder).getGenericType();
				de.fzi.sissy.metamod.Type type_metamod = (de.fzi.sissy.metamod.Type)ClassTypeBuilder.getSingleton().getInstanceFromMapper(type_recoder);;

				// create DeclarationTypeAccess for FormalParameter !!
				de.fzi.sissy.metamod.DeclarationTypeAccess dta = new de.fzi.sissy.metamod.DeclarationTypeAccess(type_metamod);
				Common.extractTypeArguments(dta, ni.getType(paramTypes[i]));
				FormalParameter parameter_metamod = new FormalParameter("arg"+i);

				//we also set the hasParameter link between the method and the parameter
				Function method_metamod = 
				    (Function)RecoderToOMMapper.getSingleton().getInstanceFromMapper(method_recoder);
				
				method_metamod.addFormalParameter(parameter_metamod);
				parameter_metamod.setTypeDeclaration(dta);							
			}
		}
		
	} //extractFromRecoder

}
