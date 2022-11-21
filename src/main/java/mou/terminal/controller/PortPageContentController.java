package mou.terminal.controller;

import mou.terminal.common.AdapterResponseEntity;
import mou.terminal.rdbmsDomain.Portfolio;
import mou.terminal.rdbmsDomain.PortfolioContent;
import mou.terminal.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/update")
    public ResponseEntity updatePortfolio(@RequestBody PortfolioContent portfolioContent){
        return AdapterResponseEntity.success(portfolioService.updatePort(portfolioContent));
    }

    @RequestMapping(value = "/add")
    public ResponseEntity addPortfolio(@RequestParam Portfolio portfolio,@RequestParam String content,@RequestParam String ref){
        return AdapterResponseEntity.success(portfolioService.addPort(portfolio,content,ref));
    }


}
