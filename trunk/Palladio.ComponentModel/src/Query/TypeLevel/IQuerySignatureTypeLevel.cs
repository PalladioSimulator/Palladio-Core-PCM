using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.Query.TypeLevel
{
	/// <summary>
	/// This interface defines several query methods to find the entities that are contained in and 
	/// belong to an interface.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/10/09 14:00:48  kelsaka
	/// - removed convenience property to access QueryRepository. This property raised security
	///  problems if the queries had been partially encapsulated: The access structure
	///  of queries wa not a tree any more.
	///
	/// Revision 1.1  2005/09/20 15:07:20  fst
	/// initial class creation
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface IQuerySignatureTypeLevel
	{
		#region properties


		#endregion

		#region methods

		/// <summary>
		/// called to return the id of the interface that belongs to this queries signature.
		/// </summary>
		/// <returns>the id of the interface</returns>
		IInterfaceIdentifier GetInterface();
		
		#endregion
	}
}
