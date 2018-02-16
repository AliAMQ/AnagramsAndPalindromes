import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String []argh){

        String[] words = {"Radar", "Iceman", "darar", "Cinema", "Abcd", "Bob", "Efgh", "obb","Bcda"};

        System.out.println("Anagrams:");
        List<List<String>> result = setAnagrams(words);
        for(List l:result){
            System.out.println("  " +l);
        }

        System.out.println("---");

        System.out.println("Palindromes:");
        List<String> result2 = setPalindromes(words);
        for (String s: result2){
            System.out.println("  " +s);
        }

    }

    public static List<List<String>> setAnagrams(String[] theWords) {

        String[] words = theWords.clone();

        List<List<String>> result = new ArrayList<List<String>>();
        for (int i=0; i<words.length;i++){
            List<String> innerlist = new ArrayList<String>();
            if (!words[i].equals("")) {
                innerlist.add(words[i]);
                for (int j = i+1; j < words.length; j++) {
                    if (isAnagram(words[i], words[j])) {
                        innerlist.add(words[j]);
                        words[j] = "";
                    }
                }
            }
            if (!innerlist.isEmpty()){
                result.add(innerlist);
            }
        }
        return result;
    }

    public static boolean isAnagram(String string1, String string2){
        char[] chars1 = string1.toLowerCase().toCharArray();
        Arrays.sort(chars1);
        String str1 = new String(chars1);

        char[] chars2 = string2.toLowerCase().toCharArray();
        Arrays.sort(chars2);
        String str2 = new String(chars2);

        if (str1.toString().equals(str2.toString())){
            return true;
        }
        return false;
    }

    public static List<String> setPalindromes(String[] words){
        List<String> result = new ArrayList<String>();
        for (int i=0;i<words.length;i++){
            if (isPalindrome(words[i])) result.add(words[i]);
        }
        return result;
    }

    public static boolean isPalindrome(String string){
        String tmp = new StringBuilder(string).reverse().toString();
        if (tmp.equalsIgnoreCase(string)) return true;
        return false;
    }
}
