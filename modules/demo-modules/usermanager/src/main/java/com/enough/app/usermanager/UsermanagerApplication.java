package com.enough.app.usermanager;

import com.supermap.data.Workspace;
import org.glassfish.jersey.server.ResourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@MapperScan("com.enough.app.usermanager.dao")
public class UsermanagerApplication {

    //初始化ResourceConfig
    @Bean
    public ResourceConfig resourceConfig() {
        return new ResourceConfig();
    }

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(UsermanagerApplication.class, args);
        File file = ResourceUtils.getFile("classpath:natives");
        addLibraryDir(file.getAbsolutePath());
        Workspace workspace = new Workspace();
        System.out.println("test");
    }

    private static void addLibraryDir(String libraryPath) {
        try {
            Field userPathsField = ClassLoader.class.getDeclaredField("usr_paths");
            userPathsField.setAccessible(true);
            String[] paths = (String[]) userPathsField.get(null);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.length; i++) {
                if (libraryPath.equals(paths[i])) {
                    continue;
                }
                sb.append(paths[i]).append(';');
            }
            sb.insert(0,libraryPath + ";");
            String rst = System.setProperty("java.library.path", sb.toString());
            final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
            sysPathsField.setAccessible(true);
            sysPathsField.set(null, null);
        }catch (Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }

    @Autowired
    private static AbstractEnvironment environment;

    public static void setEnv() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:natives");
        //        System.out.println(file.getAbsolutePath());
        //        System.setProperty("supermap.iobject.bin", file.getAbsolutePath());
        //        System.setProperty("java.library.path", file.getAbsolutePath() + ";" + System.getProperty("java.library.path"));
        //        System.out.println("path:::" + System.getProperty("java.library.path"));

        Map <String, Object> map = new HashMap <String, Object>();
        map.put("supermap.iobject.bin", file.getAbsolutePath());

        MapPropertySource mapPropertySource = new MapPropertySource("Path", map);
        environment.getPropertySources().addFirst(mapPropertySource);
        System.out.println(environment.getPropertySources().get("Path").getName());
        //Properties properties = System.getProperties();
        //        Iterator it = properties.entrySet().iterator();
        //        while (it.hasNext()) {
        //            Map.Entry entry = (Map.Entry) it.next();
        //            System.out.print(entry.getKey() + "=");
        //            System.out.println(entry.getValue());
        //
        //        }
        try {
            //删除explorer.exe进程
            //            Process proc2 = Runtime.getRuntime().exec("taskkill /F /IM explorer.exe");
            //            Thread.sleep(500);
            //            //重启explorer.exe进程
            //            Process proc3 = Runtime.getRuntime().exec("explorer.exe");
            //            System.out.println("=====SUCCESS=====");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

