package de.uka.ipd.sdq.cip;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.Package;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.units.UnitsPackage;

/**
 * This class is used as a constant container.
 * 
 * @author Thomas Schuischel
 */
public interface ConstantsContainer {
	
	/** Completion settings*/
	public static final String COMPLETION = "de.uka.ipd.sdq.cip.completion";
	public static final String REVALIDATION = "de.uka.ipd.sdq.cip.revalidate";
	
	/** Extension point values **/
	public static final String ATT_ID			= "id";
	public static final String ATT_NAME			= "name";
	public static final String ATT_QVT_FILE		= "qvt_file";
	public static final String ATT_METAMODEL	= "metamodel";
	public static final String TAG_COMPLETION 	= "completion";
	
	//
	public static final String tracesPartition  = "de.uka.ipd.sdq.simucip.traces";
	public static final String annotationPartition  = "de.uka.ipd.sdq.simucip.annotation";
	public static final String outputPartition  = "de.uka.ipd.sdq.simucip.refinedmodel";
	public static final String direction		= "target";
	
	public static final String tracesFolder 	= "traces";
	public static final String outputFolder 	= "output";
	
	public static final EPackage[] PCM_EPACKAGES = new EPackage[]{
		Package.eINSTANCE,
		SeffPackage.eINSTANCE,
		RepositoryPackage.eINSTANCE,
		ParameterPackage.eINSTANCE,
		UsagemodelPackage.eINSTANCE,
		SystemPackage.eINSTANCE,
		ResourcetypePackage.eINSTANCE,
		ResourceenvironmentPackage.eINSTANCE,
		AllocationPackage.eINSTANCE,
		StoexPackage.eINSTANCE,
		CorePackage.eINSTANCE,
		CompletionsPackage.eINSTANCE,
		IdentifierPackage.eINSTANCE,
		ProbfunctionPackage.eINSTANCE,
		StoexPackage.eINSTANCE,
		UnitsPackage.eINSTANCE,
		EcorePackage.eINSTANCE,
	};

	
}
