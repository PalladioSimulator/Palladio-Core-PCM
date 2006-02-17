using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the interface is not an provides interface of the component.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/19 18:35:20  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class NotAProvidesIFaceException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the interface is not an provides interface of the component.
		/// </summary>
		/// <param name="aComponentID">The component.</param>
		/// <param name="iFaceID">the interface</param>
		public NotAProvidesIFaceException(IComponentIdentifier aComponentID, IInterfaceIdentifier iFaceID) : 
			base( "The interface "+(iFaceID != null ? iFaceID.ToString() : "<NULL>" )+"is not an provides interfaces "+
			"of the Component " + (aComponentID != null ? aComponentID.ToString() : "<NULL>" )+ "!")
		{
		}
	}
}