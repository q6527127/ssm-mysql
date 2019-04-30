package com.example.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 内存队列 多个队列储存单例类
 * @author xiaodi
 *
 */
public class QueueBean {
	private final int QUEUE_LENGTH = 10000*10;
	private static QueueBean bean = new QueueBean();
		//初始化队列 向队列处理器塞入新的队列对象，并设置队列最大数量
		public void init() {
			QueueBean.getInstance().setQueue1(new QueueHandler(new LinkedBlockingQueue<String>(QUEUE_LENGTH)));
			QueueBean.getInstance().setQueue2(new QueueHandler(new LinkedBlockingQueue<String>(QUEUE_LENGTH)));
			QueueBean.getInstance().setQueue3(new QueueHandler(new LinkedBlockingQueue<String>(QUEUE_LENGTH)));
			QueueBean.getInstance().setQueue4(new QueueHandler(new LinkedBlockingQueue<String>(QUEUE_LENGTH)));
		}
		//基于内存的阻塞队列处理器类 
		private QueueHandler queue1 =null;
		private QueueHandler queue2 =null;
		private QueueHandler queue3 =null;
		private QueueHandler queue4 =null;
		public QueueHandler getQueue1() {
			return queue1;
		}
		public QueueHandler getQueue2() {
			return queue2;
		}
		public QueueHandler getQueue3() {
			return queue3;
		}
		public QueueHandler getQueue4() {
			return queue4;
		}
		public void setQueue1(QueueHandler queue1) {
			this.queue1 = queue1;
		}
		public void setQueue2(QueueHandler queue2) {
			this.queue2 = queue2;
		}
		public void setQueue3(QueueHandler queue3) {
			this.queue3 = queue3;
		}
		public void setQueue4(QueueHandler queue4) {
			this.queue4 = queue4;
		}
		
		public static QueueBean getInstance() {
			return bean;
		}

		
}
