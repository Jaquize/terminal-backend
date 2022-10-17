package mou.terminal.repository.stockInfo;

import mou.terminal.domain.stockInfo.StockInfo;
import mou.terminal.domain.stockInfo.StockInfoNASDAQ;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StockInfoNASDAQrepo extends MongoRepository<StockInfoNASDAQ,String> {
    @Query(value = "{'symbol' : ?0}", fields = "{'symboml' : 1 , 'dailyInfo' : { '$slice' : -300 }}")
    StockInfo findBysymbol(String symbol);
}
