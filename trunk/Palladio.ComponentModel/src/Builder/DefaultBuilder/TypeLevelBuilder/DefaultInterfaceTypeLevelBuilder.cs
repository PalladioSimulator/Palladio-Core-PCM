using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder
{
	/// <summary>
	/// Default implementation of the interface builder at the type level.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.9  2005/05/27 13:34:41  kelsaka
	/// - AbstractEntity now holds the ModelDataManger and the BuilderManager
	///
	/// Revision 1.8  2005/05/25 16:27:10  kelsaka
	/// - renamed former BuilderFactory / therefore removed former BuilderManager
	///
	/// Revision 1.7  2005/04/24 14:50:14  kelsaka
	/// - added full support for constraints
	/// - added typed lists for builders
	/// - removed protocol builder
	///
	/// Revision 1.6  2005/04/23 11:00:44  kelsaka
	/// - removed Init-Methods from AbstractBuilder - created constructors
	///
	/// Revision 1.5  2005/04/20 21:02:35  kelsaka
	/// - added first methods for constraints
	///
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
	/// Revision 1.1  2005/04/07 17:49:31  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// </pre>
	/// </remarks>
	internal class DefaultInterfaceTypeLevelBuilder : AbstractInterfaceBuilder, IInterfaceTypeLevelBuilder
	{

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="iInterface">The interface to build.</param>
		/// <param name="builderManager">The factory to use for creating new builders.</param>
		public DefaultInterfaceTypeLevelBuilder(IModelDataManager modelDataManager, IInterface iInterface, Palladio.ComponentModel.Builder.IBuilderManager builderManager) 
			: base(modelDataManager, iInterface, builderManager)
		{
		}


		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public IInterfaceImplementationLevelBuilder ImplementationLevelBuilder
		{
			get { throw new NotImplementedException ("ImplementationLevelBuilder is not done yet."); }
		}

		#region constraint-management

		/// <summary>
		/// The child builder to call for each method defined in the builder interface.
		/// </summary>
		public IInterfaceTypeLevelBuilder ChildBuilder
		{
			set {} //in constrast to constraints the builder itself has no child. 
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
			return new DefaultInterfaceTypeLevelBuilder(base.ModelDataManager, iInterface, base.BuilderManager);
		}

		#endregion
	}
}
