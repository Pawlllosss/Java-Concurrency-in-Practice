package confinement;

public class UserContext {

    private static ThreadLocal<Long> currentSchemaId = new ThreadLocal<>();

    private UserContext() {}

    public static Long get() {
        return currentSchemaId.get();
    }

    public static void set(Long id) {
        currentSchemaId.set(id);
    }
}
