using System;
using System.Collections;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connects the RequiresInterface of one component to the ProvidesInterfaces
	/// of another.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IAssemblyConnector : IConnection, IVisitable
	{
	}
}
