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

import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.GenericMethod;
import de.fzi.sissy.metamod.Method;


/**
 * @author szulman
 *  
 */
public class MethodBuilder extends FunctionBuilder {

	private static MethodBuilder singleton = null;

	private MethodBuilder() {

	}

	public static MethodBuilder getSingleton() {
		if (singleton == null) {
			singleton = new MethodBuilder();
		} //if
		return singleton;
	} //getSingleton

	protected Function addNewInstance(String simpleName, boolean generic) 
	{
		Method method_metamod = null;
		if (generic)
			method_metamod = new GenericMethod(simpleName);
		else
			method_metamod = new Method(simpleName);

		return method_metamod;
	} 
	
	
	/* (non-Javadoc)
	 * @see de.fzi.extractor.builders.FunctionBuilder#addToContainerClass(de.fzi.metamod.Class, de.fzi.metamod.Function)
	 */
	protected void addToContainerClass(Class containerClass_metamod, Function function_metamod) {
		containerClass_metamod.addMethod((Method)function_metamod);
	}

}
