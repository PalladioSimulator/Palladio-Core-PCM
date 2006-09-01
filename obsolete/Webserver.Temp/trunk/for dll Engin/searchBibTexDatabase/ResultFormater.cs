using System.Data;

namespace searchBibTexDatabase
{
	/// <summary>
	/// Converts the searchresult to differnt String formats
	/// </summary>
	public class ResultFormater
	{
		private DataSet searchResult;

		public ResultFormater(DataSet s)
		{
			this.searchResult = s;
		}

		internal string FormatToString()
		{
			string result = "";
			foreach (DataTable dt in this.searchResult.Tables)
			{
				foreach (DataRow dr in dt.Rows)
				{
					result += "Title: " + dr["title"].ToString() + "<BR>";
					result += "Autor: " + dr["author"].ToString() + "<BR>";
					//result  += "ID. "+dr["ID"].ToString()+"<BR>";
					string id = dr["ID"].ToString();
					result += "<a href=\"suche.htm?ID=" + id.ToString() + "\">";
					result += "BibTex Eintrag anzeigen </a>";
					result += "<HR>";
				}
			}

			return result;

		}

		internal string FormatToTable()
		{
			return "Kommt noch";
		}

		internal string FormatToBibtexEntry()
		{
			string result = "";
			foreach (DataTable dt in this.searchResult.Tables)
			{
				foreach (DataRow dr in dt.Rows)
				{
//					foreach(DataColumn dc in dt.Columns)
//					{
					result += "@" + dr["type"].ToString() + "{" + dr["label"].ToString() + ",<BR>";
					result += "title={" + dr["title"].ToString() + "},<BR>";
					result += "author={" + dr["author"].ToString() + "},<BR>";
					result += "year={" + dr["year"].ToString() + "},<BR>";
					result += "publisher={" + dr["publisher"].ToString() + "},<BR>";
					result += "editor={" + dr["editor"].ToString() + "},<BR>";
					result += "abstract={" + dr["abstract"].ToString() + "}<BR>";


					result += "}";

//					}
					result += "<BR><a href=\"suche.htm\"> zur&uuml zur Suche</a>";
				}
			}

			return result;

		}
	}
}