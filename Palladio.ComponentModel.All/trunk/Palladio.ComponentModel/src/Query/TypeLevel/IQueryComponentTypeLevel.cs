using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Query.TypeLevel
{
	/// <summary>
	/// This interface defines several query methods to find the entities that are contained in and 
	/// belong to a component.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/10/09 14:42:12  kelsaka
	/// - removed convenience properties to access a component model entity directly from a
	///  builder. use the access cm-environment>query instead
	///
	/// Revision 1.3  2005/10/09 14:00:48  kelsaka
	/// - removed convenience property to access QueryRepository. This property raised security
	///  problems if the queries had been partially encapsulated: The access structure
	///  of queries was not a tree.
	///
	/// Revision 1.2  2005/06/12 17:07:31  joemal
	/// renamed from QueryEntity to QueryRepository
	///
	/// Revision 1.1  2005/04/18 08:50:50  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IQueryComponentTypeLevel
	{

		#region methods

		/// <summary>
		/// returns the query interface to the interface with given id.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the query interface</returns>
		IQueryInterfaceTypeLevel QueryInterfaceTypeLevel(IInterfaceIdentifier ifaceID);

		/// <summary>
		/// called to return the list of ids that belong to the components provides interfaces
		/// </summary>
		/// <returns>the list of  ids that belong to the components provides interfaces</returns>
		IInterfaceIdentifier[] GetProvidesInterfaceIDs();

		/// <summary>
		/// called to return the list of ids that belong to the components requires interfaces
		/// </summary>
		/// <returns>the list of  ids that belong to the components requires interfaces</returns>
		IInterfaceIdentifier[] GetRequiresInterfaceIDs();

		/// <summary>
		/// returns true, if the interface with given id is a provides interface of the component
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>true, if the interface is a provides interfaces of the component</returns>
		bool IsProvidesInterface(IInterfaceIdentifier ifaceID);

		/// <summary>
		/// returns true, if the interface with given id is a requires interface of the component
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>true, if the interface is a requires interfaces of the component</returns>
		bool IsRequiresInterface(IInterfaceIdentifier ifaceID);

		#endregion
	}
}
