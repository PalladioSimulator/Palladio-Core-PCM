package org.palladiosimulator.pcm.profiles.util.helper;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.modelversioning.emfprofile.Stereotype;
import org.modelversioning.emfprofileapplication.StereotypeApplication;
import org.palladiosimulator.mdsdprofiles.api.StereotypeAPI;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

/**
 * Helper class containing static methods to interact with Palladio Profiles.
 * 
 * Note: As long as Palladio Core provides support for Java 1.6, we cannot use Java 1.8
 * implementations.
 * 
 * TODO this class
 * 
 * @author Daria Giacinto, Sebastian Lehrig, Max Schettler
 */
public final class ProfileHelper {

    /**
     * Hidden constructor
     */
    private ProfileHelper() {
        super();
    }

    /**
     * Checks whether any {@link Entity} in the given set has a stereotype with the given name
     * applied.
     * 
     * @param pcmEntitySet
     *            the set of entities
     * @param stereotypeName
     *            the stereotype name
     * @return
     * @see #hasAppliedStereotype(Entity, String)
     */
    public static boolean hasAppliedStereotype(final Set<Entity> pcmEntitySet, final String stereotypeName) {
        for (final Entity entity : pcmEntitySet) {
            if (StereotypeAPI.isStereotypeApplied(entity, stereotypeName)) {
                return true;
            }
        }

        return false;

        // Java 8:
        // return pcmEntitySet.stream().allMatch(
        // entity -> hasAppliedStereotype(entity, stereotypeName));
    }

    /**
     * Checks whether in the given set exactly one of its members has an applied {@link Stereotype}
     * of the given name.
     * 
     * @param pcmEntitySet
     *            the set of entities
     * @param stereotypeName
     *            the stereotype name
     * @return
     * @see #hasAppliedStereotype(Entity, String)
     */
    public static boolean appliedStereotypesEqualsOne(final Set<Entity> pcmEntitySet, final String stereotypeName) {
        int appliedStereotypes = 0;

        for (final Entity entity : pcmEntitySet) {
            if (StereotypeAPI.isStereotypeApplied(entity, stereotypeName)) {
                appliedStereotypes++;
            }
        }

        if (appliedStereotypes != 1) {
            return false;
        }
        return true;

        // Java 8:
        // return pcmEntitySet.stream().filter(entity -> hasAppliedStereotype(entity,
        // stereotypeName)).count() == 1;
    }

    /**
     * Sets the specified tagged value on the {@link Stereotype}.
     * 
     * @param pcmEntity
     *            the entity on which the stereotype is applied.
     * @param value
     *            the value to be set
     * @param stereotypeName
     *            the stereotype`s name
     * @param taggedValueName
     *            the tagged value`s name
     */
    public static void setTaggedValue(final Entity pcmEntity, final int value, final String stereotypeName,
            final String taggedValueName) {
        final List<StereotypeApplication> stereotypeApplications = StereotypeAPI.getStereotypeApplications(pcmEntity,
                stereotypeName);
        final StereotypeApplication stereotypeApplication = stereotypeApplications.get(0);
        setValueOfEStructuralFeature(stereotypeApplication, taggedValueName, value);
        // pcmEntity.saveContainingProfileApplication();

    }

    /**
     * Returns the tagged value of the specified {@link Stereotype}.
     * 
     * @param pcmEntity
     *            the entity on which the stereotype is applied
     * @param taggedValueName
     *            the tagged value`s name
     * @param stereotypeName
     *            the stereotype`s name
     * @return the value
     * @see #getTaggedValue(Entity, String, String)
     */
    public static int getIntTaggedValue(final Entity pcmEntity, final String taggedValueName,
            final String stereotypeName) {
        return getTaggedValue(pcmEntity, taggedValueName, stereotypeName);
    }

    /**
     * Returns the tagged value of the specified {@link Stereotype}.
     * 
     * @param pcmEntity
     *            the entity on which the stereotype is applied
     * @param taggedValueName
     *            the tagged value`s name
     * @param stereotypeName
     *            the stereotype`s name
     * @return the value
     * @see #getTaggedValue(Entity, String, String)
     */
    public static double getDoubleTaggedValue(final Entity pcmEntity, final String taggedValueName,
            final String stereotypeName) {
        return getTaggedValue(pcmEntity, taggedValueName, stereotypeName);
    }

    public static void delete(final List<NamedElement> rootEObjects, final Entity eObject) {
        final Set<EObject> eObjects = new HashSet<EObject>();
        final Set<EObject> crossResourceEObjects = new HashSet<EObject>();
        eObjects.add(eObject);
        for (@SuppressWarnings("unchecked")
        final TreeIterator<InternalEObject> j = (TreeIterator<InternalEObject>) (TreeIterator<?>) eObject
                .eAllContents(); j.hasNext();) {
            final InternalEObject childEObject = j.next();
            if (childEObject.eDirectResource() != null) {
                crossResourceEObjects.add(childEObject);
            } else {
                eObjects.add(childEObject);
            }
        }

        Map<EObject, Collection<EStructuralFeature.Setting>> usages;
        usages = UsageCrossReferencer.findAll(eObjects, rootEObjects);

        for (final Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : usages.entrySet()) {
            final EObject deletedEObject = entry.getKey();
            final Collection<EStructuralFeature.Setting> settings = entry.getValue();
            for (final EStructuralFeature.Setting setting : settings) {
                if (!eObjects.contains(setting.getEObject()) && setting.getEStructuralFeature().isChangeable()) {
                    EcoreUtil.remove(setting, deletedEObject);
                }
            }
        }

        EcoreUtil.remove(eObject);

        for (final EObject crossResourceEObject : crossResourceEObjects) {
            EcoreUtil.remove(crossResourceEObject.eContainer(), crossResourceEObject.eContainmentFeature(),
                    crossResourceEObject);
        }
    }

    /**
     * Sets the tagged value of the given {@link StereotypeApplication}.
     * 
     * @param stereotypeApplication
     *            the stereotype application
     * @param taggedValueName
     *            the tagged value`s name
     * @param newValue
     *            the value to set
     */
    private static void setValueOfEStructuralFeature(final StereotypeApplication stereotypeApplication,
            final String taggedValueName, final Object newValue) {

        final Stereotype stereotype = stereotypeApplication.getExtension().getSource();
        if (stereotype != null) {
            final EStructuralFeature taggedValue = stereotype.getTaggedValue(taggedValueName);
            stereotypeApplication.eSet(taggedValue, newValue);
        }
    }

    /**
     * Returns the tagged value of the specified {@link Stereotype}.
     * 
     * @param pcmEntity
     *            the entity on which the stereotype is applied
     * @param taggedValueName
     *            the tagged value`s name
     * @param stereotypeName
     *            the stereotype`s name
     * @return the value
     * @return
     */
    @SuppressWarnings("unchecked")
    private static <DATA_TYPE> DATA_TYPE getTaggedValue(final Entity pcmEntity, final String taggedValueName,
            final String stereotypeName) {
        final EList<StereotypeApplication> pcmEntityStereotypeApplications = StereotypeAPI.getStereotypeApplications(
                pcmEntity, stereotypeName);
        final StereotypeApplication stereotypeApplication = pcmEntityStereotypeApplications.get(0);

        final Stereotype stereotype = stereotypeApplication.getExtension().getSource();

        final EStructuralFeature taggedValue = stereotype.getTaggedValue(taggedValueName);

        return (DATA_TYPE) stereotypeApplication.eGet(taggedValue);

    }
}
