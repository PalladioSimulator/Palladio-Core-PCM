using System;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors
{
	/// <summary>
	/// Exception that is thrown during the complete coping check, when an 
	/// element that is requested by the 
	/// QMLRequiredSpecificationCompleteCopingVisitor can not be found in the
	/// provided specification by the 
	/// QMLProvidedSpecificationCompleteCopingVisitor.
	/// </summary>
	public class QMLCompleteCopingException : Exception
	{
		/// <summary>
		/// Constructor that defines a default message and adds the given 
		/// message.
		/// </summary>
		/// <param name="message"></param>
		public QMLCompleteCopingException(string message):
		base("The provided specification does not cope the required "+
			"specification. The following error occurred: "+message)
		{
		}
	}
}
