using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für ModelPersistencyInfo.
	/// </summary>
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
