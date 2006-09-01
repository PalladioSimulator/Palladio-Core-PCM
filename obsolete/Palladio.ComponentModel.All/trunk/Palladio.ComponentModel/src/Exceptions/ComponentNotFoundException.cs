using Palladio.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component is missing.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2005/05/18 10:33:46  kelsaka
	/// - added default constraints implementation
	/// - added new test-case
	///
	/// Revision 1.2  2005/02/24 20:13:05  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a component is missing.
		/// </summary>
		/// <param name="aComponentID">The missing component.</param>
		public ComponentNotFoundException(IIdentifier aComponentID) : 
			base( "Component " + (aComponentID != null ? aComponentID.ToString() : "<NULL>" )+ " could not be found!")
		{
		}

		/// <summary>
		/// Error indicating, that a component is missing.
		/// </summary>
		/// <param name="aComponentID">The missing component.</param>
		/// <param name="message">The error message.</param>
		public ComponentNotFoundException(IIdentifier aComponentID, string message) : 
			base( "Component " + (aComponentID != null ? aComponentID.ToString() : "<NULL>" )+ " could not be found! Error message: " + message)
		{
		}
	}
}