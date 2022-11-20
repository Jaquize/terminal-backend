package mou.terminal.controller;

import mou.terminal.common.AdapterResponseEntity;
import mou.terminal.rdbmsDomain.Portfolio;
import mou.terminal.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ports")
public class PortPageMainController {

    private final PortfolioService portfolioService;

    PortPageMainController(PortfolioService portfolioService){
        this.portfolioService = portfolioService;
    }

    @RequestMapping(value = "/get")
    public ResponseEntity getPortfolioList(){
         return AdapterResponseEntity.success(portfolioService.findAllPortList());
    }

//    @RequestMapping(value = "/delete")
//    public ResponseEntity deletePortfolio(@RequestParam int id){
//        return AdapterResponseEntity.success(portfolioService.deleteByPortId(id));
//    }
}
