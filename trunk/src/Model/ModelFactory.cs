using Palladio.Identifier;

namespace Palladio.Reliability.Model
{
	/// <summary>
	/// </summary>
	public class ModelFactory
	{
		public static IResource CreateResource(string id)
		{
			return new Resource.Resource(IdentifiableFactory.CreateStringID(id));
		}
	}
}