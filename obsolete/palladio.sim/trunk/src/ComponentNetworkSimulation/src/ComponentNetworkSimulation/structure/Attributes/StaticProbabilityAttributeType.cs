using System;

namespace ComponentNetworkSimulation.Structure.Attributes
{
	/// <summary>
	/// This class defines a attribute, that holds a static probability used for example in transitions in FSM's.
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
	public class StaticProbabilityAttributeType : Palladio.Attributes.IAttributeType
	{
		/// <summary>
		/// Get a description of the attribute
		/// </summary>
		public string Description
		{
			get
			{
				return "This attribute defines a static probability.";
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
				return new Guid("0AEC00AA-C0A4-4cf1-98FA-2658F3BF86EE");
			}
		}

		/// <summary>
		/// Get the type of the value of the given attribute
		/// </summary>
		public Type ValueType
		{
			get
			{
				return typeof(double);
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
