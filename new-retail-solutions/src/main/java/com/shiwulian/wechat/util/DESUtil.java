package com.shiwulian.wechat.util;

import java.security.SecureRandom;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;

/**
 * DES加密
 */
public class DESUtil {
	// 测试一下
	public static void main(String args[]) {
//		// 待加密内容
//		String str = "587ca48e88405227d0c14513";//取user
//		// 密码，长度要是8的倍数
//		String password = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901296341167";
//		System.out.println(password.length());
//		byte[] result = DESUtil.encrypt(str.getBytes(), password);
//		String resultStr = bytesToHex(result);
//		System.out.println("加密后：" + resultStr + " byte " + result);
//		// 直接将如上内容解密
//		try {
//			byte[] decryResult = DESUtil.decrypt(hexToBytes(resultStr), password);
//			System.out.println("解密后：" + new String(decryResult));
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
	}
	/**
	 * 解析加密后的bytes
	 */
    public static byte[] hexToBytes(String hexString) {   
        if (hexString == null || hexString.equals("")) {   
            return null;   
        }   

        int length = hexString.length() / 2;   
        char[] hexChars = hexString.toCharArray();   
        byte[] bytes = new byte[length];   
        String hexDigits = "0123456789abcdef";
        for (int i = 0; i < length; i++) {   
            int pos = i * 2; // 两个字符对应一个byte
            int h = hexDigits.indexOf(hexChars[pos]) << 4; // 注1
            int l = hexDigits.indexOf(hexChars[pos + 1]); // 注2
            if(h == -1 || l == -1) { // 非16进制字符
                return null;
            }
            bytes[i] = (byte) (h | l);   
        }   
        return bytes;   
    }
    /**
     * 加密后的bytes转String
     */
    public static String bytesToHex(byte[] src){   
        if (src == null || src.length <= 0) {   
            return null;   
        } 
        StringBuilder stringBuilder = new StringBuilder("");         
        for (int i = 0; i < src.length; i++) {   
            // 之所以用byte和0xff相与，是因为int是32位，与0xff相与后就舍弃前面的24位，只保留后8位
            String str = Integer.toHexString(src[i] & 0xff); 
            if (str.length() < 2) { // 不足两位要补0
                stringBuilder.append(0);   
            }   
            stringBuilder.append(str);   
        }   
        return stringBuilder.toString();   
    } 

	/**
	 * 加密
	 */
	public static byte[] encrypt(byte[] datasource, String password) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 */
	public static byte[] decrypt(byte[] src, String password) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}
}