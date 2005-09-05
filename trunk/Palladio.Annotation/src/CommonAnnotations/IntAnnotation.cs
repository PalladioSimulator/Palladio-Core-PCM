using System;

namespace Palladio.Annotation.CommonAnnotations
{
	/// <summary>
	/// Annotation that allows to describe / attribute / annotate an object
	/// with a int (integer).
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
	public class IntAnnotation : DefaultAnnotation
	{
		#region data

		private int annotationInt;

		#endregion

		#region constructor

		/// <summary>
		/// Default constructor. The default status is set to <see cref="Status.EDITABLE"/>.
		/// This annotation type uses the GUID "00000815-4711-9999-0000-000000000111".
		/// </summary>
		/// <param name="annotationID">The identifier of this attribute type</param>
		/// <param name="displayName">the displayed name of the attribute</param>
		/// <param name="annotationInt">A int that annotates the object.</param>
		public IntAnnotation(Guid annotationID, string displayName, int annotationInt)
			: base(annotationID, displayName, new Guid("00000815-4711-9999-0000-000000000111"))
		{
			this.annotationInt = annotationInt;
		}
		
		#endregion

		#region public methods

		/// <summary>
		/// A int that is set for the described object.
		/// </summary>
		public int AnnotationInt
		{
			get
			{
				return annotationInt;
			}
			set
			{
				this.annotationInt = value;		
			}
		}

		/// <summary>
		/// Implementation of the clone object.
		/// </summary>
		/// <returns>Exact clone of the actual instance.
		/// The type is <see cref="IntAnnotation"/>.</returns>
		public override object Clone()
		{
			return new IntAnnotation(ID, DisplayName, AnnotationInt);
		}

		#endregion

	}
}
