using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// 
	/// </summary>
	public interface IInterfaceModel : ICloneable 
	{
		bool IsSubSetOf( IList anIModelList );

		bool IsSubSetOf( IInterfaceModel anIModel );

		bool IsSubSetOf( IList anIModelList, out IList anErrorList);

		bool IsSubSetOf( IInterfaceModel anIModel, out IList anErrorList);
		
		IInterfaceModel Merge( IList anIModelList );

		IInterfaceModel Merge( IInterfaceModel anIModel );

		IInterfaceModel Intersect( IList anIModelList );

		IInterfaceModel Intersect( IInterfaceModel anIModel );
	}
}
