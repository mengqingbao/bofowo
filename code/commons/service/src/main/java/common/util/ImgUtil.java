package common.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import net.coobird.thumbnailator.Thumbnails;

/**
 * 
* @ClassName: ImgUtil
* @Description: TODO(图片操作工具类)
* @author 陈勋
* @date 2015年6月4日 上午2:41:09
*
 */

public class ImgUtil {
	private  static Logger log = LoggerFactory.getLogger(ImgUtil.class);
	/**
	 * 
	* @Title: changeImg
	* @Description: TODO(按固定尺寸缩放图片)
	* @param @param file1  原文件
	* @param @param width
	* @param @param height
	* @param @param fiel2  结果文件
	* @param @throws IOException    设定文件
	* @return void    返回类型
	* @date 2015年6月4日
	* @author 陈勋
	* @throws
	 */
	public static void changeImg(String file1,int width,int height,String fiel2) throws IOException{		
		 Thumbnails.of(file1).size(width, height).keepAspectRatio(false).toFile(fiel2);

	}
	 
	/**
	 * 
	* @Title: changeImg
	* @Description: TODO(按固定尺寸缩放图片)
	* @param @param in
	* @param @param width
	* @param @param height
	* @param @param out
	* @param @throws IOException    设定文件
	* @return void    返回类型
	* @date 2015年6月4日
	* @author 陈勋
	* @throws
	 */
	public static void changeImg(InputStream in,int width,int height,OutputStream out) throws IOException{		
		 Thumbnails.of(in).size(width, height).keepAspectRatio(false).toOutputStream(out);
	}
	
	
	public static List<String> getImgStr(String htmlStr) {
		String img = "";      //wrwewrwe111<img src="data:werjweoruwerjo1slejwlrjwelrj">   //base64
		Pattern p_image;
		Matcher m_image;
		List<String> pics = new ArrayList<String>();
		String regEx_img = "]*?>";
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr);
		while (m_image.find()) {
		img = img + "," + m_image.group();
		Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
		while (m.find()) {
		pics.add(m.group(1));
		}
		}
		return pics;
		}
	

	  public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	        byte[] data = null;
	        
	        // 读取图片字节数组
	        try {
	            InputStream in = new FileInputStream(imgFilePath);
	            data = new byte[in.available()];
	            in.read(data);
	            in.close();
	        } catch (IOException e) {
	            log.error(e.getMessage());
	        }
	        
	        // 对字节数组Base64编码
	        BASE64Encoder encoder = new BASE64Encoder();
	        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	    }

	    public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
	        if (imgStr == null) // 图像数据为空
	            return false;
	        BASE64Decoder decoder = new BASE64Decoder();
	        try {
	            // Base64解码
	            byte[] bytes = decoder.decodeBuffer(imgStr);
	            for (int i = 0; i < bytes.length; ++i) {
	                if (bytes[i] < 0) {// 调整异常数据
	                    bytes[i] += 256;
	                }
	            }
	            // 生成jpeg图片
	            OutputStream out = new FileOutputStream(imgFilePath);
	            out.write(bytes);
	            out.flush();
	            out.close();
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	
  
	    
	    
	    /** 
	     * 在源图片上设置水印文字 
	     * @param srcImagePath  源图片路径 
	     * @param alpha 透明度（0<alpha<1） 
	     * @param font  字体（例如：宋体） 
	     * @param fontStyle     字体格式(例如：普通样式--Font.PLAIN、粗体--Font.BOLD ) 
	     * @param fontSize  字体大小 
	     * @param color 字体颜色(例如：黑色--Color.BLACK) 
	     * @param inputWords        输入显示在图片上的文字 
	     * @param x     文字显示起始的x坐标 
	     * @param y     文字显示起始的y坐标 
	     * @param imageFormat   写入图片格式（png/jpg等） 
	     * @param toPath    写入图片路径 
	     * @throws IOException  
	     */  
	    public  static  void alphaWords2Image(String srcImagePath,float alpha,  
	            String font,int fontStyle,int fontSize,Color color,  
	            String inputWords,int x,int y,String imageFormat,String toPath) {  
	        FileOutputStream fos=null;  
	        try {  
	            BufferedImage image = ImageIO.read(new File(srcImagePath));  
	            //创建java2D对象   
	            Graphics2D g2d=image.createGraphics();  
	            //用源图像填充背景   
	            g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null, null);  
	            //设置透明度   
	            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);  
	            g2d.setComposite(ac);  
	            //设置文字字体名称、样式、大小   
	            
	            g2d.setFont(new Font(font, fontStyle, fontSize));  
	            g2d.setColor(color);//设置字体颜色   
	            g2d.drawString(inputWords, x, y); //输入水印文字及其起始x、y坐标   
	            g2d.dispose();  
	            fos=new FileOutputStream(toPath);  
	            ImageIO.write(image, imageFormat, fos);  
	        } catch (Exception e) {  
	           e.printStackTrace();  
	        }finally{  
	            if(fos!=null){  
	                try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
	            }  
	        }  
	    }     
	    
	    
	    
    
    /** 
     *  
     * @param souchFilePath 
     *            ：源图片路径 
     * @param targetFilePath 
     *            ：生成后的目标图片路径 
     * @param markContent 
     *            :要加的文字 
     * @param markContentColor 
     *            :文字颜色 
     * @param qualNum 
     *            :质量数字 
     * @param fontType 
     *            :字体类型 
     * @param fontSize 
     *            :字体大小 
     * @return 
     */  
    public static void createMark(String souchFilePath, String targetFilePath,  
                              String markContent, Color markContentColor, float qualNum,  
                              String fontType, int fontSize, int w, int h,float scaleSize) {  
                      /* 构建要处理的源图片 */  
                      ImageIcon imageIcon = new ImageIcon(souchFilePath);  
                      /* 获取要处理的图片 */  
                      Image image = imageIcon.getImage();  
                      // Image可以获得图片的属性信息  
                      int width = image.getWidth(null);  
                      int height = image.getHeight(null);  
                      // 为画出与源图片的相同大小的图片（可以自己定义）  
                      BufferedImage bImage = new BufferedImage(width, height,  
                                      BufferedImage.TYPE_INT_RGB);  
                      // 构建2D画笔  
                      Graphics2D g = bImage.createGraphics();  
                      /* 设置2D画笔的画出的文字颜色 */  
                      g.setColor(markContentColor);  
                      /* 设置2D画笔的画出的文字背景色 */  
                      g.setBackground(Color.white);  
                                          
                      /* 画出图片 */  
                      g.drawImage(image, 0, 0, null);  
                      /* --------对要显示的文字进行处理-------------- */  
                      AttributedString ats = new AttributedString(markContent);  
                      
                     // BaseFont bfChinese = BaseFont.createFont("/home/lyun/document/font/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
                    //  Font font = new Font(bfChinese, 12, Font.NORMAL);  
                      
                      Font font = new Font(fontType, Font.PLAIN , fontSize);  
                      g.setFont(font);  
                     /* 消除java.awt.Font字体的锯齿 */  
                      g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
                                                RenderingHints.VALUE_ANTIALIAS_ON);  
                      /* 消除java.awt.Font字体的锯齿 */   
                       font = g.getFont().deriveFont(30.0f);  
                      ats.addAttribute(TextAttribute.FONT, font, 0, markContent.length());  
                    
                      AttributedCharacterIterator iter = ats.getIterator();  
                      /* 添加水印的文字和设置水印文字出现的内容 ----位置 */  
                      AffineTransform trans = new AffineTransform();
                      trans.scale(scaleSize, scaleSize) ;  
                      g.setTransform(trans) ; 
                      g.drawString(iter, width - w, height - h);  
                      /* --------对要显示的文字进行处理--------------  */  
                      g.dispose();// 画笔结束  
                      FileOutputStream out=null;
                      try {                 	  
                                   // 输出 文件 到指定的路径  
                                   out = new FileOutputStream(targetFilePath); 
                                   /*
                                   JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
                                    JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bImage);  
                                    param.setQuality(qualNum, true);  
                                    encoder.encode(bImage, param);  
                                    */
                                   ImageIO.write(bImage, "jpg", out);
                                     
                      } catch (Exception e) {  
                                    e.printStackTrace();  
                      }  finally{
                    	 if(out!=null){
                    		 try {
								out.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    	 }
                      }
    }  

    

    public static void createDefaultSignature(String signature,String systemSignatrue,String userName ,String code ){
    //	signature=signature.replaceAll("\\", "/");
       String a=systemSignatrue.substring(systemSignatrue.lastIndexOf("/")+1, systemSignatrue.lastIndexOf("."));
       String b=a+"_temp1";
       String c=a+"_temp2";
       
       String temp1=systemSignatrue.replaceAll(a, b);
       String temp2=systemSignatrue.replaceAll(a, c);
       
   //    alphaWords2Image(signature, 1,"微软雅黑" , Font.PLAIN, 5,new Color(0x414f8a) , userName, 110, 20, "jpg", systemSignatrue);
       log.info("createDefaultSignature:"+userName+"*****1");
    	createMark(signature, temp1,  
    			userName,new Color(0x414f8a), 1,"微软雅黑", 5, 110, 20,0.51f
                );
    	
    	  log.info("createDefaultSignature:"+userName+"*****2");
    	createMark(temp1,temp2 ,  
    			DateUtil.toSimpleDateString(new Date()),new Color(0x414f8a), 1,"微软雅黑", 5, 100, -58,0.35f
                );  
    	log.info("createDefaultSignature:"+userName+"*****3");	
    	createMark(temp2,systemSignatrue ,code,new Color(0x808080), 1,"微软雅黑", 5, 50, -120,0.35f
                );  
    	
    	convert(systemSignatrue);
    	systemSignatrue=systemSignatrue.substring(0, systemSignatrue.lastIndexOf('.'))+".png";
     
    	

    }
    public static void createNewSignature(String signature ,String newSignature){
        	createMark(signature,newSignature ,  
        			DateUtil.toSimpleDateString(new Date()),new Color(0x414f8a), 1,"微软雅黑", 5, 100, -58,0.35f
                    );  
        	convert(newSignature);
        	newSignature=newSignature.substring(0, newSignature.lastIndexOf('.'))+".png";
        }
    
    
    public static void convert(String path) {  
        // TODO Auto-generated constructor stub  
    	if(StringUtil.isEmpty(path)){
    		log.warn("path  is   null..end!!");
    		return ;
    	}
    	   BufferedImage image =null;
        try {  
             image = ImageIO.read(new File(path));  
             log.info("convert--image: "+path);
            if(image==null){
            	return ;
            }
            ImageIcon imageIcon = new ImageIcon(image);  
            BufferedImage bufferedImage = new BufferedImage(  
                    imageIcon.getIconWidth(), imageIcon.getIconHeight(),  
                    BufferedImage.TYPE_4BYTE_ABGR);  
            Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();  
            g2D.drawImage(imageIcon.getImage(), 0, 0,  
                    imageIcon.getImageObserver());  
            int alpha = 0;  
            for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage  
                    .getHeight(); j1++) {  
                for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage  
                        .getWidth(); j2++) {  
                    int rgb = bufferedImage.getRGB(j2, j1);  
                    if (colorInRange(rgb))  
                        alpha = 50;    //0表示全透明
                    else  
                        alpha = 255;  
                    rgb = (alpha << 24) | (rgb & 0x00ffffff);  
                    bufferedImage.setRGB(j2, j1, rgb);  
                }  
            }  
            g2D.drawImage(bufferedImage, 0, 0, imageIcon.getImageObserver());  
            // 生成图片为PNG  
            String outFile = path.substring(0, path.lastIndexOf("."));  
            ImageIO.write(bufferedImage, "png", new File(outFile + ".png"));  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  finally{
        	if(image!=null){
        		image.flush();
        	}
        }
    }  
  
    public static boolean colorInRange(int color) {  
        int red = (color & 0xff0000) >> 16;  
        int green = (color & 0x00ff00) >> 8;  
        int blue = (color & 0x0000ff);  
        if (red >= color_range && green >= color_range && blue >= color_range)  
            return true;  
        return false;  
    }  
  
    public static int color_range = 210;  
    public static Pattern pattern = Pattern.compile("[0-9]*");  
  
    public static boolean isNo(String str) {  
        return pattern.matcher(str).matches();  
    }  
    
    
	
    public static void main(String[] args) {
    	/*
    	createMark("d:\\Signatrue.png", "d:\\systemSignatrue.jpg",  
                "陈勋", Color.RED, 1, "微软雅黑", 14, 50, 30 
                ); 
                d:\\signature.jpeg
                 
                */
    	convert("d:/systemSignatrue_t1.jpg");
    	
    	
    //	createDefaultSignature("D:/temp/signature.png","d:\\systemSignatrue.jpg","屈志刚3","LY1006123");
    	
    	
	}
	
    
    
	
	
	
	

}
