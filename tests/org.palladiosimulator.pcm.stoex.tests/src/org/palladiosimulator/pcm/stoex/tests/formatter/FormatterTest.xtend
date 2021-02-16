package org.palladiosimulator.pcm.stoex.tests.formatter

import com.google.inject.Inject
import de.uka.ipd.sdq.stoex.Expression
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.palladiosimulator.pcm.stoex.tests.PCMStoexInjectorProvider
import static org.junit.jupiter.api.Assertions.*

@ExtendWith(InjectionExtension)
@InjectWith(PCMStoexInjectorProvider)
class FormatterTest {

	@Inject extension ISerializer
	@Inject extension ParseHelper<Expression>

	@Test
	def testVariableCharacterisation() {
		val varChar = '''a . b . NUMBER_OF_ELEMENTS'''
		assertEquals("a.b.NUMBER_OF_ELEMENTS", varChar.parse.serialize(SaveOptions.newBuilder.format.options))
    }

}
