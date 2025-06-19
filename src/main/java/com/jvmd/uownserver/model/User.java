package com.jvmd.uownserver.model;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Reference;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity("users")
public class User {
    @Id
    private String username;
    @Reference
    private EOwn own;

    private int kills;

    public void calcOwn(){
        if (kills == 1){
            own = EOwn.ORANGE;
        }else if (kills >= 2){
            own = EOwn.RED;
        }
    }

    @Override
    public String toString() {
        return """
                {
                "username": "%s"
                "own" : "%s"
                }
                """.formatted(username, own);
    }
}
