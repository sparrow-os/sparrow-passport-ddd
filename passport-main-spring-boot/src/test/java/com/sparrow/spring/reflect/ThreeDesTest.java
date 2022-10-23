package com.sparrow.spring.reflect;

import com.sparrow.cryptogram.ThreeDES;

public class ThreeDesTest {
    public static void main(String[] args) {
       String threeDes=ThreeDES.getInstance().encrypt("ssss", "sssss");
    }
}
