using Palladio.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that an entity with given id could not be found in cm.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/31 11:01:12  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class EntityNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that an entity with given id could not be found in cm.
		/// </summary>
		/// <param name="anEntityID">The missing entity.</param>
		public EntityNotFoundException(IIdentifier anEntityID) : 
			base( "Entity " + anEntityID + " could not be found!")
		{
		}
	}
}