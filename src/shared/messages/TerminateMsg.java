package shared.messages;

import java.io.Serializable;

public class TerminateMsg implements Serializable {
    @Override
    public String toString() {
        return "TerminateMsg: no more inputs";
    }
}

