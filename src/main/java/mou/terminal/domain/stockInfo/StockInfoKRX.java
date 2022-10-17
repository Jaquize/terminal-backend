package mou.terminal.domain.stockInfo;

import lombok.Getter;
import lombok.Setter;
import mou.terminal.domain.SuperCondition;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "krxInfo")
public class StockInfoKRX {

    private String stockName;
    private List<DailyInfoKRX> dailyInfo;
}
