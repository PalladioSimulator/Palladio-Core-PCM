using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// 
	/// </summary>
	public interface IInterfaceModel {

		bool SubTypeCheck( IList anIModelList );

		bool SubTypeCheck( IInterfaceModel anIModel );

		/// <summary>
		/// prov_A gegen prov_A' oder req_A gegen req_A'
		/// </summary>
		/// <param name="anIModelList"></param>
		/// <param name="anErrorList"></param>
		/// <returns></returns>
		bool SubTypeCheck( IList anIModelList, out IList anErrorList);

		bool SubTypeCheck( IInterfaceModel anIModel, out IList anErrorList);

		
		/// <summary>
		/// prov_A gegen req_B, für IConnection
		/// </summary>
		/// <param name="anIModelList"></param>
		/// <returns></returns>
		IList GetInterOperabilityErrors( IList anIModelList );

		IList GetInterOperabilityErrors( IInterfaceModel anIModel );

		IInterfaceModel Merge( IList anIModelList );

		IInterfaceModel Merge( IInterfaceModel anIModel );
	}
}
