using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the Protocol builder - methods that are available at all levels.
	/// </summary>
	/// <remarks>
	/// Currently the protocols can not be created using a builder.
	/// 
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.9  2005/04/20 13:26:43  kelsaka
	/// - added new Init-method implementation
	///
	/// Revision 1.8  2005/04/20 13:08:31  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// Revision 1.7  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.6  2005/04/13 20:24:08  kelsaka
	/// - added enitity methods
	///
	/// Revision 1.5  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// Revision 1.4  2005/04/12 18:08:35  kelsaka
	/// - added events to builders
	///
	/// Revision 1.3  2005/04/12 12:32:39  kelsaka
	/// - removed property to access typed IDs directly from the builders
	/// - renamed the property from 'SignaturID' to 'SignatureID' in ISignature
	///
	/// Revision 1.2  2005/04/09 12:23:20  kelsaka
	/// - added documentation
	///
	/// Revision 1.1  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// </pre>
	/// </remarks>
	public abstract class AbstractProtocolBuilder : IProtocolBuilder
	{
		#region data

		private IModelDataManager modelDataManager;
		private IProtocol protocol;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// (use for deserialization.)
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="protocolIdentifier">The protocol id of an existing protocl.</param>
		public void Init (IModelDataManager modelDataManager, IProtocolIdentifier protocolIdentifier)
		{
			Init(modelDataManager, modelDataManager.Query.QueryEntities.GetProtocol(protocolIdentifier));
		}

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="protocol">The protocol to build.</param>
		public void Init(IModelDataManager modelDataManager, IProtocol protocol)
		{
			this.modelDataManager = modelDataManager;
			this.protocol = protocol;
		}

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the created instance.
		/// </summary>
		public IProtocol Protocol
		{
			get { return this.protocol; }
		}

		#endregion
	}
}
