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


		public CacheEntry()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public byte[] Content
		{
			get{return this.content;}
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
