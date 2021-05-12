package laba4;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet(name="Login", urlPatterns="/JavaCal") //связывание сервлета с URL
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login.RequestCalc Calc = laba4.Login.RequestCalc.fromRequestParameters(request);
        try {
            Calc.setAsRequestAttributesAndCalculate(request);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/Form.jsp").forward(request, response);

    }

    private static class RequestCalc {
        private final String login;
        private final String pass;
        // double result;

        private RequestCalc(String login, String pass) {
            this.login = login;
            this.pass = pass;
        }
        public static Login.RequestCalc fromRequestParameters(HttpServletRequest request) {
            return new Login.RequestCalc(
                    request.getParameter("login"), //ищет по аттрибуту name!!!!!
                    request.getParameter("pass"));
        }

        public void setAsRequestAttributesAndCalculate(HttpServletRequest request) throws IOException, ParseException {
            request.setAttribute("login", login);
            request.setAttribute("pass",pass);
            //request.setAttribute("second_result", second_calc);
            double first_try;
            double second_try;
            boolean chk = false;
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\misha\\Desktop\\git\\pi221team6\\data.json"));
            for (Object o : a) {
                JSONObject person = (JSONObject) o;

                String name = (String) person.get("name");
                String login_ = (String) person.get("login");
                String pass_ = (String) person.get("password");
                if (!login.equals(login_))
                    continue;
                else{
                    if (pass.equals(pass_)){
                        chk = true;
                        request.setAttribute("name", name);
                        break;
                    }
                    else
                        request.setAttribute("name", "Unknown");
                }
            }
            if (!chk)
                request.setAttribute("name", "Unknown");
        }

    }
}