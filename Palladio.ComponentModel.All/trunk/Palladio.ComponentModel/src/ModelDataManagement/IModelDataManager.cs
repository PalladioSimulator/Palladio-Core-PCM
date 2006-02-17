using Palladio.ComponentModel.ModelEventManagement;
using Palladio.ComponentModel.Query;

namespace Palladio.ComponentModel.ModelDataManagement
{
	/// <summary>
	/// Interface for: The ModeldataMangager is the core of database that holds the componentmodel. It supports a LowLevelBuilder to
	/// create and modify the structure of the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// $Log$
	/// Revision 1.1  2005/04/20 13:08:31  kelsaka
	/// - introduced IModelDataManagement
	/// - integrated use of the new interface
	///
	/// </pre>
	/// </remarks>
	public interface IModelDataManager
	{
		#region properties

		/// <summary>
		/// returns the lowlevelbuilder to create and modify the componentmodel
		/// </summary>
		ILowLevelBuilder LowLevelBuilder
		{
			get;
		}

		/// <summary>
		/// returns the interfaces that can be used to register for events in the component model.
		/// </summary>
		IEventInterface EventInterface
		{
			get;
		}

		/// <summary>
		/// called to return the query interface of the model
		/// </summary>
		IQuery Query
		{
			get;
		}

		#endregion
	}
}
