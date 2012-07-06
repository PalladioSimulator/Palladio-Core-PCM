package de.uka.ipd.sdq.reliability.solver.test;

import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.strings.StringValue;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.identifier.IdentifierPackage;

/**
 * This class provides additional functionality for the Markov Test Cases. To use this
 * functionality, the Test Case has to be run as a JUnit Plug-in Test (not only a JUnit Test).
 * 
 * @author brosch
 * 
 */
public class MarkovTestHelper {

    /**
     * Searches a tree of PCM model elements for an element with a certain GUID. Returns a reference
     * to this element.
     * 
     * @param root
     *            the root element of the tree to search
     * @param guid
     *            the guid of the element to find
     * @return the reference to the element
     */
    public Identifier getModelElement(final Identifier root, final String guid) {

        // Search for a string which equals the given GUID:
        Condition isGuidValue = new StringValue(guid);

        // Search for an identifier whose ID equals the given GUID:
        EObjectCondition hasGuidValue = new EObjectAttributeValueCondition(IdentifierPackage.Literals.IDENTIFIER__ID,
                isGuidValue);

        // Perform an EMF Model Query:
        IQueryResult queryResult = new SELECT(new FROM(root), new WHERE(hasGuidValue)).execute();

        // Return the first element that matches the condition:
        for (Object next : queryResult) {
            return (Identifier) next;
        }

        // Another possibility would be to use an OCL Query:
        // OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();
        // EObjectCondition guidCondition =
        // new BooleanOCLCondition<EClassifier, EClass, EObject>(
        // ocl.getEnvironment(), "self.id = '" + guid + "'",
        // IdentifierPackage.Literals.IDENTIFIER);
        // IQueryResult queryResult = new SELECT(new FROM(root), new WHERE(
        // guidCondition)).execute();

        // Nothing found:
        return null;
    }
}
