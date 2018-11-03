/**
 * 
 */
package com.wallet.crc;

import java.util.zip.CRC32;

/**
 * @author rahul kumar
 *
 */
public class CRC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		long value = crcFromString("abcd");
		System.out.println(value);

	}

	public static long crcFromString(String string)
	{
		final CRC32 crc32 = new CRC32();
		byte[] byteArray = string.getBytes();
		crc32.update(byteArray);
		return crc32.getValue();
	}
}
