using System;
using System.IO;
using Request;

namespace Delivery
{
	/// <summary>
	/// </summary>
	public interface IResponseHandler
	{
//		void HandleRequest(IRequest request);

		IResponseHandler Sucessor { set; get; }

		Stream GetResponseStream();

		byte[] GetResponse { get; }

		int GetFileSize { get; }

		DateTime LastModified();

		string StatusCode { get; }

		IResponseHandler GetResponsibleHandler(HttpRequest r, string path);
	}
}