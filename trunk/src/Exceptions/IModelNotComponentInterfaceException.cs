using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Thrown, if the IModel is not a component interface 
	/// (provides or requires) as expected.
	/// </summary>
	public class IModelNotComponentInterfaceException : ApplicationException
	{
		/// <summary>
		/// Thrown, if the IModel is not a component interface 
		/// (provides or requires) as expected.
		/// </summary>
		public IModelNotComponentInterfaceException() : base("IModel is not a component interface!")
		{
		}
	}
}
