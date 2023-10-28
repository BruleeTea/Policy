public class IndividualClient extends Client {
    public IndividualClient(String n) {
        super(n);
    }

    public String toString() {
        return "Individual" + super.toString();
    }

    public float makeClaim(int polNum) {
        int makeClaim = 0;
        if (getPolicy(polNum) != null && getPolicy(polNum).isExpired() == false) {
            if (getPolicy(polNum) instanceof DepreciatingPolicy) {
                ((DepreciatingPolicy) getPolicy(polNum)).depreciate();
                return getPolicy(polNum).getAmount();
            }
            if (getPolicy(polNum) instanceof ExpiringPolicy) {
                return getPolicy(polNum).getAmount();


            } else {
                if (makeClaim < 1) {
                    makeClaim++;
                    float claim = getPolicy(polNum).getAmount();
                    cancelPolicy(polNum);
                    return claim;
                }
            }

        }
        return 0;
    }

}

