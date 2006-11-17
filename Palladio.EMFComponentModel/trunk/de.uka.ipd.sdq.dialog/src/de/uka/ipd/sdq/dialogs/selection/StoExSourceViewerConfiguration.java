/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

/**
 * @author Snowball
 *
 */
public class StoExSourceViewerConfiguration extends SourceViewerConfiguration {

	/**
	 * 
	 */
	public StoExSourceViewerConfiguration() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getPresentationReconciler(org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler= new PresentationReconciler();
		
		DefaultDamagerRepairer dr= new DefaultDamagerRepairer(getKeywordScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	private ITokenScanner getKeywordScanner()
	{
		RuleBasedScanner keywordScanner = new RuleBasedScanner();
		IRule[] rules = new IRule[1];
		rules[0] = createKeywordRule();
		keywordScanner.setRules(rules);
		return keywordScanner;
	}

	private IRule createKeywordRule() {
		IToken keywordToken = new Token (
				new TextAttribute (new Color( null, new RGB(0,0,255) ), null, SWT.BOLD)
				);
		WordRule rule = new WordRule(new IWordDetector() {

			public boolean isWordPart(char c) {
				c = Character.toLowerCase(c);
				return (c >='a' && c <= 'z');
			}

			public boolean isWordStart(char c) {
				c = Character.toLowerCase(c);
				return (c >='a' && c <= 'z');
			}
			
		});
		rule.addWord("DoublePDF", keywordToken);
		rule.addWord("IntPMF", keywordToken);
		rule.addWord("DoublePMF", keywordToken);
		rule.addWord("EnumPMF", keywordToken);
		rule.addWord("BoolPMF", keywordToken);
		return rule;
	}
}
