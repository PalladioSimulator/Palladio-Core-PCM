namespace Palladio.ComponentModel
{
	/// <summary>
	/// The stage in a process where the event happened
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	public enum ChangeTimeEnum
	{
		/// <summary>
		/// Before a change to the signature list is made
		/// </summary>
		BEFORE,
		/// <summary>
		/// After a change to the signature list was made
		/// </summary>
		AFTER
	}

	/// <summary>
	/// Kind of change performed on the signature list
	/// </summary>
	public enum ChangeTypeEnum
	{
		/// <summary>
		/// A new element is added
		/// </summary>
		ADD,
		/// <summary>
		/// An existing element is deleted
		/// </summary>
		DELETE
	}
}
