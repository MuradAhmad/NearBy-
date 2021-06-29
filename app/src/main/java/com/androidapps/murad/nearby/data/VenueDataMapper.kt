package com.androidapps.murad.nearby.data

import com.androidapps.murad.nearby.models.VenueData
import com.androidapps.murad.nearby.utils.EntityMapper
import javax.inject.Inject

class VenueDataMapper
@Inject
constructor(): EntityMapper<VenueDataEntity, VenueData> {
    override fun mapFromEntity(entity: VenueDataEntity): VenueData {
        return VenueData(
            placeName = entity.name,
            placeAddress = entity.address,
            placeDistance = entity.distance
        )
    }

    override fun mapToEntity(domainModel: VenueData): VenueDataEntity {
        return VenueDataEntity(
            name = domainModel.placeName,
            address = domainModel.placeAddress,
            distance = domainModel.placeDistance
        )
    }

    fun mapFromEntityList(entities: List<VenueDataEntity>): List<VenueData> {
        return entities.map { mapFromEntity(it) }
    }

}