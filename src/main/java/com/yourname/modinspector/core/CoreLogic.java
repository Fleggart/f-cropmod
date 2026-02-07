package com.yourname.modinspector.core;

import java.io.*;
import java.nio.file.*;
import java.util.jar.*;

public final class CoreLogic {

    public static void run() {
        System.out.println("Core logic executed!");

        Path modsDir = Paths.get("mods"); // 修改为你的 mods 文件夹路径
        if (!Files.exists(modsDir) || !Files.isDirectory(modsDir)) {
            System.out.println("mods directory not found: " + modsDir.toAbsolutePath());
            return;
        }

        try {
            Files.list(modsDir)
                .filter(path -> path.toString().endsWith(".jar"))
                .forEach(CoreLogic::processJar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processJar(Path jarPath) {
        System.out.println("\nScanning mod: " + jarPath.getFileName());

        try (JarFile jar = new JarFile(jarPath.toFile())) {
            // 1. 读取 Forge mods.toml
            JarEntry tomlEntry = jar.getJarEntry("META-INF/mods.toml");
            if (tomlEntry != null) {
                try (InputStream in = jar.getInputStream(tomlEntry);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

                    String line;
                    String modid = "";
                    String name = "";
                    String version = "";
                    String license = "";

                    while ((line = reader.readLine()) != null) {
                        line = line.trim();
                        if (line.startsWith("modid")) {
                            modid = line.split("=")[1].replace("\"","").trim();
                        } else if (line.startsWith("name")) {
                            name = line.split("=")[1].replace("\"","").trim();
                        } else if (line.startsWith("version")) {
                            version = line.split("=")[1].replace("\"","").trim();
                        } else if (line.startsWith("license")) {
                            license = line.split("=")[1].replace("\"","").trim();
                        }
                    }

                    System.out.println("modid: " + modid);
                    System.out.println("name: " + name);
                    System.out.println("version: " + version);
                    System.out.println("license: " + license);

                    checkOpenSource(license);
                }
            }

            // 可以扩展 mcmod.info 等老版本 TOML 或 JSON，方法类似

        } catch (IOException e) {
            System.out.println("Failed to read jar: " + jarPath.getFileName());
            e.printStackTrace();
        }
    }

    private static void checkOpenSource(String license) {
        if (license == null || license.isEmpty()) {
            System.out.println("License unknown");
            return;
        }

        String upper = license.toUpperCase();
        if (upper.contains("MIT") || upper.contains("GPL") || upper.contains("APACHE") || upper.contains("BSD")) {
            System.out.println("This mod appears to be open source: " + license);
        } else {
            System.out.println("This mod license is proprietary or unknown: " + license);
        }
    }
}
