package com.dao;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;

import com.entity.Original_book_enti;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class for_demo {
	
	private Connection conn;
	
	
	
	
	
	public for_demo(Connection conn) {
		super();
		this.conn = conn;
	}





	public boolean generate_demo_QR() {
		
			boolean f = false;
		
			try {
				
				String content = "3028452";
				
				
				String path_of_qr = "G:\\Library Mgnt System\\QR Code\\"+content+".jpg";
				
				File file = new File(path_of_qr);
				
				BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300);
				int maxwidth = bitMatrix.getWidth();
				
				//MatrixToImageWriter.writeToPath(bitMatrix,"jpg", Paths.get("G:\\Library Mgnt System\\QR Code\\"+content+".jpg"));
							
				BufferedImage buff = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
				buff.createGraphics();
				
				
				Graphics2D g2d = (Graphics2D) buff.getGraphics();
				
				g2d.setColor(Color.WHITE);
				g2d.fillRect(0, 0, maxwidth, maxwidth);
				g2d.setColor(Color.BLACK);
				
				for(int i = 0; i< maxwidth; i++) {
					for(int j = 0; j<maxwidth; j++) {
						if(bitMatrix.get(i, j)) {
							g2d.fillRect(i, j, 1, 1);
						}
					}
				}
		
				
			
				ImageIO.write(buff, "jpg", file);
				
				System.out.println("Qr code Generate Succesful");
				f=true;
						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			return f;
	}

}
