using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public interface IInterfaceModel {

		bool SubTypeCheck( IList anIModelList );

		bool SubTypeCheck( IInterfaceModel anIModel );

		bool SubTypeCheck( IList anIModelList, out IList anErrorList);

		bool SubTypeCheck( IInterfaceModel anIModel, out IList anErrorList);

		IList GetInterOperabilityErrors( IList anIModelList );

		IList GetInterOperabilityErrors( IInterfaceModel anIModel );

		IInterfaceModel Merge( IList anIModelList );

		IInterfaceModel Merge( IInterfaceModel anIModel );
	}
}
