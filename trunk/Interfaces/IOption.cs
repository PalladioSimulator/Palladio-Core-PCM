using System;

namespace Options.Interfaces
{
	/// <summary>
	/// Zusammenfassung für IOption.
	/// </summary>
	public interface IOption
	{
		string ID
		{
			get;
		}

		string Description
		{
			get;
		}
		
		object Value
		{
			get; set;
		}

		OptionType Type
		{
			get;
		}
	}
}
