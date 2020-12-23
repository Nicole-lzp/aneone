package com.cn.one.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 验证码
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/utils")
public class VerificationCode {

	@RequestMapping(value="/codeImage")
	public static void Code(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int width = 200; // 宽
		int height = 50; // 高
		// 1、创建图片
		BufferedImage bfi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		String sb = createImage(width, height, bfi);
		System.out.println("验证码：   "+sb);
		HttpSession session = request.getSession();
		session.setAttribute("VerificationCode", sb);
		ImageIO.write(bfi, "JPG", response.getOutputStream());
	}
	
	
	public static String createImage(int width, int height, BufferedImage bfi) {
		Graphics graphics = bfi.getGraphics(); //获取图片对象
		graphics.setColor(new Color(255, 228, 196));
		graphics.fillRect(0, 0, width, height); //填充
		graphics.setFont(new Font("微软雅黑", Font.BOLD, 40)); //设置字体(String 字体,int 风格,int 字号)
		
		// 2、填充验证码
		char[] yzm = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".toCharArray(); // 验证码取值范围
		Random random = new Random(); //随机数
		int index; // 验证码数组下标
		StringBuffer sb = new StringBuffer(); // 用来存放验证码,方便检验,使用StringBuffer相对于StringBuild线程更安全
		// 生成验证码
		for(int i=0;i<4;i++) {
			index = random.nextInt(yzm.length);
			graphics.setColor(getRandomColor());
			sb.append(yzm[index]); //存入验证码
			graphics.drawString(yzm[index]+"", i*48, 40); // (值，x坐标点，y坐标点)
		}
		
		// 3、干扰线
		for(int i=0;i<10;i++) {
			graphics.setColor(getRandomColor());
			graphics.drawLine(random.nextInt(width), 
					random.nextInt(height), 
					random.nextInt(width), 
					random.nextInt(height));
		}
		
		// 4、噪点
		for(int i=0;i<30;i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			graphics.setColor(getRandomColor());
			graphics.fillRect(x, y, 2, 2);
		}
		return sb.toString();
	}
	
	// 随机颜色
	public static Color getRandomColor() {
		Random r = new Random();
		return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	
	
}
