package com.hz.study.fileHandle.listener;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 *
 */
public class FileListenerAdaptor extends FileAlterationListenerAdaptor  {

    public void onStart(FileAlterationObserver observer) {
        System.out.println("开始监听！");
        super.onStart(observer);
    }

    public void onDirectoryCreate(File directory) {
        System.out.println("监听到新建文件夹！");
        super.onDirectoryCreate(directory);
    }

    public void onDirectoryChange(File directory) {
    }

    public void onDirectoryDelete(File directory) {
    }

    public void onFileCreate(File file) {
        System.out.println("监听到文件创建！");
        super.onFileCreate(file);
    }

    public void onFileChange(File file) {
    }

    public void onFileDelete(File file) {
        System.out.println("监听到文件删除！");
        super.onFileDelete(file);
    }

    public void onStop(FileAlterationObserver observer) {
    }

}
