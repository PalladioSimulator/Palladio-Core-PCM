using System;
using DBAcesses;
using System.Data;
using System.Collections;
using Request;

namespace UserStatistics
{
	/// <summary>
	/// Delivers a ranking of all files which can be profided by the webserver. It deliver the
	/// 10 most requested files. For this a database connection is requiered. The result is
	/// presented in a HTML string.
	/// This class also provides a detailed information of a single file, which is provided
	/// by the server. This detail information contains the absolute number of times the file
	/// has been requested. And the average time the delivery for this file took. 
	/// </summary>
	public class UserStas
	{
		/// <summary>
		/// A reference to the component which handles the Database Connections
		/// </summary>
		DBAcessComponent db;
		Hashtable statistics;
		string result;
		Hashtable userInput;

		/// <summary>
		/// Returns the computed result as string. This string contains HTML. 
		/// More precisely it is a HTML table.
		/// </summary>
		/// <returns>The result of the computaion as HTML Table</returns>
		public string Result()
		{
			return this.result;
		}

		/// <summary>
		/// Inits a new entity and start the result computaion.
		/// </summary>
		/// <param name="dbc">A reference to the <c>DBAcess-Component</c>.</param>
		/// <param name="aRequest">The request which should be answered</param>
		public UserStas(ref DBAcessComponent dbc,HttpRequest aRequest)
		{

			this.db=dbc;
			if(aRequest.UserInput.Count!=0)
			{
				this.userInput = aRequest.UserInput;
				this.result=ComputeDetailedView();
			}
			else
			{
				this.statistics = new Hashtable();
				ComputeUserStas();
			}
		}


		/// <summary>
		/// Computes the Userstatistics and sets the result string.
		/// </summary>
		protected void ComputeUserStas()
		{

			DataSet completeDB;
			SearchDatabase(out completeDB);
			//degugOutput
			foreach(DataTable dt in completeDB.Tables)
			{
				foreach(DataRow dr in dt.Rows)
				{
					AddToStatisticTable(dr["uri"].ToString());
				}
			}

			string[] ranking = computeRanking();
			//IEnumerator re = ranking.GetEnumerator();
//			for(int i=0;i<ranking.Length;i++)
//				Console.WriteLine(ranking[i]);

			this.result = DeliverHtml(ranking,completeDB);
		}

		/// <summary>
		/// Generates the DataSet which is the base for further computation.
		/// This methods connectes itself to the Database and returns the result.
		/// </summary>
		/// <param name="completeDB">The result of the Databasequery.</param>
		private void SearchDatabase(out DataSet completeDB)
		{
			Hashtable search = new Hashtable();
			search.Add("uri","");
			search.Add("filetype","");
			search.Add("filesize","");
			search.Add("roundtriptime","");
			search.Add("dateTime","");
			completeDB = this.db.SearchForRows("UserStatistics",search);
		}
		
		/// <summary>
		/// If the user requested details for a single URI this methods computes the result.
		/// </summary>
		/// <returns>A HTML sting which the result of the request.</returns>
		protected string ComputeDetailedView()
		{
			int count =0;
			double time =0.0;
			double avarage =0.0;
			DataSet completeDB; 
			SearchDatabase(out completeDB);
			//degugOutput
			foreach(DataTable dt in completeDB.Tables)
			{
				foreach(DataRow dr in dt.Rows)
				{
//					Console.WriteLine(dr["uri"].ToString()+" == "+this.userInput["uri"].ToString());
					if(dr["uri"].ToString().Trim()==this.userInput["uri"].ToString().Trim())
					{
						count++;
						string rtt = dr["roundtriptime"].ToString();
						//rtt = rtt.Replace(',','.');
						time += double.Parse(rtt);
					}
				}
				avarage = time/count;
				//Console.WriteLine(this.userInput["uri"].ToString()+" wurde "+count+"besucht Auslieferungszeit: "+avarage.ToString());
				
			}
			string result = "<h2><span style=\"text-decoration: underline; font-weight: bold;\">Detailansicht zu "+this.userInput["uri"].ToString()+"</span></h2> ";
			result+= "Anzahl Anfragen:&nbsp;&nbsp; "+count+"<br>";
			result+="Mittlere Auslieferungszeit:&nbsp;&nbsp; "+avarage.ToString().Remove(5,avarage.ToString().Length-5)+"<br>";
			return result;
		}


