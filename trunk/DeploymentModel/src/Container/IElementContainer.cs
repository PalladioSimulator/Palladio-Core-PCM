// 
// Palladio Interface
// $Id$
//

using System;
using Palladio.Identifier;

namespace Palladio.DeploymentModel
{

	public delegate void CharacterisedElementAddedEventHandler( object sender, CharacterisedElementAddedEventArgs e);
	public delegate void CharacterisedElementRemovedEventHandler( object sender, CharacterisedElementRemovedEventArgs e);

	/// <summary>
	/// </summary>
	public interface IElementContainer : ICloneable
	{
		event CharacterisedElementAddedEventHandler ElementAdded;
		event CharacterisedElementRemovedEventHandler ElementRemoved;

		ICharacterisedElement[] Elements { get; }

		ICharacterisedElement[] Get(string name);
		ICharacterisedElement Get(IIdentifier id);

		bool Contains(string name);
		bool Contains(IIdentifier id);
		bool Contains(ICharacterisedElement element);

		IElementConnection[] Connections { get; }

		void Add(params ICharacterisedElement[] elements);

		void Remove(params string[] names);
		void Remove(params IIdentifier[] ids);
		void Remove(params ICharacterisedElement[] elements);
	}

	public interface IElementContainerWithConnections : IElementContainer
	{

		void AddConnections(params IElementConnection[] connections);
		void RemoveConnections(params IElementConnection[] connections);
		
		bool ContainsConnection(IElementConnection connection);

		IElementConnection[] GetIncomingConnections(ICharacterisedElement element);
		IElementConnection[] GetOutgoingConnections(ICharacterisedElement element);
		ICharacterisedElement[] GetPredecessors(ICharacterisedElement element);
		ICharacterisedElement[] GetSuccessors(ICharacterisedElement element);	
	}
}