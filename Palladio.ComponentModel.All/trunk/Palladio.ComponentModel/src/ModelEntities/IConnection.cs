using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.ModelEntities
{
	/// <summary>
	/// Connects two interfaces of different components to each other.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/04/05 14:23:59  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.2  2005/03/17 18:30:35  kelsaka
	/// - added first builder-interfaces
	///
	/// Revision 1.1  2005/03/15 12:31:23  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	public interface IConnection : IComponentModelEntity
	{
		#region Properties

		/// <summary>
		/// returns the typed id of this connection
		/// </summary>
		IConnectionIdentifier ConnectionID
		{
			get;
		}

		#endregion
	}
}