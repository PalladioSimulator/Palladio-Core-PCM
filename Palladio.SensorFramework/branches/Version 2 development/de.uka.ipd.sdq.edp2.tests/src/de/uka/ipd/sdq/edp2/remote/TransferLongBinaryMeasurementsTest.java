package de.uka.ipd.sdq.edp2.remote;

import javax.measure.Measure;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

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
	/** Unit used for measurements. */
	@SuppressWarnings("unchecked")
	protected Unit unit = SI.SECOND;

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
	
	@SuppressWarnings("unchecked")
	@Test
	public void testTransferLongBinaryMeasurementsWithClientOverwrite() throws Exception {
		String uuid = "ClientOverwriteTest";
		BinaryMeasurementsDao<Measure> bmd = serverDaoFactory.createLongMeasurementsDao(uuid);
		bmd.setUnit(unit);
		bmd.open();
		long testValue = Long.MAX_VALUE;
		bmd.getBinaryMeasurements().add(Measure.valueOf(testValue, unit));
		bmd.close();
		bmd = clientDaoFactory.createLongMeasurementsDao(uuid);
		bmd.setUnit(unit);
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
		Assert.assertEquals("Value in data set must remain the same.", (Long) testValue, (Long) bmd.getBinaryMeasurements().get(0).longValue(unit));
		Assert.assertEquals("Units must be equal after transfer.", unit.toString(), bmd.getUnit().toString());
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
		BinaryMeasurementsDao<Measure> bmd = serverDaoFactory.createLongMeasurementsDao(uuid);
		bmd.setUnit(unit);
		bmd.open();
		Long[] expected = createMeasurements(bmd.getBinaryMeasurements(), sizeX);
		bmd.close();
		TransferLongBinaryMeasurementsRequest transfer = new TransferLongBinaryMeasurementsRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = transfer.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
		bmd = (BinaryMeasurementsDao<Measure>) clientDaoFactory.getDaoRegistry().getEdp2Dao(uuid);
		bmd.open();
		Assert.assertEquals("Size of transferred data set mismatches.", sizeX, bmd.getBinaryMeasurements().size());
		for (int i = 0; i < sizeX; i++) {
			Assert.assertEquals("Value in data set must remain the same.", (long) expected[i], bmd.getBinaryMeasurements().get(i).longValue(unit));
		}
	}

	/**Creates the requested number of measurements.
	 * @param binaryMeasurements the measurements DAO to add all measurements.
	 * @param numberOfMeasurements  Specifies how many measurements are created.
	 * @return The created measurements themselves.
	 */
	@SuppressWarnings("unchecked")
	private Long[] createMeasurements(
			BinaryMeasurements<Measure> binaryMeasurements, int numberOfMeasurements) {
		Long[] result = new Long[numberOfMeasurements];
		for (int i = 0; i < numberOfMeasurements; i++) {
			result[i] = (long) (i + 1);
			binaryMeasurements.add(Measure.valueOf(result[i], unit));
		}
		return result;
	}
}
