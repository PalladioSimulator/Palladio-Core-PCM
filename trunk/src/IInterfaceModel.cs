using System;
using System.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// An IInterfaceModel is the description of an interface (of a component).
	/// In our case an interface is a set of services
	/// which are somehow related to each other. This relation of
	/// the services is given by the implementation 
	/// of the IInterfaceModel interface.
	/// </summary>
	public interface IInterfaceModel : ICloneable, IAttributable, IVisitable
	{
		string RoleID { get; set; }
	}
}
