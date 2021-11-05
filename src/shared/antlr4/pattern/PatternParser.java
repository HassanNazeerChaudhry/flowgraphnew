// Generated from /Users/chaudhryhassan/Desktop/FlowGraph-main/src/shared/antlr4/pattern/Pattern.g4 by ANTLR 4.9.1

 package shared.antlr4.pattern;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PatternParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, Operator=37, NOT=38, 
		AND=39, OR=40, DOT=41, Litterals=42, Timeunit=43, Number=44, Skip=45, 
		Edge=46, Vertex=47, Add=48, Delete=49, Modify=50;
	public static final int
		RULE_patternEntry = 0, RULE_temporalPattern = 1, RULE_graphModificationEvent = 2, 
		RULE_temporalClause = 3, RULE_graphProcessing = 4, RULE_computation = 5, 
		RULE_selection = 6, RULE_partition = 7, RULE_extraction = 8, RULE_evaluation = 9, 
		RULE_computationFunction = 10, RULE_computationReturnVariables = 11, RULE_computationParameters = 12, 
		RULE_aliasedParameter = 13, RULE_followedBy = 14, RULE_modifier = 15, 
		RULE_change = 16, RULE_selectionFunction = 17, RULE_edgeSelection = 18, 
		RULE_logicalExpression = 19, RULE_booleanAndExpression = 20, RULE_unaryExpression = 21, 
		RULE_primaryExpression = 22, RULE_boolPredicate = 23, RULE_operands = 24, 
		RULE_partitionFunction = 25, RULE_operationFunction = 26, RULE_oneFieldOperationAlias = 27, 
		RULE_emission = 28, RULE_temporalVariable = 29, RULE_functionName = 30, 
		RULE_label = 31, RULE_value = 32, RULE_variable = 33, RULE_fireEvent = 34, 
		RULE_tupleField = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"patternEntry", "temporalPattern", "graphModificationEvent", "temporalClause", 
			"graphProcessing", "computation", "selection", "partition", "extraction", 
			"evaluation", "computationFunction", "computationReturnVariables", "computationParameters", 
			"aliasedParameter", "followedBy", "modifier", "change", "selectionFunction", 
			"edgeSelection", "logicalExpression", "booleanAndExpression", "unaryExpression", 
			"primaryExpression", "boolPredicate", "operands", "partitionFunction", 
			"operationFunction", "oneFieldOperationAlias", "emission", "temporalVariable", 
			"functionName", "label", "value", "variable", "fireEvent", "tupleField"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.g()'", "'.compute('", "')'", "'.select('", "'.SubGraphByV('", 
			"'.SubGraphByE('", "'.extractV('", "','", "'.extractE('", "'.evaluate('", 
			"', ['", "']'", "'='", "'.followedBy('", "'EDGE['", "'('", "'.map'", 
			"'.flatmap'", "'.reduce'", "'.filter'", "'.groupby'", "'.Merge'", "'.collect'", 
			"'.avg'", "'.max'", "'.min'", "'.count'", "'.select'", "'.emit('", "'ago'", 
			"'every'", "'within'", "'''", "'$'", "'\"'", null, "'not'", "'and'", 
			"'or'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "Operator", "NOT", "AND", "OR", "DOT", "Litterals", "Timeunit", 
			"Number", "Skip", "Edge", "Vertex", "Add", "Delete", "Modify"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pattern.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PatternParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PatternEntryContext extends ParserRuleContext {
		public GraphModificationEventContext graphModificationEvent() {
			return getRuleContext(GraphModificationEventContext.class,0);
		}
		public TemporalPatternContext temporalPattern() {
			return getRuleContext(TemporalPatternContext.class,0);
		}
		public PatternEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterPatternEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitPatternEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitPatternEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternEntryContext patternEntry() throws RecognitionException {
		PatternEntryContext _localctx = new PatternEntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_patternEntry);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Edge:
			case Vertex:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				graphModificationEvent();
				}
				break;
			case T__1:
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				temporalPattern();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalPatternContext extends ParserRuleContext {
		public List<TemporalClauseContext> temporalClause() {
			return getRuleContexts(TemporalClauseContext.class);
		}
		public TemporalClauseContext temporalClause(int i) {
			return getRuleContext(TemporalClauseContext.class,i);
		}
		public TerminalNode EOF() { return getToken(PatternParser.EOF, 0); }
		public List<FollowedByContext> followedBy() {
			return getRuleContexts(FollowedByContext.class);
		}
		public FollowedByContext followedBy(int i) {
			return getRuleContext(FollowedByContext.class,i);
		}
		public TemporalPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterTemporalPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitTemporalPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitTemporalPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalPatternContext temporalPattern() throws RecognitionException {
		TemporalPatternContext _localctx = new TemporalPatternContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_temporalPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			temporalClause();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(77);
				followedBy();
				setState(78);
				temporalClause();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(T__0);
			setState(86);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphModificationEventContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PatternParser.EOF, 0); }
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public List<ChangeContext> change() {
			return getRuleContexts(ChangeContext.class);
		}
		public ChangeContext change(int i) {
			return getRuleContext(ChangeContext.class,i);
		}
		public GraphModificationEventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphModificationEvent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterGraphModificationEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitGraphModificationEvent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitGraphModificationEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphModificationEventContext graphModificationEvent() throws RecognitionException {
		GraphModificationEventContext _localctx = new GraphModificationEventContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_graphModificationEvent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88);
				modifier();
				setState(89);
				change();
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Edge || _la==Vertex );
			setState(95);
			match(T__0);
			setState(96);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalClauseContext extends ParserRuleContext {
		public GraphProcessingContext graphProcessing() {
			return getRuleContext(GraphProcessingContext.class,0);
		}
		public ExtractionContext extraction() {
			return getRuleContext(ExtractionContext.class,0);
		}
		public EvaluationContext evaluation() {
			return getRuleContext(EvaluationContext.class,0);
		}
		public List<OperationFunctionContext> operationFunction() {
			return getRuleContexts(OperationFunctionContext.class);
		}
		public OperationFunctionContext operationFunction(int i) {
			return getRuleContext(OperationFunctionContext.class,i);
		}
		public TemporalClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterTemporalClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitTemporalClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitTemporalClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalClauseContext temporalClause() throws RecognitionException {
		TemporalClauseContext _localctx = new TemporalClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_temporalClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			graphProcessing();
			setState(99);
			extraction();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) {
				{
				{
				setState(100);
				operationFunction();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
			evaluation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GraphProcessingContext extends ParserRuleContext {
		public GraphProcessingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphProcessing; }
	 
		public GraphProcessingContext() { }
		public void copyFrom(GraphProcessingContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GraphProcTempContext extends GraphProcessingContext {
		public TemporalVariableContext temporalVariable() {
			return getRuleContext(TemporalVariableContext.class,0);
		}
		public List<ComputationContext> computation() {
			return getRuleContexts(ComputationContext.class);
		}
		public ComputationContext computation(int i) {
			return getRuleContext(ComputationContext.class,i);
		}
		public List<SelectionContext> selection() {
			return getRuleContexts(SelectionContext.class);
		}
		public SelectionContext selection(int i) {
			return getRuleContext(SelectionContext.class,i);
		}
		public List<PartitionContext> partition() {
			return getRuleContexts(PartitionContext.class);
		}
		public PartitionContext partition(int i) {
			return getRuleContext(PartitionContext.class,i);
		}
		public GraphProcTempContext(GraphProcessingContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterGraphProcTemp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitGraphProcTemp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitGraphProcTemp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GraphProcContext extends GraphProcessingContext {
		public List<ComputationContext> computation() {
			return getRuleContexts(ComputationContext.class);
		}
		public ComputationContext computation(int i) {
			return getRuleContext(ComputationContext.class,i);
		}
		public List<SelectionContext> selection() {
			return getRuleContexts(SelectionContext.class);
		}
		public SelectionContext selection(int i) {
			return getRuleContext(SelectionContext.class,i);
		}
		public List<PartitionContext> partition() {
			return getRuleContexts(PartitionContext.class);
		}
		public PartitionContext partition(int i) {
			return getRuleContext(PartitionContext.class,i);
		}
		public GraphProcContext(GraphProcessingContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterGraphProc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitGraphProc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitGraphProc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphProcessingContext graphProcessing() throws RecognitionException {
		GraphProcessingContext _localctx = new GraphProcessingContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_graphProcessing);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				_localctx = new GraphProcContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(T__1);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) {
					{
					setState(112);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__2:
						{
						setState(109);
						computation();
						}
						break;
					case T__4:
						{
						setState(110);
						selection();
						}
						break;
					case T__5:
					case T__6:
						{
						setState(111);
						partition();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__34:
				_localctx = new GraphProcTempContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				temporalVariable();
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) {
					{
					setState(121);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__2:
						{
						setState(118);
						computation();
						}
						break;
					case T__4:
						{
						setState(119);
						selection();
						}
						break;
					case T__5:
					case T__6:
						{
						setState(120);
						partition();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComputationContext extends ParserRuleContext {
		public ComputationFunctionContext computationFunction() {
			return getRuleContext(ComputationFunctionContext.class,0);
		}
		public ComputationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterComputation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitComputation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitComputation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComputationContext computation() throws RecognitionException {
		ComputationContext _localctx = new ComputationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_computation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__2);
			setState(129);
			computationFunction();
			setState(130);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionContext extends ParserRuleContext {
		public SelectionFunctionContext selectionFunction() {
			return getRuleContext(SelectionFunctionContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__4);
			setState(133);
			selectionFunction();
			setState(134);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionContext extends ParserRuleContext {
		public PartitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition; }
	 
		public PartitionContext() { }
		public void copyFrom(PartitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PartByVContext extends PartitionContext {
		public PartitionFunctionContext partitionFunction() {
			return getRuleContext(PartitionFunctionContext.class,0);
		}
		public PartByVContext(PartitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterPartByV(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitPartByV(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitPartByV(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PartByEContext extends PartitionContext {
		public PartitionFunctionContext partitionFunction() {
			return getRuleContext(PartitionFunctionContext.class,0);
		}
		public PartByEContext(PartitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterPartByE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitPartByE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitPartByE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionContext partition() throws RecognitionException {
		PartitionContext _localctx = new PartitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_partition);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new PartByVContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(T__5);
				setState(137);
				partitionFunction();
				setState(138);
				match(T__3);
				}
				break;
			case T__6:
				_localctx = new PartByEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				match(T__6);
				setState(141);
				partitionFunction();
				setState(142);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtractionContext extends ParserRuleContext {
		public ExtractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extraction; }
	 
		public ExtractionContext() { }
		public void copyFrom(ExtractionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExtractByEContext extends ExtractionContext {
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public ExtractByEContext(ExtractionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterExtractByE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitExtractByE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitExtractByE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExtractByVContext extends ExtractionContext {
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public ExtractByVContext(ExtractionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterExtractByV(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitExtractByV(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitExtractByV(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtractionContext extraction() throws RecognitionException {
		ExtractionContext _localctx = new ExtractionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_extraction);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				_localctx = new ExtractByVContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(T__7);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Litterals) {
					{
					setState(147);
					label();
					}
				}

				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(150);
					match(T__8);
					setState(151);
					label();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				match(T__3);
				}
				break;
			case T__9:
				_localctx = new ExtractByEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(T__9);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Litterals) {
					{
					setState(159);
					label();
					}
				}

				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(162);
					match(T__8);
					setState(163);
					label();
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(169);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvaluationContext extends ParserRuleContext {
		public TerminalNode Operator() { return getToken(PatternParser.Operator, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public FireEventContext fireEvent() {
			return getRuleContext(FireEventContext.class,0);
		}
		public EvaluationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterEvaluation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitEvaluation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitEvaluation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvaluationContext evaluation() throws RecognitionException {
		EvaluationContext _localctx = new EvaluationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_evaluation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__10);
			setState(173);
			match(Operator);
			setState(174);
			match(T__8);
			setState(175);
			value();
			setState(176);
			match(T__8);
			setState(177);
			fireEvent();
			setState(178);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComputationFunctionContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public ComputationReturnVariablesContext computationReturnVariables() {
			return getRuleContext(ComputationReturnVariablesContext.class,0);
		}
		public ComputationParametersContext computationParameters() {
			return getRuleContext(ComputationParametersContext.class,0);
		}
		public ComputationFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computationFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterComputationFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitComputationFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitComputationFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComputationFunctionContext computationFunction() throws RecognitionException {
		ComputationFunctionContext _localctx = new ComputationFunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_computationFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			functionName();
			setState(181);
			match(T__8);
			setState(182);
			computationReturnVariables();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(183);
				computationParameters();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComputationReturnVariablesContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ComputationReturnVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computationReturnVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterComputationReturnVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitComputationReturnVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitComputationReturnVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComputationReturnVariablesContext computationReturnVariables() throws RecognitionException {
		ComputationReturnVariablesContext _localctx = new ComputationReturnVariablesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_computationReturnVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			variable();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(187);
				match(T__8);
				setState(188);
				variable();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComputationParametersContext extends ParserRuleContext {
		public List<AliasedParameterContext> aliasedParameter() {
			return getRuleContexts(AliasedParameterContext.class);
		}
		public AliasedParameterContext aliasedParameter(int i) {
			return getRuleContext(AliasedParameterContext.class,i);
		}
		public ComputationParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_computationParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterComputationParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitComputationParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitComputationParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComputationParametersContext computationParameters() throws RecognitionException {
		ComputationParametersContext _localctx = new ComputationParametersContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_computationParameters);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__11);
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(195);
					aliasedParameter();
					setState(196);
					match(T__8);
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(203);
			aliasedParameter();
			setState(204);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasedParameterContext extends ParserRuleContext {
		public TerminalNode Litterals() { return getToken(PatternParser.Litterals, 0); }
		public OperandsContext operands() {
			return getRuleContext(OperandsContext.class,0);
		}
		public AliasedParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasedParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterAliasedParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitAliasedParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitAliasedParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasedParameterContext aliasedParameter() throws RecognitionException {
		AliasedParameterContext _localctx = new AliasedParameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_aliasedParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(Litterals);
			setState(207);
			match(T__13);
			setState(208);
			operands();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FollowedByContext extends ParserRuleContext {
		public TemporalVariableContext temporalVariable() {
			return getRuleContext(TemporalVariableContext.class,0);
		}
		public FollowedByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_followedBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterFollowedBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitFollowedBy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitFollowedBy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FollowedByContext followedBy() throws RecognitionException {
		FollowedByContext _localctx = new FollowedByContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_followedBy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__14);
			setState(211);
			temporalVariable();
			setState(212);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode Edge() { return getToken(PatternParser.Edge, 0); }
		public TerminalNode Vertex() { return getToken(PatternParser.Vertex, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_la = _input.LA(1);
			if ( !(_la==Edge || _la==Vertex) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChangeContext extends ParserRuleContext {
		public TerminalNode Add() { return getToken(PatternParser.Add, 0); }
		public TerminalNode Delete() { return getToken(PatternParser.Delete, 0); }
		public TerminalNode Modify() { return getToken(PatternParser.Modify, 0); }
		public ChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_change; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitChange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitChange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangeContext change() throws RecognitionException {
		ChangeContext _localctx = new ChangeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_change);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Delete) | (1L << Modify))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionFunctionContext extends ParserRuleContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public EdgeSelectionContext edgeSelection() {
			return getRuleContext(EdgeSelectionContext.class,0);
		}
		public SelectionFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterSelectionFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitSelectionFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitSelectionFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionFunctionContext selectionFunction() throws RecognitionException {
		SelectionFunctionContext _localctx = new SelectionFunctionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_selectionFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			logicalExpression();
			setState(219);
			edgeSelection();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EdgeSelectionContext extends ParserRuleContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public EdgeSelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeSelection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterEdgeSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitEdgeSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitEdgeSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeSelectionContext edgeSelection() throws RecognitionException {
		EdgeSelectionContext _localctx = new EdgeSelectionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_edgeSelection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__15);
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
			case T__33:
			case T__34:
			case NOT:
			case Litterals:
				{
				setState(222);
				logicalExpression();
				}
				break;
			case T__12:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(226);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalExpressionContext extends ParserRuleContext {
		public List<BooleanAndExpressionContext> booleanAndExpression() {
			return getRuleContexts(BooleanAndExpressionContext.class);
		}
		public BooleanAndExpressionContext booleanAndExpression(int i) {
			return getRuleContext(BooleanAndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(PatternParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(PatternParser.OR, i);
		}
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitLogicalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitLogicalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_logicalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			booleanAndExpression();
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(229);
				match(OR);
				setState(230);
				booleanAndExpression();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanAndExpressionContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(PatternParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(PatternParser.AND, i);
		}
		public BooleanAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterBooleanAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitBooleanAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitBooleanAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanAndExpressionContext booleanAndExpression() throws RecognitionException {
		BooleanAndExpressionContext _localctx = new BooleanAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_booleanAndExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			unaryExpression();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(237);
				match(AND);
				setState(238);
				unaryExpression();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PatternParser.NOT, 0); }
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_unaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(244);
				match(NOT);
				}
			}

			setState(247);
			primaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public BoolPredicateContext boolPredicate() {
			return getRuleContext(BoolPredicateContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_primaryExpression);
		try {
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				match(T__16);
				setState(250);
				logicalExpression();
				setState(251);
				match(T__3);
				}
				break;
			case T__33:
			case T__34:
			case Litterals:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				boolPredicate();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolPredicateContext extends ParserRuleContext {
		public OperandsContext leftOp;
		public OperandsContext rightOp;
		public TerminalNode Operator() { return getToken(PatternParser.Operator, 0); }
		public List<OperandsContext> operands() {
			return getRuleContexts(OperandsContext.class);
		}
		public OperandsContext operands(int i) {
			return getRuleContext(OperandsContext.class,i);
		}
		public BoolPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterBoolPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitBoolPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitBoolPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolPredicateContext boolPredicate() throws RecognitionException {
		BoolPredicateContext _localctx = new BoolPredicateContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_boolPredicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			((BoolPredicateContext)_localctx).leftOp = operands();
			setState(257);
			match(Operator);
			setState(258);
			((BoolPredicateContext)_localctx).rightOp = operands();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandsContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TemporalVariableContext temporalVariable() {
			return getRuleContext(TemporalVariableContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public OperandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterOperands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitOperands(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitOperands(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandsContext operands() throws RecognitionException {
		OperandsContext _localctx = new OperandsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_operands);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Litterals:
				{
				setState(260);
				label();
				}
				break;
			case T__34:
				{
				setState(261);
				temporalVariable();
				}
				break;
			case T__33:
				{
				setState(262);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionFunctionContext extends ParserRuleContext {
		public List<TemporalVariableContext> temporalVariable() {
			return getRuleContexts(TemporalVariableContext.class);
		}
		public TemporalVariableContext temporalVariable(int i) {
			return getRuleContext(TemporalVariableContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public PartitionFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterPartitionFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitPartitionFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitPartitionFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionFunctionContext partitionFunction() throws RecognitionException {
		PartitionFunctionContext _localctx = new PartitionFunctionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_partitionFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__34 || _la==Litterals) {
				{
				setState(267);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__34:
					{
					setState(265);
					temporalVariable();
					}
					break;
				case Litterals:
					{
					setState(266);
					label();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(269);
					match(T__8);
					setState(272);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__34:
						{
						setState(270);
						temporalVariable();
						}
						break;
					case Litterals:
						{
						setState(271);
						label();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationFunctionContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public List<TupleFieldContext> tupleField() {
			return getRuleContexts(TupleFieldContext.class);
		}
		public TupleFieldContext tupleField(int i) {
			return getRuleContext(TupleFieldContext.class,i);
		}
		public OneFieldOperationAliasContext oneFieldOperationAlias() {
			return getRuleContext(OneFieldOperationAliasContext.class,0);
		}
		public OperationFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operationFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterOperationFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitOperationFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitOperationFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationFunctionContext operationFunction() throws RecognitionException {
		OperationFunctionContext _localctx = new OperationFunctionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_operationFunction);
		int _la;
		try {
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__18:
			case T__19:
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(282);
				match(T__16);
				setState(283);
				functionName();
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Litterals) {
					{
					setState(284);
					tupleField();
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(285);
						match(T__8);
						setState(286);
						tupleField();
						}
						}
						setState(291);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(294);
				match(T__3);
				}
				break;
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(297);
				match(T__16);
				setState(298);
				tupleField();
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(299);
					match(T__8);
					setState(300);
					tupleField();
					}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(306);
				match(T__3);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 3);
				{
				setState(308);
				match(T__23);
				}
				break;
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 4);
				{
				setState(309);
				oneFieldOperationAlias();
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(310);
					match(T__16);
					setState(311);
					tupleField();
					setState(312);
					match(T__3);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OneFieldOperationAliasContext extends ParserRuleContext {
		public OneFieldOperationAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneFieldOperationAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterOneFieldOperationAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitOneFieldOperationAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitOneFieldOperationAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneFieldOperationAliasContext oneFieldOperationAlias() throws RecognitionException {
		OneFieldOperationAliasContext _localctx = new OneFieldOperationAliasContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_oneFieldOperationAlias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmissionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public EmissionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emission; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterEmission(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitEmission(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitEmission(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmissionContext emission() throws RecognitionException {
		EmissionContext _localctx = new EmissionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_emission);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(T__29);
			setState(321);
			variable();
			setState(322);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalVariableContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode Timeunit() { return getToken(PatternParser.Timeunit, 0); }
		public TemporalVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporalVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterTemporalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitTemporalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitTemporalVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemporalVariableContext temporalVariable() throws RecognitionException {
		TemporalVariableContext _localctx = new TemporalVariableContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_temporalVariable);
		int _la;
		try {
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				variable();
				setState(326);
				match(Timeunit);
				setState(327);
				match(T__30);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
				variable();
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__31) {
					{
					setState(330);
					match(T__31);
					}
				}

				setState(333);
				match(T__32);
				setState(334);
				match(Timeunit);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode Litterals() { return getToken(PatternParser.Litterals, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitFunctionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(Litterals);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode Litterals() { return getToken(PatternParser.Litterals, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(Litterals);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode Litterals() { return getToken(PatternParser.Litterals, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(T__33);
			setState(343);
			match(Litterals);
			setState(344);
			match(T__33);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode Litterals() { return getToken(PatternParser.Litterals, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(T__34);
			setState(347);
			match(Litterals);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FireEventContext extends ParserRuleContext {
		public TerminalNode Litterals() { return getToken(PatternParser.Litterals, 0); }
		public FireEventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fireEvent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterFireEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitFireEvent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitFireEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FireEventContext fireEvent() throws RecognitionException {
		FireEventContext _localctx = new FireEventContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_fireEvent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(T__35);
			setState(350);
			match(Litterals);
			setState(351);
			match(T__35);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TupleFieldContext extends ParserRuleContext {
		public List<TerminalNode> Litterals() { return getTokens(PatternParser.Litterals); }
		public TerminalNode Litterals(int i) {
			return getToken(PatternParser.Litterals, i);
		}
		public List<TerminalNode> DOT() { return getTokens(PatternParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PatternParser.DOT, i);
		}
		public TupleFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterTupleField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitTupleField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitTupleField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleFieldContext tupleField() throws RecognitionException {
		TupleFieldContext _localctx = new TupleFieldContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_tupleField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(Litterals);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(354);
				match(DOT);
				setState(355);
				match(Litterals);
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u016c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\5\2M\n\2\3\3\3\3\3\3\3\3\7\3S\n"+
		"\3\f\3\16\3V\13\3\3\3\3\3\3\3\3\4\3\4\3\4\6\4^\n\4\r\4\16\4_\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\7\5h\n\5\f\5\16\5k\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6s\n"+
		"\6\f\6\16\6v\13\6\3\6\3\6\3\6\3\6\7\6|\n\6\f\6\16\6\177\13\6\5\6\u0081"+
		"\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u0093\n\t\3\n\3\n\5\n\u0097\n\n\3\n\3\n\7\n\u009b\n\n\f\n\16\n\u009e"+
		"\13\n\3\n\3\n\3\n\5\n\u00a3\n\n\3\n\3\n\7\n\u00a7\n\n\f\n\16\n\u00aa\13"+
		"\n\3\n\5\n\u00ad\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\5\f\u00bb\n\f\3\r\3\r\3\r\7\r\u00c0\n\r\f\r\16\r\u00c3\13\r\3\16"+
		"\3\16\3\16\3\16\7\16\u00c9\n\16\f\16\16\16\u00cc\13\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\5\24\u00e3\n\24\3\24\3\24\3\25\3\25\3\25\7\25\u00ea"+
		"\n\25\f\25\16\25\u00ed\13\25\3\26\3\26\3\26\7\26\u00f2\n\26\f\26\16\26"+
		"\u00f5\13\26\3\27\5\27\u00f8\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5"+
		"\30\u0101\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\5\32\u010a\n\32\3\33"+
		"\3\33\5\33\u010e\n\33\3\33\3\33\3\33\5\33\u0113\n\33\7\33\u0115\n\33\f"+
		"\33\16\33\u0118\13\33\5\33\u011a\n\33\3\34\3\34\3\34\3\34\3\34\3\34\7"+
		"\34\u0122\n\34\f\34\16\34\u0125\13\34\5\34\u0127\n\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\7\34\u0130\n\34\f\34\16\34\u0133\13\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\5\34\u013d\n\34\5\34\u013f\n\34\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u014e\n\37"+
		"\3\37\3\37\3\37\5\37\u0153\n\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"$\3$\3$\3$\3%\3%\3%\7%\u0167\n%\f%\16%\u016a\13%\3%\2\2&\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\7\3\2\60\61\3"+
		"\2\62\64\3\2\24\27\3\2\30\31\3\2\33\37\2\u0171\2L\3\2\2\2\4N\3\2\2\2\6"+
		"]\3\2\2\2\bd\3\2\2\2\n\u0080\3\2\2\2\f\u0082\3\2\2\2\16\u0086\3\2\2\2"+
		"\20\u0092\3\2\2\2\22\u00ac\3\2\2\2\24\u00ae\3\2\2\2\26\u00b6\3\2\2\2\30"+
		"\u00bc\3\2\2\2\32\u00c4\3\2\2\2\34\u00d0\3\2\2\2\36\u00d4\3\2\2\2 \u00d8"+
		"\3\2\2\2\"\u00da\3\2\2\2$\u00dc\3\2\2\2&\u00df\3\2\2\2(\u00e6\3\2\2\2"+
		"*\u00ee\3\2\2\2,\u00f7\3\2\2\2.\u0100\3\2\2\2\60\u0102\3\2\2\2\62\u0109"+
		"\3\2\2\2\64\u0119\3\2\2\2\66\u013e\3\2\2\28\u0140\3\2\2\2:\u0142\3\2\2"+
		"\2<\u0152\3\2\2\2>\u0154\3\2\2\2@\u0156\3\2\2\2B\u0158\3\2\2\2D\u015c"+
		"\3\2\2\2F\u015f\3\2\2\2H\u0163\3\2\2\2JM\5\6\4\2KM\5\4\3\2LJ\3\2\2\2L"+
		"K\3\2\2\2M\3\3\2\2\2NT\5\b\5\2OP\5\36\20\2PQ\5\b\5\2QS\3\2\2\2RO\3\2\2"+
		"\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\3\2\2XY\7\2\2"+
		"\3Y\5\3\2\2\2Z[\5 \21\2[\\\5\"\22\2\\^\3\2\2\2]Z\3\2\2\2^_\3\2\2\2_]\3"+
		"\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\3\2\2bc\7\2\2\3c\7\3\2\2\2de\5\n\6\2ei"+
		"\5\22\n\2fh\5\66\34\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2"+
		"\2ki\3\2\2\2lm\5\24\13\2m\t\3\2\2\2nt\7\4\2\2os\5\f\7\2ps\5\16\b\2qs\5"+
		"\20\t\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\u0081"+
		"\3\2\2\2vt\3\2\2\2w}\5<\37\2x|\5\f\7\2y|\5\16\b\2z|\5\20\t\2{x\3\2\2\2"+
		"{y\3\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0081\3\2\2\2\177"+
		"}\3\2\2\2\u0080n\3\2\2\2\u0080w\3\2\2\2\u0081\13\3\2\2\2\u0082\u0083\7"+
		"\5\2\2\u0083\u0084\5\26\f\2\u0084\u0085\7\6\2\2\u0085\r\3\2\2\2\u0086"+
		"\u0087\7\7\2\2\u0087\u0088\5$\23\2\u0088\u0089\7\6\2\2\u0089\17\3\2\2"+
		"\2\u008a\u008b\7\b\2\2\u008b\u008c\5\64\33\2\u008c\u008d\7\6\2\2\u008d"+
		"\u0093\3\2\2\2\u008e\u008f\7\t\2\2\u008f\u0090\5\64\33\2\u0090\u0091\7"+
		"\6\2\2\u0091\u0093\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u008e\3\2\2\2\u0093"+
		"\21\3\2\2\2\u0094\u0096\7\n\2\2\u0095\u0097\5@!\2\u0096\u0095\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\u009c\3\2\2\2\u0098\u0099\7\13\2\2\u0099\u009b"+
		"\5@!\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00ad\7\6"+
		"\2\2\u00a0\u00a2\7\f\2\2\u00a1\u00a3\5@!\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00a8\3\2\2\2\u00a4\u00a5\7\13\2\2\u00a5\u00a7\5@!\2\u00a6"+
		"\u00a4\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ad\7\6\2\2\u00ac"+
		"\u0094\3\2\2\2\u00ac\u00a0\3\2\2\2\u00ad\23\3\2\2\2\u00ae\u00af\7\r\2"+
		"\2\u00af\u00b0\7\'\2\2\u00b0\u00b1\7\13\2\2\u00b1\u00b2\5B\"\2\u00b2\u00b3"+
		"\7\13\2\2\u00b3\u00b4\5F$\2\u00b4\u00b5\7\6\2\2\u00b5\25\3\2\2\2\u00b6"+
		"\u00b7\5> \2\u00b7\u00b8\7\13\2\2\u00b8\u00ba\5\30\r\2\u00b9\u00bb\5\32"+
		"\16\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\27\3\2\2\2\u00bc\u00c1"+
		"\5D#\2\u00bd\u00be\7\13\2\2\u00be\u00c0\5D#\2\u00bf\u00bd\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\31\3\2\2"+
		"\2\u00c3\u00c1\3\2\2\2\u00c4\u00ca\7\16\2\2\u00c5\u00c6\5\34\17\2\u00c6"+
		"\u00c7\7\13\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c9\u00cc\3"+
		"\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00ce\5\34\17\2\u00ce\u00cf\7\17\2\2\u00cf\33\3\2"+
		"\2\2\u00d0\u00d1\7,\2\2\u00d1\u00d2\7\20\2\2\u00d2\u00d3\5\62\32\2\u00d3"+
		"\35\3\2\2\2\u00d4\u00d5\7\21\2\2\u00d5\u00d6\5<\37\2\u00d6\u00d7\7\6\2"+
		"\2\u00d7\37\3\2\2\2\u00d8\u00d9\t\2\2\2\u00d9!\3\2\2\2\u00da\u00db\t\3"+
		"\2\2\u00db#\3\2\2\2\u00dc\u00dd\5(\25\2\u00dd\u00de\5&\24\2\u00de%\3\2"+
		"\2\2\u00df\u00e2\7\22\2\2\u00e0\u00e3\5(\25\2\u00e1\u00e3\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7\17"+
		"\2\2\u00e5\'\3\2\2\2\u00e6\u00eb\5*\26\2\u00e7\u00e8\7*\2\2\u00e8\u00ea"+
		"\5*\26\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec)\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00f3\5,\27\2"+
		"\u00ef\u00f0\7)\2\2\u00f0\u00f2\5,\27\2\u00f1\u00ef\3\2\2\2\u00f2\u00f5"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4+\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f6\u00f8\7(\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\5.\30\2\u00fa-\3\2\2\2\u00fb\u00fc"+
		"\7\23\2\2\u00fc\u00fd\5(\25\2\u00fd\u00fe\7\6\2\2\u00fe\u0101\3\2\2\2"+
		"\u00ff\u0101\5\60\31\2\u0100\u00fb\3\2\2\2\u0100\u00ff\3\2\2\2\u0101/"+
		"\3\2\2\2\u0102\u0103\5\62\32\2\u0103\u0104\7\'\2\2\u0104\u0105\5\62\32"+
		"\2\u0105\61\3\2\2\2\u0106\u010a\5@!\2\u0107\u010a\5<\37\2\u0108\u010a"+
		"\5B\"\2\u0109\u0106\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a"+
		"\63\3\2\2\2\u010b\u010e\5<\37\2\u010c\u010e\5@!\2\u010d\u010b\3\2\2\2"+
		"\u010d\u010c\3\2\2\2\u010e\u0116\3\2\2\2\u010f\u0112\7\13\2\2\u0110\u0113"+
		"\5<\37\2\u0111\u0113\5@!\2\u0112\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0113"+
		"\u0115\3\2\2\2\u0114\u010f\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0119"+
		"\u010d\3\2\2\2\u0119\u011a\3\2\2\2\u011a\65\3\2\2\2\u011b\u011c\t\4\2"+
		"\2\u011c\u011d\7\23\2\2\u011d\u0126\5> \2\u011e\u0123\5H%\2\u011f\u0120"+
		"\7\13\2\2\u0120\u0122\5H%\2\u0121\u011f\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0126\u011e\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"\u0129\7\6\2\2\u0129\u013f\3\2\2\2\u012a\u012b\t\5\2\2\u012b\u012c\7\23"+
		"\2\2\u012c\u0131\5H%\2\u012d\u012e\7\13\2\2\u012e\u0130\5H%\2\u012f\u012d"+
		"\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\7\6\2\2\u0135\u013f\3\2"+
		"\2\2\u0136\u013f\7\32\2\2\u0137\u013c\58\35\2\u0138\u0139\7\23\2\2\u0139"+
		"\u013a\5H%\2\u013a\u013b\7\6\2\2\u013b\u013d\3\2\2\2\u013c\u0138\3\2\2"+
		"\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u011b\3\2\2\2\u013e\u012a"+
		"\3\2\2\2\u013e\u0136\3\2\2\2\u013e\u0137\3\2\2\2\u013f\67\3\2\2\2\u0140"+
		"\u0141\t\6\2\2\u01419\3\2\2\2\u0142\u0143\7 \2\2\u0143\u0144\5D#\2\u0144"+
		"\u0145\7\6\2\2\u0145;\3\2\2\2\u0146\u0153\5D#\2\u0147\u0148\5D#\2\u0148"+
		"\u0149\7-\2\2\u0149\u014a\7!\2\2\u014a\u0153\3\2\2\2\u014b\u014d\5D#\2"+
		"\u014c\u014e\7\"\2\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f"+
		"\3\2\2\2\u014f\u0150\7#\2\2\u0150\u0151\7-\2\2\u0151\u0153\3\2\2\2\u0152"+
		"\u0146\3\2\2\2\u0152\u0147\3\2\2\2\u0152\u014b\3\2\2\2\u0153=\3\2\2\2"+
		"\u0154\u0155\7,\2\2\u0155?\3\2\2\2\u0156\u0157\7,\2\2\u0157A\3\2\2\2\u0158"+
		"\u0159\7$\2\2\u0159\u015a\7,\2\2\u015a\u015b\7$\2\2\u015bC\3\2\2\2\u015c"+
		"\u015d\7%\2\2\u015d\u015e\7,\2\2\u015eE\3\2\2\2\u015f\u0160\7&\2\2\u0160"+
		"\u0161\7,\2\2\u0161\u0162\7&\2\2\u0162G\3\2\2\2\u0163\u0168\7,\2\2\u0164"+
		"\u0165\7+\2\2\u0165\u0167\7,\2\2\u0166\u0164\3\2\2\2\u0167\u016a\3\2\2"+
		"\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169I\3\2\2\2\u016a\u0168"+
		"\3\2\2\2&LT_irt{}\u0080\u0092\u0096\u009c\u00a2\u00a8\u00ac\u00ba\u00c1"+
		"\u00ca\u00e2\u00eb\u00f3\u00f7\u0100\u0109\u010d\u0112\u0116\u0119\u0123"+
		"\u0126\u0131\u013c\u013e\u014d\u0152\u0168";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}