package de.uka.sdq.pcm.transformations;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

public class Helper {
    public static String removeAllSpecialChars(String s) {
        return s.replace('\n', ' ').replace('\t', ' ').replace('\r', ' ');
    }

    /**
     * @param eObject
     *            The object.
     * @return The URI String of the given object.
     */
    public static String getResourceURI(EObject eObject) {
        URI uri = eObject.eResource().getURI();
        String fragment = eObject.eResource().getURIFragment(eObject);
        URI fullUri = uri.appendFragment(fragment);
        
        return fullUri.toString();
    }

    /**
     * @param eObject
     *            The object.
     * @return The measuring point description of the given object.
     */
    public static String getResourceDescription(EObject eObject) {
        return "Unknown PCM Element: " + eObject.getClass().getName();
    }

    /**
     * @param eObject
     *            The object.
     * @return The file name of the resource containing the object.
     */
    private static String getResourceFileNameEO(EObject eObject) {
        String fileName = eObject.eResource().getURI().toFileString();
        if (fileName.startsWith("\\")) {
            return fileName.substring(1).replaceAll("\\\\", "\\\\\\\\");
        } else {
            return fileName;
        }
    }

    /**
     * @param eObject
     *            The object.
     * @return The file name of the resource containing the object.
     */
    public static String getResourceFileName(ResourceDemandingSEFF eObject) {
        return getResourceFileNameEO(eObject);
    }

    /**
     * @param eObject
     *            The object.
     * @return The file name of the resource containing the object.
     */
    public static String getResourceFileName(CharacterisedPCMParameterPartition eObject) {
        return getResourceFileNameEO(eObject);
    }

    /**
     * @param action
     *            The action.
     * @return The {@link ResourceDemandingSEFF} containing the action or {@code null} if none could
     *         be found.
     */
    public static ResourceDemandingSEFF getRdseff(AbstractAction action) {
        EObject src = action;
        while (src.eContainer() != null && !(src instanceof ResourceDemandingSEFF)) {
            src = src.eContainer();
        }
        return (ResourceDemandingSEFF) src;
    }
}
