package mou.terminal.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import mou.terminal.domain.boxing.Boxing;
import mou.terminal.domain.breakLow.BreakLow;
import mou.terminal.domain.breakTop.BreakTop;
import mou.terminal.domain.stockInfo.StockInfo;
import mou.terminal.domain.stockInfo.StockInfoKRX;
import mou.terminal.domain.volumeUp.VolumeUp;
import mou.terminal.service.*;
import mou.terminal.util.StringToUTCDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    BoxingService boxingService;
    @Autowired
    BreakLowService breakLowService;
    @Autowired
    BreakTopService breakTopService;
    @Autowired
    VolumeUpService volumeUpService;
    @Autowired
    StockInfoService stockInfoService;

    public List<VolumeUp> getVolumeUp(String type, String regDate) {

        return volumeUpService.volumeUpFindAll(type, StringToUTCDate.get(regDate));
    }

    public List<Boxing> getBoxingStatus(String type, int status, String statusDate, String regDate) {

        return boxingService.boxingStatusFindAllbyDate(type, status, StringToUTCDate.get(statusDate), StringToUTCDate.get(regDate));
    }

    public List<Boxing> getBoxingBoxStatus(String type, int boxing, int status, String regDate) {

        return boxingService.boxingBoxStatusFindAllbyDate(type, boxing, status, StringToUTCDate.get(regDate));

    }

    public List<BreakTop> getBreakBoxingTop(String type, int status, String statusDate) {

        return breakTopService.breakTopBoxing(type, status, StringToUTCDate.get(statusDate));
    }

    public List<BreakLow> getBreakBoxingLow(String type, String statusDate) {

        return breakLowService.breakLowBoxing(type,StringToUTCDate.get(statusDate));
    }

    public StockInfo getDailyInfo(String type, String symbol) {
        return stockInfoService.getDailyInfo(type,symbol);
    }

    public StockInfoKRX getDailyInfoKRX(String stockName) {
        return stockInfoService.getDailyInfoKRX(stockName);
    }

}

