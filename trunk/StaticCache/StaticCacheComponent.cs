using System;
using System.Collections;
using Delivery;
using Request;
using System.IO;
using StaticFileProvider;

namespace StaticCache
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class StaticCacheComponent :IDeliverResponse
	{
		protected Hashtable cache;
		protected int visitTimesToBeCached;
		protected int maxCountOfCachedSites;
		protected int actualCountOfChachedPages;

		protected byte[] response;

		IDeliverResponse sucessor;

		protected Hashtable usserStatistics;

		protected StaticFileProviderComponent fileProvider;
		
		public StaticCacheComponent(ref StaticFileProviderComponent fileProvider)
		{
			this.usserStatistics = new Hashtable();
			this.fileProvider = fileProvider;
		}

		public IDeliverResponse DeliverResonse(HttpRequest r,string path)
		{
			
			if(IsResponsible(r,path))
			{
				this.response = ((CacheEntry) this.cache[r.URI]).Content;
				((CacheEntry) this.cache[r.URI]).TimesVisit ++;
				return this;
			}
			else 
			{
				return this.sucessor.DeliverResonse(r,path);
			}
		}

		internal bool CacheFull
		{
			get{return this.maxCountOfCachedSites == this.actualCountOfChachedPages;}
		}

		public byte[] GetResponse
		{
			get{return this.response;}
		}

		public int GetFileSize
		{
			get{return this.response.Length;}
		}

		public Stream  DeliverResponseStream()
		{
			return new MemoryStream(this.response);
		}


		public DateTime LastModified()
		{
			return DateTime.Now;
		}

		public IDeliverResponse Sucessor
		{
			get{ return this.sucessor;}
			set{ this.sucessor = value;}
		}

		private bool IsResponsible(HttpRequest r,string path)
		{
			//es handelt sich um eine statische Seite
			if(r.RequestedMethod=="GET"&& r.UserInput==null )
			{
				if(this.cache.ContainsKey(r.URI))
				{
					return true;
				}
				else 
				{
					HandleCacheMiss(r,path);
				}
			}
			return false;
		}
	

		internal void HandleCacheMiss(HttpRequest request, string path)
		{
			//if it hasn't been visit jet, add new entry
			if(!this.usserStatistics.ContainsKey(request.URI))
			{
				CacheEntry temp = new CacheEntry();
				temp.TimesVisit = 1;
				this.usserStatistics.Add(request.URI,temp);
			}

				//uri has already been requested
			else
			{
				CacheEntry ca = (CacheEntry) this.usserStatistics[request.URI];
				if(ca.TimesRequested < this.visitTimesToBeCached)
				{
					ca.TimesVisit ++;
					this.usserStatistics.Remove(this.usserStatistics[request.URI]);
					this.usserStatistics.Add(request.URI,ca);
				}
					//now it s time to cache this entry
				else if(ca.TimesRequested == this.visitTimesToBeCached)
				{
					ca.Content = this.fileProvider.GetFile(path);
					ca.TimesVisit = 1;
					this.cache.Add(request.URI,ca);
				}
				//if the cache is full an entry has to be removed
				else if(CacheFull)
				{
					ReplaceEntryAndAddNew(request,path);
				}
			}
		}

		internal void ReplaceEntryAndAddNew(HttpRequest request, string path)
		{
			//Here you ve to decide which strategie you want to use
			CacheEntry willBeRemoved = GetLeastRecentlyUsedcacheEntry();
			this.cache.Remove(willBeRemoved);
		}

		internal CacheEntry GetLeastRecentlyUsedcacheEntry()
		{
			DateTime LRUDate = DateTime.Now;
			CacheEntry returnValue = null;
			foreach(CacheEntry ce in this.cache)
			{
				if(ce.LastTimeRequested< LRUDate)
				{
					LRUDate = ce.LastTimeRequested;
					returnValue = ce;
				}
			}
			return returnValue;
		}

		internal CacheEntry GetLeastFrequentlyUsedCacheEntry()
		{
			CacheEntry returnValue =null;
			int minimum= int.MaxValue;
			foreach(CacheEntry ce in this.cache)
			{
				if(ce.TimesRequested < minimum)
				{
					minimum = ce.TimesRequested;
					returnValue = ce;
				}
			}
			return returnValue;
		}

		/// <summary>
		/// This prints the content of tghe cache. It is used for debugging.
		/// </summary>
		/// <returns></returns>
		internal string PrintcacheContonent()
		{
			string cacheContent ="Cache Content: \n";
			foreach(DictionaryEntry di in this.cache)
			{
				cacheContent+="URI: "+di.Value.ToString()+"\n";
				cacheContent+="Times rewuested: "+ ((CacheEntry) di.Value).TimesRequested.ToString();
			}
			return cacheContent;
		}
	}
}

		/**
		LRU (least-recently-used):
		Ersetzt wird der am längsten unreferenzierte Block. 
		Da die zuletzt referenzierten Blöcke am wahrscheinlichsten in der Zukunft 
		wieder referenziert werden, darf man vermuten, dass dieser Algorithmus die 
		niedrigste miss-rate ergibt. Implementiert werden kann er mit Hilfe von 
		zusätzlichen Statusbits pro Zeile. 
		
		FIFO (first-in-first-out):																																																																												 FIFO (first-in-first-out):
		Ersetzt wird der Block, der am längsten im Cache war. Die Implementation kann 
		einfach z.B. mit einem round-robin-schedule erfolgen 
					
		LFU (least-frequently-used):													
		Ersetzt wird der Block, der am wenigsten benutzt wurde. Bei der Implementierung 
		muß ein Zähler pro Zeile hinzugefügt werden. 
		Random:
		Ersetzt wird ein (pseudo-) zufällig ausgewählter Block. Dieser 
		Nicht-Nutzungsbasierte Algorithmus kann bei einer Set-Größe von  
		z.B. mit einem einzigen -Zähler, der durch beliebige Systemereignisse 
		incrementiert wird und den zu ersetzenden Block auswählt, einfach und effizient
		implementiert werden. 
		Simulationsstudien zeigen, dass ein Random-Ersetzungs-Algorithmus nur eine 
		geringfügig schlechtere Performance ergibt, als nutzungsbasierte Algorithmen 
		Quelle: http://www.mstar.de/Cache/
		*/																																																										
        