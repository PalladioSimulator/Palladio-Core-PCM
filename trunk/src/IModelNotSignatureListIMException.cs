using System;

namespace Palladio.ComponentModel
{
	public class IModelNotSignatureListIModelException : Exception
	{
		public IModelNotSignatureListIModelException() : base ("InterfaceModel is not a SignatureListIModel!")
		{
		}
	}
}
