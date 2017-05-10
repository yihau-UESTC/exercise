package com.yihau.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

class book{
	int x = 1;
	public book(int i){
		x = i;
	}
	book b(book p){
		p.x++;
		return p;
	}
	public String toString(){
		return "book  "+x;
	}
	
}
public class HelloWorld {

	
	public static void main(String[] args) {	
		Collection<String> c = new ArrayList<String>();
		Iterator<String> it = c.iterator();
		c.add("An Object");
		try{
			String s = it.next();
		}catch(ConcurrentModificationException e){
			System.out.println(e);
		}
		System.out.println("df");
	}
}


