using System;

namespace Request
{
	/// <summary>
	/// Zusammenfassung für HttpPostValidator.
	/// </summary>
	public class HttpPostValidator : HTTPValidator
	{
		public HttpPostValidator()
		{
		}

		

		
		internal void ValidateLength(int i)
		{
			//has to throw a exception when the the size is too huge 
			return;
		}

		internal void ValidateContent(string content)
		{
			//has to throw an exception, when contentlength and contonent.Lengt
			//doesn't ve the same value
			return;
		}
	}
}
