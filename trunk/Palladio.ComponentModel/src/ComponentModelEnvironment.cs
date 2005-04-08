using Palladio.ComponentModel.Builder.DefaultBuilder.TypeLevelBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEventManagement;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// This public class is used to create a new componentmodel. It provides several interfaces to create a model, 
	/// navigate through the model, save and restore the model and ...
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/08 08:23:30  joemal
	/// rename class ComponentModel to ComponentModelEnvironment
	/// due to problems with the namespace
	///
	/// Revision 1.4  2005/04/07 17:49:32  kelsaka
	/// - added some unit tests
	/// - added builder implementation
	///
	/// Revision 1.3  2005/03/29 13:06:11  joemal
	/// add event support
	///
	/// Revision 1.2  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// Revision 1.1  2005/03/15 12:49:15  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	/// Todo: add the builder
	///		  add the navigation
	///		  add the store and restore functions
	///		  add ...
	public class ComponentModelEnvironment
	{
		#region data

		//hold the manager of the model
		private ModelDataManager modelManager;
		
		#endregion

		#region constructors

		/// <summary>
		/// call to create a new componentmodel.
		/// </summary>
		public ComponentModelEnvironment()
		{
			Init();
		}

		#endregion

		#region methods
		
		//called to init the componentmodel
		private void Init()
		{
			this.modelManager = new ModelDataManager();
		}

		#endregion

		#region properties

		/// <summary>
		/// Creates a new <see cref="IRootTypeLevelBuilder"/>. The builder offers all neccessary sub-builders to
		/// create a new component model (static structure).
		/// </summary>
		/// <returns>A new RootBuilder for the type level of the component model.</returns>
		/// <remarks>
		/// Uses the EntityFactory.
		/// </remarks>
		public IRootTypeLevelBuilder RootBuilder
		{
			get
			{
				return new DefaultRootTypeLevelBuilder(modelManager.LowLevelBuilder);
			}
		}

		/// <summary>
		/// returns the interfaces that can be used to register for events in the component model.
		/// </summary>
		public IEventInterface EventInterface
		{
			get
			{
				return this.modelManager.EventInterface;
			}
		}

		#endregion
	}
}
