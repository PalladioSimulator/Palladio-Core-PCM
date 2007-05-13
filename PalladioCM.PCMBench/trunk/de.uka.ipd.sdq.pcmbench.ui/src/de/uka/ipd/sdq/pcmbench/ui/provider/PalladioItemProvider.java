/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.ui.provider;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * @author Snowball
 * Palladio Item Provider which renders Labels for elements of the Palladio Component Model
 *
 */
public class PalladioItemProvider extends ItemProviderDecorator implements
	IEditingDomainItemProvider,	
	IStructuredItemContentProvider,	
	ITreeItemContentProvider,	
	IItemLabelProvider,	
	IItemPropertySource,
	Adapter {

	/**
	 * Default constructor
	 * @param adapterFactory Decorated adapter factory
	 */
	public PalladioItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getText(java.lang.Object)
	 * A label getter which is aware of the PCM
	 */
	@Override
	public String getText(Object object) {
		String result = "";
		if (object instanceof AssemblyContext) {
			AssemblyContext ctx = (AssemblyContext)object;
			result = ctx.getEntityName();
			result += ctx.getEncapsulatedComponent_ChildComponentContext() == null ? "" : " <Component: "+ctx.getEncapsulatedComponent_ChildComponentContext().getEntityName()+">";
		} else if (object instanceof Entity) {
			result = ((Entity)object).getEntityName();
		} else if (object instanceof ResourceDemandingSEFF){
			ResourceDemandingSEFF seff = (ResourceDemandingSEFF) object;
			result = "SEFF " + (seff.getDescribedService__SEFF() == null ? "" : seff.getDescribedService__SEFF().getServiceName());
		} else {
			if (object instanceof EObject && new RepositoryPrinter().doSwitch((EObject)object)!=null)
				result = (String) new RepositoryPrinter().doSwitch((EObject)object);
			else
				result = super.getText(object); 
		}
		if (object instanceof EObject)
		{
			result += " <"+((EObject)object).eClass().getName()+"> ";
		}
		if (object instanceof Identifier)
		{
			result += " [ID: " + ((Identifier)object).getId() + "]";
		}
		return result; 
	}

	public Notifier getTarget() {
		return ((Adapter)getDecoratedItemProvider()).getTarget();
	}

	public void setTarget(Notifier newTarget) {
		((Adapter)getDecoratedItemProvider()).setTarget(newTarget);
	}

	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		// TODO Auto-generated method stub
		return super.getPropertyDescriptors(object);
	}
	
}
