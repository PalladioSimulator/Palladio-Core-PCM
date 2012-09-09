package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import de.uka.ipd.sdq.pcm.system.System;

/**
 * This wizard page uses the regular resource selector page, but checks the type of the resource
 * selected by the user to be a System.
 */
class SystemSelectorPage extends ResourceSelectorPage {

    private System mySystem;

    protected SystemSelectorPage(System selectedSystem) {
        super("Select system", selectedSystem);
        setTitle("Diagram system");
        setDescription("Select the system to be used for the diagram.");
        mySystem = selectedSystem;
    }

    protected System getSelectedSystem() {
        return mySystem;
    }

    @Override
    protected boolean validatePage() {
        if (getResolvedObject() == null) {
            setErrorMessage("No system selected");
            return false;
        }

        if (getResolvedObject() instanceof System) {
            mySystem = (System) getResolvedObject();
        } else {
            setErrorMessage("Wrong resource type selected");
            return false;
        }

        setErrorMessage(null);
        return super.validatePage();
    }
}