/**
 */
package org.palladiosimulator.pcm.resultdecorator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository;
import org.palladiosimulator.pcm.resultdecorator.ResultdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory;

import org.palladiosimulator.pcm.core.entity.provider.NamedElementItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ResultDecoratorRepositoryItemProvider extends NamedElementItemProvider {

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public ResultDecoratorRepositoryItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(final Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
     * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(final Object object) {
        if (this.childrenFeatures == null) {
            super.getChildrenFeatures(object);
            this.childrenFeatures.add(
                    ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY);
            this.childrenFeatures.add(
                    ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY);
            this.childrenFeatures.add(
                    ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(final Object object, final Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns ResultDecoratorRepository.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/ResultDecoratorRepository"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((ResultDecoratorRepository) object).getEntityName();
        return label == null || label.length() == 0 ? this.getString("_UI_ResultDecoratorRepository_type")
                : this.getString("_UI_ResultDecoratorRepository_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(final Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(ResultDecoratorRepository.class)) {
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
        case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
     * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, final Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(this.createChildParameter(
                ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY,
                RepositorydecoratorFactory.eINSTANCE.createInterfaceProvidingRequiringEntityResults()));

        newChildDescriptors.add(this.createChildParameter(
                ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY,
                RepositorydecoratorFactory.eINSTANCE.createAllocationContextResults()));

        newChildDescriptors.add(this.createChildParameter(
                ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY,
                ResourceenvironmentdecoratorFactory.eINSTANCE.createLinkingResourceResults()));

        newChildDescriptors.add(this.createChildParameter(
                ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY,
                ResourceenvironmentdecoratorFactory.eINSTANCE.createResourceContainerResults()));

        newChildDescriptors.add(this.createChildParameter(
                ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY,
                ResourceenvironmentdecoratorFactory.eINSTANCE.createProcessingResourceSpecificationResult()));

        newChildDescriptors.add(this.createChildParameter(
                ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY,
                ResourceenvironmentdecoratorFactory.eINSTANCE.createPassiveResourceResult()));

        newChildDescriptors.add(this.createChildParameter(
                ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY,
                RepositorydecoratorFactory.eINSTANCE.createAllocationServiceResult()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ResultdecoratorEditPlugin.INSTANCE;
    }

}
