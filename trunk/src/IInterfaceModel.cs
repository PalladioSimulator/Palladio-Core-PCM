using System;
using System.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// An IInterfaceModel is the description of an interface (of a component).
	/// In our case an interface is a set of signatures
	/// which can be somehow related to each other.
	/// </summary>
	public interface IInterfaceModel : ICloneable, IAttributable, IVisitable
	{
		/// <summary>
		/// Local unique identifier of the interface model.
		/// </summary>
		string RoleID { get; set; }
	}
}
