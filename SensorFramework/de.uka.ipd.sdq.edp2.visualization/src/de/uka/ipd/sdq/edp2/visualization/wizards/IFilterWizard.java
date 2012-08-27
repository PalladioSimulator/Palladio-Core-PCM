package de.uka.ipd.sdq.edp2.visualization.wizards;

import org.eclipse.jface.wizard.IWizard;

import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.AbstractFilter;

public interface IFilterWizard extends IWizard {
	public AbstractFilter getFilter();
	public void setSourceFromCaller(AbstractDataSource source, SelectFilterPage selectFilterPage);
}
