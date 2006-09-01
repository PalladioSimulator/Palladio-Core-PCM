using System;
using System.Collections;
using Options.Interfaces;

namespace Options
{
	/// <summary>
	/// Zusammenfassung für Options.
	/// </summary>
	public class Options : IOptions
	{
		protected Hashtable optionHash = new Hashtable();

		public Options() {}

		protected Options(Hashtable optionHash)
		{
			this.optionHash = optionHash;
		}

		public object this[string optionID]
		{
			get
			{
				return ((IOption)optionHash[optionID]).Value;
			}
			set
			{
				((IOption)optionHash[optionID]).Value = value;
			}
		}
		
		public void AddOption (IOption option)
		{
			optionHash.Add(option.ID,option);
		}

		public object Clone()
		{
			return new Options(optionHash);
		}
	}
}
