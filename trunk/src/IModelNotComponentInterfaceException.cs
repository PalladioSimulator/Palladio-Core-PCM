using System;

namespace Palladio.ComponentModel
{
	public class IModelNotComponentInterfaceException : Exception
	{
		public IModelNotComponentInterfaceException() : base("IModel is not a component interface!")
		{
		}
	}
}
