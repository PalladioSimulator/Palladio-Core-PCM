namespace Palladio.ComponentModel.Signature
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
	/// Revision 1.2  2005/02/24 20:13:05  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:49:17  joemal
	/// initial import
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

		public ParameterModifierEnum Modifier {
			get {
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

		private string name;
		private IType type;
		private ParameterModifierEnum modifier;
		#endregion
	}
}
