/**
 * 
 */
package de.uka.ipd.sdq.edp2.remote;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.remote.client.ListExperimentGroupsRequest;

/**Tests the remote transfer of the list of experiment groups.
 * @author groenda
 */
public class ListExperimentGroupsTest extends GenericTransferTest {

	@Test
	public void testInitialListEmpty() throws Exception {
		// create some DAOs on the client
		clientDaoFactory.createDoubleMeasurementsDao("test1");
		clientDaoFactory.createExperimentGroupDao("test2");
		clientDaoFactory.createLongMeasurementsDao("test3");
		clientDaoFactory.createNominalMeasurementsDao("test4");
		// check if list of DAOs on server is empty
		ListExperimentGroupsRequest request = new ListExperimentGroupsRequest(channel);
		Set<String> list = request.send();
		Assert.assertEquals(
						"Initial list of registered UUIDs at the server must be empty.",
						0, list.size());
	}
	
	@Test
	public void testListTransfer() throws Exception {
		// create some DAOs on the server
		String[] uuids = { "test1", "test2", "test3", "test4", "test5"};
		serverDaoFactory.createDoubleMeasurementsDao(uuids[0]);
		serverDaoFactory.createDoubleMeasurementsDao(uuids[1]);
		serverDaoFactory.createExperimentGroupDao(uuids[2]);
		serverDaoFactory.createLongMeasurementsDao(uuids[3]);
		serverDaoFactory.createNominalMeasurementsDao(uuids[4]);
		// transfer list
		ListExperimentGroupsRequest request = new ListExperimentGroupsRequest(channel);
		Set<String> list = request.send();
		// check list
		Assert.assertEquals(
						"Number of registered DAOs must not differ after transfer.",
						5, list.size());
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue("UUIDs must be the same after transfer.", list.contains(uuids[i]));
		}
	}
}
