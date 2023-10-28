public class CompanyClient extends Client {
    public CompanyClient(String n) {
        super(n);
    }

    public String toString() {
        return "Company" + super.toString();
    }

    public float makeClaim(int polNum) {
        try {
            return getPolicy(polNum).handleClaim();
        } catch (Exception NullPointerException) {

        }
        return 0;
    }
}
