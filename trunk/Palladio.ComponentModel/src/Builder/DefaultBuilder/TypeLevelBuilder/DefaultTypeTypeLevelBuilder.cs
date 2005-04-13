using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder
{
	/// <summary>
	/// Default implementation of the type builder at the type level.
	/// <summary>
	/// 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// </pre>
	/// </remarks>
	public class DefaultTypeTypeLevelBuilder : AbstractTypeBuilder, ITypeTypeLevelBuilder
	{

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="lowLevelBuilder">The model data management.</param>
		/// <param name="type">The type to build.</param>
		public DefaultTypeTypeLevelBuilder(ILowLevelBuilder lowLevelBuilder, IType type) 
		{
			base.Init(lowLevelBuilder, type);
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public ITypeImplementationLevelBuilder ImplementationLevelBuilder
		{
			get { throw new NotImplementedException ("ImplementationLevelBuilder is not done yet."); }
		}
	}
}
