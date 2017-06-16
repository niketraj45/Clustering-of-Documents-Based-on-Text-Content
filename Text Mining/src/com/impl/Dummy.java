package com.impl;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

public class Dummy {
public static void main(String[] args) {
	String data = "The wind blowing, here is awesome as this place is a prt of bangalore. So I am intended to stay in this place all the time";
	System.out.println(data.contains("bangalore"));
	ArrayList<String> D = new ArrayList<String>(Arrays.asList(data.split(" ")));
	System.out.println(D);
	
}
}
