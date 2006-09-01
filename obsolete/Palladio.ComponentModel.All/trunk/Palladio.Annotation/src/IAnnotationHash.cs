using System;
using System.Collections;

namespace Palladio.Annotation
{
	/// <summary>
	/// A hashtable containing annotations which are associated to certain
	/// objects in other data structures. Those annotations need to have
	/// a typeID that identifies the type uniquely. 
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
	/// Revision 1.3  2005/05/20 11:11:10  joemal
	/// add methods
	///
	/// Revision 1.2  2005/04/05 14:26:06  joemal
	/// add event notification
	///
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IAnnotationHash : IEnumerator
	{
		/// <summary>
		/// this event is fired if one of the annotations has been added, removed or changed
		/// </summary>
		event AnnotationChangedEventHandler AnnotationChanged;

		/// <summary>
		/// Add the value of an annotation with the given type to this 
		/// hashtable
		/// </summary>
		/// <param name="annotationTypeID">The (unique) typeID of the annotation to add</param>
		/// <param name="val">The value of the attribute to add</param>
		void Add(Guid annotationTypeID, IAnnotation val);

		/// <summary>
		/// called to remove an annotation from the annotationhash
		/// </summary>
		/// <param name="annotationTypeID">the typeID of the annotation type.</param>
		void Remove(Guid annotationTypeID);

		/// <summary>
		/// Gets a copy (!) of the value of the annotations with the specified type.
		/// To change the value, get a copy, change it and then add it again to the table.
		/// </summary>
		IAnnotation this [Guid annotationTypeID] { get; }

		/// <summary>
		/// called to return the collection of all contained annotation type IDs
		/// </summary>
		ICollection AttributeTypeIDs {get;}
	}
}
