using System;
using System.IO;
using System.Net;

namespace Measurement.RandomNumbers
{
	/// <summary>
	/// Class responsible for http connections to Random.org
	/// </summary>
	public sealed class RandomDotOrgHttp 
	{
		/// <summary>
		/// Private constructor as static methods only.
		/// Private constructors with static method only
		/// classes are recommended in the book Applied .NET
		/// framework programming by Jeffrey Richter
		/// </summary>
		private RandomDotOrgHttp()
		{
			// Static methods only
		}

		/// <summary>
		/// Static method that generates real random numbers between two values
		/// </summary>
		/// <param name="lowestNumber">The lowest random number to be generated</param>
		/// <param name="highNumber">The highest random number to be generated</param>
		/// <param name="numberQuantity">The number of random numbers to be produced</param>
		/// <returns></returns>
		public static int[] GetRandomNumbers( int lowestNumber, int highNumber, int numberQuantity ) 
		{
			//string currentLine;
			string randomNumbersString;
			WebClient webclient = new WebClient();
			Stream stream = webclient.OpenRead( String.Format( "http://www.random.org/cgi-bin/randnum?num={0}&min={1}&max={2}&col=1", numberQuantity, lowestNumber, highNumber ) );
			StreamReader streamReader = new StreamReader( stream );
			randomNumbersString = streamReader.ReadToEnd( );
			streamReader.Close();
			stream.Close();
			string[] randomNumbers = randomNumbersString.Split( '\n' );
			int[] randomNumbersIntegers = new int[ randomNumbers.Length - 1 ];

			// Convert the string array into an int array
			for ( int i = 0; i < randomNumbersIntegers.Length; i++ ) 
			{
				randomNumbersIntegers[i] = int.Parse( randomNumbers[i] );
			}

			return randomNumbersIntegers;
		}

		/// <summary>
		/// Static method that generates a single random number
		/// </summary>
		/// <param name="lowestNumber">The lowest number the random generated number can be</param>
		/// <param name="highestNumber">The highest number the random generated number can be</param>
		/// <returns></returns>
		public static int GetSingleRandomNumber( int lowestNumber, int highestNumber ) 
		{
			int result;
			WebClient webClient = new WebClient();
			Stream stream = webClient.OpenRead( String.Format( "http://www.random.org/cgi-bin/randnum?num=1&min={0}&max={1}&col=1", lowestNumber, highestNumber ) );
			StreamReader reader = new StreamReader( stream );
			result = Convert.ToInt32( reader.ReadLine() );
			stream.Close();
			return result;
		}
	}
}