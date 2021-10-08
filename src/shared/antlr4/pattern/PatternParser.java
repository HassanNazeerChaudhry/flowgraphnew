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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		Operator=46, NOT=47, AND=48, OR=49, DOT=50, Litterals=51, Timeunit=52, 
		Number=53, Skip=54;
	public static final int
		RULE_patternEntry = 0, RULE_temporalPattern = 1, RULE_graphProcessing = 2, 
		RULE_collectStreams = 3, RULE_extractStreamProcessing = 4, RULE_collectStreamProcessing = 5, 
		RULE_computation = 6, RULE_selection = 7, RULE_partition = 8, RULE_extraction = 9, 
		RULE_evaluation = 10, RULE_operation = 11, RULE_computationFunction = 12, 
		RULE_computationReturnVariables = 13, RULE_computationParameters = 14, 
		RULE_aliasedParameter = 15, RULE_followedBy = 16, RULE_selectionFunction = 17, 
		RULE_edgeSelection = 18, RULE_logicalExpression = 19, RULE_booleanAndExpression = 20, 
		RULE_unaryExpression = 21, RULE_primaryExpression = 22, RULE_boolPredicate = 23, 
		RULE_operands = 24, RULE_partitionFunction = 25, RULE_operationFunction = 26, 
		RULE_oneFieldOperationAlias = 27, RULE_triggerComputation = 28, RULE_triggerInput = 29, 
		RULE_triggerTemporal = 30, RULE_triggerSensitivity = 31, RULE_emission = 32, 
		RULE_temporalVariable = 33, RULE_functionName = 34, RULE_label = 35, RULE_value = 36, 
		RULE_variable = 37, RULE_fireEvent = 38, RULE_tupleField = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"patternEntry", "temporalPattern", "graphProcessing", "collectStreams", 
			"extractStreamProcessing", "collectStreamProcessing", "computation", 
			"selection", "partition", "extraction", "evaluation", "operation", "computationFunction", 
			"computationReturnVariables", "computationParameters", "aliasedParameter", 
			"followedBy", "selectionFunction", "edgeSelection", "logicalExpression", 
			"booleanAndExpression", "unaryExpression", "primaryExpression", "boolPredicate", 
			"operands", "partitionFunction", "operationFunction", "oneFieldOperationAlias", 
			"triggerComputation", "triggerInput", "triggerTemporal", "triggerSensitivity", 
			"emission", "temporalVariable", "functionName", "label", "value", "variable", 
			"fireEvent", "tupleField"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.g()'", "'.collect('", "','", "')'", "'.compute('", "'.select('", 
			"'.SubGraphByV('", "'.SubGraphByE('", "'.extractV('", "'.extractE('", 
			"'.evaluate('", "', ['", "']'", "'='", "'.followedBy('", "'EDGE['", "'('", 
			"'.map'", "'.flatmap'", "'.reduce'", "'.filter'", "'.groupby'", "'.Merge'", 
			"'.collect'", "'.avg'", "'.max'", "'.min'", "'.count'", "'.select'", 
			"'.trigger('", "'edge'", "'vertex'", "'addition'", "'deletion'", "'update'", 
			"'as'", "'['", "'.emit('", "'ago'", "'every'", "'within'", "'''", "'$'", 
			"'\"'", null, "'not'", "'and'", "'or'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "Operator", 
			"NOT", "AND", "OR", "DOT", "Litterals", "Timeunit", "Number", "Skip"
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
		public TerminalNode EOF() { return getToken(PatternParser.EOF, 0); }
		public List<TemporalPatternContext> temporalPattern() {
			return getRuleContexts(TemporalPatternContext.class);
		}
		public TemporalPatternContext temporalPattern(int i) {
			return getRuleContext(TemporalPatternContext.class,i);
		}
		public List<FollowedByContext> followedBy() {
			return getRuleContexts(FollowedByContext.class);
		}
		public FollowedByContext followedBy(int i) {
			return getRuleContext(FollowedByContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__9) | (1L << T__10) | (1L << T__30) | (1L << T__43))) != 0)) {
				{
				{
				setState(80);
				temporalPattern();
				setState(81);
				followedBy();
				setState(82);
				temporalPattern();
				setState(83);
				match(T__0);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
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

	public static class TemporalPatternContext extends ParserRuleContext {
		public GraphProcessingContext graphProcessing() {
			return getRuleContext(GraphProcessingContext.class,0);
		}
		public TriggerComputationContext triggerComputation() {
			return getRuleContext(TriggerComputationContext.class,0);
		}
		public EmissionContext emission() {
			return getRuleContext(EmissionContext.class,0);
		}
		public ExtractStreamProcessingContext extractStreamProcessing() {
			return getRuleContext(ExtractStreamProcessingContext.class,0);
		}
		public CollectStreamProcessingContext collectStreamProcessing() {
			return getRuleContext(CollectStreamProcessingContext.class,0);
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
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30) {
					{
					setState(92);
					triggerComputation();
					}
				}

				setState(95);
				graphProcessing();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__38) {
					{
					setState(96);
					emission();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30) {
					{
					setState(99);
					triggerComputation();
					}
				}

				setState(102);
				graphProcessing();
				setState(103);
				extractStreamProcessing();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30) {
					{
					setState(105);
					triggerComputation();
					}
				}

				setState(108);
				collectStreamProcessing();
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

	public static class GraphProcessingContext extends ParserRuleContext {
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
		public TemporalVariableContext temporalVariable() {
			return getRuleContext(TemporalVariableContext.class,0);
		}
		public GraphProcessingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphProcessing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterGraphProcessing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitGraphProcessing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitGraphProcessing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphProcessingContext graphProcessing() throws RecognitionException {
		GraphProcessingContext _localctx = new GraphProcessingContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_graphProcessing);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(T__1);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) {
					{
					setState(115);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__5:
						{
						setState(112);
						computation();
						}
						break;
					case T__6:
						{
						setState(113);
						selection();
						}
						break;
					case T__7:
					case T__8:
						{
						setState(114);
						partition();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				temporalVariable();
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) {
					{
					setState(124);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__5:
						{
						setState(121);
						computation();
						}
						break;
					case T__6:
						{
						setState(122);
						selection();
						}
						break;
					case T__7:
					case T__8:
						{
						setState(123);
						partition();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(128);
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

	public static class CollectStreamsContext extends ParserRuleContext {
		public List<TemporalVariableContext> temporalVariable() {
			return getRuleContexts(TemporalVariableContext.class);
		}
		public TemporalVariableContext temporalVariable(int i) {
			return getRuleContext(TemporalVariableContext.class,i);
		}
		public CollectStreamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectStreams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterCollectStreams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitCollectStreams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitCollectStreams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectStreamsContext collectStreams() throws RecognitionException {
		CollectStreamsContext _localctx = new CollectStreamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_collectStreams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__2);
			setState(132);
			temporalVariable();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(133);
				match(T__3);
				setState(134);
				temporalVariable();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			match(T__4);
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

	public static class ExtractStreamProcessingContext extends ParserRuleContext {
		public ExtractionContext extraction() {
			return getRuleContext(ExtractionContext.class,0);
		}
		public EmissionContext emission() {
			return getRuleContext(EmissionContext.class,0);
		}
		public EvaluationContext evaluation() {
			return getRuleContext(EvaluationContext.class,0);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public ExtractStreamProcessingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extractStreamProcessing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterExtractStreamProcessing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitExtractStreamProcessing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitExtractStreamProcessing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtractStreamProcessingContext extractStreamProcessing() throws RecognitionException {
		ExtractStreamProcessingContext _localctx = new ExtractStreamProcessingContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_extractStreamProcessing);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			extraction();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) {
				{
				{
				setState(143);
				operation();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__38:
				{
				setState(149);
				emission();
				}
				break;
			case T__11:
				{
				setState(150);
				evaluation();
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

	public static class CollectStreamProcessingContext extends ParserRuleContext {
		public CollectStreamsContext collectStreams() {
			return getRuleContext(CollectStreamsContext.class,0);
		}
		public ExtractionContext extraction() {
			return getRuleContext(ExtractionContext.class,0);
		}
		public EmissionContext emission() {
			return getRuleContext(EmissionContext.class,0);
		}
		public EvaluationContext evaluation() {
			return getRuleContext(EvaluationContext.class,0);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public CollectStreamProcessingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectStreamProcessing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterCollectStreamProcessing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitCollectStreamProcessing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitCollectStreamProcessing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectStreamProcessingContext collectStreamProcessing() throws RecognitionException {
		CollectStreamProcessingContext _localctx = new CollectStreamProcessingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_collectStreamProcessing);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(153);
				collectStreams();
				}
				break;
			case T__9:
			case T__10:
				{
				setState(154);
				extraction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) {
				{
				{
				setState(157);
				operation();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__38:
				{
				setState(163);
				emission();
				}
				break;
			case T__11:
				{
				setState(164);
				evaluation();
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
		enterRule(_localctx, 12, RULE_computation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(T__5);
			setState(168);
			computationFunction();
			setState(169);
			match(T__4);
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
		enterRule(_localctx, 14, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__6);
			setState(172);
			selectionFunction();
			setState(173);
			match(T__4);
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
		public PartitionFunctionContext partitionFunction() {
			return getRuleContext(PartitionFunctionContext.class,0);
		}
		public PartitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterPartition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitPartition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitPartition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionContext partition() throws RecognitionException {
		PartitionContext _localctx = new PartitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_partition);
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(T__7);
				setState(176);
				partitionFunction();
				setState(177);
				match(T__4);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(T__8);
				setState(180);
				partitionFunction();
				setState(181);
				match(T__4);
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
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public ExtractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterExtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitExtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitExtraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtractionContext extraction() throws RecognitionException {
		ExtractionContext _localctx = new ExtractionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_extraction);
		int _la;
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(T__9);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Litterals) {
					{
					setState(186);
					label();
					}
				}

				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(189);
					match(T__3);
					setState(190);
					label();
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196);
				match(T__4);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(T__10);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Litterals) {
					{
					setState(198);
					label();
					}
				}

				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(201);
					match(T__3);
					setState(202);
					label();
					}
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(208);
				match(T__4);
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
		enterRule(_localctx, 20, RULE_evaluation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__11);
			setState(212);
			match(Operator);
			setState(213);
			match(T__3);
			setState(214);
			value();
			setState(215);
			match(T__3);
			setState(216);
			fireEvent();
			setState(217);
			match(T__4);
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

	public static class OperationContext extends ParserRuleContext {
		public OperationFunctionContext operationFunction() {
			return getRuleContext(OperationFunctionContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			operationFunction();
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
		enterRule(_localctx, 24, RULE_computationFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			functionName();
			setState(222);
			match(T__3);
			setState(223);
			computationReturnVariables();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(224);
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
		enterRule(_localctx, 26, RULE_computationReturnVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			variable();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(228);
				match(T__3);
				setState(229);
				variable();
				}
				}
				setState(234);
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
		enterRule(_localctx, 28, RULE_computationParameters);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__12);
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(236);
					aliasedParameter();
					setState(237);
					match(T__3);
					}
					} 
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(244);
			aliasedParameter();
			setState(245);
			match(T__13);
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
		enterRule(_localctx, 30, RULE_aliasedParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(Litterals);
			setState(248);
			match(T__14);
			setState(249);
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
		enterRule(_localctx, 32, RULE_followedBy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__15);
			setState(252);
			temporalVariable();
			setState(253);
			match(T__4);
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
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__42:
			case T__43:
			case NOT:
			case Litterals:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				logicalExpression();
				setState(256);
				edgeSelection();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
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
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				match(T__16);
				setState(264);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__17:
				case T__42:
				case T__43:
				case NOT:
				case Litterals:
					{
					setState(262);
					logicalExpression();
					}
					break;
				case T__13:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(266);
				match(T__13);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
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
			setState(270);
			booleanAndExpression();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(271);
				match(OR);
				setState(272);
				booleanAndExpression();
				}
				}
				setState(277);
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
			setState(278);
			unaryExpression();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(279);
				match(AND);
				setState(280);
				unaryExpression();
				}
				}
				setState(285);
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
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(286);
				match(NOT);
				}
			}

			setState(289);
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
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(T__17);
				setState(292);
				logicalExpression();
				setState(293);
				match(T__4);
				}
				break;
			case T__42:
			case T__43:
			case Litterals:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
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
			setState(298);
			((BoolPredicateContext)_localctx).leftOp = operands();
			setState(299);
			match(Operator);
			setState(300);
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
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Litterals:
				{
				setState(302);
				label();
				}
				break;
			case T__43:
				{
				setState(303);
				temporalVariable();
				}
				break;
			case T__42:
				{
				setState(304);
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
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__43 || _la==Litterals) {
				{
				setState(309);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__43:
					{
					setState(307);
					temporalVariable();
					}
					break;
				case Litterals:
					{
					setState(308);
					label();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(311);
					match(T__3);
					setState(314);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__43:
						{
						setState(312);
						temporalVariable();
						}
						break;
					case Litterals:
						{
						setState(313);
						label();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(320);
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
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case T__19:
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(324);
				match(T__17);
				setState(325);
				functionName();
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Litterals) {
					{
					setState(326);
					tupleField();
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(327);
						match(T__3);
						setState(328);
						tupleField();
						}
						}
						setState(333);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(336);
				match(T__4);
				}
				break;
			case T__22:
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(339);
				match(T__17);
				setState(340);
				tupleField();
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(341);
					match(T__3);
					setState(342);
					tupleField();
					}
					}
					setState(347);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(348);
				match(T__4);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				match(T__24);
				}
				break;
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
				oneFieldOperationAlias();
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(352);
					match(T__17);
					setState(353);
					tupleField();
					setState(354);
					match(T__4);
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
			setState(360);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
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

	public static class TriggerComputationContext extends ParserRuleContext {
		public TriggerInputContext triggerInput() {
			return getRuleContext(TriggerInputContext.class,0);
		}
		public TriggerTemporalContext triggerTemporal() {
			return getRuleContext(TriggerTemporalContext.class,0);
		}
		public TriggerSensitivityContext triggerSensitivity() {
			return getRuleContext(TriggerSensitivityContext.class,0);
		}
		public TriggerComputationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerComputation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterTriggerComputation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitTriggerComputation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitTriggerComputation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerComputationContext triggerComputation() throws RecognitionException {
		TriggerComputationContext _localctx = new TriggerComputationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_triggerComputation);
		try {
			setState(365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				triggerInput();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(363);
				triggerTemporal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(364);
				triggerSensitivity();
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

	public static class TriggerInputContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<BoolPredicateContext> boolPredicate() {
			return getRuleContexts(BoolPredicateContext.class);
		}
		public BoolPredicateContext boolPredicate(int i) {
			return getRuleContext(BoolPredicateContext.class,i);
		}
		public TriggerInputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerInput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterTriggerInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitTriggerInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitTriggerInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerInputContext triggerInput() throws RecognitionException {
		TriggerInputContext _localctx = new TriggerInputContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_triggerInput);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(T__30);
			setState(368);
			_la = _input.LA(1);
			if ( !(_la==T__31 || _la==T__32) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(369);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(370);
			match(T__36);
			setState(371);
			variable();
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__37) {
				{
				setState(372);
				match(T__37);
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__42) | (1L << T__43) | (1L << Litterals))) != 0)) {
					{
					{
					setState(373);
					boolPredicate();
					}
					}
					setState(378);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(379);
				match(T__13);
				}
			}

			setState(382);
			match(T__4);
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

	public static class TriggerTemporalContext extends ParserRuleContext {
		public TerminalNode Timeunit() { return getToken(PatternParser.Timeunit, 0); }
		public TriggerTemporalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerTemporal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterTriggerTemporal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitTriggerTemporal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitTriggerTemporal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerTemporalContext triggerTemporal() throws RecognitionException {
		TriggerTemporalContext _localctx = new TriggerTemporalContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_triggerTemporal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(T__30);
			setState(385);
			match(Timeunit);
			setState(386);
			match(T__4);
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

	public static class TriggerSensitivityContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TriggerSensitivityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerSensitivity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).enterTriggerSensitivity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatternListener ) ((PatternListener)listener).exitTriggerSensitivity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatternVisitor ) return ((PatternVisitor<? extends T>)visitor).visitTriggerSensitivity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerSensitivityContext triggerSensitivity() throws RecognitionException {
		TriggerSensitivityContext _localctx = new TriggerSensitivityContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_triggerSensitivity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(T__30);
			setState(389);
			variable();
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(390);
				match(T__3);
				setState(391);
				variable();
				}
				}
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(397);
			match(T__4);
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
		enterRule(_localctx, 64, RULE_emission);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(T__38);
			setState(400);
			variable();
			setState(401);
			match(T__4);
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
		enterRule(_localctx, 66, RULE_temporalVariable);
		int _la;
		try {
			setState(415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				variable();
				setState(405);
				match(Timeunit);
				setState(406);
				match(T__39);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(408);
				variable();
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__40) {
					{
					setState(409);
					match(T__40);
					}
				}

				setState(412);
				match(T__41);
				setState(413);
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
		enterRule(_localctx, 68, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
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
		enterRule(_localctx, 70, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
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
		enterRule(_localctx, 72, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(T__42);
			setState(422);
			match(Litterals);
			setState(423);
			match(T__42);
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
		enterRule(_localctx, 74, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(T__43);
			setState(426);
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
		enterRule(_localctx, 76, RULE_fireEvent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(T__44);
			setState(429);
			match(Litterals);
			setState(430);
			match(T__44);
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
		enterRule(_localctx, 78, RULE_tupleField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(Litterals);
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(433);
				match(DOT);
				setState(434);
				match(Litterals);
				}
				}
				setState(439);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u01bb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\7\2X\n\2\f\2\16\2[\13\2\3\2\3\2\3\3\5\3`\n\3\3\3\3\3\5\3d\n\3\3"+
		"\3\5\3g\n\3\3\3\3\3\3\3\3\3\5\3m\n\3\3\3\5\3p\n\3\3\4\3\4\3\4\3\4\7\4"+
		"v\n\4\f\4\16\4y\13\4\3\4\3\4\3\4\3\4\7\4\177\n\4\f\4\16\4\u0082\13\4\5"+
		"\4\u0084\n\4\3\5\3\5\3\5\3\5\7\5\u008a\n\5\f\5\16\5\u008d\13\5\3\5\3\5"+
		"\3\6\3\6\7\6\u0093\n\6\f\6\16\6\u0096\13\6\3\6\3\6\5\6\u009a\n\6\3\7\3"+
		"\7\5\7\u009e\n\7\3\7\7\7\u00a1\n\7\f\7\16\7\u00a4\13\7\3\7\3\7\5\7\u00a8"+
		"\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u00ba\n\n\3\13\3\13\5\13\u00be\n\13\3\13\3\13\7\13\u00c2\n\13\f\13"+
		"\16\13\u00c5\13\13\3\13\3\13\3\13\5\13\u00ca\n\13\3\13\3\13\7\13\u00ce"+
		"\n\13\f\13\16\13\u00d1\13\13\3\13\5\13\u00d4\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u00e4\n\16\3\17\3\17\3\17"+
		"\7\17\u00e9\n\17\f\17\16\17\u00ec\13\17\3\20\3\20\3\20\3\20\7\20\u00f2"+
		"\n\20\f\20\16\20\u00f5\13\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u0106\n\23\3\24\3\24\3\24\5\24"+
		"\u010b\n\24\3\24\3\24\5\24\u010f\n\24\3\25\3\25\3\25\7\25\u0114\n\25\f"+
		"\25\16\25\u0117\13\25\3\26\3\26\3\26\7\26\u011c\n\26\f\26\16\26\u011f"+
		"\13\26\3\27\5\27\u0122\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u012b"+
		"\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\5\32\u0134\n\32\3\33\3\33\5\33"+
		"\u0138\n\33\3\33\3\33\3\33\5\33\u013d\n\33\7\33\u013f\n\33\f\33\16\33"+
		"\u0142\13\33\5\33\u0144\n\33\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u014c"+
		"\n\34\f\34\16\34\u014f\13\34\5\34\u0151\n\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\7\34\u015a\n\34\f\34\16\34\u015d\13\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u0167\n\34\5\34\u0169\n\34\3\35\3\35\3\36\3"+
		"\36\3\36\5\36\u0170\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0179"+
		"\n\37\f\37\16\37\u017c\13\37\3\37\5\37\u017f\n\37\3\37\3\37\3 \3 \3 \3"+
		" \3!\3!\3!\3!\7!\u018b\n!\f!\16!\u018e\13!\3!\3!\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3#\3#\5#\u019d\n#\3#\3#\3#\5#\u01a2\n#\3$\3$\3%\3%\3&\3&\3"+
		"&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\7)\u01b6\n)\f)\16)\u01b9\13)\3)"+
		"\2\2*\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>"+
		"@BDFHJLNP\2\7\3\2\25\30\3\2\31\32\3\2\34 \3\2\"#\3\2$&\2\u01cc\2Y\3\2"+
		"\2\2\4o\3\2\2\2\6\u0083\3\2\2\2\b\u0085\3\2\2\2\n\u0090\3\2\2\2\f\u009d"+
		"\3\2\2\2\16\u00a9\3\2\2\2\20\u00ad\3\2\2\2\22\u00b9\3\2\2\2\24\u00d3\3"+
		"\2\2\2\26\u00d5\3\2\2\2\30\u00dd\3\2\2\2\32\u00df\3\2\2\2\34\u00e5\3\2"+
		"\2\2\36\u00ed\3\2\2\2 \u00f9\3\2\2\2\"\u00fd\3\2\2\2$\u0105\3\2\2\2&\u010e"+
		"\3\2\2\2(\u0110\3\2\2\2*\u0118\3\2\2\2,\u0121\3\2\2\2.\u012a\3\2\2\2\60"+
		"\u012c\3\2\2\2\62\u0133\3\2\2\2\64\u0143\3\2\2\2\66\u0168\3\2\2\28\u016a"+
		"\3\2\2\2:\u016f\3\2\2\2<\u0171\3\2\2\2>\u0182\3\2\2\2@\u0186\3\2\2\2B"+
		"\u0191\3\2\2\2D\u01a1\3\2\2\2F\u01a3\3\2\2\2H\u01a5\3\2\2\2J\u01a7\3\2"+
		"\2\2L\u01ab\3\2\2\2N\u01ae\3\2\2\2P\u01b2\3\2\2\2RS\5\4\3\2ST\5\"\22\2"+
		"TU\5\4\3\2UV\7\3\2\2VX\3\2\2\2WR\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2"+
		"Z\\\3\2\2\2[Y\3\2\2\2\\]\7\2\2\3]\3\3\2\2\2^`\5:\36\2_^\3\2\2\2_`\3\2"+
		"\2\2`a\3\2\2\2ac\5\6\4\2bd\5B\"\2cb\3\2\2\2cd\3\2\2\2dp\3\2\2\2eg\5:\36"+
		"\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\5\6\4\2ij\5\n\6\2jp\3\2\2\2km\5:\36"+
		"\2lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2np\5\f\7\2o_\3\2\2\2of\3\2\2\2ol\3\2\2"+
		"\2p\5\3\2\2\2qw\7\4\2\2rv\5\16\b\2sv\5\20\t\2tv\5\22\n\2ur\3\2\2\2us\3"+
		"\2\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\u0084\3\2\2\2yw\3\2\2"+
		"\2z\u0080\5D#\2{\177\5\16\b\2|\177\5\20\t\2}\177\5\22\n\2~{\3\2\2\2~|"+
		"\3\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083q\3\2\2\2\u0083z\3\2\2"+
		"\2\u0084\7\3\2\2\2\u0085\u0086\7\5\2\2\u0086\u008b\5D#\2\u0087\u0088\7"+
		"\6\2\2\u0088\u008a\5D#\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u008f\7\7\2\2\u008f\t\3\2\2\2\u0090\u0094\5\24\13\2\u0091\u0093"+
		"\5\30\r\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2"+
		"\u0094\u0095\3\2\2\2\u0095\u0099\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009a"+
		"\5B\"\2\u0098\u009a\5\26\f\2\u0099\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a"+
		"\13\3\2\2\2\u009b\u009e\5\b\5\2\u009c\u009e\5\24\13\2\u009d\u009b\3\2"+
		"\2\2\u009d\u009c\3\2\2\2\u009e\u00a2\3\2\2\2\u009f\u00a1\5\30\r\2\u00a0"+
		"\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a7\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\5B\"\2\u00a6"+
		"\u00a8\5\26\f\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\r\3\2\2"+
		"\2\u00a9\u00aa\7\b\2\2\u00aa\u00ab\5\32\16\2\u00ab\u00ac\7\7\2\2\u00ac"+
		"\17\3\2\2\2\u00ad\u00ae\7\t\2\2\u00ae\u00af\5$\23\2\u00af\u00b0\7\7\2"+
		"\2\u00b0\21\3\2\2\2\u00b1\u00b2\7\n\2\2\u00b2\u00b3\5\64\33\2\u00b3\u00b4"+
		"\7\7\2\2\u00b4\u00ba\3\2\2\2\u00b5\u00b6\7\13\2\2\u00b6\u00b7\5\64\33"+
		"\2\u00b7\u00b8\7\7\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b1\3\2\2\2\u00b9\u00b5"+
		"\3\2\2\2\u00ba\23\3\2\2\2\u00bb\u00bd\7\f\2\2\u00bc\u00be\5H%\2\u00bd"+
		"\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c3\3\2\2\2\u00bf\u00c0\7\6"+
		"\2\2\u00c0\u00c2\5H%\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00d4\7\7\2\2\u00c7\u00c9\7\r\2\2\u00c8\u00ca\5H%\2\u00c9\u00c8\3\2\2"+
		"\2\u00c9\u00ca\3\2\2\2\u00ca\u00cf\3\2\2\2\u00cb\u00cc\7\6\2\2\u00cc\u00ce"+
		"\5H%\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d4\7\7"+
		"\2\2\u00d3\u00bb\3\2\2\2\u00d3\u00c7\3\2\2\2\u00d4\25\3\2\2\2\u00d5\u00d6"+
		"\7\16\2\2\u00d6\u00d7\7\60\2\2\u00d7\u00d8\7\6\2\2\u00d8\u00d9\5J&\2\u00d9"+
		"\u00da\7\6\2\2\u00da\u00db\5N(\2\u00db\u00dc\7\7\2\2\u00dc\27\3\2\2\2"+
		"\u00dd\u00de\5\66\34\2\u00de\31\3\2\2\2\u00df\u00e0\5F$\2\u00e0\u00e1"+
		"\7\6\2\2\u00e1\u00e3\5\34\17\2\u00e2\u00e4\5\36\20\2\u00e3\u00e2\3\2\2"+
		"\2\u00e3\u00e4\3\2\2\2\u00e4\33\3\2\2\2\u00e5\u00ea\5L\'\2\u00e6\u00e7"+
		"\7\6\2\2\u00e7\u00e9\5L\'\2\u00e8\u00e6\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\35\3\2\2\2\u00ec\u00ea\3\2\2"+
		"\2\u00ed\u00f3\7\17\2\2\u00ee\u00ef\5 \21\2\u00ef\u00f0\7\6\2\2\u00f0"+
		"\u00f2\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f7\5 \21\2\u00f7\u00f8\7\20\2\2\u00f8\37\3\2\2\2\u00f9\u00fa\7\65"+
		"\2\2\u00fa\u00fb\7\21\2\2\u00fb\u00fc\5\62\32\2\u00fc!\3\2\2\2\u00fd\u00fe"+
		"\7\22\2\2\u00fe\u00ff\5D#\2\u00ff\u0100\7\7\2\2\u0100#\3\2\2\2\u0101\u0102"+
		"\5(\25\2\u0102\u0103\5&\24\2\u0103\u0106\3\2\2\2\u0104\u0106\3\2\2\2\u0105"+
		"\u0101\3\2\2\2\u0105\u0104\3\2\2\2\u0106%\3\2\2\2\u0107\u010a\7\23\2\2"+
		"\u0108\u010b\5(\25\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u0109"+
		"\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010f\7\20\2\2\u010d\u010f\3\2\2\2"+
		"\u010e\u0107\3\2\2\2\u010e\u010d\3\2\2\2\u010f\'\3\2\2\2\u0110\u0115\5"+
		"*\26\2\u0111\u0112\7\63\2\2\u0112\u0114\5*\26\2\u0113\u0111\3\2\2\2\u0114"+
		"\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116)\3\2\2\2"+
		"\u0117\u0115\3\2\2\2\u0118\u011d\5,\27\2\u0119\u011a\7\62\2\2\u011a\u011c"+
		"\5,\27\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e+\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0122\7\61\2\2"+
		"\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124"+
		"\5.\30\2\u0124-\3\2\2\2\u0125\u0126\7\24\2\2\u0126\u0127\5(\25\2\u0127"+
		"\u0128\7\7\2\2\u0128\u012b\3\2\2\2\u0129\u012b\5\60\31\2\u012a\u0125\3"+
		"\2\2\2\u012a\u0129\3\2\2\2\u012b/\3\2\2\2\u012c\u012d\5\62\32\2\u012d"+
		"\u012e\7\60\2\2\u012e\u012f\5\62\32\2\u012f\61\3\2\2\2\u0130\u0134\5H"+
		"%\2\u0131\u0134\5D#\2\u0132\u0134\5J&\2\u0133\u0130\3\2\2\2\u0133\u0131"+
		"\3\2\2\2\u0133\u0132\3\2\2\2\u0134\63\3\2\2\2\u0135\u0138\5D#\2\u0136"+
		"\u0138\5H%\2\u0137\u0135\3\2\2\2\u0137\u0136\3\2\2\2\u0138\u0140\3\2\2"+
		"\2\u0139\u013c\7\6\2\2\u013a\u013d\5D#\2\u013b\u013d\5H%\2\u013c\u013a"+
		"\3\2\2\2\u013c\u013b\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u0139\3\2\2\2\u013f"+
		"\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0144\3\2"+
		"\2\2\u0142\u0140\3\2\2\2\u0143\u0137\3\2\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\65\3\2\2\2\u0145\u0146\t\2\2\2\u0146\u0147\7\24\2\2\u0147\u0150\5F$\2"+
		"\u0148\u014d\5P)\2\u0149\u014a\7\6\2\2\u014a\u014c\5P)\2\u014b\u0149\3"+
		"\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0148\3\2\2\2\u0150\u0151\3\2"+
		"\2\2\u0151\u0152\3\2\2\2\u0152\u0153\7\7\2\2\u0153\u0169\3\2\2\2\u0154"+
		"\u0155\t\3\2\2\u0155\u0156\7\24\2\2\u0156\u015b\5P)\2\u0157\u0158\7\6"+
		"\2\2\u0158\u015a\5P)\2\u0159\u0157\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e"+
		"\u015f\7\7\2\2\u015f\u0169\3\2\2\2\u0160\u0169\7\33\2\2\u0161\u0166\5"+
		"8\35\2\u0162\u0163\7\24\2\2\u0163\u0164\5P)\2\u0164\u0165\7\7\2\2\u0165"+
		"\u0167\3\2\2\2\u0166\u0162\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0169\3\2"+
		"\2\2\u0168\u0145\3\2\2\2\u0168\u0154\3\2\2\2\u0168\u0160\3\2\2\2\u0168"+
		"\u0161\3\2\2\2\u0169\67\3\2\2\2\u016a\u016b\t\4\2\2\u016b9\3\2\2\2\u016c"+
		"\u0170\5<\37\2\u016d\u0170\5> \2\u016e\u0170\5@!\2\u016f\u016c\3\2\2\2"+
		"\u016f\u016d\3\2\2\2\u016f\u016e\3\2\2\2\u0170;\3\2\2\2\u0171\u0172\7"+
		"!\2\2\u0172\u0173\t\5\2\2\u0173\u0174\t\6\2\2\u0174\u0175\7\'\2\2\u0175"+
		"\u017e\5L\'\2\u0176\u017a\7(\2\2\u0177\u0179\5\60\31\2\u0178\u0177\3\2"+
		"\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u017d\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017f\7\20\2\2\u017e\u0176\3"+
		"\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\7\7\2\2\u0181"+
		"=\3\2\2\2\u0182\u0183\7!\2\2\u0183\u0184\7\66\2\2\u0184\u0185\7\7\2\2"+
		"\u0185?\3\2\2\2\u0186\u0187\7!\2\2\u0187\u018c\5L\'\2\u0188\u0189\7\6"+
		"\2\2\u0189\u018b\5L\'\2\u018a\u0188\3\2\2\2\u018b\u018e\3\2\2\2\u018c"+
		"\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018f\3\2\2\2\u018e\u018c\3\2"+
		"\2\2\u018f\u0190\7\7\2\2\u0190A\3\2\2\2\u0191\u0192\7)\2\2\u0192\u0193"+
		"\5L\'\2\u0193\u0194\7\7\2\2\u0194C\3\2\2\2\u0195\u01a2\5L\'\2\u0196\u0197"+
		"\5L\'\2\u0197\u0198\7\66\2\2\u0198\u0199\7*\2\2\u0199\u01a2\3\2\2\2\u019a"+
		"\u019c\5L\'\2\u019b\u019d\7+\2\2\u019c\u019b\3\2\2\2\u019c\u019d\3\2\2"+
		"\2\u019d\u019e\3\2\2\2\u019e\u019f\7,\2\2\u019f\u01a0\7\66\2\2\u01a0\u01a2"+
		"\3\2\2\2\u01a1\u0195\3\2\2\2\u01a1\u0196\3\2\2\2\u01a1\u019a\3\2\2\2\u01a2"+
		"E\3\2\2\2\u01a3\u01a4\7\65\2\2\u01a4G\3\2\2\2\u01a5\u01a6\7\65\2\2\u01a6"+
		"I\3\2\2\2\u01a7\u01a8\7-\2\2\u01a8\u01a9\7\65\2\2\u01a9\u01aa\7-\2\2\u01aa"+
		"K\3\2\2\2\u01ab\u01ac\7.\2\2\u01ac\u01ad\7\65\2\2\u01adM\3\2\2\2\u01ae"+
		"\u01af\7/\2\2\u01af\u01b0\7\65\2\2\u01b0\u01b1\7/\2\2\u01b1O\3\2\2\2\u01b2"+
		"\u01b7\7\65\2\2\u01b3\u01b4\7\64\2\2\u01b4\u01b6\7\65\2\2\u01b5\u01b3"+
		"\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8"+
		"Q\3\2\2\2\u01b9\u01b7\3\2\2\2\64Y_cflouw~\u0080\u0083\u008b\u0094\u0099"+
		"\u009d\u00a2\u00a7\u00b9\u00bd\u00c3\u00c9\u00cf\u00d3\u00e3\u00ea\u00f3"+
		"\u0105\u010a\u010e\u0115\u011d\u0121\u012a\u0133\u0137\u013c\u0140\u0143"+
		"\u014d\u0150\u015b\u0166\u0168\u016f\u017a\u017e\u018c\u019c\u01a1\u01b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}