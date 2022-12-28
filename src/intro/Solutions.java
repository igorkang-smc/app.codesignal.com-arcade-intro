package intro;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            for (int i = 0; i < st.length() - 1; ) {
                if (isPalindrome(initionalPart.toString())) {
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

    public static class electionsWinners_46 {
        public static int mySolution(int[] votes, int k) {
            int ans = 1;
            Arrays.sort(votes);
            if (k == 0 && votes.length > 1 && votes[votes.length - 1] == votes[votes.length - 2]) {
                return 0;
            }

            for (int i = 0; i < votes.length - 1; i++) {
                if (votes[i] + k > votes[votes.length - 1]) {
                    ans++;
                }
            }

            return ans;
        }

        public static int bestSolution(int[] votes, int k) {
            int max = Arrays.stream(votes).max().getAsInt();
            return k == 0 ? Arrays.stream(votes).filter(x -> x == max).count() == 1 ? 1 : 0 : (int) Arrays.stream(votes).filter(x -> x + k > max).count();
        }
    }

    public static class is_Mac48Address_47 {
        public static boolean solution(String inputString) {
            Character[] symbolAlphabet = new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                    'A', 'B', 'C', 'D', 'E', 'F'};
            List<Character> symbolList = Arrays.asList(symbolAlphabet);

            String[] pairs = inputString.split("-", -1);
            if (pairs.length != 6) {
                return false;
            }

            for (int i = 0; i < 6; i++) {
                if (pairs[i].length() != 2 || !symbolList.contains(pairs[i].charAt(0)) || !symbolList.contains(pairs[i].charAt(1))) {
                    return false;
                }
            }

            return true;
        }

        public static boolean goodSolution(String inputString) {
            return inputString.matches("^([0-9A-F][0-9A-F]-){5}[0-9A-F][0-9A-F]$");
        }

    }

    public static class isDigit_48 {
        public static boolean mySolution(char symbol) {
            try {
                Integer.parseInt(Character.toString(symbol));
                return true;
            } catch (NumberFormatException exception) {
                return false;
            }
        }

        public static boolean solution(char symbol) {
            return Character.isDigit(symbol);
        }
    }

    public static class lineEncoding_49 {
        public static String mySolution(String s) {
            Character currentCh = '-';
            StringBuilder ansSb = new StringBuilder();
            int counter = 1;
            char[] charr = s.toCharArray();
            for (int i = 0; i < charr.length; i++) {

                if (charr[i] != currentCh) {
                    if (currentCh != '-') {
                        if (counter > 1) {
                            ansSb.append(counter);
                            ansSb.append(currentCh);
                        } else {
                            ansSb.append(currentCh);
                        }
                        counter = 1;
                    }
                    currentCh = charr[i];
                    if (i == charr.length - 1) {
                        ansSb.append(charr[i]);
                    }
                } else {
                    counter++;
                    if (i == charr.length - 1) {
                        if (counter > 1) {
                            ansSb.append(counter);
                            ansSb.append(currentCh);
                        } else {
                            ansSb.append(currentCh);
                        }
                    }
                }
            }

            return ansSb.toString();
        }

        public static String solution(String s) {
            Matcher m = Pattern.compile("([a-z])\\1*").matcher(s);
            String result = "";
            while (m.find()) {
                int len = m.group(0).length();
                char cha = m.group(0).charAt(0);
                result += (len == 1 ? "" : len) + "" + cha;
            }
            return result;
        }
    }

    public static class chessKnight_50 {
        public static int solution(String cell) {
            //https://imgur.com/a/PXkaY
            var results = new int[]{2, 3, 4, 6, 8};
            int dist1 = Math.min(Math.min(cell.charAt(0) - 'a', 'h' - cell.charAt(0)), 2);
            int dist2 = Math.min(Math.min(cell.charAt(1) - '1', '8' - cell.charAt(1)), 2);

            return results[dist1 + dist2];
        }
    }

    public static class deleteDigit_51 {
        public static int solution(int n) {
            int max = 0;
            for (int t = 1; t < n; t *= 10)
                max = Math.max(n / 10 / t * t + n % t, max);
            return max;
        }
    }

    public static class longestWord_52 {
        public static String solution(String text) {
            var s = text.split("[^a-zA-Z]");
            String t = "";
            for (int i = 0; i < s.length; i++) {
                if (s[i].length() > t.length())
                    t = s[i];
            }
            return t;
        }

        public static String goodSolution(String text) {
            return Arrays.stream(text.split("\\W+")).max((a, b) -> a.length() - b.length()).get();
        }
    }

    public static class validTime_53 {
        public static boolean solution(String time) {
            return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
        }
    }

    public static class sumUpNumbers_54 {
        public static int solution(String inputString) {
            var nums = inputString.split("[^0-9]");

            int ans = 0;
            for (String str : nums) {
                try {
                    ans += Integer.parseInt(str);
                } catch (Exception ignored) {

                }
            }
            return ans;
        }

        public static int goodSolution(String inputString) {
            return Arrays.stream(inputString.split("\\D+")).
                    filter(s -> !s.isEmpty()).
                    mapToInt(Integer::parseInt).sum();
        }
    }

    public static class differentSquares_55 {
        public static int mySolution(int[][] matrix) {
            Set<String> strSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matrix.length - 1; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    sb.setLength(0);
                    sb.append(matrix[i][j]);
                    sb.append(matrix[i][j + 1]);
                    sb.append(matrix[i + 1][j]);
                    sb.append(matrix[i + 1][j + 1]);
                    strSet.add(sb.toString());
                }
            }

            return strSet.size();
        }
    }

    public static class digitsProduct_56 {
        public static int solution(int product) {
            if (product == 0)
                return 10;
            if (product < 10)
                return product;

            StringBuilder r = new StringBuilder();
            for (int d = 9; d > 1; d--)
                for (; product % d == 0; product /= d)
                    r.insert(0, d);
            return product == 1 ? Integer.parseInt(r.toString()) : -1;
        }
    }

    public static class fileNaming_57 {
        public static String[] solution(String[] names) {
            List<String> input = Arrays.asList(names);
            List<String> result = new ArrayList<>();
            for (String s : names) {
                if (result.contains(s)) {
                    int i = 1;
                    for (; result.contains(s + "(" + i + ")"); i++) {

                    }
                    s += "(" + i + ")";
                }
                result.add(s);
            }
            return result.toArray(new String[0]);
        }
    }

    public static class messageFromBinaryCode_58 {
        public static String solution(String code) {
            return new String(new BigInteger(code, 2).toByteArray());
        }
    }

    public static class spiralNumbers_59 {
        public static int[][] solution(int n) {
            int[][] array = new int[n][n];

            int left = 0;
            int right = n - 1;
            int top = 0;
            int down = n - 1;

            for (int counter = 1; counter <= n * n; ) {
                for (int x = left; x <= right; x++)
                    array[top][x] = counter++;
                top++;

                for (int y = top; y <= down; y++)
                    array[y][right] = counter++;
                right--;

                for (int x = right; x >= left; x--)
                    array[down][x] = counter++;
                down--;

                for (int y = down; y >= top; y--)
                    array[y][left] = counter++;
                left++;
            }

            return array;
        }
    }

    public static class sudoku_60 {
        public static boolean solution(int[][] grid) {
            int[] rowsSumary = new int[9];
            int[] colsSumary = new int[9];
            int[] sectSumary = new int[9];
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    rowsSumary[row] += grid[row][col];
                    colsSumary[col] += grid[row][col];
                    sectSumary[(col / 3) + ((row / 3) * 3)] += grid[row][col];
                }
            }
            return Arrays.stream(grid[0]).distinct().count() == 9 &&
                    Arrays.stream(rowsSumary).allMatch(x -> x == 45) &&
                    Arrays.stream(colsSumary).allMatch(x -> x == 45) &&
                    Arrays.stream(sectSumary).allMatch(x -> x == 45);
        }
    }
}

