package com.androidapps.murad.nearby.api

import com.androidapps.murad.nearby.models.VenueData
import com.androidapps.murad.nearby.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<VenueNetworkEntity, VenueData> {
    override fun mapFromEntity(entity: VenueNetworkEntity): VenueData {
        return VenueData(
            placeName = entity.name,
            placeAddress = entity.address,
            placeDistance = entity.distance
        )
    }

    override fun mapToEntity(domainModel: VenueData): VenueNetworkEntity {
        return VenueNetworkEntity(
            name = domainModel.placeName,
            address = domainModel.placeAddress,
            distance = domainModel.placeDistance
        )
    }

    fun mapFromEntityList(entities: List<VenueNetworkEntity>): List<VenueData>{
        return entities.map { mapFromEntity(it) }
    }

}