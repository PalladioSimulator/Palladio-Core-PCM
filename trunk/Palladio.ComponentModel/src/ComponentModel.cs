using Palladio.ComponentModel.ModelDataManagement;

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

		#endregion
	}
}
