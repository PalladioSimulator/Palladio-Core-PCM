using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Connection between a requires interface of component A and
	/// a provides interface of component B. Both components stand on
	/// the same level. (none is including the other)
	/// </summary>
	public class IFaceBinding : IBinding 
	{
		#region Data

		private ProvidesInterface provIFace;
		private RequiresInterface reqIFace;
		#endregion


		#region Properties

		/// <summary>
		/// Provides interface of component B.
		/// </summary>
		public ProvidesInterface ProvIFace 
		{ 
			get { return provIFace; }
		}

		/// <summary>
		/// Requires interface of component A.
		/// </summary>
		public RequiresInterface ReqIFace 
		{ 
			get { return reqIFace; }
		}
		#endregion


		#region Constructors

		/// <summary>
		/// Creates a binding between the requires interface (aReqIFace) of
		/// the component A (aReqComp) and the provides interface (aProvIFace) of
		/// the component B (aProvComp).
		/// </summary>
		/// <param name="aProvComp"></param>
		/// <param name="aProvIFace"></param>
		/// <param name="anOuterComponent"></param>
		/// <param name="aReqIFace"></param>
		public IFaceBinding (RequiresInterface aReqIFace, ProvidesInterface aProvIFace) 
		{
			reqIFace = aReqIFace;
			provIFace = aProvIFace;
		}

		public IFaceBinding( IFaceBinding aBinding ) : 
			this( aBinding.ReqIFace, aBinding.ProvIFace ) {}

		#endregion


		#region Methods


		public bool CheckInteroperability() 
		{
			IList errorList;
			return CheckInteroperability(out errorList);
		}

		/// <summary>
		/// Checks if the requires interface is a subset of the provides interface.
		/// </summary>
		/// <param name="anErrorList"></param>
		/// <returns></returns>
		public bool CheckInteroperability(out IList anErrorList) 
		{
			return ReqIFace.IsSubSetOf(ProvIFace, out anErrorList);
		}

		public IInterfaceModel GetIntersection() 
		{
			return ProvIFace.Intersect( ReqIFace );
		}

		public object Clone () 
		{
			return new IFaceBinding (this);
		}

		#endregion

	}
}
