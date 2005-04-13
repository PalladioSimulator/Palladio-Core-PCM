using System;
using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

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
	/// Revision 1.11  2005/04/13 20:24:08  kelsaka
	/// - added enitity methods
	///
	/// Revision 1.10  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// Revision 1.9  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// Revision 1.8  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.7  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.6  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.5  2005/04/08 18:12:01  kelsaka
	/// - added further method to be able to add an existing signature
	///
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
	public abstract class AbstractInterfaceBuilder : AbstractEntityBuilder, IInterfaceBuilder
	{
		#region data

		private ILowLevelBuilder lowLevelBuilder;
		private IInterface iInterface;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="iInterface">The interface to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, IInterface iInterface)
		{
			this.lowLevelBuilder = lowLevelBuilder;
			this.iInterface = iInterface;
			base.Init(iInterface);
		}

		/// <summary>
		/// Adds an existing signature to the actual Interface.
		/// </summary>
		/// <remarks>
		/// Until the SignatureID can be used to get the signature-instance this method allows to
		/// add a self defined signature.
		/// </remarks>
		/// <param name="signature">The existing signature.</param>
		public void AddSignature (ISignature signature)
		{
			lowLevelBuilder.AddSignature(signature, this.iInterface.InterfaceID);
		}

		/// <summary>
		/// Adds a new signature with the given name to the actual Interface.
		/// The new signature is initialized with the default signature description, where
		/// the return type is void and no parameters and exceptions are set.
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

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IInterface Interface
		{
			get { return this.iInterface; }
		}

		#endregion
	}
}
