package com.jvmd.uownserver.model;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {
    private String username;
    private EOwn own;

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
