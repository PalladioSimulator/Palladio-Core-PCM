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
package de.fzi.sissy.extractors.java;

/*
 * Created on 06.12.2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

/**
 * @author stammel
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
 

import recoder.CrossReferenceServiceConfiguration;
import recoder.ParserException;
import recoder.io.ClassFileRepository;
import recoder.io.ProjectSettings;
import recoder.io.PropertyNames;
import recoder.io.SourceFileRepository;
import recoder.service.NameInfo;
import recoder.service.SourceInfo;
import de.fzi.sissy.extractors.java.builders.MetamodBuilder;
import de.fzi.sissy.extractors.java.recoder.CustomErrorHandler;
import de.fzi.sissy.extractors.java.recoder.CustomServiceConfiguration;
import de.fzi.sissy.extractors.java.recoder.RecoderProgram;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.util.Debug;

/**
 * @author szulman
 * 
 * Fassade to recoder. Provides methods to get artifacts from the metamodel of
 * goose.
 */
public class ExtractorFassade {

	protected static CrossReferenceServiceConfiguration crossReferenceServiceConfiguration = null;
	protected static CustomServiceConfiguration customServiceConfiguration = null;
	protected static ModelElementRepository modelElementRepository = null;
	protected static ClassFileRepository classFileRepository = null;
	protected static SourceInfo sourceInfo = null;
	protected static SourceFileRepository sourceFileRepository = null;
	protected static NameInfo nameInfo = null;
    private static boolean clone_analyses_active = true;
    private String langVersion = "1.4"; // can be 1.3 or 1.4 or 5.0
    
	/**
	 * This constructor only reads the model without exporting it.
	 * @throws ParserException
	 */
	public ExtractorFassade() throws ParserException {
	    super();
	    ExtractorFassade.modelElementRepository = ModelElementRepository.getWorkingRepository();
//	    initialize(modelElementRepository);
//	    extractAll();
	}

    /**
	 * This constructor only reads the model without exporting it.
	 * @throws ParserException
	 */
	public ExtractorFassade(ModelElementRepository modelElementRepository) throws ParserException {
	    super();
	    ExtractorFassade.modelElementRepository = modelElementRepository;
//	    initialize(modelElementRepository);
//	    extractAll();
	}

    public void setLangVersion(String version) {
        if (version != null)
            langVersion = version;
    }
    
    public void extract() throws ParserException {
        initialize(modelElementRepository);
        extractAll();
            
    }
	
    private void initialize(ModelElementRepository mer) throws ParserException {

	    boolean useCustomServiceConf = true;
		CustomErrorHandler errorhandler;
		
		if (useCustomServiceConf) {
			Debug.info("Using CustomServiceConfiguration");

			customServiceConfiguration = new CustomServiceConfiguration();
			/* mtrifu: Added to handle Java1.4 asserts and Java 5 constructs*/
            ProjectSettings prjSet = customServiceConfiguration.getProjectSettings();
            if (langVersion.equals("5.0")) {
                prjSet.setProperty(PropertyNames.JDK1_4, "true");
                prjSet.setProperty(PropertyNames.JAVA_5, "true");
            }
            else if (langVersion.equals("1.4")) {
                prjSet.setProperty(PropertyNames.JAVA_5, "false");
                prjSet.setProperty(PropertyNames.JDK1_4, "true");
            }
            else if (langVersion.equals("1.3")) {
                prjSet.setProperty(PropertyNames.JAVA_5, "false");
                prjSet.setProperty(PropertyNames.JDK1_4, "false");
            } else {
                Debug.warning("ExtractorFassade::initialize - unknown java language version");
                /*default value is 1.4 for now*/
                prjSet.setProperty(PropertyNames.JAVA_5, "false");
                prjSet.setProperty(PropertyNames.JDK1_4, "true");
            }
			/* mtrifu */
			
			RecoderProgram.setup(customServiceConfiguration, Extractor.class, mer.getFileList());

			errorhandler = new CustomErrorHandler();
			customServiceConfiguration.getProjectSettings().setErrorHandler(errorhandler);

			nameInfo = customServiceConfiguration.getNameInfo();
			sourceInfo = customServiceConfiguration.getSourceInfo();
			sourceFileRepository = customServiceConfiguration.getSourceFileRepository();
			classFileRepository = customServiceConfiguration.getClassFileRepository();
			
		} else {
			crossReferenceServiceConfiguration =
				new CrossReferenceServiceConfiguration();

			/* mtrifu: Added to handle Java1.4 asserts and Java 5 constructs*/
			ProjectSettings prjSet = crossReferenceServiceConfiguration.getProjectSettings();
            if (langVersion.equals("5.0")) {
                prjSet.setProperty(PropertyNames.JDK1_4, "true");
                prjSet.setProperty(PropertyNames.JAVA_5, "true");
            }
            else if (langVersion.equals("1.4")) {
                prjSet.setProperty(PropertyNames.JAVA_5, "false");
                prjSet.setProperty(PropertyNames.JDK1_4, "true");
            }
            else if (langVersion.equals("1.3")) {
                prjSet.setProperty(PropertyNames.JAVA_5, "false");
                prjSet.setProperty(PropertyNames.JDK1_4, "false");
            } else {
                Debug.warning("ExtractorFassade::initialize - unknown java language version");
                /*default value is 1.4 for now*/
                prjSet.setProperty(PropertyNames.JAVA_5, "false");
                prjSet.setProperty(PropertyNames.JDK1_4, "true");
            }
			/* mtrifu */

		    RecoderProgram.setup(crossReferenceServiceConfiguration, Extractor.class, mer.getFileList());

			nameInfo = crossReferenceServiceConfiguration.getNameInfo();
			sourceInfo = crossReferenceServiceConfiguration.getSourceInfo();
			sourceFileRepository = crossReferenceServiceConfiguration.getSourceFileRepository();
			classFileRepository = crossReferenceServiceConfiguration.getClassFileRepository();
		}
	}	

