package org.palladiosimulator.protocom.framework.java.ee.storage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.naming.InitialContext;

import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.exceptions.CmisObjectNotFoundException;

/**
 * The EcmProxy class obtains a CMIS session for the SAP HANA Cloud Document Service.
 * Using this class removes the need for references to the SAP HANA Cloud SDK.
 *
 * @author Christian Klaussner
 */
public class EcmProxy {

	/**
	 * Helper method that invokes the method with the specified name on an object.
	 * The formal parameters of the method to invoke are inferred from the arguments.
	 *
	 * @param target the object that the method is invoked on
	 * @param name the name of the method
	 * @param args the arguments of the invocation
	 * @return the result of the invocation
	 * @throws Exception if any exception occurred during the invocation
	 */
	private static Object invoke(Object target, String name, Object... args)
		throws Exception {

		Class<?>[] classes = new Class<?>[args.length];

		for (int i = 0; i < classes.length; i++) {
			classes[i] = args[i].getClass();
		}

		Method method = target.getClass().getMethod(name, classes);

		return method.invoke(target, args);
	}

	/**
	 * Creates a repository in the database of the Document Service.
	 *
	 * @param ecmService the EcmService object
	 * @param name the name of the repository
	 * @param key the key for the repository
	 * @throws Exception if any exception occurred during the repository creation
	 */
	private static void createRepository(Object ecmService, String name, String key)
		throws Exception {

		// Create an options class instance.
		Class<?> optionsClass = Class.forName("com.sap.ecm.api.RepositoryOptions");
		Object options = optionsClass.newInstance();

		// Get the enum field for the desired visibility.
		Class<?> enumClass = Class.forName("com.sap.ecm.api.RepositoryOptions$Visibility");
		Object visibility = enumClass.getField("PROTECTED").get(null);

		// Set the properties and create the repository.
		invoke(options, "setUniqueName", name);
		invoke(options, "setRepositoryKey", key);
		invoke(options, "setVisibility", visibility);

		invoke(ecmService, "createRepository", options);
	}

	/**
	 * Establishes a connection to the repository with the specified name.
	 * This method is a helper method that does not handle exceptions.
	 *
	 * @param name the name of the repository to connect to
	 * @param key the key for the repository to connect to
	 * @return a CMIS session object for the repository
	 * @throws Exception if any exception occurred during the connection
	 */
	private static Session connect(String name, String key) throws Exception {
		Object ecmService;
		Session session;

		InitialContext context = new InitialContext();
		ecmService = context.lookup("java:comp/env/EcmService");

		try {
			session = (Session) invoke(ecmService, "connect", name, key);
		} catch (InvocationTargetException e) {
			if (e.getCause() instanceof CmisObjectNotFoundException) {
				createRepository(ecmService, name, key);
				session = (Session) invoke(ecmService, "connect", name, key);
			} else {
				throw e;
			}
		}

		return session;
	}

	/**
	 * Retrieves a CMIS session object for the repository with the specified name.
	 *
	 * @param name the name of the repository to connect to
	 * @param key the key for the repository to connect to
	 * @return a CMIS session object for the repository
	 */
	public static Session getSession(String name, String key) {
		try {
			return connect(name, key);
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}
}
