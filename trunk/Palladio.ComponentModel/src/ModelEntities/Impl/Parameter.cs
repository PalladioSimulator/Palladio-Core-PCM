namespace Palladio.ComponentModel.ModelEntities.Impl
{
	/// <summary>
	/// Parameter contains the information describing a parameter
	/// of a signature. It consits of a parameter name and a parameter type.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/03/15 12:31:37  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class Parameter : IParameter 
	{
		#region Properties

		/// <summary>
		/// Parameter name.
		/// </summary>
		public string Name 
		{ 
			get{ return name; }
		}

		/// <summary>
		/// Parameter Type.
		/// </summary>
		public IType Type 
		{ 
			get{ return type; }
		}

		/// <summary>
		/// Modifier of the parameter. A modifier specifices the way of passing the
		/// parameter to the method body.
		/// </summary>
		public ParameterModifierEnum Modifier {
			get 
			{
				return modifier;
			}
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new Parameter(this);
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			if (modifier != ParameterModifierEnum.NONE)
				return modifier + " " + type + " " + name;
			else
				return type + " " + name;
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new Parameter with the name aName and the
		/// type aType.
		/// </summary>
		/// <param name="aType">Type of the parameter.</param>
		/// <param name="aName">Name of the parameter.</param>
		/// <param name="aModifier">Modifier of the parameter.</param>
		public Parameter(IType aType, string aName, ParameterModifierEnum aModifier)
		{
			type = aType;
			name = aName;
			modifier = aModifier;
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aParameter">Parameter to copy.</param>
		public Parameter( Parameter aParameter ) :
			this ( aParameter.Type, aParameter.Name, aParameter.Modifier )
		{
		}

		#endregion

		#region Data

		//holds the name
		private string name;

		//holds the type
		private IType type;

		//holds the modifier
		private ParameterModifierEnum modifier;

		#endregion
	}
}
