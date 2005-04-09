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
	/// Revision 1.2  2005/04/09 12:26:28  kelsaka
	/// - added documentation
	///
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

		/// <summary>
		/// hold the manager of the model
		/// </summary>
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
		/// <p>Creates a new <see cref="IRootTypeLevelBuilder"/>. The builder offers all neccessary sub-builders to
		/// create a new component model (static structure).</p>
		/// <p>To create other model levels of the component model than the type level (implementation, deployment)
		/// this builder offers methods to change to level specifical builders. Each entity has an property to
		/// access other level builders.</p>
		/// </summary>
		/// <returns>
		/// A new RootBuilder for the type level of the component model.
		/// </returns>
		/// <remarks>
		/// Uses the <see cref="ModelEntities.EntityFactory"/> to create new instances. The static structure is created using a <see cref="LowLevelBuilder"/>.
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
