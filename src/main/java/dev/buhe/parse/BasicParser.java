package dev.buhe.parse;

import java.util.HashSet;

import dev.buhe.ast.*;
import dev.buhe.lex.Lexer;
import dev.buhe.lex.Token;
import dev.buhe.lib.Parser;
import dev.buhe.lib.Parser.Operators;

import static dev.buhe.lib.Parser.rule;

/**
 * A basic parser for grammatical analysis
 */
public class BasicParser {
    HashSet<String> reserved = new HashSet<>();
    Operators operators = new Operators();

    Parser expr0 = rule();

    Parser primary = rule(PrimaryExpr.class).or(
            rule().sep("(").ast(expr0).sep(")"),
            rule().number(NumberLiteral.class),
            rule().identifier(Name.class, reserved),
            rule().string(StringLiteral.class));

    Parser factor = rule().or(rule(NegativeExpr.class).sep("-").ast(primary), primary);

    Parser expr = expr0.expression(BinaryExpr.class, factor, operators);

    Parser statement0 = rule();

    Parser block = rule(BlockStmnt.class)
            .sep("{").option(statement0)
            .repeat(rule().sep(";", Token.EOL).option(statement0))
            .sep("}");

    Parser simple = rule(PrimaryExpr.class).ast(expr);

    Parser forPrefix = rule().sep("(").ast(expr).sep(";").ast(expr).sep(";").ast(expr).sep(")");

    Parser statement = statement0.or(
            rule(IfStmnt.class).sep("if").ast(expr).ast(block).option(rule().sep("else").ast(block)),
            rule(WhileStmnt.class).sep("while").ast(expr).ast(block),
            rule(ForStmnt.class).sep("for").ast(forPrefix).ast(block),
            simple);

    Parser program = rule().or(statement, rule(NullStmnt.class)).sep(";", Token.EOL);

    public BasicParser() {
        reserved.add(";");
        reserved.add("}");
        reserved.add(Token.EOL);

        operators.add("=", 1, Operators.RIGHT);
        operators.add("==", 2, Operators.LEFT);
        operators.add(">", 2, Operators.LEFT);
        operators.add("<", 2, Operators.LEFT);
        operators.add("+", 3, Operators.LEFT);
        operators.add("-", 3, Operators.LEFT);
        operators.add("*", 4, Operators.LEFT);
        operators.add("/", 4, Operators.LEFT);
        operators.add("%", 4, Operators.LEFT);
    }

    public ASTree parse(Lexer lexer) throws ParseException {
        return program.parse(lexer);
    }
}
