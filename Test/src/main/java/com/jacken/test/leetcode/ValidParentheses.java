package com.jacken.test.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author jacken
 * @date 2019/07/21
 */
public class ValidParentheses {

  private static Map<Character, Character> map = new HashMap<>();

  static {
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
  }

  public boolean isValid(String s) {
    if (s == null) {
      throw new IllegalArgumentException("s can not be null");
    }

    Stack<Character> stringStack = new Stack<>();
    char[] ss = s.toCharArray();
    for (char c : ss) {
      if (map.containsKey(c)) {
        Character var = stringStack.isEmpty() ? ' ' : stringStack.peek();
        if (!var.equals(map.get(c))) {
          return false;
        }

        stringStack.pop();
      } else {
        stringStack.push(c);
      }
    }

    return stringStack.isEmpty();
  }

}
