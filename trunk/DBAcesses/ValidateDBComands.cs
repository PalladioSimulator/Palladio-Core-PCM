using System;
using System.Collections;

namespace DBAcesses
{
	/// <summary>
	/// Zusammenfassung für ValidateDBComands.
	/// </summary>
	public class ValidateDBComands
	{
		IList properties;
		public ValidateDBComands(DatabaseProperties pro)
		{
			this.properties = pro.Tables;
		}

		//first Validate Table and then validate Entries has to be called
		internal bool ValidateTable(string tablename, Hashtable entries)
		{
			foreach(DatabaseTable dbt in this.properties)
			{
				if(dbt.TableName == tablename)
				{
					if(ValidateEntries(dbt,entries))
						return true;
				}
			}
			return false;
		}

		/// <summary>
		/// Compares the entries of the sql Comand from the other component with
		/// the real database entries
		/// In the Moment this is a verry simple Comparrison. It only compares entriename
		/// not their values.
		/// </summary>
		/// <param name="databaseTable"></param>
		/// <param name="entries"></param>
		/// <returns></returns>
		internal bool ValidateEntries(DatabaseTable databaseTable, Hashtable userEntries)
		{
			foreach(DictionaryEntry de in userEntries)
			{
				if(!databaseTable.Entries.Contains(de.Key.ToString()))
					return false;
			}
			return true;
		}

		public string OrderEntries(Hashtable entries,DatabaseTable db)
		{
			string rightOrder ="";
			for(int i=0; i< db.Entries.Count; i++)
			{
				try
				{
					rightOrder = rightOrder+"'"+entries[db.Entries[i].ToString()]+"',";
					Console.WriteLine("das soll in díe DB "+ rightOrder);
					Console.WriteLine(db.Entries[i].ToString());
					
				}
				catch(Exception)
				{
					rightOrder = rightOrder+"'none'";
				}
			}
			rightOrder = rightOrder.Remove(rightOrder.Length-1,1);
			Console.WriteLine("SQL String: "+rightOrder);
			return rightOrder;

		}


	}
}
