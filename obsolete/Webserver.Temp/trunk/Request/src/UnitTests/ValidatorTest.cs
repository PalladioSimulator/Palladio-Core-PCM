using System;
using System.IO;
using NUnit.Framework;

namespace Request.UnitTests
{
	/// <summary>
	/// Zusammenfassung für ValidatorTest.
	/// </summary>
	[TestFixture]
	public class HTTPValidatorTest
	{
		HTTPValidator vali;
		public HTTPValidatorTest()
		{
			this.vali = new HTTPValidator();
		}
		
		[Test]public void TestUri()
		{
		  this.vali.validateURI("/");
			this.vali.validateURI("hallo/sdsdf/test.html");
			this.vali.validateURI("hallo/teat/flomm/");
		}
		[Test]public void Protocols()
		{
			//regular calls	
			this.vali.validateProtocol("HTTP/1.1");
			this.vali.validateProtocol("HTTP/1.0");
		}

		[Test] public void TestFileExtension()
		{
			//regular calls
			this.vali.ValidateFileExtenstion(".htm");
			this.vali.ValidateFileExtenstion(".html");
		}
		[ExpectedException(typeof(RequestNotValidException))]
		[Test]public void NoValidProtocol()
		{
		  this.vali.validateProtocol("something");
		}

		[ExpectedException(typeof(RequestNotValidException))]
		[Test] public void NotValidMethods()
		{
		  this.vali.validateMethod("someThingelse");
		}

		[Test] public void ValidateMethod()
		{
		  this.vali.validateMethod("GET");
		  this.vali.validateMethod("HEAD");
		  this.vali.validateMethod("PUT");
		  this.vali.validateMethod("POST");
		}

		public static void main()
		{
		  HTTPValidatorTest test = new HTTPValidatorTest();

		}
	}
}
