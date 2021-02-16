package org.palladiosimulator.pcm.stoex.ui.internal;

import org.palladiosimulator.pcm.stoex.ui.dialog.StoExEditDialogFactory;

public class CustomStoexActivator extends StoexActivator {

    private StoExEditDialogFactory editDialogFactory;
    
    public StoExEditDialogFactory getEditDialogFactory() {
        if (editDialogFactory == null) {
            final var injector = getInjector(ORG_PALLADIOSIMULATOR_PCM_STOEX_PCMSTOEX);
            editDialogFactory = injector.getInstance(StoExEditDialogFactory.class);
        }
        return editDialogFactory;
    }
    
}
