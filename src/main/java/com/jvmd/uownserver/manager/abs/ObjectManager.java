package com.jvmd.uownserver.manager.abs;

public interface ObjectManager<T> {
     void addObject(T object);
     void removeObject(String key);
}
