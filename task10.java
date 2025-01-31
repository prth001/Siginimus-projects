public class task10{
    public static void main(String[] args) {
        String input = "Hello World";
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (!isVowel(c)) {
                result.append(c);
            }
        }
        System.out.println(result.toString());
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}

