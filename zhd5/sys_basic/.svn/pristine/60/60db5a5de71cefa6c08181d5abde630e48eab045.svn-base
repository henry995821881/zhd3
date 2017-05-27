package com.xyscm.sys.basic.cas.controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;


/************************************************
 * Copyright (c)  by gmkjsoft
 * All right reserved.
 * Create Date: 2013-8-29
 * Create Author: liuzhe
 * File Name:  验证码 
 * Last version:  1.0
 * Change Log:
**************************************************/	
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String THECODE = "validateCode";
	/*验证码图片的宽度*/
	private int width = 70;
	/*验证码图片的高度*/
	private int height = 30;
	/*验证码字符个数*/
	private int codeCount = 4;
	/*显示字符*/
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
			'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String _heightStr = request.getParameter("height");
    	String _widthStr = request.getParameter("width");
    	if(StringUtils.isNotBlank(_heightStr)){
    		height = Integer.valueOf(_heightStr);
    	}else{
    		height = 30;
    	}
    	if(StringUtils.isNotBlank(_widthStr)){
    		width = Integer.valueOf(_widthStr);
    	}else{
    		width = 70;
    	}
    	/*创建一个图像对象*/
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        /*得到图像的环境对象*/
        Graphics g = image.createGraphics();
        Random random = new Random();
        /*用随机颜色填充图像背景*/
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        /*设置字体,下面准备画随机数*/
        g.setFont(new Font("Times New Roman", Font.HANGING_BASELINE, 24));
        /*生成12条干扰线*/
        g.setColor(getRandColor(160,200)); 
        for (int k = 0; k < 12; k++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(8);
            int yl = random.nextInt(8);
            g.drawLine(x, y, x + xl, y + yl);
        }
        /*随机数字符串*/
        String sRand = "";
        for (int i = 0; i < codeCount; i++) {/*生成codeCount个数字字符*/
            String rand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            sRand += rand;
            /*生成随机颜色*/
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            /*将随机数字画在图像上*/
			g.drawString(rand, i*(width/codeCount), height - 4);
        }
        /*将生成的随机数字字符串写入Session*/
        request.getSession().setAttribute(THECODE, sRand);
        /*使图像生效*/
        g.dispose();
        /*禁止图像页面缓存*/
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        /*图像输出到Servlet输出流中*/
        ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(image, "jpeg", sos);
		sos.flush();
		sos.close();
    }
    
    private Color getRandColor(int fc, int bc) {
        Random rand = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + rand.nextInt(bc - fc);
        int g = fc + rand.nextInt(bc - fc);
        int b = fc + rand.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}