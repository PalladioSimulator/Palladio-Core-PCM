using System;
using ReflectionBasedVisitor;

namespace Palladio.Attributes
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
	/// Revision 1.1  2005/02/21 13:05:49  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	internal class DefaultAttributeType : IAttributeType
	{
		protected string displayname = "";
		protected string description = "";
		protected Guid guid = Guid.Empty;
		protected Type type = null;

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
		/// Get a description of the attribute
		/// </summary>
		public virtual string Description 
		{ 
			get
			{
				return description;
			}
		}

		/// <summary>
		/// Get a globally unique ID of the attribute used to identify 
		/// the attribute
		/// </summary>
		public virtual Guid GUID  
		{ 
			get
			{
				return guid;
			}
		}

		/// <summary>
		/// Get the type of the value of the given attribute
		/// </summary>
		public virtual Type ValueType
		{ 
			get
			{
				return type;
			}
		}
		
		/// <summary>
		/// Default constructor
		/// </summary>
		/// <param name="guid">The identifier of this attribute type</param>
		/// <param name="description">A description of the attribute type</param>
		/// <param name="type">The type of the attribute</param>
		public DefaultAttributeType(Guid guid, string description, Type type)
		{
			this.guid = guid;
			this.description = description;
			this.type = type;
		}

		public void AcceptVisitor(IVisitor v)
		{
		}
	}
}
