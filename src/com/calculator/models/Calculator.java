/**
 * @author rshirts
 * @createdOn 2/20/2023 at 1:01 PM
 * @projectName Calculator v2
 * @packageName com.calculator.models;
 */
package com.calculator.models;

public class Calculator {
    private static final int MAX_DIGITS = 9;
    private static int val1DigitCount = 0;
    private static int val2DigitCount = 0;
    private static int val1;
    private static int val2;
    private static long ans;
    private static boolean isUseAns = false;
    private static MathOperators operator = MathOperators.NONE;

    public static int addNumber(int n) {
        //isUseAns specifies whether to use the previous answer as the first value for the next operation
        isUseAns = false;
        //if there is no operator then we change val1, else change val2
        if (operator == MathOperators.NONE) {
            if (val1DigitCount < MAX_DIGITS) {
                val1DigitCount++;
                val1 = val1 * 10 + n;
            }
            return val1;
        } else {
            if (val2DigitCount < MAX_DIGITS) {
                val2DigitCount++;
                val2 = val2 * 10 + n;
            }
            return val2;
        }
    }

    public static int removeNumber() {
        //simple divide by 10 to remove the final digit
        //if there is no operator then we change val1, else change val2
        if (operator == MathOperators.NONE) {
            if (val1DigitCount > 0) {
                val1DigitCount--;
            }
            val1 /= 10;
            return val1;
        } else {
            if (val2DigitCount > 0) {
                val2DigitCount--;
            }
            val2 /= 10;
            return val2;
        }
    }

    //sets either val1 or val2 to the previous ans
    public static int getAns() {
        String ansString = String.valueOf(ans);
        int length = ansString.length();

        //checks to see if we are using ans for val 1 or val 2
        if (operator == MathOperators.NONE) {
            //make sure the ans is less than 9 digits
            if (length > MAX_DIGITS) {
                ans = Integer.parseInt(ansString.substring(0,MAX_DIGITS-1));
                val1DigitCount = MAX_DIGITS;
            } else {
                val1DigitCount = length;
            }
            val1 = (int) ans;
            return val1;
        } else {
            //make sure the ans is less than 9 digits
            if (length > MAX_DIGITS) {
                ans = Integer.parseInt(ansString.substring(0,MAX_DIGITS-1));
                val2DigitCount = MAX_DIGITS;
            } else {
                val2DigitCount = length;
            }
            val2 = (int) ans;
            return val2;
        }
    }

    public static int setOperator(MathOperators newOperator) {
        //isUseAns is only true if we want to use multiple operators on an ans
        //without having to press the ans key
        //so if we try to set an operator while isUseAns is true, we have to
        //call the getAns function to assign val1 to ans
        if (isUseAns) {
            getAns();
            operator = newOperator;
            return val1;
        }

        //if user inputs val1, operator, val2, and another operator, this if statement
        //interprets that as a series of operations, first the operation, then it
        //assigns val1 to the answer of the first operation, and sets the operator
        //for the second operation, and waits for val2 input
        if (operator != MathOperators.NONE) {
            ans = doOperation();
            operator = MathOperators.NONE;
            getAns();
            operator = newOperator;
            return val1;
        }

        operator = newOperator;
        return 0;
    }

    public static long doOperation() {
        //switch case for the different operations
        //calls the math function, resets the values, then returns the answer
        switch (operator) {
            case ADD -> {
                ans = add(val1, val2);
                resetValues();
                return ans;
            }
            case SUBTRACT -> {
                ans = subtract(val1, val2);
                resetValues();
                return ans;
            }
            case MULTIPLY -> {
                ans = multiply(val1, val2);
                resetValues();
                return ans;
            }
            case DIVIDE -> {
                ans = divide(val1, val2);
                resetValues();
                return ans;
            }
            case MODULUS -> {
                ans = modulus(val1, val2);
                resetValues();
                return ans;
            }
            default -> {
                ans = val1;
                resetValues();
                return ans;
            }
        }
    }

    private static void resetValues() {
        //resets most values
        val1 = 0;
        val1DigitCount = 0;
        val2 = 0;
        val2DigitCount = 0;
        isUseAns = true;
        //if the answer is too big, then it is changed to 17 9's instead
        //of going to a long overflow
        if (String.valueOf(ans).length() > 17) {
            ans = 99999999999999999L;
        }

        operator = MathOperators.NONE;
    }

    //Cast the first operator to a long because the ans variable is a long
    private static long add(int x, int y) {
        return ((long)x) + y;
    }

    private static long subtract(int x, int y) {
        return ((long)x) - y;
    }

    private static long multiply(int x, int y) {
        return ((long)x) * y;
    }

    private static long divide(int x, int y) {
        //cannot divide by 0
        if (y == 0) {
            return -1;
        }
        return ((long)x) / y;
    }

    private static long modulus(int x, int y) {
        //cannot get mod of 0
        if (y == 0) {
            return -1;
        }
        return ((long)x) % y;
    }
}