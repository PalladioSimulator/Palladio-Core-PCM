using System;
using Options.Interfaces;

namespace Options
{
	/// <summary>
	/// Zusammenfassung für Option.
	/// </summary>
	public abstract class Option : IOption
	{
		protected string description = "No description";
		protected OptionType type;
		protected string id = null;

		public string Description
		{
			get
			{
				return description;
			}
		}

		public OptionType Type
		{
			get
			{
				return type;
			}
		}

		public string ID
		{
			get
			{
				return id;
			}
		}

		public abstract object Value
		{
			get;
			set;
		}

		public Option(string id, string description)
		{
			this.description = description;
			this.id = id;
		}
	}
}
