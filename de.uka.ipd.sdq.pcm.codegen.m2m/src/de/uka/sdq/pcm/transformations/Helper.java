package de.uka.sdq.pcm.transformations;

import org.eclipse.emf.ecore.EObject;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

public class Helper {
	public static String removeAllSpecialChars(String s) {
		return s.replace('\n',' ').replace('\t', ' ').replace('\r', ' ');
	}

	/**
	 * @param eObject The object.
	 * @return The file name of the resource containing the object.
	 */
	public static String getResourceFileName(ResourceDemandingSEFF eObject) {
		return eObject.eResource().getURI().toFileString();
	}

	/**
	 * @param eObject The object.
	 * @return The file name of the resource containing the object.
	 */
	public static String getResourceFileName(CharacterisedPCMParameterPartition eObject) {
		return eObject.eResource().getURI().toFileString();
	}

	/**
	 * @param action The action.
	 * @return The {@link ResourceDemandingSEFF} containing the action or {@code null} if none could be found.
	 */
	public static ResourceDemandingSEFF getRdseff(AbstractAction action) {
		EObject src = action;
		while (src.eContainer() != null && !(src instanceof ResourceDemandingSEFF)) {
			src = src.eContainer();
		}
		return (ResourceDemandingSEFF) src;
	}
}
