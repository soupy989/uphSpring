package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import models.HeartRate;
import models.Step;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import routes.HeartRateRoute;

@RestController
@RequestMapping("/sample/step")
public class StepController {

    private final AtomicLong counter = new AtomicLong();
    public List<Step> list = new ArrayList<Step>();

    @RequestMapping(method = RequestMethod.GET)
    public List<Step> getAllHeartRates()
    {
        populateSampleData();
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Step addStep(
            @RequestParam(value="date", defaultValue="0") String date,
            @RequestParam(value="rate", defaultValue="0") String rate
    )
    {
        Step newSample = new Step(counter.incrementAndGet(), Integer.parseInt(rate), new Date());
        return newSample;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Step updateStep()
    {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteStep()
    {

    }



    public void populateSampleData()
    {
        int[] rates = {65,68,76,54,57};
        Date date = new Date();
        for(int i = 0; i < 5; i++)
        {
            list.add(new Step(counter.incrementAndGet(),rates[i], date ));
        }

    }
}
