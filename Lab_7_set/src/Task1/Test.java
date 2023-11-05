package Task1;

import java.util.Iterator;

;

public class Test {
	public static void main(String[] args) {
		MyWordCount m = new MyWordCount();
		
		for (WordCount string : m.filterWords("D")) {
			System.out.println(string.getWord()+"  :"+string.getCount());
		}
//		
//		Iterator<String> i = m.getUniqueWords().iterator();
//		
//		while(i.hasNext()) {
//			String element = i.next();
//            System.out.println(element);
//		}
//		for (String string : m.getDistinctWords()) {
//			System.out.println(string);
//		}
		Iterator<WordCount> i = m.exportWordCounts().iterator();
//		
//		while(i.hasNext()) {
//			WordCount element = i.next();
//            System.out.println(element);
//		}
	}

}
