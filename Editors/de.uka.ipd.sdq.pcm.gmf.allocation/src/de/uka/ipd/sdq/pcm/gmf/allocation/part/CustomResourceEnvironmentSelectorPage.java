package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;

/**
 * This wizard page uses the regular resource selector page, but checks the type of the resource
 * selected by the user to be a ResourceEnvironment.
 */
class ResourceEnvironmentSelectorPage extends ResourceSelectorPage {

    /**
     * The resource environment.
     */
    private ResourceEnvironment myResourceEnvironment;

    /**
     * Creates the resource environment selector page.
     * 
     * @param selectedResourceEnvironment
     *            the resource environment
     */
    protected ResourceEnvironmentSelectorPage(ResourceEnvironment selectedResourceEnvironment) {
        super("Select resource environment", selectedResourceEnvironment);
        setTitle("Diagram resource environment");
        setDescription("Select the resource environment to be used for the diagram.");
        myResourceEnvironment = selectedResourceEnvironment;
    }

    /**
     * Gets the resource environment.
     * 
     * @return the resource environment
     */
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