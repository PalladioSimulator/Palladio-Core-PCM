
	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.sheet;

/**
 * @generated
 */
public class PalladioComponentModelPropertySection extends org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection implements org.eclipse.ui.views.properties.IPropertySourceProvider{

	/**
 * @generated
 */
	public org.eclipse.ui.views.properties.IPropertySource getPropertySource(Object object) {
		if (object instanceof org.eclipse.ui.views.properties.IPropertySource) {
			return (org.eclipse.ui.views.properties.IPropertySource) object;
		}
		org.eclipse.emf.common.notify.AdapterFactory af = getAdapterFactory(object);
		if (af != null) {
			org.eclipse.emf.edit.provider.IItemPropertySource ips = (org.eclipse.emf.edit.provider.IItemPropertySource) af.adapt(object, org.eclipse.emf.edit.provider.IItemPropertySource.class);
			if (ips != null) {
				return new org.eclipse.emf.edit.ui.provider.PropertySource(object, ips);
			}
		}
		if (object instanceof org.eclipse.core.runtime.IAdaptable) {
			return (org.eclipse.ui.views.properties.IPropertySource) ((org.eclipse.core.runtime.IAdaptable) object).getAdapter(org.eclipse.ui.views.properties.IPropertySource.class);
		}
		return null;
	}



	/**
 * @generated
 */
	protected org.eclipse.ui.views.properties.IPropertySourceProvider getPropertySourceProvider() {
		return this; 
	}


	/**
 * Modify/unwrap selection.
 * @generated
 */
	protected Object transformSelection(Object selected) {
		
		if (selected instanceof org.eclipse.gef.EditPart) {
			Object model = ((org.eclipse.gef.EditPart) selected).getModel();
			return model instanceof org.eclipse.gmf.runtime.notation.View ? ((org.eclipse.gmf.runtime.notation.View) model).getElement() : null;
		}
		if (selected instanceof org.eclipse.gmf.runtime.notation.View) {
			return ((org.eclipse.gmf.runtime.notation.View) selected).getElement();
		}
		if (selected instanceof org.eclipse.core.runtime.IAdaptable) {
			org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) ((org.eclipse.core.runtime.IAdaptable) selected).getAdapter(org.eclipse.gmf.runtime.notation.View.class);
			if (view != null) {
				return view.getElement();
			}
		}
		return selected;
	}


	/**
 * @generated
 */
	public void setInput(org.eclipse.ui.IWorkbenchPart part, org.eclipse.jface.viewers.ISelection selection) {
		if (selection.isEmpty() || false == selection instanceof org.eclipse.jface.viewers.StructuredSelection) {
			super.setInput(part, selection);
			return;
		}
		final org.eclipse.jface.viewers.StructuredSelection structuredSelection = ((org.eclipse.jface.viewers.StructuredSelection) selection);
		java.util.ArrayList transformedSelection = new java.util.ArrayList(structuredSelection.size());
		for (java.util.Iterator it = structuredSelection.iterator();  it.hasNext();) {
			Object r = transformSelection(it.next());
			if (r != null) {
				transformedSelection.add(r);
			}
		}
		super.setInput(part, new org.eclipse.jface.viewers.StructuredSelection(transformedSelection));
	}


	/**
 * @generated
 */
	protected org.eclipse.emf.common.notify.AdapterFactory getAdapterFactory(Object object) {
		if (getEditingDomain() instanceof org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain) {
			return ((org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain) getEditingDomain()).getAdapterFactory();
		}
		org.eclipse.emf.transaction.TransactionalEditingDomain editingDomain = org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(object);
		if (editingDomain != null) {
			return ((org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain) editingDomain).getAdapterFactory();
		}
		return null;
	}



}
