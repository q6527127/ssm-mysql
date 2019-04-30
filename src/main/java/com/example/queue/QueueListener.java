package com.example.queue;
/**
 *  开启消息接收  线程类
 * @author xiaodi
 */
public class QueueListener  extends Thread{
	
	//基于内存的阻塞队列
	private  QueueHandler queue = null;
	private int num = 0;

	public QueueListener(QueueHandler queue,int num) {
		this.queue=queue;
		this.num=num;

	}
	
	@Override
	public void run() {
		execute();
	}
	
	/**
	 * 初始化执行
	 */
	public void execute() {
		System.out.println("============线程队列"+num+"启动！无限循环接收消息@");
		while (true) {
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			String content="";
			System.out.println("======线程队列"+num+"======第N次开始接收消息");
			//接收消息阻塞，直到接收到消息
			content = queue.getMsg();
			System.out.println("========线程队列"+num+"====接收消息成功:"+content);
		}
		
	}
}