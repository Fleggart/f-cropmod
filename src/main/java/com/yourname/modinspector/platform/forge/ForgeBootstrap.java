package com.yourname.modinspector.platform.forge;

import com.yourname.modinspector.core.placeholder.CoreLogic;

public final class ForgeBootstrap {
    public static void bootstrap() {
        System.out.println("ForgeBootstrap running...");
        CoreLogic.run();
    }
}
