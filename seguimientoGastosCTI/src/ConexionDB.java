import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
    private static String url;
    private static String usuario;
    private static String password;

    public ConexionDB() {
    }

    public ConexionDB(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void conectarDB(String createTableQuery, String insertQuery ){
        // Configurar los parámetros de conexión
         url = "jdbc:h2:~/test"; // URL de conexión a la base de datos H2
         usuario = "sa"; // Nombre de usuario de la base de datos
         password = ""; // Contraseña de la base de datos

        try {
            // Establecer la conexión
            Connection connection = DriverManager.getConnection(url, usuario, password);

            // Realizar operaciones en la base de datos
            System.out.println("Conexion establecida");

            // Crear una declaración SQL
            Statement statement = connection.createStatement();

            // Crear la tabla
            /*String createTableQuery = "CREATE TABLE IF NOT EXISTS usuarios (id INT PRIMARY KEY, nombre VARCHAR(50))";*/
            statement.executeUpdate(createTableQuery);
            System.out.println("Tabla usuarios creada¡");

            // Insertar registros
            /*String insertQuery = "INSERT INTO usuarios VALUES (7, 'John Doe'), (8, 'Jane Smith')";*/
            statement.executeUpdate(insertQuery);
            System.out.println("Registros insertados con éxito en la tabla 'usuarios'.");

            // Cerrar la conexión
            statement.close();
            connection.close();
            System.out.println("Conexion cerrada¡");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
