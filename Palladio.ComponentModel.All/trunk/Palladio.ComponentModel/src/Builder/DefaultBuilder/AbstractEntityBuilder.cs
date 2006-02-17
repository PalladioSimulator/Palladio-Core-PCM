using Palladio.ComponentModel.ModelDataManagement;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Builder.DefaultBuilder
{
	/// <summary>
	/// Abstract implementation of a component model entity.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.9  2005/06/05 10:37:33  joemal
	/// - replace the entities by the ids
	/// - components now can be added to more than one container
	///
	/// Revision 1.8  2005/05/27 13:34:41  kelsaka
	/// - AbstractEntity now holds the ModelDataManger and the BuilderManager
	///
	/// Revision 1.7  2005/04/23 11:49:54  kelsaka
	/// - refactored enity-builder interface: currently no methods.
	///
	/// Revision 1.6  2005/04/23 11:00:44  kelsaka
	/// - removed Init-Methods from AbstractBuilder - created constructors
	///
	/// Revision 1.5  2005/04/20 17:55:54  kelsaka
	/// - added methods for deserialization
	///
	/// Revision 1.4  2005/04/15 08:29:46  kelsaka
	/// - fixed errors on xml-comments
	///
	/// Revision 1.3  2005/04/14 06:16:34  kelsaka
	/// - fixed bug on listening to name changed events.
	///
	/// Revision 1.2  2005/04/13 20:24:08  kelsaka
	/// - added enitity methods
	///
	/// Revision 1.1  2005/04/13 17:06:02  kelsaka
	/// - added further support for building signatures
	///
	/// </pre>
	/// </remarks>
	internal abstract class AbstractEntityBuilder : IEntityBuilder
	{
		#region data

		private IBuilderManager builderManager;
		private IModelDataManager modelDataManager;
		private IIdentifier entity_id;

		#endregion

		#region constructors

		/// <summary>
		/// Initializes the Builder.
		/// </summary>
		/// <param name="builderManager">The manger to use for getting constrained builders.</param>
		/// <param name="modelDataManager">The model data manager e. g. for use of the <see cref="LowLevelBuilder"/></param>
		/// <param name="entity_id">the id of the entity that belongs to this builder</param>
		public AbstractEntityBuilder(IIdentifier entity_id, IBuilderManager builderManager, IModelDataManager modelDataManager)
		{
			this.builderManager = builderManager;
			this.modelDataManager = modelDataManager;
			this.entity_id = entity_id;
		}

		#endregion

		#region methods

		#endregion

		#region Properties

		/// <summary>
		/// Accesses the builder manager (including the builders constraints)
		/// </summary>
		protected IBuilderManager BuilderManager
		{
			get { return this.builderManager; }
		}

		/// <summary>
		/// Accesses the model data manager of the component model (e. g. <see cref="LowLevelBuilder"/>).
		/// </summary>
		protected IModelDataManager ModelDataManager
		{
			get { return this.modelDataManager; }
		}

		/// <summary>
		/// called to returns the id of the entity that belongs to this builder
		/// </summary>
		public IIdentifier Id
		{
			get
			{
				return this.entity_id;
			}
		}

		#endregion		

	}
}
