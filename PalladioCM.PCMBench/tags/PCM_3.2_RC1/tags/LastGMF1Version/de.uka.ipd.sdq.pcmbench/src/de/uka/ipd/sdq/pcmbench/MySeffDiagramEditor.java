package de.uka.ipd.sdq.pcmbench;
/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */

import org.eclipse.ui.IEditorInput;

import de.uka.ipd.sdq.pcm.gmf.seff.part.SeffDiagramEditor;
import de.uka.ipd.sdq.pcmbench.gmfintegration.FileAndDiagramElementEditorInput;
import de.uka.ipd.sdq.pcmbench.gmfintegration.PcmMultipleDocumentProvider;

/**
 * @generated
 */
public class MySeffDiagramEditor extends SeffDiagramEditor
{
	public static final String EDITING_DOMAIN_ID = "de.uka.ipd.sdq.PCMBench.editingDomain"; //$NON-NLS-1$
	public static final String ID = "de.uka.ipd.sdq.pcm.gmf.seff.part.MySeffDiagramEditorID"; //$NON-NLS-1$

	public MySeffDiagramEditor() {
		super();
	}

	protected String getEditingDomainID() {
		return EDITING_DOMAIN_ID; //$NON-NLS-1$
	}

	@Override
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof FileAndDiagramElementEditorInput)
		{
			setDocumentProvider(new PcmMultipleDocumentProvider());
		}
		else
			super.setDocumentProvider(input);
	}

	//@Override
	//public String getContributorId() {
	//	return "de.uka.ipd.sdq.pcmbench.projectview";
	//}

	
}
