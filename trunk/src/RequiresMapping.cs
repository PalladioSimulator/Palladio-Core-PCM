using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public class RequiresMapping : IRequiresMapping 
	{
		#region Data

		private RequiresInterface	innerReqIFace;
		private IComponent			innerComp;

		private RequiresInterface	outerReqIFace;
		private IComponent			outerComp;
		#endregion


		#region Properties

		public RequiresInterface InnerReqIFace 
		{ 
			get { return innerReqIFace; }
		}

		public IComponent InnerComp 
		{ 
			get { return innerComp; }
		}

		public RequiresInterface OuterReqIFace 
		{ 
			get { return outerReqIFace; }
		}

		public IComponent OuterComp 
		{ 
			get { return outerComp; }
		}

		#endregion


		#region Constructors

		public RequiresMapping ( IComponent anInnerComp, RequiresInterface anInnerReqIFace, 
			IComponent anOuterComp, RequiresInterface anOuterReqIFace) 
		{
			innerComp = anInnerComp;
			innerReqIFace = anInnerReqIFace;
			outerComp = anOuterComp;
			outerReqIFace = anOuterReqIFace;
		}

		public RequiresMapping( RequiresMapping aReqMapping ) : 
			this( aReqMapping.InnerComp, aReqMapping.InnerReqIFace,
			aReqMapping.OuterComp, aReqMapping.OuterReqIFace) {}

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
			return new RequiresMapping( this );
		}

		#endregion
	}
}
