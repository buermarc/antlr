package org.parser;//// Generated from Stub.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StubParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, ID=26, STRING=27, ESC=28, INT=29, FLOAT=30, WS=31, SL_COMMENT=32;
	public static final int
		RULE_file = 0, RULE_arrayDecl = 1, RULE_varDecl = 2, RULE_type = 3, RULE_functionDecl = 4, 
		RULE_formalParameters = 5, RULE_formalParameter = 6, RULE_block = 7, RULE_stat = 8, 
		RULE_expr = 9, RULE_exprList = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "arrayDecl", "varDecl", "type", "functionDecl", "formalParameters", 
			"formalParameter", "block", "stat", "expr", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'mut'", "'['", "']'", "';'", "'='", "'[]'", "'float'", 
			"'int'", "'void'", "'('", "')'", "','", "'{'", "'}'", "'if'", "'then'", 
			"'else'", "'return'", "'-'", "'!'", "'*'", "'/'", "'+'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "ID", "STRING", "ESC", "INT", "FLOAT", "WS", "SL_COMMENT"
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
	public String getGrammarFileName() { return "Stub.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StubParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(24);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
				case T__8:
				case T__9:
					{
					setState(22);
					functionDecl();
					}
					break;
				case T__0:
					{
					setState(23);
					varDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0) );
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

	public static class ArrayDeclContext extends ParserRuleContext {
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
	 
		public ArrayDeclContext() { }
		public void copyFrom(ArrayDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayDeclarationContext extends ArrayDeclContext {
		public Token mutable;
		public TypeContext varType;
		public Token count;
		public Token identifier;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT() { return getToken(StubParser.INT, 0); }
		public TerminalNode ID() { return getToken(StubParser.ID, 0); }
		public ArrayDeclarationContext(ArrayDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_arrayDecl);
		int _la;
		try {
			_localctx = new ArrayDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(29);
				((ArrayDeclarationContext)_localctx).mutable = match(T__1);
				}
			}

			setState(32);
			((ArrayDeclarationContext)_localctx).varType = type(0);
			setState(33);
			match(T__2);
			setState(34);
			((ArrayDeclarationContext)_localctx).count = match(INT);
			setState(35);
			match(T__3);
			setState(36);
			((ArrayDeclarationContext)_localctx).identifier = match(ID);
			setState(37);
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

	public static class VarDeclContext extends ParserRuleContext {
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	 
		public VarDeclContext() { }
		public void copyFrom(VarDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDeclarationContext extends VarDeclContext {
		public Token mutable;
		public TypeContext varType;
		public Token identifier;
		public ExprContext expression;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(StubParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclarationContext(VarDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDecl);
		int _la;
		try {
			_localctx = new VarDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__0);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(40);
				((VarDeclarationContext)_localctx).mutable = match(T__1);
				}
			}

			setState(43);
			((VarDeclarationContext)_localctx).varType = type(0);
			setState(44);
			((VarDeclarationContext)_localctx).identifier = match(ID);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(45);
				match(T__5);
				setState(46);
				((VarDeclarationContext)_localctx).expression = expr(0);
				}
			}

			setState(49);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(52);
				match(T__7);
				}
				break;
			case T__8:
				{
				setState(53);
				match(T__8);
				}
				break;
			case T__9:
				{
				setState(54);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(57);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(58);
					match(T__6);
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext fnType;
		public Token id;
		public FormalParametersContext params;
		public BlockContext bl;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(StubParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			((FunctionDeclContext)_localctx).fnType = type(0);
			setState(65);
			((FunctionDeclContext)_localctx).id = match(ID);
			setState(66);
			match(T__10);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) {
				{
				setState(67);
				((FunctionDeclContext)_localctx).params = formalParameters();
				}
			}

			setState(70);
			match(T__11);
			setState(71);
			((FunctionDeclContext)_localctx).bl = block();
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

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			formalParameter();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(74);
				match(T__12);
				setState(75);
				formalParameter();
				}
				}
				setState(80);
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

	public static class FormalParameterContext extends ParserRuleContext {
		public Token mutable;
		public TypeContext paramType;
		public Token id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(StubParser.ID, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(81);
				((FormalParameterContext)_localctx).mutable = match(T__1);
				}
			}

			setState(84);
			((FormalParameterContext)_localctx).paramType = type(0);
			setState(85);
			((FormalParameterContext)_localctx).id = match(ID);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__13);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << ID) | (1L << STRING) | (1L << INT) | (1L << FLOAT))) != 0)) {
				{
				{
				setState(88);
				stat();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__14);
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprVarDeclContext extends StatContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExprVarDeclContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterExprVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitExprVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitExprVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends StatContext {
		public Token ret;
		public ExprContext returnE;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseContext extends StatContext {
		public ExprContext expression;
		public StatContext thenBlock;
		public StatContext elseBlock;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public IfElseContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprArrayDeclContext extends StatContext {
		public ArrayDeclContext arrayDecl() {
			return getRuleContext(ArrayDeclContext.class,0);
		}
		public ExprArrayDeclContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterExprArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitExprArrayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitExprArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBlockContext extends StatContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprBlockContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterExprBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitExprBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitExprBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends StatContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignExprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stat);
		int _la;
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new ExprBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				block();
				}
				break;
			case 2:
				_localctx = new ExprVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				varDecl();
				}
				break;
			case 3:
				_localctx = new ExprArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				arrayDecl();
				}
				break;
			case 4:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				match(T__15);
				setState(100);
				((IfElseContext)_localctx).expression = expr(0);
				setState(101);
				match(T__16);
				setState(102);
				((IfElseContext)_localctx).thenBlock = stat();
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(103);
					match(T__17);
					setState(104);
					((IfElseContext)_localctx).elseBlock = stat();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				((ReturnContext)_localctx).ret = match(T__18);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__19) | (1L << T__20) | (1L << ID) | (1L << STRING) | (1L << INT) | (1L << FLOAT))) != 0)) {
					{
					setState(108);
					((ReturnContext)_localctx).returnE = expr(0);
					}
				}

				setState(111);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new AssignExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(112);
				((AssignExprContext)_localctx).left = expr(0);
				setState(113);
				match(T__5);
				setState(114);
				((AssignExprContext)_localctx).right = expr(0);
				setState(115);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new ExpressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(117);
				expr(0);
				setState(118);
				match(T__4);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FloatContext extends ExprContext {
		public Token number;
		public TerminalNode FLOAT() { return getToken(StubParser.FLOAT, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends ExprContext {
		public Token id;
		public TerminalNode ID() { return getToken(StubParser.ID, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CoverContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CoverContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterCover(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitCover(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitCover(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ExprContext {
		public Token number;
		public TerminalNode INT() { return getToken(StubParser.INT, 0); }
		public NumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FlipEContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FlipEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterFlipE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitFlipE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitFlipE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public ExprContext left;
		public Token mathChar;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompareContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends ExprContext {
		public Token id;
		public ExprListContext expressions;
		public TerminalNode ID() { return getToken(StubParser.ID, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FunctionCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExprContext {
		public Token chars;
		public TerminalNode STRING() { return getToken(StubParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegativeEContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegativeEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterNegativeE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitNegativeE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitNegativeE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexEContext extends ExprContext {
		public ExprContext array;
		public ExprContext index;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IndexEContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterIndexE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitIndexE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitIndexE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivContext extends ExprContext {
		public ExprContext left;
		public Token mathChar;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(123);
				((FunctionCallContext)_localctx).id = match(ID);
				setState(124);
				match(T__10);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__19) | (1L << T__20) | (1L << ID) | (1L << STRING) | (1L << INT) | (1L << FLOAT))) != 0)) {
					{
					setState(125);
					((FunctionCallContext)_localctx).expressions = exprList();
					}
				}

				setState(128);
				match(T__11);
				}
				break;
			case 2:
				{
				_localctx = new NegativeEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(T__19);
				setState(130);
				expr(10);
				}
				break;
			case 3:
				{
				_localctx = new FlipEContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(T__20);
				setState(132);
				expr(9);
				}
				break;
			case 4:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				((IdentifierContext)_localctx).id = match(ID);
				}
				break;
			case 5:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				((NumberContext)_localctx).number = match(INT);
				}
				break;
			case 6:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				((FloatContext)_localctx).number = match(FLOAT);
				}
				break;
			case 7:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				((StringContext)_localctx).chars = match(STRING);
				}
				break;
			case 8:
				{
				_localctx = new CoverContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(T__10);
				setState(138);
				expr(0);
				setState(139);
				match(T__11);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(157);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivContext(new ExprContext(_parentctx, _parentState));
						((MultDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(144);
						((MultDivContext)_localctx).mathChar = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((MultDivContext)_localctx).mathChar = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(145);
						((MultDivContext)_localctx).right = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						((AddSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(147);
						((AddSubContext)_localctx).mathChar = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__23) ) {
							((AddSubContext)_localctx).mathChar = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(148);
						((AddSubContext)_localctx).right = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new CompareContext(new ExprContext(_parentctx, _parentState));
						((CompareContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(150);
						match(T__24);
						setState(151);
						((CompareContext)_localctx).right = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new IndexEContext(new ExprContext(_parentctx, _parentState));
						((IndexEContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(152);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(153);
						match(T__2);
						setState(154);
						((IndexEContext)_localctx).index = expr(0);
						setState(155);
						match(T__3);
						}
						break;
					}
					} 
				}
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StubListener ) ((StubListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StubVisitor ) return ((StubVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			expr(0);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(163);
				match(T__12);
				setState(164);
				expr(0);
				}
				}
				setState(169);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00ad\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\6\2\33\n\2\r\2\16\2\34\3\3\3\3\5\3!\n\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\5\4,\n\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\5\5:\n\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5\3\6\3\6\3\6"+
		"\3\6\5\6G\n\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7O\n\7\f\7\16\7R\13\7\3\b\5\b"+
		"U\n\b\3\b\3\b\3\b\3\t\3\t\7\t\\\n\t\f\t\16\t_\13\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\nl\n\n\3\n\3\n\5\np\n\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n{\n\n\3\13\3\13\3\13\3\13\5\13\u0081\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0090\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u00a0\n\13\f\13\16\13\u00a3\13\13\3\f\3\f\3\f\7\f\u00a8\n\f\f\f"+
		"\16\f\u00ab\13\f\3\f\2\4\b\24\r\2\4\6\b\n\f\16\20\22\24\26\2\4\3\2\30"+
		"\31\4\2\26\26\32\32\2\u00c2\2\32\3\2\2\2\4\36\3\2\2\2\6)\3\2\2\2\b9\3"+
		"\2\2\2\nB\3\2\2\2\fK\3\2\2\2\16T\3\2\2\2\20Y\3\2\2\2\22z\3\2\2\2\24\u008f"+
		"\3\2\2\2\26\u00a4\3\2\2\2\30\33\5\n\6\2\31\33\5\6\4\2\32\30\3\2\2\2\32"+
		"\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\3\3\2\2\2\36"+
		" \7\3\2\2\37!\7\4\2\2 \37\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\5\b\5\2#$\7"+
		"\5\2\2$%\7\37\2\2%&\7\6\2\2&\'\7\34\2\2\'(\7\7\2\2(\5\3\2\2\2)+\7\3\2"+
		"\2*,\7\4\2\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\5\b\5\2.\61\7\34\2\2/\60"+
		"\7\b\2\2\60\62\5\24\13\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64"+
		"\7\7\2\2\64\7\3\2\2\2\65\66\b\5\1\2\66:\7\n\2\2\67:\7\13\2\28:\7\f\2\2"+
		"9\65\3\2\2\29\67\3\2\2\298\3\2\2\2:?\3\2\2\2;<\f\6\2\2<>\7\t\2\2=;\3\2"+
		"\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\t\3\2\2\2A?\3\2\2\2BC\5\b\5\2CD\7"+
		"\34\2\2DF\7\r\2\2EG\5\f\7\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7\16\2\2I"+
		"J\5\20\t\2J\13\3\2\2\2KP\5\16\b\2LM\7\17\2\2MO\5\16\b\2NL\3\2\2\2OR\3"+
		"\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\r\3\2\2\2RP\3\2\2\2SU\7\4\2\2TS\3\2\2\2TU"+
		"\3\2\2\2UV\3\2\2\2VW\5\b\5\2WX\7\34\2\2X\17\3\2\2\2Y]\7\20\2\2Z\\\5\22"+
		"\n\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7"+
		"\21\2\2a\21\3\2\2\2b{\5\20\t\2c{\5\6\4\2d{\5\4\3\2ef\7\22\2\2fg\5\24\13"+
		"\2gh\7\23\2\2hk\5\22\n\2ij\7\24\2\2jl\5\22\n\2ki\3\2\2\2kl\3\2\2\2l{\3"+
		"\2\2\2mo\7\25\2\2np\5\24\13\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2q{\7\7\2\2"+
		"rs\5\24\13\2st\7\b\2\2tu\5\24\13\2uv\7\7\2\2v{\3\2\2\2wx\5\24\13\2xy\7"+
		"\7\2\2y{\3\2\2\2zb\3\2\2\2zc\3\2\2\2zd\3\2\2\2ze\3\2\2\2zm\3\2\2\2zr\3"+
		"\2\2\2zw\3\2\2\2{\23\3\2\2\2|}\b\13\1\2}~\7\34\2\2~\u0080\7\r\2\2\177"+
		"\u0081\5\26\f\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\u0090\7\16\2\2\u0083\u0084\7\26\2\2\u0084\u0090\5\24\13\f\u0085"+
		"\u0086\7\27\2\2\u0086\u0090\5\24\13\13\u0087\u0090\7\34\2\2\u0088\u0090"+
		"\7\37\2\2\u0089\u0090\7 \2\2\u008a\u0090\7\35\2\2\u008b\u008c\7\r\2\2"+
		"\u008c\u008d\5\24\13\2\u008d\u008e\7\16\2\2\u008e\u0090\3\2\2\2\u008f"+
		"|\3\2\2\2\u008f\u0083\3\2\2\2\u008f\u0085\3\2\2\2\u008f\u0087\3\2\2\2"+
		"\u008f\u0088\3\2\2\2\u008f\u0089\3\2\2\2\u008f\u008a\3\2\2\2\u008f\u008b"+
		"\3\2\2\2\u0090\u00a1\3\2\2\2\u0091\u0092\f\n\2\2\u0092\u0093\t\2\2\2\u0093"+
		"\u00a0\5\24\13\13\u0094\u0095\f\t\2\2\u0095\u0096\t\3\2\2\u0096\u00a0"+
		"\5\24\13\n\u0097\u0098\f\b\2\2\u0098\u0099\7\33\2\2\u0099\u00a0\5\24\13"+
		"\t\u009a\u009b\f\r\2\2\u009b\u009c\7\5\2\2\u009c\u009d\5\24\13\2\u009d"+
		"\u009e\7\6\2\2\u009e\u00a0\3\2\2\2\u009f\u0091\3\2\2\2\u009f\u0094\3\2"+
		"\2\2\u009f\u0097\3\2\2\2\u009f\u009a\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\25\3\2\2\2\u00a3\u00a1\3\2\2"+
		"\2\u00a4\u00a9\5\24\13\2\u00a5\u00a6\7\17\2\2\u00a6\u00a8\5\24\13\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\27\3\2\2\2\u00ab\u00a9\3\2\2\2\25\32\34 +\619?FPT]koz\u0080"+
		"\u008f\u009f\u00a1\u00a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}