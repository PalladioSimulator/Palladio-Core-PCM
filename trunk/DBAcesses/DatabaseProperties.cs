using System;
using System.Collections;

namespace DBAcesses
{
	/// <summary>
	/// Encapsolates the database properties.
	/// </summary>
	public class DatabaseProperties
	{
		private string datasource;
		private DatabaseTable[] tables;

		/// <summary>
		/// Initiates a new database properties.
		/// </summary>
		public DatabaseProperties()
		{
			//later it can be storted in a properties file
			this.datasource = @"INSPIRON";
			this.tables = new DatabaseTable[2];
			this.tables[0] = new DatabaseTable();
			this.tables[0].TableName = "Bibtex";
			this.tables[0].Entries = InsertBibTexTable();
			this.tables[1] = new DatabaseTable();
			this.tables[1].TableName = "UserStatistics";
			this.tables[1].Entries = InsertUserStatistics();

		}


		/// <summary>
		/// Each database 
		/// </summary>
		/// <param name="tablename"></param>
		/// <returns></returns>
		public DatabaseTable GetAssociatedTable(string tablename)
		{
			foreach (DatabaseTable d in this.tables)
			{
				if (d.TableName == tablename)
					return d;
			}
			throw new Exception("The requested Tablename doesn't exist");
		}


		/// <summary>
		/// Returns the colum names of the UserStatistics Table.
		/// </summary>
		/// <returns>In the representaion of a <c>IList</c>/returns>
		public IList InsertUserStatistics()
		{
			IList list = new ArrayList();
			//list.Add("ID");
			list.Add("uri");
			list.Add("filetype");
			list.Add("filesize");
			list.Add("roundtriptime");
			list.Add("dateTime");
			return list;
		}


		/// <summary>
		/// Returns the colum names of the BibTex Table.
		/// </summary>
		/// <returns>In the representaion of a <c>IList</c>/returns>
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


		/// <summary>
		/// ´Delivers all DatabaseTables in an <c>IList</c>.
		/// </summary>
		public IList Tables
		{
			get { return this.tables; }
		}


		/// <summary>
		/// Returns the name of the database.
		/// </summary>
		public string Datasource
		{
			get { return this.datasource; }
		}


	}
}