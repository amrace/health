/*
 * package com.example.health.patientcontroller;
 * 
 * import java.io.BufferedReader; import java.io.FileNotFoundException; import
 * java.io.FileReader; import java.io.IOException; import
 * java.io.InputStreamReader; import java.net.HttpURLConnection; import
 * java.net.URL; import java.util.List;
 * 
 * import org.json.JSONObject; import org.json.simple.parser.JSONParser; import
 * org.json.simple.parser.ParseException; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.health.model.Parameter; import
 * com.example.health.model.Patient; import
 * com.example.health.parameterRepository.ParameterRepo;
 * 
 * @RestController
 * 
 * @RequestMapping("/parameter") public class ParameterController {
 * 
 * @Autowired private ParameterRepo parameterRepository;
 * 
 * 
 * 
 * public ParameterController(ParameterRepo parameterRepository) { super();
 * this.parameterRepository = parameterRepository; }
 * 
 * 
 * 
 * @GetMapping("values") public static void readData() {
 * 
 * try {
 * 
 * 
 * String url
 * ="https://raw.githubusercontent.com/younginnovations/internship-challenges/master/programming/petroleum-report/data.json";
 * 
 * URL obj = new URL(url); HttpURLConnection con = (HttpURLConnection)
 * obj.openConnection(); con.setRequestMethod("GET");
 * 
 * int responseCode = con.getResponseCode();
 * System.out.println("\nSending 'GET' request to URL:" +url);
 * System.out.println("Response code:" +responseCode);
 * 
 * BufferedReader in = new BufferedReader(new
 * InputStreamReader(con.getInputStream())); String inputLine; StringBuffer
 * response = new StringBuffer(); while ((inputLine = in.readLine()) != null) {
 * response.append(inputLine); } in.close(); }
 * System.out.println(response.toString());
 * 
 * 
 * 
 * //Read JSON response and print
 * 
 * JSONObject myResponse = new JSONObject(response.toString());
 * myResponse.get("statusCode"); Parameter parameter1 = new Parameter();
 * parameter.setTemperature(myResponse.getString("statusMessage"));
 * parameterRepository.save(myResponse);
 * 
 * 
 * 
 * System.out.println("result after Reading JSON Response"); //
 * System.out.println("statusCode- "+myResponse.getString("statusCode"));
 * System.out.println("statusMessage- "+myResponse.getString("statusMessage"));
 * 
 * 
 * 
 * }catch(e){ System }
 * 
 * }
 * 
 * //for void method }
 */