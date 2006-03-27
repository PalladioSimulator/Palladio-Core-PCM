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
			return	"data source=141.3.52.17;" + 
					"database=WebAudioStore;" +
					"user id=audioweb;"+
					"password=webaudio;";
		}
	}
}
