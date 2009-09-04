package de.uka.ipd.sdq.edp2.local.file;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;


/**Checks if instances of the class Propertyable are correctly stored and loaded back from disc.
 * @author groenda
 * 
 */
public class PropertyablePersistenceTest extends PersistenceTest {

	@Test
	public void testPersistenceString() throws IOException {
		// test values
		String testKey = "Test if storable; Key";
		String testValue = "Test if storable; Value";

		// setup model
		ExperimentGroup eg = EmfModelFactory.createExperimentGroup();
		EMap<String, Object> information = eg.getAdditionalInformation();
		information.put(testKey, testValue);

		URI fileURI = URI.createFileURI(tempFile.getAbsolutePath());
		XMIResource resource = (XMIResource) resourceSet.createResource(fileURI);
		String test = resource.getID(eg);
		System.out.println("Test: " + test);
		
		// save and load again
		serialize(eg);
		eg = null;
		eg = deserialize();

		test = resource.getID(eg);
		System.out.println("Test2: " + test);
		
		information = eg.getAdditionalInformation();
		assertEquals("Exactly one key/value pair is stored.", information
				.size() == 1, true);
		assertEquals("Key changed after store/load operation.", information
				.containsKey(testKey), true);
		assertEquals("Value changed after store/load operation.", testValue,
				information.get(testKey));
	}

	@Test
	public void testPersistenceMalciousString() throws IOException {
		// test values
		String testKey = "Test \" <nonsense> <; Key\n\n<tst";
		String testValue = "Test \" <nonsense> <; Value";

		// setup model
		ExperimentGroup eg = EmfModelFactory.createExperimentGroup();
		EMap<String, Object> information = eg.getAdditionalInformation();
		information.put(testKey, testValue);

		// save and load again
		serialize(eg);
		eg = null;
		eg = deserialize();

		information = eg.getAdditionalInformation();
		assertEquals("Exactly one key/value pair is stored.", information
				.size() == 1, true);
		assertEquals("Key changed after store/load operation.", information
				.containsKey(testKey), true);
		assertEquals("Value changed after store/load operation.", testValue,
				information.get(testKey));
	}

	@Test
	public void testPersistenceDoubleLong() throws IOException {
		// test values
		String testKeyDouble = "Test Double";
		double testValueDouble = Math.random();
		String testKeyLong = "Test Long";
		Long testValueLong = Long.MAX_VALUE;

		// setup model
		ExperimentGroup eg = EmfModelFactory.createExperimentGroup();
		EMap<String, Object> information = eg.getAdditionalInformation();
		information.put(testKeyDouble, testValueDouble);
		information.put(testKeyLong, testValueLong);

		// save and load again
		serialize(eg);
		eg = null;
		eg = deserialize();

		information = eg.getAdditionalInformation();
		assertEquals("Exactly two key/value pairs are stored.", information
				.size() == 2, true);
		assertEquals("Key for Double changed after store/load operation.",
				information.containsKey(testKeyDouble), true);
		assertEquals("Key for Long changed after store/load operation.",
				information.containsKey(testKeyLong), true);
		assertEquals("Double value changed after store/load operation.",
				testValueDouble, information.get(testKeyDouble));
		assertEquals("Long value changed after store/load operation.",
				testValueLong, information.get(testKeyLong));
	}

	@Test
	public void testPersistenceOverwriteValue() throws IOException {
		// test values
		String testKey = "Test Overwrite Value";
		double testValueDouble = Math.random();
		long testValueLong = Long.MIN_VALUE;

		// setup model
		ExperimentGroup eg = EmfModelFactory.createExperimentGroup();
		EMap<String, Object> information = eg.getAdditionalInformation();
		information.put("Test Overwrite Value", testValueDouble);
		information.put("Test Overwrite Value", testValueLong);

		// save and load again
		serialize(eg);
		eg = null;
		eg = deserialize();

		information = eg.getAdditionalInformation();
		assertEquals("Exactly one key/value pair is stored.", information
				.size() == 1, true);
		assertEquals("Key changed after store/load operation.", information
				.containsKey(testKey), true);
		assertEquals("New value is not correct after store/load operation.",
				testValueLong, information.get(testKey));
	}

}