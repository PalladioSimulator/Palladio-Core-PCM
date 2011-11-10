package de.uka.ipd.sdq.edp2.visualization.wizards;

import org.eclipse.jface.wizard.IWizard;

import de.uka.ipd.sdq.edp2.visualization.AbstractAdapter;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;

public interface IAdapterWizard extends IWizard {
	public AbstractAdapter getAdapter();
	public void setSourceFromCaller(AbstractDataSource source, SelectAdapterPage selectAdapterPage);
}
