package de.uka.ipd.sdq.pcm.dialogs.selection;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.dialogs.selection.FilteredItemsAdapterFactory;
import de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog;
import de.uka.ipd.sdq.pcm.allocation.provider.AllocationItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.core.composition.provider.CompositionItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.core.provider.CoreItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.parameter.provider.ParameterItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.provider.ResourceenvironmentItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.resourcetype.provider.ResourcetypeItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.system.provider.SystemItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.subsystem.provider.SubsystemItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.usagemodel.provider.UsagemodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * @author Snowball
 * 
 */
public class PalladioSelectEObjectDialog extends SelectEObjectDialog {

    private Object input;
    private AdapterFactoryContentProvider contentProvider;

    /**
     * Creates a selection dialog
     * 
     * @param parent
     *            Shell of active workbench window
     * @param filterList
     *            Objects to show (positive filter). Also include respective super types here
     * @param additionalChildReferences
     *            Usually this should be the EReference which should be set
     * @param input
     *            ResourceSet or object of which resource set should be taken
     */
    public PalladioSelectEObjectDialog(Shell parent, Collection<Object> filterList,
            Collection<EReference> additionalChildReferences, Object input) {
        super(parent);
        this.input = input;
        create();
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new SeffItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new SystemItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new AllocationItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new UsagemodelItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ResourceenvironmentItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ParameterItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ResourcetypeItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new CoreItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new CompositionItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new SubsystemItemProviderAdapterFactory());

        contentProvider = new AdapterFactoryContentProvider(new FilteredItemsAdapterFactory(adapterFactory, filterList,
                additionalChildReferences));
        setViewerContentProvider(contentProvider);

        setViewerLabelProvider(new AdapterFactoryLabelProvider(new PalladioItemProviderAdapterFactory(adapterFactory)));
        setViewerInput(input);
        setInputDialogResourceName(filterList);
    }

    public PalladioSelectEObjectDialog(Shell parent, Collection<Object> filterList, Object input) {
        this(parent, filterList, new ArrayList<EReference>(), input);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog#setResourceName(java.util.Collection)
     */
    @Override
    protected void setInputDialogResourceName(Collection<Object> filterList) {
        String system = "System";
        String repository = "Repository";
        String resourceRepository = "ResourceRepository";

        ArrayList<Object> list = new ArrayList<Object>();
        list.addAll(filterList);

        if (!list.isEmpty()) {
            for (Object object : list) {
                Class<?> clazz = (Class<?>) object;
                String name = clazz.getSimpleName();
                if (name.equals(system) || name.equals(repository) || name.equals(resourceRepository))
                    setResourceName(correctionResourceRepositoryName(name));
            }
        }
    }

    /** Correction the ResourceRepository to ResourceType */
    private String correctionResourceRepositoryName(String name) {
        if (name.equals("ResourceRepository"))
            return "ResourceType";
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog#addResourceToEditingDomain(org.eclipse
     * .swt.widgets.Shell, java.lang.String)
     */
    @Override
    protected void addModelToResourceSet(Shell shell, String uri) {
        ResourceSet resourceSet = getResourceSet(input);

        if (resourceSet != null) {
            URI model = URI.createURI(uri);
            try {
                resourceSet.getResource(model, true);
            } catch (Throwable t) {
                MessageDialog.openInformation(shell, "Resource Loader Error", t.getMessage());
            }
        }
    }

    /**
     * Get a resource set from dialog input object
     * 
     * @param object
     *            - dialog input object
     */
    protected ResourceSet getResourceSet(Object object) {
        /** ResourceSet */
        if (object instanceof ResourceSet)
            return (ResourceSet) object;
        /** EObject */
        if (object instanceof EObject) {
            TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain((EObject) object);
            if (editingDomain != null)
                return editingDomain.getResourceSet();
        }
        return null;
    }

    /**
     * The method supplies the main knots of, in this dialogue the represented, tree
     */
    public Object getViewerRootElement() {
        Object object = null;

        if (contentProvider != null) {
            object = (contentProvider.getElements(input))[0];
        }

        return object;
    }
}
