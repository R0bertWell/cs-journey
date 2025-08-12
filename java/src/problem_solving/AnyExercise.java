package problem_solving;

import java.util.*;

public class AnyExercise {

    public static int longestSubsWithoutRepChars(String sentence){
        if (sentence.isEmpty()) return 0;

        HashMap<Character, Integer> vogalMap = new HashMap<>();
        int startIndex = 0;
        int longestSubs = 0;

        for(int i = 0; i < sentence.length(); i++){
            char c = sentence.charAt(i);
            if(vogalMap.containsKey(c) && vogalMap.get(c) >= startIndex){
                startIndex = vogalMap.get(c) + 1;
            }

            longestSubs = Math.max(longestSubs, i - startIndex + 1);
            vogalMap.put(c, i);
        }

        return longestSubs;
    }

    public static double medianOfTwoSortedArrays(int[] arr1, int[] arr2){
        double median;
        int finalLength = arr1.length + arr2.length;
        int[] finalArr = new int[finalLength];

        int firstArr = 0, secondArr = 0, finalIndex = 0;

        while(firstArr < arr1.length && secondArr < arr2.length){
            if(arr1[firstArr] > arr2[secondArr]){
                finalArr[finalIndex++] = arr2[secondArr++];
            } else {
                finalArr[finalIndex++] = arr1[firstArr++];
            }
        }

        while(firstArr < arr1.length){
            finalArr[finalIndex++] = arr1[firstArr++];
        }

        while(secondArr < arr2.length){
            finalArr[finalIndex++] = arr2[secondArr++];
        }

        median = (finalLength % 2) != 0 ?
                finalArr[(finalLength / 2)]
                :
                (double) (finalArr[finalLength / 2] + finalArr[(finalLength / 2) - 1]) / 2;

        return median;
    }

    public static double medianOfTwoSortedArraysEnhanced(int[] arr1, int[] arr2){
        int totalLength = arr1.length + arr2.length;
        int mid = totalLength / 2;

        int i = 0, j = 0, count = 0;
        int prev = 0, curr = 0;

        while(count <= mid){
            prev = curr;

            if (i < arr1.length && (j >= arr2.length || arr1[i] <= arr2[j])) {
                curr = arr1[i++];
            } else {
                curr = arr2[j++];
            }

            count++;
        }

        return totalLength % 2 == 0 ? (prev + curr) / 2d : curr;
    }

