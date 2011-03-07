/**
 * 
 */
package de.uka.ipd.sdq.edp2.internal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ExperimentDataPackageImpl;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.impl.EmfModelXMIResourceFactoryImpl;

/**Utility functions to serialize and deserialize data.
 * @author groenda
 *
 */
public class SerializationUtil {
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(SerializationUtil.class.getCanonicalName());

	/**Serializes an object to a string.
	 * @param o The object to store.
	 * @return String containing the serialized object.
	 * @throws IOException Error occurred during serialization.
	 */
	public static String writeObject(Object o) {
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bas);
			oos.writeObject(o);
			oos.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE,
					"Could not serialize object to string. Data corruption is likely. "
							+ "Object: " + o + "Error: " + e.getMessage());
		}
		return Base64.encodeBase64String(bas.toByteArray());
	}
	
	/**Deserialized an object from a string.
	 * @param bis The input string containing the object.
	 * @return The deserialized object.
	 * @throws IOException Error occurred during serialization.
	 * @throws ClassNotFoundException Error occurred during serialization.
	 */
	public static Object readObject(String input) {
		Object o = null;
		try {
			ObjectInputStream ois;
			ois = new ObjectInputStream(new ByteArrayInputStream(Base64.decodeBase64(input)));
			o = ois.readObject();
			ois.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE,
					"Could not deserialize object from string. Data corruption is likely. "
							+ "Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,
					"Could not deserialize object from string. No class for object could be found. " +
					"Data corruption is likely. " + "Error: " + e.getMessage());
		}
		return o;
	}

	/**Creates and initializes a resource set for edp2 use.
	 * @return New resource set.
	 */
	public static ResourceSet createResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		EmfModelXMIResourceFactoryImpl resourceFactoryImpl = new EmfModelXMIResourceFactoryImpl(); 
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(
						EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION,
					resourceFactoryImpl);
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(
						EmfModelXMIResourceFactoryImpl.EDP2_DESCRIPTIONS_EXTENSION,
						resourceFactoryImpl);
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(
						EmfModelXMIResourceFactoryImpl.EDP2_NOMINALMEASUREMENTS_EXTENSION,
						resourceFactoryImpl);
		resourceSet.getPackageRegistry().put(ExperimentDataPackageImpl.eNS_URI, ExperimentDataPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(RepositoryPackage.eNS_URI, RepositoryPackage.eINSTANCE);
		return resourceSet;
	}
}
