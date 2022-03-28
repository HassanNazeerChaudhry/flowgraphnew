package shared.messages.vertexcentric;

import java.io.Serializable;

public class ResultReplyMsg <ResultType> implements Serializable {

    private final ResultType result;

    public ResultReplyMsg(ResultType result) {
        super();
        this.result = result;
    }

    public ResultType getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "ResultReplyMsg [" + result + "]";
    }




}
