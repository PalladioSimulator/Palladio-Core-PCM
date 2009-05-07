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

import recoder.abstraction.ClassType;
import recoder.abstraction.Type;
import recoder.io.SourceFileRepository;
import recoder.java.CompilationUnit;
import recoder.java.Import;
import recoder.java.ProgramElement;
import recoder.java.SourceElement;
import recoder.java.reference.PackageReference;
import recoder.java.reference.TypeReference;
import recoder.kit.UnitKit;
import recoder.list.generic.ASTList;
import de.fzi.sissy.extractors.java.ExtractorFassade;
import de.fzi.sissy.metamod.File;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.util.Debug;

/**
 * @author szulman
 *  
 */
public class FileBuilder extends Builder {

	private static FileBuilder singleton;

	/**
	 *  
	 */
	private FileBuilder() {
		super();
	}

	public static FileBuilder getSingleton() {
		if (singleton == null) {
			singleton = new FileBuilder();
		}
		return singleton;
	}

	public int linesOfCode(SourceFileRepository sourceFileRepository) {
		int totalLOC = 0;

		List<CompilationUnit> compilationUnitList = sourceFileRepository.getCompilationUnits();
		if (compilationUnitList != null) {
			CompilationUnit[] compilationUnitArray = compilationUnitList.toArray(new CompilationUnit[0]);
			for (int i = 0; compilationUnitArray.length > i; i++) {
				CompilationUnit compUnit = compilationUnitArray[i];

				int startLine =
					compUnit.getFirstElement().getStartPosition().getLine();
				int endLine =
					compUnit.getLastElement().getEndPosition().getLine();

				totalLOC += endLine - startLine;
			}
		}


		return totalLOC;
	}


	public Position getAssemblyPosition(ProgramElement source) {
		// TODO Where can I get the assembly file from ??? classFileRepository didn't work, maybe it was used wrong.
		
		ProgramElement pe = (ProgramElement) source;
		CompilationUnit compilationUnit = UnitKit.getCompilationUnit(pe);
		if (compilationUnit != null) {
			//file = (File) RecoderToOMMapper.getSingleton().getInstanceFromMapper(compilationUnit);
		} else {
			Debug.warning("getSourcePosition: No Compilation Unit Found");	
		}
		return null;
	}
		
	
	public Position getSourcePosition(SourceElement source) {
		int startLine = source.getFirstElement().getStartPosition().getLine();
		int startColumn = source.getFirstElement().getStartPosition().getColumn();
		int endLine = source.getLastElement().getEndPosition().getLine();
		int endColumn = source.getLastElement().getEndPosition().getColumn();
		File file = null;
		if (!(source instanceof ProgramElement)) {
			Debug.warning("Position object with file=null created!");
			return new Position(null, -1, -1, -1, -1);
		}
		ProgramElement pe = (ProgramElement) source;
		CompilationUnit compilationUnit = UnitKit.getCompilationUnit(pe);
		if (compilationUnit != null) {
			file = (File) RecoderToOMMapper.getSingleton().getInstanceFromMapper(compilationUnit);
		} else {
			Debug.warning("getSourcePosition: No Compilation Unit Found");	
		}

		if (file == null) {
			Debug.warning("getSourcePosition: File-Object is null!");
			return new Position(null, -1, -1, -1, -1);
		}
		
		while  ((startLine == -1) ||
				(startColumn == -1) ||
				(endLine == -1) ||
				(endColumn == -1)) {
			if (pe == null)
				break;
			if (startLine == -1)
				startLine = pe.getStartPosition().getLine();
			if (startColumn == -1)
				startColumn = pe.getStartPosition().getColumn();
			if (endLine == -1)
				endLine = pe.getEndPosition().getLine();
			if (endColumn == -1)
				endColumn = pe.getEndPosition().getColumn();
			pe = pe.getASTParent();
	    }
		return new Position(file, startLine, startColumn, endLine, endColumn);
	}

