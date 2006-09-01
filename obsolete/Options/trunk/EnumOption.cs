using System;
using Options.Interfaces;

namespace Options
{
	/// <summary>
	/// Zusammenfassung für EnumOption.
	/// </summary>
	public class EnumOption : Option
	{
		private Type enumType;
		protected object val = null;

		public override object Value
		{
			get
			{
				return val;
			}
			set
			{
				if (!value.GetType().Equals(enumType))
					throw new Exception("Wrong enum");
				val = value;
			}
		}

		public EnumOption(string id, string description, Type enumType) : base (id, description)
		{
			this.type = OptionType.ENUMERATION;
			this.enumType = enumType;
		}
	}
}
