package de.uka.ipd.sdq.pcm.gmf.resource.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

/**
 * An xml document provider.
 */
public class XMLDocumentProvider extends FileDocumentProvider {

    /**
     * @param element
     *            an Object
     * @throws CoreException
     *             a core exception
     * @return an IDocument
     */
    protected IDocument createDocument(Object element) throws CoreException {
        IDocument document = super.createDocument(element);
        if (document != null) {
            IDocumentPartitioner partitioner = new FastPartitioner(new XMLPartitionScanner(), new String[] {
                    XMLPartitionScanner.XML_TAG, XMLPartitionScanner.XML_COMMENT });
            partitioner.connect(document);
            document.setDocumentPartitioner(partitioner);
        }
        return document;
    }
}