using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A ProvidesInterface is used to specify the services and its relations
	/// provided by a component.
	/// </summary>
	public class ProvidesInterface : AbstractComponentInterface    
	{
		#region Properties

		/// <summary>
		/// List of Service objects linking each signature to a
		/// service effect specification.
		/// </summary>
		public IList ServiceList 
		{
			get { return serviceList; }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new ProvidesInterface(this);
		}

		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
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


		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return base.GetHashCode ();
		}
		#endregion

		#region Constructors
		
		/// <summary>
		/// Creates a new ProvidesInterface using aProvidesIModel for
		/// the description of the provided services and aName as name
		/// of the interface. The ServicesList is empty, so the 
		/// provided signatures cannot be mapped onto a service effect
		/// specification.
		/// </summary>
		/// <param name="anProvidesIModel">IInterfaceModel describing 
		/// the provided services.</param>
		/// <param name="aName">An unique name of the interface.</param>
		public ProvidesInterface(IInterfaceModel aProvidesIModel, string aName) :
			base ( aProvidesIModel, aName )
		{
			serviceList = new Vector();
		}

		/// <summary>
		/// Creates a new ProvidesInterface using aProvidesIModel for
		/// the description of the provided services and aName as name
		/// of the interface. The ServicesList is used to map the
		/// signatures onto the service effect specifications.
		/// </summary>
		/// <param name="aProvidesIModel">IInterfaceModel describing 
		/// the provided services.</param>
		/// <param name="aServiceList">List of Service objects.</param>
		/// <param name="aName">An unique name of the interface.</param>
		public ProvidesInterface(IInterfaceModel aProvidesIModel, IList aServiceList, string aName) : this (aProvidesIModel, aName) 
		{
			serviceList = new Vector(aServiceList);
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aProvIface">ProvidesInterface to copy.</param>
		public ProvidesInterface( ProvidesInterface aProvIface ) :
			this( aProvIface.IModel, aProvIface.ServiceList, aProvIface.Name ) {}

		#endregion
		#region Data
		private IList serviceList;

		#endregion
	}
}
