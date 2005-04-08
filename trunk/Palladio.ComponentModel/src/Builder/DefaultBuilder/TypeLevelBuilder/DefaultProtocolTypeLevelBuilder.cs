using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder
{
	/// <summary>
	/// Default implementation of the protocol builder at the type level.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// Currently the protocols can not be created using a builder.
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/08 16:50:31  kelsaka
	/// - added interface builder implementation
	///
	/// </pre>
	/// </remarks>
	public class DefaultProtocolTypeLevelBuilder : AbstractProtocolBuilder, IProtocolTypeLevelBuilder
	{

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="protocol">The interface to build.</param>
		public DefaultProtocolTypeLevelBuilder(ILowLevelBuilder lowLevelBuilder, IProtocol protocol) 
		{
			base.Init(lowLevelBuilder, protocol);
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public IProtocolImplementationLevelBuilder ImplementationLevelBuilder
		{
			get { throw new NotImplementedException ("ImplementationLevelBuilder is not done yet."); }
		}
	}
}
