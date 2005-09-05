using System;
using System.Collections;

namespace Palladio.Annotation
{
	/// <summary>
	/// A hashtable containing attributes which are associated to certain
	/// objects in other data structures. Those attributes need to have
	/// a type. 
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
	/// Revision 1.4  2005/05/20 11:11:10  joemal
	/// add methods
	///
	/// Revision 1.3  2005/04/08 08:11:09  joemal
	/// fix missing comment
	///
	/// Revision 1.2  2005/04/05 14:30:39  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.1  2005/04/05 14:20:12  joemal
	/// initial class creation
	///
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultAnnotationHash : IAnnotationHash
	{
		#region data

		/// <summary>
		/// holds the hashtable with the annotations
		/// </summary>
		protected Hashtable annotationsHashtable;

		/// <summary>
		/// used for the implementation of the <see cref="IEnumerator"/> interface.
		/// </summary>
		private int enumeratorIndex;

		#endregion

		#region constructors

		/// <summary>
		/// Default constructor.
		/// </summary>
		public DefaultAnnotationHash()
		{
			this.enumeratorIndex = -1;
			this.annotationsHashtable = new Hashtable();
		}

		#endregion

		#region events
		/// <summary>
		/// this event is fired if one of the annotations has been added, removed or changed
		/// </summary>
		public event AnnotationChangedEventHandler AnnotationChanged;

		#endregion

		#region public methods

		/// <summary>
		/// Add the value of an annotation with the given type to this 
		/// hashtable
		/// </summary>
		/// <param name="annotationTypeID">The (unique) typeID of the annotation to add</param>
		/// <param name="val">The value of the attribute to add</param>
		public void Add(Guid annotationTypeID, IAnnotation val)
		{
			AnnotationChangedEventArgs args;
			if (this.annotationsHashtable.ContainsKey(annotationTypeID))
				args = new AnnotationChangedEventArgs(AnnotationChangedEventArgs.ChangesType.CHANGED,
					annotationTypeID,val);
			else
				args = new AnnotationChangedEventArgs(AnnotationChangedEventArgs.ChangesType.ADDED,
					annotationTypeID,val);

			annotationsHashtable[annotationTypeID] = val;
			NotifyAnnotationChanged(args);
		}

		/// <summary>
		/// called to remove an annotation from the annotationhash
		/// </summary>
		/// <param name="annotationTypeID">the typeID of the annotation type.</param>
		public void Remove(Guid annotationTypeID)
		{
			IAnnotation val = (IAnnotation) annotationsHashtable[annotationTypeID];
			annotationsHashtable.Remove(annotationTypeID);
			if (val==null) return;
			NotifyAnnotationChanged(new AnnotationChangedEventArgs(AnnotationChangedEventArgs.ChangesType.REMOVED,annotationTypeID,val));
		}

		#endregion

		#region properties

		/// <summary>
		/// Gets a copy (!) of the value of the annotations with the specified type.
		/// To change the value, get a copy, change it and then add it again to the table.
		/// </summary>
		public IAnnotation this[Guid type]
		{
			get
			{
				return (IAnnotation) ((ICloneable)annotationsHashtable[type]).Clone();
			}
		}

		/// <summary>
		/// called to return the collection of all contained annotation type IDs
		/// </summary>
		public ICollection AttributeTypeIDs
		{
			get
			{
				return annotationsHashtable.Keys;
			}
		}

		#endregion

		#region private methods

		/// <summary>
		/// called to fire an AnnotationChanged event
		/// </summary>
		/// <param name="args">the arguments of this event</param>
		protected void NotifyAnnotationChanged(AnnotationChangedEventArgs args)
		{
			if (this.AnnotationChanged != null)
				this.AnnotationChanged(this,args);
		}

		#endregion

		#region IEnumerator members

		/// <summary>
		/// Advances the enumerator to the next element of the collection.
		/// </summary>
		/// <returns></returns>
		public bool MoveNext ()
		{
			enumeratorIndex++ ;
			if( enumeratorIndex < annotationsHashtable.Count )
			{
				return true ;
			}
			else
			{
				enumeratorIndex = -1;
				return false;
			}
		}

		/// <summary>
		/// Sets the enumerator to its initial position, which is before the first
		/// element in the collection.
		/// </summary>
		public void Reset ()
		{
			enumeratorIndex = -1;
		}

		/// <summary>
		/// Gets the current element in the collection.
		/// </summary>
		public object Current
		{
			get
			{
				if(enumeratorIndex <= -1 ) 
				{
					throw new InvalidOperationException() ;
				}
				return annotationsHashtable[enumeratorIndex];
			}
		}

		#endregion
	}
}
