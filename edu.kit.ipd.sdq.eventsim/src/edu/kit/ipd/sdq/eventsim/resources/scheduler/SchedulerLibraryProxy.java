//package edu.kit.ipd.sdq.eventsim.resources.scheduler;
//
//import java.lang.reflect.InvocationTargetException;
//
//import org.eclipse.emf.common.notify.Adapter;
//import org.eclipse.emf.common.notify.Notification;
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.common.util.TreeIterator;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EOperation;
//import org.eclipse.emf.ecore.EReference;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.emf.ecore.resource.Resource;
//
//import scheduler.SchedulerLibrary;
//import scheduler.configuration.SchedulerConfiguration;
//import de.uka.ipd.sdq.scheduler.tools.SchedulerTools;
//
///**
// * A proxy to the {@link SchedulerLibrary} that loads the scheduler library on demand and knows from
// * where to load it.
// * 
// * @author Philipp Merkle
// * 
// */
//public class SchedulerLibraryProxy implements SchedulerLibrary {
//
//    /**
//     * the location of the scheduler library
//     */
//    public static final String PATHMAP_TO_SCHEDULER_LIBRARY = "pathmap://PCM_MODELS/Library.scheduler";
//
//    private SchedulerLibrary library;
//
//    /**
//     * Returns the encapsulated scheduler library, which is loaded on the first call.
//     * 
//     * @return the scheduler library
//     */
//    private SchedulerLibrary getSchedulerLibrary() {
//        if (library == null) {
//            // load scheduler library from file
//            library = (SchedulerLibrary) SchedulerTools.loadFromXMI(PATHMAP_TO_SCHEDULER_LIBRARY);
//        }
//        return library;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EList<Adapter> eAdapters() {
//        return getSchedulerLibrary().eAdapters();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public TreeIterator<EObject> eAllContents() {
//        return getSchedulerLibrary().eAllContents();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EClass eClass() {
//        return getSchedulerLibrary().eClass();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EObject eContainer() {
//        return getSchedulerLibrary().eContainer();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EStructuralFeature eContainingFeature() {
//        return getSchedulerLibrary().eContainingFeature();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EReference eContainmentFeature() {
//        return getSchedulerLibrary().eContainmentFeature();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EList<EObject> eContents() {
//        return getSchedulerLibrary().eContents();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EList<EObject> eCrossReferences() {
//        return getSchedulerLibrary().eCrossReferences();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public boolean eDeliver() {
//        return getSchedulerLibrary().eDeliver();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Object eGet(EStructuralFeature feature, boolean resolve) {
//        return getSchedulerLibrary().eGet(feature, resolve);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Object eGet(EStructuralFeature feature) {
//        return getSchedulerLibrary().eGet(feature);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public boolean eIsProxy() {
//        return getSchedulerLibrary().eIsProxy();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public boolean eIsSet(EStructuralFeature feature) {
//        return getSchedulerLibrary().eIsSet(feature);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void eNotify(Notification notification) {
//        getSchedulerLibrary().eNotify(notification);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Resource eResource() {
//        return getSchedulerLibrary().eResource();
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void eSet(EStructuralFeature feature, Object newValue) {
//        getSchedulerLibrary().eSet(feature, newValue);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void eSetDeliver(boolean deliver) {
//        getSchedulerLibrary().eSetDeliver(deliver);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void eUnset(EStructuralFeature feature) {
//        getSchedulerLibrary().eUnset(feature);
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public EList<SchedulerConfiguration> getSchedulerConfiguration() {
//        return getSchedulerLibrary().getSchedulerConfiguration();
//    }
//
//    // TODO remove comment when migrated to Eclipse 3.7
//    // @Override
//    public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
//        throw new UnsupportedOperationException(
//                "This operation is not yet supported to preserve backward compatibility to Eclipse 3.5");
//        // TODO remove comment when migrated to Eclipse 3.7
//        // return getSchedulerLibrary().eInvoke(operation, arguments);
//    }
//
//}
