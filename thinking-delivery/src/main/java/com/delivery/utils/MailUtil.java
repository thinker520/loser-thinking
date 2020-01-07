package com.delivery.utils;
/**
 *     邮箱生成器
 * @author KINGYE
 *
 */
public class MailUtil {

	enum MailType {
		gmail(1,"Gmail","@gmail.com"),
		yahoo(2,"Gmail","@gmail.com"),
		qq(3,"Gmail","@gmail.com"),
		_163(4,"Gmail","@gmail.com");
		
		public Integer index;
		public String name;
		public String suffix;
		
		private MailType(Integer index, String name, String suffix) {
			this.index = index;
			this.name = name;
			this.suffix = suffix;
		}
		
		public Integer getIndex() {
			return index;
		}
		public void setIndex(Integer index) {
			this.index = index;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSuffix() {
			return suffix;
		}
		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
	}
	
	
	
}
