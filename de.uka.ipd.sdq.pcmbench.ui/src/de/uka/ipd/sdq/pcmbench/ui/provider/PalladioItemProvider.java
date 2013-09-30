/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.ui.provider;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcmbench.ui.PCMBenchUIPlugin;

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
	Adapter,
	CreateChildCommand.Helper {

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
		if (object instanceof PCMRandomVariable) {
			String label = ((PCMRandomVariable)object).getSpecification();
			if (label == null) label = "";

			String containingFeature = ((PCMRandomVariable)object).eContainingFeature().getName();
			containingFeature = containingFeature.split("_")[0];
			containingFeature = containingFeature.substring(0, 1).toUpperCase() + containingFeature.substring(1);
			return containingFeature + ": " + label + " <PCM Random Variable>";
		}
		if (object instanceof AssemblyContext) {
			AssemblyContext ctx = (AssemblyContext)object;
			result = ctx.getEntityName();
			result += ctx.getEncapsulatedComponent__AssemblyContext() == null ? "" : " <Component: "+ctx.getEncapsulatedComponent__AssemblyContext().getEntityName()+">";
		} else if (object instanceof ProcessingResourceSpecification) { 
			ProcessingResourceSpecification spec = (ProcessingResourceSpecification) object;
			result += "Processing Resource ";
			if (spec.getActiveResourceType_ActiveResourceSpecification() != null)
				result += spec.getActiveResourceType_ActiveResourceSpecification().getEntityName() + ": ";
			else
				result += "<unset>: ";
			result += "Cores: ";
			result += spec.getNumberOfReplicas();
			result += " Rate: ";
			if (spec.getProcessingRate_ProcessingResourceSpecification() != null)
				if (spec.getProcessingRate_ProcessingResourceSpecification().getSpecification() != null) {
					result += spec.getProcessingRate_ProcessingResourceSpecification().getSpecification() + " ";
				}
				else {
					result += "N/A ";
				}
			else
				result += "N/A ";
			if (spec.getSchedulingPolicy() != null) {
				result += "Scheduling: "+spec.getSchedulingPolicy().getEntityName();
			} else {
				result += "Scheduling: N/A";
			}
		} else if (object instanceof Entity) {
			result = ((Entity)object).getEntityName();
		} else if (object instanceof ResourceDemandingSEFF){
			ResourceDemandingSEFF seff = (ResourceDemandingSEFF) object;
			result = "SEFF " + (seff.getDescribedService__SEFF() == null ? "" : seff.getDescribedService__SEFF().getEntityName());
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

	public String getCreateChildDescription(Object owner, Object feature,
			Object child, Collection<?> selection) {
		return ((CreateChildCommand.Helper)getDecoratedItemProvider()).getCreateChildDescription(owner, feature, child, selection);
	}

	public Object getCreateChildImage(Object owner, Object feature,
			Object child, Collection<?> selection) {
		return ((CreateChildCommand.Helper)getDecoratedItemProvider()).getCreateChildImage(owner, feature, child, selection);
	}

	public Collection<?> getCreateChildResult(Object child) {
		return ((CreateChildCommand.Helper)getDecoratedItemProvider()).getCreateChildResult(child);
	}

	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		if (selection.size() == 1) {
			if (owner instanceof EObject) {
				if (feature instanceof EReference) {
					String a = palladioConvention(((EReference)feature).getName());
					String b = ((EObject)child).eClass().getName();
					if (a.replaceAll(" ","").toLowerCase().equals(b.toLowerCase())) {
						return PCMBenchUIPlugin.INSTANCE.getString(
								"_UI_CreateChild_palladio_simple", 
								new Object[] {b}, 
								true);
					} else
						return PCMBenchUIPlugin.INSTANCE.getString(
							"_UI_CreateChild_palladio", 
							new Object[] {a,b}, 
							true);
				}
			}
		}
		return ((CreateChildCommand.Helper)getDecoratedItemProvider()).getCreateChildText(owner, feature, child, selection);
	}

	private String palladioConvention(String originalName) {
		if (originalName.indexOf("_") >= 0) {
			originalName = originalName.substring(0, originalName.indexOf("_"));
			if (originalName.length() >= 1) {
				String newOriginalName = Character.toUpperCase(originalName.charAt(0))+""; 
				for (int i=1; i < originalName.length(); i++) {
					if (Character.isUpperCase(originalName.charAt(i))) {
						newOriginalName += " ";
					}
					newOriginalName += originalName.charAt(i);
				}
				originalName = newOriginalName;
			}
		}
		return originalName;
	}

	public String getCreateChildToolTipText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		return ((CreateChildCommand.Helper)getDecoratedItemProvider()).getCreateChildToolTipText(owner, feature, child, selection);
	}

	@Override
	public Command createCommand(Object object, EditingDomain domain,
			Class<? extends Command> commandClass,
			CommandParameter commandParameter) {
		if (commandClass == CreateChildCommand.class)
	    {
	      CommandParameter newChildParameter = (CommandParameter)commandParameter.getValue();
	      return new CreateChildCommand
	          (domain,
	           commandParameter.getEOwner(), 
	           newChildParameter.getEStructuralFeature(), 
	           newChildParameter.getValue(),
	           newChildParameter.getIndex(),
	           commandParameter.getCollection(),
	           this);      
	    }
		return super.createCommand(object, domain, commandClass, commandParameter);
	}
	
	
	
}
