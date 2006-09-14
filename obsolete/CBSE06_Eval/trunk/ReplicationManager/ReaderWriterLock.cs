namespace ServiceReplication
{
	/// <summary>
	/// Reader-Writer lock with writer priority.
	/// </summary>
	public class ReaderWriterLock : IReaderWriterLock
	{
		// counter
		private int readcount, writecount;
		// Semaphores:
		private object x, y, z;
		private Semaphore wsem, rsem;

		public ReaderWriterLock()
		{
			readcount = 0;
			writecount = 0;
			x = new object();
			y = new object();
			z = new object();
			wsem = new Semaphore();
			rsem = new Semaphore();
		}

		public void AcquireReader()
		{
			lock (z)
			{
				rsem.Down();
				{
					lock (x)
					{
						readcount++;
						if (readcount == 1)
						{
							wsem.Down();
						}
					}
				}
				rsem.Up();
			}
		}

		public void ReleaseReader()
		{
			lock (x)
			{
				readcount--;
				if (readcount == 0)
				{
					wsem.Up();
				}
			}
		}

		public void AcquireWriter()
		{
			lock (y)
			{
				writecount++;
				if (writecount == 1)
				{
					rsem.Down();
				}
			}
			wsem.Down();
		}

		public void ReleaseWriter()
		{
			wsem.Up();
			lock (y)
			{
				writecount--;
				if (writecount == 0)
				{
					rsem.Up();
				}
			}
		}
	}
}