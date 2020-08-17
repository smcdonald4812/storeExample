package com.mcdonald.util;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import com.mcdonald.models.MembershipTiers;
import com.mcdonald.models.STATUS;
import com.mcdonald.models.TIMELENGTH;

public class DataLoaderMemberships {
	List<MembershipTiers> mtList;

	public List<MembershipTiers> getMtList() {
		return loader();
	}
	
	private List<MembershipTiers> loader() {
		List<MembershipTiers> list = new Vector<>();
		//float price, int freeSales, float percentage, timelength length, status status, date timestamp 
		list.add(new MembershipTiers(0.00f,0,.30f,TIMELENGTH.FREE,STATUS.FREE,Calendar.getInstance().getTime()));
		
		list.add(new MembershipTiers(0.00f,10,.25f,TIMELENGTH.TWOWEEK,STATUS.BASIC,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(4.99f,10,.25f,TIMELENGTH.MONTH,STATUS.BASIC,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(13.99f,10,.25f,TIMELENGTH.THREEMONTH,STATUS.BASIC,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(24.99f,10,.25f,TIMELENGTH.SIXMONTH,STATUS.BASIC,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(44.99f,10,.25f,TIMELENGTH.YEAR,STATUS.BASIC,Calendar.getInstance().getTime()));
		
		list.add(new MembershipTiers(0.00f,20,.15f,TIMELENGTH.TWOWEEK,STATUS.PREMIUM,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(9.99f,20,.15f,TIMELENGTH.MONTH,STATUS.PREMIUM,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(24.99f,20,.15f,TIMELENGTH.THREEMONTH,STATUS.PREMIUM,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(49.99f,20,.15f,TIMELENGTH.SIXMONTH,STATUS.PREMIUM,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(99.99f,20,.15f,TIMELENGTH.YEAR,STATUS.PREMIUM,Calendar.getInstance().getTime()));
		
		list.add(new MembershipTiers(0.00f,50,.10f,TIMELENGTH.TWOWEEK,STATUS.PLATINUM,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(19.99f,50,.10f,TIMELENGTH.MONTH,STATUS.PLATINUM,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(49.99f,50,.10f,TIMELENGTH.THREEMONTH,STATUS.PLATINUM,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(99.99f,50,.10f,TIMELENGTH.SIXMONTH,STATUS.PLATINUM,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(179.99f,50,.10f,TIMELENGTH.YEAR,STATUS.PLATINUM,Calendar.getInstance().getTime()));
		
		list.add(new MembershipTiers(99.99f,250,.05f,TIMELENGTH.MONTH,STATUS.BUSINESS_BASIC,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(279.99f,250,.05f,TIMELENGTH.THREEMONTH,STATUS.BUSINESS_BASIC,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(529.99f,250,.05f,TIMELENGTH.SIXMONTH,STATUS.BUSINESS_BASIC,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(899.99f,250,.05f,TIMELENGTH.YEAR,STATUS.BUSINESS_BASIC,Calendar.getInstance().getTime()));
		list.add(new MembershipTiers(1499.99f,250,.05f,TIMELENGTH.THREEYEAR,STATUS.BUSINESS_BASIC,Calendar.getInstance().getTime()));
		return list;
	}
}
