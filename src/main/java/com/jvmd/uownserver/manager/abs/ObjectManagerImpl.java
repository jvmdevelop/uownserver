package com.jvmd.uownserver.manager.abs;

import com.jvmd.uownserver.manager.abs.ObjectManager;
import com.jvmd.uownserver.util.MorphiaUtil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ObjectManagerImpl<T> implements ObjectManager<T> {

    @Override
    public void addObject(T object) {
        MorphiaUtil.getDatastore().save(object);
    }

    @Override
    public void removeObject(T object) {
        MorphiaUtil.getDatastore().delete(object);
    }
}
