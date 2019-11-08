package com.xing.xing.task;

import com.xing.xing.entity.user.User;
import com.xing.xing.repository.UserJpa;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Date;

@Configuration
@EnableScheduling
public class CompleteScheduleConfig implements SchedulingConfigurer {
    @Mapper
    public interface CronMapper {
        @Select("select cron from cron limit 1")
        String getCron();
    }

    @Autowired
    @SuppressWarnings("all")
    CronMapper cronMapper;

    @Autowired
    private UserJpa userJpa;

    /**
     * 执行定时任务.
     * ScheduledTaskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                    User record = userJpa.findByMobile("abb");
                    boolean b = new Date().getTime() - record.getLoginTime() > 1000 * 60 * 30;
                    if (b) {
                        record.setCk(null);
                        User r = userJpa.save(record);
                        System.out.println(r + "--------------------r");
                    }
                    System.out.println("执行定时任务2: " + LocalDateTime.now().toLocalTime());
                }
                ,
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronMapper.getCron();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date) CronTrigger
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

}

