package com.kotlin.ktchat.api.controller

import com.kotlin.ktchat.api.bean.request.SaveOrUpdateGroupReq
import com.kotlin.ktchat.api.bean.response.ApiResponse
import com.kotlin.ktchat.service.GroupService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@RestController
@RequestMapping("/api/group")
@Api(tags = ["群组管理接口"])
class GroupController {
    @Resource
    private lateinit var groupService: GroupService
    
    @PostMapping("/save")
    @ApiOperation("创建或更新群组")
    fun saveOrUpdateGroup(@RequestBody req: SaveOrUpdateGroupReq): ApiResponse<Any> {
        val result = groupService.SaveOrUpdateGroup(req)
        return ApiResponse.success(result)
    }
    
    @GetMapping("/findByGroupId/{groupId}")
    @ApiOperation("根据群组ID查询群组")
    fun findGroupByGroupId(@PathVariable groupId: String): ApiResponse<Any> {
        val result = groupService.findGroupByGroupId(groupId)
        return ApiResponse.success(result)
    }
    
    @GetMapping("/findByGroupCode/{groupCode}")
    @ApiOperation("根据群组编码查询群组")
    fun findGroupByGroupCode(@PathVariable groupCode: String): ApiResponse<Any> {
        val result = groupService.findGroupByGroupCode(groupCode)
        return ApiResponse.success(result)
    }
    
    @GetMapping("/findByUserId/{userId}")
    @ApiOperation("查询用户加入的群组")
    fun findGroupByUserId(@PathVariable userId: Long): ApiResponse<Any> {
        val result = groupService.findGroupByUserId(userId)
        return ApiResponse.success(result)
    }
}