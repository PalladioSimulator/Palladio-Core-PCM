package de.uka.ipd.sdq.pcmbench.navigator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.navigator.CommonDragAdapterAssistant;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

public class DragAssistant extends CommonDragAdapterAssistant {

	public DragAssistant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transfer[] getSupportedTransferTypes() {
		return new Transfer[]{};
	}

	@Override
	public boolean setDragData(DragSourceEvent anEvent,
			IStructuredSelection selection) {
		return true;
	}

}
