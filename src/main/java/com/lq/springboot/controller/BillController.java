package com.lq.springboot.controller;

import com.lq.springboot.entities.Bill;
import com.lq.springboot.entities.BillProvider;
import com.lq.springboot.entities.Provider;
import com.lq.springboot.service.BillService;
import com.lq.springboot.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private ProviderService providerService;

    Logger logger = LoggerFactory.getLogger(BillController.class);

    @GetMapping("/bills")
    public String list(Bill bill, Map<String,Object> map){
        logger.error("-------------" + bill);
        List<BillProvider> bills = billService.getBills(bill);
        List<Provider> porviders = providerService.getPorviders(null);
        map.put("bills",bills);
        map.put("bill", bill);
        map.put("providers",porviders);
        return "bill/list";
    }

    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid")Integer bid, @RequestParam(value = "type",defaultValue = "view") String type, Map<String,Object> map){
        BillProvider billProvider = billService.getById(bid);
        // 进入update页面需要获取供应商下拉选数据
        if(type.equals("update")){
            List<Provider> porviders = providerService.getPorviders(null);
            map.put("providers",porviders);
        }
        map.put("billProvider",billProvider);
        return "bill/" + type;
    }

    @GetMapping("/bill/add")
    public String toAdd(Map<String,Object> map){
        List<Provider> porviders = providerService.getPorviders(null);
        map.put("providers",porviders);
        return "bill/add";
    }

    @PostMapping("/bill/update")
    public String update(Bill bill){
        billService.update(bill);
        return "redirect:/bills";
    }

    @PostMapping("/bill/add")
    public String add(Bill bill){
        billService.save(bill);
        return "redirect:/bills";
    }

    @PostMapping("/bill/{bid}")
    public String delete(@PathVariable("bid") Integer bid){
        billService.delete(bid);
        return "redirect:/bills";
    }
}
