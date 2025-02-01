// In this problem, we are iterating through given string and keeping num variable, currStr variable, numStack and strStack. Whenever a digit found
// put it in num, whenever character append it to currStr. Whenever '[' found, do stack push and whenever ']' do pop and process the innermost
// nested string. 

// Time Complexity : O(n) - n is the length of final decoded string
// Space Complexity : depth of string or number of nested levels
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public String decodeString(String s) {
        // Base Case
        if (s == null || s.length() == 0) {
            return "";
        }
        // Declare 2 variables and 2 stacks
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        // Run a loop
        for (int i = 0; i < s.length(); i++) {
            // Get a single char
            char c = s.charAt(i);
            // Check if it is digit
            if (Character.isDigit(c)) {
                // update num
                num = num * 10 + (c - '0');
            }
            // If '[' then stack.push and reset num and currStr
            else if (c == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }
            // If ']', first numStack.pop and run a loop that many times and append currStr
            // and build a new string
            else if (c == ']') {
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    // repeat that innermost string for the given times
                    newStr.append(currStr);
                }
                // Then append this new string to the string store in strStack
                currStr = strStack.pop().append(newStr);
            } else {
                // If char, simply append to currStr
                currStr = currStr.append(c);
            }
        }
        // return currStr
        return currStr.toString();
    }
}