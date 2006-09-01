using System.Collections;
using DBAcesses;
using Request;

namespace DLLEngine
{
	/// <summary>
	/// Zusammenfassung für IDLLInterface.
	/// </summary>
	public interface IDLL
	{
		IDLL DeliverDll(HttpRequest r, Hashtable t, ref DBAcessComponent db);

		string Result();

		IDLL Sucessor { set; get; }
	}
}