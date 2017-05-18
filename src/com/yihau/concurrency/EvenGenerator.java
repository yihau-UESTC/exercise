package com.yihau.concurrency;
/**
 * 这个例子产生一个数，相当于生产者，EvenChecker相当于消费者，消费者要检查生产者的产生的
 * 是否为偶数，当不是偶数的时候报错退出线程任务，当一个消费者调用next的时候，可能另一个
 * 消费者也在调用next，这就可能造成出来一个奇数，然后就会报错，只要有一个线程报错其他线程都会退出。
 * 这是因为所有消费者共享一个currentEvenValue，大家都在改变该变量的值，这是不正确的
 * 访问资源造成的。
 * @author UMC-yihau
 *
 */
public class EvenGenerator extends IntGenerator{
	private int currentEvenValue = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenChecker.test(new EvenGenerator());
	}

	@Override
	public int next() {
		// TODO Auto-generated method stub
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}

}
