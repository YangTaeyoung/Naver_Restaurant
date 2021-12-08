package com.example.restaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {
    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity) {
        var optionalEntity = findById(entity.index);

        if(optionalEntity.isEmpty()){
            // db에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
        }
        else {
            // db에 데이터가 이미 있는 경우
            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);
            deleteById(preIndex);
            db.add(entity);
        }
        return entity;
    }

    @Override
    public void deleteById(int index) {
        var optionalEntity = findById(index);
        optionalEntity.ifPresent(db::remove);
    }

    @Override
    public List<T> findAll() {
        return db;
    }
}
