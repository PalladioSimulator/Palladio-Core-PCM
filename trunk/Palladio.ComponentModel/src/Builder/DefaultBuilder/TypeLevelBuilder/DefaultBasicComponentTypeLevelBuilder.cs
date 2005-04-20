using System;
using Palladio.ComponentModel.Builder.ImplementationLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder
{
	/// <summary>
	/// Default implementation of the basic component builder at the type level.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.6  2005/04/20 21:02:35  kelsaka
	/// - added first methods for constraints
	///
	/// Revision 1.5  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.4  2005/04/20 13:08:31  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// Revision 1.3  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.2  2005/04/07 17:49:31  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// Revision 1.1  2005/04/06 19:06:59  kelsaka
	/// - added new builder interfaces to support the levels of the component model
	/// - added basic set of methods to interfaces
	///
	/// Revision 1.2  2005/03/18 07:36:27  kelsaka
	/// - corrected errors
	///
	/// Revision 1.1  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// </pre>
	/// </remarks>
	internal class DefaultBasicComponentTypeLevelBuilder : AbstractBasicComponentBuilder, IBasicComponentTypeLevelBuilder
	{
		private IBasicComponentTypeLevelBuilder childBuilder;

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="modelDataManager">The model data management.</param>
		/// <param name="component">The component to build.</param>
		public DefaultBasicComponentTypeLevelBuilder(IModelDataManager modelDataManager, IComponent component) 
		{
			base.Init(modelDataManager, component);
		}

		/// <summary>
		/// Offers a possibility to change the model-level at which the actual entity is created.
		/// </summary>
		public IBasicComponentImplementationLevelBuilder ImplementationLevelBuilder
		{
			get { throw new NotImplementedException ("ImplementationLevelBuilder is not done yet."); }
		}

		/// <summary>
		/// The child builder to call for each method defined in the builder interface.
		/// </summary>
		public IBasicComponentTypeLevelBuilder ChildBuilder
		{
			get { throw new NotImplementedException (); }
			set { throw new NotImplementedException (); }
		}

	}
}
