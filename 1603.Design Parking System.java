class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        // Index 0 for big (1), 1 for medium (2), 2 for small (3)
        this.slots = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // carType is 1-indexed, so we subtract 1 for the array index
        if (slots[carType - 1] > 0) {
            slots[carType - 1]--;
            return true;
        }
        return false;
    }
}


/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
