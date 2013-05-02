/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.sheet;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;
import de.uka.ipd.sdq.pcmbench.propertytabs.PalladioAdapterFactoryContentProvider;

/**
 * @generated
 */
public class PalladioComponentModelPropertySection extends AdvancedPropertySection implements IPropertySourceProvider {

    /**
     * Gets the property source.
     * 
     * @param object
     *            the object
     * @return the property source
     * @generated not
     */
    public IPropertySource getPropertySource(Object object) {
        if (object instanceof IPropertySource) {
            return (IPropertySource) object;
        }
        AdapterFactory af = getAdapterFactory(object);
        if (af != null) {
            return new PalladioAdapterFactoryContentProvider(af).getPropertySource(object);
        }
        if (object instanceof IAdaptable) {
            return (IPropertySource) ((IAdaptable) object).getAdapter(IPropertySource.class);
        }
        return null;
    }

    /**
     * @generated
     */
    protected IPropertySourceProvider getPropertySourceProvider() {
        return this;
    }

    /**
     * @generated
     */
    protected Object transformSelection(Object selected) {

        if (selected instanceof EditPart) {
            Object model = ((EditPart) selected).getModel();
            return model instanceof View ? ((View) model).getElement() : null;
        }
        if (selected instanceof View) {
            return ((View) selected).getElement();
        }
        if (selected instanceof IAdaptable) {
            View view = (View) ((IAdaptable) selected).getAdapter(View.class);
            if (view != null) {
                return view.getElement();
            }
        }
        return selected;
    }

    /**
     * @generated
     */
    public void setInput(IWorkbenchPart part, ISelection selection) {
        if (selection.isEmpty() || false == selection instanceof StructuredSelection) {
            super.setInput(part, selection);
            return;
        }
        final StructuredSelection structuredSelection = ((StructuredSelection) selection);
        ArrayList transformedSelection = new ArrayList(structuredSelection.size());
        for (Iterator it = structuredSelection.iterator(); it.hasNext();) {
            Object r = transformSelection(it.next());
            if (r != null) {
                transformedSelection.add(r);
            }
        }
        super.setInput(part, new StructuredSelection(transformedSelection));
    }

    /**
     * Gets the adapter factory.
     * 
     * @param object
     *            the object
     * @return the adapter factory
     * @generated not
     */
    protected AdapterFactory getAdapterFactory(Object object) {
        return PalladioComponentModelSeffDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory();
        // if (getEditingDomain() instanceof AdapterFactoryEditingDomain) {
        // return ((AdapterFactoryEditingDomain) getEditingDomain())
        // .getAdapterFactory();
        // }
        // TransactionalEditingDomain editingDomain = TransactionUtil
        // .getEditingDomain(object);
        // if (editingDomain != null) {
        // return ((AdapterFactoryEditingDomain) editingDomain)
        // .getAdapterFactory();
        // }
        // return null;
    }

}
