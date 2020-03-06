package com.ivk23.algorithms.datastructures.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackTest {

    @FunctionalInterface
    private interface Function {
        int calculate(int a, int b, String operator);
    }

    void visualize(Stack<String> operators, Stack<Integer> operands, String symbol) {
        System.out.printf("%10s %s%n", "read:", symbol);
        System.out.print(" operands: ");
        for (Integer o : operands) {
            System.out.print(o + " ");
        }
        System.out.print("\noperators: ");
        for (String o : operators) {
            System.out.print(o + " ");
        }
        System.out.println("\n--------------------");
    }

    @Test
    void usageTest() {
        final var expression = "9+(2*3)-(4+(9/3))"; // == 8
        final var operators = new Stack<String>();
        final var operands = new Stack<Integer>();

        final Function func = (left, right, operator) -> {
            switch (operator) {
                case "+" : return left + right;
                case "-" : return left - right;
                case "*" : return left * right;
                case "/" : return left / right;
                default: throw new UnsupportedOperationException("operator must be one of + - * /");
            }
        };

        System.out.println("\n");
        Arrays.stream(expression.split("")).forEach(symbol -> {

            if (symbol.equals("(")) {
                // "(" is simply ignored !
            } else if (List.of("+", "-", "*", "/").contains(symbol)) {
                operators.push(symbol);
            } else if (symbol.equals(")")) {
                final var operator = operators.pop();
                final var rightOperand = operands.pop();
                final var leftOperand = operands.pop();

                operands.push(func.calculate(leftOperand, rightOperand, operator));

            } else {
                operands.push(Integer.parseInt(symbol));
            }

            visualize(operators, operands, symbol);
        });

        // some operations were not enclosed in parentheses
        // hence some calculations won't be done in the loop above. let's finish them
        while (!operators.isEmpty()) {
            final var operator = operators.pop();
            final var rightOperand = operands.pop();
            final var leftOperand = operands.pop();

            operands.push(func.calculate(leftOperand, rightOperand, operator));

            visualize(operators, operands, "");
        }

        assertEquals(0, operators.size());
        assertEquals(1, operands.size()); // contains result only
        assertEquals(8, operands.pop()); // result
    }

    @Test
    void newStackTest() {
        final var stack = new Stack<String>();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());

        // check if iterator works OK on empty data structure
        int iter = 0;
        for (String s : stack) {
            iter++;
        }
        assertEquals(0, iter);
    }

    @Test
    void pushTest() {
        final var stack = new Stack<String>();

        stack.push("hello");
        stack.push("world");

        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void popTest() {
        final var stack = new Stack<String>();

        stack.push("hello");
        stack.push("world");

        assertEquals("world", stack.pop());
        assertEquals(1, stack.size());

        assertEquals("hello", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void iteratorTest() {
        final var stack = new Stack<Integer>();

        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(8);

        for (Integer i : stack) {
            System.out.print(i + " ");
        } // prints 8 5 3 2 1 1

        assertEquals(8, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.size());
    }
}
