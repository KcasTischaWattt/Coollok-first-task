public class Main {
    public static void main(String[] args) {
        OperationSystem os = OperationSystem.getInstance();
        System.out.println(os.getName());
        os = OperationSystem.getInstance();
        System.out.println(os.getName());
    }
}

