package com.lq.springboot.service.impl;

import com.lq.springboot.entities.Bill;
import com.lq.springboot.entities.BillProvider;
import com.lq.springboot.mapper.BillMapper;
import com.lq.springboot.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Override
    public List<BillProvider> getBills(Bill bill) {
        return billMapper.getBills(bill);
    }

    @Override
    public BillProvider getById(Integer bid) {
        return billMapper.getById(bid);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public void update(Bill bill) {
        billMapper.update(bill);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public void save(Bill bill) {
        billMapper.save(bill);
    }

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public void delete(Integer bid) {
        billMapper.delete(bid);
    }
}
