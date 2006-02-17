using System;
using Palladio.Attributes;

namespace Palladio.FiniteStateMachines.Serializer
{
	/// <summary>
	/// Exception that is rised if a <see cref="IAttribute" /> is not supported.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/08/21 13:58:17  kelsaka
	/// - added use of plugins for deserialisation
	///
	/// Revision 1.1  2005/08/15 06:55:34  kelsaka
	/// - initial creation
	///
	/// </code>
	/// </remarks>
	public class AttributeNotSupportedException : ApplicationException
	{
		private string errorMessage;

		/// <summary>
		/// Constructor supporting error message.
		/// </summary>
		/// <param name="errorMessage">The message of the error.</param>
		public AttributeNotSupportedException(string errorMessage)
		{
			this.errorMessage = errorMessage;
		}

		public override string Message
		{
			get
			{
				return base.Message + " " + errorMessage;
			}
		}

		public override string ToString()
		{
			return base.ToString () + " " + errorMessage;;
		}

	}
}
