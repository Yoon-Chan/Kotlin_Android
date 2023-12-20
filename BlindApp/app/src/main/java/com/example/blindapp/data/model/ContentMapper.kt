package com.example.blindapp.data.model

import com.example.blindapp.data.model.dto.ContentDto
import com.example.blindapp.data.model.entity.ContentEntity
import com.example.blindapp.domain.model.Content
import java.util.Date

object ContentMapper {

    fun Content.toRequest() = ContentDto(
        id = id,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount
    )

    fun Content.toEntity() = ContentEntity(
        id = id ?: -1,
        title = title,
        content = content,
        category = category,
        likCount = likeCount,
        viewCount = viewCount,
        commentCount = commentCount,
        createDate = createDate ?: Date()
    )

    fun ContentDto.toContent() = Content(
        id = id ?: -1,
        title = title,
        content = content,
        likeCount = likeCount ?: 0,
        viewCount = viewCount ?: 0,
        commentCount = commentCount ?: 0,
        createDate = createdDate ?: Date(),
        category = category
    )

    fun ContentEntity.toContent() = Content(
        id = id,
        title = title,
        content = content,
        category = category,
        viewCount = viewCount,
        commentCount = commentCount,
        likeCount = likCount,
        createDate = createDate
    )

    fun ContentDto.toEntity() = ContentEntity(
        id = id ?: -1,
        content = content,
        category = category,
        title = title,
        likCount = likeCount ?: 0,
        viewCount = viewCount ?: 0,
        createDate = createdDate ?: Date(),
        commentCount = commentCount ?: 0
    )
}