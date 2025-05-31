package dsa.recursions;

import java.util.Arrays;

public class FrogJumper {
    /*
        To solve the frog jump problem, you must realize that the frog can jump in one of two ways:
        either it jumps 1 rock at a time or 2 rocks at a time. The goal is to count all the possible
        combinations of jumps that allow the frog to go from the start (before the first rock) to the end
        (after the last rock).

        Let's define F(n) as the number of ways to reach the end when there are n rocks between the start
        and the finish.

        Consider the following:
            - If the frog is at the starting position (before any rock), we count this as F(0) = 1.
            - For F(1): with 1 rock, the frog can only make a jump of 1 rock. Therefore, F(1) = 1.
            - For F(2): with 2 rocks, there are two possibilities:
                  1) Jump 1 rock, then another 1 rock (1, 1).
                  2) Jump directly 2 rocks (2).
                Thus, F(2) = 2.

        The key observation is that to reach position n, the frog can come from:
            - Position n-1 by jumping 1 rock,
            - Or from position n-2 by jumping 2 rocks.
        Therefore, the recurrence relation is:

            F(n) = F(n-1) + F(n-2)

        Let's visualize this with some examples:

        1. With 1 rock:

                    START → [ROCK] → END
            There is only 1 path: (1)
            F(1) = 1.

        2. With 2 rocks:

                    START → [ROCK] → [ROCK] → END
            Possible paths:
                  - (1, 1)
                  - (2)
            F(2) = 2.

        3. With 3 rocks:

                    START → [ROCK] → [ROCK] → [ROCK] → END
            Possible paths:
                  - (1, 1, 1)
                  - (1, 2)
                  - (2, 1)
            F(3) = F(2) + F(1) = 2 + 1 = 3.

        4. With 4 rocks:

                    START → [ROCK] → [ROCK] → [ROCK] → [ROCK] → END
            Possible paths:
                  - (1, 1, 1, 1)
                  - (1, 1, 2)
                  - (1, 2, 1)
                  - (2, 1, 1)
                  - (2, 2)
            F(4) = F(3) + F(2) = 3 + 2 = 5.

        In summary:
            - F(0) = 1   // Starting position (before any jump)
            - F(1) = 1
            - F(2) = 2
            - For n ≥ 3, F(n) = F(n-1) + F(n-2)

        This is the famous Fibonacci sequence. It works for this problem because for each position,
        the number of ways to reach it is the sum of the ways to reach the two previous positions (from
        which the frog can jump 1 or 2 rocks).

        Generalization:
            If the frog were allowed to jump between 1 and k rocks at a time, the recurrence would be:

                F(n) = F(n-1) + F(n-2) + ... + F(n-k)

            with the base condition F(0) = 1 (and typically F(n) = 0 for n < 0).

        Visualization:
            Imagine the frog's path as:

                [START] → R1 → R2 → ... → Rn → [END]

            The total number of ways to go from [START] to [END] is determined by the fact that for each
            position the frog can come from one of the previous k positions, depending on its jump length.

        In conclusion, the frog jump problem is solved using the Fibonacci sequence (or its generalized form)
        because the method of combining the possible jumps (either 1 or 2, or up to k) is exactly given by
        the sum of the ways to get to the previous positions. This results in a recurrence relation that fits
        the Fibonacci pattern.

        F(n) = F(N-1) + F(N-2) QUANDO n >= 1 sendo f(1) e f(2) = 1

        1 1 1
        1 2
        2 1

        1 1 1 f(3) = f(2) = f(1) -> 1 maneira de fazer isso
        1 1 1 / 1 2 / 2 1 (f3) = f(2) + f(1) -> 2 maneiras de fazer isso

    */

    public static int frogJumps(int rocks, int maxJump) {
        rocks++;
        return frogJumpsHelper(rocks, maxJump);
    }

    private static int frogJumpsHelper(int rocks, int maxJump) {
        if (rocks < 0) return 0;
        if (rocks == 0) return 1;

        int ways = 0;
        for (int i = 1; i <= maxJump; i++) {
            ways += frogJumpsHelper(rocks - i, maxJump);
        }

        return ways;
    }

    // WITH MEMO

    public static int frogJumpsMemo(int rocks, int maxJump) {
        int[] memo = new int[rocks + 1];
        Arrays.fill(memo, -1);
        return frogJumpsHelper(rocks, maxJump, memo);
    }

    private static int frogJumpsHelper(int rocks, int maxJump, int[] memo) {
        if (rocks < 0) return 0;
        if (rocks == 0) return 1; // Se não há mais pedras, encontrou um caminho válido

        if (memo[rocks] != -1) return memo[rocks]; // Usa cache para evitar recálculo

        int ways = 0;
        for (int i = 1; i <= maxJump; i++) {
            ways += frogJumpsHelper(rocks - i, maxJump, memo);
        }

        memo[rocks] = ways; // Salva o resultado para otimizar chamadas futuras
        return ways;
    }


    public static void main(String[] args) {
        System.out.println("Frog jumps => " + frogJumps(10, 6));
        System.out.println("Frog jump with memo => " + frogJumpsMemo(10, 6));
    }

    // ROCK ROCK END _ _ _
    // ROCK ROCK ROCK ROCK ROCK END
    /*
       1 1 1 1 1
       1 1 1 2
       1 1 2 1
       1 2 1 1
       2 1 1 1
       1 2 2
       2 1 2
       2 2 1
       3 1 1
       1 3 1
       3 1 1
       2 3
       3 2
       1 4
       4 1
       5

       // FACTORIALS

       1
       1
       2
       3
       5
       8
       13
       21
     */
}
