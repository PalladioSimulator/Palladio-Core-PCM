package de.uka.ipd.sdq.edp2.remote;

import javax.measure.Measure;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.BinaryMeasurementsDao;
import de.uka.ipd.sdq.edp2.file.impl.BackgroundMemoryListImpl;
import de.uka.ipd.sdq.edp2.models.binary.BinaryMeasurements;
import de.uka.ipd.sdq.edp2.remote.client.TransferDoubleBinaryMeasurementsRequest;

/**
 * Test the remote transfer of DoubleBinaryMeasurements.
 * 
 * @author groenda
 */
public class TransferDoubleBinaryMeasurementsTest extends GenericTransferTest {
	/** Unit used for measurements. */
	@SuppressWarnings("unchecked")
	protected Unit unit = SI.SECOND;

	@Test
	public void testTransferDoubleBinaryMeasurementsWithWrongUuid()
			throws Exception {
		String requestedUuid = "non-existing uuid";
		TransferDoubleBinaryMeasurementsRequest transfer = new TransferDoubleBinaryMeasurementsRequest(
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
	public void testTransferDoubleBinaryMeasurementsWithClientOverwrite() throws Exception {
		String uuid = "ClientOverwriteTest";
		BinaryMeasurementsDao<Measure> bmd = serverDaoFactory.createDoubleMeasurementsDao(uuid);
		bmd.setUnit(unit);
		bmd.open();
		double testValue = 1.02;
		bmd.getBinaryMeasurements().add(Measure.valueOf(testValue, unit));
		bmd.close();
		bmd = clientDaoFactory.createDoubleMeasurementsDao(uuid);
		bmd.setUnit(unit);
		bmd.open();
		bmd.close();
		TransferDoubleBinaryMeasurementsRequest transfer = new TransferDoubleBinaryMeasurementsRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = transfer.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
		bmd.open();
		Assert.assertEquals("Size of transferred data set mismatches.", 1, bmd.getBinaryMeasurements().size());
		Assert.assertEquals("Value in data set must remain the same.", testValue, bmd.getBinaryMeasurements().get(0).doubleValue(unit));
		Assert.assertEquals("Units must be equal after transfer.", unit.toString(), bmd.getUnit().toString());
	}
	
	@Test
	public void testTransferDoubleBinaryMeasurementsSize0() throws Exception {
		testTransferDoubleBinaryMeasurementsSizeX(0);
	}

	@Test
	public void testTransferDoubleBinaryMeasurementsSize1() throws Exception {
		testTransferDoubleBinaryMeasurementsSizeX(1);
	}

	@Test
	public void testTransferDoubleBinaryMeasurementsSizeDefaultChunkMinusOne() throws Exception {
		testTransferDoubleBinaryMeasurementsSizeX(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE-1);
	}

	@Test
	public void testTransferDoubleBinaryMeasurementsSizeDefaultChunk() throws Exception {
		testTransferDoubleBinaryMeasurementsSizeX(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE);
	}

	@Test
	public void testTransferDoubleBinaryMeasurementsSizeDefaultChunkPlusTwo() throws Exception {
		testTransferDoubleBinaryMeasurementsSizeX(BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE+2);
	}

	@Test
	public void testTransferDoubleBinaryMeasurementsSizeFourTimesDefaultChunkPlusTwo() throws Exception {
		testTransferDoubleBinaryMeasurementsSizeX(4*BackgroundMemoryListImpl.DEFAULT_CHUNK_SIZE+2);
	}
	
	/**Transfers a specified number of measurements.
	 * First, the measurements are created. Second, transfer is started. Last, the transferred 
	 * data is compared.
	 * @param sizeX Number of measurements to create and transfer.
	 * @throws Exception Any error (there should not be one)
	 */
	@SuppressWarnings("unchecked")
	private void testTransferDoubleBinaryMeasurementsSizeX(int sizeX) throws Exception {
		String uuid = "0815test_size" + sizeX;
		BinaryMeasurementsDao<Measure> bmd = serverDaoFactory.createDoubleMeasurementsDao(uuid);
		bmd.setUnit(unit);
		bmd.open();
		Double[] expected = createMeasurements(bmd.getBinaryMeasurements(), sizeX);
		bmd.close();
		TransferDoubleBinaryMeasurementsRequest transfer = new TransferDoubleBinaryMeasurementsRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = transfer.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
		bmd = (BinaryMeasurementsDao<Measure>) clientDaoFactory.getDaoRegistry().getEdp2Dao(uuid);
		bmd.open();
		Assert.assertEquals("Size of transferred data set mismatches.", sizeX, bmd.getBinaryMeasurements().size());
		for (int i = 0; i < sizeX; i++) {
			Assert.assertEquals("Value in data set must remain the same.", expected[i], bmd.getBinaryMeasurements().get(i).doubleValue(unit));
		}
	}

	/**Creates the requested number of measurements.
	 * @param binaryMeasurements the measurements DAO to add all measurements.
	 * @param numberOfMeasurements  Specifies how many measurements are created.
	 * @return The created measurements themselves.
	 */
	@SuppressWarnings("unchecked")
	private Double[] createMeasurements(
			BinaryMeasurements<Measure> binaryMeasurements, int numberOfMeasurements) {
		Double[] result = new Double[numberOfMeasurements];
		for (int i = 0; i < numberOfMeasurements; i++) {
			result[i] = i+1.0;
			binaryMeasurements.add(Measure.valueOf(result[i], unit));
		}
		return result;
	}
}
