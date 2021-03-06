/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package leanMind.katas;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PhraseSplitTest{

	@Test
	public void testSingleWordWithHighNumber() {
		PhraseSplit phraseSplit = new PhraseSplit();
		String phrase = "Hola";
		int columnNumber = 5;
		assertTrue("Hola".equals(phraseSplit.split(phrase, columnNumber)));
	}
	
	@Test
	public void testSingleWordWithLowNumber() {
		PhraseSplit phraseSplit = new PhraseSplit();
		String phrase = "Hola";
		int columnNumber = 2;
		assertTrue("Ho/nla".equals(phraseSplit.split(phrase, columnNumber)));
	}
	
	@Test
	public void testMultipleWordPhrase() {
		PhraseSplit phraseSplit = new PhraseSplit();
		String phrase = "Hola Mundo";
		int columnNumber = 7;
		assertTrue("Hola/nMundo".equals(phraseSplit.split(phrase, columnNumber)));
	}
}
