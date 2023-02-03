import java.sql.*;
/**
 *
 * @author esmeldy
 * Esta clase será la encargada de gestionar 
 * los registros de la base de datos
 * 
 */
public class dbDepartamentos {
    /**
     * Método que permite listar los departamentos 
     * de la tabla departamentos
     * @return 
     */
    //Listar o Mostra
    public String Listar(){
       String txt = "";
       //Bloque try-catch para capturar posibles errores

       try{
           //primer paso...Cargar el driver
           Class.forName("com.mysql.jdbc.Driver");
           
           //segundo...crear la conexion
           String User = "Jefe";
           String Pass = "jefe";
           
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/NOmbreDeBaseDeDatos", User,Pass);
           
           //preparar la consulta
           Statement consulta = cn.createStatement();
           
           //almacenar el resultado de la consulta en una colección
           ResultSet resultado = consulta.executeQuery("SELECT CODIGO, NOMBRE, IDLOCALIZACION, IDMANAGER FROM DEPARTAMENTOS;");
           
           txt = "Código\tNombre\t\tID de localización\tID de manager\n\n";
           
           while (resultado.next()) {
               txt += resultado.getInt(1)+
                       "\t"+resultado.getString(2)+
                       "\t\t"+resultado.getInt(3)+
                       "\t\t"+resultado.getInt(4)+"\n";
           }
           cn.close();
           consulta.close();
           resultado.close();
       }
       catch (Exception e){
           txt = "Error al listar " +e.getMessage();
       }
    return txt;
    }//Fin Listar
    
    //Modificar
    public String Modificar(int cod, String nombre, int idLoc, int idMan){
       String txt = "";


       try{
           //primer paso...Cargar el driver
           Class.forName("com.mysql.jdbc.Driver");
           
           //segundo...crear la conexion
           String User = "Jefe";
           String Pass = "jefe";
           
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/03174791D", User,Pass);
           
           //preparar la consulta
           Statement consulta = cn.createStatement();
           String sql = "UPDATE DEPARTAMENTOS SET NOMBRE= '"+nombre+"', "
                   + "IDLOCALIZACION = "+idLoc+", "
                   + "IDMANAGER = "+idMan+" WHERE CODIGO = "+cod+"";
           
           //almacenar el resultado de la consulta en un entero
           int resultado = consulta.executeUpdate(sql);
           
           if (resultado==1) {
               txt += "Campo modificado correctamente";
           }
           else {
               txt = "El código "+cod+" no se encuentra en la tabla";
           }
           
           cn.close();
           consulta.close();
           
       }
       catch (Exception e){
           txt = "Error al modificar campo " +e.getMessage();
       }
    return txt;
    }//Fin de Modificar
    
    
    //Insertar
    public String Insertar(int cod, String nombre, int idLoc, int idMan) throws SQLException{
       String txt = "";

       Connection cn = null;
       try{
           //primer paso...Cargar el driver
           Class.forName("com.mysql.jdbc.Driver");
           
           //segundo...crear la conexion
           String User = "Jefe";
           String Pass = "jefe";
           
           cn = DriverManager.getConnection("jdbc:mysql://localhost/03174791D", User,Pass);
           
           //preparar la consulta
           Statement consulta = cn.createStatement();
           String sql = "INSERT INTO DEPARTAMENTOS VALUES ("
                   +cod+", '"+nombre+"', "+idLoc+", "+idMan+");";
           
           //almacenar el resultado de la consulta en un entero
           int resultado = consulta.executeUpdate(sql);
           
           if (resultado==1) {
               txt += "Nuevo registro añadido correctamente";
           }
           //No es necesario porque en caso de que no se realice la consulta
           //Salta al catch
//           else {
//               txt = "El código "+cod+" ya se encuentra en la tabla";
//           }
           
           cn.close();
           consulta.close();
           
       }
       catch (Exception e){
           txt = "Error al añadir nuevo registro " +e.getMessage();
       }
       finally {
           cn.close();
       }
    return txt;
    }//Fin Insertar

    //Borrar
    public String Borrar(int cod){
       String txt = "";


       try{
           //primer paso...Cargar el driver
           Class.forName("com.mysql.jdbc.Driver");
           
           //segundo...crear la conexion
           String User = "Jefe";
           String Pass = "jefe";
           
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/03174791D", User,Pass);
           
           //preparar la consulta
           Statement consulta = cn.createStatement();
           String sql = "DELETE FROM DEPARTAMENTOS WHERE CODIGO = "+cod+";";
           
           //almacenar el resultado de la consulta en un entero
           int resultado = consulta.executeUpdate(sql);
           
           if (resultado==1) {
               txt += "registro borrado correctamente";
           }
           else {
               txt = "Error al borrar el registro "+cod;
           }
           
           cn.close();
           consulta.close();
           
       }
       catch (Exception e){
           txt = "Se ha producido un error " +e.getMessage();
       }
    return txt;
    }//Fin de borrar
    
