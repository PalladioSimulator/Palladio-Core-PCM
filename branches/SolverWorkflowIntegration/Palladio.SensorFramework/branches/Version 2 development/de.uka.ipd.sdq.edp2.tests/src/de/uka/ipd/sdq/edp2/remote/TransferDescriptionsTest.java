/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote;

import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.DescriptionsDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType;
import de.uka.ipd.sdq.edp2.models.emfmodel.DataType;
import de.uka.ipd.sdq.edp2.models.emfmodel.Description;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.MetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.MetricSetDescription;
import de.uka.ipd.sdq.edp2.remote.client.TransferDescriptionsRequest;

/** Test the remote transfer of Descriptions.
 * @author groenda
 */
public class TransferDescriptionsTest extends GenericTransferTest {

	@Test
	public void testTransferDescriptionsWithWrongUuid() throws Exception {
		String requestedUuid = "non-existing uuid";
		TransferDescriptionsRequest transfer = new TransferDescriptionsRequest(
				channel, requestedUuid, clientDaoFactory);
		Boolean transferSuccess = transfer.send();
		Assert.assertFalse(
				"Transfer of non-exisiting UUID must not be successful.",
				transferSuccess);
		Assert.assertFalse("Uuid must not be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(requestedUuid));
	}

	@Test
	public void testTransferDescriptionsWithClientOverwrite()
			throws Exception {
		String uuid = "ClientOverwriteTest";
		DescriptionsDao descDao = clientDaoFactory
				.createDescriptionsDao(uuid);
		descDao.open();
		descDao.close();
		descDao = serverDaoFactory.createDescriptionsDao(uuid);
		descDao.open();
		descDao.close();
		TransferDescriptionsRequest request = new TransferDescriptionsRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = request.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
	}

	@Test
	public void testTransferDescriptionsSize0() throws Exception {
		testTransferDescriptionsSizeX(0);
	}

	@Test
	public void testTransferDescriptionsSize1() throws Exception {
		testTransferDescriptionsSizeX(1);
	}

	@Test
	public void testTransferDescriptionsSize50() throws Exception {
		testTransferDescriptionsSizeX(50);
	}

	/**
	 * Transfers a specified number of Descriptions. First, the descriptions are
	 * created. Second, transfer is started. Last, the transferred descriptions are
	 * compared.
	 * 
	 * @param sizeX
	 *            Number of descriptions to create and transfer.
	 * @throws Exception
	 *             Any error (there should not be one)
	 */
	private void testTransferDescriptionsSizeX(int sizeX)
			throws Exception {
		String uuid = "testDescriptions_size" + sizeX + "_"
				+ EcoreUtil.generateUUID();
		EmfmodelFactory emfFactory = EmfmodelFactory.eINSTANCE;
		// create on server
		DescriptionsDao descDao = serverDaoFactory.createDescriptionsDao(uuid);
		descDao.open();
		Description desc;
		String[] createdUuids = new String[sizeX];
		String[] createdTextualDescriptions = new String[sizeX];
		for (int i = 0; i < sizeX; i++) {
			if (i % 3 == 0) {
				AggregationFunctionDescription afd = emfFactory.createAggregationFunctionDescription();
				afd.setName("Aggregation Function Number " + i);
				desc = afd;
			} else
			if (i % 3 == 1) {
				BaseMetricDescription bmd = emfFactory.createBaseMetricDescription();
				bmd.setName("Base Metric Number " + i);
				bmd.setCaptureType(CaptureType.NATURAL_NUMBER);
				bmd.setDataType(DataType.QUANTITATIVE);
				desc = bmd;
			} else { // i % 3 == 2
				MetricSetDescription msd = emfFactory.createMetricSetDescription();
				msd.setName("Metric Set Number " + i);
				msd.getSubsumedMetrics().add(
						(MetricDescription) descDao.getDescriptions()
								.getDescription().get(1));
				desc = msd;
			}
			desc.setTextualDescription("Description of " + desc.getName());
			createdUuids[i] = desc.getUuid();
			createdTextualDescriptions[i] = desc.getTextualDescription();
			Assert.assertTrue("Adding Description failed. Number = " + i, descDao.getDescriptions().getDescription().add(desc));
		}
		Assert.assertEquals("Number of constructed descriptions is not right.",
				sizeX, descDao.getDescriptions().getDescription().size());
		descDao.close();

		// transfer
		TransferDescriptionsRequest request = new TransferDescriptionsRequest(
				channel, uuid, clientDaoFactory);
		boolean transferSuccess = request.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));

		// check contents
		descDao = (DescriptionsDao) clientDaoFactory.getDaoRegistry()
				.getEdp2Dao(uuid);
		descDao.open();
		Assert.assertEquals("Size of transferred data set mismatches.", sizeX,
				descDao.getDescriptions().getDescription().size());
		Iterator<Description> listIterator = descDao.getDescriptions().getDescription().iterator();
		int i = 0;
		while (listIterator.hasNext()) {
			desc = listIterator.next();
			Assert.assertEquals("UUIDs must remain the same.",
					createdUuids[i], desc.getUuid());
			Assert.assertEquals("Textual descriptions in data set must remain the same.",
					createdTextualDescriptions[i], desc.getTextualDescription());
			i++;
		}
	}
}
