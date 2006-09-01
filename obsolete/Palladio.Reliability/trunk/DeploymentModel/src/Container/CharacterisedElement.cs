using System;
using Palladio.Identifier;

namespace Palladio.DeploymentModel
{
	/// <summary>
	/// </summary>
	public class CharacterisedElement	: ICharacterisedElement
	{
		private IIdentifier id;
		private string name;

		public CharacterisedElement(string name)
		{
			this.id = IdentifiableFactory.CreateGUID();
			this.name = name;
		}

		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get { return id; }
		}

		public string Name
		{
			set { name = value; }
			get { return name; }
		}

		public override string ToString()
		{
			return name;
		}

		public override bool Equals(object obj)
		{
			if (obj is ICharacterisedElement)
			{
				ICharacterisedElement elem =  (ICharacterisedElement) obj;
				Console.WriteLine(elem.ID);
				return Name.Equals(elem.Name);
			}
			return false;
		}

		public override int GetHashCode()
		{
			return ID.GetHashCode();
		}
	}
}
