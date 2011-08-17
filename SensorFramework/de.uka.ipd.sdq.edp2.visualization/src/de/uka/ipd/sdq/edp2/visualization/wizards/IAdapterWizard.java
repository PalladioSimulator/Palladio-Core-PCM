package de.uka.ipd.sdq.edp2.visualization.wizards;

import org.eclipse.jface.wizard.IWizard;

import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;

public interface IAdapterWizard extends IWizard {
	public IAdapter getAdapter();
	public void setSourceFromCaller(IDataSource source, SelectAdapterPage selectAdapterPage);
}
