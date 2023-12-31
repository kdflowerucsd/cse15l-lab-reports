import java.io.IOException;
import java.net.URI;
import java.util.Vector;
class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int listNum = 0;
    Vector<String> messageBoard = new Vector<String>(1);
    public String handleRequest(URI url) 
    {
         if(url.getPath().equals("/add-messages"))
         {
           String[] parameters = url.getQuery().split("=");
           if(parameters[0].contains("s"))
           {
             String checker = parameters[1];
             String clean = checker.replace("+"," ");
             messageBoard.add(String.format("\n %d. %s", listNum+1,clean));
             String output = "";
             listNum++;
             //return String.format("\n %d . %s", listNum,parameters[1]);
             //messageBoard[listNum]=String.format("\n %d . %s", listNum+1,parameters[1]);
             for (int i=0;i<messageBoard.size(); i++)
             {
                output+=messageBoard.get(i);
             }
             return output;
           } 
    
        } 
         return "404 Not Found!";
    } 
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
/*import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int listNum = 1;

    public String handleRequest(URI url) {
         if(url.getPath().equals("/add-messages")){
           String[] parameters = url.getQuery().split("=");
           if(parameters[0].contains("s")){
             return String.format("/n",listNum, ". ", parameters[1]);
         } 
      
      /* if (url.getPath().equals("/")) {
            return String.format("Number: %d", num);
        } else if (url.getPath().equals("/increment")) {
            num += 1;
            return String.format("Number incremented!");
        } else {
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("count")) {
                    num += Integer.parseInt(parameters[1]);
                    return String.format("Number increased by %s! It's now %d", parameters[1], num);
                }
            }
          
        } 
         return "404 Not Found!";
    } 
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
*/
