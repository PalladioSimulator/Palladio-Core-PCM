using Palladio.ComponentModel.Query.TypeLevel;

namespace Palladio.ComponentModel.Query
{
	/// <summary>
	/// This interface is returned by the componentmodel environment in order to support several query mechanisms.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/06/12 17:07:31  joemal
	/// renamed from QueryEntity to QueryRepository
	///
	/// Revision 1.1  2005/04/18 08:50:50  joemal
	/// initial creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public interface IQuery
	{
		/// <summary>
		/// returns an interface that contains several methods to query all entities of the componentmodel
		/// </summary>
		IQueryRepository QueryRepository
		{
			get;
		}

		/// <summary>
		/// returns an interface that contains several methods to query the model in type level
		/// </summary>
		IQueryTypeLevel QueryTypeLevel
		{
			get;
		}

/*		/// <summary>
		/// returns an interface that contains several methods to query the model in type level
		/// </summary>
		IQueryImplementationLevel QueryImplementationLevel
		{
			get;
		}
		/// <summary>
		/// returns an interface that contains several methods to query the model in type level
		/// </summary>
		IQueryDeploymentLevel QueryDeploymentLevel
		{
			get;
		}*/
	}
}
