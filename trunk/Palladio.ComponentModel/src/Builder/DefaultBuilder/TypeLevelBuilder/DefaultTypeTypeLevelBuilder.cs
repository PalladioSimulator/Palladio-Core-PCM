using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder
{
	/// <summary>
	/// Default implementation of the type builder at the type level.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.3  2005/04/20 13:08:31  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// Revision 1.2  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.1  2005/04/13 09:27:17  kelsaka
	/// - added builders (including interfaces) for types and parameters of signatures.
	///
	/// </pre>
	/// </remarks>
	internal class DefaultTypeTypeLevelBuilder : AbstractTypeBuilder, ITypeTypeLevelBuilder
	{

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="type">The type to build.</param>
		public DefaultTypeTypeLevelBuilder(IModelDataManager modelDataManager, IType type) 
		{
			base.Init(modelDataManager, type);
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
