package org.parser;//// Generated from Stub.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StubParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StubVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StubParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(StubParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDeclaration}
	 * labeled alternative in {@link StubParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(StubParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link StubParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(StubParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link StubParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(StubParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link StubParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(StubParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link StubParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(StubParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link StubParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(StubParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprBlock}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBlock(StubParser.ExprBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVarDecl}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVarDecl(StubParser.ExprVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(StubParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(StubParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(StubParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link StubParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(StubParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(StubParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Maths}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaths(StubParser.MathsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(StubParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Cover}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCover(StubParser.CoverContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(StubParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FlipE}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlipE(StubParser.FlipEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(StubParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(StubParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(StubParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegativeE}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeE(StubParser.NegativeEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexE}
	 * labeled alternative in {@link StubParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexE(StubParser.IndexEContext ctx);
	/**
	 * Visit a parse tree produced by {@link StubParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(StubParser.ExprListContext ctx);
}