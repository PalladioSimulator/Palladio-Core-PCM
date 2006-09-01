namespace Palladio.Attributes
{
	/// <summary>
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2005/04/05 14:23:03  joemal
	/// add event notification
	///
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IAttributable
	{
		/// <summary>
		/// A list of attributes attached an object. 
		/// </summary>
		IAttributeHash Attributes { get; }
	}
}
