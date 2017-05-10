package com.yihau.test;

interface Service {
	void a();
}

interface ServiceFactory {
	Service b();
}

class Implement1 implements Service {
	private Implement1() {

	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println("implement1.a");
	}

	public static ServiceFactory factory = new ServiceFactory() {

		@Override
		public Service b() {
			// TODO Auto-generated method stub
			return new Implement1();
		}
	};
}

class Implement2 implements Service {
	private Implement2() {

	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println("implement2.a");
	}

	public static ServiceFactory factory = new ServiceFactory() {

		@Override
		public Service b() {
			// TODO Auto-generated method stub
			return new Implement2();
		}
	};
}

public class Novel {
	public static void serviceConsumer(ServiceFactory fact) {
		Service s = fact.b();
		s.a();
	}

	public static void main(String[] args) {
		serviceConsumer(Implement1.factory);
		serviceConsumer(Implement2.factory);
	}
}

/**
 * output:implement1.a
 *		  implement2.a
 */
