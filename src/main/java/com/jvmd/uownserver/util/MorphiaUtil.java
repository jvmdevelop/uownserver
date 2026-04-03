package com.jvmd.uownserver.util;

import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import lombok.Getter;

public class MorphiaUtil {
    @Getter
    private static final Datastore datastore;

    static {
        datastore = Morphia.createDatastore(MongoClients.create());
        datastore.getMapper().mapPackage("com.jvmd.uownserver.model");
        datastore.ensureIndexes();
    }

}
