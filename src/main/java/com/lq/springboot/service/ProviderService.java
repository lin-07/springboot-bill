package com.lq.springboot.service;

import com.lq.springboot.entities.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> getPorviders(Provider provider);

    Provider getById(Integer pid);

    void update(Provider provider);

    void save(Provider provider);

    void delete(Integer pid);
}
