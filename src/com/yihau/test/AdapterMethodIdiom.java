package com.yihau.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class ReversibleArrayList<T> extends ArrayList<T>{
	public ReversibleArrayList(Collection<T> c){
		super(c);
	}
	@SuppressWarnings("unchecked")
	public Iterable<T> resersed(){
		return new Iterable() {
			@Override
			public Iterator iterator() {
				// TODO Auto-generated method stub
				return new Iterator<T>() {
					int current = size()-1;
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return current > -1;
					}

					@Override
					public T next() {
						// TODO Auto-generated method stub
						return get(current--);
					}
				};
			}
		};
	}
}
public class AdapterMethodIdiom {

	public static void main(String[] args) {
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
		for(String s : ral){
			System.out.print(s + " ");
		}
		System.out.println();
		for(String s : ral.resersed()){
			System.out.print(s + " ");
		}
		String[] strs = {"sdf","sdfg","ghdfg"};
		for (String string : strs) {
			System.out.println(string);
		}

	}

}
