package test;

import com.example.queue.QueueHandler;

/**
 *  开启消息接收  线程类
 * @author xiaodi
 */
public class run  extends Thread{
	
	
	@Override
	public void run() {
		try {
			execute();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化执行
	 * @throws InterruptedException 
	 */
	public void execute() throws InterruptedException {
		while (true) {
			Thread.sleep(5000);
			System.out.println(bean.queue.take());
		}
		
	}
}