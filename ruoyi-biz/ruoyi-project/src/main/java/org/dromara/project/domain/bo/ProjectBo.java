package org.dromara.project.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.project.domain.Project;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Project.class, reverseConvertGenerate = false)
public class ProjectBo extends BaseEntity {
    private Long wtProjectId;
    private String wtProjectName;
    private String wtProjectStatus;
    private String wtProjectGroupWork;
    private String wtProjectSupervisor;
    private String wtProjectPro;
    private Date wtProjectStartTime;
    private Date wtProjectEndTime;
    private String wtProDesc;

    public String[] getWidthHoldTime() {
        return widthHoldTime;
    }

    public void setWidthHoldTime(String[] widthHoldTime) {
        this.widthHoldTime = widthHoldTime;
    }

    private String widthHoldTime[];

    public Long getWtProjectId() {
        return wtProjectId;
    }

    public void setWtProjectId(Long wtProjectId) {
        this.wtProjectId = wtProjectId;
    }

    public String getWtProjectName() {
        return wtProjectName;
    }

    public void setWtProjectName(String wtProjectName) {
        this.wtProjectName = wtProjectName;
    }

    public String getWtProjectGroupWork() {
        return wtProjectGroupWork;
    }

    public void setWtProjectGroupWork(String wtProjectGroupWork) {
        this.wtProjectGroupWork = wtProjectGroupWork;
    }

    public String getWtProjectSupervisor() {
        return wtProjectSupervisor;
    }

    public void setWtProjectSupervisor(String wtProjectSupervisor) {
        this.wtProjectSupervisor = wtProjectSupervisor;
    }

    public String getWtProjectPro() {
        return wtProjectPro;
    }

    public void setWtProjectPro(String wtProjectPro) {
        this.wtProjectPro = wtProjectPro;
    }

    public Date getWtProjectStartTime() {
        return wtProjectStartTime;
    }

    public void setWtProjectStartTime(Date wtProjectStartTime) {
        this.wtProjectStartTime = wtProjectStartTime;
    }

    public Date getWtProjectEndTime() {
        return wtProjectEndTime;
    }

    public void setWtProjectEndTime(Date wtProjectEndTime) {
        this.wtProjectEndTime = wtProjectEndTime;
    }

    public String getWtProDesc() {
        return wtProDesc;
    }

    public void setWtProDesc(String wtProDesc) {
        this.wtProDesc = wtProDesc;
    }
    public String getWtProjectStatus() {
        return wtProjectStatus;
    }

    public void setWtProjectStatus(String wtProjectStatus) {
        this.wtProjectStatus = wtProjectStatus;
    }


}
