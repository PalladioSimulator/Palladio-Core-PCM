using System;

namespace Request
{
	/// <summary>
	/// Zusammenfassung für HttpPostRequest.
	/// </summary>
	public class HttpPostRequest : HttpRequest
	{
		protected int contentLength;
		protected string content;
		protected HttpPostValidator validator;
		public HttpPostRequest() :base()
		{
			this.validator = new HttpPostValidator();

			
		}

		public HttpPostRequest(HttpRequest r) : base(r)
		{
			Console.WriteLine("Copx Konstruktor gemacht");
		}

		
		public int ContentLength
		{
			get{return this.contentLength;}
			set
			{
//				this.validator.ValidateLength(value);
				this.contentLength = value;
			}
		}

		public string Content
		{
			get{return this.content;}
			set
			{
//				this.validator.ValidateContent(value);
				this.content = value;
			}
		}


	}
}
