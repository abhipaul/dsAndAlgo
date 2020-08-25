import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Tweet {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		List<String> arrHashTag;
		String tweet = null;
		System.out.println("Enter number of tweets");
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Please enter the correct value");
			e.printStackTrace();
		}
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				try {
					tweet += br.readLine() + " ";
				} catch (IOException e) {
					System.out.println("Please enter the correct tweet");
					e.printStackTrace();
				}
			}
			//This method will extract all the hashtag from the given string
			arrHashTag = extractHashTag(tweet);
			Map<String, Long> map = arrHashTag.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));

			//Select top 10 tweets from all the twwets entered using JAVA 8 function.
			List<Map.Entry<String, Long>> result = map.entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10).collect(Collectors.toList());
			//Print the result
			if (result != null && result.size() > 0) {
				System.out.println("Top 10 tweets in the given entered tweets is as follows:");
			} else {
				System.out.println("There is no tweets to show!");
			}
			for (int i = 0; i < result.size(); i++) {
				System.out.println(((Map.Entry<String, Long>) result.get(i)).getKey());
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("error while closing the buffered reader connection");
			}
		} else {
			System.out.println("Please enter the correct value");
		}
		
	}

	private static List<String> extractHashTag(String tweet) {
		Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
		Matcher mat = MY_PATTERN.matcher(tweet);
		List<String> strs = new ArrayList<String>();
		//Extract tweet from String using regex matcher pattern
		while (mat.find()) {
			strs.add(mat.group(1));
		}
		return strs;
	}
}
