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
		
		public ProvidesInterface(IInterfaceModel anProvidesIModel, string aName) :
			base ( anProvidesIModel, aName )
		{
		}

		public ProvidesInterface(IInterfaceModel anProvidesIModel, IList aServiceList, string aName) : this (anProvidesIModel, aName) 
		{
			serviceList = new Vector(aServiceList);
		}

		public ProvidesInterface( ProvidesInterface aProvIFace ) :
			this( aProvIFace.IModel, aProvIFace.ServiceList, aProvIFace.Name ) {}

		#endregion

		#region Methods

		public override object Clone()
		{
			return new ProvidesInterface(this);
		}

		public override bool Equals(object obj)
		{
			if (base.Equals(obj)) 
			{
				if (obj is ProvidesInterface)
				{
					return this.ServiceList.Equals(((ProvidesInterface)obj).ServiceList);
				}
			}
			return false;
		}


		#endregion
	}
}
