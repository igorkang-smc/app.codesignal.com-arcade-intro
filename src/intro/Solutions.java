package intro;

import java.util.HashMap;
import java.util.Map;

public class Solutions {

    public static class stringsRearrangement_33 {
        private static boolean success = false;

        private static void findSequence(String[] a, String prev, boolean[] used, int n) {
            if (n == a.length) {
                success = true;
                return;
            }
            for (int i = 0; i < a.length; i++) {
                if (!used[i] && (prev == null || differByOne(prev, a[i]))) {
                    used[i] = true;
                    findSequence(a, a[i], used, n + 1);
                    used[i] = false;
                }
            }
        }

        private static boolean differByOne(String a, String b) {
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }

        public static boolean solution(String[] inputArray) {
            boolean[] used = new boolean[inputArray.length];
            findSequence(inputArray, null, used, 0);
            return success;
        }
    }

    public static class growingPlant_38 {
        public static int solution(int upSpeed, int downSpeed, int desiredHeight) {
            return upSpeed > desiredHeight ? 1 : (int) Math.ceil((double) (desiredHeight - upSpeed) / (upSpeed - downSpeed)) + 1;
        }
    }

    public static class knapsack_light_39 {
        public static int solution(int value1, int weight1, int value2, int weight2, int maxW) {
            if (weight1 > maxW && weight2 > maxW) return 0;
            if (weight1 + weight2 <= maxW) return value1 + value2;
            if (weight1 > maxW) return value2;
            if (weight2 > maxW) return value1;
            return Math.max(value1, value2);
        }
    }

    public static class longestDigitsPrefix_40 {
        public static String solution(String inputString) {
            StringBuilder ans = new StringBuilder();

            try {
                String current_symbol = "";
                for (int i = 0; i < inputString.length(); i++) {
                    current_symbol = String.valueOf(Integer.parseInt(String.valueOf(inputString.charAt(i))));

                    ans.append(current_symbol);
                }
            } catch (NumberFormatException ignored) {

            }

            return ans.toString();
        }

        public static String best_solution(String inputString) {
            return inputString.replaceAll("^(\\d*).*", "$1");
        }
    }

    public static class digitDegree_41 {
        public static int mySolution(int n) {
            int ans = 0;
            String num = String.valueOf(n);
            while (num.length() != 1) {

                int sum = 0;
                for (int i = 0; i < num.length(); i++) {
                    sum += Integer.parseInt(String.valueOf(num.charAt(i)));
                }
                ans++;
                num = String.valueOf(sum);
            }

            return ans;
        }

        public static int solution(int n) {
            int count = 0;
            while (n >= 10) {
                int sum = 0;
                while (n > 0) {
                    sum += n % 10;
                    n /= 10;
                }
                n = sum;
                sum = 0;
                count++;
            }
            return count;
        }
    }

    public static class bishopAndPawn_42 {
        public static boolean mySolution(String bishop, String pawn) {
            return Math.abs(bishop.charAt(0) - pawn.charAt(0)) == Math.abs(bishop.charAt(1) - pawn.charAt(1));
        }
    }

    public static class isBeautifulString_43 {
        public static boolean mySolution(String inputString) {
            Map<Character, Integer> map = new HashMap<>() {{
                put('a', 0);
                put('b', 0);
                put('c', 0);
                put('d', 0);
                put('e', 0);
                put('f', 0);
                put('g', 0);
                put('h', 0);
                put('i', 0);
                put('j', 0);
                put('k', 0);
                put('l', 0);
                put('m', 0);
                put('n', 0);
                put('o', 0);
                put('p', 0);
                put('q', 0);
                put('r', 0);
                put('s', 0);
                put('t', 0);
                put('u', 0);
                put('v', 0);
                put('w', 0);
                put('x', 0);
                put('y', 0);
                put('z', 0);
            }};

            for (int i = 0; i < inputString.length(); i++) {
                map.put(inputString.charAt(i), map.get(inputString.charAt(i)) + 1);
            }
            Object[] s = map.values().toArray();
            for (int i = 0; i < s.length - 1; i++) {
                if ((Integer) s[i + 1] - (Integer) s[i] > 0) {
                    return false;
                }
            }
            ;

            return true;
        }

        public static boolean solution(String s) {
            int[] c = new int[26];

            for (int i : s.getBytes()) c[i - 'a']++;

            for (int i = 1; i < 26; i++)
                if (c[i] > c[i - 1]) return false;

            return true;
        }
    }

    public static class findEmailDomain_44 {
        public static String mySolution(String address) {
            return address.substring(address.lastIndexOf('@') + 1);
        }
    }
    public static class buildPalindrome_45 {
        public static String mySolution(String st) {
            StringBuilder initionalPart = new StringBuilder(st);
            StringBuilder additionalPart = new StringBuilder();
            for(int i = 0; i < st.length() - 1; ) {
                if(isPalindrome(initionalPart.toString())) {
                    break;
                }

                additionalPart.append(initionalPart.charAt(i));
                initionalPart.deleteCharAt(i);
            }
            return st + additionalPart.reverse();
        }
        private static boolean isPalindrome(String st) {
            return new StringBuilder(st).reverse().toString().equals(st);
        }
    }

}
