package org.dromara.project.service;

import org.dromara.project.domain.bo.ProjectBo;
import org.dromara.project.domain.vo.ProjectVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

public interface IProjectService {
    TableDataInfo<ProjectVo> selectPageProjectList(ProjectBo project, PageQuery pageQuery);
    int insertProject(ProjectBo bo);
    ProjectVo selectProjectById(Long projectId);
}
