package de.uka.ipd.sdq.simulation.resources;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import scheduler.SchedulerLibrary;
import scheduler.configuration.SchedulerConfiguration;
import de.uka.ipd.sdq.scheduler.tools.SchedulerTools;

public class SchedulerLibraryProxy implements SchedulerLibrary {

    private SchedulerLibrary library;
    private String pathToSchedulerLibrary;

    public SchedulerLibraryProxy(String pathToSchedulerLibrary) {
        this.pathToSchedulerLibrary = pathToSchedulerLibrary;
    }
    
    private SchedulerLibrary getSchedulerLibrary() {
        if (library == null) {
            // load scheduler library from file
            library =  (SchedulerLibrary) SchedulerTools.loadFromXMI(pathToSchedulerLibrary);
        }
        return library;
    }

    public EList<Adapter> eAdapters() {
        return getSchedulerLibrary().eAdapters();
    }

    public TreeIterator<EObject> eAllContents() {
        return getSchedulerLibrary().eAllContents();
    }

    public EClass eClass() {
        return getSchedulerLibrary().eClass();
    }

    public EObject eContainer() {
        return getSchedulerLibrary().eContainer();
    }

    public EStructuralFeature eContainingFeature() {
        return getSchedulerLibrary().eContainingFeature();
    }

    public EReference eContainmentFeature() {
        return getSchedulerLibrary().eContainmentFeature();
    }

    public EList<EObject> eContents() {
        return getSchedulerLibrary().eContents();
    }

    public EList<EObject> eCrossReferences() {
        return getSchedulerLibrary().eCrossReferences();
    }

    public boolean eDeliver() {
        return getSchedulerLibrary().eDeliver();
    }

    public Object eGet(EStructuralFeature feature, boolean resolve) {
        return getSchedulerLibrary().eGet(feature, resolve);
    }

    public Object eGet(EStructuralFeature feature) {
        return getSchedulerLibrary().eGet(feature);
    }

    public boolean eIsProxy() {
        return getSchedulerLibrary().eIsProxy();
    }

    public boolean eIsSet(EStructuralFeature feature) {
        return getSchedulerLibrary().eIsSet(feature);
    }

    public void eNotify(Notification notification) {
        getSchedulerLibrary().eNotify(notification);
    }

    public Resource eResource() {
        return getSchedulerLibrary().eResource();
    }

    public void eSet(EStructuralFeature feature, Object newValue) {
        getSchedulerLibrary().eSet(feature, newValue);
    }

    public void eSetDeliver(boolean deliver) {
        getSchedulerLibrary().eSetDeliver(deliver);
    }

    public void eUnset(EStructuralFeature feature) {
        getSchedulerLibrary().eUnset(feature);
    }

    public EList<SchedulerConfiguration> getSchedulerConfiguration() {
        return getSchedulerLibrary().getSchedulerConfiguration();
    }

}
