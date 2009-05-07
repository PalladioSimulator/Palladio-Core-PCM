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
import recoder.abstraction.Package;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.Root;

/**
 * @author szuli
 * It calculates hasPackages links between the packages
 */
public class HasPackagesBuilder extends Builder {

	private static HasPackagesBuilder singleton;
	
	/**
	 * 
	 */
	private HasPackagesBuilder() {
		super();
	}
	
	public static HasPackagesBuilder getSingleton() {
		if (singleton == null) {
			singleton = new HasPackagesBuilder();
		}//if
		return singleton;
	}//getSingleton

	/**
	 * It extracts the hasPackages links between packages.
	 *
	 */
	public void extractFromRecoder() {
		// (03b) Package-Containment-Relation

		//We iterate through all packages in our metamod model and calculate
		//the hasPackage links based on the package names. Lets consider the
		//package "java.util" for example. Its parent is the package "java"
		
		//See the next line, how we get his instances.
		Root root = ExtractorFassade.getModelElementRepository().getRoot();
		ModelElementList packagesList = root.getPackages();

		//Next we iterate throug all packages and calculate their parent using naming conventions in Java.
		for (int i = 0; i<packagesList.size(); i++) {
			//Ok, you can see one of the packages above.
			de.fzi.sissy.metamod.Package packageType = (de.fzi.sissy.metamod.Package) packagesList.get(i);
			
			//Here is the full name (for example "java.util") of the package.
			String fullName = packageType.getSimpleName();
			
			//And now, lets calculate the name of his parent package.
			if (fullName.matches(".*\\..*")) {//--> fullName does not contain "."
				String parentFullName = fullName.replaceAll("(.+)\\.(.*)", "$1");
				
				//Now as we calculated the name of the parent package, we
				//look up the parent package in the extent.
				Package parentPackageType_recoder = ExtractorFassade.getNameInfo().getPackage(parentFullName);
				de.fzi.sissy.metamod.Package parentPackageType_metamod = (de.fzi.sissy.metamod.Package) RecoderToOMMapper.getSingleton().getInstanceFromMapper(parentPackageType_recoder);
				//PackageType parentPackageType = (metamod.PackageType) PackageTypeBuilder.getSingleton().getNamedModelElementByName(parentFullName);
				if (parentPackageType_metamod == null)
					parentPackageType_metamod = PackageTypeBuilder.getSingleton().extractFromRecoder(parentPackageType_recoder);
				parentPackageType_metamod.addSubPackage(packageType);
			}//if  
			
			//povalahe:
			// strip simplenames so that they are simple and not fully qualified
			int a = fullName.lastIndexOf('.');
			if (a!=-1) {
				fullName = fullName.substring(a+1);
				packageType.setSimpleName(fullName);
			}
		}//while
	}
}
