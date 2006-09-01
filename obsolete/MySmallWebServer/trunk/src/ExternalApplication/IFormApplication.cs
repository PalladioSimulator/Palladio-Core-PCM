using System;

namespace MySmallWebServer.ExternalApplication
{
	/// <summary>
	/// 
	/// </summary>
	public interface IFormApplication
	{
		/// <summary>
		/// This method must contain the replay of the request. It has to be a html page, because this 
		/// will be sended to the browser with no manipulation.
		/// </summary>
		/// <returns></returns>
		string GenerateText();
	}
}
