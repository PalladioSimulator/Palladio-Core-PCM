using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;

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
	/// Revision 1.6  2005/06/25 16:54:09  joemal
	/// fix bug in signaturebuilder
	///
	/// Revision 1.5  2005/06/05 10:38:31  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.4  2005/05/25 19:44:54  kelsaka
	/// - optimized usings
	/// - builders are now returning identifiers again
	///
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
	public class InterfaceTypeLevelConstraint : AbstractEntityConstraint,IInterfaceTypeLevelBuilder
	{
		#region data
		
		private IInterfaceTypeLevelBuilder interfaceBuilderSuccessor;

		#endregion

		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		/// <param name="query">the query interface of the componentmodel</param>
		public InterfaceTypeLevelConstraint(IQuery query): base (query)
		{
		}

		/// <summary>
		/// Internal constructor.
		/// </summary>
		/// <param name="query">the query of the componentmodel</param>
		/// <param name="ifaceId">The id of the interface this instance is constraint for.</param>
		private InterfaceTypeLevelConstraint(IInterfaceIdentifier ifaceId,IQuery query) : 
			base(ifaceId, query)
		{
		}

		#endregion

		/// <summary>
		/// Adds an existing signature to the actual Interface.
		/// </summary>
		/// <param name="sigId">The existing signature.</param>
		/// <param name="signatureName">The new signatures name.</param>
		public ISignatureTypeLevelBuilder AddSignature(ISignatureIdentifier sigId, string signatureName)
		{
			return this.interfaceBuilderSuccessor.AddSignature(sigId,signatureName);
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
			if(!this.Query.QueryTypeLevel.QueryInterface(this.InterfaceId).IsSignatureFromInterface(signatureID))
			{
				throw new SignatureNotFoundException(signatureID, this.InterfaceId,"The signature is not part of this ");
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
			if(!this.Query.QueryTypeLevel.QueryInterface(this.InterfaceId).IsProtocolFromInterface(protocolID))
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

		/// <summary>
		/// Accesses the identifier of the actual instance.
		/// </summary>
		public IInterfaceIdentifier InterfaceId
		{
			get
			{
				return this.interfaceBuilderSuccessor.InterfaceId;
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
		/// <remarks>This method should only be used for constraints management.</remarks>
		public IInterfaceTypeLevelBuilder Clone(IInterfaceIdentifier iInterface)
		{
			return new InterfaceTypeLevelConstraint(iInterface, this.Query);
		}

		#endregion
	}
}
