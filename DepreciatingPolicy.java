public class DepreciatingPolicy extends Policy {
    private float rate;

    public DepreciatingPolicy(float a, float r) {
        super(a);
        rate = r;

    }

    public float getRate() {
        return rate;
    }

    public String toString() {
        return "Depreciating" + super.toString() + String.format(" rate %1.2f%%", getRate() * 100);
    }

    public boolean isExpired() {
        return super.isExpired();
    }

    public void depreciate() {
        super.amount = super.getAmount() - (super.amount * getRate());
    }

    public float handleClaim() {
        float beforeDepreciating = getAmount();
        amount = super.getAmount() - (super.amount * getRate());
        return beforeDepreciating;
    }
}
