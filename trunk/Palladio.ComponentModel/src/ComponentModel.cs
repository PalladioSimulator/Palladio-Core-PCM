using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.DefaultBuilder;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;

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
	public class ComponentModel
	{
		#region data

		//hold the manager of the model
		private ModelDataManager modelManager;

		#endregion

		#region constructors

		/// <summary>
		/// call to create a new componentmodel.
		/// </summary>
		public ComponentModel()
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

		/// <summary>
		/// Creates a new <see cref="IRootBuilder"/>. The builder offers all neccessary sub-builders to
		/// create a new component model (static structure).
		/// </summary>
		/// <returns>A new RootBuilder.</returns>
		/// <remarks>
		/// Uses the EntityFactory.
		/// </remarks>
		public IRootBuilder RootBuilder
		{
			get
			{
				return new DefaultRootBuilder(modelManager.LowLevelBuilder);
			}
		}

		#endregion
	}
}
