package org.xiaxiang.bean;

import com.example.fragmentproject.R;

public class MessageBean {
	private int PhotoDrawableId;
	private String MessageName;
	private String MessageContent;
	private String MessageTime;
	private int MessageSex;
	
	public MessageBean(){
		
	}
	
	public MessageBean(int photoDrawableId, String messageName,
			String messageContent, String messageTime, int messagesex) {
		super();
		PhotoDrawableId = photoDrawableId;
		MessageName = messageName;
		MessageContent = messageContent;
		MessageTime = messageTime;
		MessageSex = messagesex;
	}

	public int getPhotoDrawableId() {
		return PhotoDrawableId;
	}
	public void setPhotoDrawableId(int mPhotoDrawableId) {
		this.PhotoDrawableId = mPhotoDrawableId;
	}
	public String getMessageName() {
		return MessageName;
	}
	public void setMessageName(String messageName) {
		MessageName = messageName;
	}
	public String getMessageContent() {
		return MessageContent;
	}
	public void setMessageContent(String messageContent) {
		MessageContent = messageContent;
	}
	public String getMessageTime() {
		return MessageTime;
	}
	public void setMessageTime(String messageTime) {
		MessageTime = messageTime;
	}
	
	public void setMessageSex(int messagesex) {
		MessageSex = messagesex;
	}
	
	public int getSexDrawableId() {
		if (MessageSex == 0)
		{
			return R.drawable.woman;
		}
		else
		{
			return R.drawable.man;
		}
	}
	@Override
	public String toString() {
		return "MessageBean [mPhotoDrawableId=" + PhotoDrawableId
				+ ", MessageName=" + MessageName + ", MessageContent="
				+ MessageContent + ", MessageTime=" + MessageTime + "]";
	}
}
