package de.uka.ipd.sdq.pcmbench.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.nature.PalladioProjectNature;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.CategoryAwareItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.CategoryDescriptor;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.GenericCategoryItemProvider;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.ICategoryDescriptions;
import de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware.PalladioCategoryDescriptions;

public class PCMNavigatorLabelProvider implements ILabelProvider {

	private ComposedAdapterFactory adapterFactory;
	private AdapterFactoryLabelProvider labelContentProvider;

	public PCMNavigatorLabelProvider()
	{
		adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new SeffItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		
		AdapterFactory palladioFactory = new PalladioItemProviderAdapterFactory(adapterFactory);
		AdapterFactory decoratorFactory = new CategoryAwareItemProviderAdapterFactory(palladioFactory, new PalladioCategoryDescriptions());
		
		labelContentProvider = new AdapterFactoryLabelProvider(decoratorFactory);
	}
	
	public Image getImage(Object element) {
		if (element instanceof EObject)
		{
			return labelContentProvider.getImage(element);
		}
		return null;
	}

	public String getText(Object element) {
		if (element instanceof LinkedRepositoriesNode)
		{
			return "Linked Repositories";
		}
		return labelContentProvider.getText(element);
	}

	public void addListener(ILabelProviderListener listener) {
		labelContentProvider.addListener(listener);
	}

	public void dispose() {
		labelContentProvider.dispose();
	}

	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	public void removeListener(ILabelProviderListener listener) {
		labelContentProvider.removeListener(listener);
	}

}
