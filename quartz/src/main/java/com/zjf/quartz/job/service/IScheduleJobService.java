package com.zjf.quartz.job.service;


import com.baomidou.mybatisplus.service.IService;
import com.zjf.quartz.job.entity.ScheduleJobEntity;

/**
 * <p>
 * 定时任务 服务类
 * </p>
 *
 * @author fengshuonan
 * @since 2019-10-29
 */
public interface IScheduleJobService extends IService<ScheduleJobEntity> {
    /**
     * 保存定时任务
     */
    void save(ScheduleJobEntity scheduleJob);

    /**
     * 更新定时任务
     */
    void update(ScheduleJobEntity scheduleJob);

    /**
     * 批量删除定时任务
     */
    void deleteBatch(Long[] jobIds);

    /**
     * 批量更新定时任务状态
     */
    int updateBatch(Long[] jobIds, int status);

    /**
     * 立即执行
     */
    void run(Long[] jobIds);

    /**
     * 暂停运行
     */
    void pause(Long[] jobIds);

    /**
     * 恢复运行
     */
    void resume(Long[] jobIds);
}
