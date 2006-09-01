using System;
using System.Collections;

namespace DBAcesses
{
	/// <summary>
	/// Zusammenfassung für DatabaseTable.
	/// </summary>
	public class DatabaseTable
	{
		string tableName;
		IList entries;
		public DatabaseTable()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public string TableName
		{
			get{return this.tableName;}
			set{this.tableName = value;}
		}

		public IList Entries
		{
			get{return this.entries;}
			set{this.entries = value;}
		}
	}

}
