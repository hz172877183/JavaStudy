package com.hz.study.demo.service.impl;

import com.hz.study.fileHandle.service.FileMoni;
import com.hz.study.demo.dao.firstDao;
import com.hz.study.demo.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstServiceImpl implements FirstService {

    @Autowired
    private firstDao firstDao;

    @Autowired
    private FileMoni fileMoni;

    @Override
    public String firstMethod() {
        return firstDao.firstSelect();
    }


}
