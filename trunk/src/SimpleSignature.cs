using System;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public class SimpleSignature : AbstractSignature
	{
		#region Data
		
		private string name;
		#endregion

		#region Constructors

		public SimpleSignature(string aName)
		{
			name = aName;
		}

		public SimpleSignature(SimpleSignature  aSig) : this(aSig.Name) 
		{
		}
		#endregion

		#region Properties

		public override string Name
		{
			get
			{
				return name;
			}
		}
		#endregion

		#region Methods

		public override object Clone()
		{
			return new SimpleSignature(this);
		}

		public override bool Equals(object obj)
		{
			if (obj is SimpleSignature)
			{
				SimpleSignature sig = (SimpleSignature)obj;
				return sig.Match(this);
			}
			return false;
		}
		#endregion

	}
}
