using System;
using System.Collections;

namespace DBAcesses
{
	/// <summary>
	/// Entkapselt die Eigenschaften der Datenbank
	/// </summary>
	public class DatabaseProperties
	{
		/// <summary>
		/// DatabaseLocation
		/// </summary>
		string database;
		DatabaseTable[] tables;
		public DatabaseProperties()
		{
			//later it can be storted in a properties fiele
			this.database =@"RAFIKI\NAGINI ";
			this.tables = new DatabaseTable[1];
			this.tables[0] = new DatabaseTable();
			this.tables[0].TableName = "Bibtex";
			
			this.tables[0].Entries = InsertBibTexTable();
			
		}

		public DatabaseTable GetAssociatedTable(string tablename)
		{
			foreach(DatabaseTable d in this.tables)
			{
				if(d.TableName==tablename)
					return d;
			}
			throw new Exception("The requested Tablename doesn't exist");
		}


		public IList InsertBibTexTable()
		{
			IList list = new ArrayList();
			list.Add("ID");
			list.Add("abstract");
			list.Add("annote");
			list.Add("note");
			list.Add("number");
			list.Add("journal");
			list.Add("volume");
			list.Add("pages");
			list.Add("publisher");
			list.Add("editor");
			list.Add("booktitle");
			list.Add("year");
			list.Add("title");
			list.Add("author");
			list.Add("label");
			list.Add("type");
			return list;
		}

		public IList Tables
		{
			get{return this.tables;}
		}


		public string Database
		{
			get{return this.database;}
		}


	}
}
