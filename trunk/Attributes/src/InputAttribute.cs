/*
 * $Id$
 * 
 * $Log$
 * Revision 1.1  2004/12/15 00:05:12  sliver
 * initial checkin after some major refactorings
 *
 */

using System;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.Attributes
{
	/// <summary>
	/// Input symbol associated with the state.
	/// </summary>
	public class InputAttribute
	{
		private IInput inputSymbol;

		/// <summary>
		/// Input Symbol associated with a state.
		/// </summary>
		public IInput InputSymbol
		{
			get { return inputSymbol; }
			set { inputSymbol = value; }
		}

		/// <summary>
		/// Create a new attribute.
		/// </summary>
		/// <param name="inputSymbol"></param>
		public InputAttribute(IInput inputSymbol)
		{
			this.inputSymbol = inputSymbol;
		}

		/// <summary>
		/// Create a new attribute.
		/// </summary>
		public InputAttribute()
		{
			this.inputSymbol = null;
		}

		#region Attribute Handling

		/// <summary>
		/// Type of the InputAttribute.
		/// </summary>
		public static IAttributeType AttributeType
		{
			get { return attributeType; }
		}

		/// <summary>
		/// Returns the InputAttribute of the state. If it
		/// has no InputAttribute null is returned.
		/// </summary>
		/// <param name="state"></param>
		/// <returns></returns>
		public static InputAttribute GetAttribute(IState state)
		{
			return state.Attributes[InputAttribute.AttributeType] as InputAttribute;
		}

		/// <summary>
		/// Associates <c>inputSymbol</c> with <c>state</c>.
		/// </summary>
		/// <param name="state"></param>
		/// <param name="inputSymbol"></param>
		public static void SetAttribute(IState state, IInput inputSymbol)
		{
			InputAttribute attr = GetAttribute(state);
			if (attr == null)
				attr = new InputAttribute();

			attr.InputSymbol = inputSymbol;
			state.Attributes.Add(InputAttribute.AttributeType, attr);
		}

		private static IAttributeType attributeType = AttributesFactory.Default.CreateAttributeType(new Guid("B34309B7-499F-4bff-A206-AF2979B1FC31"), "InputAttribute", typeof (InputAttribute));

		#endregion
	}
}