/**
 * 
 */
package com.cdac.spring.di;

/**
 * @author Smita B Kumar
 *
 */
public class MessageService implements IMessageService {
	private String name;
	public MessageService() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String sendMessage() {
		// TODO Auto-generated method stub
		return "Welcome to Msg!"+
				name+ " , Hello from Spring!! ";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
