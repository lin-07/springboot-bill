package com.lq.springboot.mapper;

import com.lq.springboot.entities.Bill;
import com.lq.springboot.entities.BillProvider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BillMapper {

    List<BillProvider> getBills(Bill bill);

    BillProvider getById(Integer bid);

    void update(Bill bill);

    void save(Bill bill);

    void delete(Integer bid);
}
