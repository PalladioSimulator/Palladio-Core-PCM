using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Query.TypeLevel
{
	/// <summary>
	/// This interface defines several query methods to find the entities that are connected by a connection.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/04/18 08:50:50  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IQueryConnectionTypeLevel
	{
		#region properties

		#endregion

		#region methods

		/// <summary>
		/// returns the query interface to the interface with given id.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the query interface</returns>
		IQueryInterfaceTypeLevel QueryInterfaceTypeLevel(IInterfaceIdentifier ifaceID);

		/// <summary>
		/// returns the query interface to the component with given id.
		/// </summary>
		/// <param name="componentID">the id of the component</param>
		/// <returns>the query interface</returns>
		IQueryComponentTypeLevel QueryComponentTypeLevel(IComponentIdentifier componentID);

		/// <summary>
		/// call to return the id of the component on requires side of the connection
		/// </summary>
		/// <returns>the id of the component</returns>
		IComponentIdentifier GetRequiringComponent();

		/// <summary>
		/// called to return the id of the interface on requires side of the connection
		/// </summary>
		/// <returns>the id of the interface</returns>
		IInterfaceIdentifier GetRequiringInterface();

		/// <summary>
		/// call to return the id of the component on provides side of the connection
		/// </summary>
		/// <returns>the id of the component</returns>
		IComponentIdentifier GetProvidingComponent();

		/// <summary>
		/// called to return the id of the interface on provides side of the connection
		/// </summary>
		/// <returns>the id of the interface</returns>
		IInterfaceIdentifier GetProvidingInterface();

		#endregion
	}
}
