using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Connects two interfaces of different componetens to each other.
	/// </summary>
	public interface IInterfaceConnection  
	{
		/// <summary>
		/// Determines the intersection of both interfaces.
		/// </summary>
		/// <returns>The lowest common denominator of both interfaces.</returns>
		IInterfaceModel GetIntersection();
	}
}