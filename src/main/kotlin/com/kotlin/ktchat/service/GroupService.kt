package com.kotlin.ktchat.service

import com.kotlin.ktchat.api.bean.request.SaveOrUpdateGroupReq
import com.kotlin.ktchat.enums.RestErrorCode
import com.kotlin.ktchat.entity.GroupInfo
import com.kotlin.ktchat.entity.UserContact
import com.kotlin.ktchat.enums.AddUserStatus
import com.kotlin.ktchat.enums.UserOrGroupType
import com.kotlin.ktchat.execption.BusinessException
import com.kotlin.ktchat.repository.GroupRepository
import com.kotlin.ktchat.repository.UserContactRepository
import com.kotlin.ktchat.repository.UserRepository
import com.kotlin.ktchat.utils.CodeUtils
import com.kotlin.ktchat.utils.DateTimeUtils
import com.kotlin.ktchat.utils.TokenUtil
import com.kotlin.ktchat.utils.UuIdUtils
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.transaction.Transactional

@Service
class GroupService(
        @Resource
        private val groupRepository: GroupRepository,
        @Resource
        private val tokenUtil: TokenUtil,
        @Resource
        private val userRepository: UserRepository,
        @Resource
        private val userContactRepository: UserContactRepository
) {
    @Transactional
    fun SaveOrUpdateGroup(req: SaveOrUpdateGroupReq): Any {
        val groupInfo = GroupInfo(
                groupId = UuIdUtils.generateUniqueId(),
                groupCode = CodeUtils.generateCode(UserOrGroupType.GROUP.code),
                groupName = req.groupName!!,
                groupOwnerId = req.userId!!,
                createTime = req.createTime!!,
                groupNotice = req.groupNotice,
                joinType = req.joinType!!,
                status = req.status!!
        )
        if(req.groupId != null){
            var count = req.userId.let { groupRepository.selectGroupCountByUserId(it) }
            if(count != null && count > 10){
                throw BusinessException(RestErrorCode.GROUP_COUNT_MANY)
            }
            val group = groupRepository.findByGroupId(req.groupId)
            if(group != null){
                group.apply {
                    groupName = req.groupName
                    groupNotice = req.groupNotice
                    joinType = req.joinType
                    status = req.status
                }
                return groupRepository.save(group)
            }
        }
        val saveGroup = groupRepository.save(groupInfo)
        val userContact = UserContact(
                userId = req.userId,
                contactId = saveGroup.id,
                contactType = UserOrGroupType.GROUP.code,
                createTime = LocalDateTime.now().format(DateTimeUtils.formatter),
                status = AddUserStatus.NORMAL.code
        )
        userContactRepository.save(userContact)
        return saveGroup
    }

    fun findGroupByGroupId(groupId: String): GroupInfo? {
        return groupRepository.findByGroupId(groupId)
    }

    fun findGroupByGroupCode(groupCode: String): GroupInfo? {
        return groupRepository.findByGroupCode(groupCode)
    }

    fun findGroupByUserId(userId: Long): List<GroupInfo> {
        return groupRepository.findGroupByUserId(userId)
    }
}