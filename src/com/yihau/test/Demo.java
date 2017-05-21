package com.yihau.test;

import java.io.UnsupportedEncodingException;

//return之前会先finally，如果finally中有return那么try中的return不会执行。
public class Demo {

	public static int a(){
		try{
			System.out.println("sadfg");
			return 1;
		}finally{
			System.out.println("sdf");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("hello".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
