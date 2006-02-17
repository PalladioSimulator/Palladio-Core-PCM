using System;

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
	public class DefaultAttributeType : IAttributeType
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
		protected Guid guid = Guid.Empty;

		/// <summary>
		/// the type of the attribute value  
		/// </summary>
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
		/// <param name="displayName">the displayed name of the attribute</param>
		/// <param name="description">A description of the attribute type</param>
		/// <param name="type">The type of the attribute</param>
		public DefaultAttributeType(Guid guid, string displayName, string description, Type type)
		{
			this.guid = guid;
			this.displayname = displayName;
			this.description = description;
			this.type = type;
		}
	}
}
