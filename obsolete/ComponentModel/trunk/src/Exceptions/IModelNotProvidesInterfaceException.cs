using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Thrown, if the IModel is not a ProvidesInterface.
	/// </summary>
	public class IModelNotProvidesInterfaceException : ApplicationException
	{
		/// <summary>
		/// Thrown, if the IModel is not a ProvidesInterface.
		/// </summary>
		public IModelNotProvidesInterfaceException() : base("IModel is not a ProvidesInterface!")
		{
		}
	}
}
