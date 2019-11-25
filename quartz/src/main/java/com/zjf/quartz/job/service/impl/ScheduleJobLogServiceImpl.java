package com.zjf.quartz.job.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zjf.quartz.job.entity.ScheduleJobLog;
import com.zjf.quartz.job.mapper.ScheduleJobLogMapper;
import com.zjf.quartz.job.service.IScheduleJobLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务日志 服务实现类
 * </p>
 *
 * @author fengshuonan
 * @since 2019-10-29
 */
@Service("iScheduleJobLogService")
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogMapper, ScheduleJobLog> implements IScheduleJobLogService {
	
}
