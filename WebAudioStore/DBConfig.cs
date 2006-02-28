using System;

namespace WebAudioStore
{
	/// <summary>
	/// Zusammenfassung für DBConfig.
	/// </summary>
	public class DBConfig
	{
		public DBConfig()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public static String GetConnectionString()
		{
			return	"data source=134.106.27.36;" + 
					"database=WebAudioStore;" +
					"user id=root;"+
					"password=myonjupsql17;";
		}
	}
}
