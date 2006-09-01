using System;
using Palladio.Attributes;
using Palladio.DeploymentModel.Default;
using Palladio.Identifier;

namespace Palladio.DeploymentModel
{
	/// <summary>
	/// </summary>
	public class DeploymentFactory
	{
		public static IArtifactConnection CreateArtifactConnection()
		{
			return new ArtifactConnection();
		}

		public static IArtifactConnection CreateArtifactConnection(IArtifact source, IArtifact destination)
		{
			return new ArtifactConnection(source, destination);
		}

		public static INodeConnection CreateNodeConnection()
		{
			return new NodeConnection();
		}

		public static INodeConnection CreateNodeConnection(INode source, INode destination)
		{
			return new NodeConnection(source, destination);
		}

		public static IArtifact CreateArtifact(string filename)
		{
			return new Artifact(filename);
		}

		public static IArtifact CreateArtifact(string filename, IAttributeHash attributes)
		{
			return new Artifact(filename, attributes);
		}
		
		public static INode CreateNode(string name)
		{
			return new Node(name);
		}

		public static INode CreateNode(string name, IAttributeHash attributes)
		{
			return new Node(name, attributes);
		}
		
		public static ISystem CreateSystem(string name)
		{
			return new Default.System(name);
		}

		public static ISystem CreateSystem(string name, IAttributeHash attributes)
		{
			return new Default.System(name, attributes);
		}	
		
		public static IDeploymentSpecification CreateDeploymentSpecification(string filename)
		{
			return new Default.DeploymentSpecification(filename);
		}

		public static IDeploymentSpecification CreateDeploymentSpecification(string filename, IAttributeHash attributes)
		{
			return new Default.DeploymentSpecification(filename, attributes);
		}	
	}
}
