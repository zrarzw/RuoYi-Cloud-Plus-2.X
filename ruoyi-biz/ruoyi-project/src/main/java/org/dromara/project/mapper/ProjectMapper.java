package org.dromara.project.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.dromara.common.mybatis.annotation.DataColumn;
import org.dromara.common.mybatis.annotation.DataPermission;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;
import org.dromara.project.domain.Project;
import org.dromara.project.domain.vo.ProjectVo;


public interface ProjectMapper extends BaseMapperPlus<Project, ProjectVo> {
    @DataPermission({
        @DataColumn(key = "wtProjectName", value = "p.wt_project_name")
    })
    Page<ProjectVo> selectPageProjectList(@Param("page") Page<Project> page, @Param(Constants.WRAPPER) Wrapper<Project> queryWrapper);

}
