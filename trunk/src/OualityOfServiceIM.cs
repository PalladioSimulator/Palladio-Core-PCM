using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public class OualityOfServiceIModel : ProtocolIModel  
	{
		#region Data
		#endregion


		#region Constructors

		public OualityOfServiceIModel()	
		{
		}

		#endregion


		#region Methods

		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			anErrorList = null;
			return false;
		}

		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			return null;
		}

		public override IInterfaceModel Intersect(IInterfaceModel anIModel)
		{
			return null;
		}

		public override object Clone()
		{
			return null;
		}

		#endregion
	}
}
