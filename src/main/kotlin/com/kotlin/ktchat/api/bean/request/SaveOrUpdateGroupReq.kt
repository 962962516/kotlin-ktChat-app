package com.kotlin.ktchat.api.bean.request

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("创建或更新群组请求")
data class SaveOrUpdateGroupReq(
    @ApiModelProperty("群组ID，新建时为空")
    val groupId: String? = null,
    
    @ApiModelProperty("群组名称", required = true)
    val groupName: String? = null,
    
    @ApiModelProperty("群主ID", required = true)
    val userId: Long? = null,
    
    @ApiModelProperty("创建时间", required = true)
    val createTime: String? = null,
    
    @ApiModelProperty("群公告")
    val groupNotice: String? = null,
    
    @ApiModelProperty("加入类型：1-需要验证，2-直接加入，3-仅邀请加入", required = true)
    val joinType: Int? = null,
    
    @ApiModelProperty("状态：1-正常，2-已解散", required = true)
    val status: Int? = null
)