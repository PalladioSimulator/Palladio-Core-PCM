using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// </summary>
	public class IfaceReqMapping : IIfaceReqMapping  
	{
		#region Properties

		/// <summary>
		/// RequiresInterface of the inner component.
		/// </summary>
		public RequiresInterface InnerInterface 
		{ 
			get { return innerInterface; }
		}

		/// <summary>
		/// RequiresInterface of the outer component.
		/// </summary>
		public RequiresInterface OuterInterface 
		{ 
			get { return outerInterface; }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks if the RequiresInterface of the inner component is
		/// a subtype of the RequiresInterface of the outer component.
		/// </summary>
		/// <param name="anErrorList">
		///		List of errors, which occured during the subtypecheck.
		///	</param>
		/// <returns>
		/// True, if the inner RequiresInterface is a subtype of the outer
		/// one, false otherwise.
		/// </returns>
		public bool IsSubType(out IList anErrorList) 
		{
			return innerInterface.IsSubSetOf(OuterInterface, out anErrorList);
		}


		/// <summary>
		/// Checks if the RequiresInterface of the inner component is
		/// a subtype of the RequiresInterface of the outer component.
		/// </summary>
		/// <returns>
		/// True, if the inner RequiresInterface is a subtype of the outer
		/// one, false otherwise.
		/// </returns>
		public bool IsSubType()
		{
			IList errorList;
			return IsSubType(out errorList);
		}

		/// <summary>
		/// Determines the intersection of both interfaces.
		/// </summary>
		/// <returns>The lowest common denominator of both interfaces.</returns>
		public IInterfaceModel GetIntersection() 
		{
			return OuterInterface.GetIntersection(InnerInterface);
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone() 
		{
			return new IfaceReqMapping( this );
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a mapping between a RequiresInterface of the inner component onto a
		/// RequiresInterface of the outer component, which includes the inner component.
		/// </summary>
		/// <param name="anInnerInterface">RequiresInterface of the inner component</param>
		/// <param name="anOuterInterface">RequiresInterface of the outer component</param>
		public IfaceReqMapping ( RequiresInterface anInnerInterface, RequiresInterface anOuterInterface ) 
		{
			innerInterface = anInnerInterface;
			outerInterface = anOuterInterface;
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aProvMapping">Mapping to copy</param>
		public IfaceReqMapping( IfaceReqMapping aReqMapping ) : 
			this ( aReqMapping.InnerInterface, aReqMapping.OuterInterface ) {}

		#endregion

		#region Data
		
		private RequiresInterface	innerInterface;
		private RequiresInterface	outerInterface;
		#endregion
	}
}
