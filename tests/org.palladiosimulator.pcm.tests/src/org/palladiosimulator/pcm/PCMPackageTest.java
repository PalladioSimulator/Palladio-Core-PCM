package org.palladiosimulator.pcm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Test;

public class PCMPackageTest {

    /**
     * This test ensures that all EClass instances contained in the {@link PcmPackage} inherit from
     * EObject.
     */
    @Test
    public void testThatAllMetaClassesAreEObjects() {
        Set<EClass> nonEObjectEClasses = new LinkedHashSet<>();

        // iterate through the whole PCM package
        EObject currentEObject = PcmPackage.eINSTANCE;
        for (TreeIterator<EObject> iter = PcmPackage.eINSTANCE.eAllContents(); iter
            .hasNext(); currentEObject = iter.next()) {

            // we are only interested in EClasses
            if (!(currentEObject instanceof EClass)) {
                continue;
            }
            EClass currentEClass = (EClass) currentEObject;

            // skip all non-concrete EClasses 
            if (currentEClass.isAbstract() || currentEClass.isInterface()) {
                continue;
            }

            // record EClasses that do not inherit from EObject transitively
            if (!currentEClass.getEAllSuperTypes()
                .contains(EcorePackage.eINSTANCE.getEObject())) {
                nonEObjectEClasses.add(currentEClass);
            }

        }

        // assert that no problematic classes exist
        String classNamesMessagePart = nonEObjectEClasses.stream()
            .map(c -> c.getName() + "(" + c.getEPackage()
                .getNsURI() + ")")
            .collect(Collectors.joining(System.lineSeparator()));
        assertTrue(nonEObjectEClasses.isEmpty(), "There are EClasses that do not inherit from EObject:"
                + System.lineSeparator() + classNamesMessagePart);
    }

}
