package de.uka.ipd.sdq.edp2.visualization.wizards;

import org.eclipse.jface.wizard.IWizard;

import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;

public interface IFilterWizard extends IWizard {
	public IFilter getFilter();
	public void setSourceFromCaller(IDataSource source, SelectFilterPage selectFilterPage);
}
