import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ExpiringPolicy extends Policy {
    private Date expiryDate;

    public ExpiringPolicy(float a, Date e) {
        super(a);
        expiryDate = e;

    }

    public ExpiringPolicy(float a) {
        super(a);
        GregorianCalendar aCalendar = new GregorianCalendar();
        aCalendar.add(Calendar.YEAR, 1);
        expiryDate = aCalendar.getTime();
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String toString() {
        return "Expiring" + super.toString() + " expired on: " + new SimpleDateFormat("MMMM dd, yyyy (hh:mma)").format(getExpiryDate());
    }

    public boolean isExpired() {
        Date today = new Date();
        return getExpiryDate().before(today);
    }

    public float handleClaim() {
        if (isExpired() == false)
            return super.amount;
        return 0;
    }
}
