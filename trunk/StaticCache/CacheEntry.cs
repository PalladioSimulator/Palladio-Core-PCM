using System;

namespace StaticCache
{
	/// <summary>
	/// Zusammenfassung für CacheEntry.
	/// </summary>
	public class CacheEntry
	{
		protected byte[] content;
		protected int timesVisited;
		protected int timesRequested;
		protected DateTime lastTimeRequested;
		protected DateTime lastTimeModified;
		protected string id;


		public CacheEntry()
		{
			this.timesVisited =0;
			this.LastTimeModified = DateTime.MinValue;
			this.lastTimeRequested = DateTime.Now;
		}

		public string ID
		{
			get{return this.id;}
			set{this.id = value;}
		}


		public byte[] Content
		{
			get
			{
				this.timesVisited++;
				this.lastTimeRequested = DateTime.Now;
				return this.content;
			}
			set{this.content = value;}		
		}

		public int TimesVisit
		{
			get
			{
				this.lastTimeRequested = DateTime.Now;
				return this.timesVisited;
			}
			set{this.timesVisited = value;}		
		}

		public int TimesRequested
		{
			get{return this.timesRequested;}
			set{this.timesRequested = value;}
		}

		public DateTime LastTimeModified
		{
			get{return this.lastTimeModified;}
			set{this.lastTimeModified = value;}
		}

		public DateTime LastTimeRequested
		{
			get{return this.lastTimeRequested;}
		}

	}
}
