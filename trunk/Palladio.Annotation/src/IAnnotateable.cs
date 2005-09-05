namespace Palladio.Annotation
{
	/// <summary>
	/// Interface that has to be implemented by objects that shall
	/// be annotated by attributes or other information. Each
	/// object can have a set (<see cref="IAnnotationHash"/>) of
	/// annotations.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2005/09/05 14:16:05  kelsaka
	/// - renamed "attribute" to "annotation"
	/// - put AttributeType into IAnnotation; removed default description
	/// - added common set of annotations
	///
	/// Revision 1.2  2005/04/05 14:23:03  joemal
	/// add event notification
	///
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IAnnotateable
	{
		/// <summary>
		/// A list of annotations (attributes, completing information) attached an object. 
		/// </summary>
		IAnnotationHash Annotations { get; }
	}
}
