package models;

/**
 * @author Jack Young
 * @date February 07, 2014
 * SWE 645
 * 
 * Class Purpose: The purpose of this class is to contain the two 
 * calculated attributes (mean & standard deviation), which were 
 * specified in the instruction for this HW assignment.
 * 
 */

public class WinningResult {
	
	private double mean;
	private double stdv;
	
	/**
	 * No-Arg Default Constructor
	 */
	public WinningResult() {
		this.mean = 0.0;
		this.stdv = 0.0;
	}
	
	/**
	 * Arg Constructor
	 * @param mean
	 * @param stdv
	 */
	public WinningResult(double mean, double stdv) {
		super();
		this.mean = mean;
		this.stdv = stdv;
	}
	
	/**
	 * @return the mean
	 */
	public double getMean() { return mean; }
	
	/**
	 * @param mean the mean to set
	 */
	public void setMean(double mean) { this.mean = mean; }
	
	/**
	 * @return the stdv
	 */
	public double getStdv() { return stdv; }
	
	/**
	 * @param stdv the stdv to set
	 */
	public void setStdv(double stdv) { this.stdv = stdv; }
	
}
