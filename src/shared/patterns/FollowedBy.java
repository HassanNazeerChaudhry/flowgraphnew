package shared.patterns;

import master.PatternCallback;
import org.jetbrains.annotations.Nullable;
import shared.AkkaMessages.FollowsByMsg;
import shared.FollowBy.FollowedBySolver;
import shared.PropertyHandler;

import java.io.Serializable;

public class FollowedBy extends Pattern {

    private FollowedBySolver FollowedBySolver;


    public FollowedBy(Trigger trigger, @Nullable String variablesToBeGenerated, PatternCallback transportLayer, FollowedBySolver FollowedBySolver) {
        super(trigger, variablesToBeGenerated, transportLayer);
        this.FollowedBySolver=FollowedBySolver;
    }

    @Override
    boolean startPatternLogic() {
        PropertyHandler.writeOnPerformanceLog("ENTERING_FOLLOWEDBY_"+ System.currentTimeMillis());
        transportLayer.sendToAllSlaves(new FollowsByMsg());
        transportLayer.becomeAwaitAckFromAll();
        return false;
    }

    @Override
    public boolean processMessage(@Nullable Serializable message) {
        PropertyHandler.writeOnPerformanceLog("EXITING_FOLLOWEDBY_"+ System.currentTimeMillis());
        return true;
    }
}










