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
	/// <summary>
	/// </summary>
	public interface IDeploymentSpecification : ICloneable, IAttributable, IVisitable, IIdentifiable, ISerializable
	{
		string Filename {get; set; }
	}
}
