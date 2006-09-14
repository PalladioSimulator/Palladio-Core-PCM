using System;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Interface for errors which can occur during an inclusion check 
	/// of two interfaces.
	/// </summary>
	public interface IInclusionError 
	{
		/// <summary>
		/// ErrorLevel indicating how serious the
		/// error is.
		/// </summary>
		int ErrorLevel { get; }

		/// <summary>
		/// Message discribing the error.
		/// </summary>
		string Message { get; }
	}
}
