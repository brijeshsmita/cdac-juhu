/**
 * 
 */
package com.cdac.spring;

/**
 * @author Smita B Kumar
 *
 */
public class WatsAppMsgService implements IMessageService {
	private String name;
	public WatsAppMsgService() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String sendMessage(String name) {
		// TODO Auto-generated method stub
		return "Welcome to WatsApp Msg!"+
				name+ " , Hello from Spring!! ";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
