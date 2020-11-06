package org.palladiosimulator.pcm.tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.tests.impl.ConstraintTestBase;

public class ServiceEffectSpecificationConstraintTest extends ConstraintTestBase {

    private static final String PATH_REF = "testmodels/referencedSignatureMustBelongToInterfaceReferencedByProvidedRole";
    private static final String CONSTRAINT_OP = "referencedOperationSignatureMustBelongToInterfaceReferencedByProvidedRole";
    private static final String CONSTRAINT_EG = "referencedEventTypeMustBelongToEventGroupReferencedByProvidedRole";

    @Test
    public void testDirectInterface() {
        // ChildComponent
        testSEFFReferencedOperationSignature("_B4cm8CBcEeu_eL7spKBPnw", true);
    }

    @Test
    public void testParentInterface() {
        // ParentComponent
        testSEFFReferencedOperationSignature("_cCffsCBhEeuj6pgbQMaDVA", true);
    }

    @Test
    public void testTwoLevelParentInterface() {
        // ParentParentComponent
        testSEFFReferencedOperationSignature("_c1JrsCBhEeuj6pgbQMaDVA", true);
    }

    @Test
    public void testWrongInterface() {
        // Broken Component
        testSEFFReferencedOperationSignature("_1TMt8CBsEeudX9l4s6X0iA", false);
    }

    @Test
    public void testDirectEventGroup() {
        // ChildComponent
        testSEFFReferencedEventGroup("_QHWiYCBsEeudX9l4s6X0iA", true);
    }

    @Test
    public void testParentEventGroup() {
        // OneLevelUpComponent
        testSEFFReferencedEventGroup("_SCgngCBsEeudX9l4s6X0iA", true);
    }

    @Test
    public void testTwoLevelParentEventGroup() {
        // TwoLevelsUpComponents
        testSEFFReferencedEventGroup("_TJonoCBsEeudX9l4s6X0iA", true);
    }

    @Test
    public void testWrongEventGroup() {
        // BrokenComponent
        testSEFFReferencedEventGroup("_m4szQCBsEeudX9l4s6X0iA", false);
    }

    @Test
    public void testCorrectMixedInterfaces() {
        // Correct
        testSEFFReferencedMixedSignature(new SeffAndExpectedResult("_eF6SgCBtEeudX9l4s6X0iA", true, CONSTRAINT_OP),
                new SeffAndExpectedResult("_e_DhACBtEeudX9l4s6X0iA", true, CONSTRAINT_OP),
                new SeffAndExpectedResult("_k0BwUCBtEeudX9l4s6X0iA", true, CONSTRAINT_EG),
                new SeffAndExpectedResult("_mKraMCBtEeudX9l4s6X0iA", true, CONSTRAINT_EG));
    }

    @Test
    public void testWrongOperationInterface() {
        // WrongOperation
        testSEFFReferencedMixedSignature(new SeffAndExpectedResult("_s8ZloCBtEeudX9l4s6X0iA", false, CONSTRAINT_OP),
                new SeffAndExpectedResult("_uWIYsCBtEeudX9l4s6X0iA", true, CONSTRAINT_OP),
                new SeffAndExpectedResult("_vnItkCBtEeudX9l4s6X0iA", true, CONSTRAINT_EG),
                new SeffAndExpectedResult("_wT-lcCBtEeudX9l4s6X0iA", true, CONSTRAINT_EG));
    }

    @Test
    public void testWrongWrongEventGroup() {
        // WrongEvent
        testSEFFReferencedMixedSignature(new SeffAndExpectedResult("_zfiigCBtEeudX9l4s6X0iA", true, CONSTRAINT_OP),
                new SeffAndExpectedResult("_1BbzECBtEeudX9l4s6X0iA", true, CONSTRAINT_OP),
                new SeffAndExpectedResult("_4dVSMCBtEeudX9l4s6X0iA", true, CONSTRAINT_EG),
                new SeffAndExpectedResult("_5NdHkCBtEeudX9l4s6X0iA", false, CONSTRAINT_EG));
    }

    protected void testSEFFReferencedOperationSignature(String seffId, boolean expectSuccess) {
        testReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(
                PATH_REF + "/operationalInterfaceInheritance.repository",
                new SeffAndExpectedResult(seffId, expectSuccess, CONSTRAINT_OP));
    }

    protected void testSEFFReferencedEventGroup(String seffId, boolean expectSuccess) {
        testReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(
                PATH_REF + "/eventGroupInterfaceInheritance.repository",
                new SeffAndExpectedResult(seffId, expectSuccess, CONSTRAINT_EG));
    }

    protected void testSEFFReferencedMixedSignature(SeffAndExpectedResult... seffAndExpectedResults) {
        testReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(
                PATH_REF + "/mixedInterfaceInheritance.repository", seffAndExpectedResults);
    }

    private static class SeffAndExpectedResult {
        private final String seffId;
        private final boolean expectedResult;
        private final String constraintName;

        public SeffAndExpectedResult(String seffId, boolean expectedResult, String constraintName) {
            this.seffId = seffId;
            this.expectedResult = expectedResult;
            this.constraintName = constraintName;
        }

        public String getSeffId() {
            return seffId;
        }

        public boolean isExpectedResult() {
            return expectedResult;
        }

        public String getConstraintName() {
            return constraintName;
        }

    }

    protected void testReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(String modelName,
            SeffAndExpectedResult... seffAndExpectedResults) {
        testReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(modelName,
                Arrays.asList(seffAndExpectedResults));
    }

    protected void testReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(String modelName,
            Collection<SeffAndExpectedResult> seffAndExpectedResults) {
        var repository = loadModel(modelName, Repository.class);

        var seffs = repository.getComponents__Repository()
            .stream()
            .filter(BasicComponent.class::isInstance)
            .map(BasicComponent.class::cast)
            .map(BasicComponent::getServiceEffectSpecifications__BasicComponent)
            .flatMap(Collection::stream)
            .map(ResourceDemandingSEFF.class::cast)
            .collect(Collectors.toList());

        for (var seffAndExpectedResult : seffAndExpectedResults) {
            var seff = seffs.stream()
                .filter(s -> seffAndExpectedResult.getSeffId()
                    .equals(s.getId()))
                .findFirst()
                .orElseThrow();
            if (seffAndExpectedResult.isExpectedResult()) {
                assertNoViolation(seff, seffAndExpectedResult.getConstraintName());
            } else {
                assertViolation(seff, seffAndExpectedResult.getConstraintName());
            }
        }

    }

}
