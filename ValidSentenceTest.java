package validSentence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidSentenceTest {

	@Test
	void testValidSentence() {
		boolean expected = false;
		boolean actual = false;
		
		// test case 1
		expected = true;
		actual = ValidSentence.validSentence("The quick brown fox said \"hello Mr lazy dog\".");		
		assertEquals(expected, actual);
		
		// test case 2
		expected = true;
		actual = ValidSentence.validSentence("The quick brown fox said hello Mr lazy dog.");		
		assertEquals(expected, actual);
		
		// test case 3
		expected = true;
		actual = ValidSentence.validSentence("One lazy dog is too few, 13 is too many.");		
		assertEquals(expected, actual);
		
		// test case 4
		expected = true;
		actual = ValidSentence.validSentence("One lazy dog is too few, thirteen is too many.");		
		assertEquals(expected, actual);
		
		// test case 5
		expected = true;
		actual = ValidSentence.validSentence("How many \"lazy dogs\" are there?");		
		assertEquals(expected, actual);
		
		// test case 6
		expected = false;
		actual = ValidSentence.validSentence("The quick brown fox said \"hello Mr. lazy dog\".");		
		assertEquals(expected, actual);
		
		// test case 7
		expected = false;
		actual = ValidSentence.validSentence("\"The quick brown fox said \"hello Mr lazy dog.\"");		
		assertEquals(expected, actual);
		
		// test case 8
		expected = false;
		actual = ValidSentence.validSentence("One lazy dog is too few, 12 is too many.");		
		assertEquals(expected, actual);
		
		// test case 9
		expected = false;
		actual = ValidSentence.validSentence("Are there 11, 12, or 13 lazy dogs?");		
		assertEquals(expected, actual);
		
		// test case 10
		expected = false;
		actual = ValidSentence.validSentence("There is no punctuation in this sentence");		
		assertEquals(expected, actual);
	}

}
