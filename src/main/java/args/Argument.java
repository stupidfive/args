package args;

public class Argument {
    public final String flag;
    public final ArgumentType type;

    public Argument(String flag, ArgumentType type) {
        this.flag = flag;
        this.type = type;
    }
}
