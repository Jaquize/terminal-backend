package mou.terminal.controller;

import mou.terminal.common.AdapterResponseEntity;
import mou.terminal.rdbmsDomain.PortfolioContent;
import mou.terminal.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/port")
public class PortPageContentController {

    private final PortfolioService portfolioService;

    PortPageContentController(PortfolioService portfolioService){
        this.portfolioService = portfolioService;
    }

    @RequestMapping(value = "/get")
    public ResponseEntity getPortfolio(int id){
        return AdapterResponseEntity.success(portfolioService.findPort(id));
    }

//    @RequestMapping(value = "/update")
//    public void updatePortfolio(){
//        return portfolioService.updatePort();
//    }
//
    @RequestMapping(value = "/add")
    public void addPortfolio(){
        portfolioService.addPort();
    }


}
