/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.util.ArrayList;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import de.uka.ipd.sdq.pcm.repository.Parameter;

/**
 * @author Snowball
 *
 */
public class StoExCompletionProcessor implements IContentAssistProcessor {

	private String[] defaultCharacterisations = new String[]{"INNER","BYTESIZE","NUMBER_OF_ELEMENTS","STRUCTURE","VALUE","TYPE"};
	private String[] defaultCharacterisationsDescriptions = new String[]{
			"Characterise an inner element of a collection datatype",
			"Characterise the memory footprint in bytes",
			"Characterise the number of elements of a collection datatype",
			"Characterise the structure of a datastructure",
			"Characterise the actual value of a variable",
			"Characterise the type of a variable"};
	private String templatePrefixes = "+-*/%";
	
	private StoExTemplateCompletionProcessor templateProcessor;
	private Parameter[] context = null;
	/**
	 * 
	 */
	public StoExCompletionProcessor(Parameter[] context) {
		templateProcessor = new StoExTemplateCompletionProcessor();
		this.context = context;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
		ArrayList<ICompletionProposal> resultList=new ArrayList<ICompletionProposal>();
		String currentText = viewer.getDocument().get();
		computeCharacterisationCompletions(offset, resultList, currentText);
		computeContextCompletions(offset, resultList, currentText);
		computeTemplateCompletions(viewer, offset, resultList, currentText);
		return resultList.toArray(new ICompletionProposal[]{});
	}

	private void computeTemplateCompletions(ITextViewer viewer, int offset, ArrayList<ICompletionProposal> resultList, String currentText) {
		if (templatePrefixes.indexOf(currentText.charAt(offset-1)) >= 0) {
			for (ICompletionProposal p : templateProcessor.computeCompletionProposals(viewer, offset)){
				resultList.add(p);
			}
		}
	}

	private void computeCharacterisationCompletions(int offset, ArrayList<ICompletionProposal> resultList, String currentText) {
		int lastDotIndex = currentText.substring(0,offset).lastIndexOf(".");
		String typedFragment = currentText.substring(lastDotIndex+1, offset);
		for (int i= 0; i < defaultCharacterisations.length; i++) {
			if (defaultCharacterisations[i].startsWith(typedFragment)){
				IContextInformation info= new ContextInformation(defaultCharacterisations[i], defaultCharacterisationsDescriptions[i]); //$NON-NLS-1$
				resultList.add(new CompletionProposal(
						defaultCharacterisations[i], 
						lastDotIndex+1, 
						typedFragment.length(), 
						defaultCharacterisations[i].length(), 
						null, 
						defaultCharacterisations[i] + " - "+ defaultCharacterisationsDescriptions[i], 
						info, 
						defaultCharacterisationsDescriptions[i])); //$NON-NLS-1$
			}
		}
	}

	private void computeContextCompletions(int offset, ArrayList<ICompletionProposal> resultList, String currentText) {
		int lastIndex = -1;
		String templatePrefixesAndWS = templatePrefixes + " ";
		for (int i=0; i<templatePrefixesAndWS.length(); i++) {
			int newLastIndex = currentText.substring(0,offset).lastIndexOf(templatePrefixesAndWS.charAt(i));
			if (newLastIndex > lastIndex)
				lastIndex = newLastIndex;
		}
		String typedFragment = currentText.substring(lastIndex+1, offset).trim();
		System.out.println(typedFragment);
		for (int i= 0; i < context.length; i++) {
			if (context[i].getParameterName().startsWith(typedFragment) || typedFragment.equals("")){
				IContextInformation info= new ContextInformation(context[i].getParameterName(), context[i].getParameterName()); //$NON-NLS-1$
				resultList.add(new CompletionProposal(
						context[i].getParameterName(), 
						lastIndex+1, 
						typedFragment.length(), 
						context[i].getParameterName().length(), 
						null, 
						context[i].getParameterName() + " - Signature Parameter " + context[i].getParameterName(), 
						info, 
						context[i].getParameterName())); //$NON-NLS-1$
			}
		}
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
		ArrayList<Character> result = new ArrayList<Character>();
		for (int i=0; i < context.length; i++)
			result.add(context[i].getParameterName().charAt(0));
		for (int i=0; i < templatePrefixes.length(); i++)
			result.add(templatePrefixes.charAt(0));
		result.add('.');
		char[] realResult = new char[result.size()];
		for (int i=0; i < result.size(); i++)
			realResult[i] = result.get(i);
		return realResult;
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
