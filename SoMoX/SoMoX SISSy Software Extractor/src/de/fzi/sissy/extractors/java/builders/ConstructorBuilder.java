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
import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Constructor;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.GenericConstructor;
import de.fzi.sissy.metamod.Member;

/**
 * @author szulman
 *  
 */
public class ConstructorBuilder extends FunctionBuilder {

	private static ConstructorBuilder singleton;

	/**
	 *  
	 */
	private ConstructorBuilder() {
		super();
	}

	public static ConstructorBuilder getSingleton() {
		if (singleton == null) {
			singleton = new ConstructorBuilder();
		}
		return singleton;
	}

	protected Function addNewInstance(String simpleName, boolean generic) {
		Constructor constructor_metamod = null;
		if (generic)
			constructor_metamod = new GenericConstructor(simpleName);
		else
			constructor_metamod = new Constructor(simpleName);
			
		return constructor_metamod;
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fzi.extractor.builders.FunctionBuilder#addToContainerClass(de.fzi.metamod.Class,
	 *          de.fzi.metamod.Function)
	 */
	protected void addToContainerClass(
		Class containerClass_metamod,
		Function function_metamod) {
		containerClass_metamod.addConstructor((Constructor) function_metamod);
	}

	protected void extractModifiers(Constructor method_recoder) {

		//we look up the appropriate member
		Member member_metamod =
			(Member) RecoderToOMMapper.getSingleton().getInstanceFromMapper(method_recoder);
		
		if (method_recoder.isAbstract()) {
			member_metamod.setAbstract(true);
		}

		if (method_recoder.isFinal()) {
			member_metamod.setFinal(true);
		}
		else {
			member_metamod.setVirtual(true);
		}

		if (method_recoder.isPrivate()) {
			member_metamod.setPrivate();
		}

		if (method_recoder.isProtected()) {
			member_metamod.setProtected();
		}

		if (method_recoder.isPublic()) {
			member_metamod.setPublic();
		}

		member_metamod.setStatic(false);

	} //extractModifiers

}
