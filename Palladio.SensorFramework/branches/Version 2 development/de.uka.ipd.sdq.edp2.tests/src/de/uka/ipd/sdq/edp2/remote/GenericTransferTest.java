package de.uka.ipd.sdq.edp2.remote;

import java.io.File;
import java.io.IOException;

import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.acceptor.IAcceptor;
import org.eclipse.net4j.channel.IChannel;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.OMPlatform;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import de.uka.ipd.sdq.edp2.DaoFactory;
import de.uka.ipd.sdq.edp2.StorageFactory;
import de.uka.ipd.sdq.edp2.remote.client.Edp2TransferProtocolClientFactory;
import de.uka.ipd.sdq.edp2.remote.server.Edp2TransferProtocolServerFactory;

/**Test the remote transfer of Measurements.
 * Subclass to test the different protocol signals.
 * @author groenda
 */
public abstract class GenericTransferTest {

	/** Container to create and wire the server components. */
	protected static IManagedContainer serverContainer = ContainerUtil
			.createContainer();
	/** Container to create and wire the client components. */
	protected static IManagedContainer clientContainer = ContainerUtil
			.createContainer();
	/** Client side connector to the server. */
	protected static IConnector connector;
	/** Server protocol IP address. */
	protected static String listenOnIp = "0.0.0.0";
	/** Server protocol port. */
	protected static String listenOnPort = "2036";
	/** Client side communication channel. */
	protected static IChannel channel;
	/** Factory to create DAOs. */
	protected static DaoFactory daoFactory;
	
	/** Factory used by the client. */
	protected static StorageFactory clientFactory = new StorageFactory();
	/** DAO file factory used by the client. */
	protected static DaoFactory clientDaoFactory = createFileDaoFactory(clientFactory);
	/** Factory used by the server. */
	protected static StorageFactory serverFactory = new StorageFactory();
	/** DAO file factory used by the server. */
	protected static DaoFactory serverDaoFactory = createFileDaoFactory(serverFactory);

	@BeforeClass
	public static void beforeClass() {
		// Send all traces and logs to the console
		OMPlatform.INSTANCE.setDebugging(false);
//		OMPlatform.INSTANCE.addTraceHandler(PrintTraceHandler.CONSOLE);
//		OMPlatform.INSTANCE.addLogHandler(PrintLogHandler.CONSOLE);
		// prepare OSGI package
		Net4jUtil.prepareContainer(serverContainer);
		TCPUtil.prepareContainer(serverContainer);
		// register server
		serverContainer.registerFactory(new Edp2TransferProtocolServerFactory(
				serverFactory.getDaoRegistry()));
		LifecycleUtil.activate(serverContainer);
		// Start an acceptor / server
		IAcceptor acceptor = (IAcceptor) serverContainer.getElement(
				"org.eclipse.net4j.acceptors", "tcp", listenOnIp + ":"
						+ listenOnPort);
		OM.LOG.info("Accepting connections: " + acceptor);

		Net4jUtil.prepareContainer(clientContainer);
		TCPUtil.prepareContainer(clientContainer);
		// register client
		clientContainer
				.registerFactory(new Edp2TransferProtocolClientFactory());
		// Start connector / client
		connector = (IConnector) clientContainer.getElement(
				"org.eclipse.net4j.connectors", "tcp", listenOnIp + ":"
						+ listenOnPort);
		OM.LOG.info("Client set up.");
	}

	protected static DaoFactory createFileDaoFactory(StorageFactory factory) {
		// Create file Factory
		File tempFile;
		try {
			tempFile = File.createTempFile("delete", "me");
			tempFile.delete();
			if (tempFile.mkdir() == true) {
				tempFile.deleteOnExit();
				daoFactory = factory.createFileDaoFactory(tempFile
						.getAbsoluteFile());
			}
			return daoFactory;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Before
	public void openClient() {
		channel = connector.openChannel(Edp2TransferProtocol.PROTOCOL_NAME,
				null);
	}

	@After
	public void closeClient() {
		channel.close();
	}

	@AfterClass
	public static void afterClass() {
		// shutdown OSGI container
		if (LifecycleUtil.isActive(serverContainer)) {
			LifecycleUtil.deactivate(serverContainer);
			LifecycleUtil.deactivate(clientContainer);
		}
	}

}
