using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Contains the information about the services provided by a component.
	/// </summary>
	public class ProvidesInterface : AbstractComponentInterface    
	{

		#region Data
		private IList serviceList;

		#endregion

		#region Properties

		/// <summary>
		/// List of Service objects. A Service links a signature with a
		/// service effect specification.
		/// </summary>
		public IList ServiceList 
		{
			get { return serviceList; }
		}
		#endregion

		#region Constructors
		
		public ProvidesInterface(IInterfaceModel anProvidesIModel) 
		{
			iModel = (IInterfaceModel) anProvidesIModel.Clone();
		}

		public ProvidesInterface(IInterfaceModel anProvidesIModel, IList aServiceList) : this (anProvidesIModel) 
		{
			serviceList = new ArrayList(aServiceList);
		}

		public ProvidesInterface( ProvidesInterface aProvIFace ) :
			this( aProvIFace.IModel, aProvIFace.ServiceList ) {}

		#endregion

		#region Methods

		public override object Clone()
		{
			return new ProvidesInterface(this);
		}

		#endregion
	}
}
