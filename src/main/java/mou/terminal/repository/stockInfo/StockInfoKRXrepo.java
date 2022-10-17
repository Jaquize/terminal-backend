package mou.terminal.repository.stockInfo;

import mou.terminal.domain.stockInfo.StockInfoKRX;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StockInfoKRXrepo extends MongoRepository<StockInfoKRX,String> {

    @Query(value = "{'stockName' : ?0}", fields = "{'stockName' : 1 , 'dailyInfo' : { '$slice' : -300 }}")
    StockInfoKRX findBystockName(String stockName);

}
