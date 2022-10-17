package mou.terminal.domain.stockInfo;

import lombok.Getter;
import lombok.Setter;
import mou.terminal.domain.SuperCondition;

import java.util.List;

@Getter
@Setter
public class StockInfo extends SuperCondition {

    private String symbol;
    private List<DailyInfo> dailyInfo;

}
