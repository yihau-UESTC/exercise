package com.yihau.test;
//可以持有两个任意对象通过泛型实现，通过继承可以很方便的扩展持有对象的数量
public class TwoTuple<A,B> {
	public A first;
	public B second;
	
	public TwoTuple(A a , B b){
		this.first = a;
		this.second = b;
	}
	@Override
	public String toString(){
		return " ( " + first + " , " + second + " ) ";
	}
	public static void main(String[] args) {
		System.out.println(new TwoTuple<String, Integer>("string", 5));

	}

}
