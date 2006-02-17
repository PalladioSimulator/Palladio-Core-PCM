using System;
using Palladio.Attributes;
using Palladio.ComponentModel;
using Palladio.Identifier;
using ReflectionBasedVisitor;

namespace Palladio.DeploymentModel
{
	/// <summary>
	/// </summary>
	public interface ISystem : ICloneable, IAttributable, IVisitable, IIdentifiable, ISerializable
	{
		string Name {get;}

		INodeContainerWithConnections Nodes{ get; }

		IArtifactContainerWithConnections Artifacts { get; }
	}
}
