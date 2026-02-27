package com.jvmd.uownserver.manager.abs;

import com.jvmd.uownserver.manager.abs.ObjectManager;
import com.jvmd.uownserver.util.MorphiaUtil;
import dev.morphia.Datastore;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ObjectManagerImpl<T> implements ObjectManager<T> {

    protected Datastore datastore = MorphiaUtil.getDatastore();

    @Override
    public void addObject(T object) {
        datastore.save(object);
    }

    @Override
    public void removeObject(T object) {
        datastore.delete(object);
    }
}
