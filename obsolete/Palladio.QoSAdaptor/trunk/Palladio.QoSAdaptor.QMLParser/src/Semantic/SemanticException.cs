using System;

namespace QmlParser.Semantic
{
	public class SemanticException : Exception
	{
		public SemanticException() : base() {}

		public SemanticException(string message) : base(message) {}

		public SemanticException(string message, Exception innerException) : base (message, innerException) {}
	}
}
