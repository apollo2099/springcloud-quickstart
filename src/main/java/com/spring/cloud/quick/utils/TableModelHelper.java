package com.spring.cloud.quick.utils;

import java.util.zip.CRC32;

/**
 * 分表帮助类
 * @author: huixiong
 */
public class TableModelHelper {
	/** mod分表 **/
	public static String TABLE_SPIT_MOD = "mod";
	/** hash分表 **/
	public static String TABLE_SPIT_HASH = "hash";
	/** crc32分表 **/
	public static String TABLE_SPIT_CRC32 = "crc32";
	/** mobile分表 **/
	public static String TABLE_SPIT_MOBILE = "mobile";

	public static int TABLE_NUM = 128;

	/**
	 * 获取表名
	 * 
	 * @param value
	 *            值
	 * @param tableName
	 *            表名
	 * @param tableRule
	 *            分表规则
	 * @param tablenum
	 *            表个数
	 * @return String 分表名[0-(tablenum-1)]
	 */
	public static String getTableName(String value, String tableName, String tableRule, int tablenum) {
		long suffix = 0L;
		if (tableRule.equals(TABLE_SPIT_MOD)) {
			suffix = Long.parseLong(value) % (tablenum == 0 ? 10 : tablenum) ;
		}
		
		if (tableRule.equals(TABLE_SPIT_HASH)) {
			/**Hash算法估计不是这样的**/
			suffix = value.hashCode() % (tablenum == 0 ? 10 : tablenum) ; 
		}
		
		if (tableRule.equals(TABLE_SPIT_CRC32)) {
			CRC32 crc = new CRC32();
			/**将字符串转大写**/
			String upperValue = value.toUpperCase();
			crc.update(upperValue.getBytes());
			suffix = crc.getValue() % (tablenum == 0 ? 10 : tablenum) ;
		}
		
		if (tableRule.equals(TABLE_SPIT_MOBILE)) {
			CRC32 crc = new CRC32();
			/**将字符串转大写**/
			String upperValue = value.toUpperCase();
			crc.update(upperValue.getBytes());			
			long crcValue = crc.getValue();
			long v1 = crcValue % 10;
			long v2 = (crcValue % 100)/10;
			long v3 = (crcValue % 1000)/100;
			long v4 = (crcValue % 10000)/1000;
			suffix = (v1 + v2 + v3 + v4)% 10 ;
		}
		
		tableName =tableName + "_" + suffix;
		return tableName;
	}

		
	/**
	 * 获取购物袋分表表名
	 * @author huixiong 
	 * @param userId 用户编码
	 * @param tableName 表名
	 * @return 分表后的表名
	 */
	public static String getCartInfoTableName(String userId,String tableName) {
		String tableNameback = TableModelHelper.getTableName(userId, tableName, TableModelHelper.TABLE_SPIT_MOD, TableModelHelper.TABLE_NUM);
		return tableNameback;
	}
}