	public int extractFromRecoder(SourceFileRepository sourceFileRepository) {

		int totalLOC = 0;

		List<CompilationUnit> compilationUnitList = sourceFileRepository.getCompilationUnits();
		if (compilationUnitList != null) {
			CompilationUnit[] compilationUnitArray = compilationUnitList.toArray(new CompilationUnit[0]);
			for (int i = 0; i < compilationUnitArray.length; i++) {
				CompilationUnit compUnit = compilationUnitArray[i];

				int startLine =
					compUnit.getFirstElement().getStartPosition().getLine();
				int endLine =
					compUnit.getLastElement().getEndPosition().getLine();

				totalLOC += endLine - startLine;

				String fileName = compUnit.getName();

				// (02a) File-Object created.
				File file_metamod = new File(fileName);
				ExtractorFassade.getModelElementRepository().getRoot().addFile(file_metamod);
					
				//we also add it to the recoder to OM mapper
				RecoderToOMMapper.getSingleton().addInstanceToMapper(
					compUnit,
					file_metamod);

			} //for
		} //if

		//we extract now all imports among compilation units
		
		extractImports(sourceFileRepository);

		return totalLOC;
	} //extractFromRecoder

	/*
	 * This method sets the "containingFile" links between a file and the
	 * contained classes
	 */
	/*private void extractContainedClassTypes(CompilationUnit compUnit_recoder) {
		recoder.abstraction.ClassType[] classTypeArray_recoder =
			compUnit_recoder.getDeclarations().toClassTypeArray();
		for (int i = 0; classTypeArray_recoder.length > i; i++) {
			ClassType classType_recoder = classTypeArray_recoder[i];

			//we look up this classType in the METAMOD instancec
			de.fzi.metamod.Class classType_metamod =
				(de.fzi.metamod.Class) ClassTypeBuilder
					.getSingleton()
					.getInstanceFromMapper(
					classType_recoder);

			//we look up this compilation unit in the file repository
			File file_metamod =
				(File) RecoderToOMMapper.getSingleton().getInstanceFromMapper(
					compUnit_recoder);

			if (classType_metamod != null && file_metamod != null) {
				if (classType_metamod.hasSource()) {
					classType_metamod.
						getPosition().
							setSourceFile(file_metamod);
				}
			}
		} //for
	} //extractContainedClassTypes
	*/

