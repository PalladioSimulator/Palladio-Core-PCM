using System;
using System.IO;
using Request;

namespace Delivery
{
	/// <summary>
	/// Zusammenfassung für IDeliverResponse.
	/// </summary>
	public interface IDeliverResponse
	{
		/// <summary>
		/// Checks responsebility
		/// </summary>
		/// <param name="r"></param>
		/// <returns></returns>
		IDeliverResponse DeliverResonse(HttpRequest r,string path);

		Stream DeliverResponseStream();


		byte[] GetResponse{get;}

		int GetFileSize{get;}

		DateTime LastModified();

		IDeliverResponse Sucessor{set;get;}

	}
}
