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

		//old
		byte[] GetResponse{get;}

		//for testing the cache
//		byte[] GetResponse(HttpRequest request);

		int GetFileSize{get;}

		DateTime LastModified();

		IDeliverResponse Sucessor{set;get;}

	}
}
