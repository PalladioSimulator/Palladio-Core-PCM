package de.uka.ipd.sdq.experimentautomation.application.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.identifier.Identifier;

public class EcoreHelper {

    /**
     * Creates a deep copy of the source object and creates a new UUID for each {@link Identifier}
     * instance contained in the containment hierarchy of the copied object.
     * 
     * @param source
     *            the object that is to be copied
     */
    public static <T extends EObject> T copy(T source) {
        T copy = (T) EcoreUtil.copy(source);
        createNewIds(copy);
        return copy;
    }
    
    private static <T extends EObject> void createNewIds(T source) {
        // create and set new UUID
        if(Identifier.class.isInstance(source)) {
            ((Identifier) source).setId(EcoreUtil.generateUUID());
        }
      
        // recursively create new UUIDs for contained objects
        EList<EObject> contents = source.eContents();
        for(EObject o : contents) {
            createNewIds(o);
        }
    }

}
