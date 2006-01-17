using System;

namespace Palladio.QoSAdaptor.Exceptions
{
	/// <summary>
	/// Zusammenfassung für IncompleteInterfaceCopingException.
	/// </summary>
	public class IncompleteInterfaceCopingException :Exception
	{
		/// <summary>
		/// Constructor which calls the parent constructor with the given
		/// message.
		/// </summary>
		/// <param name="message">The exception message.</param>
		public IncompleteInterfaceCopingException(string message):
			base(message)
		{
			
		}
	}
}
