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
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.18  2005/04/23 11:00:44  kelsaka
	/// - removed Init-Methods from AbstractBuilder - created constructors
	///
	/// Revision 1.17  2005/04/20 18:27:45  kelsaka
	/// - made classes internal
	/// - removed unused init-methods
	/// - use of InternalEntityIdentifier for creating new Identifiers
	///
	/// Revision 1.16  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.15  2005/04/20 16:23:44  joemal
	/// fix a bug
	///
	/// Revision 1.14  2005/04/20 13:26:43  kelsaka
	/// - added new Init-method implementation
	///
	/// Revision 1.13  2005/04/20 13:08:31  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// Revision 1.12  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
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
	internal abstract class AbstractInterfaceBuilder : AbstractEntityBuilder, IInterfaceBuilder
	{
		#region data

		private IModelDataManager modelDataManager;
		private IInterface iInterface;

		#endregion

		#region constraints

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="iInterface">The interface to build.</param>
		public AbstractInterfaceBuilder(IModelDataManager modelDataManager, IInterface iInterface)
			: base(iInterface)
		{
			this.modelDataManager = modelDataManager;
			this.iInterface = iInterface;
		}

		#endregion

		#region methods

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
			modelDataManager.LowLevelBuilder.AddSignature(signature, this.iInterface.InterfaceID);
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
			modelDataManager.LowLevelBuilder.AddSignature(signature, this.iInterface.InterfaceID);
			return new DefaultSignatureTypeLevelBuilder(modelDataManager, signature);
		}

		/// <summary>
		/// called to remove the signature with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="signatureID">the id of the signature that has to be removed</param>
		public void RemoveSignature (ISignatureIdentifier signatureID)
		{
			modelDataManager.LowLevelBuilder.RemoveSignature(signatureID);
		}


		/// <summary>
		/// Adds a new protocol to the interface.
		/// (for use in deserialization.)
		/// </summary>
		/// <param name="protocolIdentifier">The new protocols identifier.</param>
		/// <param name="protocolName">The new protocols name.</param>
		public IProtocolTypeLevelBuilder AddProtocol (IProtocolIdentifier protocolIdentifier, string protocolName)
		{
			throw new NotImplementedException("currently protocols can not be created using a builder.");
		}

		/// <summary>
		/// called to add a existing protocol to the actual interfaces.
		/// </summary>
		/// <param name="protocol">the protocol to be added</param>
		public void AddProtocol (IProtocol protocol)
		{
			modelDataManager.LowLevelBuilder.AddProtocol(protocol, this.iInterface.InterfaceID);
		}

		/// <summary>
		/// called to remove the protocol with given id. If the entity could not be found in 
		/// componentmodel, the method returns without doing anything.
		/// </summary>
		/// <param name="protocolID">the id of the protocol that has to be removed</param>
		public void RemoveProtocol (IProtocolIdentifier protocolID)
		{
			modelDataManager.LowLevelBuilder.RemoveProtocol(protocolID);
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
