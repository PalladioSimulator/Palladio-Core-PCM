#region info
///////////////////////////////////////////////////////////////////////////////
/// This software has been developed as a part of the diploma thesis 
/// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
/// Komponentenadapter" ("Influence of the configuration of a generator on the 
/// prediction of the QoS of component adaptors")
/// at the 
/// University of Oldenburg
/// Department of Computing Science
/// Software Engineering Group
/// Palladio Research Group
/// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
/// 
/// Development period: July 2005 - January 2006
/// 
/// Author: Niels Streekmann
/// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion
using System;
using antlr.collections;

namespace Palladio.QoSAdaptor.QMLComparison
{
	/// <summary>
	/// The QMLComparator is abled to compare two given QML interface 
	/// specifications. 
	/// There are some constraints the QML specifications have to fulfill to 
	/// be handled with this version of the QMLComparator:
	///		- There should only be one profile declaration in each 
	///		  specification.
	///		- The profile declaration of the provided interface should cover
	///		  all "from X require" sections of the required interface, but may
	///		  have additional sections itself which are not considered in the
	///		  comparison.
	///		- The denotation of contract types has to equal the denotations of
	///		  the QoS-effects in the pattern description. Otherwise a mapping
	///		  would be necessary. 
	///		  TODO: Compose list of possible QoS attributes?
	///		- TODO: Restrict usage of requirements in profiles to a 
	///		        prototypical case. E.g.:
	///		        - no contract declarations are allowed nested in profile
	///		          declarations.
	///		        - prohibit requirements which do not refer to a certain 
	///		          method / service?
	/// Comparison basics:
	///		- "from X require" sections for the same X (compared by name) have
	///		  to require contracts with equal contract types.
	///	TODO: Handle specifications with multiple profile declarations.
	/// TODO: How can the interfaces be compared and what is the result of the
	/// comparison?
	/// </summary>
	public class QMLComparator
	{
		#region constructor
		/// <summary>
		/// Standard constructor.
		/// </summary>
		public QMLComparator()
		{
		}
		#endregion

		#region public methods
		/// <summary>
		/// Compares two given qml interface specifications. The specifications
		/// have to be given as antlr.ASTs where the root node is the 
		/// declarations node.
		/// TODO: What type of return value is needed.
		/// </summary>
		/// <param name="requiredSpecification">QML specification of the 
		/// required interface.</param>
		/// <param name="providedSpecification">QML specification of the 
		/// provided interface.</param>
		public void Compare (AST requiredSpecification, 
								AST providedSpecification)
		{	
			if (!requiredSpecification.getText().Equals("declarations"))
			{
				// TODO: throw exception
			}
			else if (!providedSpecification.getText().Equals("declarations"))
			{
				// TODO: throw exception
			}

			// TODO: Compare the interfaces.

			// TEST: Compare contract types of required with provided
			AST reqAST = requiredSpecification.getFirstChild();
			for (int i=0; i<requiredSpecification.getNumberOfChildren(); i++)
			{
				if (reqAST.getText().Equals("contrTypeDecl"))
				{
					// compare to all provided contrTypeDecls
					AST provAST = providedSpecification.getFirstChild();
					for (int j=0; 
						j<requiredSpecification.getNumberOfChildren(); j++)
					{
						if (provAST.getText().Equals("contrTypeDecl"))
						{
							bool test = CompareContractTypes(reqAST, provAST);
							if (test)
								Console.WriteLine("Contract types match");
						}
					}
				}
				reqAST = reqAST.getNextSibling();
			}
		}
		#endregion

		#region private methods
		/// <summary>
		/// Compares two given contract types.
		/// </summary>
		/// <param name="contractType1">AST with "contractTypeDecl as root 
		/// node"</param>
		/// <param name="contractType2">AST with "contractTypeDecl as root 
		/// node"</param>
		/// <returns>True if contractType1 and contractType2 are equal. Else
		/// false.</returns>
		private bool CompareContractTypes (AST contractType1, AST contractType2)
		{
			if (!(contractType1.getText().Equals("contractTypeDecl")
				  && contractType2.getText().Equals("contractTypeDecl")))
			{
				// TODO: throw exception
			}
			// Compare the names of the contract types (e.g. "Performance")
			AST contractT1 = contractType1.getFirstChild();
			AST contractT2 = contractType2.getFirstChild();
			if (!contractT1.getText().Equals(contractT2.getText()))
				return false;
			// Contract types are not equal if they have different numbers of 
			// dimensions.
			else if (contractType1.getNumberOfChildren() != 
						contractType2.getNumberOfChildren())
				return false;
			else
			{
				contractT1 = contractT1.getNextSibling();
				contractT2 = contractT2.getNextSibling();
				for (int i=0; i<contractType1.getNumberOfChildren()-1; i++)
				{
					bool check = false;
					AST temp = contractT2;
					// Since the contract dimensions may be in different order
					// in the different contract type declarations, each 
					// dimension of contractT1 is compared to each dimension of
					// contractT2. If all of these comparisons return false
					// the whole comparison will return false
					for (int j=0; j<contractType2.getNumberOfChildren()-1; 
						j++)
					{
						if (CompareDimensions(contractT1, temp))
							check = true;
						temp = temp.getNextSibling();
					}
					if (!check)
						return false;
					contractT1 = contractT1.getNextSibling();
				}
				return true;
			}
		}

