using System;
using System.Collections;

using Palladio.Identifier;
using Palladio.Utils.Collections;



namespace Palladio.ComponentModel.InterfaceModels
{
	internal class DefaultServiceList : IServiceList , ICloneable
	{
		#region Properties
		/// <summary>
		/// The number of service in this list
		/// </summary>
		public int Count
		{
			get
			{
				return services.Count;
			}
		}
		
		/// <summary>
		/// Indexer to access the sigantures easily.
		/// </summary>
		public IService this[int index]
		{
			get { return (IService) services[index]; }
		}

		#endregion
		
		#region Methods
		
		/// <summary>
		/// Adds an array of services to the list
		/// </summary>
		/// <param name="aServiceArray">service to be added.</param>
		public void AddServices( params IService[] aServiceArray )
		{
			foreach (IService s in aServiceArray)
			{
				if (ServiceListChangeEvent != null)
					ServiceListChangeEvent(this,new ServiceListChangeEventArgs(s, ChangeTimeEnum.BEFORE,ChangeTypeEnum.ADD));
			}
			services.AddRange(aServiceArray);
			foreach (IService s in aServiceArray)
			{
				if (ServiceListChangeEvent != null)
					ServiceListChangeEvent(this,new ServiceListChangeEventArgs(s, ChangeTimeEnum.AFTER,ChangeTypeEnum.ADD));
			}
		}

		/// <summary>
		/// Deletes a set of services from the list
		/// </summary>
		/// <param name="aServiceArray">services to be removed.</param>
		public void DeleteServices( params IService[] aServiceArray )
		{
			foreach (IService s in aServiceArray)
			{
				if (ServiceListChangeEvent != null)
					ServiceListChangeEvent(this,new ServiceListChangeEventArgs(s, ChangeTimeEnum.BEFORE,ChangeTypeEnum.DELETE));
			}
			foreach (IService s in aServiceArray)
			{
				services.Remove(s);
			}
			foreach (IService s in aServiceArray)
			{
				if (ServiceListChangeEvent != null)
					ServiceListChangeEvent(this,new ServiceListChangeEventArgs(s, ChangeTimeEnum.AFTER,ChangeTypeEnum.DELETE));
			}
		}

		public bool ContainsService( IService aService )
		{
			return services.Contains(aService);
		}

		public IService GetServiceByID( IIdentifier id )
		{
			foreach (IService s in services)
			{
				if (s.Signature.ID.Equals(id))
					return s;
			}
			return null;
		}

		public IService[] GetServices()
		{
			return (IService[]) services.ToArray(typeof(IService));
		}

		public IEnumerator GetEnumerator()
		{
			return services.GetEnumerator();
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new DefaultServiceList(this);
		}
		
		/// <summary>
		/// This event is raised before and after a change of the services in this list
		/// </summary>
		public event ServiceListChangeEventHandler ServiceListChangeEvent;
		#endregion

		#region Constructors

		/// <summary>
		/// Creates a ServiceList.
		/// </summary>
		/// <param name="anAttHash">Attributes.</param>
		/// <param name="aServiceArray">Services contained by the list.</param>
		public DefaultServiceList(params IService[] aServiceArray)
		{
			services = new Set();
			AddServices(aServiceArray);
		}

		/// <summary>
		/// Copy constructor.
		/// </summary>
		/// <param name="aServiceList">ServiceList to copy.</param>
		public DefaultServiceList(DefaultServiceList aServiceList) :
			this(aServiceList.GetServices() ) {}

		#endregion
		
		#region Data
		
		private Set services;
		#endregion
	}
}
