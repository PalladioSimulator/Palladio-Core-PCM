using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public class RequiresMapping : IRequiresMapping 
	{
		private RequiresInterface	innerReqIFace;
		private IComponent			innerComp;

		private RequiresInterface	outerReqIFace;
		private IComponent			outerComp;

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

		public RequiresMapping ( IComponent anInnerComp, RequiresInterface anInnerReqIFace, 
			IComponent anOuterComponent, RequiresInterface anOuterReqIFace) 
		{
		}

		public bool CheckSubType(out IList anErrorList) 
		{
			anErrorList = null;
			return false;
		}

		public bool CheckSubType()
		{
			return false;
		}

		public IInterfaceModel GetIntersection() 
		{
			return null;
		}
	}
}
