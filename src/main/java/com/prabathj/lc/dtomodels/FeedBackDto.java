package com.prabathj.lc.dtomodels;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FeedBackDto {

	@NotBlank(message="Please enter a Valid Name")
	@Size(min=3,max=15,message="*User Name should have <15,>3 chars")
	private String feedBUser;
	@NotBlank(message="Please enter a Valid header")
	@Size(max=15,message="*Header max size 5 chars")
	private String feedBheader;
	@NotBlank(message="Please enter a Valid message")
	@Size(max=200,message="*Message body max size 200 chars")
	private String feedBbody;
	
	public String getFeedBUser() {
		return feedBUser;
	}
	public void setFeedBUser(String feedBUser) {
		this.feedBUser = feedBUser;
	}
	public String getFeedBheader() {
		return feedBheader;
	}
	public void setFeedBheader(String feedBheader) {
		this.feedBheader = feedBheader;
	}
	public String getFeedBbody() {
		return feedBbody;
	}
	public void setFeedBbody(String feedBbody) {
		this.feedBbody = feedBbody;
	}
	
	
}
