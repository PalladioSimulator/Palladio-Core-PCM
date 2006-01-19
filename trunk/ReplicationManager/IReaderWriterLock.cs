namespace ServiceReplication
{
	public interface IReaderWriterLock
	{
		void AcquireReader();
		void ReleaseReader();
		void AcquireWriter();
		void ReleaseWriter();
	}
}