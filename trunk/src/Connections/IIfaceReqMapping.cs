using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Maps the RequiresInterfaces of an inner Component
	/// onto the RequiresInterfaces of an outer Component.
	/// </summary>
	public interface IIfaceReqMapping : IInterfaceConnection
	{
		#region Properties

		/// <summary>
		/// RequiresInterface of the inner component.
		/// </summary>
		RequiresInterface InnerInterface 
		{ 
			get;
		}

		/// <summary>
		/// RequiresInterface of the outer component.
		/// </summary>
		RequiresInterface OuterInterface 
		{ 
			get;
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
		bool IsSubType(out IList anErrorList);

		/// <summary>
		/// Checks if the RequiresInterface of the inner component is
		/// a subtype of the RequiresInterface of the outer component.
		/// </summary>
		/// <returns>
		/// True, if the inner RequiresInterface is a subtype of the outer
		/// one, false otherwise.
		/// </returns>
		bool IsSubType();

		#endregion
	}


}