package com.jvmd.uownserver.controller;

import com.jvmd.uownserver.config.PluginConfig;
import io.javalin.Javalin;

public interface Controller {

    void setupRoutes(Javalin app);

    default String getName() {
        return this.getClass().getSimpleName();
    }

    default Javalin createApp() {
        return Javalin.create();
    }

    default void startServer() {
        Javalin app = createApp();
        setupRoutes(app);
        app.start(PluginConfig.getServerConfig().getPort());
    }
}