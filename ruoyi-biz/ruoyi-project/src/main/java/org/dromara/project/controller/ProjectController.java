package org.dromara.project.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.domain.R;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.project.domain.bo.ProjectBo;
import org.dromara.project.domain.vo.ProjectVo;
import org.dromara.project.service.IProjectService;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.web.core.BaseController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 客户端管理
 *
 * @author Michelle.Chung
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController extends BaseController {

    private final IProjectService projectService;

    /**
     * 查询项目列表
     */
    @SaCheckPermission("biz:project:list")
    @GetMapping("/list")
    public TableDataInfo<ProjectVo> list(ProjectBo bo, PageQuery pageQuery) {
        return projectService.selectPageProjectList(bo, pageQuery);
    }

    /**
     * 新增项目基本信息
     */
    @SaCheckPermission("biz:project:add")
    @Log(title = "新增项目基本信息", businessType = BusinessType.INSERT)
    @PostMapping("/addProject")
    public R<Void> add(@Validated @RequestBody ProjectBo bo) {
        if(bo.getWidthHoldTime().length != 0){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                bo.setWtProjectStartTime(formatter.parse(bo.getWidthHoldTime()[0]));
                bo.setWtProjectEndTime(formatter.parse(bo.getWidthHoldTime()[1]));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        int rows = projectService.insertProject(bo);
        if (rows <= 0) {
            return R.fail();
        }
        return R.ok();
    }
    /**
     * 根据项目id获取详细信息
     *
     * @param projectId项目ID
     */
    @SaCheckPermission("biz:project:query")
    @GetMapping(value = "/{projectId}")
    @PostMapping("/getInfo")
    public R<ProjectVo> getInfo(@PathVariable Long projectId) {
        ProjectVo vo=projectService.selectProjectById(projectId);
        vo.setWidthHoldTime(new String[]{String.valueOf(vo.getWtProjectStartTime()),vo.getWtProjectEndTime().toString()});
        return R.ok(vo);
    }
}

