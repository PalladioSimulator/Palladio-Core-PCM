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
	/// Revision 1.2  2005/05/21 17:12:17  kelsaka
	/// - added new exception for use with signatures
	/// - finished adding constraints for the type level
	///
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

		/// <summary>
		/// Error indicating, that an entity with given id could not be found in cm.
		/// </summary>
		/// <param name="anEntityID">The missing entity.</param>
		/// <param name="message">The error message.</param>
		public EntityNotFoundException(IIdentifier anEntityID, string message) : 
			base( "Entity " + anEntityID + " could not be found! Error message: " + message)
		{
		}
	}
}