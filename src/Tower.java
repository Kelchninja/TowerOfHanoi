public class Tower {

    private Disk[] disks;
    private int locationOfHighestEmpty;

    /**
     * constructor for the Tower-object
     * 
     * @param maxDisks value of the maximum count of possible Disks on a Tower
     *                 (between 1 and 8)
     */
    public Tower(int maxDisks) {
        if (maxDisks >= 1 && maxDisks <= 8) {
            disks = new Disk[maxDisks];
        } else {
            disks = new Disk[4];
        }
        locationOfHighestEmpty = 0;
    }

    /**
     * returns the array of Disks on the Tower-object
     * 
     * @return array of current Disks on the Tower-object
     */
    public Disk[] getDisks() {
        return disks;
    }

    /**
     * checks if a certain disk-object is contained in the list of disks,
     * which are on the current Tower-object.
     * 
     * @param disk the passed disk-object
     * @return if the passed disk-object is contained or not
     */
    public boolean containsDisk(Disk disk) {
        for (int i = 0; i < disks.length; i++) {
            if (disks[i] == disk) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks if there are no disks on the tower-object
     * 
     * @return if the tower is empty or not
     */
    private boolean isEmpty() {
        for (int i = 0; i < disks.length; i++) {
            if (disks[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * checks if a passed disk is allowed to be placed on the current Tower-object
     * 
     * @param disk the passed disk-object
     * @return if the disk-object can be placed on the current tower-object
     */
    private boolean isValidTower(Disk disk) {
        if (isEmpty() == false) {
            if (disks[locationOfHighestEmpty-1].width() > disk.width()) {
                return true;
            }
            return false;
        }
        return true;
    }

    /**
     * inserts a Disk-object in the highest possible spot on the tower-object
     * 
     * @param disk the passed disk-object that should be inserted
     * @return if disk was successfully inserted in the Tower-object
     */
    public boolean insertDisk(Disk disk) {
        if (isValidTower(disk) == true) {
            for (int i = 0; i < disks.length; i++) {
                if (disks[i] == null) {
                    disks[i] = disk;
                    locationOfHighestEmpty += 1;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean moveDisk(Tower other) {
        if (locationOfHighestEmpty > 0) {
            if (other.insertDisk(disks[locationOfHighestEmpty-1])) {
                disks[locationOfHighestEmpty-1] = null;
                locationOfHighestEmpty -= 1;
                return true;
            }
        }
        return false;
    }

/*    private int getHighestDisk() {
        for (int i = 0; i < disks.length; i++) {
            if (disks[i])
        }
    } */
}
