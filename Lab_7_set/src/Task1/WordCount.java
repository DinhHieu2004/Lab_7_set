package Task1;

import java.util.Objects;

public class WordCount {

	private String word;
	private int count;

	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + word.hashCode();
//		result = prime * result + count;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		System.out.println("called.");
//		if (obj == null || obj.getClass() != getClass())
//			return false;
//		else {
//			WordCount c = (WordCount) obj;
//			return this.word.equals(c.word);
//		}
//	}
	
	
	public int getCount() {
		return count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, word);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordCount other = (WordCount) obj;
		return count == other.count && Objects.equals(word, other.word);
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWord() {
		return word;
	}
	public int increaseCount() {
		return this.count ++;
	}

	@Override
	public String toString() {
		return this.word + "-" + this.count;
	}
	
}
