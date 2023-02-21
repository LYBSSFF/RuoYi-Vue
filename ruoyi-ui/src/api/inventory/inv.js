import request from '@/utils/request'

// 查询库存管理列表
export function listInv(query) {
  return request({
    url: '/inventory/inv/list',
    method: 'get',
    params: query
  })
}

// 查询库存管理详细
export function getInv(id) {
  return request({
    url: '/inventory/inv/' + id,
    method: 'get'
  })
}

// 新增库存管理
export function addInv(data) {
  return request({
    url: '/inventory/inv',
    method: 'post',
    data: data
  })
}

// 修改库存管理
export function updateInv(data) {
  return request({
    url: '/inventory/inv',
    method: 'put',
    data: data
  })
}

// 删除库存管理
export function delInv(id) {
  return request({
    url: '/inventory/inv/' + id,
    method: 'delete'
  })
}
