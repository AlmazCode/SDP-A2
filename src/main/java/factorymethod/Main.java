package factorymethod;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Part A: Factory Method ===\n");

        EnemySpawner[] spawners = {
            new GoblinSpawner(),
            new SkeletonSpawner(),
            new SlimeSpawner()
        };

        for (EnemySpawner spawner : spawners) {
            spawner.spawnAndAttack();
        }
    }
}
