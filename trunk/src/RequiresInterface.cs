using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public class RequiresInterface : AbstractIModel	 
	{

		// Delegate
		IInterfaceModel requiresIM;

		public RequiresInterface() 
		{
		}

		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			anErrorList = null;
			return false;
		}

		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			return null;
		}

		public override object Clone()
		{
			return null;
		}
	}
}
