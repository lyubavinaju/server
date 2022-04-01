package hw.server.controller;

import hw.server.storage.Storage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stocks")
public class StocksController {
    @RequestMapping("/put/{company}/{count}")
    public String putStocks(@PathVariable String company, @PathVariable Long count) {
        long currentPrice = Storage.putStocks(company, count);
        return "Stocks added. The price was " + currentPrice;
    }

    @RequestMapping("/pop/{company}/{count}/{price}")
    public String popStocks(@PathVariable String company, @PathVariable Long count, @PathVariable Long price) {
        try {
            Storage.popStocks(company, count, price);
            return "Stocks removed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping("/changePrice/{company}/{price}")
    public String changePrice(@PathVariable String company, @PathVariable Long price) {
        if (Storage.changePrice(company, price)) {
            return "Price changed.";
        }
        return "Something wrong";
    }

    @RequestMapping("/getPrice/{company}")
    public Long getPrice(@PathVariable String company) {
        return Storage.getPrice(company);
    }

    @RequestMapping("/getCount/{company}")
    public Long getCount(@PathVariable String company) {
        return Storage.getCount(company);
    }

}
