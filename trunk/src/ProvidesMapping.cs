using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public class ProvidesMapping : IProvidesMapping 
	{
		#region Data
		
		private ProvidesInterface	innerProvIFace;
		private IComponent			innerComp;

		private ProvidesInterface	outerProvIFace;
		private IComponent			outerComp;
		#endregion


		#region Properties

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

		#endregion


		#region Constructors

		public ProvidesMapping ( IComponent anInnerComp, ProvidesInterface anInnerProvIFace, 
			IComponent anOuterComp, ProvidesInterface anOuterProvIFace ) 
		{
			innerComp = anInnerComp;
			innerProvIFace = anInnerProvIFace;
			outerComp = anOuterComp;
			outerProvIFace = anOuterProvIFace;
		}

		public ProvidesMapping( ProvidesMapping aProvMapping ) : 
			this ( aProvMapping.InnerComp, aProvMapping.InnerProvIFace,
			aProvMapping.OuterComp, aProvMapping.OuterProvIFace ) {}

		#endregion


		#region Methods

		/// <summary>
		/// Checks if the provides interface of the outer componente is
		/// a subset of the provides interface of the inner component.
		/// </summary>
		/// <param name="anErrorList"></param>
		/// <returns></returns>
		public bool IsSubType(out IList anErrorList) 
		{
			return outerProvIFace.IsSubSetOf(InnerProvIFace, out anErrorList);
		}

		public bool IsSubType()
		{
			IList errorList;
			return IsSubType(out errorList);
		}

		public IInterfaceModel GetIntersection() 
		{
			return OuterProvIFace.Intersect(InnerProvIFace);
		}

		public object Clone() 
		{
			return new ProvidesMapping( this );
		}

		#endregion
	}
}
