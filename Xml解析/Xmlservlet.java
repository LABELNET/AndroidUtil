package cn.yuan.servlet;

//生成读取数据库生成xml
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yuan.util.DBO;

@SuppressWarnings("serial")
public class Xmlservlet extends HttpServlet {

	private Connection ct;
	private Statement st;
	private ResultSet rs;

	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nameString = "losttable.xml";
		String dir = "C:/apache-tomcat-6.0.41-windows-x86/apache-tomcat-6.0.41";
		try {
			File file = new File(dir, nameString);
			if (!file.isFile()) {

				file.createNewFile();
				ct = new DBO().getConnection();
				st = ct.createStatement();
				rs = st.executeQuery("select * from losttable");
				FileWriter fw = new FileWriter(file);
				fw.write("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
				fw.write("<infos>");
				while (rs.next()) {
					fw.write("<info>");
					fw.write("<a>");
					fw.write(rs.getString(1));
					fw.write("</a>");
					fw.write("<v>");
					fw.write(rs.getString(2));
					fw.write("</v>");
					fw.write("<x>");
					fw.write(rs.getString(3));
					fw.write("</x>");
					fw.write("<x>");
					fw.write(rs.getString(4));
					fw.write("</x>");
					fw.write("<x>");
					fw.write(rs.getString(5));
					fw.write("</x>");
					fw.write("<x>");
					fw.write(rs.getString(6));
					fw.write("</x>");
					fw.write("<x>");
					fw.write(rs.getString(7));
					fw.write("</x>");
					fw.write("</info>");
				}
				fw.write("</infos>");
				fw.flush();
				fw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
