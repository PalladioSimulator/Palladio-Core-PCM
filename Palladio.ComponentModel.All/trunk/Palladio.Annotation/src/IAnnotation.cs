using System;

namespace Palladio.Annotation
{
	/// <summary>
	/// This is the base interface of an annotation. 
	/// A annotation are attributes or other completing information for an object.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/09/05 14:16:05  kelsaka
	/// - renamed "attribute" to "annotation"
	/// - put AttributeType into IAnnotation; removed default description
	/// - added common set of annotations
	///
	/// Revision 1.3  2005/04/05 14:30:39  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IAnnotation : ICloneable
	{
		/// <summary>
		/// Get a name of the annotation, that is displayed in the property cell
		/// </summary>
		string DisplayName { get; }

		/// <summary>
		/// Get a globally unique ID of the annotation used to identify 
		/// the annotation
		/// </summary>
		Guid ID  { get; }

		/// <summary>
		/// Get the type of the value of the given annotation
		/// </summary>
		Guid AnnotationTypeID { get; }

		/// <summary>
		/// The actual status of the annotation.
		/// </summary>
		Status Status { get; set; }
	}

	/// <summary>
	/// Indicates the status of an annotation value.
	/// </summary>
	/// <remarks>List might be extended in the future.</remarks>
	public enum Status
	{
		/// <summary>
		/// The annotations value can be edited.
		/// </summary>
		EDITABLE,

		/// <summary>
		/// The annotation value is read-only. For example
		/// this can be calculated values.
		/// </summary>
		READONLY
	}
}
