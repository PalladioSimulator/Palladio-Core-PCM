using System;
using System.Collections;

namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// Error indicating, that a component is missing.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class ComponentNotFoundException : ComponentModelException
	{
		/// <summary>
		/// Error indicating, that a component is missing.
		/// </summary>
		/// <param name="aComponentID">The missing component.</param>
		public ComponentNotFoundException(Identifier.IIdentifier aComponentID) : 
			base( "Component " + (aComponentID != null ? aComponentID.ToString() : "<NULL>" )+ " could not be found!")
		{
		}
	}
}