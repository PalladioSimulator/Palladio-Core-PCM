using System;
using System.Collections;

namespace Palladio.Attributes
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
	/// Revision 1.1  2005/04/05 14:20:12  joemal
	/// initial class creation
	///
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class DefaultAttributeHash : IAttributeHash
	{
		#region data

		//holds the hashtable with the attributes
		protected Hashtable hashtable = new Hashtable();

		#endregion

		#region events
		/// <summary>
		/// this event is fired if one of the attributes has been added, removed or changed
		/// </summary>
		public event AttributeChangedEventHandler AttributeChanged;

		#endregion

		#region public methods

		/// <summary>
		/// Add the value of an attribute with the given type to this 
		/// hashtable
		/// </summary>
		/// <param name="type">The type of the attribute to add</param>
		/// <param name="val">The value of the attribute to add</param>
		public void Add(IAttributeType type, IAttribute val)
		{
			AttributeChangedEventArgs args;
			if (this.hashtable.ContainsKey(type))
				args = new AttributeChangedEventArgs(AttributeChangedEventArgs.ChangesType.CHANGED,
					type,val);
			else
				args = new AttributeChangedEventArgs(AttributeChangedEventArgs.ChangesType.ADDED,
					type,val);

			hashtable[type] = val;
			NotifyAttributeChanged(args);
		}

		/// <summary>
		/// called to remove an attribute from the attributehash
		/// </summary>
		/// <param name="type">the type of the attribute</param>
		public void Remove(IAttributeType type)
		{
			IAttribute val = (IAttribute) hashtable[type];
			hashtable.Remove(type);
			if (val==null) return;
			NotifyAttributeChanged(new AttributeChangedEventArgs(AttributeChangedEventArgs.ChangesType.REMOVED,type,val));
		}

		#endregion

		#region properties

		/// <summary>
		/// Gets a copy (!) of the value of the attribute with the specified type.
		/// To change the value, get a copy, change it and then add it again to the table.
		/// </summary>
		public IAttribute this[IAttributeType type]
		{
			get
			{
				return (IAttribute) hashtable[type];
			}
		}

		#endregion

		#region private methods

		/// <summary>
		/// called to fire an AttributeChanged event
		/// </summary>
		/// <param name="args">the arguments of this event</param>
		protected void NotifyAttributeChanged(AttributeChangedEventArgs args)
		{
			if (this.AttributeChanged != null)
				this.AttributeChanged(this,args);
		}

		#endregion
	}
}
