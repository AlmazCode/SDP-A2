package factorymethod;

public abstract class EnemySpawner {
    public abstract Enemy createEnemy();

    public void spawnAndAttack() {
        Enemy enemy = createEnemy();
        System.out.println("Spawning: " + enemy.getName());
        enemy.attack();
    }
}
