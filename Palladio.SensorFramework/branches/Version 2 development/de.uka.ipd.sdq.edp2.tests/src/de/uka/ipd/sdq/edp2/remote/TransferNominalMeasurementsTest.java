/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote;

import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import de.uka.ipd.sdq.edp2.ExperimentGroupDao;
import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.CategoryIdentifier;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure;
import de.uka.ipd.sdq.edp2.models.emfmodel.ObservedCategory;
import de.uka.ipd.sdq.edp2.remote.client.TransferExperimentGroupRequest;
import de.uka.ipd.sdq.edp2.remote.client.TransferNominalMeasurementsRequest;

/** Test the remote transfer of NominalMeasurements.
 * @author groenda
 */
public class TransferNominalMeasurementsTest extends GenericTransferTest {

	@Test
	public void testTransferNominalMeasurementsWithWrongUuid() throws Exception {
		String requestedUuid = "non-existing uuid";
		TransferNominalMeasurementsRequest transfer = new TransferNominalMeasurementsRequest(
				channel, requestedUuid, clientDaoFactory);
		Boolean transferSuccess = transfer.send();
		Assert.assertFalse(
				"Transfer of non-exisiting UUID must not be successful.",
				transferSuccess);
		Assert.assertFalse("Uuid must not be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(requestedUuid));
	}

	@Test
	public void testTransferNominalMeasurementsWithClientOverwrite()
			throws Exception {
		String uuid = "ClientOverwriteTest";
		NominalMeasurementsDao nmd = clientDaoFactory
				.createNominalMeasurementsDao(uuid);
		nmd.open();
		nmd.close();
		nmd = serverDaoFactory.createNominalMeasurementsDao(uuid);
		nmd.open();
		nmd.close();
		TransferNominalMeasurementsRequest request = new TransferNominalMeasurementsRequest(
				channel, uuid, clientDaoFactory);
		Boolean transferSuccess = request.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));
	}

	@Test
	public void testTransferNominalMeasurementsSize0() throws Exception {
		testTransferNominalMeasurementsSizeX(0);
	}

	@Test
	public void testTransferNominalMeasurementsSize1() throws Exception {
		testTransferNominalMeasurementsSizeX(1);
	}

	@Test
	public void testTransferNominalMeasurementsSize30000() throws Exception {
		testTransferNominalMeasurementsSizeX(30000);
	}

	/**
	 * Transfers a specified number of measurements. First, the measurements are
	 * created. Second, transfer is started. Last, the transferred data is
	 * compared.
	 * 
	 * @param sizeX
	 *            Number of measurements to create and transfer.
	 * @throws Exception
	 *             Any error (there should not be one)
	 */
	private void testTransferNominalMeasurementsSizeX(int sizeX)
			throws Exception {
		String egUuid = "testExperimentGroup_" + EcoreUtil.generateUUID();
		String uuid = "testNominalMeasurements_size" + sizeX + "_"
				+ EcoreUtil.generateUUID();
		// create on server
		// build ExperimentGroup and NominalMeasure
		ExperimentGroupDao egd = serverDaoFactory
				.createExperimentGroupDao(egUuid);
		egd.open();
		ExperimentGroup eg = egd.getExperimentGroup();
		// eg.setId(egUuid);
		EmfmodelFactory emfFactory = EmfmodelFactory.eINSTANCE;
		NominalMeasure measure = emfFactory.createNominalMeasure();
		CategoryIdentifier[] ci = new CategoryIdentifier[3];
		ci[0] = emfFactory.createCategoryIdentifier();
		ci[0].setStateLiteral("State 1");
		measure.getDefinedCategoryIdentifiers().add(ci[0]);
		ci[1] = emfFactory.createCategoryIdentifier();
		ci[1].setStateLiteral("State 2");
		measure.getDefinedCategoryIdentifiers().add(ci[1]);
		ci[2] = emfFactory.createCategoryIdentifier();
		ci[2].setStateLiteral("State 3");
		measure.getDefinedCategoryIdentifiers().add(ci[2]);
		measure.setInitialState(ci[2]);
		eg.getMeasure().add(measure);
		egd.close();
		// Set NominalMeasurmentsDao information
		NominalMeasurementsDao nmd = serverDaoFactory
				.createNominalMeasurementsDao(uuid);
		nmd.open();
		ObservedCategory oc;
		for (int i = 0; i < sizeX; i++) {
			oc = emfFactory.createObservedCategory();
			oc.setCategoryIdentifier(ci[i%3]);
			Assert.assertTrue("Adding Nominal Measurement failed. Number = " + i, nmd.getNominalMeasurements().getObservedCategories().add(oc));
		}
		Assert.assertEquals("Number of constructed measurements is not right.",
				sizeX, nmd.getNominalMeasurements().getObservedCategories()
						.size());
		nmd.close();

		// transfer
		TransferExperimentGroupRequest egRequest = new TransferExperimentGroupRequest(
				channel, egUuid, clientDaoFactory);
		Boolean transferSuccess = egRequest.send();
		Assert.assertTrue(
				"Transfer of referenced ExperimentGroup must be successful.",
				transferSuccess);
		TransferNominalMeasurementsRequest request = new TransferNominalMeasurementsRequest(
				channel, uuid, clientDaoFactory);
		transferSuccess = request.send();
		Assert.assertTrue("Transfer must be successful.", transferSuccess);
		Assert.assertTrue("Uuid must be registered on client.", clientDaoFactory
				.getDaoRegistry().isRegistered(uuid));

		// check contents
		egd = (ExperimentGroupDao) clientDaoFactory.getDaoRegistry()
				.getEdp2Dao(egUuid);
		egd.open();
		eg = egd.getExperimentGroup();
		Assert
				.assertEquals(
						"ExperimentGroup transfer did not transfer the CategoryIndentifiers correctly.",
						3, ((NominalMeasure) eg.getMeasure().get(0))
								.getDefinedCategoryIdentifiers().size());
		ci = new CategoryIdentifier[3];
		ci[0] = ((NominalMeasure) eg.getMeasure().get(0))
				.getDefinedCategoryIdentifiers().get(0);
		ci[1] = ((NominalMeasure) eg.getMeasure().get(0))
				.getDefinedCategoryIdentifiers().get(1);
		ci[2] = ((NominalMeasure) eg.getMeasure().get(0))
				.getDefinedCategoryIdentifiers().get(2);
		egd.close();

		nmd = (NominalMeasurementsDao) clientDaoFactory.getDaoRegistry()
				.getEdp2Dao(uuid);
		nmd.open();
		Assert.assertEquals("Size of transferred data set mismatches.", sizeX,
				nmd.getNominalMeasurements().getObservedCategories().size());
		Iterator<ObservedCategory> listIterator = nmd.getNominalMeasurements().getObservedCategories().iterator();
		int i = 0;
		while (listIterator.hasNext()) {
			oc = listIterator.next();
			Assert.assertEquals("Value in data set must remain the same.",
					ci[i % 3].getUuid(), oc.getCategoryIdentifier().getUuid());
			Assert.assertEquals("Value in data set must remain the same.",
					ci[i % 3].getStateLiteral(), oc.getCategoryIdentifier().getStateLiteral());
			i++;
		}
	}
}
