package org.palladiosimulator.pcm.stoex.ui.dialog.impl;

import org.eclipse.swt.widgets.Shell;
import org.palladiosimulator.pcm.stoex.ui.dialog.StoExEditDialog;
import org.palladiosimulator.pcm.stoex.ui.dialog.StoExEditDialogFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class StoExEditDialogFactoryImpl implements StoExEditDialogFactory {

    @Inject
    private Injector injector;

    @Override
    public StoExEditDialog create(Shell parentShell, TypeEnum expectedType) {
        var dialog = new StoExEditDialogImpl(parentShell, expectedType);
        injector.injectMembers(dialog);
        return dialog;
    }

}
