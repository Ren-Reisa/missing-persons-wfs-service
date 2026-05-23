package org.example.final2.service;

import org.example.final2.dao.ISzryDao;
import org.example.final2.entities.Szry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SzryServiceImpl implements ISzryService {
    @Autowired
    private ISzryDao szryDao;

    @Override
    public List<Szry> selectAll() {
        return szryDao.selectAll();
    }
}