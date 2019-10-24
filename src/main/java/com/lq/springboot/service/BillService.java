package com.lq.springboot.service;

import com.lq.springboot.entities.Bill;
import com.lq.springboot.entities.BillProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BillService {

    List<BillProvider> getBills(Bill bill);

    BillProvider getById(Integer bid);

    void update(Bill bill);

    void save(Bill bill);

    void delete(Integer bid);
}
