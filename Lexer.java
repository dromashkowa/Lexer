import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by danya on 29.04.2018.
 */
public class Lexer {
    static Map<String, String> lexem = new HashMap<String, String>();
    public Lexer()
    {
        lexem.put("VAR", "^[a..z]+$");
        lexem.put("NUM", "^0|[1-9][0-9]*$");
        lexem.put("OP", "^[-|+|/|*]$");
        lexem.put("ASSIGN_OP", "^=$");
    }

    Queue<Token> MakeTokens(String test)
    {
        Queue<Token> tokens = new LinkedList();
        String temp = "";
        for(int i = 0; i < test.length(); ++i)
        {
            if (test.toCharArray()[i] != ' ')
            {
                temp = temp + test.toCharArray()[i];
            }
            String temp2 = "";
            if (i < test.length() - 1)
            {
                temp2 = temp + test.toCharArray()[i + 1];
            }

            Iterator iter = lexem.keySet().iterator();
            while (iter.hasNext())
            {
                String key = (String)iter.next();
                Pattern p = Pattern.compile((String)lexem.get(key));
                Matcher matchForTemp = p.matcher(temp);
                Matcher matchForTemp2 = p.matcher(temp2);
                if (matchForTemp.find() && !matchForTemp2.find())
                {
                    tokens.add(new Token(key.toString(), temp));
                    temp = "";
                }
            }

        }
        return tokens;
    }
}
