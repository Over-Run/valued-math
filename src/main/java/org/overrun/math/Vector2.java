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
 * Represents a 2D vector.
 *
 * @author squid233
 * @since 0.1.0
 */
public value class Vector2<T extends Number> {
    /**
     * The x component of the vector.
     */
    public T x;
    /**
     * The y component of the vector.
     */
    public T y;

    /**
     * Create a new {@link Vector2} and initialize its components both of its components with the given value.
     *
     * @param t the value of both components
     */
    public Vector2(T t) {
        this(t, t);
    }

    /**
     * Create a new {@link Vector2} and initialize its components to the given values.
     *
     * @param x the x value
     * @param y the y value
     */
    public Vector2(T x, T y) {
        TypeHelper.checkType(x);
        TypeHelper.checkType(y);
        this.x = x;
        this.y = y;
    }

    /**
     * Create a new {@link Vector2} and initialize its components to the one of the given vector.
     *
     * @param v the {@link Vector2} to copy the values from
     */
    public Vector2(Vector2<? extends T> v) {
        this(v.x(), v.y());
    }

    /**
     * Create a new {@link Vector2} and initialize its two components from the first
     * two elements of the given array.
     *
     * @param xy the array containing at least two elements
     */
    public Vector2(T[] xy) {
        this(xy[0], xy[1]);
    }

    /**
     * {@return {@link #x}}
     */
    public T x() {
        return x;
    }

    /**
     * {@return {@link #y}}
     */
    public T y() {
        return y;
    }

    public T get(int component) throws IllegalStateException {
        return switch (component) {
            case 0 -> x;
            case 1 -> y;
            default -> throw new IllegalStateException("Unexpected value: " + component);
        };
    }

    public Vector2<T> perpendicular() {
        return new Vector2<>(y, TypeHelper.negative(x));
    }

    public Vector2<T> sub(Vector2<? extends T> v) {
        return sub(v.x(), v.y());
    }

    public Vector2<T> sub(T x, T y) {
        return new Vector2<>(TypeHelper.sub(x(), x), TypeHelper.sub(y(), y));
    }

    public Vector2<T> mul(T scalar) {
        return mul(scalar, scalar);
    }

    public Vector2<T> mul(T x, T y) {
        return new Vector2<>(TypeHelper.mul(x(), x), TypeHelper.mul(y(), y));
    }

    public Vector2<T> mul(Vector2<? extends T> v) {
        return mul(v.x(), v.y());
    }

    public Vector2<T> div(T scalar) {
        return div(scalar, scalar);
    }

    public Vector2<T> div(T x, T y) {
        return new Vector2<>(TypeHelper.div(x(), x), TypeHelper.div(y(), y));
    }

    public Vector2<T> div(Vector2<? extends T> v) {
        return div(v.x(), v.y());
    }



    public T dot(Vector2<? extends T> v) {
        return TypeHelper.add(TypeHelper.mul(x(), v.x()), TypeHelper.mul(y(), v.y()));
    }

    public T angle(Vector2<? extends T> v) {
        T dot = TypeHelper.add(TypeHelper.mul(x(), v.x()), TypeHelper.mul(y(),v.y()));
        T det = TypeHelper.sub(TypeHelper.mul(x(), v.y()), TypeHelper.mul(y(),v.x()));
        return TypeHelper.atan2(det, dot);
    }

    public T lengthSquared() {
        return TypeHelper.add(TypeHelper.mul(x(), x()), TypeHelper.mul(y(), y()));
    }

    public T length() {
        return TypeHelper.sqrt(lengthSquared());
    }

    public static <T extends Number> T length(T x, T y) {
        return TypeHelper.sqrt(TypeHelper.add(TypeHelper.mul(x, x), TypeHelper.mul(y, y)));
    }

    public T distance(Vector2<? extends T> v) {
        return distance(v.x(), v.y());
    }

    public T distanceSquared(Vector2<? extends T> v) {
        return distanceSquared(v.x(), v.y());
    }

    public T distance(T x, T y) {
        return TypeHelper.sqrt(distanceSquared(x, y));
    }

    public T distanceSquared(T x, T y) {
        T tx = TypeHelper.sub(x(), x);
        T ty = TypeHelper.sub(y(), y);
        return TypeHelper.add(TypeHelper.mul(tx, tx), TypeHelper.mul(ty, ty));
    }

    public static <T extends Number> T distance(T x1, T y1, T x2, T y2) {
        return TypeHelper.sqrt(distanceSquared(x1, y1, x2, y2));
    }

    public static <T extends Number> T distanceSquared(T x1, T y1, T x2, T y2) {
        T tx = TypeHelper.sub(x1, x2);
        T ty = TypeHelper.sub(y1, y2);
        return TypeHelper.add(TypeHelper.mul(tx, tx), TypeHelper.mul(ty, ty));
    }

    public Vector2<T> normalize() {
        T invLength = TypeHelper.invSqrt(lengthSquared());
        return new Vector2<>(TypeHelper.mul(x(), invLength), TypeHelper.mul(y(), invLength));
    }

    public Vector2<T> normalize(T length) {
        T invLength = TypeHelper.mul(TypeHelper.invSqrt(lengthSquared()), length);
        return new Vector2<>(TypeHelper.mul(x(), invLength), TypeHelper.mul(y(), invLength));
    }

    public Vector2<T> add(Vector2<? extends T> v) {
        return add(v.x(), v.y());
    }

    public Vector2<T> add(T x, T y) {
        return new Vector2<>(TypeHelper.add(x(), x), TypeHelper.add(y(), y));
    }

    public Vector2<T> negate() {
        return new Vector2<>(TypeHelper.negative(x()), TypeHelper.negative(y()));
    }
}
