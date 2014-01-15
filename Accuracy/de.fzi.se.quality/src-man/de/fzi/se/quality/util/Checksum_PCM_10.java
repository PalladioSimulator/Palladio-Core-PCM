/**
 * 
 */
package de.fzi.se.quality.util;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.ServiceSpecification;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.util.RepositorySwitch;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**
 * Checksum calculation algorithm for PCM.
 * 
 * @author groenda
 * @version 1.0
 * 
 */
public class Checksum_PCM_10 implements SpecificationChecksumCalculator {
	/** Logger for this class. */
	public static final Logger logger = Logger.getLogger(Checksum_PCM_10.class.getCanonicalName());
	/** Identifier for version 1.0 of the PCM checksum calculation algorithm. */
	public static final String CHECKSUM_PCM_10_IDENTIFIER = "PCM 1.0";
	/**
	 * Separator character for the same hierarchy level. Improves readability
	 * for humans. Technically not necessary.
	 */
	protected static final String SEPARATOR = "_";
	/**
	 * Separator character for the opening a new hierarchy level. Improves
	 * readability for humans. Technically not necessary.
	 */
	protected static final String SEPARATOR_HIERARCHY_START = "(";
	/**
	 * Separator character for closing a hierarchy level. Improves readability
	 * for humans. Technically not necessary.
	 */
	protected static final String SEPARATOR_HIERARCHY_END = ")";

	/** String converter for data types. */
	private final DataTypeConverter dataTypeConverter = new DataTypeConverter();

	@Override
	public void update(ServiceSpecification specification) {
		Long checksum = calculate(specification);
		specification.setChecksum(checksum);
		specification.setChecksumAlg(CHECKSUM_PCM_10_IDENTIFIER);
	}
	
	@Override
	public long calculate(ServiceSpecification specification) {
		if (!(specification instanceof PCMServiceSpecification)) {
			throw new IllegalArgumentException(
					"This algorithm can only calculate checksums for PCM service specifications. The provided specification type must be PCMServiceSpecification.");
		}
		Checksum checksum = new CRC32();
		checksum.reset();
		ResourceDemandingSEFF rdseff = ((PCMServiceSpecification) specification)
				.getResourceDemandingSEFF();
		// Provided interface must stay the same
		updateChecksumWithSignature(checksum,
				rdseff.getDescribedService__SEFF());
		// Component parameter and component parameter must stay the same
		for (VariableUsage usage : rdseff
				.getBasicComponent_ServiceEffectSpecification()
				.getComponentParameterUsage_ImplementationComponentType()) {
			updateChecksum(checksum,
					"ComponentParameter" + PCMUtil.getQualifiedName(usage));
		}
		for (PassiveResource passiveResource : rdseff
				.getBasicComponent_ServiceEffectSpecification()
				.getPassiveResource_BasicComponent()) {
			updateChecksum(checksum, passiveResource.eClass().getName()
					+ SEPARATOR + passiveResource.getId() + SEPARATOR
					+ passiveResource.getEntityName());
		}
		// Required interface identifiers and operation parameters must stay the
		// same
		for (RequiredRole requiredRole : rdseff
				.getBasicComponent_ServiceEffectSpecification()
				.getRequiredRoles_InterfaceRequiringEntity()) {
			updateChecksum(checksum, requiredRole.eClass().getName()
					+ SEPARATOR + requiredRole.getId());
			if (requiredRole instanceof OperationRequiredRole) {
				OperationRequiredRole operationRequiredRole = (OperationRequiredRole) requiredRole;
				updateChecksum(checksum, SEPARATOR
						+ operationRequiredRole
								.getRequiredInterface__OperationRequiredRole()
								.getId() + SEPARATOR_HIERARCHY_START);
				for (Signature signature : operationRequiredRole
						.getRequiredInterface__OperationRequiredRole()
						.getSignatures__OperationInterface()) {
					updateChecksumWithSignature(checksum, signature);
				}
				updateChecksum(checksum, SEPARATOR_HIERARCHY_END);
			} else if (requiredRole instanceof InfrastructureRequiredRole) {
				InfrastructureRequiredRole infrastructureRequiredRole = (InfrastructureRequiredRole) requiredRole;
				updateChecksum(
						checksum,
						SEPARATOR
								+ infrastructureRequiredRole
										.getRequiredInterface__InfrastructureRequiredRole()
										.getId() + SEPARATOR_HIERARCHY_START);
				for (Signature signature : infrastructureRequiredRole
						.getRequiredInterface__InfrastructureRequiredRole()
						.getInfrastructureSignatures__InfrastructureInterface()) {
					updateChecksumWithSignature(checksum, signature);
				}
				updateChecksum(checksum, SEPARATOR_HIERARCHY_END);
			} else {
				throw new IllegalArgumentException(
						"Required roles of the component containing the specification may only have operation and infrastructure required roles. Experienced role was:"
								+ requiredRole.eClass().getName());
			}
		}
		for (ResourceRequiredRole rrRole : rdseff
				.getBasicComponent_ServiceEffectSpecification()
				.getResourceRequiredRoles__ResourceInterfaceRequiringEntity()) {
			updateChecksum(checksum, SEPARATOR + rrRole.getId()
					+ SEPARATOR_HIERARCHY_START);
			for (ResourceSignature resourceSignature : rrRole
					.getRequiredResourceInterface__ResourceRequiredRole()
					.getResourceSignatures__ResourceInterface()) {
				updateChecksumWithSignature(checksum, resourceSignature);
			}
			updateChecksum(checksum, SEPARATOR_HIERARCHY_END);
		}
		// Specified behavior must stay the same
		ActionChecksumSwitch checksumSwitch = new ActionChecksumSwitch(checksum);
		checksumSwitch.doSwitch(rdseff);
		return checksum.getValue();
	}

