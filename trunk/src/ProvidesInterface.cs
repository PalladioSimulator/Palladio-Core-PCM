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
		private IInterfaceModel providesIModel;
		
		private IList serviceList;


		public ProvidesInterface(IInterfaceModel anProvidesIModel) 
		{
			providesIModel = (IInterfaceModel) anProvidesIModel.Clone();
		}

		public ProvidesInterface(IInterfaceModel anProvidesIModel, IList aServiceList) : this (anProvidesIModel) 
		{
			serviceList = new ArrayList(aServiceList);
		}

		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			return providesIModel.IsSubSetOf(anIModel, out anErrorList);
		}

		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			if (anIModel is ProvidesInterface) 
			{
				// TODO Merge Provides-Interfaces correctly
			}
			return null;

		}

		public override object Clone()
		{
			return new ProvidesInterface(providesIModel, serviceList);
		}
	}
}
