import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DictionaryGUI extends JFrame {
    private JTextField txtWord;
    private JTextArea txtResult;
    private JButton btnQuery;
    private static final String HTML_PATH = "result.html";

    public DictionaryGUI() {
        setTitle("英汉词典查询");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        // 上方：输入与按钮
        JPanel top = new JPanel(new BorderLayout(5,5));
        txtWord = new JTextField();
        btnQuery = new JButton("查询");
        top.add(new JLabel("请输入英文单词："), BorderLayout.WEST);
        top.add(txtWord, BorderLayout.CENTER);
        top.add(btnQuery, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        // 中间：结果展示
        txtResult = new JTextArea();
        txtResult.setEditable(false);
        add(new JScrollPane(txtResult), BorderLayout.CENTER);

        // 点击事件
        btnQuery.addActionListener(e -> onQuery());
    }

    private void onQuery() {
        String word = txtWord.getText().trim();
        if (word.isEmpty()) {
            JOptionPane.showMessageDialog(this, "单词不能为空！");
            return;
        }

        String meaning = queryDatabase(word);
        if (meaning != null) {
            String output = String.format("“%s” 的中文释义是：%s", word, meaning);
            txtResult.setText(output);
            writeHtml(word, meaning);
            JOptionPane.showMessageDialog(this, "查询成功，结果已写入 " + HTML_PATH);
        } else {
            txtResult.setText("未查到单词 “" + word + "” 的释义。");
        }
    }

    private String queryDatabase(String word) {
        String url = "jdbc:mysql://rm-bp13z1291yal195860o.mysql.rds.aliyuncs.com:3306/book?useSSL=false&serverTimezone=GMT";
        String user = "root";
        String pass = "Giti#73920";
        String meaning = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(url, user, pass);
                 PreparedStatement ps = con.prepareStatement("SELECT cname FROM dic WHERE ename = ?")) {
                ps.setString(1, word);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        meaning = rs.getString("cname");
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            showError("JDBC Driver 加载失败");
        } catch (SQLException ex) {
            showError("数据库错误：" + ex.getMessage());
        }
        return meaning;
    }

    private void writeHtml(String word, String meaning) {
        String html = "<!DOCTYPE html>\n"
                + "<html lang=\"zh-CN\">\n"
                + "<head><meta charset=\"UTF-8\"><title>查询结果</title></head>\n"
                + "<body>\n"
                + "<h1>英汉词典查询结果</h1>\n"
                + "<p>单词：<strong>" + word + "</strong></p>\n"
                + "<p>释义：<em>" + meaning + "</em></p>\n"
                + "</body>\n"
                + "</html>";

        try (FileWriter writer = new FileWriter(HTML_PATH)) {
            writer.write(html);
        } catch (IOException ex) {
            showError("写入 HTML 文件失败：" + ex.getMessage());
        }
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "错误", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DictionaryGUI gui = new DictionaryGUI();
            gui.setVisible(true);
        });
    }
}
