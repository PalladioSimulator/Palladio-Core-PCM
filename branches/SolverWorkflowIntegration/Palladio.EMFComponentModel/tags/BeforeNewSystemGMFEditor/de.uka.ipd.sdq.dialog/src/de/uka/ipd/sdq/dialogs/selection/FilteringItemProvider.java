/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

/**
 * @author Snowball
 *
 */
public class FilteringItemProvider extends ItemProviderDecorator implements ITreeItemContentProvider {

	private Collection filterList;

	/**
	 * @param adapterFactory
	 */
	public FilteringItemProvider(AdapterFactory adapterFactory, Collection filterList) {
		super(adapterFactory);
		this.filterList = filterList;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getChildren(java.lang.Object)
	 */
	@Override
	public Collection getChildren(Object object) {
		Collection unfilteredResult = null;
		if (object instanceof ResourceSet)
		{
			ArrayList result = new ArrayList();
			ResourceSet rs = (ResourceSet)object;
			for (Resource r : (Collection<Resource>) rs.getResources() ) {
				ITreeItemContentProvider provider = (ITreeItemContentProvider)adapterFactory.adapt((Object)r, ITreeItemContentProvider.class);
				result.addAll(provider.getChildren(r));
			}
			unfilteredResult = result;
		}
		else
		{
			unfilteredResult = ((ITreeItemContentProvider) getDecoratedItemProvider()).getChildren(object);
		}
		ArrayList filteredResult = new ArrayList();
		for (Iterator i = unfilteredResult.iterator(); i.hasNext(); ) {
			Object o = i.next();
			for (Class c : (List<Class>)filterList)
			{
				if (c.isAssignableFrom(o.getClass()))
					filteredResult.add(o);
			}
		}
		return filteredResult;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getElements(java.lang.Object)
	 */
	@Override
	public Collection getElements(Object object) {
		return getChildren(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object object) {
		return this.getChildren(object).size() > 0;
	}
}
