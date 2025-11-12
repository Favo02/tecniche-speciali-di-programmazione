import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Formatter {

    private final String separator;
    private final List<String> tokens;

    public Formatter(String separator) {
        this.separator = separator;
        this.tokens = new ArrayList<>();
    }

    @CFG(calls = { "List.add" })
    public void format(String f) {
        this.tokens.add(f);
    }

    @CFG(calls = { "List.stream", "List.collect" })
    public String write() {
        return this.tokens.stream().collect(Collectors.joining(separator));
    }

}
