using System;
using System.Collections;
using Palladio.DeploymentModel.src.Container;
using Palladio.Identifier;
using Palladio.Utils.Collections;

namespace Palladio.DeploymentModel
{
	/// <summary>
	/// </summary>
	public class ElementContainer : IElementContainerWithConnections
	{
		private ElementDataset elementDataset;
		private long nextElementID;
		private long nextConnectionID;
		private Hashmap elementHash;
		private Hashmap connectionHash;

		public ElementContainer()
		{
			elementDataset = new ElementDataset();
			nextElementID = 1;
			elementHash = new Hashmap();

			nextConnectionID = 1;
			connectionHash = new Hashmap();
		}

		protected ElementContainer(ElementContainer container)
		{
			elementDataset = container.elementDataset.Clone() as ElementDataset;
			elementDataset.Merge(container.elementDataset);
			nextElementID = container.nextElementID;
			elementHash = container.elementHash.Clone() as Hashmap;

			nextConnectionID = container.nextConnectionID;
			connectionHash = container.connectionHash as Hashmap;
			if (container.ElementAdded != null)
				ElementAdded = container.ElementAdded.Clone() as CharacterisedElementAddedEventHandler;
			if (container.ElementRemoved != null)
				ElementRemoved = container.ElementRemoved.Clone() as CharacterisedElementRemovedEventHandler;
		}

		public event CharacterisedElementAddedEventHandler ElementAdded;
		public event CharacterisedElementRemovedEventHandler ElementRemoved;

		public ICharacterisedElement[] Elements
		{
			get
			{
				ICharacterisedElement[] elements = new ICharacterisedElement[elementHash.Values.Count];
				elementHash.Values.CopyTo(elements, 0);
				return elements;
			}
		}

		public void Add(params ICharacterisedElement[] elements)
		{
			foreach (ICharacterisedElement element in elements)
			{
				if (Contains(element))
					throw new ApplicationException("Element '"+ element + "' is already in the container!");
				long id = nextElementID++;
				elementDataset.ElementTable.AddElementTableRow(id, element.Name, element.ID.ToString());
				elementHash[id] = element;
				OnElementAdded(element);
			}
		}

		public ICharacterisedElement[] Get(string name)
		{
			Vector result = SelectElements("Name = '" + name + "'");
			if (result.Count < 1)
				throw new ApplicationException("No element  with name '"+name+"' found!");
			return (ICharacterisedElement[]) result.ToArray(typeof(ICharacterisedElement));
		}

		public ICharacterisedElement Get(IIdentifier id)
		{
			Vector result = SelectElements("Identifier = '" + id.ToString() + "'");
			if (result.Count < 1)
				throw new ApplicationException("No element  with ID '"+id+"' found!");
			if (result.Count > 1)
				throw new ApplicationException("Multiple results found for identifier '" + id.ToString() + "'.");
			return (ICharacterisedElement) result[0];
		}

		public ICharacterisedElement Get(ICharacterisedElement element)
		{
			Vector result = SelectElements("(Identifier = '" + element.ID.ToString() + "') AND (Name = '" + element.Name + "')");
			if (result.Count < 1)
				return null;
			if (result.Count > 1)
				throw new ApplicationException("Multiple results found for identifier '" + element.ID.ToString() + "' and name '" + element.Name + "'.");
			return (ICharacterisedElement) result[0];
		}

		public void Remove(params ICharacterisedElement[] elements)
		{
			foreach (ICharacterisedElement element in elements)
			{
				RemoveElements("(Identifier = '" + element.ID.ToString() + "') AND (Name = '" + element.Name + "')");
			}
		}

		public void Remove(params string[] names)
		{
			foreach (string name in names)
			{
				RemoveElements("Name = '" + name + "'");
			}
		}

		public void Remove(params IIdentifier[] ids)
		{
			foreach (IIdentifier id in ids)
			{
				RemoveElements("Identifier = '" + id.ToString() + "'");
			}
		}



		public IElementConnection[] Connections
		{
			get
			{
				IElementConnection[] connections = new IElementConnection[connectionHash.Values.Count];
				connectionHash.Values.CopyTo(connections, 0);
				return connections;
			}
		}

		public bool ContainsConnection(IElementConnection connection)
		{
			long sourceID = GetElementID(connection.Source);
			long destinationID = GetElementID(connection.Destination);
			Vector connections = SelectConnections("(Source = "+ sourceID +") AND (Destination = " + destinationID+")");
			return connections.Count > 0;
		}

		public bool Contains(string name)
		{
			Vector result = SelectElements("Name = '" + name + "'");
			if (result.Count < 1)
				return false;
			return true;
		}

		public bool Contains(IIdentifier id)
		{
			Vector result = SelectElements("Identifier = '" + id.ToString() + "'");
			if (result.Count < 1)
				return false;
			return true;
		}

		public bool Contains(ICharacterisedElement element)
		{
			Vector result = SelectElements("(Identifier = '" + element.ID.ToString() + "') AND (Name = '" + element.Name + "')");
			if (result.Count < 1)
				return false;
			return true;
		}

		public IElementConnection[] GetIncomingConnections(ICharacterisedElement element)
		{
			long destinationID = GetElementID(element);
			Vector connections = SelectConnections("Destination = " + destinationID);
			return (IElementConnection[])connections.ToArray(typeof(IElementConnection));
		}