	private void extractImports(SourceFileRepository sourceFileRepository) {
		// (02b) Imports extrahieren.
		//We iterate through all compilation units and than through all
		// imports of this
		//compilation unit and add them to the METAMOD instance.
		List<CompilationUnit> compilationUnitList = sourceFileRepository.getCompilationUnits();
		if (compilationUnitList != null) {
			CompilationUnit[] compilationUnitArray = compilationUnitList.toArray(new CompilationUnit[0]);
			for (int i = 0; i < compilationUnitArray.length; i++) {
				CompilationUnit compUnit = compilationUnitArray[i];

				File file_metamod =
					(File) RecoderToOMMapper
						.getSingleton()
						.getInstanceFromMapper(
						compUnit);

				//Now we iterate through all imports.
				ASTList<Import> imports = compUnit.getImports();
				if (imports != null) {
					Import[] importsArray = imports.toArray(new Import[0]);
					for (int j = 0; j < importsArray.length; j++) {
						Import import_recoder = importsArray[j];

						//is it a TypeReference? Then find compilation unit
						// where this type is declared.
						//Name of compilation unit equals name of metamod.File
						// instance.
						//Find File instance by name and add link.

						if (import_recoder.getPackageReference() == null) {
							// we import a class here !
							TypeReference typeRef = import_recoder.getTypeReference();
							
							if (typeRef != null) {
								Type referencedType_recoder = 
									ExtractorFassade.getSourceInfo().getType(typeRef);
														
								if (referencedType_recoder instanceof ClassType) {
									// check if we have already metamod-class-object:
									de.fzi.sissy.metamod.Class importedClass_metamod =
										(de.fzi.sissy.metamod.Class) RecoderToOMMapper
											.getSingleton()
											.getInstanceFromMapper(
											referencedType_recoder);
									if (importedClass_metamod != null) {
										file_metamod.addImportedType(
										importedClass_metamod);
									} else {
										Debug.info("New Imported Class ==> create metamod object!");
										// create new metamod-Class-object
										importedClass_metamod = 
											ClassTypeBuilder.getSingleton().extractMembers((ClassType)referencedType_recoder);
										file_metamod.addImportedType(
										importedClass_metamod);
									}
									
									// TODO Here we have to find a way to get the appropriate CompilationUnit for the ClassType
									// look up compilation unit
									CompilationUnit unit = null;
									// versuch 1:
									// unit = sourceFileRepository.getCompilationUnit(referencedType_recoder.getName()/.getFullName()/.getString());
									// versuch 2:
									// unit = sourceFileRepository.findSourceFile(referencedType_recoder.getName()/.getFullName()/.getString());
									// beide waren ohne Erfolg
									
									
									// look
									if (unit != null) {
										Debug.warning("Here a Compilation Unit was found for an Imported Class, "+referencedType_recoder.getFullName()+ ", Container: "+ referencedType_recoder.getProgramModelInfo().getClassTypeContainer((ClassType)referencedType_recoder).getFullName());
										System.exit(-3);
										File new_file_metamod = 
										  (File) RecoderToOMMapper.getSingleton().getInstanceFromMapper(unit);
										 
										if (new_file_metamod == null) {
											new_file_metamod = new File(unit.getName());
											ExtractorFassade.getModelElementRepository().getRoot().addFile(new_file_metamod);
					
											//we also add it to the recoder to OM mapper
											RecoderToOMMapper.getSingleton().addInstanceToMapper(unit, new_file_metamod);
											 
										} else {
											// class already there
										}
									} else {
										
										//Debug.warning("No Compilation Unit found for Imported Class, "+referencedType_recoder.getFullName()+ ", Container: "+ referencedType_recoder.getProgramModelInfo().getClassTypeContainer((ClassType)referencedType_recoder).getFullName());
										
										
										//DataLocation dl = sourceFileRepository.findSourceFile(referencedType_recoder.getFullName());
										//Debug.warning(dl.toString());
									}
									
									
									
								} else {
									Debug.warning("Import references other Type (not ClassType) !");
								}							
							
								/*
								CompilationUnit unit = null;

								// we iterate over all compilation units
								for (int k = 0; k < compilationUnitArray.length; k++) {
									CompilationUnit compUnit2 =
										compilationUnitArray[k];
									TypeDeclarationMutableList declaredTypesList =
										compUnit2.getDeclarations();
									Type[] declaredTypes =
										declaredTypesList.toTypeArray();

									for (int l = 0;
										l < declaredTypes.length;
										l++) {
										if ((referencedType_recoder != null)
											&& (( declaredTypes[l])
												.getFullName()
												.equals(
													referencedType_recoder
														.getFullName()))) {
											//found first declaration of our
											// type
											//stop here
											unit = compUnit2;
											break;
										}
									}

									if (unit != null)
										break;
								}	
								
								if (unit != null) {
									//System.err.println("declared in: " +
									// unit.getName());

									
									File importedFile =
										(File) RecoderToOMMapper
											.getSingleton()
											.getInstanceFromMapper(
											unit);
									if (importedFile != null) {
										file_metamod.addIncludedFile(
											importedFile);
									} else {
										Debug.warning("Imported File was null!");
									}
									
								} else {
									Debug.warning("Imports: Compilation Unit was null!");
								}
*/									
							}

						} else {
							//we import a package here
							PackageReference packageRef =
								import_recoder.getPackageReference();
							//Recoder SourceInfo gives us the PackageType that
							// corresponds to that PackageReference
							recoder
								.abstraction
								.Package referencedPackage_recoder =
								ExtractorFassade.getSourceInfo().getPackage(
									packageRef);
							//get metamod instance of PackageType
							de.fzi.sissy.metamod.Package importedPackage_metamod =
								(de.fzi.sissy.metamod.Package) RecoderToOMMapper
									.getSingleton()
									.getInstanceFromMapper(
									referencedPackage_recoder);
							if (importedPackage_metamod != null) {
								file_metamod.addImportedPackage(
									importedPackage_metamod);
							} else {
								Debug.info("New Imported Package ==> create metamod object!");
								// create new metamod-Package-object
								importedPackage_metamod = 
									PackageTypeBuilder.getSingleton().extractFromRecoder(referencedPackage_recoder);
								file_metamod.addImportedPackage(
									importedPackage_metamod);
							}
						}
					} //for
				} //if
			} //for
		} //if
	} //extractImports
}
