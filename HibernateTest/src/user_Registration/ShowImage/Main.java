package user_Registration.ShowImage;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class Main extends JFrame {

Connection connection = null;
PreparedStatement statement = null;

ResultSet result;

public Main() {
    super("Image Display");
    setSize(600, 600);
    connection = getConnection();
    try { // table name:image and second image is field name
        statement = connection
                .prepareStatement("select image from  image where id = 1");
        result = statement.executeQuery();

        byte[] image = null;
        while (result.next()) {
            image = result.getBytes("image");

        }
        Image img = Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon = new ImageIcon(img);
        JLabel lPhoto = new JLabel();
        lPhoto.setIcon(icon);
        add(lPhoto);

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    setVisible(true);
}

public Connection getConnection() {
    Connection connection = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                // user name:root and password:blank
                "jdbc:mysql://localhost:3306/insertRetriveImages", "root",
                "");

    } catch (Exception e) {
        System.out.println("Error Occured While Getting the Connection: - "
                + e);
    }
    return connection;
}

public static void main(String[] args) {
    new Main();
}
}

