using System;

namespace Options.Interfaces
{
	/// <summary>
	/// Zusammenfassung für IOptions.
	/// </summary>
	public interface IOptions : ICloneable
	{
		object this[string optionID]
		{
			get; set;
		}
	}
}
