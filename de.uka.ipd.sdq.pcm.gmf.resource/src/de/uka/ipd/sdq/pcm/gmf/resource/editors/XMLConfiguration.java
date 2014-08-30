package de.uka.ipd.sdq.pcm.gmf.resource.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

/**
 * An xml configuration.
 */
public class XMLConfiguration extends SourceViewerConfiguration {

    /**
     * The double click strategy.
     */
    private XMLDoubleClickStrategy doubleClickStrategy;

    /**
     * The tag scanner.
     */
    private XMLTagScanner tagScanner;

    /**
     * The xml scanner.
     */
    private XMLScanner scanner;

    /**
     * The color manager.
     */
    private ColorManager colorManager;

    /**
     * Initiates the configuration using a ColorManager.
     * 
     * @param colorManager
     *            a ColorManager
     */
    public XMLConfiguration(ColorManager colorManager) {
        this.colorManager = colorManager;
    }

    /**
     * @param sourceViewer
     *            an ISourcesViewer
     * @return a string with the content types
     */
    public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
        return new String[] { IDocument.DEFAULT_CONTENT_TYPE, XMLPartitionScanner.XML_COMMENT,
                XMLPartitionScanner.XML_TAG };
    }

    /**
     * @param sourceViewer
     *            the source viewer
     * @param contentType
     *            the content type
     * @return the double click strategy
     */
    public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
        if (doubleClickStrategy == null) {
            doubleClickStrategy = new XMLDoubleClickStrategy();
        }
        return doubleClickStrategy;
    }

    /**
     * 
     * @return the xml scanner
     */
    protected XMLScanner getXMLScanner() {
        if (scanner == null) {
            scanner = new XMLScanner(colorManager);
            scanner.setDefaultReturnToken(new Token(
                    new TextAttribute(colorManager.getColor(IXMLColorConstants.DEFAULT))));
        }
        return scanner;
    }

    /**
     * 
     * @return the xml tag scanner
     */
    protected XMLTagScanner getXMLTagScanner() {
        if (tagScanner == null) {
            tagScanner = new XMLTagScanner(colorManager);
            tagScanner
                    .setDefaultReturnToken(new Token(new TextAttribute(colorManager.getColor(IXMLColorConstants.TAG))));
        }
        return tagScanner;
    }

    /**
     * @param sourceViewer
     *            the source viewer
     * @return the presentation reconciler
     */
    public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
        PresentationReconciler reconciler = new PresentationReconciler();

        DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getXMLTagScanner());
        reconciler.setDamager(dr, XMLPartitionScanner.XML_TAG);
        reconciler.setRepairer(dr, XMLPartitionScanner.XML_TAG);

        dr = new DefaultDamagerRepairer(getXMLScanner());
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

        NonRuleBasedDamagerRepairer ndr = new NonRuleBasedDamagerRepairer(new TextAttribute(
                colorManager.getColor(IXMLColorConstants.XML_COMMENT)));
        reconciler.setDamager(ndr, XMLPartitionScanner.XML_COMMENT);
        reconciler.setRepairer(ndr, XMLPartitionScanner.XML_COMMENT);

        return reconciler;
    }

}