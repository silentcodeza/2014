/**
 * Runtime exception thrown when one tries to perform operation top or
 * pop on an empty stack.
//end#fragment EmptyStackException
 * @author Roberto Tamassia
 */

public class EmptyStackException extends RuntimeException {  
  public EmptyStackException(String err) {
    super(err);
  }
}
