import java.util.*;

public abstract class Client {
    private static final int MAX_POLICIES_PER_CLIENT = 10;

    private static int NEXT_CLIENT_ID = 1;

    private String name;
    private int id;
    protected Policy[] policies;
    protected int numPolicies;

    public Client(String n) {
        name = n;
        id = NEXT_CLIENT_ID++;
        policies = new Policy[MAX_POLICIES_PER_CLIENT];
        numPolicies = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Policy[] getPolicies() {
        return policies;
    }

    public int getNumPolicies() {
        return numPolicies;
    }

    public String toString() {
        return "Client " + this.getId() + this.getName();
    }

    public float totalCoverage() {
        float total = 0;
        for (int i = 0; i < getNumPolicies(); i++) {
            total += policies[i].getAmount();
        }
        return total;
    }

    public Policy addPolicy(Policy p) {
        if (numPolicies < MAX_POLICIES_PER_CLIENT) {
            policies[numPolicies++] = p;
        }
        return p;
    }

    public void openPolicyFor(float amt) {
        addPolicy(new Policy(amt));
    }

    public void openPolicyFor(float amt, float rate) {
        addPolicy(new DepreciatingPolicy(amt, rate));
    }

    public void openPolicyFor(float amt, Date expire) {
        addPolicy(new ExpiringPolicy(amt, expire));

    }

    public Policy getPolicy(int polNum) {

        for (int i = 0; i < numPolicies; i++) {
            if (policies[i].getPolicyNumber() == polNum)
                return policies[i];
        }

        return null;
    }

    public boolean cancelPolicy(int polNum) {
        if (getPolicy(polNum) == null)
            return false;
        else {

            for (int i = 0; i < numPolicies ; i++) {
                if (getPolicy(polNum) == policies[i]) {
                    policies[i] = policies[numPolicies-1];
                }

            }
            numPolicies--;
            return true;
        }

    }

    public abstract float makeClaim(int polNum);


}