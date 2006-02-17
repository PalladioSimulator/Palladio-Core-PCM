using System;
using System.Collections;
using System.Runtime.Remoting.Channels.Tcp;
using RemoteClient;

namespace ServiceReplication
{
	public class ReplicatedService : IServiceClass
	{
		private ReplicationManager manager;
		private TcpChannel channel;
		Hashtable replicaTable;

		private static bool saved = false;
		private static object myLock = new object();
		
		public ReplicatedService(string replicationURI, TcpChannel channel, string name)
		{
			this.channel = channel;
			manager = (ReplicationManager) Activator.GetObject(typeof (ReplicationManager), replicationURI);
			replicaTable = new Hashtable();
			string[] replicas = manager.GetReplicaList();
			foreach (string replica in replicas)
			{
				replicaTable[replica] = new ServiceProbe(new DirectServiceProxy(replica,channel),name + "_"+"Replica_" + replica.Substring(replica.Length-12,4));
			}
		}

		public void WriteData(byte[] data)
		{
			string[] replicas = manager.AcquireAllReplicasForWriting();
			foreach (string replica in replicas)
			{
				IServiceClass service = (IServiceClass) replicaTable[replica];
				service.WriteData(data);
			}
			manager.ReleaseAllReplicasFromWriting();
		}

		public byte[] ReadData()
		{
			string replica = manager.GetReadReplica();
			IServiceClass service = (IServiceClass) replicaTable[replica];
			byte[] result = service.ReadData();
			manager.ReturnReadReplica(replica);
			return result;
		}

		public void PrintData()
		{
			string replica = manager.GetReadReplica();
			IServiceClass service = new DirectServiceProxy(replica, channel);
			service.PrintData();
			manager.ReturnReadReplica(replica);
		}

		public void Save()
		{
			foreach (ServiceProbe probe in replicaTable.Values)
			{
				probe.Save();
			}

			lock(myLock)
			{
				if(!saved)
				{
					saved = true;
					manager.Save();
				}
			}
		}
	}
}