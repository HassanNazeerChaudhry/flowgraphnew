package shared.antlr4.pattern.patternSubParsers;

import master.PatternCallback;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import shared.FollowBy.FollowedBySolver;
import shared.antlr4.pattern.PatternBaseListener;
import shared.antlr4.pattern.PatternParser;
import shared.patterns.FollowedBy;
import shared.patterns.Trigger;


public class FollowedByParser extends PatternBaseListener {
    private FollowedBySolver followsBySolver;

    private FollowedByParser() {
        followsBySolver = new FollowedBySolver();
    }


    public static FollowedBy getFollowsBySolver (shared.antlr4.pattern.PatternParser.FollowedByContext ctx, Trigger trigger, PatternCallback callback) {
        FollowedBySolver followedBySolver = new FollowedBySolver();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk((ParseTreeListener) followedBySolver, ctx);

        FollowedBy followedBy = new FollowedBy(
                trigger,
                null,
                callback,
                followedBySolver
        );

        return followedBy;
    }

    @Override public void enterFollowedBy(PatternParser.FollowedByContext ctx) {
        this.followsBySolver= new FollowedBySolver();
    }

    @Override public void exitFollowedBy(PatternParser.FollowedByContext ctx) {



    }


}







