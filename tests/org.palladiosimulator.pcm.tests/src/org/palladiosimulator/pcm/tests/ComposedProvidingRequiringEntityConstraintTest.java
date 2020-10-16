package org.palladiosimulator.pcm.tests;

import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.tests.impl.ConstraintTestBase;

public class ComposedProvidingRequiringEntityConstraintTest extends ConstraintTestBase {

    @Test
    public void operationalProvidedRolesMustBeBound() {
        testOperationalProvidedRolesMustBeBound(
                "testmodels/operationalProvidedRolesHaveToBeBound/operationalProvidedRole.repository", true);
    }

    @Test
    public void operationalProvidedRolesMustBeBoundButIsUnbound() {
        testOperationalProvidedRolesMustBeBound(
                "testmodels/operationalProvidedRolesHaveToBeBound/operationalProvidedRoleUnbound.repository", false);
    }

    @Test
    public void operationalProvidedRolesMustBeBoundWithNonOperationalRole() {
        testOperationalProvidedRolesMustBeBound(
                "testmodels/operationalProvidedRolesHaveToBeBound/operationalAndSinkProvidedRole.repository", true);
    }

    protected void testOperationalProvidedRolesMustBeBound(String modelName, boolean expectSuccess) {
        var repository = loadModel(modelName, Repository.class);
        var composite = repository.getComponents__Repository()
            .stream()
            .filter(ComposedProvidingRequiringEntity.class::isInstance)
            .map(ComposedProvidingRequiringEntity.class::cast)
            .findAny()
            .orElseThrow();
        if (expectSuccess) {
            assertNoViolation(composite, "operationProvidedRolesMustBeBound");
        } else {
            assertViolation(composite, "operationProvidedRolesMustBeBound");
        }
    }

}
