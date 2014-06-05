package edu.kit.ipd.sdq.eventsim.util;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * Provides helper methods for PCM entities implementing the {@link Entity} interface.
 * 
 * @author Philipp Merkle
 * 
 */
public class PCMEntityHelper {

    /**
     * Builds a string representation of an entity. The returned string contains the entities's
     * name, class name and ID.
     * 
     * @param entity
     *            the entity which is to be represented by a string
     * @return the string representation
     */
    public static String toString(final Entity entity) {
        if (entity == null) {
            return "null";
        }
        final StringBuilder builder = new StringBuilder();
        builder.append(entity.getEntityName());
        builder.append(" <");
        builder.append(entity.eClass().getName());
        builder.append("> ");
        builder.append(" [ID: ");
        builder.append(entity.getId());
        builder.append("]");
        return builder.toString();
    }

    /**
     * Checks whether the passed entities are equal. Two entities are regarded to be equal if they
     * carry the same ID.
     * 
     * @param e1
     *            the first entity
     * @param e2
     *            the second entity
     * @return true if e1 and e2 are equal; false else.
     */
    public static boolean equals(final Entity e1, final Entity e2) {
        if (e1 == null || e2 == null) {
            return false;
        }
        if (e1 == e2) {
            return true;
        }
        if (e1.getClass() != e2.getClass()) {
            return false;
        }
        return e1.getId().equals(e2.getId());
    }

}
