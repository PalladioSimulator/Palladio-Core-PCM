/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote;

import junit.framework.Assert;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.ExperimentGroupDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting;
import de.uka.ipd.sdq.edp2.remote.client.TransferExperimentGroupRequest;

/**
 * Test the remote transfer of ExperimentGroup.
 * 
 * @author groenda
 */
public class TransferExperimentGroupTest extends GenericTransferTest {
	@Test
	public void testTransferExperimentGroupWithWrongUuid() throws Exception {
		String requestedUuid = "non-existing uuid";
		TransferExperimentGroupRequest transfer = new TransferExperimentGroupRequest(
				channel, requestedUuid, clientDaoFactory);
		Boolean transferSuccess = transfer.send();
		Assert.assertFalse(
				"Transfer of non-exisiting UUID must not be successful.",
				transferSuccess);
		Assert.assertFalse("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(requestedUuid));
	}

	@Test
	public void testTransferExperimentGroupWithClientOverwrite()
			throws Exception {
		String uuid = "ClientOverwriteTest";
		ExperimentGroupDao egd = clientDaoFactory
				.createExperimentGroupDao(uuid);
		egd.open();
		egd.close();
		egd = serverDaoFactory.createExperimentGroupDao(uuid);
		egd.open();
		egd.close();
		TransferExperimentGroupRequest request = new TransferExperimentGroupRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = request.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
	}

	@Test
	public void testTransferExperimentGroupSize0() throws Exception {
		String uuid = EcoreUtil.generateUUID();
		@SuppressWarnings("unused")
		ExperimentGroupDao egd = serverDaoFactory
				.createExperimentGroupDao(uuid);
		TransferExperimentGroupRequest request = new TransferExperimentGroupRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = request.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
	}

	@Test
	public void testTransferExperimentGroupSize1() throws Exception {
		String uuid = EcoreUtil.generateUUID();
		ExperimentGroupDao egd = serverDaoFactory
				.createExperimentGroupDao(uuid);
		egd.open();
		ExperimentGroup eg = egd.getExperimentGroup();
		ExperimentSetting es = EmfmodelFactory.eINSTANCE
				.createExperimentSetting();
		String experimentName = "Experiment Name 1";
		es.setExperimentName(experimentName);
		eg.getExperimentSettings().add(es);
		egd.close();
		// check transfer
		TransferExperimentGroupRequest request = new TransferExperimentGroupRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = request.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
		// check content
		egd = (ExperimentGroupDao) clientDaoFactory.getDaoRegistry()
				.getEdp2Dao(uuid);
		egd.open();
		eg = egd.getExperimentGroup();
		es = eg.getExperimentSettings().get(0);
		Assert
				.assertEquals(
						"Name of ExperimentSetting within ExperimentGroup must stay the same.",
						experimentName, es.getExperimentName());
		egd.close();
	}

}
