# Random Phrase Generator
## Purpose
This project highlights understanding  data structures and problem-solving skills through the implementation of a random phrase generator. This is a pair programming project that required collaboration, code review and feedback, and combining different perspectives and knowledge.

## Overview
The program generates randomized phrases based on the structure defined in an input grammar file. Phrases are constructed according to strict formatting rules and incorporate both non-terminals (e.g., <noun>) and terminals (e.g., "dog"). The starting non-terminal is always <start>.

The program takes two command-line arguments:
* The path to the input grammar file.
* The number of random phrases to generate.
## Example
For the grammar file super_simple.g, possible outputs include:
* "The cat sat on the mouse."
* "The mouse stood on the dog."
## Grammar File Rules
1. Non-terminals are enclosed in angle brackets (e.g., <noun>). They must not contain whitespace.
2. Each non-terminal has a definition that:
   * Begins with { on its own line.
   * Lists the non-terminal being defined on the next line.
   * Contains one or more productions (sequences of terminals and/or non-terminals) listed one per line.
   * Ends with } on its own line.
3. Terminals are written without angle brackets and may appear in productions alongside non-terminals.
4. Any lines outside the curly braces are ignored (comments or whitespace).
5. The <start> non-terminal is the entry point for generating phrases.
## Input and Output
* ### Input:
  * A grammar file following the strict formatting rules.
  * Number of phrases to generate.
* ### Output: Randomly generated phrases printed to the console, one per line, preserving spacing in the grammar file.
## Requirements
* Implement the program in a class named RandomPhraseGenerator in a package named comprehensive.
* The program must:
  * Parse the grammar file.
  * Generate the specified number of random phrases based on the grammar rules.
  * Preserve formatting rules (e.g., no trailing spaces).
* Ensure efficiency to meet running-time requirements.
## How to Run
1. Compile the program using javac:
   * javac comprehensive/RandomPhraseGenerator.java
2. Run the program from the terminal:
   * java comprehensive/RandomPhraseGenerator <grammar_file_path> <number_of_phrases>
   
   Example:
      * java comprehensive/RandomPhraseGenerator poetic_sentence.g 5
      * This will generate 5 random phrases based on poetic_sentence.g
