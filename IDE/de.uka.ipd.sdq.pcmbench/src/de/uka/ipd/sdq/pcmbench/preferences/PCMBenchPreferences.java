package de.uka.ipd.sdq.pcmbench.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * 
 * This preference page is supposed to be the root of all Palladio-related preference pages in the
 * hierarchically organised Eclipse preferences dialogue. For this, each Palladio-related preference
 * page must set its "category" property to the page id corresponding to this preference page.
 * <p>
 * Currently, this preference page does not contribute any configuration possibilities by itself.
 * Ideally, however, this page would host some general preferences that are relevant for more than a
 * single plug-in (if there are any).
 * 
 * @author Philipp Merkle
 * 
 */
public class PCMBenchPreferences extends PreferencePage implements IWorkbenchPreferencePage {

    @Override
    protected Control createContents(Composite parent) {
        Label label = new Label(parent, NONE);
        label.setText("Please expand the tree and use the preference pages of the respective Palladio features.");
        return label;
    }

    @Override
    public void init(IWorkbench workbench) {
        // nothing to do here
    }

}
