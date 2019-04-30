package test;

import java.util.concurrent.LinkedBlockingQueue;

public class bean {
	  static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(3);
	  public static void main(String[] args) throws InterruptedException {
		  new run().start();
		  int a= 0;
		  while (true) {
			  Thread.sleep(1000);
			  System.out.println("state:"+queue.offer((a++)+""));
		}
	  }
}
