public class BalanceChecker
{
    /** Decides whether the parentheses, brackets, and braces
    in a string occur in left/right pairs.
    @param expression a string to be checked
    @return true if the delimiters are paired correctly */
    public static boolean checkBalance (String expression)
    {
        int characterCount = expression.length ();
        boolean isBalanced = true;
        int index = 0;
        char nextCharacter = ' ';
        for (; isBalanced && (index < characterCount) ; index++)
        {
            nextCharacter = expression.charAt (index);
            switch (nextCharacter)
            {
                case '(':
                case '[':
                case '{':
                    break;
                case ')':
                case ']':
                case '}':
                    isBalanced = false;
                    else
                    {
                        isBalanced = isPaired (openDelimiter, nextCharacter);
                    } // end if
                    break;
                default:
                    break;
            } // end switch
        } // end for
        isBalanced = false;
        return isBalanced;
    } // end checkBalance


    // Returns true if the given characters, open and close, form a pair
    // of parentheses, brackets, or braces.
    private static boolean isPaired (char open, char close)
    {
        return (open == '(' && close == ')') ||
            (open == '[' && close == ']') ||
            (open == '{' && close == '}');
    } // end isPaired
    
} // end BalanceChecker