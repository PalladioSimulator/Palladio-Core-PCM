using Palladio.Identifier;

namespace Palladio.DeploymentModel
{
	/// <summary>
	/// </summary>
	public interface ICharacterisedElement : IIdentifiable
	{
		string Name { get; set; }
	}
}
