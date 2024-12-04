package com.devtuna.identityservice.mapper;

import java.util.List;

public interface EntityMapper<D,E> {
    E toEntity(D dto);
    D toDto(E entity);
    List<D> toDtos(List<E> entities);
    List<E> toEntities(List<D> dto);

}
