// 
// Palladio Interface
// $Id$
//

using System;
using Palladio.Attributes;
using Palladio.ComponentModel;
using Palladio.Identifier;
using ReflectionBasedVisitor;

namespace Palladio.DeploymentModel
{
	public enum NodeStereotype
	{
		DEVICE,
		EXECUTION_ENVIRONMENT
	}

	/// <summary>
	/// </summary>
	public interface INode : ICloneable, IAttributable, IVisitable, IIdentifiable, ISerializable
	{
		string Name { get; set; }

		NodeStereotype Stereotype { get; set; }

		INodeContainer NestedNodes { get; }

		IArtifactContainer DeployedArtifacts { get; }
	}
}