using System;
using Palladio.Webserver.Request;

namespace Palladio.Webserver.RequestParser.src.ErrorRequestParser
{
	/// <summary>
	/// ErrorRequestParser. Usually this class should be used at the end of the Chain Of Responsibility
	/// to catch errors on getting a fitting parser for the delivered stream.
	/// </summary>
	public class ErrorRequestParser : IRequestParser
	{
		public ErrorRequestParser()
		{

		}

		public void HandleRequest (IRequest request)
		{
			throw new NotImplementedException ();
		}
	}
}
