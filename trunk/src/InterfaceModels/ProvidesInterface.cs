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
		/// Intersects this IInterfaceModel and anIModel. 
		/// The result contains alls services and relationships wich exist in both
		/// IInterfaceModels.
		/// </summary>
		/// <param name="anIModel">IInterfaceModel to intersect with.</param>
		/// <returns>A new IInterfaceModel representing the intersection 
		/// of both IInterfaceModels</returns>
		public override IInterfaceModel GetIntersection(IInterfaceModel anIModel)
		{
			if (anIModel is ProvidesInterface) 
			{
				ProvidesInterface prvIface = (ProvidesInterface) anIModel;
				ProvidesInterface result = (ProvidesInterface) base.GetIntersection(anIModel);
				result.serviceList = new Vector();
				foreach(Service srv in this.ServiceList) 
				{
					if (prvIface.ServiceList.Contains(srv))
					{
						result.serviceList.Add(srv);
					}
				}
				return result;
			}
			else
			{
				throw new IModelNotProvidesInterfaceException();
			}
		}

		/// <summary>
		/// Merges this IInterfaceModel with anIModel.
		/// </summary>
		/// <param name="anIModel">An IInterfaceModel which is merged with this one.</param>
		/// <returns>A new IInterfaceModel created by merging this IInterfacemodel an anIModel.</returns>
		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			if (anIModel is ProvidesInterface) 
			{
				ProvidesInterface prvIface = (ProvidesInterface) anIModel;
				ProvidesInterface result = (ProvidesInterface) base.Merge(anIModel);
				result.serviceList = new Vector(this.ServiceList);
				foreach(Service srv in prvIface.ServiceList) 
				{
					if (!result.ServiceList.Contains(srv))
					{
						result.serviceList.Add(srv);
					}
				}
				return result;
			}
			else
			{
				throw new IModelNotProvidesInterfaceException();
			}
		}
		
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

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			string result = base.ToString()+"\nServiceList:\n";
			foreach (Service srv in ServiceList)
			{
				result += srv+"\n";
			}
			return result;
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
		/// <param name="aProvidesIModel">IInterfaceModel describing 
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
