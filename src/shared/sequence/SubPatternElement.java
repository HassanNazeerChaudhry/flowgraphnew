package shared.sequence;

import java.io.Serializable;
import java.util.HashMap;

public class SubPatternElement extends PatternElement implements Serializable {

    private final String detectOn;

    public SubPatternElement(PatternElement patternElement, String detectOn) {
        super(patternElement.getType(), patternElement.getPayload(), patternElement.getPosition());
        this.detectOn = detectOn;
    }

    public String getDetectOn() {
        return detectOn;
    }


}
