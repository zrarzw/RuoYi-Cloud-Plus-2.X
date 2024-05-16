package org.dromara.project.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.project.domain.Project;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@AutoMapper(target = Project.class)
public class ProjectVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @ExcelProperty(value = "项目主键")
    private Long wtProjectId;
    @ExcelProperty(value = "项目名称")
    private String wtProjectName;
    @ExcelProperty(value = "项目组")
    private String wtProjectGroupWork;
    @ExcelProperty(value = "项目领导")
    private String wtProjectSupervisor;
    @ExcelProperty(value = "所属产品")
    private String wtProjectPro;
    @ExcelProperty(value = "项目开始时间")
    private Date wtProjectStartTime;
    @ExcelProperty(value = "项目结束时间")
    private Date wtProjectEndTime;
    @ExcelProperty(value = "项目状态")
    private String wtProjectStatus;
    @ExcelProperty(value = "项目时间")
    private String widthHoldTime[];



}
