package mou.terminal.repository.stockInfo;

import mou.terminal.domain.stockInfo.StockInfo;
import mou.terminal.domain.stockInfo.StockInfoNYSE;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StockInfoNYSErepo extends MongoRepository<StockInfoNYSE,String> {
    @Query(value = "{'symbol' : ?0}", fields = "{'stockName' : 1 , 'dailyInfo' : { '$slice' : -300 }}")
    StockInfo findBysymbol(String symbol);
}
