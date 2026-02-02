package Khoisama;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public class InsuranceClaim {

        //  Encapsulation + naming convention
        private String claimId;
        private double amount;
        private ClaimStatus claimStatus;

        //  Avoid magic strings by using enum
        public enum ClaimStatus {
            PENDING, APPROVED, REJECTED
        }

        // Constructor
        public InsuranceClaim(String id, double claimAmount) {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("claimId cannot be null/empty");
            }
            if (claimAmount <= 0) {
                throw new IllegalArgumentException("amount must be > 0");
            }
            this.claimId = id;
            this.amount = claimAmount;
            this.claimStatus = ClaimStatus.PENDING;
        }

        /**
         *  Only allow processing when current status is PENDING
         *  Only allow updating to APPROVED or REJECTED
         */
        public boolean processClaim(String statusUpdate) {
            if (claimStatus != ClaimStatus.PENDING) {
                return false;
            }

            if (statusUpdate == null) {
                return false;
            }

            statusUpdate = statusUpdate.trim();

            if (statusUpdate.equalsIgnoreCase("Approved")) {
                claimStatus = ClaimStatus.APPROVED;
                return true;
            } else if (statusUpdate.equalsIgnoreCase("Rejected")) {
                claimStatus = ClaimStatus.REJECTED;
                return true;
            }

            // invalid status
            return false;
        }

        /**
         *  Payout only when APPROVED
         */
        public double calculatePayout() {
            if (claimStatus == ClaimStatus.APPROVED) {
                return amount * 0.85; // 85% payout
            }
            return 0;
        }

        /**
         *  Validate amount
         */
        public void updateClaimAmount(double newAmount) {
            if (newAmount <= 0) {
                throw new IllegalArgumentException("newAmount must be > 0");
            }
            this.amount = newAmount;
        }

        //  Getters (for unit testing / usage)
        public String getClaimId() {
            return claimId;
        }

        public double getAmount() {
            return amount;
        }

        public ClaimStatus getClaimStatus() {
            return claimStatus;
        }
    }
    public void main() {
        InsuranceClaim c = new InsuranceClaim("C001", 1000);

        System.out.println(c.getClaimStatus());      // PENDING
        System.out.println(c.calculatePayout());     // 0.0

        System.out.println(c.processClaim("Approved")); // true
        System.out.println(c.getClaimStatus());         // APPROVED
        System.out.println(c.calculatePayout());        // 850.0
        }

    }

