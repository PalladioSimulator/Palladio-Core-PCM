using System;

namespace Palladio.Annotation.CommonAnnotations
{
	/// <summary>
	/// Annotation that allows to describe / attribute / annotate an object
	/// with a text string.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	/// $Log$
	/// Revision 1.1  2005/09/05 14:16:05  kelsaka
	/// - renamed "attribute" to "annotation"
	/// - put AttributeType into IAnnotation; removed default description
	/// - added common set of annotations
	///
	///
	/// </code>
	/// </remarks>
	public class StringAnnotation : DefaultAnnotation
	{
		#region data

		private string annotationText;

		#endregion

		#region constructor

		/// <summary>
		/// Default constructor. The default status is set to <see cref="Status.EDITABLE"/>.
		/// This annotation type uses the GUID "00000815-4711-9999-0000-000000000111".
		/// </summary>
		/// <param name="annotationID">The identifier of this attribute type</param>
		/// <param name="displayName">the displayed name of the attribute</param>
		/// <param name="annotationText">A text that annotates an object.</param>
		public StringAnnotation(Guid annotationID, string displayName, string annotationText)
			: base(annotationID, displayName, new Guid("00000815-4711-9999-0000-000000000111"))
		{
			this.annotationText = annotationText;
		}
		
		#endregion

		#region public methods

		/// <summary>
		/// A text string that is set for the described object.
		/// </summary>
		public string AnnotationText
		{
			get
			{
				return annotationText;
			}
			set
			{
				this.annotationText = value;		
			}
		}

		/// <summary>
		/// Implementation of the clone object.
		/// </summary>
		/// <returns>Exact clone of the actual instance.
		/// The type is <see cref="StringAnnotation"/>.</returns>
		public override object Clone()
		{
			return new StringAnnotation(ID, DisplayName, AnnotationText);
		}

		#endregion

	}
}
