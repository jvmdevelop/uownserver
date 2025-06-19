package com.jvmd.uownserver.manager.abs;

import com.jvmd.uownserver.manager.abs.ObjectManager;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ObjectManagerImpl<T> implements ObjectManager<T> {

    @Getter
    private final List<Object> objects;

    public ObjectManagerImpl() {
        objects = new ArrayList<>();
    }

    @Override
    public void addObject(T object) {
        objects.add(object);
    }

    @Override
    public void removeObject(String key) {
        objects.remove(key);
    }
}
