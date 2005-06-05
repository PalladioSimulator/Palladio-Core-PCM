using Palladio.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that an entity with same id already exists in the model.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/06/05 10:39:03  joemal
	/// add second constructor
	///
	/// Revision 1.2  2005/05/18 10:33:46  kelsaka
	/// - added default constraints implementation
	/// - added new test-case
	///
	/// Revision 1.1  2005/03/15 12:30:08  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class EntityAlreadyExistsException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that an entity with same id already exists in current model.
		/// </summary>
		/// <param name="entityId">the id of the entity</param>
		public EntityAlreadyExistsException(IIdentifier entityId) : 
			base( "Entity with id " + (entityId != null ? entityId.ToString() : "<NULL>" )+ " already exists!")
		{
		}

		/// <summary>
		/// Error indicating, that an entity with same id already exists in current model.
		/// </summary>
		/// <param name="message">The error message.</param>
		public EntityAlreadyExistsException(string message) : 
			base(message)
		{
		}
	}
}