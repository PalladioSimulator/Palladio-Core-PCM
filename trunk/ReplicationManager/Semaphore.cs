using System.Threading;

namespace ServiceReplication
{
	/// <summary>
	/// Zusammenfassung für Semaphore.
	/// </summary>
	public class Semaphore
	{
		private int value;
		private object myLock;

		public Semaphore(int initial)
		{
			value = initial;
			myLock = new object();
		}

		public Semaphore() : this(1)
		{
		}

		public void Up()
		{
			Monitor.Enter(myLock);
			value++;
			Monitor.Pulse(myLock);
			Monitor.Exit(myLock);
		}

		public void Down()
		{
			Monitor.Enter(myLock);
			while (value == 0) Monitor.Wait(myLock);
			value--;
			Monitor.Exit(myLock);
		}
	}
}