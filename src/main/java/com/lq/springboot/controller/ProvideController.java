package com.lq.springboot.controller;

import com.lq.springboot.entities.Provider;
import com.lq.springboot.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author LinQing
 * @Description:
 * @date: 2019-10-20 15:54
 */
@Controller
public class ProvideController {

    @Autowired
    private ProviderService providerService;

    private static final Logger logger = LoggerFactory.getLogger(ProvideController.class);

    @GetMapping("/provider")
    public String list(Map<String,Object> map,Provider provider){
        logger.error("providerName" + provider);
        List<Provider> porviders = providerService.getPorviders(provider);
        map.put("provides",porviders);
        map.put("providerName",provider.getProviderName());
        return "provider/list";
    }

    @GetMapping("/provide/{pid}")
    public String view(@PathVariable("pid")Integer pid,@RequestParam(value = "type",defaultValue = "view") String type,Map<String,Object> map){
        Provider provider = providerService.getById(pid);
        map.put("provider",provider);
        return "provider/" + type;
    }

    @PostMapping("/provider/update")
    public String update(Provider provider){
        providerService.update(provider);
        return "redirect:/provider";
    }

    @GetMapping("/provider/add")
    public String toAddPage(){
        return "provider/add";
    }

    @PostMapping("/provider/add")
    public String add(Provider provider){
        providerService.save(provider);
        return "redirect:/provider";
    }

    @PostMapping("/provider/{pid}")
    public String add(@PathVariable("pid") Integer pid){
        providerService.delete(pid);
        return "redirect:/provider";
    }
}
