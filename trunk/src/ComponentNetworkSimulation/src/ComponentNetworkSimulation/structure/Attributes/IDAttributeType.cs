using System;

namespace ComponentNetworkSimulation.Structure.Attributes
{
	/// <summary>
	/// This class defines a attribute, that holds an ID.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/05/25 16:18:56  joemal
	/// initial creation
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class IDAttributeType : Palladio.Attributes.IAttributeType
	{
		/// <summary>
		/// Get a description of the attribute
		/// </summary>
		public string Description
		{
			get
			{
				return "This attribute is the ID of the element.";
			}
		}

		/// <summary>
		/// Get a globally unique ID of the attribute used to identify 
		/// the attribute
		/// </summary>
		public Guid GUID
		{
			get
			{
				return new Guid("9A614238-8563-4e44-9022-29E57F429278");
			}
		}

		/// <summary>
		/// Get the type of the value of the given attribute
		/// </summary>
		public Type ValueType
		{
			get
			{
				return typeof(string);
			}
		}

		/// <summary>
		/// called by data driven visitors. Not implemented because this class is the end of the visitable path.
		/// </summary>
		public void AcceptVisitor(ReflectionBasedVisitor.IVisitor visitor)
		{
		}
	}
}
//EOF