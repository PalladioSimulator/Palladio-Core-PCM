using System;

namespace Palladio.Annotation
{
	/// <summary>
	/// Stores information on the type of an attribute. The attribute
	/// type inherits IVisitable in order to e.g. allow specialised
	/// rendering of GUI elements to edit the value of the attribute.
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
	/// Revision 1.3  2005/07/13 11:11:07  joemal
	/// now public
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
	public class DefaultAnnotation : IAnnotation
	{
		/// <summary>
		/// the dislayed name of attribute type
		/// </summary>
		protected string displayname = "";

		/// <summary>
		/// the description of the atribute type 
		/// </summary>
		protected string description = "";

		/// <summary>
		/// the guid of the attribute type
		/// </summary>
		protected Guid annotationID = Guid.Empty;

		/// <summary>
		/// the type of the attribute value  
		/// </summary>
		protected Guid annotationTypeID = Guid.Empty;

		/// <summary>
		/// The status (editable/read-only) of the annotation.
		/// </summary>
		protected Status status;

		/// <summary>
		/// Get a name of the attribute, that is displayed in the property cell
		/// </summary>
		public virtual string DisplayName
		{ 
			get
			{
				return displayname;
			}
		}

		/// <summary>
		/// Get a globally unique ID of the annotation used to identify 
		/// the annotation
		/// </summary>
		public Guid ID
		{
			get
			{
				return this.annotationID;
			}
		}

		/// <summary>
		/// Get the type of the value of the given annotation
		/// </summary>
		public Guid AnnotationTypeID
		{
			get
			{
				return this.annotationTypeID;
			}
		}

		/// <summary>
		/// The actual status of the annotation.
		/// </summary>
		public Status Status
		{
			get
			{
				return this.status;
			}
			set
			{
				this.status = value;
			}
		}

		/// <summary>
		/// Default constructor. The default status is set to <see cref="Status.EDITABLE"/>.
		/// </summary>
		/// <param name="annotationTypeID">The identifier of this annotaion</param>
		/// <param name="displayName">the displayed name of the annotation</param>
		/// <param name="annotationTypeID">The type of the annotation</param>
		public DefaultAnnotation(Guid annotationID, string displayName, Guid annotationTypeID)
		{
			this.annotationID = annotationID;
			this.displayname = displayName;
			this.annotationTypeID = annotationTypeID;
			this.status = Status.EDITABLE;
		}

		/// <summary>
		/// Implementation of the clone object.
		/// </summary>
		/// <returns>Exact clone of the actual instance.
		/// The type is <see cref="DefaultAnnotation"/>.</returns>
		public virtual object Clone ()
		{
			return new DefaultAnnotation(AnnotationTypeID, DisplayName, annotationTypeID);
		}
	}
}
