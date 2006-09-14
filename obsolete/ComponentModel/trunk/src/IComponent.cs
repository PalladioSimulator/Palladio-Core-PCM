using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A Component is a set of Provides- and RequiresInterfaces.
	/// </summary>
	public interface IComponent : ICloneable 
	{
		
		/// <summary>
		/// Interfaces provided by the component to its environment.
		/// </summary>
		/// <returns>
		/// A list of ProvidesInterface objects.
		/// </returns>
		IList GetProvidesIfaceList();

		/// <summary>
		/// Interfaces required by the component from its environment.
		/// </summary>
		/// <returns>
		/// A list of RequiresInterface objects.
		/// </returns>
		IList GetRequiresIfaceList();

		/// <summary>
		/// Interfaces provided by the component constrained by its environment.
		/// </summary>
		/// <param name="aProvIfaceList">
		/// List of ProvidesInterface objects provided to the component.
		/// </param>
		/// <returns>
		/// A list of ProvidesInterface objects.
		/// </returns>
		IList GetProvidesIfaceList( IList aProvIfaceList );

		/// <summary>
		/// Interfaces required by the component adapted to the requirements
		/// of the environment.
		/// </summary>
		/// <param name="aReqIfaceList">
		/// List of RequiresInterface objects required from the component.
		/// </param>
		/// <returns>
		/// A List of RequireInterface objects.
		/// </returns>
		IList GetRequiresIfaceList( IList aReqIfaceList );
	}
}
