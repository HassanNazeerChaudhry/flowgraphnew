package shared.messages.vertexcentric;

import java.io.Serializable;
import java.util.function.Supplier;
import shared.vertexcentric.VertexCentricComputation;



public class InstallComputationMsg<MsgType extends Serializable, OutputType extends Serializable>
        implements Serializable {
    private static final long serialVersionUID = -3747071909430802205L;

    private final String name;
    private final SerializableSupplier<VertexCentricComputation<MsgType, OutputType>> computationSupplier;

    public InstallComputationMsg(String name,
                                 SerializableSupplier<VertexCentricComputation<MsgType, OutputType>> computationSupplier) {
        super();
        this.name = name;
        this.computationSupplier = computationSupplier;
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