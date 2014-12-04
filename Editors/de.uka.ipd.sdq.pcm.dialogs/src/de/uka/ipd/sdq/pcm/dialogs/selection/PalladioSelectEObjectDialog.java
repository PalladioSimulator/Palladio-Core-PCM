package de.uka.ipd.sdq.pcm.dialogs.selection;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
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
import de.uka.ipd.sdq.pcm.subsystem.provider.SubsystemItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.system.provider.SystemItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.usagemodel.provider.UsagemodelItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PalladioSelectEObjectDialog.
 * 
 * @author Steffen Becker, Sebastian Lehrig
 */
public class PalladioSelectEObjectDialog extends SelectEObjectDialog {

    private static final String SYSTEM = "System";
    private static final String REPOSITORY = "Repository";
    private static final String RESOURCE_REPOSITORY = "ResourceRepository";
    private static final String RESOURCE_TYPE = "ResourceType";
    private static final ComposedAdapterFactory ADAPTER_FACTORY = new ComposedAdapterFactory();
    private static final IBaseLabelProvider LABEL_PROVIDER;

    static {
        ADAPTER_FACTORY.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new SeffItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new SystemItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new AllocationItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new UsagemodelItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new ResourceenvironmentItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new ParameterItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new ResourcetypeItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new CoreItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new CompositionItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        ADAPTER_FACTORY.addAdapterFactory(new SubsystemItemProviderAdapterFactory());

        LABEL_PROVIDER = new AdapterFactoryLabelProvider(new PalladioItemProviderAdapterFactory(ADAPTER_FACTORY));
    }

    /**
     * Creates a selection dialog.
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
        super(parent, getInputDialogResourceName(filterList), input, new AdapterFactoryContentProvider(new FilteredItemsAdapterFactory(ADAPTER_FACTORY,
                filterList, additionalChildReferences)), LABEL_PROVIDER);
    }

    /**
     * Instantiates a new Palladio select EObject dialog.
     * 
     * @param parent
     *            the parent
     * @param filterList
     *            the filter list
     * @param input
     *            the input
     */
    public PalladioSelectEObjectDialog(Shell parent, Collection<Object> filterList, Object input) {
        this(parent, filterList, new ArrayList<EReference>(), input);
    }

    protected static String getInputDialogResourceName(final Collection<Object> filterList) {
        final StringBuilder result = new StringBuilder();

        for (final Object object : filterList) {
            final String name = ((Class<?>) object).getSimpleName();

            if (name.equals(SYSTEM) || name.equals(REPOSITORY)) {
                result.append(name);
                result.append(" ");
            } else if (name.equals(RESOURCE_REPOSITORY)) {
                result.append(RESOURCE_TYPE);
                result.append(" ");
            }
        }

        return result.toString();
    }
}
