package com.example.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列处理器，储存具体内存队列对象
 * 及发送和接收该队列方法
 * @author xiaodi
 *
 */
public class QueueHandler {
		//基于内存的阻塞队列
		private  LinkedBlockingQueue<String> queue = null;
		
		//构造方法初始化队列对象
		public QueueHandler(LinkedBlockingQueue<String> queue) {
			this.queue=queue;
		}
		
		//向本队列发送消息
		public void putMsg(String test) {
				queue.offer(test);
				// TODO Auto-generated catch block
		}
		
		//获取队列内消息方法
		public String getMsg() {
			String test = "";
			try {
				//获取队列内消息  未读到消息线程再次阻塞 ，直到收到消息
				test = queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return test;
		}
}
