using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Thrown, if the IModel is not a SignatureListIModel as expected.
	/// </summary>
	public class IModelNotSignatureListIModelException : ApplicationException
	{
		/// <summary>
		/// Thrown, if the IModel is not a SignatureListIModel as expected.
		/// </summary>
		public IModelNotSignatureListIModelException() : base ("InterfaceModel is not a SignatureListIModel!")
		{
		}
	}
}
