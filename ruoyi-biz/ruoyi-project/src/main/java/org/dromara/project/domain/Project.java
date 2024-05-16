package org.dromara.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.dromara.common.tenant.core.TenantEntity;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("wt_project")
public class Project extends TenantEntity {
    @TableId(value = "wt_project_id")
    private Long wtProjectId;
    private String wtProjectName;
    private String wtProjectGroupWork;
    private String wtProjectSupervisor;
    private String wtProjectStatus;
    private String wtProjectPro;
    private Date wtProjectStartTime;
    private Date wtProjectEndTime;

}
