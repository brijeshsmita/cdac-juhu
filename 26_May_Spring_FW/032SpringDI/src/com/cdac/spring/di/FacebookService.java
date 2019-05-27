/**
 * 
 */
package com.cdac.spring.di;

/**
 * @author Smita B Kumar
 *
 */
public class FacebookService implements IFacebookService {
//object of another class as property of this class (has-a)
	private IMessageService messageService;
	//Spring DI says to get the object rather than creating it
	//it can be acheived in two way -> setter or constructor
	//=new MessageService();
	public FacebookService() {
		// TODO Auto-generated constructor stub
	}

	public FacebookService(IMessageService messageService) {
		super();
		this.messageService = messageService;
	}

	/* (non-Javadoc)
	 * @see com.cdac.spring.di.IFacebookService#writePost(java.lang.String)
	 */
	@Override
	public void writePost(String postUpdates) {
		System.out.println(" Writing post");
		System.out.println(messageService.sendMessage());
	}

	public IMessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

}
