using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public class ProvidesMapping : IMapping 
	{
		
		private ProvidesInterface	innerProvIFace;
		private IComponent			innerComp;

		private ProvidesInterface	outerProvIFace;
		private IComponent			outerComp;

		public ProvidesInterface InnerProvIFace 
		{ 
			get { return innerProvIFace; }
		}

		public IComponent InnerComp 
		{ 
			get { return innerComp; }
		}

		public ProvidesInterface OuterProvIFace 
		{ 
			get { return outerProvIFace; }
		}

		public IComponent OuterComp 
		{ 
			get { return outerComp; }
		}


		public ProvidesMapping ( IComponent anInnerComp, ProvidesInterface anInnerProvI, 
			IComponent anOuterComp, ProvidesInterface anOuterProvI ) 
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
