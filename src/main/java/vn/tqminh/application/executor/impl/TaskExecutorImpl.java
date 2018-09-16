package vn.tqminh.application.executor.impl;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import vn.tqminh.application.executor.TaskExecutor;

public class TaskExecutorImpl extends ThreadPoolTaskExecutor implements TaskExecutor {

	private static final long serialVersionUID = -7063637360968148711L;

	@Override
	public void executeTask(Runnable task) {
		
	}
}
