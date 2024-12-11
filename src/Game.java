public class Game {

    public static void main(String[] args) {
        TowersOfHanoi HanoiGame = new TowersOfHanoi(In.readInt("How many Disks do you want? (max. 8): "));

        int startTower;
        int destinationTower;

        do {
            HanoiGame.showTowers();

            startTower = In.readInt("Which Tower would you like to take the highest Disk from? (1/2/3): ");
            destinationTower = In.readInt("On which Tower would you like to put the Disk on? (1/2/3): ");

            HanoiGame.moveDisk(startTower, destinationTower);
        } while (HanoiGame.isFinished() == false);

        System.out.println("GEWONNEN YEAAA");
        HanoiGame.showTowers();
    }
}
