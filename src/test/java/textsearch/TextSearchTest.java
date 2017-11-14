package textsearch;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TextSearchTest {

	@Test
	public void test1() {
		TweetHistory tHistory = new TweetHistory();
		tHistory.add("hello #world");
		assertEquals("#world", tHistory.getPopularHashtag());
	}

	@Test
	public void test2() {
		TweetHistory tHistory = new TweetHistory();
		tHistory.add("hello #world");
		tHistory.add("hello hello bye bye #cruelworld");
		assertEquals(3, tHistory.getNumOccurrences("hello"));
	}

	@Test
	public void test3() {
		TweetHistory tHistory = new TweetHistory();
		tHistory.add("hello #world");
		tHistory.add("hello hello bye bye #cruelworld");
		assertEquals(Arrays.asList("hello hello bye bye #cruelworld"), tHistory.getOccurrences("bye"));
	}

	@Test
	public void test4() {
		TweetHistory tHistory = new TweetHistory();
		tHistory.add("hello #world #goodmorning");
		tHistory.add("hello hello bye bye #cruelworld");
		tHistory.add("#cruelworld sic transit gloria mundi #cruelworld");
		assertEquals("#cruelworld", tHistory.getPopularHashtag());
		assertEquals(3, tHistory.getNumOccurrences("cruelworld"));
	}

	@Test
	public void test5() {
		TweetHistory tHistory = new TweetHistory();
		tHistory.add("hello #world #goodmorning");
		tHistory.add("hello hello bye bye #cruelworld");
		assertEquals(Arrays.asList("hello #world #goodmorning", "hello hello bye bye #cruelworld"),
				tHistory.getOccurrences("hello"));
	}
	
	@Test
	public void test6() {
		TweetHistory tHistory = new TweetHistory();
		tHistory.add("#floccinaucinihilipilification");
		assertEquals(Arrays.asList("#floccinaucinihilipilification"),
				tHistory.getOccurrences("floc"));
		assertEquals("#floccinaucinihilipilification", tHistory.getPopularHashtag());
	}
	
	@Test
	public void test7() {
		TweetHistory tHistory = new TweetHistory();
		tHistory.add("#floccinaucinihilipilification");
		assertEquals(Arrays.asList(),
				tHistory.getOccurrences("flock"));
		assertEquals(0,
				tHistory.getNumOccurrences("flock"));
	}

}
