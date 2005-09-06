// TODO: What if the cached object has more than one constructor
// TODO: What if Getter, Setter are implemented as Properties ???  
#region info
///////////////////////////////////////////////////////////////////////////////
/// This software has been developed as a part of the diploma thesis 
/// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
/// Komponentenadapter" ("Influence of the configuration of a generator on the 
/// prediction of the QoS of component adaptors")
/// at the 
/// University of Oldenburg
/// Department of Computing Science
/// Software Engineering Group
/// Palladio Research Group
/// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
/// 
/// Development period: July 2005 - January 2006
/// 
/// Author: Niels Streekmann
/// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion
#region Description
////////////////////////////////////////////////////////////////////////////////////////
// Generated from CacheAdaptor.cst
// Generated on 01.09.2005 
//
// Deployment instructions:
// 1. Copy the generated code into a new VisualStudio project and name the file
//    ServiceCacheAdaptor.cs 
// 2. Add the assembly of the original service (probably TestService.dll)
//    to the project references. 
// 3. Build the ServiceCacheAdaptor component.
// 4. Use the newly build component instead of the original service. 
////////////////////////////////////////////////////////////////////////////////////////
#endregion

using Palladio.Utils.Collections;
using System;
using System.Collections;
using Palladio.QoSAdaptor.TestService;

namespace Palladio.QoSAdaptor.Measurement 
{

	/// <summary>
	/// This class implements a cache component for the Service service.
	/// In this first version the component is only able to cache data services with 
	/// one getter and one setter method using the same indexer to index the returned 
	/// resource. 
	/// The resources returned by getter are saved in a Palladio.Utils.Collections.Hashmap.
	/// The cache is an generative implementation of the design pattern described in 
	/// Kircher/Jain: Pattern-oriented software architecture volume 3 - Patterns for
	/// resource management (pp. 83-96)
	/// The cache implements the methods acquire and release described by the Cache 
	/// pattern.
	/// lock(this) is used in the public methods to secure concurrent access.
	/// </summary>
	public class ServiceCacheAdaptor
	{
		#region data
		private Service cachedObject;
		
		private Hashmap map;
		private int cacheSize;
		#endregion
	
		#region inner classes
		/// <summary>
		/// A ResourceWrapper holds an instance of a resource returned by the 
		/// Get method of Service and additional information 
		/// needed by the cache implementation. 
		/// In this first version the additional information consists of data needed 
		/// by the LRU eviction strategy. 
		/// </summary>
		private class ResourceWrapper 
		{
			private int resource;
			private int id;
			private DateTime lastUse;
			
			/// <summary>
			/// Constructs a ResourceWrapper using a given resource and sets the 
			/// initial values if the eviction strategy data.
			/// </summary>
			public ResourceWrapper(int resource, int id) 
			{
				this.resource = resource;
				this.id = id;
				this.lastUse = DateTime.Now;			}
			
			public int Resource
			{
				get 
				{
					return this.resource;
				}
			}
			
			public int Id
			{
				get 
				{
					return this.id;
				}
			}
			
			public DateTime Date 
			{
				get 
				{
					return this.lastUse; }
			}
			
			/// <summary>
			/// This method has to be called whenever the wrapped resource is used. 
			/// It sets the resets the values of the eviction strategy data. 
			/// </summary>
			public void Use()
			{
				this.lastUse = DateTime.Now;			}
		}
		#endregion
	 
		#region constructors
		public ServiceCacheAdaptor(
			)
		{

			// TODO: call constructor of the cachedObject with given parameters
			// i.e. adapt the constructor of the cachedObject.
			this.cachedObject = new Service();
			this.map = new Hashmap();
			this.cacheSize = 50;
		}
		#endregion
		

		#region methods described in the cache design pattern
		/// <summary>
		/// The release method releases a resource after usage. In this case usage means
		/// that the resource is taken from Service or the cache and 
		/// returned to the calling component. 
		/// The method puts resources that are used and not yet in the cache into the
		/// cache hashmap and calls the evict method if the number of resources in the 
		/// hashmap has reached the cache size. 
		/// </summary>
		/// <param name="resource">ResourceWrapper of the resource to be released.</param>
		private void Release (ResourceWrapper resource)
		{
			int id = resource.Id;
			if (!map.ContainsKey(id))
			{
				if (this.map.Count == this.cacheSize)
					this.Evict();
				this.map.Add(id, resource);
			}
		}
		

		/// <summary>
		/// The acquire method is called each time a resource shall be used. It returns
		/// the resource from the hashmap or calls the Get method of 
		/// Service if the resource is not yet in the cache.
		/// </summary> 
		/// <param name="id">ID of the aquired resource.</param>
		private ResourceWrapper Acquire (int id)
		{
			ResourceWrapper resource = (ResourceWrapper)this.map[id];
			if (resource == null)
			{
				resource = new ResourceWrapper(
					this.cachedObject.Get(id), id);
				//logger.Debug("acquire:Resource NOT in cache. Value = "+resource.Id);
			}
			//else
				//logger.Debug("acquire:Found Resource in cache. Value = "+resource.Id);
			
			return resource;
		}
		#endregion
	
		#region eviction
		/// <summary>
		/// This method implements the LRU eviction strategy.
		/// </summary>
		private void Evict()
		{
			IDictionaryEnumerator enu = this.map.GetEnumerator();
			enu.MoveNext(); 
			ResourceWrapper victim = (ResourceWrapper)enu.Value;
			while (enu.MoveNext()) 
			{
				ResourceWrapper res = (ResourceWrapper)enu.Value;
				if (victim.Date.CompareTo(res.Date) > 0)
					victim = res;
			}
			this.map.Remove(victim.Id);
			//logger.Debug("EVICTION victim = "+victim.Id);
		}
		#endregion	
	
		#region methods of the provided interface to be cached
		/// <summary>
		/// This method adapts the Get method of Service.
		/// Instead of calling that method directly the cache methods are used to 
		/// provide the requested service. 
		/// </summary>
		public int Get(int index)
		{
			lock(this)
			{
				ResourceWrapper resource = this.Acquire(index);
				// set informations needed for the eviction strategies.
				resource.Use();
				this.Release(resource);
				return resource.Resource;
			}
		}
	
		/// <summary>
		/// This method adapts the Set method of Service.
		/// Instead of calling that method directly the cache methods are used to 
		/// provide the requested service. 
		/// </summary>
		public void Set(int index, int newResult)
		{
			lock(this)
			{
				// TODO: implement write-back strategy!!!
			
				// implementation of write-through
				if (this.map.ContainsKey(index))
				{
					this.map[index] = new ResourceWrapper(newResult, index);
					//resource.Result = newResult;
					this.cachedObject.Set(index, newResult);
				}
				else 
					this.cachedObject.Set(index, newResult);
			}
		}
		#endregion
	}
}