    public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> first, LinkedList<Integer> second){
        LinkedList<Integer> resultList = new LinkedList<>();

        int resto = 0;
        while(!first.isEmpty() || !second.isEmpty() || resto != 0){
            int sum = resto;

            if(!first.isEmpty())  sum += first.pop();

            if(!second.isEmpty()) sum += second.pop();

            resto = sum / 10;
            resultList.add(sum % 10);
        }

        return resultList;
    }

    public static String zigZagConversion(String sentence, int numRows){
        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        int direction = 1;
        for(char c : sentence.toCharArray()){
            rows[currentRow].append(c);
            currentRow += direction;

            if(currentRow == (numRows - 1) || currentRow == 0){
                direction *= -1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static int reverseInteger(int num){
        int signal = 1;
        if(num < 0) signal = -1;

        int length = String.valueOf(num).length();
        if(signal == -1) length -= 1;

        double multi = Math.pow(10, length - 1);
        long finalInt = 0;
        while (num != 0) {
            finalInt += (num % 10) * multi;

            if(finalInt > Integer.MAX_VALUE || finalInt < Integer.MIN_VALUE) return 0;

            num /= 10;
            multi /= 10;
        }

        return (int) finalInt;
    }

    public static int reverse(int x){
        long reversed = 0;
        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int) reversed;
    }

    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 1) return strs[0];

        String fixed = strs[0];

        for(int i = 1; i < strs.length; i++){
            String curr = strs[i];
            while(curr.indexOf(fixed) != 0){
                fixed = fixed.substring(0, fixed.length() - 1);
                if(fixed.isEmpty()) return "";
            }
        }

        return fixed;
    }

    public static String longestCommonPrefixMy(String[] strs){
        if(strs.length == 1) return strs[0];

        String lowest = strs[0];

        int i = 0, j = 0;
        while(i < lowest.length()){
            if(i < strs[j].length() && lowest.charAt(i) != strs[j].charAt(i)) {
                break;
            }

            if(lowest.length() > strs[j].length()){
                lowest = strs[j];
            }

             j++;
            if(j >= strs.length) {
                i++; j = 0;
            }
        }

        if(lowest.isEmpty()) return "";

        return lowest.substring(0, i);
    }

    public static String longestCommonPrefixMy2(String[] strs){
        if(strs.length == 1) return strs[0];

        int minLength = Integer.MAX_VALUE;

        for(String str : strs){
            if(str.length() < minLength){
                minLength = str.length();
            }
        }

        int i = 0;
        while(i < minLength){
            for(String str : strs){
                if(str.charAt(i) != strs[0].charAt(i)){
                    return str.substring(0, i);
                }
            }
            i++;
        }

        return strs[0].substring(0, i);
    }

    public static List<String> digitCombinations(String digits){
        if(digits.length() == 0) return Collections.emptyList();

        Map<Character, List<String>> digitMap = new HashMap<>();
        digitMap.put('2', List.of("a", "b", "c"));
        digitMap.put('3', List.of("d", "e", "f"));
        digitMap.put('4', List.of("g", "h", "i"));
        digitMap.put('5', List.of("j", "k", "l"));
        digitMap.put('6', List.of("m", "n", "o"));
        digitMap.put('7', List.of("p", "q", "r", "s"));
        digitMap.put('8', List.of("t", "u", "v"));
        digitMap.put('9', List.of("w", "x", "y", "z"));

        if(digits.length() == 1) return digitMap.get(digits.charAt(0));

        List<String> result = List.of(""); // Inicialmente 1 string vazia para acumular

        for (char digit : digits.toCharArray()) {
            List<String> letters = digitMap.get(digit);
            if (letters == null || letters.isEmpty()) continue;

            List<String> temp = new ArrayList<>();
            for (String prefix : result) {
                for (String letter : letters) {
                    temp.add(prefix + letter);
                }
            }
            result = temp; // Atualiza a lista principal
        }

        /*List<String> combinations = new ArrayList<>();
        List<List<String>> characters = new ArrayList<>();

        int highestComb = Integer.MAX_VALUE;
        int numOffCombinations = 1;
        for(char c : digits.toCharArray()){
            List<String> chars = digitMap.get(c);
            characters.add(chars);

            numOffCombinations *= chars.size();
            highestComb = Math.min(highestComb, chars.size());
        }

        while(numOffCombinations > 0){

        }

        for(int j = 0; j < characters.size(); j++) {
            int currIndex = 0;
            for (String c : characters.get(j)) {
                if (j != 0) {
                    for (int i = currIndex; i < combinations.size(); i += highestComb) {
                        String curr = combinations.get(i);
                        combinations.set(i, curr.concat(c));
                    }
                    currIndex++;
                } else {
                    for (int i = currIndex; i < currIndex + highestComb; i++) {
                        combinations.add(c);
                    }
                    currIndex += 3;
                }
            }
        }*/

        return result;
    }

    public static int[] twoSumOrdered(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            } else if(sum > target){
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        Set<List<Integer>> intSet = new HashSet<>();
        int len = nums.length;

        for(int i = 0; i < len - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] == 0) break;

            int j = i + 1;
            int z = len - 1;
            while(j < z){
                int sum = nums[i] + nums[j] + nums[z];
                if(sum == 0){
                    intSet.add(List.of(nums[i], nums[j], nums[z]));
                    while(j < z && nums[j] == nums[j + 1])j++;
                    while(j < z && nums[z] == nums[z - 1])z--;

                    j++;z--;
                } else if(sum > 0){
                    z--;
                } else {
                    j++;
                }
            }
        }

        return intSet.stream().toList();
    }

    public static int trappingRainWater(int[] height){
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWatter = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    trappedWatter += leftMax - height[left];
                }

                left++;
            } else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    trappedWatter += rightMax - height[right];
                }

                right--;
            }
        }

        return trappedWatter;
    }

    public static int trappedRainWater(int[] height){
        int trapped = 0;

        int left = 0, right = height.length - 1;
        int leftWall = 0, rightWall = 0;
        // 0 1 2

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > leftWall){
                    leftWall = height[left];
                } else {
                    trapped += leftWall - height[left];
                }
                left++;
            } else {
                if(height[right] > rightWall){
                    rightWall = height[right];
                } else {
                    trapped += rightWall - height[right];
                }
                right--;
            }
        }

        // 1 < 2
        // leftWall < left ( 0 < 1 ) leftWall = 1 0 1

        return trapped;
    }

    public static boolean validParenthesis(String s){
        Stack<Character> characters = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            switch (c) {
                case '(', '[', '{' -> characters.add(c);
                default -> {
                    if(characters.isEmpty()) return false;
                    char curr = characters.pop();
                    if ((c == ')' && curr != '(') ||
                            (c == '}' && curr != '{') ||
                            (c == ']' && curr != '[')
                    ) {
                        return false;
                    }
                }
            }
        }

        return characters.isEmpty();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> pMap = new HashMap<>();
        pMap.put('(', ')');
        pMap.put('{', '}');
        pMap.put('[', ']');

        for (char c : s.toCharArray()) {
            if(pMap.containsKey(c)){
                stack.push(c);
                continue;
            }

            if(!(c == pMap.get(stack.pop()))){
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> oper = new Stack<>();

        for(String token : tokens){
            switch (token) {
                case "+", "-", "*", "/" -> {
                    int second = oper.pop();
                    int first = oper.pop();
                    if (token.equals("+")) {
                        oper.push(first + second);
                        break;
                    }
                    if (token.equals("-")) {
                        oper.push(first - second);
                        break;
                    }
                    if (token.equals("*")) {
                        oper.push(first * second);
                        break;
                    }
                    oper.push(first / second);
                }
                default -> oper.push(Integer.valueOf(token));
            }
        }

        return oper.pop();
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] prev = stack.pop();
                answer[prev[1]] = i - prev[1];
            }
            stack.push(new int[]{temp, i});
        }
        return answer;
    }

    public static int countMoreFrequency(int[] nums){

        int curr = -1;
        int count = 0;
        for(int num : nums){
            if(count == 0) curr = num;

            if(curr == num){
                count++;
            } else {
                count--;
            }
        }

        return curr;
    }

    public static int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length;

        while(left <= right){
            int middle = (right + left) / 2;

            if(nums[middle] == target){
                return middle;
            } else if(target < nums[middle]){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle = 0;
        while(left <= right){
            middle = (right + left)/2;

            if(nums[middle] == target) return middle;

            if(target < nums[middle]){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if(target < nums[middle]){
            return middle;
        } else {
            return middle + 1;
        }
    }

    private static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public static int firstBadVersion(int n) {
        long left = 0, right = n;
        int lastBadVersion = 0;
        while(left <= right){
            int middle = (int) ((right + left) / 2);

            if(isBadVersion(middle)){
                lastBadVersion = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        return lastBadVersion;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int i = mid / n;
            int j = mid % n;
            int midNum = matrix[i][j];

            if (target == midNum) {
                return true;
            } else if (target < midNum) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;

        if(len == 0) return -1;
        if(len == 1) return target == nums[0] ? 0 : -1;

        int left = 0, right = len - 1;
        int rotated = rotatedIndex(nums);

        if(target >= nums[rotated] && target <= nums[right]){
            left = rotated;
        } else {
            right = rotated;
        }

        while(left <= right){
            int middle = (left + right) / 2;

            if(target == nums[middle]){
                return middle;
            }

            if(target > nums[middle]){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int rotatedIndex(int[] nums) {
        int len = nums.length - 1;
        if(len >= 1 && nums[0] < nums[len]) return 0;

        int left = 0, right = len;
        int middle = 0;
        while(left <= right){
            middle = (left + right) / 2;

            if(nums[middle] > nums[middle + 1]){
                return middle + 1;
            }

            if(nums[left] > nums[middle]){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return middle + 1;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().orElse(1); // maximum pile

        while (left < right) {
            int mid = (left + right) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canFinish(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // Equivalent to ceil(pile / k)
        }
        return hours <= h;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int windowSum  = 0;

        for(int i = 0; i < k; i++){
            windowSum  += nums[i];
        }

        int maxSum  = windowSum;

        for(int i = k; i < nums.length; i++){
            maxSum  -= nums[i - k];
            maxSum  += nums[i];

            windowSum = Math.max(windowSum, maxSum);
        }

        return (double) maxSum / k;
    }
    public static int longestOnes(int[] nums, int k) {
        Queue<Integer> indexZero = new LinkedList<>();
        int longestOnes = 0;
        int curLongestOnes = 0;
        int usedOnes = k;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                curLongestOnes += 1;
            } else if(usedOnes > 0){
                usedOnes -= 1;
                curLongestOnes += 1;
                indexZero.add(i);
            } else {
                indexZero.add(i);
                curLongestOnes = i - indexZero.remove();
            }

            longestOnes = Math.max(longestOnes, curLongestOnes);
        }
        return longestOnes;
    }

    public static int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int l = 0, longest = 0;
        int maxCount = 0;

        for (int r = 0; r < s.length(); r++) {
            maxCount = Math.max(maxCount, ++counts[s.charAt(r) - 'A']);

            while ((r - l + 1) - maxCount > k) {
                counts[s.charAt(l) - 'A']--;
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }

    public static int characterReplacementDebug(String s, int k) {
        int[] counts = new int[26];
        int l = 0, longest = 0, maxCount = 0;

        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);
            counts[currentChar - 'A']++;
            maxCount = Math.max(maxCount, counts[currentChar - 'A']);

            System.out.printf("r=%d (%c), counts[%c]=%d, maxCount=%d%n", r, currentChar, currentChar, counts[currentChar - 'A'], maxCount);

            while ((r - l + 1) - maxCount > k) {
                char leftChar = s.charAt(l);
                counts[leftChar - 'A']--;
                System.out.printf("  Shrinking window: l=%d (%c), counts[%c]=%d%n", l, leftChar, leftChar, counts[leftChar - 'A']);
                l++;
            }

            int currentWindowLength = r - l + 1;
            longest = Math.max(longest, currentWindowLength);

            // Debug visual da janela atual
            System.out.printf("Current window: [%d, %d] = \"%s\" | currentWindowLength=%d | longest=%d%n",
                    l, r, s.substring(l, r + 1), currentWindowLength, longest);
            System.out.println("----------------------------------------------------------");
        }

        System.out.println("Final longest length: " + longest);
        return longest;
    }

    public static boolean permutationString(String s1, String s2){
        if(s2.length() < s1.length()) return false;

        int[] counts = new int[26];

        for(char c : s1.toCharArray()){
            counts[c - 'a']++;
        }

        int[] compare = new int[26];

        int l = 0;
        for(int i = 0; i < s2.length(); i++){
            int index = s2.charAt(i) - 'a';
            int count = counts[index];

            if(count > 0 && compare[index] < count){
                compare[index]++;
            } else {
                if(s2.charAt(l) != s2.charAt(i)){
                    while(l != i){
                        if(s2.charAt(l) == s2.charAt(i)) break;
                        compare[s2.charAt(l) - 'a']--;
                        l++;
                    }
                }
                l++;
            }

            if(Arrays.equals(compare, counts)) return true;
        }

        return false;
    }

    public static int maxDepth(problem_solving.TreeNode root) {
        int level = 0;
        if(root == null) return level;

        return helper(root, level);
    }

    public static int helper(problem_solving.TreeNode node, int level){
        if(node == null) return level;
        level++;
        if(node.right != null) {
            level = Math.max(level, helper(node.right, level));
        }

        if(node.left != null) {
            level = Math.max(level, helper(node.left, level));
        }

        return level;
    }

    public static boolean isBalanced(problem_solving.TreeNode node){
        return height(node) != -1;
    }

    public static int height(problem_solving.TreeNode node){
        if(node == null) return 0;

        int leftHeight = height(node.left);
        if(leftHeight == -1) return -1;

        int rightHeight = height(node.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean hasPathSum(problem_solving.TreeNode root, int targetSum) {
        if(root == null) return false;

        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0) return true;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    /*
    public static boolean isSubtree(problem_solving.TreeNode root, problem_solving.TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if (root.val == subRoot.val) {
            return isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right);
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }*/


    public static boolean isSubtree(TreeNode root, TreeNode subTree){
        if(root == null) return false;

        if(isSameTree(root, subTree)) return true;

        return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);
    }

    public static boolean isSameTree(TreeNode root, TreeNode subTree){
        if(root == null && subTree == null) return true;
        if(root == null || subTree == null) return false;
        if(root.val != subTree.val) return false;

        return isSameTree(root.left, subTree.left) && isSameTree(root.right, subTree.right);
    }

    public static void main(String[] args) {
        // root
        problem_solving.TreeNode rootT = new problem_solving.TreeNode(3);
        rootT.left = new problem_solving.TreeNode(4);
        rootT.right = new problem_solving.TreeNode(5);
        rootT.left.left = new problem_solving.TreeNode(1);
        rootT.left.right = new problem_solving.TreeNode(2);

// subRoot
        problem_solving.TreeNode subRootT = new problem_solving.TreeNode(4);
        subRootT.left = new problem_solving.TreeNode(1);
        subRootT.right = new problem_solving.TreeNode(2);
        System.out.println(isSubtree(rootT, subRootT));

        problem_solving.TreeNode rootT2 = new problem_solving.TreeNode(2);
        rootT2.left = new problem_solving.TreeNode(2);
        rootT2.left.left = new problem_solving.TreeNode(2);
        rootT2.left.left.left = new problem_solving.TreeNode(1);

        problem_solving.TreeNode subRootT2 = new problem_solving.TreeNode(1);
        System.out.println(isSubtree(rootT2, subRootT2));


        problem_solving.TreeNode root = new problem_solving.TreeNode(5);
        root.left = new problem_solving.TreeNode(4);
        root.right = new problem_solving.TreeNode(8);

        root.left.left = new problem_solving.TreeNode(11);
        root.left.left.left = new problem_solving.TreeNode(7);
        root.left.left.right = new problem_solving.TreeNode(2);
        root.left.left.right.right = new problem_solving.TreeNode(0);

        root.right.left = new problem_solving.TreeNode(13);
        root.right.right = new problem_solving.TreeNode(4);
        root.right.right.right = new problem_solving.TreeNode(1);

        hasPathSum(root, 22);

        problem_solving.TreeNode treeNodeNotBalanced = new problem_solving.TreeNode(1);
        treeNodeNotBalanced.left = new problem_solving.TreeNode(2);
        treeNodeNotBalanced.right = new problem_solving.TreeNode(2);
        treeNodeNotBalanced.left.left  = new problem_solving.TreeNode(3);
        treeNodeNotBalanced.left.right  = new problem_solving.TreeNode(3);
        treeNodeNotBalanced.left.left.left  = new problem_solving.TreeNode(4);
        treeNodeNotBalanced.left.left.right  = new problem_solving.TreeNode(4);

        isBalanced(treeNodeNotBalanced);

        problem_solving.TreeNode treeNode = new problem_solving.TreeNode(3);
        treeNode.left = new problem_solving.TreeNode(9);
        treeNode.right = new problem_solving.TreeNode(20);
        maxDepth(treeNode);

        permutationString("adc", "dcda");
        permutationString("kuzntqeuvaszrspkgjvxrupwxwrexztptsowceibeewxbslvosbobmyymikdscshybtmanuxeqtanrjekbwirmhgvfmzipfiqxcilarfyasoayepgfzmdytlpjymeaztsyubkbmblepwozffxiitdhwaquozlfmnascomqczrbhxcnzugppddtudxrigfeaozzojpeamnobapgwksudbiwdedvprwonmzardsodhxmkgghqzfhorjaijdvwzsnfpdfklwibbsnwqsoajcpjisbgizgttlnmclawbgnhbmtcpuusuammvgxnopdngclxumgfgwjrinamevhirpmlkwtyxkrmoffrreotdosjghsrkgxyiyrytbbofgczndgmdalyvvoljczcztxitxelywqemjigtuanubpstndwzvtiejtoqvetaehvcuujyupncumjnkesmoadzyvkwvjqgqewvvvpheyyvkewefbjjqzajxnhouodanyruqpzdcjmgnxkmhsgqjhpcyviewmrkfioudzqivmmguxjxuxdmpsmkwnvbxcomifgxqmcovlkooptjpfxjllwtlkkoaayzduodgsusaogswmoqkznynwiukkrrxzkwcknwlazxnlmghybxmyvquzbdqlpfydhnnuvlmyjmixyzso",
                "zthosfejqodcstlqczkndmgwtcakxzxaklkrehkfwnokclametzpnblcwaspdblfoopsiqrpzlbmlysddlqxcjzezcpknwzljvhmqxqinmptcppipifchxexlytleambzwmqwgvxlehnecdqsqbrxqfwvcovgdvtmwbnvajvkizixbmuiuyuixjhiohimghdbohetogrhzsbzgpekosxcjglsrvzenovpjyzknuumpsdrufcjsyfbuwfmaaztxjbpjctnuwcqknnemptjbgfthyafeatskfmysaioqikcpywmefujnvthumyhareltknxyvqprexgbwyzodfkinltwobeukrmpyjkrgvwhbtnzaozgxouxndmkyvzlujhxxwebptykctbojgnvcwhhgsyohccrqxksdyygcwdsazlznhqjdddisjmfqvjqcquuvjrzkcvzpxpfakbkrqlzacanqbggavezedqmoffxmkrlcwxdeosvhvvknqimwpasrlldewvhppzixgcxisysgeppcwfknecupyrrqnkhvessintrequaqiuoesgyndovaqxnlldmdupjcjzejannfjfasguyvgsdakwxezrginhdstbrtqmznpkasytqtbfyftwhgnuazcwehsvcdukuifmkefzabxyhihgnldpsvglubalbsvqstfxehvnpxmrejnkqacafuvzghbttgqmjhqzejasoasbpjirfawcvwahykvrfpaadcgvxssebdznzyvamyilahahgdslwvpuvzsinbbqecdqyvwnucjzyxmxwqwyxbxoljnjcqqdumghmcvqpcpjlxemupospxvkicqvyiavatbojgzurfzitgpeqjmvsgzzqphciyweyavebslgegjcyqmgehchryyclswjequeijzpsvuercqzhwgtgyxhxavhqkrwqdvkqvklicxpasnsnbgybtufdgbwrpaewzwczabckvddtewunsktcznqkivsubdjrpzxtsohiilcybrwqtlfqmjzmvpbfjmbjvbpwietkyzwzizwuiohjuhoekejhmkrooeyydmavdencmxhsxdnyitzivlymzyqogdhzrwhbdupborzqihurziajjwbrfwkzgbpmfgtobkbzyijcgkszyuyouyxvztmmtaqetcaxqrkbrmkzyokglckifgdfidjqoiqrfrpftagxxoqodbyygdioxdznycssxjvpotsrptttrbjayhugecptuibezsyggqcyvzosvmlpwmnuhovvhfyazkdrfxlxjxpbkkbuexxnklhnkteyjshhlojnbxtyltdfzhulcsptinpsskaeowofruejqpinhivlpvvosppxtbbrebvfihmamdlvsjirwfzhzmaqzuryakjlzroxrlwccdannvzwenabvosplnwhotxyzxhocdnvsekmnepzzqjhqrokocqewpihhyftshsfehijlvpajrcrgeqqjigmzkrhcgafqkdkrkkyausijdfzqewawxurtzhioqqnoxhbrdrriveapdebbwbrnmpcakomfhpfrqvzmpqkqucoepjklaqtirgkcrgpdhvyxybnulrchqgbupjdxxalbwljfpdjfnlqfquhdxvvuaecgzgfhulhkkvpuexpssodxqxhrbpzzgdiohxzjxnuhtavlittooxkuededfxdaabuzdlwjhitwykqdvtrwuohpvpgpeudhpslpvxmotibojtgvohqaaowiofdtgbkiiurhcfavlgsnqxndcxyxozklduxqeovzrtwuhoikgpyqoqwllagzufkuzntqeuvaszrspkgjvxrupwxwrexztptsowceibeewxbslvosbobmyymikdscshybtmanuxeqtanrjekbwirmhgvfmzipfiqxcilarfyfsoayepgfzmdytlpjymeaztsyubkbmblepwozffxiitdhwaquozlfmnascomqczrbhxcnzugppddtudxrigfeaozzojpeamnobapgwksudbmwdedvprwonmzardsodhxmkgghqzfhorjaijdvwzsnfpdfklwibbsnwqsoajcpjisbgizgttlnmclawbgnhbmtcpuusuamivgxnopdngclxumgfgwjrinamevhirpmlkwtyxkrmoafrreotdosjghsrkgxyiyrytbbofgczndgmdalyvvoljczcztxitxelywqemjigtuanubpstndwzvtiejtoqvetaehvcuujyupncumjnkesmoadzyvkwvjqgqewvvvpheyyvkewefbjjqzajxnhouodanyruqpzdcjmgnxkmhsgqjhpcyviewmrkfioudzqivmmguxjxuxdmpsmkwnvbxcomifgxqmcovlkooptjpfxjllwtlkkoaayzduodgsusaogswmoqkznynyiukkrrxzkwcknwlazxnlmghybxmyvquzbdqlpfydhnnuvlmyjmixwzsoufvjlrqtzxvybzhurdqdtnkciiradptqxzgrkqgfbnsmptyyggwpenatlrtpvmdpveivmenzwjlwdhlhmmpvbglhxcinvhhcphgklicwwnwqbkbndiuqowwgzdczwvlazndbboublzrltxahxenivmkbwofrnkkvjixfbbctshvqzmgwqrmheupodlrnebsidrbxxjfeoqgcoscymzskvbamtxtpumbdmedjghxazwamkqdrxsqytqxkrrqcnwrtkuaocuwmyucctdnaqfjlosovveoxjyypqrbkflxrrxlnjxhkrrvjettqfzzbwbzowsufxmppazhwiwcvimmlixdzgpmfayrblbkulfopwarxlsbfkuqvhyufwdswfpxqwhuvepyslbliapotofrxhufoopqhqjcjdtleeoedsacpeqfewxehghwvfvqmlzvzudkqxinsfekpbaggbpohbtbhcvdzvuormpzadkhhqqyspfkijjcelofwgkgimjxrkwqwhpqfihyhmwdkwhathcxvxtuopufsjaagbamghtsjewrpooxrprtvqpslsbaijrzojgwhekijtfugwbvgdltgpentcyjbwqjcdqkhicbsdvgtvsecpsacesztkjdskoumcheqzmoijoimnmnhfavttfamkkvugpmnibdzhcieyhhctifhbvqrllslpvymjamfmgladmpeqdrtumbqwcwwkduavjokhjrdbdozxaqemvurjwdukuwrbzfstuesjqfgblvvaqemylqgrtfzdrfgtcbvaokygyidfsbppasppzcunjwbrhqscumnrugeyxqvceninwsvmqcekvuetloevkrntgsrivpebgoobcggmgwkrzagkdavpejdgkpokcdpvncsmduzhowhdjklqwyphevtaugcabxovxgjovvgzksukpnadsblbpnuuihxdkovwsmniptwhrjxhyitozdwgkdkasspklxbyfmmugmawjflmrdiqmolsufpyzkrrqrvgnbtcogomdjrymxgnocnmpsdmbncterfrrxqyrsdqjzrodttnjbblleexyvfzxemlxfmxbzffflpyifrqhbdnwpuuwfhskfevjshsxvhvbldqyxenpxkvamashnbmrfiladqnuzwltrkoegwxrjveajpyvchyotakniwcyigejnaspdfjssacnfhbyobgrovavxoclvkgvgivoiycquftjuqynabeqakugedwlogqfbbivbzisljreuowaxfaugjunbyrcxvlqjvvuewgprwfiofxyzdaomzjfystxrbpmgdwyznnuzibozcjtsxxastlhmjpogvuhdtfhnmrhdxihhrtxqocmsmysxuudsdquadshqncpbejkjarbhkwkstpcqgwuarnmvtfjvdzeeklwnnjdewmwdyzdfnryaqoiysysfvlxetggjhywxwvkvvuccklxptokzvrrhodicekjrffbdjxoftxbstcbxjcksqcvcwkisywdzepzgznaorlllmahrqepouqnrtbhgxnsnyhkacxhjzgvxhlukbvspfzqgguqkngncotvgvuygijtkucvqcsjjolodnbfeznuikkaghyyqtxmtdjchrgybirzkbysbgnwwqaxjsnneazxnmdyzooizcyqtxlmqvujoqhjqlnuvojlkcdybfryidsunirmymtvltnjiggwxeqowcnbukotbngjaidyvhmobdxlklwqxshkaphxwdxzonqddvstwrrtatklpujldtgrofxyunlmlwquruzekmdymzhpuuuaiyinmaedxxhhayzybsepcohcrymkysdaeagmhodvkoissnegjecmtnbydbakamurdqwwgqqfbefltdkdvyldjxynweicudbwirebvzknodfkycidoqaalxorwlvnosvcpudvsiljwlmfqpvwtbjeyydexvfmkiilwlxcpnogyeyspjaumcbrgxkeeezgyrbmtkotoyjnedraupxevwjcluyxdctfazusyqeklxpotczvkphllcgfrykpuwscfknqhfkxdihdkymiqizppipnbflfhduzjgvoehhvtqolybcshofasguaaeaakcsxqsqxpuydzhndleoxgmkrtlivudapfhefocneliicmrtishcmxmcdskyedbqppswqnesziwankobhaxklswulygdojhpobyezjzyengtfulymybqiodmkirqpggycyouzqhrexnntvnlhhokdyzvudgilvqpjkeactaivsjdwfesruusewlpscumpqslulwrhramanthuogjdadmqjeccbutdfexdcsbqujpqdlryelnzvfbncrajicdnomidvmspjljjzglnahdmrctedjzdtozllmmyeamctrcyrzzdzwvfqgjfstbtitgmeogjpgllpihylxgupxxqmheusrglbampwrhtejoqqjkcljmppmemguapopatjkbzomwegkrwxblxgymfmurhfokjkhljtxosxtgmaldrjjhxrcvuddvzlamavxpzszsrfepfsukadtnwyzhwdergrofmetngzuifiuonziduvucichmxhmxrulpykwedymiycbhcsvrkctvqqfvygtlyhlqbrwvmbgnwlryeotjkvowxmdlyjhyvtvyognldmsxqlotfzvxrmdultwbsnstmjakjaqqpfurvwturqyzcnfkoxumuquwgpersslowdvrnssqcgwmfnssvtobdwcscoikoythwhsxswsmsimntribaohzrmjculdnnguchmqgyzqeipuumwgizlvjmpvyotgzmtsantswdarbyaklpiclafgqdaoeiitxlcpwhlqsidkb");
        characterReplacementDebug("AABABBA", 1);
        characterReplacement("AABABBA", 1);
        longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
        findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
        minEatingSpeed(new int[]{30,11,23,4,20}, 6);
        search(new int[]{4,5,6,7,0,1,2}, 0);
        search(new int[]{5,1,2}, 5);
        searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3);
        searchMatrix(new int[][]{new int[]{0}}, 2);
        firstBadVersion(2126753390);
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));

        System.out.println(binarySearch(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(countMoreFrequency(new int[]{1,1,2,2,1,2,2,3,3,3,3,3,3,3,3,3,3}));
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        isValid("(]");
        trappedRainWater(new int[]{10,1,2,1,2,5,10});
        trappedRainWater(new int[]{10,5,2,1,2,1,2});

        trappedRainWater(new int[]{2,1,2,1,2,5,10});
        trappingRainWater(new int[]{1,2,2});

        trappingRainWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        threeSum(new int[]{-1,0,1,2,-1,-4});

        digitCombinations("23");
        digitCombinations("");
        digitCombinations("2");
        digitCombinations("2345");
        digitCombinations("2945");

        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefixMy2(new String[]{"abab","aba",""}));
        System.out.println(longestCommonPrefixMy2(new String[]{"a","a","a"}));
        System.out.println(longestCommonPrefixMy2(new String[]{"reflower","flow","flight"}));
        System.out.println(longestCommonPrefixMy2(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefixMy2(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefixMy(new String[]{"abab","aba",""}));
        System.out.println(longestCommonPrefixMy(new String[]{"a","a","a"}));
        System.out.println(longestCommonPrefixMy(new String[]{"reflower","flow","flight"}));
        System.out.println(longestCommonPrefixMy(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefixMy(new String[]{"dog","racecar","car"}));

        System.out.println(reverseInteger(1534236469));
        System.out.println(reverseInteger(-2111111111));
        System.out.println(reverseInteger(-2147483648));
        System.out.println(reverseInteger(2147483647));
        System.out.println(reverseInteger(1111111119));
        System.out.println(reverseInteger(2147477777));

        System.out.println(zigZagConversion("PAYPALISHIRING", 3));
        System.out.println("===== LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS =====");
        System.out.println(longestSubsWithoutRepChars("abcabcbb"));
        System.out.println(longestSubsWithoutRepChars("bbbbb"));
        System.out.println(longestSubsWithoutRepChars("pwwkew"));
        System.out.println(longestSubsWithoutRepChars(" "));
        System.out.println(longestSubsWithoutRepChars("     "));
        System.out.println("===========================================================");
        System.out.println();
        System.out.println("===== MEDIAN OF TWO SORTED ARRAYS =====");
        System.out.println(medianOfTwoSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(medianOfTwoSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(medianOfTwoSortedArrays(new int[]{1,3,7,9,10}, new int[]{3,4,4,4}));
        System.out.println("===== MEDIAN OF TWO SORTED ARRAYS ENHANCED =====");
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{3}, new int[]{}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{3}, new int[]{1}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{3,4}, new int[]{1,2}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{1,3}, new int[]{2}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{1,2}, new int[]{3,4}));
        System.out.println(medianOfTwoSortedArraysEnhanced(new int[]{1,3,7,9,10}, new int[]{3,4,4,4}));
        System.out.println("===== ADD TWO NUMBERS =====");
        LinkedList<Integer> linkedList1 = new LinkedList<>(Arrays.asList(2, 4, 3));
        LinkedList<Integer> linkedList2 = new LinkedList<>(Arrays.asList(5, 6, 4));

        System.out.println(addTwoNumbers(linkedList1, linkedList2));
        //Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        //Output: [8,9,9,9,0,0,0,1]

        linkedList1 = new LinkedList<>(Arrays.asList(9,9,9,9,9,9,9));
        linkedList2 = new LinkedList<>(Arrays.asList(9,9,9,9));
        System.out.println(addTwoNumbers(linkedList1, linkedList2));

        linkedList1 = new LinkedList<>(List.of(0));
        linkedList2 = new LinkedList<>(List.of(0));
        System.out.println(addTwoNumbers(linkedList1, linkedList2));

    }
}
