using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public class ProvIFaceMapping : IMapping
	{
		#region Data
		
		private ProvidesInterface	innerProvIFace;
		private ProvidesInterface	outerProvIFace;
		#endregion


		#region Properties

		public ProvidesInterface InnerProvIFace 
		{ 
			get { return innerProvIFace; }
		}

		public ProvidesInterface OuterProvIFace 
		{ 
			get { return outerProvIFace; }
		}
		#endregion


		#region Constructors

		public ProvIFaceMapping ( ProvidesInterface anInnerProvIFace, ProvidesInterface anOuterProvIFace ) 
		{
			innerProvIFace = anInnerProvIFace;
			outerProvIFace = anOuterProvIFace;
		}

		public ProvIFaceMapping( ProvIFaceMapping aProvMapping ) : 
			this ( aProvMapping.InnerProvIFace, aProvMapping.OuterProvIFace ) {}

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
			return new ProvIFaceMapping( this );
		}

		#endregion
	}
}
