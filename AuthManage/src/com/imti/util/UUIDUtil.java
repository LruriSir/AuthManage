package com.imti.util;

import java.util.UUID;

/**@�ļ���: UUIDUtil.java
 * @�๦��˵��: ����UUID�Զ�����user_code
 * @����: BaiYunZhong
 * @Email: 2537975653@qq.com
 * @����: 2021��1��6������10:17:24
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: BaiYunZhong</li> 
 * 	 <li>����: 2021��1��6������10:17:24</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class UUIDUtil {
	public static String getUUID() {
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
}
