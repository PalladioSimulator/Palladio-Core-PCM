/**
 * 
 */
package de.uka.ipd.sdq.sensorframework;

import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Assert;
import org.junit.Test;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentGroup;

/**Checks if {@link de.uka.ipd.sdq.sensorframework.Identifiable} classes get 
 * a correct UUID and keep it after (de-)serialization.
 * The {@link de.uka.ipd.sdq.sensorframework.ExperimentGroup} class is used 
 * as representative for the abstract identifiable class.
 * @author groenda
 */
public class IdentifiablePersistenceTest extends PersistenceTest {
	
	@Test
	public void testUuidSetOnFirstRequest() {
		// setup model
		ExperimentGroup eg = EmfModelFactory.createExperimentGroup();
		String uuid = eg.getId();
		Assert.assertNotNull("First request of id should initialize uuid (if uuid unset).", uuid);
	}

	@Test
	public void testSetUuid() {
		ExperimentGroup eg = EmfModelFactory.createExperimentGroup();
		eg.getId();
		String newUuid = EcoreUtil.generateUUID();
		eg.setId(newUuid);
		String uuid = eg.getId();
		
		Assert.assertEquals("Uuid should be changed after setting it.", uuid, eg.getId());
	}

	@Test
	public void testUuidEqualAfterPersistence() throws IOException {
		ExperimentGroup eg = EmfModelFactory.createExperimentGroup();
		String uuid = eg.getId();
		serialize(eg);
		eg = deserialize();

		Assert.assertEquals("Uuid changed after persistence.", uuid, eg.getId());
	}
}
