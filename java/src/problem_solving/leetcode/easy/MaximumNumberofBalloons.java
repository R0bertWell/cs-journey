package problem_solving.leetcode.easy;


public class MaximumNumberofBalloons {
    public int maxNumberOfBalloonsFirstSolve(String text) {
        int[] letters = new int[26];

        int totalBallons = 0;

        for(int i = 0; i < text.length(); i++){
            int index = text.charAt(i) - 'a';
            letters[index]++;

            if( letters['b' - 'a'] >= 1 &&
                    letters['a' - 'a'] >= 1 &&
                    letters['l' - 'a'] >= 2 &&
                    letters['o' - 'a'] >= 2 &&
                    letters['n' - 'a'] >= 1) {
                totalBallons += 1;
                letters['b' - 'a']--;
                letters['a' - 'a']--;
                letters['l' - 'a']-=2;
                letters['o' - 'a']-=2;
                letters['n' - 'a']--;
            }
        }

        return totalBallons;
    }

    public static int maxNumberOfBalloons(String text) {
        int[] letters = new int[26];

        for(int i = 0; i < text.length(); i++){
            int index = text.charAt(i) - 'a';
            letters[index]++;
        }

        return Math.min(
                Math.min(letters['b' - 'a'], letters['a' - 'a']),
                Math.min(
                        Math.min(letters['l' - 'a'] / 2, letters['o' - 'a'] / 2),
                        letters['n' - 'a']
                )
        );
    }

    public static void main(String[] args) {
        maxNumberOfBalloons("nllbblooon");
        maxNumberOfBalloons("nlaebolko");
        maxNumberOfBalloons("loonbalxballpoon");
        maxNumberOfBalloons("leetcode");
    }
}
