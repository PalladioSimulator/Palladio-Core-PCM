using System;

namespace Palladio.Simulation.Model.Attributes
{
	/// <summary>
	/// This class defines a attribute, that holds a LoggingType. It is used for simulationstate in the framework.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>	
	/// </remarks>
	public class LoggingTypeAttributeType : Palladio.Attributes.IAttributeType
	{
		/// <summary>
		/// Get a description of the attribute
		/// </summary>
		public string Description
		{
			get
			{
				return "This attribute defines a loggingtype.";
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
				return new Guid("FB79F121-ABA8-4163-8A06-806856FA4638");
			}
		}

		/// <summary>
		/// Get the type of the value of the given attribute
		/// </summary>
		public Type ValueType
		{
			get
			{
				return typeof(LoggingType_t);
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