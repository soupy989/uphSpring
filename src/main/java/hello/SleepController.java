package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import models.HeartRate;
import models.Sleep;
import models.Step;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import routes.HeartRateRoute;

@RestController
@RequestMapping("/sample/sleep")
public class SleepController {

    private final AtomicLong counter = new AtomicLong();
    public List<Sleep> list = new ArrayList<Sleep>();

    @RequestMapping(method = RequestMethod.GET)
    public List<Sleep> getAllSleepSamples()
    {
        populateSampleData();
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Sleep addSleepSample(
            @RequestParam(value="date", defaultValue="0") String date,
            @RequestParam(value="rate", defaultValue="0") String rate
    )
    {
        Sleep newSample = new Sleep(counter.incrementAndGet(), Integer.parseInt(rate), new Date());
        return newSample;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Sleep updateSleep()
    {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteSleep()
    {

    }



    public void populateSampleData()
    {
        int[] rates = {65,68,76,54,57};
        Date date = new Date();
        for(int i = 0; i < 5; i++)
        {
            list.add(new Sleep(counter.incrementAndGet(),rates[i], date ));
        }

    }
}
