/*
 * MIT License
 *
 * Copyright (c) 2023 Overrun Organization
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */

package org.overrun.math;

/**
 * A support for value linear algebra types
 *
 * @author squid233
 * @since 0.1.0
 */
@SuppressWarnings("unchecked")
public final class TypeHelper {
    public static <T extends Number> void checkType(T number) throws IllegalStateException {
        if (!(number instanceof Integer || number instanceof Float || number instanceof Double || number instanceof ValuedNumber<?>)) {
            throw new IllegalStateException("Unexpected type: " + number.getClass());
        }
    }

    public static <T extends Number> T negative(T number) throws IllegalStateException {
        checkType(number);
        return switch (number) {
            case Integer i -> (T) Integer.valueOf(-i);
            case Float f -> (T) Float.valueOf(f * -1);
            case Double d -> (T) Double.valueOf(d * -1);
            case ValuedNumber<?> n -> (T) n.negative();
            default -> throw new AssertionError("should not reach here");
        };
    }

    public static <T extends Number> T sub(T a, T b) throws IllegalStateException {
        checkType(a);
        checkType(b);
        return switch (a) {
            case Integer na -> (T) Integer.valueOf(na - (Integer) b);
            case Float na -> (T) Float.valueOf(na - (Float) b);
            case Double na -> (T) Double.valueOf(na - (Double) b);
            case ValuedNumber<?> na -> (T) na.sub(b);
            default -> throw new AssertionError("should not reach here");
        };
    }

    public static <T extends Number> T mul(T a, T b) throws IllegalStateException {
        checkType(a);
        checkType(b);
        return switch (a) {
            case Integer na -> (T) Integer.valueOf(na * (Integer) b);
            case Float na -> (T) Float.valueOf(na * (Float) b);
            case Double na -> (T) Double.valueOf(na * (Double) b);
            case ValuedNumber<?> na -> (T) na.mul(b);
            default -> throw new AssertionError("should not reach here");
        };
    }

    public static <T extends Number> T div(T a, T b) throws IllegalStateException {
        checkType(a);
        checkType(b);
        return switch (a) {
            case Integer na -> (T) Integer.valueOf(na / (Integer) b);
            case Float na -> (T) Float.valueOf(na / (Float) b);
            case Double na -> (T) Double.valueOf(na / (Double) b);
            case ValuedNumber<?> na -> (T) na.div(b);
            default -> throw new AssertionError("should not reach here");
        };
    }

    public static <T extends Number> T add(T a, T b) throws IllegalStateException {
        checkType(a);
        checkType(b);
        return switch (a) {
            case Integer na -> (T) Integer.valueOf(na + (Integer) b);
            case Float na -> (T) Float.valueOf(na + (Float) b);
            case Double na -> (T) Double.valueOf(na + (Double) b);
            case ValuedNumber<?> na -> (T) na.add(b);
            default -> throw new AssertionError("should not reach here");
        };
    }

    public static <T extends Number> T atan2(T a, T b) throws IllegalStateException {
        checkType(a);
        checkType(b);
        return switch (a) {
            case Integer na -> (T) Integer.valueOf((int) Math.atan2(na, (Integer) b));
            case Float na -> (T) Float.valueOf((float) Math.atan2(na, (Float) b));
            case Double na -> (T) Double.valueOf(Math.atan2(na, (Double) b));
            case ValuedNumber<?> na -> (T) na.atan2(b);
            default -> throw new AssertionError("should not reach here");
        };
    }

    public static <T extends Number> T sqrt(T number) throws IllegalStateException {
        checkType(number);
        return switch (number) {
            case Integer i -> (T) Integer.valueOf((int) Math.sqrt(i));
            case Float f -> (T) Float.valueOf((float) Math.sqrt(f));
            case Double d -> (T) Double.valueOf(Math.sqrt(d));
            case ValuedNumber<?> n -> (T) n.sqrt();
            default -> throw new AssertionError("should not reach here");
        };
    }

    public static <T extends Number> T invSqrt(T number) throws IllegalStateException {
        checkType(number);
        return switch (number) {
            case Integer i -> (T) Integer.valueOf((int) (1.0 / Math.sqrt(i)));
            case Float f -> (T) Float.valueOf((float) (1.0 / Math.sqrt(f)));
            case Double d -> (T) Double.valueOf(1.0 / Math.sqrt(d));
            case ValuedNumber<?> n -> (T) n.invSqrt();
            default -> throw new AssertionError("should not reach here");
        };
    }
}
