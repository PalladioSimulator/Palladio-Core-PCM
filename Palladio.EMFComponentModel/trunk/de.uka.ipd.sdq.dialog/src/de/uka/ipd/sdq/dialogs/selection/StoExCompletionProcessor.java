/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;

/**
 * @author Snowball
 *
 */
public class StoExCompletionProcessor implements IContentAssistProcessor {

	private String[] defaultCharacterisations = new String[]{"INNER","BYTESIZE","NUMBER_OF_ELEMENTS","STRUCTURE","VALUE","TYPE"};
	private StoExTemplateCompletionProcessor templateProcessor;
	/**
	 * 
	 */
	public StoExCompletionProcessor() {
		templateProcessor = new StoExTemplateCompletionProcessor();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
		ArrayList<ICompletionProposal> resultList=new ArrayList<ICompletionProposal>();
		for (int i= 0; i < defaultCharacterisations.length; i++) {
			IContextInformation info= new ContextInformation(defaultCharacterisations[i], defaultCharacterisations[i]); //$NON-NLS-1$
			resultList.add(new CompletionProposal(
					defaultCharacterisations[i], 
					offset, 
					0, 
					defaultCharacterisations[i].length(), 
					null, 
					defaultCharacterisations[i], 
					info, 
					defaultCharacterisations[i])); //$NON-NLS-1$
		}
		for (ICompletionProposal p : templateProcessor.computeCompletionProposals(viewer, offset)){
			resultList.add(p);
		}
		return resultList.toArray(new ICompletionProposal[]{});
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer, int)
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] {'.'};
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 */
	public String getErrorMessage() {
		return "No proposals available";
	}
}
