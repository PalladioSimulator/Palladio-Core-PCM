package de.uka.ipd.sdq.workflow.mdsd.oaw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xpand2.output.XmlBeautifier;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

//TODO Is this annotation needed?
/**
 * A job to run oAWs Xpand Generator on models in order to generate code (i.e., perform a model-2-text transformation)
 * 
 * @author Steffen Becker
 */
@SuppressWarnings("deprecation")
public class XpandGeneratorJob
extends AbstractOAWWorkflowJobBridge<Generator> {

	private EPackage[] ePackages = null;
	private Outlet[] outlets;
	private String expandExpression;
	
	private List<String> advices = new ArrayList<String>();
	private boolean checkProtectedRegions;
	private String fileEncoding;
	private boolean beautifyCode;
	
	public XpandGeneratorJob(HashMap<String, Object> slotContents, 
			EPackage[] ePackages,
			Outlet[] outlets,
			String expandExpression) {
		
		super(new Generator(),slotContents);
		
		this.ePackages = ePackages;
		this.outlets = outlets;
		this.expandExpression = expandExpression;
		
		this.checkProtectedRegions = false;
		this.fileEncoding = "ISO-8859-1"; 
		this.beautifyCode = false;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.mdsd.oaw.AbstractOAWWorkflowJobBridge#setupOAWJob(org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2)
	 */
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
		
		for (String advice : this.advices) {
			generatorJob.addAdvice(advice);
		}
		
		if (beautifyCode) {
			ArrayList<PostProcessor> beautifier = new ArrayList<PostProcessor>();
			beautifier.add(new JavaBeautifier());
			beautifier.add(new XmlBeautifier());
			generatorJob.setBeautifier(beautifier);
		}
	}

	public List<String> getAdvices() {
		return this.advices;
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
