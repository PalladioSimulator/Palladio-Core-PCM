package org.palladiosimulator.protocom.lang.xml.impl

import org.palladiosimulator.protocom.lang.GeneratedFile
import org.palladiosimulator.protocom.lang.xml.ITestPlan
import java.util.regex.Pattern
import java.util.regex.Matcher

/**
 * @author Christian Klaussner
 */
class TestPlan extends GeneratedFile<ITestPlan> implements ITestPlan {
	
	/**
	 * 
	 */
	val scriptRegex = "(<stringProp name=\"BeanShellSampler.query\">)(.*?)(</stringProp>)";
	
	/**
	 * Searches for script tags and removes the indentation added by Xtend's whitespace handling.
	 * This is not required but increases the readability of the scripts in JMeter.
	 */
	private def postProcessScripts(String output) {
		var pattern = Pattern.compile(scriptRegex, Pattern.DOTALL)
		var matcher = pattern.matcher(output)
		
		var result = new StringBuffer
		
		while (matcher.find()) {
			var script = matcher.group(2).replaceAll("\n\\u0020*", "\n")
			script = Matcher.quoteReplacement(script)
			
			matcher.appendReplacement(result, "$1" + script + "$3")
		}
		
		matcher.appendTail(result)
		
		result.toString
	}
	
	override generate() {
		postProcessScripts('''
			<?xml version="1.0" encoding="UTF-8"?>
			<jmeterTestPlan version="1.2" properties="2.6" jmeter="2.11 r1554548">
			  <hashTree>
			    «testPlan»
			    <hashTree>
			      «requestDefaults»
			      <hashTree/>
			      «threadGroup»
			      <hashTree>
			        «content»
			      </hashTree>
			    </hashTree>
			  </hashTree>
			</jmeterTestPlan>
		''')
	}
	
	override content() {
		provider.content
	}
	
	/**
	 * Generates the XML for the test plan.
	 * @returns a string containing the XML for the test plan 
	 */
	private def testPlan() {
		'''
		<TestPlan guiclass="TestPlanGui" testclass="TestPlan" testname="Test Plan" enabled="true">
		  <stringProp name="TestPlan.comments"></stringProp>
		  <boolProp name="TestPlan.functional_mode">false</boolProp>
		  <boolProp name="TestPlan.serialize_threadgroups">false</boolProp>
		  <elementProp name="TestPlan.user_defined_variables" elementType="Arguments" guiclass="ArgumentsPanel" testclass="Arguments" testname="User Defined Variables" enabled="true">
		    <collectionProp name="Arguments.arguments"/>
		  </elementProp>
		  <stringProp name="TestPlan.user_define_classpath"></stringProp>
		</TestPlan>
		'''
	}
	
	/**
	 * Generates the XML for the HTTP request defaults
	 * @returns a string containing the XML for the HTTP request defaults
	 */
	private def requestDefaults() {
		'''
		<ConfigTestElement guiclass="HttpDefaultsGui" testclass="ConfigTestElement" testname="HTTP Request Defaults" enabled="true">
		  <elementProp name="HTTPsampler.Arguments" elementType="Arguments" guiclass="HTTPArgumentsPanel" testclass="Arguments" testname="User Defined Variables" enabled="true">
		    <collectionProp name="Arguments.arguments"/>
		  </elementProp>
		  <stringProp name="HTTPSampler.domain">localhost</stringProp>
		  <stringProp name="HTTPSampler.port">8080</stringProp>
		  <stringProp name="HTTPSampler.connect_timeout"></stringProp>
		  <stringProp name="HTTPSampler.response_timeout"></stringProp>
		  <stringProp name="HTTPSampler.protocol"></stringProp>
		  <stringProp name="HTTPSampler.contentEncoding"></stringProp>
		  <stringProp name="HTTPSampler.path"></stringProp>
		  <stringProp name="HTTPSampler.concurrentPool">4</stringProp>
		</ConfigTestElement>
		'''
	}
	
	/**
	 * Generates the XML for the thread group.
	 * @returns a string containing the XML for the thread group
	 */
	private def threadGroup() {
		'''
		<ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="Thread Group" enabled="true">
		  <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
		  <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControlPanel" testclass="LoopController" testname="Loop Controller" enabled="true">
		    <boolProp name="LoopController.continue_forever">false</boolProp>
		    <stringProp name="LoopController.loops">10</stringProp>
		  </elementProp>
		  <stringProp name="ThreadGroup.num_threads">1</stringProp>
		  <stringProp name="ThreadGroup.ramp_time">1</stringProp>
		  <longProp name="ThreadGroup.start_time">1409475705000</longProp>
		  <longProp name="ThreadGroup.end_time">1409475705000</longProp>
		  <boolProp name="ThreadGroup.scheduler">false</boolProp>
		  <stringProp name="ThreadGroup.duration"></stringProp>
		  <stringProp name="ThreadGroup.delay"></stringProp>
		</ThreadGroup>
		'''
	}
}
