package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.openarchitectureware.type.emf.EmfMetaModel;
import org.openarchitectureware.xpand2.Generator;
import org.openarchitectureware.xpand2.output.Outlet;

public class XpandGeneratorJob
extends AbstractOAWWorkflowJobBridge<Generator> {

	private EPackage[] ePackages = null;
	private Outlet[] outlets;
	private String expandExpression;
	
	public XpandGeneratorJob(HashMap<String, EObject> slotContents, 
			EPackage[] ePackages,
			Outlet[] outlets,
			String expandExpression) {
		super(new Generator(),slotContents);
		this.ePackages = ePackages;
		this.outlets = outlets;
		this.expandExpression = expandExpression;
	}

	@Override
	protected void setupOAWJob(Generator generatorJob) {
		generatorJob.setPrExcludes(".svn");
		generatorJob.setExpand(expandExpression);
		generatorJob.setFileEncoding("ISO-8859-1");
		for (EPackage p : ePackages) {
			generatorJob.addMetaModel(new EmfMetaModel(p));
		}
		String prResolver = "";
		for (Outlet o : outlets) {
			generatorJob.addOutlet(o);
			prResolver += o.getPath() + ",";
		}
		prResolver = prResolver.substring(0,prResolver.length()-1);
		generatorJob.setPrSrcPaths(prResolver);
		
		generatorJob.addAdvice("simulation_template_methods");
	}
}
