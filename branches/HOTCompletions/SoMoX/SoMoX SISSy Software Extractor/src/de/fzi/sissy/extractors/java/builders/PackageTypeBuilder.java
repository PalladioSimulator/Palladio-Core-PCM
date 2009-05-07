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

import de.fzi.sissy.extractors.java.ExtractorFassade;

/**
 * @author szulman
 *  
 */
public class PackageTypeBuilder extends Builder {

	private static PackageTypeBuilder singleton;

	/**
	 *  
	 */
	private PackageTypeBuilder() {
		super();
	}

	public static PackageTypeBuilder getSingleton() {
		if (singleton == null) {
			singleton = new PackageTypeBuilder();
		} //if
		return singleton;
	} //getSingleton

	public de.fzi.sissy.metamod.Package extractFromRecoder(recoder.abstraction.Package packageType) {

		if (packageType != null) {

			//creating a metamod model element for this package
			String name = packageType.getName();
			
			//String simpleName = name.substring(name.lastIndexOf('.')+1);

			// (03a) Package-Object created.
			de.fzi.sissy.metamod.Package packageType_metamod =
				new de.fzi.sissy.metamod.Package(name, ExtractorFassade.getModelElementRepository().getRoot());

			//we also add it to the recoder to MDR mapper
			RecoderToOMMapper.getSingleton().addInstanceToMapper(packageType, packageType_metamod);

			return packageType_metamod;
			/*ClassTypeList classTypeList = packageType.getTypes();
			ClassType[] classTypeArray = classTypeList.toClassTypeArray();
			for (int j = 0; j < classTypeArray.length; j++) {
				ClassType classType = classTypeArray[j];
				//with this line, we exclude the compiled libraries, as we
				// only want to analyze sources
				if (classType instanceof ClassDeclaration)
					classes.add(classTypeArray[j]);
			}*/
		} //for
		return null;
	}

}
