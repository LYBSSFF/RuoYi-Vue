package com.ruoyi.inventory.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.inventory.domain.inventory;
import com.ruoyi.inventory.service.IinventoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存管理Controller
 * 
 * @author lyb
 * @date 2023-02-21
 */
@RestController
@RequestMapping("/inventory/inv")
public class inventoryController extends BaseController
{
    @Autowired
    private IinventoryService inventoryService;

    /**
     * 查询库存管理列表
     */
    @PreAuthorize("@ss.hasPermi('inventory:inv:list')")
    @GetMapping("/list")
    public TableDataInfo list(inventory inventory)
    {
        startPage();
        List<inventory> list = inventoryService.selectinventoryList(inventory);
        return getDataTable(list);
    }

    /**
     * 导出库存管理列表
     */
    @PreAuthorize("@ss.hasPermi('inventory:inv:export')")
    @Log(title = "库存管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, inventory inventory)
    {
        List<inventory> list = inventoryService.selectinventoryList(inventory);
        ExcelUtil<inventory> util = new ExcelUtil<inventory>(inventory.class);
        util.exportExcel(response, list, "库存管理数据");
    }

    /**
     * 获取库存管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('inventory:inv:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(inventoryService.selectinventoryById(id));
    }

    /**
     * 新增库存管理
     */
    @PreAuthorize("@ss.hasPermi('inventory:inv:add')")
    @Log(title = "库存管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody inventory inventory)
    {
        return toAjax(inventoryService.insertinventory(inventory));
    }

    /**
     * 修改库存管理
     */
    @PreAuthorize("@ss.hasPermi('inventory:inv:edit')")
    @Log(title = "库存管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody inventory inventory)
    {
        return toAjax(inventoryService.updateinventory(inventory));
    }

    /**
     * 删除库存管理
     */
    @PreAuthorize("@ss.hasPermi('inventory:inv:remove')")
    @Log(title = "库存管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(inventoryService.deleteinventoryByIds(ids));
    }
}
