using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.ModelEntities.Impl
{
	/// <summary>
	/// Default Connection class. The connection has a name, an id and an attribute hashmap.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:31:37  joemal
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultConnection : AbstractEntity ,IConnection
	{
		#region Properties

		/// <summary>
		/// returns the typed id of this connection
		/// </summary>
		public IConnectionIdentifier ConnectionID
		{
			get
			{
				return (IConnectionIdentifier) id;
			}
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a connection with given name and given id. 
		/// </summary>
		/// <param name="aID">ID of the connection</param>
		/// <param name="name">the name of the connection</param>
		public DefaultConnection(IInterfaceIdentifier aID, string name) : base(aID, name)
		{
		}		

		#endregion
	}
}