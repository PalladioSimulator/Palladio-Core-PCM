/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.UsageBranchParameter;

/**
 * This is the item provider adapter for a {@link de.uka.ipd.sdq.sensitivity.UsageBranchParameter}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class UsageBranchParameterItemProvider extends SingleSensitivityParameterItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public UsageBranchParameterItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addBranch__UsageBranchParameterPropertyDescriptor(object);
            addScenarioBehaviour__UsageBranchParameterPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Branch Usage Branch Parameter feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addBranch__UsageBranchParameterPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_UsageBranchParameter_branch__UsageBranchParameter_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_UsageBranchParameter_branch__UsageBranchParameter_feature",
                        "_UI_UsageBranchParameter_type"),
                SensitivityPackage.Literals.USAGE_BRANCH_PARAMETER__BRANCH_USAGE_BRANCH_PARAMETER, true, false, true,
                null, null, null));
    }

    /**
     * This adds a property descriptor for the Scenario Behaviour Usage Branch Parameter feature.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addScenarioBehaviour__UsageBranchParameterPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(),
                getString("_UI_UsageBranchParameter_scenarioBehaviour__UsageBranchParameter_feature"),
                getString("_UI_PropertyDescriptor_description",
                        "_UI_UsageBranchParameter_scenarioBehaviour__UsageBranchParameter_feature",
                        "_UI_UsageBranchParameter_type"),
                SensitivityPackage.Literals.USAGE_BRANCH_PARAMETER__SCENARIO_BEHAVIOUR_USAGE_BRANCH_PARAMETER, true,
                false, true, null, null, null));
    }

    /**
     * This returns UsageBranchParameter.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/UsageBranchParameter"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated not
     */
    @Override
    public String getText(Object object) {
        String branchName = "UNSPECIFIED";
        try {
            branchName = ((UsageBranchParameter) object).getBranch__UsageBranchParameter().getEntityName();
        } catch (Exception e) {
        }
        String behaviourName = "UNSPECIFIED";
        try {
            behaviourName = ((UsageBranchParameter) object).getScenarioBehaviour__UsageBranchParameter()
                    .getEntityName();
        } catch (Exception e) {
        }
        return ((UsageBranchParameter) object).getEntityName() + " (" + branchName + "/" + behaviourName + ")"
                + " [ID: " + ((UsageBranchParameter) object).getId() + "]" + " <"
                + getString("_UI_UsageBranchParameter_type") + ">";
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
     * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
