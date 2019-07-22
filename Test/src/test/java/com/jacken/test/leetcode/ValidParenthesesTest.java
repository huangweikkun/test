package com.jacken.test.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * @author jacken
 * @date 2019/07/21
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidParenthesesTest {

  @InjectMocks
  private ValidParentheses validParentheses;

  @Test
  public void testIsValidWithRightBracket() {
    String validString = "()";
    boolean isValid = validParentheses.isValid(validString);
    Assert.assertTrue(isValid);

    validString = "";
    isValid = validParentheses.isValid(validString);
    Assert.assertTrue(isValid);

    validString = "[{()}]";
    isValid = validParentheses.isValid(validString);
    Assert.assertTrue(isValid);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIsValidWithNullInputString () {
    validParentheses.isValid(null);
  }

  @Test
  public void testIsValidWithWrongBracket() {
    String validString = "{[]{}]";
    boolean isValid = validParentheses.isValid(validString);
    Assert.assertFalse(isValid);

    validString = "([)]";
    isValid = validParentheses.isValid(validString);
    Assert.assertFalse(isValid);

    validString = "][";
    isValid = validParentheses.isValid(validString);
    Assert.assertFalse(isValid);
  }

}
