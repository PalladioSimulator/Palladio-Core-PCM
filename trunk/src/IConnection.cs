using System;
using System.Collections;
using Palladio.Attributes;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connects two interfaces of different componetens to each other.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/05/24 15:20:44  sliver
	/// added cvs log
	///
	/// </pre>
	/// </remarks>
	public interface IConnection : IAttributable, ICloneable
	{
	}
}