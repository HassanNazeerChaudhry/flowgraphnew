package shared.model;

public class PatternElement {
   private TemporalClause clause1;
   private FollowedBy followBy;
   private TemporalClause clause2;


    public PatternElement(TemporalClause clause1, FollowedBy followBy, TemporalClause clause2) {
        this.clause1 = clause1;
        this.followBy = followBy;
        this.clause2 = clause2;
    }

    public TemporalClause getClause1() {
        return clause1;
    }

    public FollowedBy getFollowBy() {
        return followBy;
    }

    public TemporalClause getClause2() {
        return clause2;
    }
}
