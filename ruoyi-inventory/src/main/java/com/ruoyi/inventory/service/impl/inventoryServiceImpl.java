package com.ruoyi.inventory.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.inventory.mapper.inventoryMapper;
import com.ruoyi.inventory.domain.inventory;
import com.ruoyi.inventory.service.IinventoryService;

/**
 * 库存管理Service业务层处理
 * 
 * @author lyb
 * @date 2023-02-21
 */
@Service
public class inventoryServiceImpl implements IinventoryService 
{
    @Autowired
    private inventoryMapper inventoryMapper;

    /**
     * 查询库存管理
     * 
     * @param id 库存管理主键
     * @return 库存管理
     */
    @Override
    public inventory selectinventoryById(Long id)
    {
        return inventoryMapper.selectinventoryById(id);
    }

    /**
     * 查询库存管理列表
     * 
     * @param inventory 库存管理
     * @return 库存管理
     */
    @Override
    public List<inventory> selectinventoryList(inventory inventory)
    {
        return inventoryMapper.selectinventoryList(inventory);
    }

    /**
     * 新增库存管理
     * 
     * @param inventory 库存管理
     * @return 结果
     */
    @Override
    public int insertinventory(inventory inventory)
    {
        return inventoryMapper.insertinventory(inventory);
    }

    /**
     * 修改库存管理
     * 
     * @param inventory 库存管理
     * @return 结果
     */
    @Override
    public int updateinventory(inventory inventory)
    {
        return inventoryMapper.updateinventory(inventory);
    }

    /**
     * 批量删除库存管理
     * 
     * @param ids 需要删除的库存管理主键
     * @return 结果
     */
    @Override
    public int deleteinventoryByIds(Long[] ids)
    {
        return inventoryMapper.deleteinventoryByIds(ids);
    }

    /**
     * 删除库存管理信息
     * 
     * @param id 库存管理主键
     * @return 结果
     */
    @Override
    public int deleteinventoryById(Long id)
    {
        return inventoryMapper.deleteinventoryById(id);
    }
}