	/**
	 * Updates the checksum with details about the signatures.
	 * 
	 * @param checksum
	 *            The checksum.
	 * @param signature
	 *            The signature.
	 */
	protected void updateChecksumWithSignature(Checksum checksum,
			Signature signature) {
		if (signature instanceof OperationSignature) {
			OperationSignature operationSignature = (OperationSignature) signature;
			for (Parameter parameter : operationSignature
					.getParameters__OperationSignature()) {
				updateChecksum(
						checksum,
						parameter.getParameterName()
								+ SEPARATOR
								+ dataTypeConverter.getUniqueIdentifier(parameter
										.getDataType__Parameter()));
			}
			if (operationSignature.getReturnType__OperationSignature() != null) {
				updateChecksum(checksum,
						dataTypeConverter.getUniqueIdentifier(operationSignature
								.getReturnType__OperationSignature()));
			}
		} else if (signature instanceof InfrastructureSignature) {
			for (Parameter parameter : ((InfrastructureSignature) signature)
					.getParameters__InfrastructureSignature()) {
				updateChecksum(
						checksum,
						parameter.getParameterName()
								+ SEPARATOR
								+ dataTypeConverter.getUniqueIdentifier(parameter
										.getDataType__Parameter()));
			}
		} else {
			throw new IllegalArgumentException(
					"Only signature of operation and infrastructure interfaces can be processed. Provided type was: "
							+ signature.eClass().getName());
		}
	}

	/**
	 * Updates the checksum with details about the signatures.
	 * 
	 * @param checksum
	 *            The checksum.
	 * @param signature
	 *            The signature.
	 */
	protected void updateChecksumWithSignature(Checksum checksum,
			ResourceSignature signature) {
		updateChecksum(checksum,
				Integer.toString(signature.getResourceServiceId()) + SEPARATOR);
		if (signature.getParameter__ResourceSignature() != null) {
			for (Parameter parameter : signature.getParameter__ResourceSignature()) {
				updateChecksum(
						checksum,
						parameter.getParameterName()
								+ SEPARATOR
								+ dataTypeConverter.getUniqueIdentifier(parameter
										.getDataType__Parameter()));
			}
		}
	}

	@Override
	public String identify() {
		return CHECKSUM_PCM_10_IDENTIFIER;
	}

	/**
	 * Updates checksum with the given string.
	 * 
	 * @param checksum
	 *            Checksum generator and storage.
	 * @param string
	 *            String used to update the checksum.
	 */
	public static void updateChecksum(Checksum checksum, String string) {
		byte[] byteArray = string.getBytes();
		checksum.update(byteArray, 0, byteArray.length);
	}

	
	/**
	 * Converts data types to strings for the checksum calculations. Unique
	 * identifiers and names are included.
	 * 
	 * @author groenda
	 * 
	 */
	private class DataTypeConverter extends RepositorySwitch<String> {
		/** List of data types handled in a conversion. Allows to track recursive definitions. */
		protected ArrayList<DataType> handledDataTypes;
		
		/**Calculates and returns the unique string for the data type.
		 * @param dataType The data type.
		 * @return The unique string.
		 */
		public String getUniqueIdentifier(DataType dataType) {
			handledDataTypes = new ArrayList<DataType>();
			return doSwitch(dataType);
		}
				
		@Override
		public String caseCollectionDataType(CollectionDataType object) {
			if (handledDataTypes.contains(object)) {
				return object.eClass().getName() + SEPARATOR + object.getId() + SEPARATOR + object.getEntityName();
			}
			handledDataTypes.add(object);
			String result = object.eClass().getName() + SEPARATOR + object.getId()
					+ SEPARATOR + object.getEntityName()
					+ SEPARATOR_HIERARCHY_START
					+ doSwitch(object.getInnerType_CollectionDataType())
					+ SEPARATOR_HIERARCHY_END;
			handledDataTypes.remove(object);
			return result;
		}

		@Override
		public String caseCompositeDataType(CompositeDataType object) {
			if (handledDataTypes.contains(object)) {
				return object.eClass().getName() + SEPARATOR + object.getId() + SEPARATOR + object.getEntityName();
			}
			handledDataTypes.add(object);
			StringWriter result = new StringWriter();
			result.append(object.eClass().getName() + SEPARATOR
					+ object.getId() + SEPARATOR + object.getEntityName());
			for (InnerDeclaration declaration : object
					.getInnerDeclaration_CompositeDataType()) {
				result.append(SEPARATOR + declaration.getEntityName()
						+ SEPARATOR_HIERARCHY_START
						+ doSwitch(declaration.getDatatype_InnerDeclaration())
						+ SEPARATOR_HIERARCHY_END);
			}
			handledDataTypes.remove(object);
			return result.toString();
		}

		@Override
		public String casePrimitiveDataType(PrimitiveDataType object) {
			handledDataTypes.add(object);
			String result = object.eClass().getName() + SEPARATOR
					+ object.getType().getValue() + SEPARATOR
					+ object.getType().getLiteral();
			handledDataTypes.remove(object);
			return result;
		}

		@Override
		public String caseDataType(DataType object) {
			throw new IllegalArgumentException(
					"The provided data type is not supported by this implementation. The data type was "
							+ object.eClass().getName());
		}
	}

}
