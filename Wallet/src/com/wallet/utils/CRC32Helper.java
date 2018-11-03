/**
 * 
 */
package com.wallet.utils;

import java.util.zip.CRC32;

/**
 * @author rahul kumar
 * 
 */
public class CRC32Helper {

	public static long crc32FromString(String string) {
		final CRC32 crc32 = new CRC32();
		byte[] byteArray = string.getBytes();
		crc32.update(byteArray);
		return crc32.getValue();
	}
}
