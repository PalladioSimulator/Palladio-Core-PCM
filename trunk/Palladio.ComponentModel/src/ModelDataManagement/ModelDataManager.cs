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
			lowLevelBuilder = new LowLevelBuilder(modelDataset,entityHashtable);
		}

		/// <summary>
		/// returns the lowlevelbuilder to create and modify the componentmodel
		/// </summary>
		public ILowLevelBuilder LowLevelBulder
		{
			get
			{
				return this.lowLevelBuilder;
			}
		}
	}
}
