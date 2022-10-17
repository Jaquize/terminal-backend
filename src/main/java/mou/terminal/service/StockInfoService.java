package mou.terminal.service;

import mou.terminal.domain.stockInfo.StockInfo;
import mou.terminal.domain.stockInfo.StockInfoKRX;
import mou.terminal.repository.stockInfo.StockInfoKRXrepo;
import mou.terminal.repository.stockInfo.StockInfoNASDAQrepo;
import mou.terminal.repository.stockInfo.StockInfoNYSErepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockInfoService {

    @Autowired
    StockInfoKRXrepo stockInfoRepository;
    @Autowired
    StockInfoNASDAQrepo stockInfoNASDAQrepo;
    @Autowired
    StockInfoNYSErepo stockInfoNYSErepo;

    public StockInfoKRX getDailyInfoKRX(String stockName){
        return stockInfoRepository.findBystockName(stockName);
    }

    public StockInfo getDailyInfo(String type, String symbol){

        if(type.equals("nasdaq")){
            return stockInfoNASDAQrepo.findBysymbol(symbol);
        }
        else if(type.equals("nyse")){
            return stockInfoNYSErepo.findBysymbol(symbol);
        }

        return null;

    }
}
