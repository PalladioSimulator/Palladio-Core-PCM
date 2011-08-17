package de.uka.ipd.sdq.cip;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;

import QVTBase.QVTBasePackage;
import QVTRelation.QVTRelationPackage;
import QVTTemplate.QVTTemplatePackage;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage;

/**
 *  @author Thomas Schuischel
 *
 */
public class ConstantsContainer {
	
	// Completion Constants
	public static final String COMPLETION_DEFAULT_PROJECT_ID = "de.uka.ipd.sdq.cip.generated";
	
	public static final String MODELFOLDER = "model";
	public static final String TRACESFOLDER = "traces";
	public static final String HOTTRACESFOLDER = "traces-hot";
	public static final String LOGFOLDER = "logs";	
	
	// Standard QVT catagories
	public static final String QVTO_Category = "QVTO";
	public static final String QVTR_Category = "QVTR";
	public static final String MARK_COMPLETION = "MarkCompletion";
	public static final String PLAIN_COMPLETION = "PlainCompletion";
	public static final String HOT_COMPLETION = "HOTCompletion";
	
	// CipConfigTab
	public static final String COMPLETION_PROJECT_ID = "completion.plugin.id";
	public static final String COMPLETION_DELETE_PLUGIN = "completion.plugin.delete";
	public static final String COMPLETION_QVT_VERBOSE_LOGGING = "completion.qvt.verbose.logging";
	
	//CipCompletionTab
	public static final String COMPLETION_CONFIG = "completion.config";
	
	
	//Extension Point
	public static final String COMPLETION_EXTENSION_POINT_ID = "Completion";

	public static final Object NODE_COMPLETION = "Completion";
	public static final String ATT_COMPLETION_ID = "id";
	public static final String ATT_COMPLETION_NAME = "name";
	public static final String ATT_COMPLETION_IMAGE = "image";
	public static final String ATT_COMPLETION_FEATUREMODEL = "featuremodel";
	public static final String ATT_COMPLETION_METAMODEL = "metamodel";
	public static final String ATT_COMPLETION_QVTSCRIPT = "qvtscript";
	
	
	public static final String NODE_DESCRIPTION = "Description";
	
	public static final String NODE_CATEGORY = "Category";
	
	public static final String HOT_PARTITION_ID = "de.uka.ipd.sdq.cip.hotpartition";
	public static final String FEATURECONFIG2QVT_FILE = "platform:/plugin/de.uka.ipd.sdq.cip/completion/FeatureConfig2QVT.qvt";
	public static final EPackage[] HOT_METAMODELS = {
		QVTBasePackage.eINSTANCE,		// "http://schema.omg.org/spec/QVT/1.0/qvtbase.xml",
		QVTRelationPackage.eINSTANCE, 	// "http://schema.omg.org/spec/QVT/1.0/qvtrelation.xml",
		QVTTemplatePackage.eINSTANCE,	// "http://schema.omg.org/spec/QVT/1.0/qvttemplate.xml",
		EcorePackage.eINSTANCE,			// "http://www.eclipse.org/emf/2002/Ecore",
		//OCL,					// "http://www.eclipse.org/ocl/1.1.0/OCL",
		TypesPackage.eINSTANCE,			//"http://www.eclipse.org/ocl/1.1.0/OCL/Types",
		UtilitiesPackage.eINSTANCE,		// "http://www.eclipse.org/ocl/1.1.0/OCL/Utilities",
		ExpressionsPackage.eINSTANCE,	// "http://www.eclipse.org/ocl/1.1.0/OCL/Expressions",
		//"http://www.eclipse.org/ocl/1.1.0/OCLEcore",
		EcorePackage.eINSTANCE,			// "http://www.eclipse.org/ocl/1.1.0/Ecore",
		featureconfigPackage.eINSTANCE, // "http://sdq.ipd.uka.de/FeatureConfig/2.0"
		completionfeaturemodelPackage.eINSTANCE, // "http://sdq.ipd.kit.edu/CompletionFeatureModel/1.0"
	};
	
	
}
