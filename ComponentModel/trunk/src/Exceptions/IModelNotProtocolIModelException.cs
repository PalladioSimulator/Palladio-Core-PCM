using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Thrown, if the IModel is not a ProtocolIModel as expected.
	/// </summary>
	public class IModelNotProtocolIModelException : ApplicationException
	{
		/// <summary>
		/// Thrown, if the IModel is not a ProtocolIModel as expected.
		/// </summary>
		public IModelNotProtocolIModelException() : base ("InterfaceModel is not a ProtocolIModel!")
		{
		}
	}
}
