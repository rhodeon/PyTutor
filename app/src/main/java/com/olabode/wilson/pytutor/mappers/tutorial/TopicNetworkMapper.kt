package com.olabode.wilson.pytutor.mappers.tutorial

import com.olabode.wilson.pytutor.models.Topic
import com.olabode.wilson.pytutor.models.remote.tutorial.TopicResponse
import com.olabode.wilson.pytutor.utils.EntityMapper
import javax.inject.Inject

/**
 *   Created by OLABODE WILSON on 9/18/20.
 */
class TopicNetworkMapper @Inject constructor() :
        EntityMapper<TopicResponse, Topic> {

    fun mapFromEntityList(entities: List<TopicResponse>): List<Topic> {
        return entities.map {
            mapFromEntity(it)
        }
    }

    override fun mapFromEntity(entity: TopicResponse): Topic {
        return Topic(
                orderKey = entity.orderKey,
                topicId = entity.topicId,
                title = entity.title,
                description = entity.description,
                isCompleted = entity.completed,
                isLocked = entity.locked,
                noOfPages = entity.noOfPages,
                numOfStars = entity.stars,
                isLastTopic = entity.lastTopic,
                nextTopicsId = entity.nextTopicId
        )
    }

    override fun mapToEntity(domainModel: Topic): TopicResponse {
        return TopicResponse(
                orderKey = domainModel.orderKey,
                topicId = domainModel.topicId,
                title = domainModel.title,
                description = domainModel.description,
                completed = domainModel.isCompleted,
                locked = domainModel.isLocked,
                noOfPages = domainModel.noOfPages,
                stars = domainModel.numOfStars,
                nextTopicId = domainModel.nextTopicsId,
                lastTopic = domainModel.isLastTopic
        )
    }
}