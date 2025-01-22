package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Collection of methods that reads and collects data from a no-context grammar file.
 * 
 * @author Zoe Ewing and Autumrose Stubbs
 */
public class Grammar {
	private HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	private File file;
	
	/**
	 * Constructor that takes input file and constructs the grammar structure from it.
	 * 
	 * @param filename - name of the file to be read
	 * @throws FileNotFoundException if the specified file does not exist
	 */
	public Grammar(String filename) throws FileNotFoundException {
		file = new File(filename);
		buildGrammar(file);
	}

	/**
	 * Private helper method that reads the given file to input grammar rules.
	 * 
	 * @param file - correctly formatted grammar file
	 * @throws FileNotFoundException if the specified file does not exist
	 */
	private void buildGrammar(File file) throws FileNotFoundException {
		try (Scanner scan = new Scanner(file);) {
			while (scan.hasNextLine()) {
				String temp = scan.nextLine();
				if(temp.equals("{")) {
					String nonTerm = scan.nextLine();
					temp = scan.nextLine();
					ArrayList<String> tempList = new ArrayList<String>();
					while(!temp.equals("}")) {
						tempList.add(temp);
						temp = scan.nextLine();
					}
					map.put(nonTerm, tempList);
				}
			}
		}
	}
	
	/**
	 * Finds all possible definitions of the given nonterminal.
	 * 
	 * @param nonTerm - String that represents any nonterminal in the grammar file
	 * @return a list of the nonterminal's production rules
	 */
	public ArrayList<String> findDefinition(String nonTerm){
		return map.get(nonTerm);
	}
}
