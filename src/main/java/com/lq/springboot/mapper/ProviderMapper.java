package com.lq.springboot.mapper;

import com.lq.springboot.entities.Provider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProviderMapper {

    List<Provider> getPorviders(Provider provider);

    Provider getById(Integer pid);

    void update(Provider provider);

    void save(Provider provider);

    void delete(Integer pid);
}
