/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.policies;

import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.RepositoryCanonicalEditPolicy;

/**
 * A custom Repository canoncial EditPolicy.
 */
public class CustomRepositoryCanonicalEditPolicy extends RepositoryCanonicalEditPolicy {

    // To fix GMF bug #189589:
    @Override
    protected boolean shouldDeleteView(View view) {
        return view.getEAnnotation("Shortcut") == null;
    }

}
