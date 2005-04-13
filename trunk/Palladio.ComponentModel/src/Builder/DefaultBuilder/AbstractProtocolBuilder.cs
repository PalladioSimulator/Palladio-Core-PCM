using System;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of the Protocol builder - methods that are available at all levels.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// Currently the protocols can not be created using a builder.
	/// </remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
	public abstract class AbstractProtocolBuilder : AbstractEntityBuilder, IProtocolBuilder
	{
		#region data

		private ILowLevelBuilder lowLevelBuilder;
		private IProtocol protocol;

		#endregion

		#region methods

		/// <summary>
		/// Initializes the Builder. Has to be called by implementing members at construction time.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="protocol">The protocol to build.</param>
		public void Init(ILowLevelBuilder lowLevelBuilder, IProtocol protocol)
		{
			this.lowLevelBuilder = lowLevelBuilder;
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
