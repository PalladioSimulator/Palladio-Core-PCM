package de.uka.ipd.sdq.edp2.remote;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.file.impl.BackgroundMemoryListImpl;
import de.uka.ipd.sdq.edp2.models.binary.BinaryMeasurements;
import de.uka.ipd.sdq.edp2.remote.client.TransferLongBinaryMeasurementsRequest;

/**
 * Test the remote transfer of DoubleBinaryMeasurements.
 * 
 * @author groenda
 */
public class TransferLongBinaryMeasurementsTest extends GenericTransferTest{

	@Test
	public void testTransferLongBinaryMeasurementsWithWrongUuid()
			throws Exception {
		String requestedUuid = "non-existing uuid";
		TransferLongBinaryMeasurementsRequest transfer = new TransferLongBinaryMeasurementsRequest(
				channel, requestedUuid, clientDaoFactory);
		Boolean transferSuccess = transfer.send();
		Assert.assertFalse(
				"Transfer of non-exisiting UUID must not be successful.",
				transferSuccess);
		Assert.assertFalse("Uuid must not be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(requestedUuid));
	}
	
	@Test
	public void testTransferLongBinaryMeasurementsWithClientOverwrite() throws Exception {
		String uuid = "ClientOverwriteTest";
		BinaryMeasurementsDao<Long> bmd = serverDaoFactory.createLongMeasurementsDao(uuid);
		bmd.open();
		long testValue = Long.MAX_VALUE;
		bmd.getBinaryMeasurements().add(new Long(testValue));
		bmd.close();
		bmd = clientDaoFactory.createLongMeasurementsDao(uuid);
		bmd.open();
		bmd.close();
		TransferLongBinaryMeasurementsRequest transfer = new TransferLongBinaryMeasurementsRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = transfer.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
		bmd.open();
		Assert.assertEquals("Size of transferred data set mismatches.", 1, bmd.getBinaryMeasurements().size());
		Assert.assertEquals("Value in data set must remain the same.", (Long) testValue, (Long) bmd.getBinaryMeasurements().get(0));
	}
	
	@Test
	public void testTransferLongBinaryMeasurementsSize0() throws Exception {
		testTransferLongBinaryMeasurementsSizeX(0);
	}

	@Test
	public void testTransferLongBinaryMeasurementsSize1() throws Exception {
		testTransferLongBinaryMeasurementsSizeX(1);
	}

	@Test
	public void testTransferLongBinaryMeasurementsSizeDefaultChunkMinusOne() throws Exception {
		testTransferLongBinaryMeasurementsSizeX(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE-1);
	}

	@Test
	public void testTransferLongBinaryMeasurementsSizeDefaultChunk() throws Exception {
		testTransferLongBinaryMeasurementsSizeX(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE);
	}

	@Test
	public void testTransferLongBinaryMeasurementsSizeDefaultChunkPlusTwo() throws Exception {
		testTransferLongBinaryMeasurementsSizeX(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE+2);
	}

	@Test
	public void testTransferLongBinaryMeasurementsSizeFourTimesDefaultChunkPlusTwo() throws Exception {
		testTransferLongBinaryMeasurementsSizeX(4*BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE+2);
	}
	
	/**Transfers a specified number of measurements.
	 * First, the measurements are created. Second, transfer is started. Last, the transferred 
	 * data is compared.
	 * @param sizeX Number of measurements to create and transfer.
	 * @throws Exception Any error (there should not be one)
	 */
	@SuppressWarnings("unchecked")
	private void testTransferLongBinaryMeasurementsSizeX(int sizeX) throws Exception {
		String uuid = "0815test_size" + sizeX;
		BinaryMeasurementsDao<Long> bmd = serverDaoFactory.createLongMeasurementsDao(uuid);
		bmd.open();
		Long[] expected = createMeasurements(bmd.getBinaryMeasurements(), sizeX);
		bmd.close();
		TransferLongBinaryMeasurementsRequest transfer = new TransferLongBinaryMeasurementsRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = transfer.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
		bmd = (BinaryMeasurementsDao<Long>) clientDaoFactory.getDaoRegistry().getEdp2Dao(uuid);
		bmd.open();
		Assert.assertEquals("Size of transferred data set mismatches.", sizeX, bmd.getBinaryMeasurements().size());
		for (int i = 0; i < sizeX; i++) {
			Assert.assertEquals("Value in data set must remain the same.", expected[i], bmd.getBinaryMeasurements().get(i));
		}
	}

	/**Creates the requested number of measurements.
	 * @param binaryMeasurements the measurements DAO to add all measurements.
	 * @param numberOfMeasurements  Specifies how many measurements are created.
	 * @return The created measurements themselves.
	 */
	private Long[] createMeasurements(
			BinaryMeasurements<Long> binaryMeasurements, int numberOfMeasurements) {
		Long[] result = new Long[numberOfMeasurements];
		for (int i = 0; i < numberOfMeasurements; i++) {
			result[i] = (long) (i + 1);
			binaryMeasurements.add(result[i]);
		}
		return result;
	}
}
