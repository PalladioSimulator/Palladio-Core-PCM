package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * This wizard page uses the regular resource selector page, but checks the type of the resource
 * selected by the user to be a ResourceEnvironment.
 */
class ResourceEnvironmentSelectorPage extends ResourceSelectorPage {

    private ResourceEnvironment myResourceEnvironment;

    protected ResourceEnvironmentSelectorPage(ResourceEnvironment selectedResourceEnvironment) {
        super("Select resource environment", selectedResourceEnvironment);
        setTitle("Diagram resource environment");
        setDescription("Select the resource environment to be used for the diagram.");
        myResourceEnvironment = selectedResourceEnvironment;
    }

    protected ResourceEnvironment getSelectedResourceEnvironment() {
        return myResourceEnvironment;
    }

    @Override
    protected boolean validatePage() {
        if (getResolvedObject() == null) {
            setErrorMessage("No resource environment selected");
            return false;
        }

        if (getResolvedObject() instanceof ResourceEnvironment) {
            myResourceEnvironment = (ResourceEnvironment) getResolvedObject();
        } else {
            setErrorMessage("Wrong resource type selected");
            return false;
        }

        setErrorMessage(null);
        return super.validatePage();
    }
}