using System;

namespace Palladio.FiniteStateMachines.Serializer
{
	/// <summary>
	/// Exception that is rised if a <see cref="IInput" /> is not supported.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/08/25 08:57:22  kelsaka
	/// - added exception
	///
	/// </code>
	/// </remarks>
	public class InputNotSupportedException : ApplicationException
	{
		private string errorMessage;

		/// <summary>
		/// Constructor supporting error message.
		/// </summary>
		/// <param name="errorMessage">The message of the error.</param>
		public InputNotSupportedException(string errorMessage)
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
