using System;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the Interface builder - methods that are available at all levels.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// Revision 1.3  2005/04/08 15:40:06  kelsaka
	/// - added SignatureBuilder
	/// - fixed bug: some new entities were not added to component model
	///
	/// Revision 1.2  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// Revision 1.1  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractInterfaceBuilder : IInterfaceBuilder
	{
		private ILowLevelBuilder lowLevelBuilder;
		private IInterface iInterface;


		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="iInterface">The interface to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, IInterface iInterface)
		{
			this.lowLevelBuilder = lowLevelBuilder;
			this.iInterface = iInterface;
		}

		/// <summary>
		/// Adds a new signature with the given name to the actual Interface.
		/// </summary>
		/// <param name="signatureName">The new signatures name.</param>
		/// <returns>SignatureBuilder</returns>
		public ISignatureTypeLevelBuilder AddSignature (string signatureName)
		{
			ISignature signature = EntityFactory.CreateSignature(signatureName, new SignatureDescription());
			lowLevelBuilder.AddSignature(signature, this.iInterface.InterfaceID);
			return new DefaultSignatureTypeLevelBuilder(lowLevelBuilder, signature);
		}

		/// <summary>
		/// called to remove the signature with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		public void RemoveSignature (ISignatureIdentifier signatureID)
		{
			lowLevelBuilder.RemoveSignature(signatureID);
		}

		/// <summary>
		/// Adds a new protocol to the interface.
		/// </summary>
		/// <param name="protocolName">The new protocols name.</param>
		public IProtocolTypeLevelBuilder AddProtocol (string protocolName)
		{
			//TODO: if ever protocols are integrated use:
			//new DefaultProtocolTypeLevelBuilder(lowLevelBuilder, iProtocol);
			throw new NotImplementedException("currently protocols can not be created using a builder.");
		}

		/// <summary>
		/// called to add a existing protocol to the actual interfaces.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		public void AddProtocol (IProtocol protocol)
		{
			lowLevelBuilder.AddProtocol(protocol, this.iInterface.InterfaceID);
		}

		/// <summary>
		/// called to remove the protocol with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		public void RemoveProtocol (IProtocolIdentifier protocolID)
		{
			lowLevelBuilder.RemoveProtocol(protocolID);
		}

		/// <summary>
		/// Returns the <see cref="IInterfaceIdentifier"/> of the actual interface.
		/// </summary>
		public IInterfaceIdentifier InterfaceID
		{
			get { return this.iInterface.InterfaceID; }
		}

	}
}
