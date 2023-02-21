package com.ruoyi.inventory.service;

import java.util.List;
import com.ruoyi.inventory.domain.inventory;

/**
 * 库存管理Service接口
 * 
 * @author lyb
 * @date 2023-02-21
 */
public interface IinventoryService 
{
    /**
     * 查询库存管理
     * 
     * @param id 库存管理主键
     * @return 库存管理
     */
    public inventory selectinventoryById(Long id);

    /**
     * 查询库存管理列表
     * 
     * @param inventory 库存管理
     * @return 库存管理集合
     */
    public List<inventory> selectinventoryList(inventory inventory);

    /**
     * 新增库存管理
     * 
     * @param inventory 库存管理
     * @return 结果
     */
    public int insertinventory(inventory inventory);

    /**
     * 修改库存管理
     * 
     * @param inventory 库存管理
     * @return 结果
     */
    public int updateinventory(inventory inventory);

    /**
     * 批量删除库存管理
     * 
     * @param ids 需要删除的库存管理主键集合
     * @return 结果
     */
    public int deleteinventoryByIds(Long[] ids);

    /**
     * 删除库存管理信息
     * 
     * @param id 库存管理主键
     * @return 结果
     */
    public int deleteinventoryById(Long id);
}
