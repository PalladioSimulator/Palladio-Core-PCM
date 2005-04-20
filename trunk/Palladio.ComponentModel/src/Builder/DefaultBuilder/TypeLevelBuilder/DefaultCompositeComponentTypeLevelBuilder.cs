using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder
{
	/// <summary>
	/// Default implementation of the composite component builder at the type level.
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
	/// Revision 1.1  2005/04/08 10:41:18  kelsaka
	/// - added return of IDs
	/// - added implementation of defined interfaces
	/// - redefined interfaces for builder-context
	/// - added CC-levels
	///
	/// </pre>
	/// </remarks>
	internal class DefaultCompositeComponentTypeLevelBuilder : AbstractCompositeComponentBuilder, ICompositeComponentTypeLevelBuilder
	{

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="component">The component to build.</param>
		public DefaultCompositeComponentTypeLevelBuilder(IModelDataManager modelDataManager, IComponent component) 
		{
			base.Init(modelDataManager, component);
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public ICompositeComponentImplementationLevelBuilder ImplementationLevelBuilder
		{
			get { throw new NotImplementedException ("ImplementationLevelBuilder is not done yet."); }
		}
	}
}
