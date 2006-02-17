using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// This IInterfaceModel extends the ProtocolIModel using quality of service 
	/// attributes like reliability and performance.
	/// </summary>
	public class OualityOfServiceIModel : ProtocolIModel  
	{
		#region Methods

		/// <summary>
		/// Checks if this interface is a subset of anIModel. In
		/// other words all services of this IInterfaceModel must be
		/// provided by anIModel and all relations between these 
		/// services expected by this IInterfaceModel must be fulfilled
		/// by anIModel, but anIModel can provide more than what is required
		/// by this IInterfaceModel.
		/// </summary>
		/// <param name="anIModel">An other IInterfaceModel.</param>
		/// <param name="anErrorList">List of error which occured during the subtypecheck.</param>
		/// <returns>True, if this IInterfaceModel is a subset of anIModel, false otherwise.</returns>
		public override bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList) 
		{
			anErrorList = null;
			return false;
		}

		/// <summary>
		/// Merges this IInterfaceModel with anIModel.
		/// </summary>
		/// <param name="anIModel">An IInterfaceModel which is merged with this one.</param>
		/// <returns>A new IInterfaceModel created by merging this IInterfacemodel an anIModel.</returns>
		public override IInterfaceModel Merge(IInterfaceModel anIModel) 
		{
			return null;
		}

		/// <summary>
		/// Intersects this IInterfaceModel and anIModel. 
		/// The result contains alls services and relationships wich exist in both
		/// IInterfaceModels.
		/// </summary>
		/// <param name="anIModel">IInterfaceModel to intersect with.</param>
		/// <returns>A new IInterfaceModel representing the intersection 
		/// of both IInterfaceModels</returns>
		public override IInterfaceModel GetIntersection(IInterfaceModel anIModel)
		{
			return null;
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return null;
		}

		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
		public override bool Equals(object obj)
		{
			return base.Equals (obj);
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return base.GetHashCode ();
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty QualityOfServiceIModel.
		/// </summary>
		public OualityOfServiceIModel()	
		{
		}
		#endregion

		#region Data
		#endregion
	}
}
