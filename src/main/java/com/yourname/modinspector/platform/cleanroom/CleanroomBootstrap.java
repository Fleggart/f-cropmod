package com.yourname.modinspector.platform.cleanroom;

import com.yourname.modinspector.core.CoreLogic;

public final class CleanroomBootstrap {
    public static void bootstrap() {
        System.out.println("CleanroomBootstrap running...");
        CoreLogic.run();
    }
}

