using System;

namespace Palladio.ComponentModel
{
	public class IModelNotProtocolIModelException : Exception
	{
		public IModelNotProtocolIModelException() : base ("InterfaceModel is not a ProtocolIModel!")
		{
		}
	}
}
