using System;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// DefaultConfiguration. Note: currently unused TODO
	/// </summary>
	public class DefaultConfiguration : IConfiguration
	{
		public DefaultConfiguration()
		{

		}

		public object GetValue (string key)
		{
			throw new NotImplementedException ();
		}
	}
}
