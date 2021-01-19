package com.imti.util;

import java.util.UUID;

/**@文件名: UUIDUtil.java
 * @类功能说明: 利用UUID自动生成user_code
 * @作者: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @日期: 2021年1月6日下午10:17:24
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: BaiYunZhong</li> 
 * 	 <li>日期: 2021年1月6日下午10:17:24</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class UUIDUtil {
	public static String getUUID() {
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
}
