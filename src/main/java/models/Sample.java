package models;

import java.util.Date;

/**
 * Created by Aakash on 9/29/16.
 */
public class Sample {

    private final long id;
    private final int rate;
    private final Date date;

    public Sample(long id, int rate, Date date) {
        this.id = id;
        this.rate = rate;
        this.date = date;
    }

    public long getId() {
        return this.id;
    }

    public int getRate() {
        return this.rate;
    }

    public Date getDate() {
        return this.date;
    }
}
