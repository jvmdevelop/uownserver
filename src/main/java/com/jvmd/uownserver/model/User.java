package com.jvmd.uownserver.model;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
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
    private EOwn own;

    private int kills;

    public void calcOwn() {
        if (kills == 0) {
            own = EOwn.GREEN;
        } else if (kills == 1) {
            own = EOwn.ORANGE;
        } else {
            own = EOwn.RED;
        }
    }

    @Override
    public String toString() {
        return """
                {
                "username": "%s",
                "own" : "%s"
                }
                """.formatted(username, own);
    }
}