		public IElementConnection[] GetOutgoingConnections(ICharacterisedElement element)
		{
			long sourceID = GetElementID(element);
			Vector connections = SelectConnections("Source = " + sourceID);
			return (IElementConnection[])connections.ToArray(typeof(IElementConnection));
		}

		public ICharacterisedElement[] GetPredecessors(ICharacterisedElement element)
		{
			IElementConnection[] incoming = GetIncomingConnections(element);
			Set predecessors = new Set();
			foreach (IElementConnection connection in incoming)
			{
				predecessors.Add(connection.Source);
			}
			return (ICharacterisedElement[])predecessors.ToArray(typeof(ICharacterisedElement));
		}

		public ICharacterisedElement[] GetSuccessors(ICharacterisedElement element)
		{
			IElementConnection[] outgoing = GetOutgoingConnections(element);
			Set successors = new Set();
			foreach (IElementConnection connection in outgoing)
			{
				successors.Add(connection.Destination);
			}
			return (ICharacterisedElement[])successors.ToArray(typeof(ICharacterisedElement));
		}

		public void AddConnections(params IElementConnection[] connections)
		{
			foreach (IElementConnection connection in connections)
			{
				long sourceID = GetElementID(connection.Source);
				long destinationID = GetElementID(connection.Destination);
				long id = nextConnectionID++;
				elementDataset.ConnectionTable.AddConnectionTableRow(id, sourceID, destinationID);
				connectionHash[id] = connection;
			}
		}

		public void RemoveConnections(params IElementConnection[] connections)
		{
			foreach (IElementConnection connection in connections)
			{
				try
				{
					long sourceID = GetElementID(connection.Source);
					long destinationID = GetElementID(connection.Destination);
					RemoveConnection("(Source = " + sourceID + ") AND (Destination = "+destinationID+")");
				}
				catch( ApplicationException) {}
			}
		}

		private long GetElementID(ICharacterisedElement element)
		{
			ElementDataset.ElementTableRow[] rows = (ElementDataset.ElementTableRow[])
				elementDataset.ElementTable.Select("(Identifier = '" + element.ID.ToString() + "') AND (Name = '" + element.Name + "')");
			if (rows.Length > 0)
			{
				return rows[0].ID;
			}
			throw new ApplicationException("Element '" + element.ToString() + "' not found!");
		}

		internal void RemoveElements(string filterExpression)
		{
			ElementDataset.ElementTableRow[] rows = (ElementDataset.ElementTableRow[])
				elementDataset.ElementTable.Select(filterExpression);
			foreach (ElementDataset.ElementTableRow row in rows)
			{
				elementHash.Remove(row.ID);
				elementDataset.ElementTable.RemoveElementTableRow(row);
			}
			OnElementRemoved(filterExpression);
		}

		private Vector SelectElements(string filterExpression)
		{
			Vector result = new Vector();
			ElementDataset.ElementTableRow[] rows = (ElementDataset.ElementTableRow[]) elementDataset.ElementTable.Select(filterExpression);
			foreach (ElementDataset.ElementTableRow row in rows)
			{
				result.Add(elementHash[row.ID]);
			}
			return result;
		}

		private void RemoveConnection(string filterExpression)
		{
			ElementDataset.ConnectionTableRow[] rows = (ElementDataset.ConnectionTableRow[])
				elementDataset.ConnectionTable.Select(filterExpression);
			if (rows.Length > 0)
			{
				connectionHash.Remove(rows[0].ID);
				elementDataset.ConnectionTable.RemoveConnectionTableRow(rows[0]);
			}
		}

		private Vector SelectConnections(string filterExpression)
		{
			Vector result = new Vector();
			ElementDataset.ConnectionTableRow[] rows = (ElementDataset.ConnectionTableRow[]) 
				elementDataset.ConnectionTable.Select(filterExpression);
			foreach (ElementDataset.ConnectionTableRow row in rows)
			{
				result.Add(connectionHash[row.ID]);
			}
			return result;
		}

		protected virtual void OnElementAdded(ICharacterisedElement element)
		{
				if (ElementAdded != null)
				{
					ElementAdded(this, new CharacterisedElementAddedEventArgs(element));
				}
		}

		protected virtual void OnElementRemoved(string filterExpression)
		{
			if (ElementRemoved != null)
			{
				ElementRemoved(this, new CharacterisedElementRemovedEventArgs(filterExpression));
			}
		}

		public object Clone()
		{
			return new ElementContainer(this);
		}
	}

	public class CharacterisedElementRemovedEventArgs : EventArgs
	{
		public string filterExpression;

		public string FilterExpression
		{
			get { return filterExpression; }
		}

		public CharacterisedElementRemovedEventArgs(string filterExpression)
		{
			this.filterExpression = filterExpression;
		}
	}
	
	public class CharacterisedElementAddedEventArgs : EventArgs
	{
		private ICharacterisedElement element;

		public ICharacterisedElement Element
		{
			get { return element; }
		}

		public CharacterisedElementAddedEventArgs(ICharacterisedElement element)
		{
			this.element = element;
		}
	}

}