/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.swt.graphics.Image;

/**
 * @author Steffen Becker
 *
 */
public class StoExTemplateCompletionProcessor extends
		TemplateCompletionProcessor {

	public static final String STO_EX_CONTEXT_TYPE = "StoExContextType";

	/**
	 * 
	 */
	public StoExTemplateCompletionProcessor() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#getContextType(org.eclipse.jface.text.ITextViewer, org.eclipse.jface.text.IRegion)
	 */
	@Override
	protected TemplateContextType getContextType(ITextViewer viewer,
			IRegion region) {
		return new TemplateContextType(STO_EX_CONTEXT_TYPE);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#getImage(org.eclipse.jface.text.templates.Template)
	 */
	@Override
	protected Image getImage(Template template) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.templates.TemplateCompletionProcessor#getTemplates(java.lang.String)
	 */
	@Override
	protected Template[] getTemplates(String contextTypeId) {
		Template t = new Template("IntPMF","Creates an integer random variable",
				STO_EX_CONTEXT_TYPE,
				"IntPMF(unit=\"${unit}\")[(x;p)]",false);
		Template t2 = new Template("BoolPMF","Creates an boolean random variable",
				STO_EX_CONTEXT_TYPE,
				"BoolPMF(unit=\"bool\")[(true;p)(false;p)]",false);

		return new Template[]{t,t2};
	}
}
