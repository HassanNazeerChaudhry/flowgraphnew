package shared.sequence;

import shared.patterns.Trigger;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Objects;

public class Parameter implements Serializable {

    private static final long serialVersionUID = -5307219757897710277L;
    private String id;
    private String value;

    public Parameter() {
    }


    public Parameter(@Nullable String id, @Nullable String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Event{" +
                ", id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parameter)) return false;
        Parameter parameter = (Parameter) o;
        return Objects.equals(id, parameter.id) &&
                Objects.equals(value, parameter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
