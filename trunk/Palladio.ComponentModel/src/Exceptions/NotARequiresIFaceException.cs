using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that the interface is not an requires interface of the component.
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
	public class NotARequiresIFaceException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that the interface is not an requires interface of the component.
		/// </summary>
		/// <param name="aComponentID">The component.</param>
		/// <param name="iFaceID">the interface</param>
		public NotARequiresIFaceException(IComponentIdentifier aComponentID, IInterfaceIdentifier iFaceID) : 
			base( "The interface "+(iFaceID != null ? iFaceID.ToString() : "<NULL>" )+"is not an requires interfaces "+
			"of the Component " + (aComponentID != null ? aComponentID.ToString() : "<NULL>" )+ "!")
		{
		}
	}
}