import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q2 {
    public static void main(String[] args) {
        String [] words = {"appy", "eya", "dy"};

        List <String> wordsToReplace = Arrays.asList(words);

        System.out.println(replaceWords("Happy", wordsToReplace));
        System.out.println(replaceWords("Heya", wordsToReplace));
        System.out.println(replaceWords("Howdy?", wordsToReplace));
        System.out.println(replaceWords("Howdy? My friend lives in Pompeya and every time I see her I say \"Heya\" to her, she is very happy", wordsToReplace));
    }

    private static String replaceWords(String word, List <String> wordsToReplace) {
        for (String s : wordsToReplace) {
            Pattern p = Pattern.compile(s, Pattern.CASE_INSENSITIVE); //We create a pattern that matches each word in our list. (1)
            Matcher m = p.matcher(word); //We actually check for each match against our phrase
            StringBuilder sb = new StringBuilder();
            if (m.find()) { //If there was a match, we're going to replace each character for an '*' (2)
                for (int i = 0; i < s.length(); i++) {
                    sb.append("*");
                }
            }

            word = m.replaceAll(sb.toString()); //We replace each match with '*' (3)
        }

        return word; //We return the modified word
    }
}