using Palladio.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that an interface is missing.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 22:02:46  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class InterfaceNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that an interface is missing.
		/// </summary>
		/// <param name="aIFaceID">The id of the missing interface.</param>
		public InterfaceNotFoundException(IIdentifier aIFaceID) : 
			base( "Interface " + (aIFaceID != null ? aIFaceID.ToString() : "<NULL>" )+ " could not be found!")
		{
		}
	}
}