		/// <summary>
		/// This method delivers the HTML result for the ranking.
		/// </summary>
		/// <param name="ranking">The sorted list of uris</param>
		/// <param name="db">The Database Component</param></param>
		/// <returns>A Html string which contains the result.</returns>
		protected string DeliverHtml(string[] ranking, DataSet db)
		{
			
			
			string result = "<table style=\"width: 100%; text-align: left;\" border=\"1\" cellspacing=\"2\" ";
			result+="cellpadding=\"2\"><tbody><tr><td style=\"vertical-align: top; font-weight: bold;\">Rang<br></td>";
			result+="<td style=\"vertical-align: top; font-weight: bold;\">Seitenname (URI)<br></td>";
			result+="<td style=\"vertical-align: top; font-weight: bold;\">Dateiformat<br></td><td style=\"vertical-align: top; font-weight: bold;\">Detailansicht<br> ";
			result+="</td></tr>";

			for(int i=0; i<ranking.Length;i++)
			{
				//DatabaseTable d = db.Tables;
				string filesize="";
				string filetype="";
				foreach(DataTable d in db.Tables)
				{
					foreach(DataRow dr in d.Rows)
					{
						if(dr["uri"].ToString()==ranking[i].ToString())
						{
							filesize =dr["filesize"].ToString();
							filetype =dr["filetype"].ToString();

						}
					}
					result+="<tr><td style=\"vertical-align: top;\">"+(i+1)+"<br></td>";
					result+="<td style=\"vertical-align: top;\">"+ranking[i]+"<br>";
					result+="</td><td style=\"vertical-align: top;\">"+filetype+"<br></td>";
					result+="<td style=\"vertical-align: top;\"><a href=\"userStatictics.htm?uri="+ranking[i].ToString().Trim()+"&details=true\">Details anzeigen</a><br></td></tr>";
				}
			}
			result+="</tbody></table>";
			return result;
		}

		/// <summary>
		/// Computes a ranking of the all uris in the database. And delivers
		/// the 10 most requested files of the webserver.
		/// </summary>
		/// <returns>A array which contains the 10 most requested files. 
		/// At 0 the most requested is stored.</returns>
		public string[] computeRanking()
		{
			string[] result = new string[10];
			int max =0;
			int counter = 0;
			while(counter < 10)
			{
				DictionaryEntry maxEntry = new DictionaryEntry();
				foreach(DictionaryEntry de in this.statistics)
				{
					if((int)de.Value >= max)
					{
						max = (int)de.Value;
						maxEntry = de;
					}
				}
				try
				{
					result[counter] = maxEntry.Key.ToString();
//					Console.WriteLine(maxEntry.Key+" wurde besuch: "+maxEntry.Value);
//					Console.WriteLine("Ich habe gerade ins result that hinzugefügt"+maxEntry.Key);
					this.statistics.Remove(maxEntry.Key);
					counter++;
					max =0;

				}
				catch(Exception)
				{
					;
				}
				
			}
			return result;
		}

		/// <summary>
		/// Each row of the database will be inspected and ervery occurrence of uri is counted.
		/// This method counts the occurrence of a uri and stores them in a <c>Hashtable</c>.
		/// </summary>
		/// <param name="dbUriEntry">A single database entry</param>
		protected void AddToStatisticTable(string dbUriEntry)
		{
			if(this.statistics.ContainsKey(dbUriEntry))
			{
				int count = (int) this.statistics[dbUriEntry];
				count++;
				this.statistics.Remove(dbUriEntry);
				this.statistics.Add(dbUriEntry,count);
			}
			else
			{
				this.statistics.Add(dbUriEntry,1);
			}


		}
	}
}
