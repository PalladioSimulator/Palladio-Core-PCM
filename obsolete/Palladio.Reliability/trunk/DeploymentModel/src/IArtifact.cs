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
	public enum ArtifactStereotype
	{
		NONE,
		SOURCE,
		EXECUTABLE
	}

	/// <summary>
	/// </summary>
	public interface IArtifact : ICloneable, IAttributable, IVisitable, IIdentifiable, ISerializable
	{
		string Name { get; set; }

		ArtifactStereotype Stereotype { get; set; }

		IDeploymentSpecification DeploymentSpecification { get; set; }

		/// <summary>
		/// Component realised by this artifacts excluding components 
		/// realised by nested artifacts.
		/// </summary>
		IComponent RealisedComponent { get; set; }

		IArtifactContainer NestedArtifacts { get; }
	}
}