using System;

namespace ComponentModel {
	public interface IConnection {

		bool CheckInteroperability ();
		bool CheckInteroperability ( out IList anErrorList );

		IInterfaceModel GetIntersection ();
	}
}
