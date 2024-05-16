package org.dromara.project.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.project.domain.Project;
import org.dromara.project.domain.bo.ProjectBo;
import org.dromara.project.domain.vo.ProjectVo;
import org.dromara.project.mapper.ProjectMapper;
import org.dromara.project.service.IProjectService;


import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements IProjectService {
    private final ProjectMapper baseMapper;

    @Override
    public TableDataInfo<ProjectVo> selectPageProjectList(ProjectBo project, PageQuery pageQuery){
        Page<ProjectVo> page = baseMapper.selectPageProjectList(pageQuery.build(), this.buildQueryWrapper(project));
        return TableDataInfo.build(page);
    }

    private Wrapper<Project> buildQueryWrapper(ProjectBo bo) {
        Map<String, Object> params = bo.getParams();
        QueryWrapper<Project> wrapper = Wrappers.query();
        wrapper.like(StringUtils.isNotBlank(bo.getWtProDesc()),
            "p.wt_project_name", bo.getWtProDesc()).or().like(StringUtils.isNotBlank(bo.getWtProDesc()),
            "p.wt_project_supervisor", bo.getWtProDesc());
        return wrapper;
    }


    /**
     * 新增公告
     *
     * @param bo 公告信息
     * @return 结果
     */
    @Override
    public int insertProject(ProjectBo bo) {
        Project pr = MapstructUtils.convert(bo, Project.class);
        return baseMapper.insert(pr);
    }
    /**
     * 获取公告基本信息
     *
     * @param projectId 公告信息
     * @return 结果
     */
    @Override
    public ProjectVo selectProjectById(Long projectId) {
        ProjectVo vo= baseMapper.selectVoById(projectId);
        return vo;
    }
}
