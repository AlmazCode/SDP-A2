public class GameWorldKit {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║        GAME WORLD KIT            ║");
        System.out.println("╚══════════════════════════════════╝\n");

        System.out.println("┌──────────────────────────────────┐");
        System.out.println("│  PART A: Factory Method          │");
        System.out.println("└──────────────────────────────────┘");
        factorymethod.Main.main(args);

        System.out.println("\n┌──────────────────────────────────┐");
        System.out.println("│  PART B: Abstract Factory        │");
        System.out.println("└──────────────────────────────────┘");
        abstractfactory.Main.main(args);
    }
}
