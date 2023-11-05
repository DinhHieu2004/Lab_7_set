package Task1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {

	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// Returns a set of WordCount objects that represents the number of times
	// each // unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.

	public List<WordCount> getWordCounts() {
		List<WordCount> result = new ArrayList<>();
		for (String word : words) {
			boolean found = false;
			for (WordCount wordCount : result) {
				if (wordCount.getWord().equals(word)) {

					wordCount.increaseCount();
					found = true;
					break;
				}
			}
			if (!found) {

				result.add(new WordCount(word, 1));
			}
		}

		return result;
	}

	// Returns the words that their appearances are 1, do not consider
	// duplidated words

	public Set<String> getUniqueWords() {
		Set<String> re = new HashSet<>();
		List<WordCount> list = getWordCounts();

		for (WordCount wordCount : list) {
			if (wordCount.getCount() == 1) {
				re.add(wordCount.getWord());
			}
		}
		return re;
	}
	// Returns the words in the text file, duplicated words appear once in the
	// result

	public Set<String> getDistinctWords() {
		Set<String> result = new HashSet<>();
		
		for (String string : words) {
			result.add(string);
		}

		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of
	// tokens
	// Example: An - 3, Bug - 10, ...
	 public Set<WordCount> exportWordCounts() {
	        Set<WordCount> re = new TreeSet<>(new Comparator<>() {
	            @Override
	            public int compare(WordCount o1, WordCount o2) {
	               
	            	return o1.getWord().compareTo(o2.getWord());
	          
	            }
	        });
	       
	        re.addAll(getWordCounts());
	        return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsOrderByOccurence() {
		Set<WordCount> re = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(WordCount o1, WordCount o2) {
               return o1.getCount()-o2.getCount();
            	
            }
        });
       
        re.addAll(getWordCounts());
        return re;
	
	}

	// delete words beginning with the given pattern (i.e., delete words begin
	// with 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		Set<WordCount> result = new HashSet<>();
		for (WordCount word : getWordCounts()) {
			if(!word.getWord().startsWith(pattern)) {
				result.add(word);
			}
		}
		return result;
	}

}
