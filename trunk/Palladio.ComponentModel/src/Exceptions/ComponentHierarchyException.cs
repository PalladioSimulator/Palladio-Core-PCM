
namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that an hierarchy constrain was hurt. By example this exception is thrown if two components
	/// should be connected by an assembly connector which have not the same parent component.
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
	public class ComponentHierarchyException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that an hierarchy constrain was hurt.
		/// </summary>
		/// <param name="message">the message of the exception</param>
		public ComponentHierarchyException(string message) : 
			base(message)
		{
		}
	}
}