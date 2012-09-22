package de.uka.ipd.sdq.hudson;

import hudson.model.Action;

import java.util.Collections;
import java.util.List;

//Used for publishing of a list of projects (strings). Connects to summary.jelly
public class NotBuiltRepositoriesAction implements Action {
    private final List<String> svnProjects;
    
    
    public NotBuiltRepositoriesAction (final List<String> svnProjects) {
        this.svnProjects = svnProjects;
    }
    
    /**
     * for summary.jelly
     */
    public List<String> getSvnProjectsList() {
        return Collections.unmodifiableList(svnProjects);
    }

    public String getDisplayName() {
        return "Repository action";
    }

    public String getIconFileName() {
        return null;
    }

    public String getUrlName() {
        return "";
    }
}
