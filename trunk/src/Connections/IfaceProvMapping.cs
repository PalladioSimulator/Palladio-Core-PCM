using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Maps one ProvidesInterface of an inner Component
	/// onto one ProvidesInterfaces of an outer Component.
	/// </summary>
	public class IfaceProvMapping : IIfaceProvMapping 
	{
		#region Properties

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		public ProvidesInterface InnerInterface 
		{ 
			get { return innerInterface; }
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		public ProvidesInterface OuterInterface 
		{ 
			get { return outerInterface; }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks if the ProvidesInterface of the outer component is
		/// a subset of the ProvidesInterface of the inner component.
		/// </summary>
		/// <param name="anErrorList">
		///		List of errors, which occured during the subtypecheck
		///	</param>
		/// <returns>
		/// true, if the outer ProvidesInterface is a subtype of the inner,
		/// false otherwise.
		/// </returns>
		public bool IsSubType(out IList anErrorList) 
		{
			return outerInterface.IsSubSetOf(InnerInterface, out anErrorList);
		}


		/// <summary>
		/// Checks if the ProvidesInterface of the outer component is
		/// a subset of the ProvidesInterface of the inner component.
		/// </summary>
		/// <returns>
		/// true, if the outer ProvidesInterface is a subtype of the inner,
		/// false otherwise.
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
			return new IfaceProvMapping( this );
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a mapping between a ProvidesInterface of the inner component onto a
		/// ProvidesInterface of the outer component, which includes the inner component.
		/// </summary>
		/// <param name="anInnerInterface">ProvidesInterface of the inner component</param>
		/// <param name="anOuterInterface">ProvidesInterface of the outer component</param>
		public IfaceProvMapping ( ProvidesInterface anInnerInterface, ProvidesInterface anOuterInterface ) 
		{
			innerInterface = anInnerInterface;
			outerInterface = anOuterInterface;
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aProvMapping">Mapping to copy</param>
		public IfaceProvMapping( IfaceProvMapping aProvMapping ) : 
			this ( aProvMapping.InnerInterface, aProvMapping.OuterInterface ) {}

		#endregion

		#region Data
		
		private ProvidesInterface	innerInterface;
		private ProvidesInterface	outerInterface;
		#endregion
	}
}
