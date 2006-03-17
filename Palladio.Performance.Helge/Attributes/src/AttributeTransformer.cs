using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Math;

namespace Palladio.Performance.Attributes
{
	/// <summary>
	/// Class for transforming or generating Attributes. All methods are static.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: AttributeTransformer.cs,v $
	/// Revision 1.2  2005/10/11 22:05:13  helgeh
	/// - Added NUnit project and NDoc documentation.
	/// - fixed a bug in AdjustSamplingRate
	///
	/// Revision 1.1  2005/08/12 07:59:19  helgeh
	/// Initial impot after refactoring.
	///
	/// Math:
	/// - Added DiscretePDFunction.
	/// - Added Fast Fourier Transformation and FourierFunction.
	/// - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
	/// - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
	/// - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
	///
	/// FSMTransformer:
	/// - Method SEFFValidity added.
	/// - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
	///
	/// WebserverSeffFactory:
	/// - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
	///
	/// WebserverAnalyser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// RegExASTVisitor:
	/// - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
	///
	/// RegularExpressions:
	/// - No changes.
	///
	/// XmlSeffParser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// PerformanceCalculator:
	/// - Added interface IPerformanceCalculator. Added CalculatorFactory.
	///
	/// Unit Tests added.
	/// Updated documentation.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class AttributeTransformer
	{
		/// <summary>
		/// Creates a ProbabilityAttribute for a transition. The probability depends on the measure:
		/// NumberOfVisits(transition)/NumberOfVisits(sourceState)
		/// </summary>
		/// <param name="transition">A Transition with a MeasureAttribute. The source state also must have 
		/// a Measure Attribute</param>
		/// <returns>Probability for the transition.</returns>
		public static ProbabilityAttribute CreateProbabilityAttributeForTransition(ITransition transition) 
		{
			double probability;
			MeasureAttribute transitionMeasure = MeasureAttribute.GetAttribute(transition);
			MeasureAttribute sourceStateMeasure = MeasureAttribute.GetAttribute(transition.SourceState);
			if(transitionMeasure == null || sourceStateMeasure== null)
				throw new ApplicationException("Transition or state does not contain a MeasureAttribute!");
			if(sourceStateMeasure.measures.Count == 0) 
			{
				probability =0;
			} 
			else 
			{
				probability = (double) transitionMeasure.measures.Count / 
					(double) sourceStateMeasure.measures.Count;
			}
			return new ProbabilityAttribute(probability);
		}

		/// <summary>
		/// Creates a new Random Variable out of the MeasureAttribute. 
		/// </summary>
		/// <param name="measure">Attribute containing all measures</param>
		/// <param name="samplingrate">SamplingRate of the new random variable</param>
		public static RandomVariable MeasureAttribute2RandomVariable(MeasureAttribute measure, int samplingrate) 
		{
			if(measure.measures.Count<1) return new RandomVariable(0,samplingrate,new double[] {1}); // execution time of 0


			long min =  (measure.MinMeasure / samplingrate) * samplingrate; // Das neue Minimum ist kleiner oder gleich dem alten, abgerundet
			long span = measure.MaxMeasure - min;
			long dataLength = span / samplingrate + 2;
			

			double[] data = new double[dataLength];
			foreach (Measure m in measure.measures)
			{
				int pos = (int)System.Math.Round(((double)m.executionTime-(double)min) / (double)samplingrate);
				data[pos] += 1;
			}

			// Convert Histogramm to PMF
			double totalNumOfMeasures = (double)measure.measures.Count;
			for (int i=0; i<data.Length; i++)
			{
				data[i] /= totalNumOfMeasures;
			}

			return new RandomVariable(MathTools.DiscreteFunctions.DiscreteValuePDFunction(min,samplingrate,data));
		}


		/// <summary>
		/// Converts a RandomVariable to a QMLAttribute. 
		/// This is a conversion from density function to distribution function.
		/// </summary>
		/// <param name="rand"><c>RandomVariable</c> to be transformed.</param>
		/// <returns>A new QMLAttribute equivalent to the RandomVariable.</returns>
		public static QMLAttribute RandomVariable2QML (RandomVariable rand) 
		{
			int count = rand.ProbabilityDensityFunction.Count;
			double[] percentile = new double[count];
			long[] time = new long[count];

			double actualPercentile=0;
			for(int i=0;i<count;i++) 
			{
				time[i] = rand.ProbabilityDensityFunction.XMin + 
					(i*rand.ProbabilityDensityFunction.SamplingRate);
				actualPercentile += rand.ProbabilityDensityFunction.Data[i]*100;
				percentile[i] = actualPercentile;
			}

			if(rand.ProbabilityDensityFunction.XMin/rand.ProbabilityDensityFunction.SamplingRate > 1)
			{
				double[] newPercentile = new double[count+1];
				long[] newTime = new long[count+1];
				newPercentile[0] = 0;
				newTime[0] = rand.ProbabilityDensityFunction.XMin-rand.ProbabilityDensityFunction.SamplingRate;
				percentile.CopyTo(newPercentile,1);
				time.CopyTo(newTime,1);
				percentile = newPercentile;
				time=newTime;
			}

			return new QMLAttribute(percentile,time);
		}


		/// <summary>
		/// Creates a RandomVariable out of a QML Specification. This is a conversion from distribution function
		/// to density function.
		/// The aspects must be defined in ascending order. 
		/// </summary>
		/// <param name="qml">The QMLAttribute.</param>
		/// <returns>A new RandomVariable which density function has a fixed samplingrate.</returns>
		public static RandomVariable Qml2RandomVariable(QMLAttribute qml)
		{
			if(qml.Aspects[0].Percentile == 100 && qml.Aspects[0].TimeValue == 0) return new RandomVariable();

			QmlDensityFunction densityFunction = qml.GetQmlDensityFunction();
			double[] pdf = ComputeProbabilities(qml);

			long samplingrate = MathTools.GCD(densityFunction.GetDistance());

			long minTime=qml.Aspects[0].TimeValue;
			if(minTime!=0) minTime = samplingrate;
			RandomVariable rand = new RandomVariable(minTime, samplingrate, pdf);

			rand.ProbabilityDensityFunction.Crop();
			return rand;
		}

		/// <summary>
		/// Computes the probabilities for an equidistant probability density function.
		/// </summary>
		/// <param name="qml"><c>QMLAttribute</c> which shall be converted.</param>
		/// <returns>Probabilities for an equidistant probability density function.</returns>
		private static double[] ComputeProbabilities(QMLAttribute qml)
		{
			QmlDensityFunction densityFunction = qml.GetQmlDensityFunction(); 
			long[] distance = densityFunction.GetDistance();
			long samplingrate = MathTools.GCD(distance);
			double[] pdf = new double[qml.GetMaxTime()/samplingrate+1]; //one more for an execution time of 0
			int pdf_i = 0; //index for pdf

			int length = qml.Length;
			for (long i=0;i<length;i++)
			{
				int numberOfValues = 
					System.Math.Max((int) (distance[i]/samplingrate),1); // avoid omit of values (execution time of 0 implies a distance of 0) 
				for (int j=0; j<numberOfValues;j++)
				{
					pdf[pdf_i++]= densityFunction.QmlDensityFunctionValues[i].Probability / numberOfValues;
				}
			}
			return pdf;
		}

	}
}
