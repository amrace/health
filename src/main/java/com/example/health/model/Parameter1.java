/*
 * package com.example.health.model;
 * 
 * import java.io.InputStreamReader; import java.net.HttpURLConnection; import
 * java.net.URL;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.health.parameterRepository.ParameterRepo; import
 * com.google.gson.Gson;
 * 
 * @RestController
 * 
 * @RequestMapping("test") public class Parameter1 {
 * 
 * @Autowired private ParameterRepo parameterRepository;
 * 
 * 
 *//***************************************
	 * static variables are set here
	 ********************************************************/
/*
 * 
 * public static String url =
 * " ";
 * public static Parameter[] parameter = null; //private static Connection
 * connection ;
 * 
 *//********************************************
	 * static variables are set here
	 ***************************************************/
/*

*//**********
	 * jason data are converted and save into mysql dabase in this specific method
	 ***************************************************//*
															 * 
															 * public static void storeDataSql() { Gson gson = new
															 * Gson(); try { URL url1 = new URL(url); HttpURLConnection
															 * httpURLConnection = (HttpURLConnection)
															 * url1.openConnection(); InputStreamReader
															 * inputStreamReader = new
															 * InputStreamReader(httpURLConnection.getInputStream());
															 * parameter = gson.fromJson(inputStreamReader,
															 * Parameter[].class); String sql1 =
															 * "INSERT INTO `healthstation`.`parameter` ( `year`, `petroleum_product`, `sale`) VALUES ( ?, ?, ?)"
															 * ;
															 * 
															 * //connection = DbConnection.connectionDb();
															 * //PreparedStatement statement =
															 * connection.prepareStatement(sql1); Integer obj = null;
															 * for (Parameter op : parameter) { String name =
															 * op.getPetroleum_product(); String year = op.getYear();
															 * String sale = op.getSale();
															 * 
															 * //statement.setInt(1, year); //statement.setString(2,
															 * name); //statement.setInt(3, sale); // obj =
															 * statement.executeUpdate(); } if (obj > 0) {
															 * System.out.println("data are inserted inside the table");
															 * } } catch (Exception e) { System.out.println(e); } }
															 * 
															 * 
															 * 
															 * }
															 */