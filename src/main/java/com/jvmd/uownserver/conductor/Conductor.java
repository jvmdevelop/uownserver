package com.jvmd.uownserver.conductor;

public interface Conductor<T> {

    void accept(T object);

}
