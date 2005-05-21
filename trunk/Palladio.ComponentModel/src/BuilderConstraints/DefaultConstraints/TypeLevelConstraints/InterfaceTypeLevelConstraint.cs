using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.BuilderConstraints.DefaultConstraints.TypeLevelConstraints
{

	/// <summary>
	/// Default constraints for interfaces at the type level. This constraints are used always
	/// as they are the neccessary for a valid and consistent static structure of the component model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.3  2005/05/21 17:13:40  kelsaka
	/// - removed unused using statements
	///
	/// Revision 1.2  2005/05/21 17:12:17  kelsaka
	/// - added new exception for use with signatures
	/// - finished adding constraints for the type level
	///
	/// Revision 1.1  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// </pre>
	/// </remarks>
	public class InterfaceTypeLevelConstraint : IInterfaceTypeLevelBuilder
	{
		#region data
		
		private IInterfaceTypeLevelBuilder interfaceBuilderSuccessor;
		private IModelDataManager modelDataManager;
		private IInterface iInterface;

		#endregion

		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="modelDataManager">The model data manager to use for executing e. g. queries.</param>
		public InterfaceTypeLevelConstraint(IModelDataManager modelDataManager)
		{
			this.modelDataManager = modelDataManager;
		}

		/// <summary>
		/// Internal constructor.
		/// </summary>
		/// <param name="modelDataManager">The model data manager to use for executing e. g. queries.</param>
		/// <param name="iInterface">The interface this instance is constraint for.</param>
		private InterfaceTypeLevelConstraint(IModelDataManager modelDataManager, IInterface iInterface)
		{
			this.modelDataManager = modelDataManager;
			this.iInterface = iInterface;
		}

		#endregion

		/// <summary>
		/// Adds an existing signature to the actual Interface.
		/// </summary>
		/// <param name="signature">The existing signature.</param>
		public void AddSignature (ISignature signature)
		{
			this.interfaceBuilderSuccessor.AddSignature(signature);
		}

		/// <summary>
		/// Adds a new signature with the given name to the actual Interface.
		/// </summary>
		/// <param name="signatureName">The new signatures name.</param>
		/// <returns>SignatureBuilder</returns>
		public ISignatureTypeLevelBuilder AddSignature (string signatureName)
		{
			return this.interfaceBuilderSuccessor.AddSignature(signatureName);
		}

		/// <summary>
		/// called to remove the signature with given id. 
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		/// <exception cref="SignatureNotFoundException">Thrown if the signature is not
		/// associated to the actual interface.</exception>
		public void RemoveSignature (ISignatureIdentifier signatureID)
		{
			if(!this.modelDataManager.Query.QueryTypeLevel.QueryInterface(this.iInterface
				.InterfaceID).IsSignatureFromInterface(signatureID))
			{
				throw new SignatureNotFoundException(signatureID, this.iInterface.InterfaceID,
					"The signature is not part of this ");
			}
			this.interfaceBuilderSuccessor.RemoveSignature(signatureID);
		}

		/// <summary>
		/// called to add a existing protocol to the actual interfaces.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		public void AddProtocol (IProtocol protocol)
		{
			this.interfaceBuilderSuccessor.AddProtocol(protocol);
		}

		/// <summary>
		/// called to remove the protocol with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		/// <exception cref="EntityNotFoundException">Thrown if the given protocol is not
		/// attached to the actual interface.</exception>
		public void RemoveProtocol (IProtocolIdentifier protocolID)
		{
			if(!this.modelDataManager.Query.QueryTypeLevel.QueryInterface(this.iInterface.InterfaceID)
				.IsProtocolFromInterface(protocolID))
			{
				throw new EntityNotFoundException(protocolID,
					"The given protocol is not associated with the actual component.");
			}
			this.interfaceBuilderSuccessor.RemoveProtocol(protocolID);
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public IInterfaceImplementationLevelBuilder ImplementationLevelBuilder
		{
			get
			{
				return this.interfaceBuilderSuccessor.ImplementationLevelBuilder;
			}
		}

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IInterface Interface
		{
			get
			{
				return this.interfaceBuilderSuccessor.Interface;
			}
		}

		#region constraint-management
		
		/// <summary>
		/// The child builder to call for each method defined in the builder interface.
		/// </summary>
		public IInterfaceTypeLevelBuilder ChildBuilder
		{
			set
			{
				this.interfaceBuilderSuccessor = value;
			}
		}

		/// <summary>
		/// Clones the actual builder / constraints instance except the created / supervised
		/// component model entity.
		/// </summary>
		/// <param name="iInterface">The component model entity that has to be builder /
		/// supervised.</param>
		/// <returns>A copy of the actual builder / constraint.</returns>
		public IInterfaceTypeLevelBuilder Clone (IInterface iInterface)
		{
			return new InterfaceTypeLevelConstraint(modelDataManager, iInterface);
		}

		#endregion
	}
}
