using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Contains information about the services provided by a component.
	/// </summary>
	public class ProvidesInterface : AbstractIModel 
	{

		/// <summary>
		/// IInterfaceModel describing the relationship 
		/// of the provided services.
		/// </summary>
		private IInterfaceModel providesIM;
		
		private IList serviceList;


		public ProvidesInterface() 
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
