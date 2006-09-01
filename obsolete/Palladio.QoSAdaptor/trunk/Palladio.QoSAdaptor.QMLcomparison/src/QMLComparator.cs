#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using System.Collections;
using System.IO;
using antlr.collections;
using Palladio.QoSAdaptor.Exceptions;
using Palladio.QoSAdaptor.Interfaces;
using Palladio.QoSAdaptor.QMLComparison.QmlSpecification;
using Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison
{
	/// <summary>
	/// Compares QML specifications in order to find mismatches.
	/// </summary>
	public class QMLComparator : IQMLComparator
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
		/// Checks if the given provided specification covers the same 
		/// interfaces and contracts as the given required specification.
		/// If this is not the case an IncompleteInterfaceCopingException is 
		/// thrown.
		/// </summary>
		/// <param name="requiredSpecification">QML specification of the 
		/// required interface.</param>
		/// <param name="providedSpecification">QML specification of the 
		/// provided interface.</param>
		public void CheckCompleteCoping (
			IInterfaceModelSpecification requiredSpecification, 
			IInterfaceModelSpecification providedSpecification)
		{
			QMLProvidedSpecificationCompleteCopingVisitor providedCCVisitor =
				new QMLProvidedSpecificationCompleteCopingVisitor();
			((QMLSpecification)providedSpecification).Accept(providedCCVisitor);

			QMLRequiredSpecificationCompleteCopingVisitor requiredCCVisitor =
				new QMLRequiredSpecificationCompleteCopingVisitor(
				providedCCVisitor);
			((QMLSpecification)requiredSpecification).Accept(requiredCCVisitor);
			
			if (!requiredCCVisitor.CopingErrorMessage.Equals(string.Empty))
				throw new IncompleteInterfaceCopingException(
					requiredCCVisitor.CopingErrorMessage); 
		}

		/// <summary>
		/// Searches for mismatches in the two given QML specifications. 
		/// CheckCompleteCoping has to be called before.
		/// </summary>
		/// <param name="requiredSpecification">TextReader representing the specification 
		/// for the required interface.</param>
		/// <param name="providedSpecification">TextReader representing the specification 
		/// for the provided interface.</param>
		/// <returns>A list of QMLMismatch objects.</returns>
		public IList FindMismatches (
			IInterfaceModelSpecification requiredSpecification, 
			IInterfaceModelSpecification providedSpecification)
		{
			QMLProvidedSpecificationMismatchSearchVisitor providedVisitor = 
				new QMLProvidedSpecificationMismatchSearchVisitor();
			((QMLSpecification)providedSpecification).Accept(providedVisitor);

			QMLRequiredSpecificationMismatchSearchVisitor requiredVisitor = 
				new QMLRequiredSpecificationMismatchSearchVisitor(providedVisitor);
			((QMLSpecification)requiredSpecification).Accept(requiredVisitor);

			IList mismatches = requiredVisitor.Mismatches;
			return mismatches;
		}

		/// <summary>
		/// Parses the given QML specification, builds an internal model of the
		/// specification and returns its string representation.
		/// Can e.g. be used for debugging of the parser. 
		/// </summary>
		/// <param name="specificationReader">A TextReader representing a QML
		/// specification.</param>
		/// <returns>The string representation of the internal model of the
		/// QML specification.</returns>
		public string Parse (TextReader specificationReader)
		{
			QMLSpecification specification = CreateQMLSpecification(
				specificationReader);
			return specification.ToString();
		}
		
		/// <summary>
		/// Creates a QMLSpecification from the textual QML specification given
		/// in form of a textReader.
		/// </summary>
		/// <param name="textReader">TextReader containing a textual 
		/// representation of a QML specification.</param>
		/// <returns></returns>
		public QMLSpecification CreateQMLSpecification (TextReader 
			textReader)
		{
			QMLLexer lexer = new QMLLexer(textReader);	
			lexer.setTokenObjectClass("antlr.CommonHiddenStreamToken");
			QMLParser parser = new QMLParser(lexer);
			parser.setASTNodeClass("QmlParser.QMLAST");
			parser.declarations();

			QMLSpecification specification = new QMLSpecification(
			(AST)parser.getAST());
			return specification;
		}
		#endregion
	}
}
