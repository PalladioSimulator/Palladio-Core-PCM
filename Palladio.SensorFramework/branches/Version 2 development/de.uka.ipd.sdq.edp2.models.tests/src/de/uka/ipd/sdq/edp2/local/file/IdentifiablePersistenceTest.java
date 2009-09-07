/**
 * 
 */
package de.uka.ipd.sdq.edp2.local.file;

import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Assert;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;

/**Checks if {@link de.uka.ipd.sdq.edp2.Identifiable} classes get 
 * a correct UUID and keep it after (de-)serialization.
 * The {@link de.uka.ipd.sdq.edp2.ExperimentGroup} class is used 
 * as representative for the abstract identifiable class.
 * @author groenda
 */
public class IdentifiablePersistenceTest extends PersistenceTest {
	
	@Test
	public void testUuidSetOnFirstRequest() {
		// setup model
		ExperimentGroup eg = experimentDataFactory.createExperimentGroup();
		String uuid = eg.getUuid();
		Assert.assertNotNull("First request of id should initialize uuid (if uuid unset).", uuid);
	}

	@Test
	public void testSetUuid() {
		ExperimentGroup eg = experimentDataFactory.createExperimentGroup();
		eg.getUuid();
		String newUuid = EcoreUtil.generateUUID();
		eg.setUuid(newUuid);
		String uuid = eg.getUuid();
		
		Assert.assertEquals("Uuid should be changed after setting it.", uuid, eg.getUuid());
	}

	@Test
	public void testUuidEqualAfterPersistence() throws IOException {
		ExperimentGroup eg = experimentDataFactory.createExperimentGroup();
		String uuid = eg.getUuid();
		Assert.assertNotNull("Uuid of Identifiable classes must not be null.", uuid);
		serialize(eg);
		eg = deserialize();

		Assert.assertEquals("Uuid changed after persistence.", uuid, eg.getUuid());
	}
	
	@Test
	public void testUuidGeneration() throws IOException {
		ExperimentGroup eg = experimentDataFactory.createExperimentGroup();
		serialize(eg);
		eg = deserialize();
		Assert.assertNotNull("UUID of Identifiable classes must not be null.", eg.getUuid());
	}
	
}
