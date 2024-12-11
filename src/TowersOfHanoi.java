public class TowersOfHanoi {
    
    private Tower[] towers = new Tower[3];
    private int maxDisks;

    /**
     * constructor of the Towers of Hanoi Game
     * @param maxDisks value of maximum Disks on a Tower
     */
    public TowersOfHanoi(int maxDisks) {
        towers[0] = new Tower(maxDisks);
        towers[1] = new Tower(maxDisks);
        towers[2] = new Tower(maxDisks);
        this.maxDisks = maxDisks;

        for (int widthOfDisks = maxDisks; widthOfDisks > 0; widthOfDisks--) {
            towers[0].insertDisk(new Disk(widthOfDisks));
        }
    }

    /**
     * shows the Towers graphicly
     */
    public void showTowers() {
        for (int row = maxDisks - 1; row >= 0; row--) {
            for (int col = 0; col < 3; col++) {
                if (towers[col].getDisks()[row] != null) {
                    System.out.print("[ " + towers[col].getDisks()[row].width() + " ] ");
                } else {
                    System.out.print("[   ] ");
                }
            }
            System.out.println();
        }
    }

    /**
     * moves a Disk from one tower to another
     * @param startTower the tower you want to take the disk from
     * @param destinationTower the tower you want to place the disk on
     * @return if the move was successful
     */
    public boolean moveDisk(int startTower, int destinationTower) {
        startTower -= 1; destinationTower -= 1;
        if (startTower >= 0 && startTower <= 2 && destinationTower >= 0 && destinationTower <= 2) {
            return towers[startTower].moveDisk(towers[destinationTower]);
        }
        return false;
    }

    /**
     * checks if the Game is completed
     * @return if the Game is completed
     */
    public boolean isFinished() {
        for (int i = 0; i < maxDisks; i++) {
            if(towers[2].getDisks()[i] == null) {
                return false;
            }
        }
        return true;
    }

}
