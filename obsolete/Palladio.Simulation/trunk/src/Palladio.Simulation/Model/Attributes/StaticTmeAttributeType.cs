using System;

namespace Palladio.Simulation.Model.Attributes
{
	/// <summary>
	/// This class defines a attribute, that holds a static time used for several timeconsuming elements in the
	/// component architecture.
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
	public class StaticTmeAttributeType : Palladio.Attributes.IAttributeType
	{
		/// <summary>
		/// Get a description of the attribute
		/// </summary>
		public string Description
		{
			get
			{
				return "This attribute defines a static time.";
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
				return new Guid("9CB10551-DF51-41a5-9472-98D6B2EA0340");
			}
		}

		/// <summary>
		/// Get the type of the value of the given attribute
		/// </summary>
		public Type ValueType
		{
			get
			{
				return typeof(long);
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