package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import models.HeartRate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import routes.HeartRateRoute;

@RestController
@RequestMapping("/sample/heartRate")
public class HeartRateController {

    private final AtomicLong counter = new AtomicLong();
    public List<HeartRate> list = new ArrayList<HeartRate>();

    @RequestMapping(method = RequestMethod.GET)
    public List<HeartRate> getAllHeartRates()
    {
        populateSampleData();
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public HeartRate addHeartRate(
            @RequestParam(value="date", defaultValue="0") String date,
            @RequestParam(value="rate", defaultValue="0") String rate
    )
    {
        HeartRate newSample = new HeartRate(counter.incrementAndGet(), Integer.parseInt(rate), new Date());
        return newSample;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public HeartRate updateHeartRate()
    {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteHeartRate()
    {

    }



    public void populateSampleData()
    {
        int[] rates = {65,68,76,54,57};
        Date date = new Date();
        for(int i = 0; i < 5; i++)
        {
            list.add(new HeartRate(counter.incrementAndGet(),rates[i], date ));
        }

    }
}
