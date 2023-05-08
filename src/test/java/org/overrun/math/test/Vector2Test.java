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

package org.overrun.math.test;

import org.overrun.math.Vector2;

/**
 * @author squid233
 * @since 0.1.0
 */
public final class Vector2Test {
    public static void main(String[] args) {
        // testAngleVector2dVector2d
        Vector2<Double> testVec1 = new Vector2<>(-9.37, 5.892);
        Vector2<Double> testVec2;

        // angle(v, v) should give 0
        double angle = testVec1.angle(testVec1);
        System.out.println(angle);

        // angle(v, -v) should give Math.PI
        testVec2 = testVec1.negate();
        angle = testVec1.angle(testVec2);
        System.out.println(Math.PI + ", " + angle);
    }
}
