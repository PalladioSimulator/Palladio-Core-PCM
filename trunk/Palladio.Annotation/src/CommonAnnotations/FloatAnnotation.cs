using System;

namespace Palladio.Annotation.CommonAnnotations
{
	/// <summary>
	/// Annotation that allows to describe / attribute / annotate an object
	/// with a float number.
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
	public class FloatAnnotation : DefaultAnnotation
	{
		#region data

		private float annotationFloat;

		#endregion

		#region constructor

		/// <summary>
		/// Default constructor. The default status is set to <see cref="Status.EDITABLE"/>.
		/// This annotation type uses the GUID "00000815-4711-9999-0000-000000000111".
		/// </summary>
		/// <param name="annotationID">The identifier of this attribute type</param>
		/// <param name="displayName">the displayed name of the attribute</param>
		/// <param name="annotationFloat">A int that annotates the object.</param>
		public FloatAnnotation(Guid annotationID, string displayName, float annotationFloat)
			: base(annotationID, displayName, new Guid("00000815-4711-9999-0000-000000000111"))
		{
			this.annotationFloat = annotationFloat;
		}
		
		#endregion

		#region public methods

		/// <summary>
		/// A int that is set for the described object.
		/// </summary>
		public float AnnotationFloat
		{
			get
			{
				return annotationFloat;
			}
			set
			{
				this.annotationFloat = value;		
			}
		}

		/// <summary>
		/// Implementation of the clone object.
		/// </summary>
		/// <returns>Exact clone of the actual instance.
		/// The type is <see cref="FloatAnnotation"/>.</returns>
		public override object Clone()
		{
			return new FloatAnnotation(ID, DisplayName, AnnotationFloat);
		}

		#endregion
	}
}
