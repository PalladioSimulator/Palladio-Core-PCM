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

import recoder.abstraction.ClassType;
import recoder.abstraction.TypeParameter;
import de.fzi.sissy.metamod.Class;

/**
 * @author haller
 */
public class InnerClassesBuilder extends Builder {

	private static InnerClassesBuilder singleton = null;
	
	/**
	 * 
	 */
    private InnerClassesBuilder() {
		super();
	}

	public static InnerClassesBuilder getSingleton() {
		if (singleton == null) {
			singleton = new InnerClassesBuilder();
		}//if
		return singleton;
	}//getSingleton
	
	public void extractFromRecoder(ClassType containingClassType_recoder) {
		// (07e) Inner Class - Relation (nochmal?)
		//getTypes() instead of getAllTypes()...
		ClassType[] innerClasses_recoder =
			containingClassType_recoder.getTypes().toArray(new ClassType[0]);
		
		for (int i = 0; i < innerClasses_recoder.length; i++) {
			//TODO: Do we have to filter out inner classes that are inherited????? Ask Volker.
			//Now all inner classes (also inherited) are considered
			ClassType innerClass_recoder = innerClasses_recoder[i];
			
			if (innerClass_recoder instanceof TypeParameter)
				continue;
			
			//Now we add the inner class as member to the containing class.
			Class containingClassType_metamod = (Class)
							ClassTypeBuilder.getSingleton().getInstanceFromMapper(containingClassType_recoder);
			Class innerClass_metamod = (Class)
							ClassTypeBuilder.getSingleton().getInstanceFromMapper(innerClass_recoder);
			
			containingClassType_metamod.addInnerClass(innerClass_metamod);
		}//for
	}

}
