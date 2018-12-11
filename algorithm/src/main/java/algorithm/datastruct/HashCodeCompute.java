package algorithm.datastruct;

import java.util.Objects;

public class HashCodeCompute {
    private String s;

    public HashCodeCompute(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashCodeCompute)) return false;
        HashCodeCompute that = (HashCodeCompute) o;
        return Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}
