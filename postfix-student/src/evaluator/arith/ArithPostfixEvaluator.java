package evaluator.arith;

import language.Operand;
import language.Operator;
import parser.IllegalPostfixExpressionException;
import parser.PostfixParser.Type;
import parser.Token;
import parser.arith.ArithPostfixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.PostfixEvaluator;

/**
 * An {@link ArithPostfixEvaluator} is a postfix evaluator over simple
 * arithmetic expressions.
 *
 */
public class ArithPostfixEvaluator implements PostfixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;

	/**
	 * Constructs an {@link ArithPostfixEvaluator}
	 */
	public ArithPostfixEvaluator(){
		this.stack = new LinkedStack<Operand<Integer>>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) throws IllegalPostfixExpressionException {
		ArithPostfixParser parser = new ArithPostfixParser(expr);
		for (Token<Integer> token : parser) {
			Type type = token.getType();
			switch(type){ 
			case OPERAND:
		       Operand<Integer> operation = token.getOperand();
		       this.stack.push(operation);
				break;
			case OPERATOR:
            Operator<Integer> op1 = token.getOperator();
            int num = op1.getNumberOfArguments(); 
            if(num == 2){
            	Operand<Integer> oper = stack.pop();
            	op1.setOperand(1, oper);
            	Operand<Integer> oper2 = stack.pop();
            	op1.setOperand(0, oper2);
            }
            
            else if(num == 1)
            	 {
            		 Operand<Integer> oper = stack.pop();
                 	op1.setOperand(0, oper);
            	 }
            
              Operand<Integer> a = op1.performOperation();
              stack.push(a);
            
				break;
			default:
				throw new IllegalStateException("Parser returned an invalid Type: " + type);
			}						
		}		
		  Operand<Integer> pop = stack.pop();
		  if(!stack.isEmpty())
			  throw new IllegalPostfixExpressionException("");
		return pop.getValue();
	}

}
