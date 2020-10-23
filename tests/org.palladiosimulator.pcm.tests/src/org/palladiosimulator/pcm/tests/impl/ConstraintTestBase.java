package org.palladiosimulator.pcm.tests.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;

public abstract class ConstraintTestBase extends TestBase {

    protected static void assertViolation(EObject object) {
        assertViolation(object, null);
    }

    protected static void assertViolation(EObject object, String constraintName) {
        var diagnostic = Diagnostician.INSTANCE.validate(object);
        assertFalse(diagnostic.getSeverity() <= Diagnostic.INFO);
        if (constraintName != null) {
            assertTrue(isConstraintViolated(diagnostic, constraintName),
                    "Constraint " + constraintName + " not violated\n" + serializeDiagnostic(diagnostic));
        }
    }

    protected static void assertNoViolation(EObject object) {
        assertNoViolation(object, null);
    }

    protected static void assertNoViolation(EObject object, String constraintName) {
        var diagnostic = Diagnostician.INSTANCE.validate(object);
        assertTrue(diagnostic.getSeverity() <= Diagnostic.INFO, serializeDiagnostic(diagnostic));
        if (constraintName != null) {
            assertFalse(isConstraintViolated(diagnostic, constraintName));
        }
    }

    protected static boolean isConstraintViolated(Diagnostic diagnostic, String constraintName) {
        var errorPrefix = "The '" + constraintName + "' constraint is violated on";
        var queue = new LinkedList<Diagnostic>();
        queue.add(diagnostic);
        while (!queue.isEmpty()) {
            var current = queue.pop();
            if (current.getMessage()
                .startsWith(errorPrefix)) {
                return true;
            }
            queue.addAll(current.getChildren());
        }
        return false;
    }

    protected static String serializeDiagnostic(Diagnostic diagnostic) {
        return serializeDiagnostic(diagnostic, 0);
    }

    protected static String serializeDiagnostic(Diagnostic diagnostic, int depth) {
        String prefix = "\t".repeat(depth);
        String result = prefix + String.format("%d: %s%n", diagnostic.getSeverity(), diagnostic.getMessage());
        for (var child : diagnostic.getChildren()) {
            result += serializeDiagnostic(child, depth + 1);
        }
        return result;
    }

}
