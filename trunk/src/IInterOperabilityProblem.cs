using System;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public interface IInclusionError 
	{
		int ErrorLevel { get; }
		string Message { get; }
	}
}
