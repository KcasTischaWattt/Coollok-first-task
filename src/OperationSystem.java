import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

class OperationSystem {
    private static OperationSystem instance;
    private final String name;

    public static OperationSystem getInstance() {
        // Потокобезопасный синглетон
        // Не очень знаю, как правильно её реализовывваать, так что эту часть взял с хабра
        OperationSystem tempInstance = instance;
        if (tempInstance == null) {
            synchronized (OperationSystem.class) {
                tempInstance = instance;
                if (tempInstance == null) {
                    instance = new OperationSystem();
                }
            }
        } else {
            System.out.println("ОС уже запущена!");
        }
        return instance;
    }

    private OperationSystem() {
        System.out.println("Введите название операционной системы:");
        this.name = chooseSystemName();
        System.out.println("Вы успешно запустили " + name + "!");
    }

    private String chooseSystemName() {
        String osName = "";
        do {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            try {
                osName = br.readLine();
            } catch (Exception ex) {
                System.out.println("Ошибка при выборе системы. Повторите попытку.");
                System.out.println(ex.getMessage());
            }
        } while (Objects.equals(osName, ""));
        return osName;
    }

    public String getName() {
        return name;
    }

    public void doSmth() {
        // Дальнейшая логика работы операционки
    }
}