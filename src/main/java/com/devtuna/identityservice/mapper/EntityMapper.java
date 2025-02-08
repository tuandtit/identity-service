package com.devtuna.identityservice.mapper;

import java.util.List;

public interface EntityMapper<REQ, E, RES> {
    E toEntity(REQ dto);

    RES toDtoResponse(E entity);

    List<RES> toDtosResponse(List<E> entities);

    List<E> toEntities(List<REQ> dto);
}