	private void extractAll() throws ParserException {

		Debug.info("extractAll started...");
		
		// (00) Create and Get MetamodBuilder
		MetamodBuilder metamod_builder = MetamodBuilder.getSingleton();
		
		// (00) Setup the MetamodBuilder
		metamod_builder.setup(modelElementRepository, classFileRepository, sourceInfo, sourceFileRepository, nameInfo);
		
		// (01) Primitive Type Classes
		metamod_builder.createPrimitiveTypeClasses();
				
		// (02) Files
		metamod_builder.createFiles();
				
		// (04) Direkte Klassen ermitteln.
		metamod_builder.findDirectClasses();

		// (04) Innere Klassen ermitteln.
		metamod_builder.findInnerClasses();
		
		// (05) Lokale/Annonyme Klassen ermitteln.
		metamod_builder.findLocalClasses();

		metamod_builder.unionClasses();

		// Duplikate in Classes entfernen.
		metamod_builder.eliminateDuplicateClasses();
				
		// (06) Methoden und Constructors ermitteln.
		metamod_builder.findMethodsConstructorsAndFields();

		// (07) Classes
		metamod_builder.createClasses();
		metamod_builder.establishInnerClassRelation();
		
		// (09) Fields
		metamod_builder.createFields();

		// (09z) Methoden/Constructor separieren.
		metamod_builder.separateConstructorsAndMethods();

		// (10) Methods
		metamod_builder.createMethods();

		// (11) Constructors
		metamod_builder.createConstructors();

		// (11z) Methoden/Constructors zusammenf�hren.
		metamod_builder.reuniteConstructorsAndMethods();

		metamod_builder.findAndCreateInitializers();

		// (12) Local Class - Relation
		metamod_builder.establishLocalClassRelation();


		// SuperClass-Relation with InheritanceTypeAccess
		metamod_builder.establishDirectSuperclassRelation();


		// (13) Accesses
		//System.exit(0);
		metamod_builder.findAndCreateAccesses();
		
		// (14) Override ResultStatus of Methods
		metamod_builder.setupOverrideStatusOfMethods();

		// (03) Packages
		metamod_builder.establishInnerPackageRelation();


		// TODO for testing with StatementViewer
		//metamod_builder.createStatementViewer();

		Debug.info("Finished extracting");		
	}

	/**
	 * @return
	 */
	public static NameInfo getNameInfo() {
		return nameInfo;
	}

	/**
	 * @return
	 */
	public static SourceFileRepository getSourceFileRepository() {
		return sourceFileRepository;
	}

	/**
	 * @return
	 */
	public static SourceInfo getSourceInfo() {
		return sourceInfo;
	}

	/**
	 * @param info
	 */
	public static void setNameInfo(NameInfo info) {
		nameInfo = info;
	}

	/**
	 * @param repository
	 */
	public static void setSourceFileRepository(SourceFileRepository repository) {
		sourceFileRepository = repository;
	}

	/**
	 * @param info
	 */
	public static void setSourceInfo(SourceInfo info) {
		sourceInfo = info;
	}

	/**
	 * @return
	 */
	public static ClassFileRepository getClassFileRepository() {
		return classFileRepository;
	}

	/**
	 * @param repository
	 */
	public static void setClassFileRepository(ClassFileRepository repository) {
		classFileRepository = repository;
	}

	/**
	 * @return
	 */
	public static CrossReferenceServiceConfiguration getCrossReferenceServiceConfiguration() {
		return crossReferenceServiceConfiguration;
	}

	/**
	 * @param configuration
	 */
	public static void setCrossReferenceServiceConfiguration(CrossReferenceServiceConfiguration configuration) {
		crossReferenceServiceConfiguration = configuration;
	}

	/**
	 * @return Returns the modelElementRepository.
	 */
	public static ModelElementRepository getModelElementRepository() {
		return modelElementRepository;
	}

    public static void activateCloneAnalyses(boolean activate) {
        clone_analyses_active = activate;
    }
    
}
