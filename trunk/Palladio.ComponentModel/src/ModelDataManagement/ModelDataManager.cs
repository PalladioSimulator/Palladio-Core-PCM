using Palladio.ComponentModel.ModelEventManagement;
using Palladio.ComponentModel.Query;
using Palladio.ComponentModel.Query.Impl;
using Palladio.Identifier;

namespace Palladio.ComponentModel.ModelDataManagement
{
	/// <summary>
	/// The ModeldataMangager is the core of database that holds the componentmodel. It supports a LowLevelBuilder to
	/// create and modify the structure of the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/04/18 08:51:05  joemal
	/// add query methods
	///
	/// Revision 1.4  2005/04/10 15:34:23  joemal
	/// add some query methods
	///
	/// Revision 1.3  2005/03/29 13:06:11  joemal
	/// add event support
	///
	/// Revision 1.2  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// Revision 1.1  2005/03/15 12:31:02  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class ModelDataManager
	{
		#region data

		//holds the instance of the builder
		private ILowLevelBuilder lowLevelBuilder;

		//holds the event manager of the component model
		private IModelEventManager modelEventManager;

		//holds the query interface of the component model
		private IQuery  modelQuery;

		//holds the dataset
		private ModelDataSet modelDataset;

		//holds the hashtable for the models entities
		private EntityHashtable entityHashtable;

		#endregion

		/// <summary>
		/// called to create a new modelmanager
		/// </summary>
		public ModelDataManager()
		{
			Init();
		}

		//creates the initial dataset, an empty entitytable and the builder.
		private void Init()
		{
			modelDataset =  new ModelDataSet(); 
			entityHashtable = new EntityHashtable();
			
			modelQuery = new ModelQueryManager(modelDataset,entityHashtable);

			modelEventManager = new ModelEventManager(modelDataset,entityHashtable);
			lowLevelBuilder = new LowLevelBuilder(modelDataset,entityHashtable,modelEventManager.EntityRegistration);
		}

		/// <summary>
		/// returns the lowlevelbuilder to create and modify the componentmodel
		/// </summary>
		public ILowLevelBuilder LowLevelBuilder
		{
			get
			{
				return this.lowLevelBuilder;
			}
		}

		/// <summary>
		/// returns the interfaces that can be used to register for events in the component model.
		/// </summary>
		public IEventInterface EventInterface
		{
			get
			{
				return this.modelEventManager.EventInterface;
			}
		}

		/// <summary>
		/// called to return the query interface of the model
		/// </summary>
		public IQuery Query
		{
			get
			{
				return modelQuery;
			}
		}
	}
}
