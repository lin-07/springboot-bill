package com.lq.springboot.service.impl;

import com.lq.springboot.entities.Provider;
import com.lq.springboot.mapper.ProviderMapper;
import com.lq.springboot.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {


    @Autowired
    private ProviderMapper providerMapper;
    @Override
    public List<Provider> getPorviders(Provider provider) {
        return providerMapper.getPorviders(provider);
    }

    @Override
    public Provider getById(Integer pid) {
        return providerMapper.getById(pid);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public void update(Provider provider) {
        providerMapper.update(provider);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public void save(Provider provider) {
        providerMapper.save(provider);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public void delete(Integer pid) {
        providerMapper.delete(pid);
    }
}
