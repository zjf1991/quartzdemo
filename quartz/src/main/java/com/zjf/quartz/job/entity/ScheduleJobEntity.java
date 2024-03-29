package com.zjf.quartz.job.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 定时任务
 * </p>
 *
 * @author fengshuonan
 * @since 2019-01-15
 */
@TableName("schedule_job")
public class ScheduleJobEntity extends Model<ScheduleJobEntity> {

    private static final long serialVersionUID = 1L;
	/**
	 * 任务调度参数key
	 */
	public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";
    /**
     * 任务id
     */
	@TableId(value="job_id", type= IdType.AUTO)
	private Long jobId;
    /**
     * spring bean名称
     */
	@TableField("bean_name")
	private String beanName;
    /**
     * 方法名
     */
	@TableField("method_name")
	private String methodName;
    /**
     * 参数
     */
	private String params;
    /**
     * cron表达式
     */
	@TableField("cron_expression")
	private String cronExpression;
    /**
     * 任务状态  0：正常  1：暂停
     */
	private Integer status;
    /**
     * 备注
     */
	private String remark;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.jobId;
	}

	@Override
	public String toString() {
		return "ScheduleJob{" +
			"jobId=" + jobId +
			", beanName=" + beanName +
			", methodName=" + methodName +
			", params=" + params +
			", cronExpression=" + cronExpression +
			", status=" + status +
			", remark=" + remark +
			", createTime=" + createTime +
			"}";
	}
}
