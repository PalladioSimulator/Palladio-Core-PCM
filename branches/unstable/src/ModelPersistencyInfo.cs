using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für ModelPersistencyInfo.
	/// </summary>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1.2.2  2004/12/02 23:39:48  uffi
	/// IAttributeHash replaced by AttributeHash,
	/// added attribute serialization
	///
	/// </pre>
	public class ModelPersistencyInfo
	{
		public static ModelPersistencyInfo ATTACHED = new ModelPersistencyInfo();

		private string repository;
		private string username;
		private string password;
		// ...


		public ModelPersistencyInfo()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}
	}
}
