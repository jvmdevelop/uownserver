package com.jvmd.uownserver.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class DbConfig {
    private String url;
    private String username;
    private String dbPassword;
}