using System;
using System.Collections;
using Delivery;
using Request;
using System.IO;
using StaticFileProvider;
using SimpleLogging;


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
		//protected int actualCountOfChachedPages;

		protected SimpleLogger logger;

		protected byte[] response;

		IDeliverResponse sucessor;

		protected Hashtable usserStatistics;

		protected StaticFileProviderComponent fileProvider;

		
		public StaticCacheComponent(ref StaticFileProviderComponent fileProvider)
		{
			this.usserStatistics = new Hashtable();
			this.cache = new Hashtable();
			this.visitTimesToBeCached = 2;
			this.maxCountOfCachedSites = 4;
			this.fileProvider = fileProvider;

			this.logger = new SimpleLogger(this);
			this.logger.DebugOutput = true;
			this.logger.FileOutput = true;

//			this.requesthasBeenread = false;
			this.response = System.Text.Encoding.ASCII.GetBytes("something has to be in here otherwise it can't be locked");
		}

		public IDeliverResponse DeliverResonse(HttpRequest r,string path)
		{
			
			if(IsResponsible(r,path))
			{
				Console.WriteLine(PrintcacheContonent());
				//ensures that no other Thread can manipulate the response
//				lock(this.response.SyncRoot)
//				{
					this.response = ((CacheEntry) this.cache[r.URI.ToString()]).Content;
					((CacheEntry) this.cache[r.URI]).TimesRequested ++;
//				}
				return this;
			}
			else 
			{
				return this.sucessor.DeliverResonse(r,path);
			}
		}

		internal bool CacheFull
		{
			get{return this.maxCountOfCachedSites == this.cache.Count;}
		}

		public byte[] GetResponse
		{
			get{
//				this.requesthasBeenread = true;
				return this.response;}
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
					this.logger.Debug(this.PrintcacheContonent());
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
			lock(this.cache.SyncRoot)
			{
				//Console.WriteLine(PrintcacheContonent());
				//if it hasn't been visit jet, add new entry
				if(!this.usserStatistics.ContainsKey(request.URI))
				{
					this.usserStatistics.Add(request.URI,1);
				}

					//uri has already been requested
				else
				{
					int timesUsed = (int) this.usserStatistics[request.URI];
					if(timesUsed < this.visitTimesToBeCached)
					{
						timesUsed++;
						this.usserStatistics.Remove(request.URI);
						this.usserStatistics.Add(request.URI,timesUsed);
					}
						//now it s time to cache this entry
					else if(timesUsed == this.visitTimesToBeCached)
					{
						if(CacheFull)
						{
							ReplaceEntryAndAddNew(request,path);
						}
					
						CacheEntry ce = new CacheEntry();
						ce.Content = this.fileProvider.GetFile(path);
						ce.ID = request.URI;
						ce.TimesVisit = 1;
						this.cache.Add(request.URI.ToString(),ce);
							
					}
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
			foreach(CacheEntry ce in this.cache.Values)
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
			string cacheContent ="Cache Content: \n\r";
			foreach(DictionaryEntry di in this.cache)
			{
				cacheContent+="URI: "+di.Key.ToString()+"\n\r";
				cacheContent+="Times requested: "+ ((CacheEntry) di.Value).TimesRequested.ToString()+"\n";
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
        