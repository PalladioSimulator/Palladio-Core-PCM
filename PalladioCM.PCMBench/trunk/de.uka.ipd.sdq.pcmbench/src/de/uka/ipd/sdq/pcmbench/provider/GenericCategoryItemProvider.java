package de.uka.ipd.sdq.pcmbench.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationWrapper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

// Item provider for category displays - No EMF Model Element is associated to this type of item provider
public class GenericCategoryItemProvider extends ItemProviderAdapter
implements 	IEditingDomainItemProvider,
	IStructuredItemContentProvider,
	ITreeItemContentProvider,
	IItemLabelProvider,
	IItemPropertySource,
	IDisposable,
	Adapter
{
	private CategoryDescriptor descriptor;
	
	public GenericCategoryItemProvider(AdapterFactory adapterFactory, CategoryDescriptor descriptor, EObject parentObject) {
		super(adapterFactory);
		parentObject.eAdapters().add(this);
		this.descriptor = descriptor;
	}

	public Collection getChildren(Object object)
	{
		return super.getChildren(target);
	}
	
	public Object getParent(Object object)
	{
		return target;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getChildrenReferences(java.lang.Object)
	 */
	@Override
	protected Collection getChildrenReferences(Object object) {
		if (childrenReferences == null)
		{
			super.getChildrenReferences(object);
			childrenReferences.add(descriptor.getEReference());
		}
		return childrenReferences;
	}

	public String getText(Object object)
	{
		return descriptor.getLabel();
	}
	
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeatureID(descriptor.getParentClass()) == descriptor.getEReference().getFeatureID()){
			fireNotifyChanged(new NotificationWrapper(this,notification));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#dispose()
	 */
	@Override
	public void dispose() {
		target.eAdapters().remove(this);
		super.dispose();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getNewChildDescriptors(java.lang.Object, org.eclipse.emf.edit.domain.EditingDomain, java.lang.Object)
	 */
	@Override
	public Collection getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {
		IEditingDomainItemProvider itemProvider = 
			(IEditingDomainItemProvider)adapterFactory.adapt((Object)target, IEditingDomainItemProvider.class);
		Collection children = itemProvider.getNewChildDescriptors(target, editingDomain, sibling);
		ArrayList result = new ArrayList();
		for (Iterator i=children.iterator(); i.hasNext(); )
		{
			CommandParameter p = (CommandParameter)i.next();
			if (p.getEReference() != null && p.getEReference() == descriptor.getEReference())
			{
				result.add(p);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getCreateChildDescription(java.lang.Object, java.lang.Object, java.lang.Object, java.util.Collection)
	 */
	@Override
	public String getCreateChildDescription(Object owner, Object feature, Object child, Collection selection) {
		// TODO Auto-generated method stub
		return super.getCreateChildDescription(target, feature, child, selection);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getCreateChildImage(java.lang.Object, java.lang.Object, java.lang.Object, java.util.Collection)
	 */
	@Override
	public Object getCreateChildImage(Object owner, Object feature, Object child, Collection selection) {
		// TODO Auto-generated method stub
		return super.getCreateChildImage(target, feature, child, selection);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getCreateChildResult(java.lang.Object)
	 */
	@Override
	public Collection getCreateChildResult(Object child) {
		// TODO Auto-generated method stub
		return super.getCreateChildResult(child);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getCreateChildText(java.lang.Object, java.lang.Object, java.lang.Object, java.util.Collection)
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection selection) {
		// TODO Auto-generated method stub
		return super.getCreateChildText(target, feature, child, selection);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getCreateChildToolTipText(java.lang.Object, java.lang.Object, java.lang.Object, java.util.Collection)
	 */
	@Override
	public String getCreateChildToolTipText(Object owner, Object feature, Object child, Collection selection) {
		// TODO Auto-generated method stub
		return super.getCreateChildToolTipText(target, feature, child, selection);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#createCommand(java.lang.Object, org.eclipse.emf.edit.domain.EditingDomain, java.lang.Class, org.eclipse.emf.edit.command.CommandParameter)
	 */
	@Override
	public Command createCommand(Object object, EditingDomain domain, Class commandClass, CommandParameter commandParameter) {
		IEditingDomainItemProvider itemProvider = 
			(IEditingDomainItemProvider)adapterFactory.adapt((Object)target, IEditingDomainItemProvider.class);
		return itemProvider.createCommand(target, domain, commandClass, commandParameter);
	}
}
