package com.hz.study.fileHandle.service;

import com.hz.study.fileHandle.listener.FileListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileMoni implements CommandLineRunner {

    public FileAlterationMonitor fileMonitor;

//    @Override
//    public void run() {
//        try {
//            String filepath = "G:\\ideaSpace\\JavaStudy\\file";
//            FileAlterationObserver fileObserver = new FileAlterationObserver(new File(filepath));
//            FileListenerAdaptor fileListener = new FileListenerAdaptor();
//            fileObserver.addListener(fileListener);
//            this.fileMonitor = new FileAlterationMonitor(50000,new FileAlterationObserver[]{fileObserver});
//            this.fileMonitor.start();
//            System.out.println("---------监听线程启动-----------");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void run(String... args) {
        try {
            String filepath = "G:\\ideaSpace\\JavaStudy\\file";
            FileAlterationObserver fileObserver = new FileAlterationObserver(new File(filepath));
            FileListenerAdaptor fileListener = new FileListenerAdaptor();
            fileObserver.addListener(fileListener);
            this.fileMonitor = new FileAlterationMonitor(50000,new FileAlterationObserver[]{fileObserver});
            this.fileMonitor.start();
            System.out.println("---------监听线程启动-----------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
