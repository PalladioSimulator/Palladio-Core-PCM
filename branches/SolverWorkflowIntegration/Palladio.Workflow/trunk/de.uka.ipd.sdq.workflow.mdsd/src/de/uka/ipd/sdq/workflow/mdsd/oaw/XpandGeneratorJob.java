package de.uka.ipd.sdq.workflow.mdsd.oaw;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.openarchitectureware.type.emf.EmfMetaModel;
import org.openarchitectureware.xpand2.Generator;
import org.openarchitectureware.xpand2.output.JavaBeautifier;
import org.openarchitectureware.xpand2.output.Outlet;
import org.openarchitectureware.xpand2.output.PostProcessor;
import org.openarchitectureware.xpand2.output.XmlBeautifier;

@SuppressWarnings("deprecation")
public class XpandGeneratorJob
extends AbstractOAWWorkflowJobBridge<Generator> {

	private EPackage[] ePackages = null;
	private Outlet[] outlets;
	private String expandExpression;
	
	private String advice;
	private boolean checkProtectedRegions;
	private String fileEncoding;
	private boolean beautifyCode;
	
	public XpandGeneratorJob(HashMap<String, EObject> slotContents, 
			EPackage[] ePackages,
			Outlet[] outlets,
			String expandExpression) {
		
		super(new Generator(),slotContents);
		this.ePackages = ePackages;
		this.outlets = outlets;
		this.expandExpression = expandExpression;
		
		this.advice = null;
		this.checkProtectedRegions = false;
		this.fileEncoding = "ISO-8859-1"; 
		this.beautifyCode = false;
	}

	@Override
	protected void setupOAWJob(Generator generatorJob) {
		generatorJob.setExpand(expandExpression);
		generatorJob.setFileEncoding(fileEncoding);
		
		for (EPackage p : ePackages) {
			generatorJob.addMetaModel(new EmfMetaModel(p));
		}
		
		String prResolver = "";
		for (Outlet o : outlets) {
			generatorJob.addOutlet(o);
			prResolver += o.getPath() + ",";
		}
		prResolver = prResolver.substring(0,prResolver.length()-1);
		
		if (this.checkProtectedRegions) {
			generatorJob.setPrSrcPaths(prResolver);
			generatorJob.setPrExcludes(".svn");
		}
		
		if (this.advice != null) {
			generatorJob.addAdvice("simulation_template_methods");
		}
		
		if (beautifyCode) {
			ArrayList<PostProcessor> beautifier = new ArrayList<PostProcessor>();
			beautifier.add(new JavaBeautifier());
			beautifier.add(new XmlBeautifier());
			generatorJob.setBeautifier(beautifier);
		}
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public boolean isCheckProtectedRegions() {
		return checkProtectedRegions;
	}

	public void setCheckProtectedRegions(boolean checkProtectedRegions) {
		this.checkProtectedRegions = checkProtectedRegions;
	}

	public String getFileEncoding() {
		return fileEncoding;
	}

	public void setFileEncoding(String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}

	public String getExpandExpression() {
		return expandExpression;
	}

	public boolean isBeautifyCode() {
		return beautifyCode;
	}

	public void setBeautifyCode(boolean beautifyCode) {
		this.beautifyCode = beautifyCode;
	}
}
