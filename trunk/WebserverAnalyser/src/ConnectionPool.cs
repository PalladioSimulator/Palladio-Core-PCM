using System;
using System.Collections;
using System.Data.SqlClient;

namespace Palladio.Reliability.WebserverAnalyser
{
	/// <summary>
	/// Connection Pool. -> Pool Pattern.
	/// </summary>
	public class ConnectionPool
	{
		private string connectionString;

		/// <summary>
		/// Contains all active connections.
		/// Keys = SqlConnection
		/// Value = null
		/// </summary>
		private Hashtable activeHash;

		/// <summary>
		/// Contains all passive connections
		/// </summary>
		private Stack passiveStack;

		/// <summary>
		/// Indicates whether the connections in the pool are open or not.
		/// </summary>
		private bool isOpen;

		public ConnectionPool(string connectionString)
		{
			this.isOpen = false;
			this.connectionString = connectionString;
			this.activeHash = new Hashtable();
			this.passiveStack = new Stack();
			SqlConnection connection = new SqlConnection(connectionString);
			passiveStack.Push(connection);
		}

		/// <summary>
		/// Opens all connections in the pool.
		/// </summary>
		public void Open()
		{
			foreach (SqlConnection connection in passiveStack)
			{
				connection.Open();
			}
			foreach (SqlConnection connection in activeHash.Keys)
			{
				connection.Open();
			}
			isOpen = true;
		}

		/// <summary>
		/// Indciates whether the connection in the pool are open or not.
		/// </summary>
		public bool IsOpen
		{
			get { return isOpen; }
		}

		/// <summary>
		/// True, if there are still some active connections around.
		/// </summary>
		/// <returns></returns>
		public bool ConnectionsActive
		{
			get { return activeHash.Count > 0; }
		}

		/// <summary>
		/// Closes all connections in the pool. Note, that all
		/// connections must be passive!
		/// </summary>
		public void Close()
		{
			if (ConnectionsActive)
				throw new ApplicationException("There are still some connections active!");
			foreach (SqlConnection connection in passiveStack)
			{
				connection.Close();
			}
			isOpen = false;
		}

		/// <summary>
		/// Closes all connections in the pool. Note, that all
		/// connections must be passive!
		/// </summary>
		public void ForceClose()
		{
			foreach (SqlConnection connection in activeHash.Keys)
			{
				connection.Close();
			}
			foreach (SqlConnection connection in passiveStack)
			{
				connection.Close();
			}
			isOpen = false;
		}

		/// <summary>
		/// Returns a connection from the pool.
		/// </summary>
		/// <returns></returns>
		public SqlConnection BorrowConnection()
		{
			SqlConnection connection;
			if (passiveStack.Count>0)	 
			{
				connection = (SqlConnection) passiveStack.Pop();
			}
			else
			{
				connection = new SqlConnection(connectionString);
				if (isOpen)
					connection.Open();
			}
			activeHash.Add(connection,null);
			return connection;
		}

		public void ReturnConnection(SqlConnection connection)
		{
			if (!activeHash.ContainsKey(connection))
				throw new ApplicationException("This connection does not belong to this pool!");
			activeHash.Remove(connection);
			passiveStack.Push(connection);
		}

		/// <summary>
		/// Hide the default constructor.
		/// </summary>
		private ConnectionPool(){}
	}
}
