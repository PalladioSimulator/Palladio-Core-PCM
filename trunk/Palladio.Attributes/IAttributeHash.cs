using System;

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
	/// Revision 1.2  2005/04/05 14:26:06  joemal
	/// add event notification
	///
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IAttributeHash
	{
		/// <summary>
		/// this event is fired if one of the attributes has been added, removed or changed
		/// </summary>
		event AttributeChangedEventHandler AttributeChanged;

		/// <summary>
		/// Add the value of an attribute with the given type to this 
		/// hashtable
		/// </summary>
		/// <param name="type">The type of the attribute to add</param>
		/// <param name="val">The value of the attribute to add</param>
		void Add (IAttributeType type, IAttribute val);

		/// <summary>
		/// called to remove an attribute from the attributehash
		/// </summary>
		/// <param name="type">the type of the attribute</param>
		void Remove(IAttributeType type);

		/// <summary>
		/// Gets a copy (!) of the value of the attribute with the specified type.
		/// To change the value, get a copy, change it and then add it again to the table.
		/// </summary>
		IAttribute this [IAttributeType type] { get; }
	}

	/// <summary>
	/// the definition of the AttributedChangedHandler
	/// </summary>
	public delegate void AttributeChangedEventHandler(object source, AttributeChangedEventArgs args);

	/// <summary>
	/// the event arguments of the AttributeChangedEvent
	/// </summary>
	public class AttributeChangedEventArgs
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
		private AttributeChangedEventArgs.ChangesType type;

		//the attribuitetype
		private IAttributeType attributeType;

		//the value
		private IAttribute attribute;

		/// <summary>
		/// called to create a new event argument structure
		/// </summary>
		/// <param name="type">the type of changes</param>
		/// <param name="attributeType">the attributetype</param>
		/// <param name="attribute">the value of the attribute</param>
		public AttributeChangedEventArgs(ChangesType type, IAttributeType attributeType, IAttribute attribute)
		{
			this.type = type;
			this.attributeType = attributeType;
			this.attribute = attribute;
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
		public IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		/// <summary>
		/// returns the value of the attribute
		/// </summary>
		public IAttribute Attribute
		{
			get { return attribute; }
		}
	}
}
