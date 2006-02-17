using System;

namespace Palladio.Annotation
{
	/// <summary>
	/// the event arguments of the <see cref="AnnotationChangedEventHandler"/>.
	/// </summary>
	/// 
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/09/05 14:16:05  kelsaka
	/// - renamed "attribute" to "annotation"
	/// - put AttributeType into IAnnotation; removed default description
	/// - added common set of annotations
	///
	/// </code>
	/// </remarks>
	public class AnnotationChangedEventArgs
	{
		/// <summary>
		/// the type of changes
		/// </summary>
		public enum ChangesType
		{
			/// <summary>
			/// the attribute has been added
			/// </summary>
			ADDED,

			/// <summary>
			/// the attribute has been removed
			/// </summary>
			REMOVED,

			/// <summary>
			/// the attribute has been changed
			/// </summary>
			CHANGED
		}

		//the type of changes
		private AnnotationChangedEventArgs.ChangesType type;

		//the attribuitetype
		private Guid annotationTypeID;

		//the value
		private IAnnotation annotation;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="type">the type of changes</param>
		/// <param name="annotationTypeID">the attributetype</param>
		/// <param name="annotation">the value of the attribute</param>
		public AnnotationChangedEventArgs(ChangesType type, Guid annotationTypeID, IAnnotation annotation)
		{
			this.type = type;
			this.annotationTypeID = annotationTypeID;
			this.annotation = annotation;
		}

		/// <summary>
		/// returns the type of changes
		/// </summary>
		public ChangesType Type
		{
			get { return type; }
		}

		/// <summary>
		/// returns the type of the attribute
		/// </summary>
		public Guid AnnotationTypeID
		{
			get { return annotationTypeID; }
		}

		/// <summary>
		/// returns the value of the attribute
		/// </summary>
		public IAnnotation Annotation
		{
			get { return annotation; }
		}
	}

	/// <summary>
	/// the definition of the AnnotationChangedHandler
	/// </summary>
	public delegate void AnnotationChangedEventHandler(object source, AnnotationChangedEventArgs args);
}
