using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Connection between a RequiresInterface and
	/// a ProvidesInterface of two different components.
	/// </summary>
	public class InterfaceBinding : IInterfaceBinding
	{
		#region Properties

		/// <summary>
		/// Description of the services provided 
		/// by one of the compontents to the other.
		/// </summary>
		public ProvidesInterface ProvIface 
		{ 
			get { return provIface; }
		}

		/// <summary>
		/// Description of the services required by one of the
		/// components from the other.
		/// </summary>
		public RequiresInterface ReqIface 
		{ 
			get { return reqIface; }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks if the needs specified in the RequiresInterfaces can be fulfilled 
		/// by the ProvidesInterfaces.
		/// </summary>
		/// <returns>True, if as much is provided as required.</returns>
		public bool CheckInteroperability() 
		{
			IList errorList;
			return CheckInteroperability(out errorList);
		}

		/// <summary>
		/// Checks if the needs specified in the RequiresInterfaces can be fulfilled 
		/// by the ProvidesInterfaces.
		/// </summary>
		/// <param name="anErrorList">List of errors occured during the interoperability check.</param>
		/// <returns>True, if as much is provided as required.</returns>
		public bool CheckInteroperability(out IList anErrorList) 
		{
			return ReqIface.IsSubSetOf(ProvIface, out anErrorList);
		}

		/// <summary>
		/// Determines the intersection of both interfaces.
		/// </summary>
		/// <returns>The lowest common denominator of both interfaces.</returns>
		public IInterfaceModel GetIntersection() 
		{
			return ProvIface.GetIntersection( ReqIface );
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone () 
		{
			return new InterfaceBinding (this);
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a binding between aReqIface of one component
		/// aProvIface of another component.
		/// </summary>
		/// <param name="aProvComp">Description of the provided services.</param>
		/// <param name="aProvIface">Description of the required services.</param>
		public InterfaceBinding (RequiresInterface aReqIface, ProvidesInterface aProvIface) 
		{
			reqIface = aReqIface;
			provIface = aProvIface;
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aBinding">Binding to copy.</param>
		public InterfaceBinding( InterfaceBinding aBinding ) : 
			this( aBinding.ReqIface, aBinding.ProvIface ) {}

		#endregion

		#region Data

		private ProvidesInterface provIface;
		private RequiresInterface reqIface;
		#endregion
	}
}
