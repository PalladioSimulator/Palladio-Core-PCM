using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.DefaultBuilder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEventManagement;
using Palladio.ComponentModel.Query;
using Palladio.ComponentModel.Serialization;

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
	/// Revision 1.8  2005/04/24 19:15:42  joemal
	/// add serialization manager
	///
	/// Revision 1.7  2005/04/20 19:53:20  kelsaka
	/// - Example and CM-Environment are now using the IBuilderManger
	///
	/// Revision 1.6  2005/04/20 16:23:44  joemal
	/// fix a bug
	///
	/// Revision 1.5  2005/04/20 13:08:31  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// Revision 1.4  2005/04/18 08:51:05  joemal
	/// add query methods
	///
	/// Revision 1.3  2005/04/10 15:34:23  joemal
	/// add some query methods
	///
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
	/// Todo: add the navigation
	///		  add ...
	public class ComponentModelEnvironment
	{
		#region data

		// hold the manager of the model
		private IModelDataManager modelManager;
		
		//holds the buildermanager
		//don't use this attribute directly, lazy loading is used to set this attribute
		private IBuilderManager builderManager;

		//holds the serializationmanager
		//don't use this attribute directly, lazy loading is used to set this attribute
		private ISerializationManager serializationManager;
		
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
		/// <p>Accesse the <see cref="IBuilderManager"/>. The builder manager offers all neccessary sub-builders to
		/// create a new component model (static structure).</p>
		/// <p>To create other model levels of the component model than the type level (implementation, deployment)
		/// this builder offers methods to change to level specifical builders. Each entity has a property to
		/// access other level builders.</p>
		/// </summary>
		/// <returns>
		/// A new builder manager which offers access to the <see cref="IRootTypeLevelBuilder"/> and
		/// methods to add constraints.
		/// </returns>
		/// <remarks>
		/// Uses the <see cref="ModelEntities.EntityFactory"/> to create new instances. The static structure
		/// is created using a <see cref="LowLevelBuilder"/>.
		/// </remarks>
		public IBuilderManager BuilderManager
		{
			get
			{
				//lazy loading
				if (this.builderManager==null)
					this.builderManager = new BuilderManager(modelManager);
				return builderManager;
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

		/// <summary>
		/// called to return the interface used to query the entity of the componentmodel.
		/// </summary>
		public IQuery Query
		{
			get
			{
				return this.modelManager.Query;
			}
		}

		/// <summary>
		/// called to return the manager that can be used to load and store the model
		/// </summary>
		public ISerializationManager SerializationManager
		{
			get
			{
				//lazy loading
				if (this.serializationManager == null) 
					this.serializationManager = new DefaultSerializationManager(this.BuilderManager,this.Query);
				return serializationManager;
			}
		}

		#endregion
	}
}
