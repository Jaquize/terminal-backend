package mou.terminal.domain.stockInfo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class DailyInfoKRX {

    private int val_open;
    private int val_close;
    private int val_high;
    private int val_low;
    private double vol;
    private Date stock_date;

    public String getStock_date() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(stock_date);
    }

}
