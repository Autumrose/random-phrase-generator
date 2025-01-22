package comprehensive;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Collection of methods that generates a specified number of random phrases in the command-line given
 * a no-context grammar file.
 * 
 * @author Zoe Ewing and Autumrose Stubbs
 */
public class RandomPhraseGenerator {
	static Grammar grammar;
	static Random rand;

	/**
	 * Main method that prints each randomized phrase.
	 * 
	 * @param args - two command line arguments: a grammar file name and the number of phrases to generate
	 * @throws FileNotFoundException if the specified file does not exist
	 */
	public static void main(String args[]) throws FileNotFoundException {
		rand = new Random();
		grammar = new Grammar(args[0]);
		for (int i = 0; i < Integer.parseInt(args[1]); i++) {
			System.out.println(devolveSentence(grammar.findDefinition("<start>")));
		}
	}

	/**
	 * Continues to break down each nonterminal of the sentence until none are left.
	 * 
	 * @param defList - the list of possible starting sentences
	 * @return a version of the original starting sentence with only terminals remaining
	 */
	private static StringBuilder devolveSentence(ArrayList<String> defList) {
		StringBuilder sentence = new StringBuilder(defList.get(rand.nextInt(defList.size())));
		String newWord;
		String temp;
		int firstIndex;
		while (sentence.indexOf("<") > -1) {
			newWord = sentence.substring(sentence.indexOf("<"), sentence.indexOf(">") + 1);
			defList = grammar.findDefinition(newWord);
			temp = defList.get(rand.nextInt(defList.size()));
			firstIndex = sentence.indexOf(newWord);
			if (firstIndex > -1) {
				sentence.replace(firstIndex, firstIndex + newWord.length(), temp);
			}
		}
		return sentence;
	}
}
