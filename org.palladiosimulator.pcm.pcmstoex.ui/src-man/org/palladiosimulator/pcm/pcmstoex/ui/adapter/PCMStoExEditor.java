package org.palladiosimulator.pcm.pcmstoex.ui.adapter;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.palladiosimulator.commons.stoex.adapter.StoExEditor;
import org.palladiosimulator.pcm.pcmstoex.adapter.PCMStoExSerializer;
import org.palladiosimulator.pcm.pcmstoex.ui.contentassist.PCMStoExProposalProvider;
import org.palladiosimulator.pcm.pcmstoex.ui.internal.PCMStoExActivator;
import org.palladiosimulator.xtexttools.interfaces.IXSerializer;

import com.google.inject.Injector;

/**
 * Embedded Editor for PCM-specific StoEx.
 * 
 * @author Jonas Heinisch
 *
 */
public class PCMStoExEditor extends StoExEditor {

    /**
     * Sets parent and initial input.
     * 
     * @param parent
     *            parent composite
     * @param string
     *            initial input
     */
    public PCMStoExEditor(Composite parent, String string) {
        super(parent, string);
    }

    @Override
    protected Injector getInjector() {
        PCMStoExActivator activator = PCMStoExActivator.getInstance();
        return activator.getInjector(PCMStoExActivator.ORG_PALLADIOSIMULATOR_PCM_PCMSTOEX);
    }

    @Override
    protected String getFileExtension() {
        return "pcmstoex";
    }

    @Override
    protected IXSerializer getSerializer() {
        return new PCMStoExSerializer();
    }

    /**
     * Gets the ProposalProvider.
     * 
     * @return the {@link PCMStoExProposalProvider}
     */
    public PCMStoExProposalProvider getPCMProposalProvider() {
        PCMStoExProposalProvider p = (PCMStoExProposalProvider) getInjectorInstance().getInstance(IContentProposalProvider.class);
        return p;
    }

}
