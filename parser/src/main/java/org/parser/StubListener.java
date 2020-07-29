package org.parser;//// Generated from Stub.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StubParser}.
 */
public interface StubListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StubParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(StubParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link StubParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(StubParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDeclaration}
	 * labeled alternative in {@link StubParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(StubParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDeclaration}
	 * labeled alternative in {@link StubParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(StubParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link StubParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(StubParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link StubParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(StubParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link StubParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(StubParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link StubParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(StubParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link StubParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(StubParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link StubParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(StubParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link StubParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(StubParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link StubParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(StubParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link StubParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(StubParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link StubParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(StubParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprBlock}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprBlock(StubParser.ExprBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprBlock}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprBlock(StubParser.ExprBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprVarDecl}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprVarDecl(StubParser.ExprVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprVarDecl}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprVarDecl(StubParser.ExprVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(StubParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(StubParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturn(StubParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturn(StubParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(StubParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(StubParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExpression(StubParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExpression(StubParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Float}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloat(StubParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloat(StubParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Maths}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMaths(StubParser.MathsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Maths}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMaths(StubParser.MathsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(StubParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(StubParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Cover}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCover(StubParser.CoverContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Cover}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCover(StubParser.CoverContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(StubParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(StubParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FlipE}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFlipE(StubParser.FlipEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FlipE}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFlipE(StubParser.FlipEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompare(StubParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompare(StubParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(StubParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(StubParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(StubParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(StubParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegativeE}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegativeE(StubParser.NegativeEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegativeE}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegativeE(StubParser.NegativeEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexE}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexE(StubParser.IndexEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexE}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexE(StubParser.IndexEContext ctx);
	/**
	 * Enter a parse tree produced by {@link StubParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(StubParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link StubParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(StubParser.ExprListContext ctx);
}