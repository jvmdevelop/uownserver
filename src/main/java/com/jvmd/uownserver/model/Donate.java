package com.jvmd.uownserver.model;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@Entity("donates")
public class Donate {
    @Id
    private ObjectId id;
    private String nickname;
    private DonateType type;
}