    //Ordenar por
    public String OrdenarPor(int indexJlis){
       String txt = "";
       //Bloque try-catch para capturar posibles errores

       try{
           //primer paso...Cargar el driver
           Class.forName("com.mysql.jdbc.Driver");
           
           //segundo...crear la conexion
           String User = "Jefe";
           String Pass = "jefe";
           
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/03174791D", User,Pass);
           
           //preparar la consulta
           Statement consulta = cn.createStatement();
           String sql = "SELECT * FROM DEPARTAMENTOS ";
           
           //Solo se puede ordenar por un campo
           if ( indexJlis == 0 ){
               sql += "ORDER BY CODIGO";
           }
           if ( indexJlis == 1 ){
               sql += "ORDER BY NOMBRE";
           }
           if ( indexJlis == 2 ){
               sql += "ORDER BY IDLOCALIZACION";
           }
           if ( indexJlis == 3 ){
               sql += "ORDER BY IDMANAGER";
           }
           //almacenar el resultado de la consulta en una colección
           ResultSet resultado = consulta.executeQuery(sql+";");
           
           txt = "Código\tNombre\t\tID de localización\tID de manager\n\n";
           
           while (resultado.next()) {
               txt += resultado.getInt(1)+
                       "\t"+resultado.getString(2)+
                       "\t\t"+resultado.getInt(3)+
                       "\t\t"+resultado.getInt(4)+"\n";
           }
           cn.close();
           consulta.close();
           resultado.close();
       }
       catch (Exception e){
           txt = "Error al listar " +e.getMessage();
       }
       return txt;
    }//Fin ordenarPor
    
    //Buscar
    public String Buscar(String cod, String nombre, String idLoc, String idMan){  
       String txt = "";
       //Bloque try-catch para capturar posibles errores

       try{
           //primer paso...Cargar el driver
           Class.forName("com.mysql.jdbc.Driver");
           
           //segundo...crear la conexion
           String User = "Jefe";
           String Pass = "jefe";
           
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/03174791D", User,Pass);
           
           //preparar la consulta
           Statement consulta = cn.createStatement();
           String sql = "SELECT CODIGO, NOMBRE, IDLOCALIZACION, IDMANAGER FROM DEPARTAMENTOS";
           String W = " WHERE ";
           String Or = " OR ";
           String Cod = "";
           String Nom = "";
           String idLocation = "";
           String idManager = "";
           
           //Controlando campo por campo
           //que no se encuentren vacíos
           if (cod.trim().length() != 0){
               Cod = " CODIGO = "+cod;
           }
           if (nombre.trim().length() != 0){
               Nom = " NOMBRE = +'"+nombre+"'";
           }
           if (idLoc.trim().length() != 0){
               idLocation = "IDLOCALIZACION = "+idLoc;  
           }
           if (idMan.trim().length() != 0) {
               idManager = " IDMANAGER = "+idMan;
           }
           
           //Todos los campos que no esten vacíos
           if (nombre.trim().length() != 0 && 
                   cod.trim().length() != 0 &&
                   idLoc.trim().length() != 0 && 
                   idMan.trim().length() != 0){
               sql = sql + W + Cod + Or +Nom +Or +idLocation +Or +idManager;
           }
           
           //Solo un campo vacío
           if (nombre.trim().length() != 0 && 
                   cod.trim().length() == 0 &&
                   idLoc.trim().length() == 0 && 
                   idMan.trim().length() == 0){
               sql = sql + W + Nom;
           }
           
           if (nombre.trim().length() == 0 && 
                   cod.trim().length() != 0 &&
                   idLoc.trim().length() == 0 && 
                   idMan.trim().length() == 0){
               sql = sql + W + Cod;
           }
           
           if (nombre.trim().length() == 0 && 
                   cod.trim().length() == 0 &&
                   idLoc.trim().length() != 0 && 
                   idMan.trim().length() == 0){
               sql = sql + W + idLocation;
           }
           
           if (nombre.trim().length() == 0 && 
                   cod.trim().length() == 0 &&
                   idLoc.trim().length() == 0 && 
                   idMan.trim().length() != 0){
               sql = sql + W + idManager;
           }
           
           //almacenar el resultado de la consulta en una colección
           ResultSet resultado = consulta.executeQuery(sql);
           
           txt = "Código\tNombre\t\tID de localización\tID de manager\n\n";
           
           while (resultado.next()) {
               txt += resultado.getInt(1)+
                       "\t"+resultado.getString(2)+
                       "\t\t"+resultado.getInt(3)+
                       "\t\t"+resultado.getInt(4)+"\n";
           }
           cn.close();
           consulta.close();
           resultado.close();
       }
       catch (Exception e){
           txt = "Error al listar " +e.getMessage();
       }
    return txt;
    }//Fin Buscar
}