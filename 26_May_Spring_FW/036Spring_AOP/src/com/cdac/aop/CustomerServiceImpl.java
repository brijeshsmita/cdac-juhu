/**
 * 
 */
package com.cdac.aop;

/**
 *  Sm@authorita B Kumar
 *
 */
public class CustomerServiceImpl implements CustomerService {

	/* (non-Javadoc)
	 * @see com.cdac.aop.CustomerService#withdraw(double)
	 */
	@Override
	public void withdraw(double amount) {
		System.out.println("Withdrawing amount..."+amount);
	}

	@Override
	public void logout() {
		System.out.println("Logout... have a nice day!!");
	}

	@Override
	public void login() throws Exception {	
			throw new Exception(
					"Sorry !! Something went worng while Login!!");
	}

	@Override
	public double checkBalance(int accId) {
		System.out.println("Returning Current Balance for account Id : "
	+accId);
		return 1000.00;
	}
}
