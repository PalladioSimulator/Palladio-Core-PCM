using Palladio.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component is from wrong type for the wanted operation.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:30:08  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class WrongComponentTypeException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a component is from wrong type for the wanted operation.
		/// </summary>
		/// <param name="aComponentID">the component.</param>
		public WrongComponentTypeException(IIdentifier aComponentID) : 
			base( "Component " + (aComponentID != null ? aComponentID.ToString() : "<NULL>" )+ " from wrong type!")
		{
		}
	}
}