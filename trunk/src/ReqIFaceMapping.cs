using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public class ReqIFaceMapping : IMapping 
	{
		#region Data

		private RequiresInterface	innerReqIFace;
		private RequiresInterface	outerReqIFace;
		#endregion


		#region Properties

		public RequiresInterface InnerReqIFace 
		{ 
			get { return innerReqIFace; }
		}

		public RequiresInterface OuterReqIFace 
		{ 
			get { return outerReqIFace; }
		}

		#endregion


		#region Constructors

		public ReqIFaceMapping ( RequiresInterface anInnerReqIFace, RequiresInterface anOuterReqIFace) 
		{
			innerReqIFace = anInnerReqIFace;
			outerReqIFace = anOuterReqIFace;
		}

		public ReqIFaceMapping( ReqIFaceMapping aReqMapping ) : 
			this( aReqMapping.InnerReqIFace, aReqMapping.OuterReqIFace) {}

		#endregion


		# region Methods

		/// <summary>
		/// Checks if the requires interface of the inner component is
		/// a subtype of the requires interface of the outer component.
		/// </summary>
		/// <param name="anErrorList"></param>
		/// <returns></returns>
		public bool IsSubType(out IList anErrorList) 
		{
			return InnerReqIFace.IsSubSetOf( OuterReqIFace, out anErrorList );
		}

		public bool IsSubType()
		{
			IList errorList;
			return IsSubType(out errorList);
		}

		public IInterfaceModel GetIntersection() 
		{
			return InnerReqIFace.Intersect( OuterReqIFace );
		}

		public object Clone() 
		{
			return new ReqIFaceMapping( this );
		}

		#endregion
	}
}