		/// <summary>
		/// Compares two given contracts. The contracts have to be given as 
		/// ASTs with "contractDecl" as root node.
		/// </summary>
		/// <param name="requiredContract">The required contract</param>
		/// <param name="providedContract">The provided contract</param>
		/// <returns>TODO: What type should the return value have?</returns>
		private void CompareContracts (AST requiredContract, 
										AST providedContract)
		{
			if (!(requiredContract.getText().Equals("contractDecl")
				&& providedContract.getText().Equals("contractDecl")))
			{
				// TODO: throw exception
			}
			//TODO: Compare contracts
		}

		/// <summary>
		/// Compares two given profiles. The profiles have to be given as ASTs 
		/// with "profileDecl" as root node.
		/// The provided profile should provide all 
		/// </summary>
		/// <param name="requiredProfile">The required profile</param>
		/// <param name="providedProfile">The provided profile</param>
		/// <returns>TODO: What type should the return value have?</returns>
		private void CompareProfiles (AST requiredProfile, AST providedProfile)
		{
			if (!(requiredProfile.getText().Equals("profileDecl")
				&& providedProfile.getText().Equals("profileDecl")))
			{
				// TODO: throw exception
			}
			// TODO: Compare profiles
		}

		/// <summary>
		/// Compares two dimensions. 
		/// </summary>
		/// <param name="dimension1">AST with dimensionDecl as root node.
		/// </param>
		/// <param name="dimension2">AST with dimensionDecl as root node.
		/// </param>
		/// <returns>True, if the dimensions are equal. Else false.</returns>
		private bool CompareDimensions (AST dimension1, AST dimension2)
		{
			if (!(dimension1.getText().Equals("dimensionDecl")
				&& dimension2.getText().Equals("dimensionDecl")))
			{
				// TODO: throw exception
				Console.WriteLine("CompareDimensions EXCEPTION");
				return false;
			}

			// Check if dimension names are equal
			AST ast1 = dimension1.getFirstChild();
			AST ast2 = dimension2.getFirstChild();
			if (!(ast1.getText().Equals(ast2.getText())))
				return false;

			// Check if dimension types are equal
			ast1 = ast1.getNextSibling();
			ast2 = ast2.getNextSibling();
			if (!CompareDimensionTypes(ast1, ast2))
				return false;

			// Check if dimension units are specified and equal
			ast1 = ast1.getNextSibling();
			ast2 = ast2.getNextSibling();
			// Compare units if specified
			if (((ast1 != null) && (ast2 != null)))
				if (!CompareDimensionUnits(ast1, ast2))
					return false;
					// Dimensions are different if one dimension defines units and one
					// does not define units.
				else if ((ast1 == null) || (ast2 == null))
					return false;

			// return true when all comparisons were successful
			return true;
		}

		/// <summary>
		/// Compares two dimension types. 
		/// </summary>
		/// <param name="type1">AST representing a dimension type</param>
		/// <param name="type2">AST representing a dimension type</param>
		/// <returns>True, if the dimension types are equal. Else false.
		/// </returns>
		private bool CompareDimensionTypes (AST type1, AST type2)
		{
			// TODO: Is a different handling for the different node types
			// QMLTokenTypes.ENUM_DEF, QMLTokenTypes.SET_DEF and
			// QMLTokenTypes.NUMERIC_DEF needed ???

			// Compare root node
			if (!(type1.getText().Equals(type2.getText())))
				return false;
			// Compare number of children
			else if (!(type1.getNumberOfChildren() == type2.getNumberOfChildren()))
				return false;
			// Compare children
			AST ast1 = type1.getFirstChild();
			AST ast2 = type2.getFirstChild();
			for (int i=0; i<type1.getNumberOfChildren(); i++)
			{
				if (!(ast1.getText().Equals(ast2.getText())))
					return false;
				ast1 = ast1.getNextSibling();
			}
			// return true when all comparisons were successful
			return true;
		}

		/// <summary>
		/// Compares two dimension units. 
		/// </summary>
		/// <param name="unit1">AST representing a dimension unit</param>
		/// <param name="unit2">AST representing a dimension unit</param>
		/// <returns>True, if the dimension units are equal. Else false.
		/// </returns>
		private bool CompareDimensionUnits (AST unit1, AST unit2)
		{
			if ((!unit1.getText().Equals("unit")) || 
				(!unit2.getText().Equals("unit")))
			{
				// TODO: Throw exception 
				Console.WriteLine("name unit1.getText() does not equal expected name -unit-");
			}
			AST ast1 = unit1.getFirstChild();
			AST ast2 = unit2.getFirstChild();
			// Every dimension unit can be composed of multiple units
			// E.g. mb/sec
			for (int i=0; i<unit1.getNumberOfChildren(); i++)
			{
				// Compare the units
				if (!(ast1.getText().Equals(ast2.getText())))
					return false;
				ast1 = ast1.getNextSibling();
				ast2 = ast2.getNextSibling();
			}
			// return true when all comparisons were successful
			return true;
		}
		#endregion
	}
}
