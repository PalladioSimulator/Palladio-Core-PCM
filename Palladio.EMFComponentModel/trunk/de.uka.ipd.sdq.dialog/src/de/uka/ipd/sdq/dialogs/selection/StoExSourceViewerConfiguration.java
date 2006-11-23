/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.ContentFormatter;
import org.eclipse.jface.text.formatter.IContentFormatter;
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
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsLexer;

/**
 * @author Snowball
 * 
 */
public class StoExSourceViewerConfiguration extends SourceViewerConfiguration {

	private IAnnotationModel annotationModel;

	/**
	 * 
	 */
	public StoExSourceViewerConfiguration(IAnnotationModel annotationModel) {
		this.annotationModel = annotationModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getPresentationReconciler(org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(
				getKeywordScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new AnnotationHover(annotationModel);
	}

	private ITokenScanner getKeywordScanner() {
		// RuleBasedScanner keywordScanner = new RuleBasedScanner();
		// IRule[] rules = new IRule[1];
		// rules[0] = createKeywordRule();
		// keywordScanner.setRules(rules);
		// return keywordScanner;
		return new ANTLRTokenScannerAdapter(StochasticExpressionsLexer.class);
	}

	private IRule createKeywordRule() {
		IToken keywordToken = new Token(new TextAttribute(new Color(null,
				new RGB(0, 0, 255)), null, SWT.BOLD));
		WordRule rule = new WordRule(new IWordDetector() {

			public boolean isWordPart(char c) {
				c = Character.toLowerCase(c);
				return (c >= 'a' && c <= 'z');
			}

			public boolean isWordStart(char c) {
				c = Character.toLowerCase(c);
				return (c >= 'a' && c <= 'z');
			}

		});
		rule.addWord("DoublePDF", keywordToken);
		rule.addWord("IntPMF", keywordToken);
		rule.addWord("DoublePMF", keywordToken);
		rule.addWord("EnumPMF", keywordToken);
		rule.addWord("BoolPMF", keywordToken);
		return rule;
	}

	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {

		ContentAssistant assistant = new ContentAssistant();
		assistant.setContentAssistProcessor(new StoExCompletionProcessor(),
				IDocument.DEFAULT_CONTENT_TYPE);
		assistant.setAutoActivationDelay(1);
		assistant.enableAutoActivation(true);

		return assistant;
	}
}

// annotation hover manager
class AnnotationHover implements IAnnotationHover, ITextHover {
	private IAnnotationModel fAnnotationModel;

	public AnnotationHover(IAnnotationModel annotationModel) {
		this.fAnnotationModel = annotationModel;
	}

	public String getHoverInfo(ISourceViewer sourceViewer, int lineNumber) {
		Iterator ite = fAnnotationModel.getAnnotationIterator();

		ArrayList all = new ArrayList();

		while (ite.hasNext()) {
			Annotation a = (Annotation) ite.next();
			if (a instanceof Annotation) {
				all.add(((Annotation) a).getText());
			}
		}

		StringBuffer total = new StringBuffer();
		for (int x = 0; x < all.size(); x++) {
			String str = (String) all.get(x);
			total.append(" " + str + (x == (all.size() - 1) ? "" : "\n"));
		}

		return total.toString();
	}

	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		return null;
	}

	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		return null;
	}
}