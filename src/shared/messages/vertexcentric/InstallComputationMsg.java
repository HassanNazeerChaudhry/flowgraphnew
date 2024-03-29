package shared.messages.vertexcentric;

import java.io.Serializable;
import java.util.function.Supplier;

import shared.messages.GraphAction.GraphActions;
import shared.vertexcentric.VertexCentricComputation;



public class InstallComputationMsg<MsgType extends Serializable, OutputType extends Serializable> extends GraphActions {
    private static final long serialVersionUID = -3747071909430802205L;

    private String name;
    private SerializableSupplier<VertexCentricComputation<MsgType, OutputType>> computationSupplier;
    private String type;
    private int computationCoeff;

    public InstallComputationMsg(String name,
                                 SerializableSupplier<VertexCentricComputation<MsgType, OutputType>> computationSupplier, int computationCoeff) {
        super();
        this.name = name;
        this.computationSupplier = computationSupplier;
        this.type="compute";
        this.computationCoeff=computationCoeff;
    }

    public InstallComputationMsg() {
    }

    public int getComputationCoeff() {
        return computationCoeff;
    }

    public String getType() {
        return type;
    }

    public final String getName() {
        return name;
    }

    public final Supplier<VertexCentricComputation<MsgType, OutputType>> getComputationSupplier() {
        return computationSupplier;
    }

    @Override
    public String toString() {
        return "InstallComputationMsg [name=" + name + "]";
    }

}