using System;
using System.Collections;

namespace ComponentModel
{
	/// <summary>
	/// Implements functionality relevant to all types of connections.
	/// </summary>
	public abstract class AbstractConnection : IConnection {
		
		public abstract IInterfaceModel GetIntersection();
		
		public abstract bool CheckInteroperability(out IList anErrorList);

		public bool CheckInteroperability() {
			IList errorList;
			return CheckInteroperability( out errorList );
		}
	}
}
