package de.uka.ipd.sdq.pcmbench.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

public class CategoryAwareItemProviderDecorator extends ItemProviderDecorator
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
		IItemProviderDecorator, IDisposable {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#dispose()
	 */
	@Override
	public void dispose() {
		for (Iterator<Collection> childCacheIterator = childCache.values().iterator(); childCacheIterator.hasNext(); )
		{
			for(Iterator<GenericCategoryItemProvider> itemProviderIterator = childCacheIterator.next().iterator(); itemProviderIterator.hasNext();)
			{
				itemProviderIterator.next().dispose();
			}
		}
		super.dispose();
	}

	private ICategoryDescriptions categories;

	private HashMap<EObject, Collection> childCache = new HashMap<EObject, Collection>();

	public CategoryAwareItemProviderDecorator(AdapterFactory adapterFactory,
			ICategoryDescriptions categories) {
		super(adapterFactory);
		this.categories = categories;
	}

	public CategoryAwareItemProviderDecorator(
			CategoryAwareAdapterFactory factory,
			ICategoryDescriptions categories) {
		super(factory);
		this.categories = categories;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getChildren(java.lang.Object)
	 */
	@Override
	public Collection getChildren(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			if (categories.hasCategoriesForObject(eObject)) {
				if (!childCache.containsKey(eObject)) {
					ArrayList children = new ArrayList();
					Collection<CategoryDescriptor> childDescriptors = categories
							.getCategoriesForObject(eObject);
					for (Iterator<CategoryDescriptor> iterator = childDescriptors
							.iterator(); iterator.hasNext();) {
						children.add(new GenericCategoryItemProvider(
								adapterFactory, iterator.next(), eObject));
					}
					childCache.put(eObject, children);
				}
				return childCache.get(eObject);
			}
			else
				return super.getChildren(object);
		} else
			return super.getChildren(object);
	}
}
