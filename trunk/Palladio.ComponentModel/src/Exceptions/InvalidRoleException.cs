namespace Palladio.ComponentModel.Exceptions
{
	/// <summary>
	/// The AttachedInterface is invalid. This is the case, if the component associated 
	/// with the AttachedInterface is not contained in the surrounding CompositeComponent or
	/// if it does not provide the required role.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:05  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:48:03  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class InvalidRoleException : ComponentModelException
	{
		/// <summary>
		/// The AttachedInterface is invalid. This is the case, if the component associated 
		/// with the AttachedInterface is not contained in the surrounding CompositeComponent or
		/// if it does not provide the required role.
		/// </summary>
		public InvalidRoleException(IRole anInterface) : base( "Role " + anInterface + "is invalid!")
		{
		}
	}
}