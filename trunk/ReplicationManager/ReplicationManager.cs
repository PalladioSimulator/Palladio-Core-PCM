using System;
using System.Collections;
using System.Threading;
using Measurement;
using Service;

namespace ServiceReplication
{
	/// <summary>
	/// </summary>
	public class ReplicationManager : MarshalByRefObject
	{
		private Queue availableReplicas;
		private ArrayList allReplicas;
		private IReaderWriterLock rwLock;

		TimeArray readerWaitingTimes;
		TimeArray replicaWaitingTimes;
		TimeArray writerWaitingTimes;


		public ReplicationManager()
		{
			rwLock = new ReaderWriterLock();
			allReplicas = new ArrayList();
			allReplicas.Add("tcp://localhost:8085/Service");
			allReplicas.Add("tcp://localhost:8086/Service");
			allReplicas.Add("tcp://localhost:8087/Service");
			allReplicas.Add("tcp://localhost:8088/Service");
			allReplicas.Add("tcp://localhost:8089/Service");
			availableReplicas = new Queue(allReplicas);

			readerWaitingTimes = new TimeArray("readerWaitingTime");
			replicaWaitingTimes = new TimeArray("replicaWaitingTime");
			writerWaitingTimes = new TimeArray("writerWaitingTime");
		}

		public string GetReadReplica()
		{
			HiResTimer timer = new HiResTimer();			
			string selectedReplica;

			timer.Start();
			rwLock.AcquireReader();
			timer.Stop();
			readerWaitingTimes.Add(timer.ElapsedMicroseconds);

			timer.Start();
			Monitor.Enter(availableReplicas);
			while (availableReplicas.Count == 0) Monitor.Wait(availableReplicas);
			selectedReplica = (string) availableReplicas.Dequeue();
			Monitor.Exit(availableReplicas);
			timer.Stop();
			replicaWaitingTimes.Add(timer.ElapsedMicroseconds);

			Console.WriteLine("GET: " + selectedReplica);
			return selectedReplica;
		}

		public void ReturnReadReplica(string replica)
		{
			Monitor.Enter(availableReplicas);
			availableReplicas.Enqueue(replica);
			Monitor.Pulse(availableReplicas);
			Monitor.Exit(availableReplicas);
			rwLock.ReleaseReader();

			Console.WriteLine("RET: " + replica);
		}

		public string[] AcquireAllReplicasForWriting()
		{
			HiResTimer timer = new HiResTimer();
			Console.WriteLine("START write to all");
			timer.Start();
			rwLock.AcquireWriter();
			timer.Stop();
			writerWaitingTimes.Add(timer.ElapsedMicroseconds);
			return (string[]) allReplicas.ToArray(typeof (string));
		}

		public void ReleaseAllReplicasFromWriting()
		{
			rwLock.ReleaseWriter();
			Console.WriteLine("STOP write to all");
		}

		public string[] GetReplicaList()
		{
			return (string[])allReplicas.ToArray(typeof(string));
		}

		public void Save()
		{
			readerWaitingTimes.Save();
			writerWaitingTimes.Save();
			replicaWaitingTimes.Save();
		}
	}
}