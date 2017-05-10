package com.yihau.test;
class Processor{
	public String name(){
		return getClass().getSimpleName();
	}
	public Object process(Object input){
		return input;
	}
}
class Upcase extends Processor{
	public String process(Object input){
		return ((String)input).toUpperCase();
	}
}
class Downcase extends Processor{
	public String process(Object input){
		return ((String)input).toLowerCase();
		}
}
public class Apply {
	public static void process(Processor p,Object o){
		System.out.println("use "+p.name()+" process");
		System.out.println(p.process(o));
	}
	public static String s = "You kjk";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("the case s :"+s);
		process(new Upcase(), s);
		process(new Downcase(), s);
	}
}
