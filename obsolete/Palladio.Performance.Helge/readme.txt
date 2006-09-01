------------------------------
---- Description:         ----
------------------------------
The Palladio.Performance tool computes the performance of a service effect automaton. A service effect automaton is a finite
state machine created by the Palladio.FiniteStateMachines library. For the computation of the performance the time behavior 
of each state and transition must be specified by an attribute. The calculation uses RandomVariable attributes for computation in time domain and FourierAttributes for computation in frequency domain. The time behavior can also be defined
by QML aspects. A attribute transformer can transform the attributes from one to another.
Additional the probability for each transition is needed as a ProbabilityAttribute.
For the computation of the loop you have to define an epsilon. The calculation is aborted when the total probability of the result reaches 1-epsilon. So the epsilon
defines the precision of the loop calculation.

------------------------------
---- Folders:             ----
------------------------------
- Config: Configuration files.
- TestData: Some data for testing and the required DTDs.


------------------------------
---- Solutions:           ----
------------------------------
- Palladio.Performance:
Starting project is XmlSeffParser. For Configuration see the XmlSeffParserConfig.xml in config folder.

- WebserverAnalyser: Generates seffs for the Palladio.Webserver. ProbabilityAttributes and RandomVariables are generated from measures. For configuration see the WebserverAnalyserConfig.xml in config directory.



------------------------------
---- Projects:            ----
------------------------------
XmlSeffParser: The XmlSeffParser is configured by the XmlSeffParserConfig.xml. The parser takes an xml file as input that follows the XmlSeffParser.dtd (see config folder) and generates a service effect automaton. The performance is calculated using the PerformanceCalculator.

PerformanceCalculator: The PerformanceCalculator computes the performance for a service effect automaton.
Depending on the configuration the calculation is done in time domain or frequency domain. The service effect automaton is
transformed into a regular expression and the performance is calculated by the RegExASTVisitor.

FSMTransformer: The FSMTransformer transforms the service effect automaton, that all time consumption is associated to transitions.
For each time consuming state s , a new state s' and transition t:s'->s is created. The new transition t 
gets the time consumption of state s. All incoming transitions of s are directed to s'.


Attributes: Defines attributes, that are added to the service effect automaton and needed for the performance
calculation. The AttributeTransformer provides methods to convert an attribute to another.

Math: Defines classes for discrete functions with equidistant values. MathTools give access to the DiscreteFunctionFactory and the fourier transformation.

RegExASTVisitor: The visitors go through the regular expression and calculate the performance. There are one visitor for the calculation in time domain and one visitor for the calculation in frequency domain. The RegExASTVisitorDetermineProbabilitiesAndMaxValue is invoked by the RegExASTVisitorFrequencyDomain to determine the vector size of the result.

WebserverSeff: Creation of the service effect automaton of the Palladio.Webserver. The attributes are created from measure. 
Examples of the webserver measures are located in the TestData directory.

Measure: Defines some static timer for measures.

WebserverAnalyser: The WebserverAnalyser is configured by the WebserverAnalyserConfig.xml. It generates a Service effect automaton and performs the calculation. The result is stored as xml file.


