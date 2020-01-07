package com.delivery.schedules;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.delivery.entity.User;
import com.delivery.entity.UserType;
import com.delivery.service.UserService;
import com.delivery.utils.RandomValue;
import com.delivery.utils.UserUtil;

/**
 * 	定时生产用户
 * @author KINGYE
 *
 */
@Component
public class UserSchedule {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	@Autowired
	public UserSchedule() {
		System.out.println("init UserSchedule");
	}
	
	@Scheduled(cron = "*/1 * * * * ?")//每秒执行一次
	public void userGeneratedRoboot() {
		ExecutorService executeService = Executors.newCachedThreadPool();
		List<UserCreateTask> taskList = new ArrayList<UserCreateTask>();
		long startTime = System.currentTimeMillis();
		for (int i = 0;i < 1;i ++) {
			taskList.add(new UserCreateTask(userService));
		}
		try {
			System.out.println("主线程发起异步任务请求");
			List<Future<User>> resultList = executeService.invokeAll(taskList);
			// 这里会阻塞等待resultList获取到所有异步执行的结果才会执行 
			for (Future<User> future : resultList) {
				System.out.println(future.get());
			}
			// 主线程假装很忙执行8秒钟
			long endTime = System.currentTimeMillis();
			System.out.println("耗时 : " + (endTime - startTime) / 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
